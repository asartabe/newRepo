package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.BuyerVIPContentComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class BuyerVIPContentComponentLocators extends BasePageObject<BuyerVIPContentComponent>{

	protected BuyerVIPContentComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By ITM_IMAGE = getLocator("ITM_IMAGE");
	public final By ITM_TITLE = getLocator("ITM_TITLE");
	public final By ITM_SUBTITLE = getLocator("ITM_SUBTITLE");
	public final By ITM_RVWSTARS = getLocator("ITM_RVWSTARS");
	public final By ITM_RVWCOUNT = getLocator("ITM_RVWCOUNT");
	public final By ITM_PRICE = getLocator("ITM_PRICE");
	public final By ITM_ORIGINAL_PRICE = getLocator("ITM_ORIGINAL_PRICE");
	public final By ITM_PRCNT_OFF = getLocator("ITM_PRCNT_OFF");
	
	public final By ITM_BIN_BTN = getLocator("ITM_BIN_BTN");
		public final By ITM_COMMIT_TO_BUY_BTN = getLocator("ITM_COMMIT_TO_BUY_BTN");
		public final By ITM_PAYNOW_BTN = getLocator("ITM_PAYNOW_BTN");
	public final By ITM_MAKEOFFER_BTN = getLocator("ITM_MAKEOFFER_BTN");
		public final By ITM_OFFERPRICE_TXT = getLocator("ITM_OFFERPRICE_TXT");
		public final By ITM_OFFERQTY_TXT = getLocator("ITM_OFFERQTY_TXT");
		public final By ITM_REVIEWOFFER_BTN = getLocator("ITM_REVIEWOFFER_BTN");
		public final By ITM_SUBMIT_OFFER = getLocator("ITM_SUBMIT_OFFER");
	public final By ITM_PLACEBID_BTN = getLocator("ITM_PLACEBID_BTN");
		public final By ITM_BIDPRICE_TXT = getLocator("ITM_BIDPRICE_TXT");
		public final By ITM_CONFIRM_BID = getLocator("ITM_CONFIRM_BID");
		public final By ITM_SUGGESTEDBID_1 = getLocator("ITM_SUGGESTEDBID_1");
		public final By ITM_SUGGESTEDBID_2 = getLocator("ITM_SUGGESTEDBID_2");
		public final By ITM_SUGGESTEDBID_3 = getLocator("ITM_SUGGESTEDBID_3");
	
	public final By ITM_CONTACT_BTN = getLocator("ITM_CONTACT_BTN");
	public final By ITM_LVFEEDBACK_BTN = getLocator("ITM_LVFEEDBACK_BTN");
	
	public final By ITM_QTY_SELECT = getLocator("ITM_QTY_SELECT");
	public final By ITM_QTY_REVIEW = getLocator("ITM_QTY_REVIEW");
	
	public final By ITM_ATC_BTN = getLocator("ITM_ATC_BTN");
	public final By ITM_WATCH_BTN = getLocator("ITM_WATCH_BTN");
	public final By ITM_UNWATCH_BTN = getLocator("ITM_UNWATCH_BTN");
	
	public final By SME_PANEL = getLocator("SME_PANEL");
		public final By SME_MOREITEMS = getLocator("SME_MOREITEMS");
	
	public final By SEC_ABOUT_THIS_ITEM = getLocator("SEC_ABOUT_THIS_ITEM");
	public final By ITM_DESCRIPTION_LNK = getLocator("ITM_DESCRIPTION_LNK");
	
	public final By SEC_SPR = getLocator("SEC_SPR");
	public final By ITM_SPR = getLocator("ITM_SPR");
		public final By ITM_SPR_MORE = getLocator("ITM_SPR_MORE");
	
	public final By SEC_MORE_LIKE_THIS = getLocator("SEC_MORE_LIKE_THIS");
		public final By ITM_MERCH_IMG = getLocator("ITM_MERCH_IMG");
	
	public final By SEC_ABOUT_THE_SELLER = getLocator("SEC_ABOUT_THE_SELLER");
		public final By ITM_SELLER_MOREITEMS = getLocator("ITM_SELLER_MOREITEMS");
		public final By ITM_SELLER_PROFILELNK = getLocator("ITM_SELLER_PROFILELNK");
	
	public final By ITM_SOLT_BTN = getLocator("ITM_SOLT_BTN");
	public final By ITM_SHARE_BTN = getLocator("ITM_SHARE_BTN");
	public final By ITM_REPORT_BTN = getLocator("ITM_REPORT_BTN");
	
	public final By UPGRADE_PROMPT_OK = getLocator("UPGRADE_PROMPT_OK");
	public final By UPGRADE_PROMPT_CANCEL = getLocator("UPGRADE_PROMPT_CANCEL");
	
	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_IMAGE",By.id("com.ebay.mobile:id/imageview_image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_TITLE",By.id("com.ebay.mobile:id/textview_item_name"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SUBTITLE",By.id("com.ebay.mobile:id/item_subtitle_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_RVWSTARS",By.id("com.ebay.mobile:id/reviews_rating"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_RVWCOUNT",By.id("com.ebay.mobile:id/reviews_count"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PRICE",By.id("com.ebay.mobile:id/textview_item_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_ORIGINAL_PRICE",By.id("com.ebay.mobile:id/original_price_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PRCNT_OFF",By.id("com.ebay.mobile:id/percent_off_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_BIN_BTN",By.id("com.ebay.mobile:id/button_bin"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_ATC_BTN",By.id("com.ebay.mobile:id/button_add_to_cart"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PLACEBID_BTN",By.id("com.ebay.mobile:id/button_placebid"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MAKEOFFER_BTN",By.id("com.ebay.mobile:id/button_make_offer"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_COMMIT_TO_BUY_BTN",By.id("com.ebay.mobile:id/take_action"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PAYNOW_BTN",By.id("com.ebay.mobile:id/button_pay_now"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_CONTACT_BTN",By.id("com.ebay.mobile:id/button_contact"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_LVFEEDBACK_BTN",By.id("com.ebay.mobile:id/button_leave_feedback"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_OFFERPRICE_TXT",By.id("com.ebay.mobile:id/offer_amount_edittext"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_OFFERQTY_TXT",By.id("com.ebay.mobile:id/create_offer_quantity"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_REVIEWOFFER_BTN",By.id("com.ebay.mobile:id/offer_review_offer_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SUBMIT_OFFER",By.id("com.ebay.mobile:id/offer_submit_offer_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_QTY_SELECT",By.id("android:id/numberpicker_input"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_QTY_REVIEW",By.id("com.ebay.mobile:id/take_action"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_BIDPRICE_TXT",By.id("com.ebay.mobile:id/edit_text"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_CONFIRM_BID",By.id("com.ebay.mobile:id/button_confirm_bid"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SUGGESTEDBID_1",By.id("com.ebay.mobile:id/power_bid_value1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SUGGESTEDBID_2",By.id("com.ebay.mobile:id/power_bid_value2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SUGGESTEDBID_3",By.id("com.ebay.mobile:id/power_bid_value3"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_WATCH_BTN",By.id("com.ebay.mobile:id/button_watch"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_UNWATCH_BTN",By.id("com.ebay.mobile:id/button_unwatch"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SME_PANEL",By.id("com.ebay.mobile:id/button_sme_panel"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SME_MOREITEMS",By.id("com.ebay.mobile:id/chevron_icon"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_BIDDING",By.id("//android.widget.TextView[@text='Bidding']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_ABOUT_THIS_ITEM",By.id("com.ebay.mobile:id/about_this_item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_DESCRIPTION_LNK",By.id("com.ebay.mobile:id/description_snippet_readmore"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_SPR",By.id("com.ebay.mobile:id/spr_fragment_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SPR",By.id("com.ebay.mobile:id/spr_fragment_expando_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SPR_MORE",By.id("com.ebay.mobile:id/chevron_icon"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_MORE_LIKE_THIS",By.xpath("//android.widget.TextView[@text='More like this']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MERCH_IMG",By.id("com.ebay.mobile:id/merch_image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_ABOUT_THE_SELLER",By.xpath("//android.widget.TextView[@text='About the seller']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SELLER_MOREITEMS",By.id("com.ebay.mobile:id/button_other_items"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SELLER_PROFILELNK",By.id("com.ebay.mobile:id/chevron_icon"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SOLT_BTN",By.id("com.ebay.mobile:id/button_sell_like_this"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SHARE_BTN",By.id("com.ebay.mobile:id/button_share_item"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_REPORT_BTN",By.id("com.ebay.mobile:id/button_report_item"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_PROMPT_OK",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_PROMPT_CANCEL",By.id("android:id/button2"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
	}
	
}
