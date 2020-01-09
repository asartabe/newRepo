package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.Commons.SearchRefinementType;
import com.eBay.NativeApp.Commons.SearchRefinementType.BuyingFormat;
import com.eBay.NativeApp.Commons.SearchRefinementType.Condition;
import com.eBay.NativeApp.Commons.SearchRefinementType.DeliveryOptions;
import com.eBay.NativeApp.Commons.SearchRefinementType.ItemLocation;
import com.eBay.NativeApp.Commons.SearchRefinementType.Sort;
import com.eBay.NativeApp.Commons.SearchRefinementType.View;
import com.eBay.NativeApp.Commons.SearchRefinementType.eGD;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.SRPHeaderComponentLocators;
import com.eBay.NativeApp.Locators.SRPRefinePanelLocators;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;

public class SRPHeaderComponent extends SRPHeaderComponentLocators{

	public SRPHeaderComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * openRefinePanel - TRUE if you wish to have Refine Panel open already, else FALSE
	 */
	public SRPRefinePanel getRefinementPanel(boolean openRefinePanel){
		return new SRPRefinePanel(driver, openRefinePanel);
	}
	private static boolean sortAbsent = false;
	public SRPHeaderComponent sortBy(Sort sort){
		if(sortAbsent || actions.element().notPresent(SORT_BTN, 5)){ 
			actions.element().click().by(FILTER_BTN);
			sortAbsent = true;
		}
		else actions.element().click().by(SORT_BTN); 
		actions.element().click().by(By.xpath(sort.getLocator()));
		
		/*if(actions.element().present().now(new SRPRefinePanel(driver, false).SAVE_REFINEMENTS))
			actions.element().click().by(new SRPRefinePanel(driver, false).SAVE_REFINEMENTS);*/
		
		return this;
	}
	
	private SRPHeaderComponent saveSrchFollow(String customName, boolean emailAlerts, boolean phoneAlerts){
		actions.element().textBox().clearAndSendKeys(FOLLOW_PANEL_NAME, customName);
		if(emailAlerts && actions.element().get().text(FOLLOW_PANEL_EMAILALERT, "").contentEquals("OFF"))
			actions.element().click().by(FOLLOW_PANEL_EMAILALERT);
		if(phoneAlerts && actions.element().get().text(FOLLOW_PANEL_PHONEALERT, "").contentEquals("OFF"))
			actions.element().click().by(FOLLOW_PANEL_PHONEALERT);
		
		actions.element().click().by(SAVE_OK);
		
		return this;
	}
	public SRPHeaderComponent clickToFollowSearch(String customName, boolean emailAlerts, boolean phoneAlerts){
		if(actions.element().present().now(FOLLOW_BTN)){
			actions.element().click().by(FOLLOW_BTN);
			this.saveSrchFollow(customName, emailAlerts, phoneAlerts);
		}
		return this;
	}
	
	public SRPHeaderComponent justClickFollowSearch(){
		if(actions.element().present().now(FOLLOW_BTN)){
			actions.element().click().by(FOLLOW_BTN);
		}
		return this;
	}
	
	public SRPHeaderComponent clickFilterBtn(){
		actions.element().click().by(FILTER_BTN);
		return this;
	}
	
	public class SRPRefinePanel extends SRPRefinePanelLocators{
		protected SRPRefinePanel(WebDriver driver, boolean flag) {
			super(driver);
			if(flag){
				if(actions.element().present().byPolling(SAVE_QUICKTIP))
					actions.element().click().by(SAVE_QUICKTIP);
				clickFilterBtn();
				clickShowMore();
			}
		}
		
		private SRPRefinePanel clickThisElement(By by){
			if(CustomWaitUtils.waitForElement(by))
				actions.element().click().by(by);
			else
				Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
				
			return this;
		}
		
		/*private SRPRefinePanel clickFilterMenu(){
			this.clickThisElement(FILTER_BTN);
			return this;
		}*/
		
