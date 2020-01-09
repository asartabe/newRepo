package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Locators.BuyerVIPContentComponentLocators;

public class BuyerVIPContentComponent extends BuyerVIPContentComponentLocators{

	public BuyerVIPContentComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/*
	private BuyerVIPContentComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}

	private BuyerVIPContentComponent enterThisValue(By by, String value){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().textBox().clearAndSendKeys(by, value);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}
	
	public BuyerVIPContentComponent clickATCButton(){
		this.clickThisElement(ITM_ATC_BTN);
		return this;
	}

	public BuyerVIPContentComponent watchItem(){
		this.clickThisElement(ITM_WATCH_BTN);
		return this;
	}

	public BuyerVIPContentComponent unwatchItem(){
		this.clickThisElement(ITM_UNWATCH_BTN);
		return this;
	}
	
	protected BuyerVIPContentComponent updateQuantity(By by, int qty){
		this.enterThisValue(by, Integer.toString(qty));
		return this;
	}
	
	public BuyerVIPContentComponent clickBINButton(){
		this.clickThisElement(ITM_BIN_BTN);
		return this;
	}

	protected BuyerVIPContentComponent clickCommitToBuy() {
		this.clickThisElement(ITM_COMMIT_TO_BUY_BTN);
		return this;
	}
	
	*//**
	 * @param multiQty - TRUE if Multiple-Quantity needs to be purchased
	 * @param qty - Count of Quantities need be purchased
	 * @return
	 *//*
	public BuyerVIPContentComponent makeBINPurchase(boolean multiQty, int qty){
		if(qty < 1) qty = 1;
		
		this.clickBINButton();
		
		if(multiQty && actions.element().found().byPolling(ITM_QTY_SELECT))
			this.updateQuantity(ITM_QTY_SELECT, qty).clickThisElement(ITM_QTY_REVIEW);
		
		this.clickCommitToBuy();
		return this;
	}

	public BuyerVIPContentComponent clickMAKEOFFERButton(){
		this.clickThisElement(ITM_MAKEOFFER_BTN);
		return this;
	}
	
	protected BuyerVIPContentComponent addOfferPrice(Double offerPrice){
		this.enterThisValue(ITM_OFFERPRICE_TXT, Double.toString(offerPrice));
		return this;
	}
	
	*//**
	 * @param multiQty - TRUE if placing Offers for Multiple-Quantity
	 * @param qty - Count of Quantities to place offer 
	 * @return
	 *//*
	public BuyerVIPContentComponent placeOffer(boolean multiQty, int qty, Double offerPrice){
		if(qty < 1) qty = 1;
		
		this.clickMAKEOFFERButton();
		
		if(multiQty && actions.element().found().byPolling(ITM_OFFERQTY_TXT))
			this.updateQuantity(ITM_OFFERQTY_TXT, qty);
		
		this.addOfferPrice(offerPrice)
			.clickThisElement(ITM_REVIEWOFFER_BTN)
			.clickThisElement(ITM_SUBMIT_OFFER);
		return this;
	}
	
	public BuyerVIPContentComponent clickPLACEBIDButton(){
		this.clickThisElement(ITM_PLACEBID_BTN);
		return this;
	}
	
	protected BuyerVIPContentComponent addBIDAmount(Double bidAmt){
		this.enterThisValue(ITM_BIDPRICE_TXT, Double.toString(bidAmt));
		return this;
	}
	
	protected BuyerVIPContentComponent selectBIDAmount(int suggestedBid){
		switch(suggestedBid){
			case 1: this.clickThisElement(ITM_SUGGESTEDBID_1); break;
			case 2: this.clickThisElement(ITM_SUGGESTEDBID_2); break;
			case 3: this.clickThisElement(ITM_SUGGESTEDBID_3); break;
			default: this.clickThisElement(ITM_SUGGESTEDBID_3); break;
		}
		return this;
	}
	
	protected BuyerVIPContentComponent submitBid(){
		this.clickThisElement(ITM_CONFIRM_BID);
		return this;
	}
	
	*//**
	 * @param bidAmt - Custom BID Amount
	 * @param suggestedBids - If need to pick suggested bid amount
	 * @param suggestedBid - Suggested Bid No# 1 or 2 or 3 for values LT1 or GT3 suggested price 3 will be selected.
	 * @return
	 *//*
	public BuyerVIPContentComponent placeBID(Double bidAmt, boolean suggestedBids, int suggestedBid){
		
		this.clickPLACEBIDButton();
		if(suggestedBids)
			this.selectBIDAmount(suggestedBid);
		else
			this.addBIDAmount(bidAmt);
		this.submitBid();
		
		return this;
	}
	
	public BuyerVIPContentComponent clickPayNow(){
		this.clickThisElement(ITM_PAYNOW_BTN);
		return this;
	}
	
	public BuyerVIPContentComponent clickShareItemButton(){
		this.clickThisElement(ITM_SHARE_BTN);
		return this;
	}
	
	public BuyerVIPContentComponent clickSOLTButton(){
		this.clickThisElement(ITM_SOLT_BTN);
		return this;
	}
	
	public BuyerVIPContentComponent clickShowMoreSPRDetails(){
		actions.element().withinParent(ITM_SPR).click().by(ITM_SPR_MORE);
		return this;
	}
	
	public BuyerVIPContentComponent clickShowMoreSellerInfo(){
		this.clickThisElement(ITM_SELLER_PROFILELNK);
		return this;
	}
	
	public BuyerVIPContentComponent clickShowMoreSellerItems(){
		this.clickThisElement(ITM_SELLER_MOREITEMS);
		return this;
	}
	
	public BuyerVIPContentComponent clickLeaveFeedback(){
		this.clickThisElement(ITM_LVFEEDBACK_BTN);
		return this;
	}
	
	public BuyerVIPContentComponent getMoreSMEItems(){
		actions.element().withinParent(SME_PANEL).click().by(SME_MOREITEMS);
		return this;
	}
	
	public BuyerVIPContentComponent clickItemDescriptionLink(){
		this.clickThisElement(ITM_DESCRIPTION_LNK);
		return this;
	}
	
	public BuyerVIPContentComponent clickReportItemButton(){
		this.clickThisElement(ITM_REPORT_BTN);
		return this;
	}
	
	public void clickBINToUpgrade(){
		this.clickBINButton()
			.clickThisElement(UPGRADE_PROMPT_OK);
	}
	
	public void clickBIDToUpgrade(){
		this.clickPLACEBIDButton()
			.clickThisElement(UPGRADE_PROMPT_OK);
	}
	
	public void clickMAKEOFFERToUpgrade(){
		this.clickMAKEOFFERButton()
			.clickThisElement(UPGRADE_PROMPT_OK);
	}
*/}
