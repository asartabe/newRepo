package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.ViewItemPageLocators;
import com.eBay.NativeApp.Pages.RespondOffersPage;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;

public class ViewItemPageComponent extends ViewItemPageLocators{
	
	private boolean isMSKU = false;
	
	public ViewItemPageComponent(WebDriver driver) {
		super(driver);
	}
	
	public SellerViewItemPageActionsComponent getSellerViewItemPageActions(){
		return new SellerViewItemPageActionsComponent();
	}
	
	public BuyerViewItemPageActionsComponent getBuyerViewItemPageActions(){
		return new BuyerViewItemPageActionsComponent();
	}
	
	private ViewItemPageComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return new ViewItemPageComponent(driver);
	}
	
	public boolean checkIfMSKU(){
		isMSKU = false;
		if(actions.element().present().now(ITM_MSKU_OPTIONS_PANEL))
			isMSKU = true;
		return isMSKU;
	}
	
	public ViewItemPageComponent viewSellerDetails(){
		
		if(CustomTouchUtils.scrollToElement(actions, SEC_ABOUT_THE_SELLER, 5)){
			if(actions.element().withinParent(SEC_ABOUT_THE_SELLER).present().now(ITM_SELLER_PROFILELNK))
				actions.element().withinParent(SEC_ABOUT_THE_SELLER).click().by(ITM_SELLER_PROFILELNK);
		}
		return this;
	}
	
	public ViewItemPageComponent viewPostageReturnPaymentDetails(){
		if(CustomTouchUtils.scrollToElement(actions, SEC_SPR, 5)){
			if(actions.element().withinParent(SEC_SPR).present().now(ITM_SPR_MORE)){
				actions.element().withinParent(SEC_SPR).click().by(ITM_SPR_MORE);
				if(checkIfMSKU()) selectMSKUOptions(true);
			}
		}
		return this;
	}
	
	public ViewItemPageComponent selectMSKUOptions(boolean withDone){
		if(actions.element().present().now(ITM_MSKU_OPTIONS_PANEL)){
			List<WebElement> mskuRows = actions.element().withinParent(ITM_MSKU_OPTIONS_PANEL).get().allWebElementsWithSameLocator(ITM_MSKU_OPT);
			for (WebElement mskuRow : mskuRows) {
				actions.element().withinParent(mskuRow).click().by(ITM_MSKU_OPT_DROPDOWN);
				actions.element().click().oneFromManyWithSameLocator(ITM_MSKU_OPT_DROP_VALUES, 1);
			}
		}
		if(withDone && actions.element().present().now(ITM_MSKU_DONE)){
			actions.element().click().by(ITM_MSKU_DONE);
		}
		return new ViewItemPageComponent(driver);
	}
	
	public class SellerViewItemPageActionsComponent{
		
		public ViewItemPageComponent endListing(){
			clickThisElement(SELLER_END_LISTING);
			actions.element().click().webElement(actions.element().get().allWebElementsWithSameLocator(SELLER_END_REASONS).get(1));
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickToEndListingAndConfirm(){
			endListing();
			if(!CustomWaitUtils.waitForElement(SELLER_RELIST_LISTING))
				new ReportLogger().logInConsoleAndReport("RELIST_BUTTON did not show after ENDING_LISTING");
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickToReviseListing(){
			clickThisElement(SELLER_REVISE_LISTING);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickToSellSimilar(){
			clickThisElement(SELLER_SELL_SIMILAR);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickToRelist(){
			clickThisElement(SELLER_RELIST_LISTING);
			return new ViewItemPageComponent(driver);
		}
		
		public RespondOffersPage clickToReviewOffers(){
			clickThisElement(SELLER_REVIEW_OFFERS);
			return new RespondOffersPage(driver);
		}
		
	}
	
	public class BuyerViewItemPageActionsComponent{

		private ViewItemPageComponent enterThisValue(By by, String value){
			if(CustomWaitUtils.waitForElement(by))
				actions.element().textBox().clearAndSendKeys(by, value);
			else
				Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickATCButton(){
			if(checkIfMSKU()) selectMSKUOptions(false);
			clickThisElement(ITM_ATC_BTN);
			return new ViewItemPageComponent(driver);
		}

		public ViewItemPageComponent watchItem(){
			if(checkIfMSKU()) selectMSKUOptions(false);
			clickThisElement(ITM_WATCH_BTN);
			return new ViewItemPageComponent(driver);
		}

		public ViewItemPageComponent unwatchItem(){
			clickThisElement(ITM_UNWATCH_BTN);
			return new ViewItemPageComponent(driver);
		}
		
		protected ViewItemPageComponent updateQuantity(By by, int qty){
			this.enterThisValue(by, Integer.toString(qty));
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickBINButton(){
			if(checkIfMSKU()) selectMSKUOptions(false);
			clickThisElement(ITM_BIN_BTN);
			if(actions.element().found().byPolling(ITM_QTY_SELECT)) clickThisElement(ITM_QTY_REVIEW);
			return new ViewItemPageComponent(driver);
		}

		protected ViewItemPageComponent clickCommitToBuy() {
			clickThisElement(ITM_COMMIT_TO_BUY_BTN);
			return new ViewItemPageComponent(driver);
		}
		
		/**
		 * @param multiQty - TRUE if Multiple-Quantity needs to be purchased
		 * @param qty - Count of Quantities need be purchased
		 * @return
		 */
		public ViewItemPageComponent makeBINPurchase(boolean multiQty, int qty){
			if(qty < 1) qty = 1;
			
			clickBINButton();
			
//			if(multiQty && actions.element().found().byPolling(ITM_QTY_SELECT))
//				this.updateQuantity(ITM_QTY_SELECT, qty).clickThisElement(ITM_QTY_REVIEW);
//			
//			clickCommitToBuy();
			return new ViewItemPageComponent(driver);
		}

		protected ViewItemPageComponent clickMAKEOFFERButton(){
			if(checkIfMSKU()) selectMSKUOptions(false);
			clickThisElement(ITM_MAKEOFFER_BTN);
			return new ViewItemPageComponent(driver);
		}
		
		protected ViewItemPageComponent addOfferPrice(Double offerPrice){
			this.enterThisValue(ITM_OFFERPRICE_TXT, Double.toString(offerPrice));
			return new ViewItemPageComponent(driver);
		}
		
		/**
		 * @param multiQty - TRUE if placing Offers for Multiple-Quantity
		 * @param qty - Count of Quantities to place offer 
		 * @return
		 */
		public ViewItemPageComponent placeOffer(boolean multiQty, int qty, Double offerPrice){
			if(qty < 1) qty = 1;
			clickMAKEOFFERButton();
			if(actions.element().present().byCustomPolling(BO_NEW_OFFERS_LEFT_LBL, 5)){
				enterThisValue(BO_NEW_OFFER_PRICE_TXT, Double.toString(offerPrice))
				.clickThisElement(BO_NEW_RVW_OFFER_BTN)
				.clickThisElement(BO_NEW_SUBMIT_OFFER);
			}
			else{
				if(multiQty && actions.element().found().byPolling(ITM_OFFERQTY_TXT))
					this.updateQuantity(ITM_OFFERQTY_TXT, qty);
				this.addOfferPrice(offerPrice)
					.clickThisElement(ITM_REVIEWOFFER_BTN)
					.clickThisElement(ITM_SUBMIT_OFFER);
			}
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickPLACEBIDButton(){
			clickThisElement(ITM_PLACEBID_BTN);
			return new ViewItemPageComponent(driver);
		}
		
		protected ViewItemPageComponent addBIDAmount(Double bidAmt){
			this.enterThisValue(ITM_BIDPRICE_TXT, Double.toString(bidAmt));
			return new ViewItemPageComponent(driver);
		}
		
		protected ViewItemPageComponent selectBIDAmount(int suggestedBid){
			switch(suggestedBid){
				case 1: clickThisElement(ITM_SUGGESTEDBID_1); break;
				case 2: clickThisElement(ITM_SUGGESTEDBID_2); break;
				case 3: clickThisElement(ITM_SUGGESTEDBID_3); break;
				default: clickThisElement(ITM_SUGGESTEDBID_3); break;
			}
			return new ViewItemPageComponent(driver);
		}
		
		protected ViewItemPageComponent submitBid(){
			clickThisElement(ITM_CONFIRM_BID);
			return new ViewItemPageComponent(driver);
		}
		
		/**
		 * @param bidAmt - Custom BID Amount
		 * @param suggestedBids - If need to pick suggested bid amount
		 * @param suggestedBid - Suggested Bid No# 1 or 2 or 3 for values LT1 or GT3 suggested price 3 will be selected.
		 * @return
		 */
		public ViewItemPageComponent placeBID(Double bidAmt, boolean suggestedBids, int suggestedBid){
			
			clickPLACEBIDButton();
			if(suggestedBids)
				this.selectBIDAmount(suggestedBid);
			else
				this.addBIDAmount(bidAmt);
			this.submitBid();
			
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickPayNow(){
			clickThisElement(ITM_PAYNOW_BTN);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickShareItemButton(){
			if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, ITM_SHARE_BTN, 10))
				clickThisElement(ITM_SHARE_BTN);
			else
				new GenericAssert().fail("Could not find SHARE Button").end();
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickSOLTButton(){
			clickThisElement(ITM_SOLT_BTN);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickShowMoreSPRDetails(){
			actions.element().withinParent(ITM_SPR).click().by(ITM_SPR_MORE);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickShowMoreSellerInfo(){
			clickThisElement(ITM_SELLER_PROFILELNK);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickShowMoreSellerItems(){
			clickThisElement(ITM_SELLER_MOREITEMS);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickLeaveFeedback(){
			clickThisElement(ITM_LVFEEDBACK_BTN);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent getMoreSMEItems(){
			actions.element().withinParent(SME_PANEL).click().by(SME_MOREITEMS);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickItemDescriptionLink(){
			clickThisElement(ITM_DESCRIPTION_LNK);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickItemProductDetailsLink(){
			clickThisElement(ITM_PRODUCT_DETAILS);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickReportItemButton(){
			clickThisElement(ITM_REPORT_BTN);
			return new ViewItemPageComponent(driver);
		}
		
		public void clickBINToUpgrade(){
			clickBINButton()
				.clickThisElement(UPGRADE_PROMPT_OK);
		}
		
		public void clickBIDToUpgrade(){
			/*clickPLACEBIDButton()*/
			placeBID(null, true, 1)
				.clickThisElement(UPGRADE_PROMPT_OK);
		}
		
		public void clickMAKEOFFERToUpgrade(){
			clickMAKEOFFERButton()
				.clickThisElement(UPGRADE_PROMPT_OK);
		}
		
		public ViewItemPageComponent clickReviewStarsAndGoToRatingsReviewsSection(){
			actions.element().click().by(ITM_RVWSTARS);
			CustomWaitUtils.waitForSeconds(5);
			CustomTouchUtils.scrollToElement(actions, SEC_RnR_HDR, 2);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickToSeeAllReviews(){
			if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, RnR_SEE_MORE_REVIEWS))
				actions.element().click().by(RnR_SEE_MORE_REVIEWS);
			return new ViewItemPageComponent(driver);
		}
		
		public ViewItemPageComponent clickToWriteAReview(){
			if(CustomTouchUtils.scrollToElement(actions, PRVW_WRITE_REVIEW_BTN, 2))
				actions.element().click().by(PRVW_WRITE_REVIEW_BTN);
			return new ViewItemPageComponent(driver);
		}
		
	}
	
}
