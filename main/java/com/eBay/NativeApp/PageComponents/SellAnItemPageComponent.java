package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eBay.NativeApp.BreezeTestParams.TestNGPara;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Enums.PostageEnums.PostageFor;
import com.eBay.NativeApp.Locators.SellAnItemPageComponentLocators;
import com.eBay.NativeApp.Pages.SellAnItemPage;
import com.eBay.NativeApp.Validators.SellAnItemPageValidators;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;

public class SellAnItemPageComponent extends SellAnItemPageComponentLocators{

	public SellAnItemPageComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private SellAnItemPageComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}
	
	private SellAnItemPageComponent enterText(By by, String data){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().textBox().clearAndSendKeys(by, data);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}
	
	public SellAnItemPageComponent saveDraft(){
		this.clickThisElement(SAVE_LISTING);
		return this;
	}
	
	public SellAnItemPageComponent continueToFinishListing(){
		this.clickThisElement(CONTINUE_LISTING);
		return this;
	}
	
	public SellAnItemPageComponent enterTitleAndProceed(ItemType item){
		this.enterText(ITEM_TITLE, item.getTitle()+"\n");
		return this;
	}
	
	public SellAnItemPageComponent editTitle(ItemType item){
		this.clickThisElement(ITEM_TITLE_CELL)
			.enterText(ITEM_TITLE_EDIT, item.getTitle())
			.clickThisElement(NAVIGATE_BACK);
		return this;
	}
	
	public String selectCatalogProduct(){
		String title = actions.element().get().text(actions.element().get().allWebElementsWithSameLocator(CATALOG_PROD_TITLE).get(0));
		actions.element().click().webElement(actions.element().get().allWebElementsWithSameLocator(CATALOG_PROD).get(0));
		return title;
	}
	
	public SellAnItemPageComponent editCategory(boolean confirmEdit){
		this.clickThisElement(ITEM_CATEGORY_CELL)
			.clickThisElement(CAT_EDIT);
		CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, CAT_LVL_1);
		this.clickThisElement(CAT_LVL_1)
			.clickThisElement(CAT_LVL_2)
			.clickThisElement(CAT_LVL_3)
			.clickThisElement(CAT_LVL_4);
		
		UIChainAssert uiAssert = new UIChainAssert(driver);
		new SellAnItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setSellAnItemPage(new SellAnItemPage(driver))
			.validateCatalogCategoryChangeAlert();
		uiAssert.end();
		
		if(confirmEdit)
			clickThisElement(CATALOG_CAT_CHNG_ALERT_OK);
		else
			clickThisElement(CATALOG_CAT_CHNG_ALERT_CANCEL);
		
		this.clickThisElement(NAVIGATE_BACK);
		
		return this;
	}
	
	public SellAnItemPageComponent selectCategory(){
		if(actions.element().withinParent(By.id("com.ebay.mobile:id/primary_toolbar"))
				.get().text(By.id("com.ebay.mobile:id/title"), "").contains("Select a category")){
			CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, CAT_LVL_1);
			this.clickThisElement(CAT_LVL_1)
				.clickThisElement(CAT_LVL_2)
				.clickThisElement(CAT_LVL_3)
				.clickThisElement(CAT_LVL_4);
			
			if(actions.element().present().byCustomPolling(ITEM_TO_LIST, 10))
				this.clickThisElement(ITEM_TO_LIST);
		}
		return this;
	}
	
	public SellAnItemPageComponent addPhotos(){
		
		this.clickThisElement(ITEM_PHOTOS_CELL)
			.clickThisElement(ITEM_UPLOAD_PHOTO)
			.clickThisElement(PHOTO_FROM_GALLERY);
		if(actions.element().present().byPolling(ALLOW_FROM_GALLERY))
			actions.element().click().by(ALLOW_FROM_GALLERY);
		this.clickThisElement(PHOTO_TO_UPLOAD)
			.clickThisElement(PHOTO_UPLOAD_BTN)
			.clickThisElement(NAVIGATE_BACK);
		
		return this;
	}
	
	public SellAnItemPageComponent addCondition(){
		this.clickThisElement(ITEM_CONDITION_CELL)
			.clickThisElement(CONDITION_VALUE)
			.enterText(CONDITION_DESC, "Test Item Do Not Buy")
			.clickThisElement(NAVIGATE_BACK);
		return this;
	}
	
	public SellAnItemPageComponent addDescription(){
		this.clickThisElement(ITEM_DESCRIPTION_CELL)
			.enterText(DESC_DETAILS, "TEST ITEM DO NOT BUY")
			.clickThisElement(NAVIGATE_BACK);
		return this;
	}
	
	public SellAnItemPageComponent addDescription(ItemType item){
		this.clickThisElement(ITEM_DESCRIPTION_CELL)
			.enterText(DESC_DETAILS, item.getDescription())
			.clickThisElement(NAVIGATE_BACK);
		return this;
	}
	
	protected SellAnItemPageComponent addAuctionPricing(ItemType item, boolean isABIN){
		this.enterText(PRICE_AUCTION, Double.toString(item.getStartPrice().getValue()));
		if(isABIN)
			this.enterText(PRICE_BIN_WITHAUCTION, Double.toString(item.getBuyItNowPrice().getValue()));
		
		/*if(item.getReservePrice().getValue() > 0.00)
		{
			//add code to add reserve price listing fee
		}*/
		
		return this;
	}
	
	protected SellAnItemPageComponent addBuyItNowPricing(ItemType item){
		if(item.getBestOfferDetails().isBestOfferEnabled() && item.getStartPrice().getValue()<10){
			AmountType value = new AmountType();
			value.setValue(10.00);
			item.setStartPrice(value);
		}
		
		this.enterText(PRICE_BUYITNOW, Double.toString(item.getStartPrice().getValue()));
		if(item.getQuantity().intValue() > 1)
			this.enterText(PRICE_QUANTITY, Integer.toString(item.getQuantity().intValue()));
		return this;
	}
	
	protected SellAnItemPageComponent addBestOfferDetails(ItemType item, boolean autoAccept, boolean autoDecline){
		
		if(item.getBestOfferDetails().isBestOfferEnabled() && actions.element().get().text(PRICE_BO_SWITCH, "").contains("OFF"))
			this.clickThisElement(PRICE_BO_SWITCH);
		else if(!item.getBestOfferDetails().isBestOfferEnabled() && actions.element().get().text(PRICE_BO_SWITCH, "").contains("ON"))
			this.clickThisElement(PRICE_BO_SWITCH);
		
		if(autoAccept)
			this.enterText(PRICE_BO_AUTOACCEPT, Double.toString(10.00-1.00));
		if(autoDecline)
			this.enterText(PRICE_BO_AUTODECLINE, Double.toString(10.00-3.00));
			
		return this;
	}
	
	public SellAnItemPageComponent addPriceDetails(ItemType item, boolean isABIN, boolean boAutoAcceptPrice, boolean boAutoDeclinePrice){
		this.clickThisElement(ITEM_PRICEFORMAT_CELL)
			.clickThisElement(PRICE_MORE_OPTIONS);
		if(item.getListingType().equals(ListingTypeCodeType.CHINESE))
			this.clickThisElement(LISTINGTYPE_AUCTION)
				.addAuctionPricing(item, isABIN);
		else if(item.getListingType().equals(ListingTypeCodeType.FIXED_PRICE_ITEM)){
			this.clickThisElement(LISTINGTYPE_BUYITNOW)
				.addBuyItNowPricing(item)
				.addBestOfferDetails(item, boAutoAcceptPrice, boAutoDeclinePrice);;
		}
		
		this.clickThisElement(NAVIGATE_BACK);
		return this;
	}
	
	/*NEED TO FINISH BELOW CODE*/
	public SellAnItemPageComponent scheduleListing(boolean schedule){
		if(schedule){
			this.clickThisElement(PRICE_SCHEDULE_SEL)
				.clickThisElement(PRICE_SCHEDULE_LATER)
				.clickThisElement(PRICE_SCHEDULE_LATER_DATE_SEL);
			
			List<WebElement> dates = actions.element().get().allWebElementsWithSameLocator(PRICE_SCHEDULE_LATER_DATE_VALUE);
			for (WebElement date : dates) {
				if(date.getAttribute("content-desc").contains("Selected")){
					String index = date.getAttribute("index");
					this.clickThisElement(By.xpath("//android.view.View[@index='"+index+"']"));
					break;
				}
			}
		}
		return this;
	}
	
	private boolean defaultPostage = false;
	private SellAnItemPageComponent selectPostageType(PostageFor postFor, ShippingTypeCodeType postageType){
		if(postFor.equals(PostageFor.DOMESTIC))
			if(CustomWaitUtils.waitForElement(POSTAGE_TYPE_SEL))
				actions.element().click().by(POSTAGE_TYPE_SEL);
			else if(CustomWaitUtils.waitForElement(DEFAULT_POSTAGE_ADDED))
			{	defaultPostage = true;
				return this;
			}
		else{
			actions.element().click().by(POSTAGE_SHOW_INTL_OPTIONS, "You might have not added any Domestic Postage!!!");
			this.clickThisElement(POSTAGE_INTL_TYPE);
		}
		if(postageType.equals(ShippingTypeCodeType.FLAT))
			this.clickThisElement(POSTAGE_TYPE_FLAT);
		else if(postageType.equals(ShippingTypeCodeType.CALCULATED))
			this.clickThisElement(POSTAGE_TYPE_CALC);
		else
			this.clickThisElement(POSTAGE_TYPE_LOCALPICKUPONLY);
		
		return this;
	}
	
	private SellAnItemPageComponent selectPostageService(PostageFor postFor, ShippingTypeCodeType postageType){
		if(postFor.equals(PostageFor.DOMESTIC))
			this.clickThisElement(POSTAGE_ADD_SRVC)
				.clickThisElement(POSTAGE_SRVC_PARENT);
		else
			this.clickThisElement(POSTAGE_INTL_ADD).clickThisElement(POSTAGE_INTL_SRVC_PARENT);
		
		if(TestNGPara.getSite().equalsIgnoreCase("AU")){
			List<WebElement> services = actions.element().get().allWebElementsWithSameLocator(POSTAGE_SRVC_CHILD_OPTIONS);
			actions.element().click().webElement(services.get(0));
		}
		
		if(postageType.equals(ShippingTypeCodeType.FLAT))
			this.enterText(POSTAGE_FLAT_SRVC_PRICE, "2.00");
		
		this.clickThisElement(POSTAGE_SRVC_SAVE);
		
		return this;
	}
	
	private SellAnItemPageComponent addPackageDetails(ItemType item){
		
		if(item.getShippingDetails().getShippingType().equals(ShippingTypeCodeType.CALCULATED)){
			this.clickThisElement(POSTAGE_PKG_INFO)
				.enterText(POSTAGE_PKG_LENGTH, item.getShippingPackageDetails().getPackageLength().getValue().toString())
				.enterText(POSTAGE_PKG_WIDTH, item.getShippingPackageDetails().getPackageWidth().getValue().toString())
				.enterText(POSTAGE_PKG_HEIGHT, item.getShippingPackageDetails().getPackageDepth().getValue().toString())
				.enterText(POSTAGE_PKG_WGT_KGS, item.getShippingPackageDetails().getWeightMajor().getValue().toString())
				.enterText(POSTAGE_PKG_WGT_GMS, item.getShippingPackageDetails().getWeightMinor().getValue().toString())
				.clickThisElement(POSTAGE_PKG_SAVE);
		}
		return this;
	}
	
	public SellAnItemPageComponent addPostageDetails(ItemType item, boolean addIntlPostage){

		this.clickThisElement(ITEM_POSTAGE_CELL);

		this.selectPostageType(PostageFor.DOMESTIC, item.getShippingDetails().getShippingType());

		if(!defaultPostage)
			this.selectPostageService(PostageFor.DOMESTIC, item.getShippingDetails().getShippingType()).addPackageDetails(item);

		if(addIntlPostage)
			this.selectPostageType(PostageFor.INTERNATIONAL, item.getShippingDetails().getShippingType())
				.selectPostageService(PostageFor.INTERNATIONAL, item.getShippingDetails().getShippingType());

		this.clickThisElement(NAVIGATE_BACK);

		return this;
	}
	
	public SellAnItemPageComponent addPaymentDetails(ItemType item, boolean enableReturns){
		
		this.clickThisElement(ITEM_PAYMENT_CELL);
		
		this.enterText(PAYMENT_PAYPAL_EMAIL, item.getPayPalEmailAddress());
		
		if(TestNGPara.getSite().equalsIgnoreCase("AU")){
			if(enableReturns && actions.element().get().text(PAYMENT_RETURNS_SWITCH, "").contains("OFF")){
				clickThisElement(PAYMENT_RETURNS_SWITCH);
				clickThisElement(PAYMENT_RETURNS_WITHIN_DROP); actions.element().click().oneFromManyWithSameLocator(PAYMENT_RETURN_OPTIONS, 0);
				clickThisElement(PAYMENT_RETURNS_GIVEN_AS); actions.element().click().oneFromManyWithSameLocator(PAYMENT_RETURN_OPTIONS, 0);
				clickThisElement(PAYMENT_RETURN_PAID_BY); actions.element().click().oneFromManyWithSameLocator(PAYMENT_RETURN_OPTIONS, 0);
			}
			else if(!enableReturns && actions.element().get().text(PAYMENT_RETURNS_SWITCH, "").contains("ON"))
				this.clickThisElement(PAYMENT_RETURNS_SWITCH);
		}
		this.clickThisElement(NAVIGATE_BACK);
		return this;
	}
	
	
	
	
}
