package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.RespondOffersComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class RespondOffersComponentLocators extends BasePageObject<RespondOffersComponent>{

	protected RespondOffersComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By PANEL_ITM_DETAILS = getLocator("PANEL_ITM_DETAILS");
	public final By ITM_IMG = getLocator("ITM_IMG");
	public final By ITM_TITLE = getLocator("ITM_TITLE");
	public final By ITM_PRICE = getLocator("ITM_PRICE");
	public final By ITM_POSTAGE = getLocator("ITM_POSTAGE");
	
	public final By PANEL1_OFFER_DETAILS = getLocator("PANEL1_OFFER_DETAILS");
	public final By PANEL1_BUYER = getLocator("PANEL1_BUYER");
	public final By PANEL1_OFFERPRICE = getLocator("PANEL1_OFFERPRICE");
	public final By PANEL1_QTY = getLocator("PANEL1_QTY");
	public final By PANEL1_OFFERSTATE = getLocator("PANEL1_OFFERSTATE");
	public final By PANEL1_EXPIRETIME = getLocator("PANEL1_EXPIRETIME");
	public final By PANEL1_BUYERADDR = getLocator("PANEL1_BUYERADDR");
	public final By PANEL1_RESPONDLNK = getLocator("PANEL1_RESPONDLNK");
	
	public final By PANEL2_OFFER_DETAILS = getLocator("PANEL2_OFFER_DETAILS");
	public final By PANEL2_BUYER = getLocator("PANEL2_BUYER");
	public final By PANEL2_REMAINING = getLocator("PANEL2_REMAINING");
	public final By PANEL2_OFFERPRICE = getLocator("PANEL2_OFFERPRICE");
	public final By PANEL2_QTY = getLocator("PANEL2_QTY");
	public final By PANEL2_EXPIRETIME = getLocator("PANEL2_EXPIRETIME");
	public final By PANEL2_BUYERADDR = getLocator("PANEL2_BUYERADDR");
	
	public final By BTN_ACCEPT = getLocator("BTN_ACCEPT");
	public final By BTN_COUNTER = getLocator("BTN_COUNTER");
	public final By BTN_DECLINE = getLocator("BTN_DECLINE");
	
	public final By LEGAL_TERMS_ACCEPT = getLocator("LEGAL_TERMS_ACCEPT");
	
	public final By BTN_ACCEPT_CONFIRM = getLocator("BTN_ACCEPT_CONFIRM");
	
	public final By CTR_OFFER_TXT = getLocator("CTR_OFFER_TXT");
	public final By CTR_OFFER_QTY = getLocator("CTR_OFFER_QTY");
	public final By CTR_OFFER_TERMS = getLocator("CTR_OFFER_TERMS");
	public final By CTR_RVW_OFFER = getLocator("CTR_RVW_OFFER");
	public final By LEGAL_TERMS_COUNTER = getLocator("LEGAL_TERMS_COUNTER");
	public final By BTN_COUNTER_CONFIRM = getLocator("BTN_COUNTER_CONFIRM");
	public final By BTN_COUNTER_EDIT = getLocator("BTN_COUNTER_EDIT");
	
	public final By DEC_MESSAGE = getLocator("DEC_MESSAGE");
	public final By BTN_DECLINE_CONFIRM = getLocator("BTN_DECLINE_CONFIRM");
	
	public final By SUCCESS_MSG_DECLINE = getLocator("SUCCESS_MSG_DECLINE");
	public final By SUCCESS_MSG_ACCEPT = getLocator("SUCCESS_MSG_ACCEPT");
	public final By SUCCESS_MSG_COUNTER = getLocator("SUCCESS_MSG_COUNTER");
	
	@Override
	  protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "PANEL_ITM_DETAILS",By.id("com.ebay.mobile:id/item_header_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_IMG",By.id("com.ebay.mobile:id/item_thumbnail"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_TITLE",By.id("com.ebay.mobile:id/item_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PRICE",By.id("com.ebay.mobile:id/textview_item_price"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_POSTAGE",By.id("com.ebay.mobile:id/shipping_textview"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "PANEL1_OFFER_DETAILS",By.id("com.ebay.mobile:id/body"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL1_BUYER",By.id("com.ebay.mobile:id/buyer"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL1_OFFERPRICE",By.id("com.ebay.mobile:id/price"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL1_QTY",By.id("com.ebay.mobile:id/quantity"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL1_OFFERSTATE",By.id("com.ebay.mobile:id/status"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL1_EXPIRETIME",By.id("com.ebay.mobile:id/expires"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL1_BUYERADDR",By.id("com.ebay.mobile:id/ship_to"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL1_RESPONDLNK",By.id("com.ebay.mobile:id/respond_to_offer"));
				
		setLocator(LocatorType.ANDROID_LOCATOR, "PANEL2_OFFER_DETAILS",By.id("com.ebay.mobile:id/offer_view_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL2_BUYER",By.id("com.ebay.mobile:id/view_offer_buyer"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL2_REMAINING",By.id("com.ebay.mobile:id/view_offer_offers_remaining"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL2_OFFERPRICE",By.id("com.ebay.mobile:id/view_offer_bid_value"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL2_QTY",By.id("com.ebay.mobile:id/view_offer_quantity_value"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL2_EXPIRETIME",By.id("com.ebay.mobile:id/view_offer_expires_in"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PANEL2_BUYERADDR",By.id("com.ebay.mobile:id/view_offer_buyer_address_value"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_ACCEPT",By.id("com.ebay.mobile:id/seller_offer_row_accept_offer_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_COUNTER",By.id("com.ebay.mobile:id/seller_offer_row_counteroffer_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_DECLINE",By.id("com.ebay.mobile:id/seller_offer_row_decline_offer_button"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "LEGAL_TERMS_ACCEPT",By.id("com.ebay.mobile:id/LEGAL_seller_accept_offer_legal"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_ACCEPT_CONFIRM",By.id("com.ebay.mobile:id/offer_accept_confirm_button")); 
		
		setLocator(LocatorType.ANDROID_LOCATOR, "CTR_OFFER_TXT",By.id("com.ebay.mobile:id/offer_amount_edittext"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CTR_OFFER_QTY",By.id("com.ebay.mobile:id/counteroffer_quantity"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CTR_OFFER_TERMS",By.id("com.ebay.mobile:id/counteroffer_terms"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CTR_RVW_OFFER",By.id("com.ebay.mobile:id/counteroffer_review_offer_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LEGAL_TERMS_COUNTER",By.id("com.ebay.mobile:id/counteroffer_legal"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_COUNTER_CONFIRM",By.id("com.ebay.mobile:id/counteroffer_submit_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_COUNTER_EDIT",By.id("com.ebay.mobile:id/counteroffer_edit_button"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "DEC_MESSAGE",By.id("com.ebay.mobile:id/seller_decline_message"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_DECLINE_CONFIRM",By.id("com.ebay.mobile:id/offer_decline_confirm_button"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SUCCESS_MSG_DECLINE",By.id("com.ebay.mobile:id/offer_decline_success"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SUCCESS_MSG_ACCEPT",By.id("com.ebay.mobile:id/offer_accept_success"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SUCCESS_MSG_COUNTER",By.id("com.ebay.mobile:id/offer_counter_success"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
	
	}
}