		public SRPRefinePanel clickShowMore(){
			CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, SHOW_MORE);
			if(actions.element().get().text(SHOW_MORE, "").equalsIgnoreCase("show more"))
				this.clickThisElement(SHOW_MORE);
			CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 5, ScrollDirection.UP);
			return this;
		}
		
		public SRPRefinePanel clickShowLess(){
			CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, SHOW_MORE);
			if(actions.element().get().text(SHOW_MORE, "").equalsIgnoreCase("show less"))
				this.clickThisElement(SHOW_MORE);
			CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 5, ScrollDirection.UP);
			return this;
		}
		
		public SRPRefinePanel changeView(View viewType){
			if(viewType.equals(View.LIST))
				this.clickThisElement(VIEW_ASLIST);
			else
				this.clickThisElement(VIEW_ASGRID);
			
			return this;
		}
		
		public SRPRefinePanel addeGDOptions(eGD egd) {
			this.clickThisElement(GUARANTEED_DELIVERY)
			.clickThisElement(By.xpath(egd.getLocator()))
			.clickThisElement(BACK_TO_REFINEPANEL);
			return this;
			
		}
		
		
		
		public SRPRefinePanel openBuyingFormatMenu(){
			this.clickThisElement(BUYINGFORMAT_MENU);
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements
		 */
		public SRPRefinePanel addBuyingFormat(BuyingFormat format){
			this.clickThisElement(BUYINGFORMAT_MENU)
				.clickThisElement(By.xpath(format.getLocator()))
				.clickThisElement(BACK_TO_REFINEPANEL);
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements
		 */
		public SRPRefinePanel addSort(Sort sort){
			this.clickThisElement(SORT_BY_MENU)
				.clickThisElement(By.xpath(sort.getLocator()))
				.clickThisElement(BACK_TO_REFINEPANEL);
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements
		 */
		public SRPRefinePanel addCondition(Condition condition){
			this.clickThisElement(ITEMCONDITION_MENU)
				.clickThisElement(By.xpath(condition.getLocator()))
				.clickThisElement(BACK_TO_REFINEPANEL);
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements
		 */
		public SRPRefinePanel addDeliveryOptions(DeliveryOptions deliveryOpts){
			this.clickThisElement(DELIVERYOPTS_MENU)
				.clickThisElement(By.xpath(deliveryOpts.getLocator()))
				.clickThisElement(BACK_TO_REFINEPANEL);
			return this;
		}
		
		public SRPRefinePanel openItemLocationMenu(){
			this.clickThisElement(ITEMLOCATION_MENU);
			return this;
		}
		
		public SRPRefinePanel addItemLocationOptions(ItemLocation locationOpts){
			this.clickThisElement(ITEMLOCATION_MENU)
				.clickThisElement(By.xpath(locationOpts.getLocator()))
				.clickThisElement(BACK_TO_REFINEPANEL);
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements
		 */
		public SRPRefinePanel addPriceRange(Double minPrice, Double maxPrice){
			this.clickThisElement(PRICERANGE_MENU)
				.clickThisElement(PRICE_SET_RANGE);
			actions.element().textBox().clearAndSendKeys(PRICE_MINVAL, Double.toString(minPrice));
			actions.element().textBox().clearAndSendKeys(PRICE_MAXVAL, Double.toString(maxPrice));
			this.clickThisElement(PRICE_APPLY)
				.clickThisElement(BACK_TO_REFINEPANEL);
			
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements
		 */
		public SRPRefinePanel completedItems(boolean enable){
			if((enable && actions.element().get().text(COMPLETEDITEMS_SWITCH, "").contains("OFF")) || 
					(!enable && actions.element().get().text(COMPLETEDITEMS_SWITCH, "").contains("ON")))
				this.clickThisElement(COMPLETEDITEMS_SWITCH);
			/*else if(!enable && actions.element().get().text(COMPLETEDITEMS_SWITCH, "").contains("ON"))
				this.clickThisElement(COMPLETEDITEMS_SWITCH);*/
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements
		 */
		public SRPRefinePanel soldItems(boolean enable){
			if((enable && actions.element().get().text(SOLDITEMS_SWITCH, "").contains("OFF")) || 
					(!enable && actions.element().get().text(SOLDITEMS_SWITCH, "").contains("ON")))
				this.clickThisElement(SOLDITEMS_SWITCH);
			/*else if(!enable && actions.element().get().text(COMPLETEDITEMS_SWITCH, "").contains("ON"))
				this.clickThisElement(COMPLETEDITEMS_SWITCH);*/
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements
		 */
		public SRPRefinePanel srchInDescription(boolean enable){
			if((enable && actions.element().get().text(SRCH_IN_DESC_SWITCH, "").contains("OFF")) || 
					(!enable && actions.element().get().text(SRCH_IN_DESC_SWITCH, "").contains("ON")))
				this.clickThisElement(SRCH_IN_DESC_SWITCH);
			/*else if(!enable && actions.element().get().text(COMPLETEDITEMS_SWITCH, "").contains("ON"))
				this.clickThisElement(COMPLETEDITEMS_SWITCH);*/
			return this;
		}
		
		public SRPRefinePanel saveRefinements(){
			this.clickThisElement(SAVE_REFINEMENTS);
			return this;
		}
		
		/**
		 * Make call to <b>saveRefinements</b> to save your refinements/changes
		 */
		public SRPRefinePanel resetRefinements(){
			CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, RESET_REFINEMENTS);
			this.clickThisElement(RESET_REFINEMENTS)
				.clickThisElement(OK);
			return this;
		}
		
		public SRPRefinePanel switchDealsAndSavingsFilter(boolean mode){
			By dealSwitch = By.xpath(SearchRefinementType.GlobalFilterSwitches.DEALS_SAVINGS.getLocator());
			if(!CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, dealSwitch, 4))
				new GenericAssert().fail("Could not find [DEALS AND SAVINGS] Filter switch!!!").end();
			if(mode){
				if(actions.element().get().text(dealSwitch, "[DEALS AND SAVINGS] Filter Switch was not found!").contains("OFF"))
					actions.element().click().by(dealSwitch);
			}else{
				if(actions.element().get().text(dealSwitch, "[DEALS AND SAVINGS] Filter Switch was not found!").contains("ON"))
					actions.element().click().by(dealSwitch);
			}
			return this;
		}
	}
}
