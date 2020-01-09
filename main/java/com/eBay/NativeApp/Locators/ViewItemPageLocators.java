package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.ViewItemPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class ViewItemPageLocators extends BasePageObject<ViewItemPageComponent>{

	protected ViewItemPageLocators(WebDriver driver) {
		super(driver);
	}
	
	public final By ITM_IMAGE = getLocator("ITM_IMAGE");
	public final By ITM_TITLE = getLocator("ITM_TITLE");
	public final By ITM_SUBTITLE = getLocator("ITM_SUBTITLE");
	public final By ITM_RVWSTARS = getLocator("ITM_RVWSTARS");
	public final By ITM_RVWCOUNT = getLocator("ITM_RVWCOUNT");
	public final By ITM_PRICE = getLocator("ITM_PRICE");
	public final By ITM_ORIGINAL_PRICE = getLocator("ITM_ORIGINAL_PRICE");
	public final By ITM_PRCNT_OFF = getLocator("ITM_PRCNT_OFF");
	public final By ITM_POSTAGE = getLocator("ITM_POSTAGE");
	public final By LOCAL_PICKUP_INFO = getLocator("LOCAL_PICKUP_INFO");
	
	public final By CBT_VI_PRICE = getLocator("CBT_VI_PRICE");
	public final By CBT_SPR_PRICE = getLocator("CBT_SPR_PRICE");
	public final By CBT_SPR_POSTAGE_PRICE = getLocator("CBT_SPR_POSTAGE_PRICE");
	
	public final By ITM_EDD = getLocator("ITM_EDD");
	public final By ITM_HIGHLIGHTS = getLocator("ITM_HIGHLIGHTS");
		public final By ITM_HIGHLIGHT_1 = getLocator("ITM_HIGHLIGHT_1");
		public final By ITM_HIGHLIGHT_2 = getLocator("ITM_HIGHLIGHT_2");
		
	public final By ITM_MSKU_OPTIONS_PANEL = getLocator("ITM_MSKU_OPTIONS_PANEL");
		public final By ITM_MSKU_OPT = getLocator("ITM_MSKU_OPT");
			public final By ITM_MSKU_OPT_DROPDOWN = getLocator("ITM_MSKU_OPT_DROPDOWN");
			public final By ITM_MSKU_OPT_NAME = getLocator("ITM_MSKU_OPT_NAME");
				public final By ITM_MSKU_OPT_DROP_VALUES = getLocator("ITM_MSKU_OPT_DROP_VALUES");
			public final By ITM_MSKU_DONE = getLocator("ITM_MSKU_DONE");
				
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
	
	public final By BO_NEW_OFFERS_LEFT_LBL = getLocator("BO_NEW_OFFERS_LEFT_LBL");
	public final By BO_NEW_ITM_BIN_PRICE_LBL = getLocator("BO_NEW_ITM_BIN_PRICE_LBL");
	public final By BO_NEW_OFFER_PRICE_TXT = getLocator("BO_NEW_OFFER_PRICE_TXT");
	public final By BO_NEW_RVW_OFFER_BTN = getLocator("BO_NEW_RVW_OFFER_BTN");
	public final By BO_NEW_QUANTITY_BTN = getLocator("BO_NEW_QUANTITY_BTN");
		public final By BO_NEW_QTY_SELECTOR = getLocator("BO_NEW_QTY_SELECTOR");
		public final By BO_NEW_QTY_CANCEL = getLocator("BO_NEW_QTY_CANCEL");
		public final By BO_NEW_QTY_OK = getLocator("BO_NEW_QTY_OK");
	public final By BO_NEW_MESSAGE_BTN = getLocator("BO_NEW_MESSAGE_BTN");
		public final By BO_NEW_MESSAGE_TXT = getLocator("BO_NEW_MESSAGE_TXT");
		public final By BO_NEW_MESSAGE_DISCARD = getLocator("BO_NEW_MESSAGE_DISCARD");
		public final By BO_NEW_MESSAGE_SAVE = getLocator("BO_NEW_MESSAGE_SAVE");
	public final By BO_NEW_SUBMIT_OFFER = getLocator("BO_NEW_SUBMIT_OFFER");
	public final By BO_NEW_EDIT_OFFER = getLocator("BO_NEW_EDIT_OFFER");
		
	public final By ITM_ATC_BTN = getLocator("ITM_ATC_BTN");
	public final By ITM_WATCH_BTN = getLocator("ITM_WATCH_BTN");
	public final By ITM_UNWATCH_BTN = getLocator("ITM_UNWATCH_BTN");
		
	public final By SME_PANEL = getLocator("SME_PANEL");
		public final By SME_MOREITEMS = getLocator("SME_MOREITEMS");
		public final By SME_TITLE = getLocator("SME_TITLE");
	
	public final By SEC_ITEM_SPECIFICS = getLocator("SEC_ITEM_SPECIFICS");
	public final By SEC_ABOUT_THIS_ITEM = getLocator("SEC_ABOUT_THIS_ITEM");
	public final By ITM_DESCRIPTION_LNK = getLocator("ITM_DESCRIPTION_LNK");
	public final By ITM_PRODUCT_DETAILS = getLocator("ITM_PRODUCT_DETAILS");
	
	public final By SEC_SPR = getLocator("SEC_SPR");
		public final By SEC_SPR_HDR = getLocator("SEC_SPR_HDR");
		public final By ITM_SPR = getLocator("ITM_SPR");
		public final By ITM_CNC_LBL = getLocator("ITM_CNC_LBL");
			public final By ITM_SPR_MORE = getLocator("ITM_SPR_MORE");	
	
	public final By SEC_MORE_LIKE_THIS = getLocator("SEC_MORE_LIKE_THIS");
		public final By ITM_MERCH_IMG = getLocator("ITM_MERCH_IMG");
		public final By ITM_MERCH_TXT = getLocator("ITM_MERCH_TXT");
	
	public final By SEC_ABOUT_THE_SELLER = getLocator("SEC_ABOUT_THE_SELLER");
		public final By SEC_ABOUT_THE_SELLER_HDR = getLocator("SEC_ABOUT_THE_SELLER_HDR");
			public final By ITM_SELLER_MOREITEMS = getLocator("ITM_SELLER_MOREITEMS");
			public final By ITM_SELLER_PROFILELNK = getLocator("ITM_SELLER_PROFILELNK");
	
	public final By SEC_RATINGS_REVIEWS = getLocator("SEC_RATINGS_REVIEWS");
		public final By SEC_RnR_HDR = getLocator("SEC_RnR_HDR");
		public final By RnR_RATINGS_SUMMARY = getLocator("RnR_RATINGS_SUMMARY");
		public final By RnR_ASPECTS_CONTAINER = getLocator("RnR_ASPECTS_CONTAINER");
		public final By RnR_RELEVANT_RVWS = getLocator("RnR_RELEVANT_RVWS");
		public final By RnR_SEE_MORE_REVIEWS = getLocator("RnR_SEE_MORE_REVIEWS");
	
	public final By ITM_SOLT_BTN = getLocator("ITM_SOLT_BTN");
	public final By ITM_SHARE_BTN = getLocator("ITM_SHARE_BTN");
	public final By ITM_REPORT_BTN = getLocator("ITM_REPORT_BTN");
		
	public final By ITM_GOOGLE_TXT_ADS = getLocator("ITM_GOOGLE_TXT_ADS");
	public final By ITM_BANNER_AD = getLocator("ITM_BANNER_AD");
	
	/*=====================================================================*/
	
	public final By SPR_ITM_HDR_PANEL = getLocator("SPR_ITM_HDR_PANEL");
		public final By SPR_ITM_IMG = getLocator("SPR_ITM_IMG");
		public final By SPR_ITM_TITLE = getLocator("SPR_ITM_TITLE");
		public final By SPR_ITM_PRICES = getLocator("SPR_ITM_PRICES");
	public final By SPR_POSTAGE_TITLE = getLocator("SPR_POSTAGE_TITLE");
	public final By SPR_POSTAGE_DETAILS = getLocator("SPR_POSTAGE_DETAILS");
	public final By SPR_RETURNS_TITLE = getLocator("SPR_RETURNS_TITLE");
	public final By SPR_RETURNS_DETAILS = getLocator("SPR_RETURNS_DETAILS");
	public final By SPR_PAYMENTS_TITLE = getLocator("SPR_PAYMENTS_TITLE");
	public final By SPR_PAYMENTS_DETAILS = getLocator("SPR_PAYMENTS_DETAILS");
	public final By SPR_CnC_TITLE = getLocator("SPR_CnC_TITLE");
	public final By SPR_CnC_DETAILS = getLocator("SPR_CnC_DETAILS");
	
	/*=====================================================================*/
	public final By ITM_CONTACT_BTN = getLocator("ITM_CONTACT_BTN");
	public final By ITM_LVFEEDBACK_BTN = getLocator("ITM_LVFEEDBACK_BTN");
	
	public final By ITM_QTY_SELECT = getLocator("ITM_QTY_SELECT");
	public final By ITM_QTY_REVIEW = getLocator("ITM_QTY_REVIEW");
	
	public final By UPGRADE_PROMPT_OK = getLocator("UPGRADE_PROMPT_OK");
	public final By UPGRADE_PROMPT_CANCEL = getLocator("UPGRADE_PROMPT_CANCEL");
	
	/*=====================================================================*/
	
	public final By SELLER_VIP_PAGE_HDR = getLocator("SELLER_VIP_PAGE_HDR");
	public final By SELLER_VIP_STATS = getLocator("SELLER_VIP_STATS");
	public final By SELLER_VIP_STAT_KEY = getLocator("SELLER_VIP_STAT_KEY");
	
	public final By SELLER_REVISE_LISTING = getLocator("SELLER_REVISE_LISTING");
	public final By SELLER_END_LISTING = getLocator("SELLER_END_LISTING");
	public final By SELLER_SELL_SIMILAR = getLocator("SELLER_SELL_SIMILAR");
	public final By SELLER_END_REASONS = getLocator("SELLER_END_REASONS");
	public final By SELLER_RELIST_LISTING = getLocator("SELLER_RELIST_LISTING");
	public final By SELLER_REVIEW_OFFERS = getLocator("SELLER_REVIEW_OFFERS");
	
	public final By SELLER_SEND_PAY_REMINDER = getLocator("SELLER_SEND_PAY_REMINDER");
	public final By SELLER_MARK_AS_PAID = getLocator("SELLER_MARK_AS_PAID");
	public final By SELLER_MARK_POSTED = getLocator("SELLER_MARK_POSTED");
	public final By SELLER_TRACK_PACKAGE = getLocator("SELLER_TRACK_PACKAGE");
		public final By SELLER_ADD_TRACKINGINFO = getLocator("SELLER_ADD_TRACKINGINFO");
			public final By SELLER_TRACKING_ID_TXT = getLocator("SELLER_TRACKING_ID_TXT");
			public final By SELLER_TRACKING_CARRIER_TXT = getLocator("SELLER_TRACKING_CARRIER_TXT");
			public final By SELLER_TRACKING_SAVE = getLocator("SELLER_TRACKING_SAVE");
	
	/*=====================================================================*/
	/*PRODUCT RELATED PAGES*/ /*- Moved to New Locator Class*/ 
	/*=====================================================================*/
	/*public final By PRP_MINI_IMG = getLocator("PRP_MINI_IMG");
	public final By PRP_MINI_TITLE = getLocator("PRP_MINI_TITLE");
	public final By PRP_CHANGE_OPTIONS_BTN = getLocator("PRP_CHANGE_OPTIONS_BTN");
	public final By PRP_MINI_RATING_BAR = getLocator("PRP_MINI_RATING_BAR");
	public final By PRP_BIG_IMG = getLocator("PRP_BIG_IMG");
	public final By PRP_ITM_PRICE = getLocator("PRP_ITM_PRICE");
	public final By PRP_ITM_POSTAGE_PRICE = getLocator("PRP_ITM_POSTAGE_PRICE");
	public final By PRP_ALL_LISTINGS = getLocator("PRP_ALL_LISTINGS");
	public final By PRP_ABOUT_PRODUCT = getLocator("PRP_ABOUT_PRODUCT");
	public final By PRP_RATING_REVIEWS = getLocator("PRP_RATING_REVIEWS");
	public final By PRP_RELEVANT_REVIEWS = getLocator("PRP_RELEVANT_REVIEWS");
	public final By PRP_ALL_BUTTONS = getLocator("PRP_ALL_BUTTONS");
	public final By PRP_BTN_CTA1 = getLocator("PRP_BTN_CTA1");
	public final By PRP_BTN_CTA2 = getLocator("PRP_BTN_CTA2");*/
	
	/*=====================================================================*/
	/*RATINGS AND REVIEWS PAGE*/
	/*=====================================================================*/
	public final By PRVW_RATINGS_HDR = getLocator("PRVW_RATINGS_HDR");
	public final By PRVW_HISTOGRAM_CONTAINER = getLocator("PRVW_HISTOGRAM_CONTAINER");
	public final By PRVW_RATING_SUMMARY_CONTAINER = getLocator("PRVW_RATING_SUMMARY_CONTAINER");
		public final By PRVW_RATING_1STAR = getLocator("PRVW_RATING_1STAR");
		public final By PRVW_RATING_2STAR = getLocator("PRVW_RATING_2STAR");
		public final By PRVW_RATING_3STAR = getLocator("PRVW_RATING_3STAR");
		public final By PRVW_RATING_4STAR = getLocator("PRVW_RATING_4STAR");
		public final By PRVW_RATING_5STAR = getLocator("PRVW_RATING_5STAR");
	public final By PRVW_ASPECTS_CONTAINER = getLocator("PRVW_ASPECTS_CONTAINER");
	public final By PRVW_WRITE_REVIEW_CONTAINER = getLocator("PRVW_WRITE_REVIEW_CONTAINER");
		public final By PRVW_WRITE_REVIEW_BTN = getLocator("PRVW_WRITE_REVIEW_BTN");
	public final By PRVW_SORT_BTN = getLocator("PRVW_SORT_BTN");
		public final By PRVW_SORT_OPT_MOSTRELEVANT = getLocator("PRVW_SORT_OPT_MOSTRELEVANT");
		public final By PRVW_SORT_OPT_MOSTRECENT = getLocator("PRVW_SORT_OPT_MOSTRECENT");
		public final By PRVW_SORT_OPT_RATE_HIGHESTFIRST = getLocator("PRVW_SORT_OPT_RATE_HIGHESTFIRST");
		public final By PRVW_SORT_OPT_RATE_LOWESTFIRST = getLocator("PRVW_SORT_OPT_RATE_LOWESTFIRST");
	public final By PRVW_FILTER_COND_DROPDWN = getLocator("PRVW_FILTER_COND_DROPDWN");
	public final By PRVW_FILTER_COND_ALL = getLocator("PRVW_FILTER_COND_ALL");
	public final By PRVW_FILTER_COND_NEW = getLocator("PRVW_FILTER_COND_NEW");
	public final By PRVW_FILTER_COND_PREOWNED = getLocator("PRVW_FILTER_COND_PREOWNED");
	public final By PRVW_SRCH_REVIEWS = getLocator("PRVW_SRCH_REVIEWS");
	public final By PRVW_WAR_STAR_HDR = getLocator("PRVW_WAR_STAR_HDR");
	public final By PRVW_WAR_STARS = getLocator("PRVW_WAR_STARS");
	public final By PRVW_WAR_ASPECTS = getLocator("PRVW_WAR_ASPECTS");
	public final By PRVW_WAR_RVW_TITLE = getLocator("PRVW_WAR_RVW_TITLE");
	public final By PRVW_WAR_RVW_DESC = getLocator("PRVW_WAR_RVW_DESC");
	public final By PRVW_WAR_RVW_ADD_PHOTOS = getLocator("PRVW_WAR_RVW_ADD_PHOTOS");
	public final By PRVW_WAR_CANCEL_BTN = getLocator("PRVW_WAR_CANCEL_BTN");
	public final By PRVW_WAR_SUBMIT_BTN = getLocator("PRVW_WAR_SUBMIT_BTN");
	
	public final By eGD_TEXT_ATF=getLocator("eGD_TEXT_ATF");
	public final By eGD_TEXT_BTF=getLocator("eGD_TEXT_BTF");
	
	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_VIP_PAGE_HDR",By.id("com.ebay.mobile:id/header"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_VIP_STATS",By.xpath("//*[contains(@resource-id, 'stat_layout') or contains(@resource-id, 'stats_card')]"));	//com.ebay.mobile:id/stat_layout
			setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_VIP_STAT_KEY",By.id("com.ebay.mobile:id/stat_key"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_REVISE_LISTING",By.id("com.ebay.mobile:id/button_revise_listing"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_END_LISTING",By.id("com.ebay.mobile:id/button_end_listing"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_SELL_SIMILAR",By.id("com.ebay.mobile:id/button_sell_similar"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_END_REASONS",By.id("android:id/text1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_RELIST_LISTING",By.id("com.ebay.mobile:id/button_relist_item"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_SEND_PAY_REMINDER",By.id("com.ebay.mobile:id/button_send_reminder"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_MARK_AS_PAID",By.id("com.ebay.mobile:id/button_mark_paid"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_MARK_POSTED",By.id("com.ebay.mobile:id/button_mark_shipped"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_TRACK_PACKAGE",By.id("com.ebay.mobile:id/button_track_package"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_ADD_TRACKINGINFO",By.id("com.ebay.mobile:id/button_add_tracking_details"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_TRACKING_ID_TXT",By.id("com.ebay.mobile:id/tracking_number_edit_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_TRACKING_CARRIER_TXT",By.id("com.ebay.mobile:id/tracking_carrier_edit_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_TRACKING_SAVE",By.id("com.ebay.mobile:id/tracking_dialog_save_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_REVIEW_OFFERS",By.xpath("//*[@resource-id='com.ebay.mobile:id/button_review_offer' or @resource-id='com.ebay.mobile:id/button_view_offers']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "LOCAL_PICKUP_SPR",By.id("com.ebay.mobile:id/view_item_shipping_section"));
			setLocator(LocatorType.ANDROID_LOCATOR, "LOCAL_PICKUP_SPR_LBL",By.id("com.ebay.mobile:id/stat_value"));
		
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_IMAGE",By.id("com.ebay.mobile:id/imageview_image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_TITLE",By.id("com.ebay.mobile:id/textview_item_name"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SUBTITLE",By.id("com.ebay.mobile:id/item_subtitle_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_POSTAGE",By.id("com.ebay.mobile:id/shipping_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_EDD",By.id("com.ebay.mobile:id/estimated_delivery_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LOCAL_PICKUP_INFO",By.id("com.ebay.mobile:id/type_info"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_HIGHLIGHTS",By.id("com.ebay.mobile:id/highlights_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_HIGHLIGHT_1",By.id("com.ebay.mobile:id/highlight1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_HIGHLIGHT_2",By.id("com.ebay.mobile:id/highlight2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MSKU_OPTIONS_PANEL",By.id("com.ebay.mobile:id/options"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MSKU_OPT",By.id("com.ebay.mobile:id/selection_option_row"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MSKU_OPT_DROPDOWN",By.id("com.ebay.mobile:id/spinner_selection_option"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MSKU_OPT_NAME",By.id("com.ebay.mobile:id/textview_selection_option_title"));
					setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MSKU_OPT_DROP_VALUES",By.id("com.ebay.mobile:id/text"));
					setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MSKU_DONE",By.xpath("//*[@resource-id='com.ebay.mobile:id/done_button' or @resource-id='com.ebay.mobile:id/button_watch_buybar']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_RVWSTARS",By.xpath("//*[@resource-id='com.ebay.mobile:id/reviews_rating' or @resource-id='com.ebay.mobile:id/rating_bar']"));
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
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_OFFERPRICE_TXT",By.id("com.ebay.mobile:id/view_item_offer_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_OFFERQTY_TXT",By.id("com.ebay.mobile:id/create_offer_quantity"));//By.id(android:id/text1)
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_REVIEWOFFER_BTN",By.id("com.ebay.mobile:id/review_offer_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SUBMIT_OFFER",By.xpath("//android.widget.Button[@text='SUBMIT OFFER']"));    //By.id("com.ebay.mobile:id/offer_submit_offer_button"));
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
			setLocator(LocatorType.ANDROID_LOCATOR, "SME_TITLE",By.id("com.ebay.mobile:id/seller_offer_caption"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_BIDDING",By.id("//android.widget.TextView[@text='Bidding']"));
		
		/*ITEM SPECIFICS SECTION*/
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_ITEM_SPECIFICS",By.id("com.ebay.mobile:id/item_specifics_layout"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_ABOUT_THIS_ITEM",By.id("com.ebay.mobile:id/about_this_item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_DESCRIPTION_LNK",By.id("com.ebay.mobile:id/description_snippet_readmore"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PRODUCT_DETAILS",By.id("com.ebay.mobile:id/button_product_details"));
		
		/*POSTAGE RETURNS PEYMENTS SECTION*/
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_SPR",By.id("com.ebay.mobile:id/button_shipping_returns_payments"));	
			setLocator(LocatorType.ANDROID_LOCATOR, "SEC_SPR_HDR",By.id("com.ebay.mobile:id/spr_fragment_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SPR",By.id("com.ebay.mobile:id/spr_fragment_expando_layout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ITM_CNC_LBL",By.xpath("//android.widget.TextView[contains(@text,'Click & Collect')]"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SPR_MORE",By.id("com.ebay.mobile:id/chevron_icon"));
		
		/*MORE LIKE THIS SECTION*/
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_MORE_LIKE_THIS",By.xpath("//android.widget.TextView[@text='More like this']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MERCH_IMG",By.id("com.ebay.mobile:id/merch_image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_MERCH_TXT",By.id("com.ebay.mobile:id/merch_cell"));
		
		/*ABOUT THE SELLER*/
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_ABOUT_THE_SELLER",By.id("com.ebay.mobile:id/button_seller_name"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_ABOUT_THE_SELLER_HDR",By.xpath("//android.widget.TextView[@text='About the seller']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SELLER_MOREITEMS",By.id("com.ebay.mobile:id/button_other_items"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SELLER_PROFILELNK",By.id("com.ebay.mobile:id/seller_username"));
		
		/*RATINGS REVIEWS SECTION*/
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_RATINGS_REVIEWS",By.id("com.ebay.mobile:id/product_review_summary"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEC_RnR_HDR",By.id("com.ebay.mobile:id/ratings_reviews_card_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RnR_RATINGS_SUMMARY",By.id("com.ebay.mobile:id/rating_summary_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RnR_ASPECTS_CONTAINER",By.id("com.ebay.mobile:id/aspects_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RnR_RELEVANT_RVWS",By.id("com.ebay.mobile:id/relevant_reviews_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RnR_SEE_MORE_REVIEWS",By.id("com.ebay.mobile:id/button_more_reviews"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		/*PRODUCT REVIEWS Page*/
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_RATINGS_HDR",By.id("com.ebay.mobile:id/ratings"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_HISTOGRAM_CONTAINER",By.id("com.ebay.mobile:id/histogram_content"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_RATING_SUMMARY_CONTAINER",By.id("com.ebay.mobile:id/rating_summary_container"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_RATING_1STAR",By.id("com.ebay.mobile:id/one_star_ratings"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_RATING_2STAR",By.id("com.ebay.mobile:id/two_star_ratings"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_RATING_3STAR",By.id("com.ebay.mobile:id/three_star_ratings"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_RATING_4STAR",By.id("com.ebay.mobile:id/four_star_ratings"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_RATING_5STAR",By.id("com.ebay.mobile:id/five_star_ratings"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_ASPECTS_CONTAINER",By.id("com.ebay.mobile:id/aspects_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WRITE_REVIEW_CONTAINER",By.id("com.ebay.mobile:id/write_review_button_container"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WRITE_REVIEW_BTN",By.id("com.ebay.mobile:id/button_write_review"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_SORT_BTN",By.id("com.ebay.mobile:id/button_sort"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_SORT_OPT_MOSTRELEVANT",By.xpath("//android.widget.CheckedTextView[@text='Most relevant']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_SORT_OPT_MOSTRECENT",By.xpath("//android.widget.CheckedTextView[@text='Most recent']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_SORT_OPT_RATE_HIGHESTFIRST",By.xpath("//android.widget.CheckedTextView[@text='Ratings: highest first']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_SORT_OPT_RATE_LOWESTFIRST",By.xpath("//android.widget.CheckedTextView[@text='Ratings: lowest first']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_FILTER_COND_DROPDWN",By.id("com.ebay.mobile:id/button_sort_by_condition"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_FILTER_COND_ALL",By.xpath("//android.widget.CheckedTextView[@text='All']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_FILTER_COND_NEW",By.xpath("//android.widget.CheckedTextView[@text='New']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_FILTER_COND_PREOWNED",By.xpath("//android.widget.CheckedTextView[@text='Pre-owned']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_SRCH_REVIEWS",By.id("com.ebay.mobile:id/search_field"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WAR_STAR_HDR",By.id("com.ebay.mobile:id/star_rating_heading"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WAR_STARS",By.id("com.ebay.mobile:id/rating_stars"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WAR_ASPECTS",By.id("com.ebay.mobile:id/aspects_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WAR_RVW_TITLE",By.id("com.ebay.mobile:id/review_title_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WAR_RVW_DESC",By.id("com.ebay.mobile:id/review_description_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WAR_RVW_ADD_PHOTOS",By.id("com.ebay.mobile:id/review_add_photos"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WAR_CANCEL_BTN",By.id("com.ebay.mobile:id/button_cancel"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRVW_WAR_SUBMIT_BTN",By.id("com.ebay.mobile:id/button_submit"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		/*POSTAGE RETURNS PEYMENTS Page*/
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_ITM_HDR_PANEL",By.id("com.ebay.mobile:id/item_header_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SPR_ITM_IMG",By.id("com.ebay.mobile:id/item_thumbnail"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SPR_ITM_TITLE",By.id("com.ebay.mobile:id/item_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SPR_ITM_PRICES",By.id("com.ebay.mobile:id/value_layout"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_POSTAGE_TITLE",By.id("com.ebay.mobile:id/full_delivery_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_POSTAGE_DETAILS",By.id("com.ebay.mobile:id/full_delivery_card"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_RETURNS_TITLE",By.id("com.ebay.mobile:id/full_returns_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_RETURNS_DETAILS",By.id("com.ebay.mobile:id/full_returns_card"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_PAYMENTS_TITLE",By.id("com.ebay.mobile:id/full_payments_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_PAYMENTS_DETAILS",By.id("com.ebay.mobile:id/full_payments_card"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_CnC_TITLE",By.id("com.ebay.mobile:id/full_pickup_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPR_CnC_DETAILS",By.id("com.ebay.mobile:id/full_pickup_card"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SOLT_BTN",By.id("com.ebay.mobile:id/button_sell_like_this"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_SHARE_BTN",By.id("com.ebay.mobile:id/button_share_item"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_REPORT_BTN",By.id("com.ebay.mobile:id/button_report_item"));
		
		/*ADs*/
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_GOOGLE_TXT_ADS",By.id("com.ebay.mobile:id/google_text_ad_view"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_BANNER_AD",By.xpath("//*[contains(@resource-id, 'com.ebay.mobile:id/ad_container')]"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_PROMPT_OK",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_PROMPT_CANCEL",By.id("android:id/button2"));
		
		/*setLocator(LocatorType.ANDROID_LOCATOR, "PRP_MINI_IMG",By.id("com.ebay.mobile:id/imageview_item_image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_MINI_TITLE",By.id("com.ebay.mobile:id/textview_item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_CHANGE_OPTIONS_BTN",By.id("com.ebay.mobile:id/button_change_aspects"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_MINI_RATING_BAR",By.id("com.ebay.mobile:id/rating_bar"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_BIG_IMG",By.id("com.ebay.mobile:id/prp_mtp_image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ITM_PRICE",By.id("com.ebay.mobile:id/price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ITM_POSTAGE_PRICE",By.id("com.ebay.mobile:id/shipping"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ALL_LISTINGS",By.xpath("//android.widget.TextView[@text='All listings for this product']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ABOUT_PRODUCT",By.xpath("//android.widget.TextView[@text='About this product']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_RATING_REVIEWS",By.xpath("//android.widget.TextView[@text='Ratings and reviews']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_RELEVANT_REVIEWS",By.xpath("//android.widget.TextView[@text='Most relevant reviews']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ALL_BUTTONS",By.id("//android.widget.Button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_BTN_CTA1",By.id("com.ebay.mobile:id/prp_primary_button_0"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_BTN_CTA2",By.id("com.ebay.mobile:id/prp_secondary_button_0"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));*/
		
		setLocator(LocatorType.ANDROID_LOCATOR, "CBT_VI_PRICE",By.id("com.ebay.mobile:id/converted_prices_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CBT_SPR_PRICE",By.id("com.ebay.mobile:id/converted_price_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CBT_SPR_POSTAGE_PRICE",By.id("com.ebay.mobile:id/converted_shipping_textview"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_OFFERS_LEFT_LBL",By.id("com.ebay.mobile:id/offer_header_offers_left"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_ITM_BIN_PRICE_LBL",By.id("com.ebay.mobile:id/offer_header_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_OFFER_PRICE_TXT",By.id("com.ebay.mobile:id/view_item_offer_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_RVW_OFFER_BTN",By.id("com.ebay.mobile:id/review_offer_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_QUANTITY_BTN",By.id("com.ebay.mobile:id/view_item_offer_quantity_button"));
			setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_QTY_SELECTOR",By.id("android:id/numberpicker_input"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_MESSAGE_BTN",By.id("com.ebay.mobile:id/view_item_offer_add_message_button"));
			setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_MESSAGE_TXT",By.id("com.ebay.mobile:id/offer_message_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_MESSAGE_DISCARD",By.id("com.ebay.mobile:id/offer_button_close"));
			setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_MESSAGE_SAVE",By.id("com.ebay.mobile:id/offer_message_save"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_QTY_CANCEL",By.id("android:id/button2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_QTY_OK",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_SUBMIT_OFFER",By.id("com.ebay.mobile:id/submit_offer_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BO_NEW_EDIT_OFFER",By.id("com.ebay.mobile:id/edit_offer_button"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "eGD_TEXT_ATF",By.id("com.ebay.mobile:id/guaranteed_by_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "eGD_TEXT_BTF",By.xpath("//android.widget.TextView[contains(@text, 'Guaranteed by')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		
	}

}
