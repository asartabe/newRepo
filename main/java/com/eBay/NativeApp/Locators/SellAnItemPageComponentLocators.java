package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SellAnItemPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SellAnItemPageComponentLocators extends BasePageObject<SellAnItemPageComponent>{

	protected SellAnItemPageComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By CATALOG_OPTIONS_HDR = getLocator("CATALOG_OPTIONS_HDR");
		public final By SEE_YOUR_PROD_TITLE = getLocator("SEE_YOUR_PROD_TITLE");
	public final By CATALOG_PROD = getLocator("CATALOG_PROD");
		public final By CATALOG_PROD_IMG = getLocator("CATALOG_PROD_IMG");
		public final By CATALOG_PROD_TITLE = getLocator("CATALOG_PROD_TITLE");
	
	public final By CATALOG_CAT_CHNG_ALERT_TITLE = getLocator("CATALOG_CAT_CHNG_ALERT_TITLE");
	public final By CATALOG_CAT_CHNG_ALERT_CONTENT = getLocator("CATALOG_CAT_CHNG_ALERT_CONTENT");
	public final By CATALOG_CAT_CHNG_ALERT_CANCEL = getLocator("CATALOG_CAT_CHNG_ALERT_CANCEL");
	public final By CATALOG_CAT_CHNG_ALERT_OK = getLocator("CATALOG_CAT_CHNG_ALERT_OK");
		
	public final By NAVIGATE_BACK = getLocator("NAVIGATE_BACK");
	public final By ITEM_TITLE = getLocator("ITEM_TITLE");
	public final By LISTING_HEADER = getLocator("LISTING_HEADER");
	public final By CAT_LVL_1 = getLocator("CAT_LVL_1");
	public final By CAT_LVL_2 = getLocator("CAT_LVL_2");
	public final By CAT_LVL_3 = getLocator("CAT_LVL_3");
	public final By CAT_LVL_4 = getLocator("CAT_LVL_4");
	public final By ITEM_TO_LIST = getLocator("ITEM_TO_LIST");
	public final By SAVE_LISTING = getLocator("SAVE_LISTING");
	public final By CONTINUE_LISTING = getLocator("CONTINUE_LISTING");

	public final By ITEM_TITLE_CELL = getLocator("ITEM_TITLE_CELL");
		public final By ITEM_TITLE_EDIT = getLocator("ITEM_TITLE_EDIT");
	public final By ITEM_PHOTOS_CELL = getLocator("ITEM_PHOTOS_CELL");
	public final By ITEM_UPLOAD_PHOTO = getLocator("ITEM_UPLOAD_PHOTO");
		public final By PHOTO_FROM_GALLERY = getLocator("PHOTO_FROM_GALLERY");
		public final By ALLOW_FROM_GALLERY = getLocator("ALLOW_FROM_GALLERY");
		public final By PHOTO_OPTION_IMAGES = getLocator("PHOTO_OPTION_IMAGES");
		public final By PHOTO_CAMERA_PHOTOS = getLocator("PHOTO_CAMERA_PHOTOS");
		public final By PHOTO_TO_UPLOAD = getLocator("PHOTO_TO_UPLOAD");
		public final By PHOTO_UPLOAD_BTN = getLocator("PHOTO_UPLOAD_BTN");
		public final By PHOTO_FROM_CAMERA = getLocator("PHOTO_FROM_CAMERA");
		public final By PHOTO_TAKE_PIC = getLocator("PHOTO_TAKE_PIC");
		public final By PHOTO_CONFIRM_PIC = getLocator("PHOTO_CONFIRM_PIC");
		
	public final By ITEM_CONDITION_CELL = getLocator("ITEM_CONDITION_CELL");
		public final By CONDITION_VALUE = getLocator("CONDITION_VALUE");
		public final By CONDITION_DESC = getLocator("CONDITION_DESC");
	
	public final By ITEM_CATEGORY_CELL = getLocator("ITEM_CATEGORY_CELL");
		public final By CAT_EDIT = getLocator("CAT_EDIT");
		
	public final By ITEM_DESCRIPTION_CELL = getLocator("ITEM_DESCRIPTION_CELL");
		public final By DESC_DETAILS = getLocator("DESC_DETAILS");
	
	public final By ITEM_PRICEFORMAT_CELL = getLocator("ITEM_PRICEFORMAT_CELL");
	public final By LISTINGTYPE_AUCTION = getLocator("LISTINGTYPE_AUCTION");
		public final By PRICE_AUCTION = getLocator("PRICE_AUCTION");
		public final By PRICE_MORE_OPTIONS = getLocator("PRICE_MORE_OPTIONS");
	public final By LISTINGTYPE_BUYITNOW = getLocator("LISTINGTYPE_BUYITNOW");
		public final By PRICE_BUYITNOW = getLocator("PRICE_BUYITNOW");
		public final By PRICE_QUANTITY = getLocator("PRICE_QUANTITY");
		public final By PRICE_BO_SWITCH = getLocator("PRICE_BO_SWITCH");
		public final By PRICE_BO_AUTOACCEPT = getLocator("PRICE_BO_AUTOACCEPT");
		public final By PRICE_BO_AUTODECLINE = getLocator("PRICE_BO_AUTODECLINE");
			public final By PRICE_BIN_WITHAUCTION = getLocator("PRICE_BIN_WITHAUCTION");
			public final By PRICE_DURATION_SEL = getLocator("PRICE_DURATION_SEL");
			public final By PRICE_DURATION_OPTION = getLocator("PRICE_DURATION_OPTION");
			public final By PRICE_SCHEDULE_SEL = getLocator("PRICE_SCHEDULE_SEL");
				public final By PRICE_SCHEDULE_IMMEDIATE = getLocator("PRICE_SCHEDULE_IMMEDIATE");
				public final By PRICE_SCHEDULE_LATER = getLocator("PRICE_SCHEDULE_LATER");
					public final By PRICE_SCHEDULE_LATER_DATE_SEL = getLocator("PRICE_SCHEDULE_LATER_DATE_SEL");
					public final By PRICE_SCHEDULE_LATER_DATE_VALUE = getLocator("PRICE_SCHEDULE_LATER_DATE_VALUE");
					public final By PRICE_SCHEDULE_LATER_DATEVAL_OK = getLocator("PRICE_SCHEDULE_LATER_DATEVAL_OK");
	
	public final By ITEM_POSTAGE_CELL = getLocator("ITEM_POSTAGE_CELL");
		public final By DEFAULT_POSTAGE_ADDED = getLocator("DEFAULT_POSTAGE_ADDED");
		public final By POSTAGE_LOCAL_PICKUP_SWITCH = getLocator("POSTAGE_LOCAL_PICKUP_SWITCH");
		public final By POSTAGE_TYPE_SEL = getLocator("POSTAGE_TYPE_SEL");
			public final By POSTAGE_TYPE_CALC = getLocator("POSTAGE_TYPE_CALC");
			public final By POSTAGE_TYPE_FLAT = getLocator("POSTAGE_TYPE_FLAT");
			public final By POSTAGE_TYPE_LOCALPICKUPONLY = getLocator("POSTAGE_TYPE_LOCALPICKUPONLY");
		public final By POSTAGE_ADD_SRVC = getLocator("POSTAGE_ADD_SRVC");
			public final By POSTAGE_SRVC_PARENT = getLocator("POSTAGE_SRVC_PARENT");
			public final By POSTAGE_SRVC_CHILD_OPTIONS = getLocator("POSTAGE_SRVC_CHILD_OPTIONS");
			public final By POSTAGE_FLAT_SRVC_PRICE = getLocator("POSTAGE_FLAT_SRVC_PRICE");
			public final By POSTAGE_SRVC_SAVE = getLocator("POSTAGE_SRVC_SAVE");
		public final By POSTAGE_PKG_INFO = getLocator("POSTAGE_PKG_INFO");
			public final By POSTAGE_PKG_LENGTH = getLocator("POSTAGE_PKG_LENGTH");
			public final By POSTAGE_PKG_WIDTH = getLocator("POSTAGE_PKG_WIDTH");
			public final By POSTAGE_PKG_HEIGHT = getLocator("POSTAGE_PKG_HEIGHT");
			public final By POSTAGE_PKG_WGT_KGS = getLocator("POSTAGE_PKG_WGT_KGS");
			public final By POSTAGE_PKG_WGT_GMS = getLocator("POSTAGE_PKG_WGT_GMS");
			public final By POSTAGE_PKG_SAVE = getLocator("POSTAGE_PKG_SAVE");
		public final By POSTAGE_SHOW_INTL_OPTIONS = getLocator("POSTAGE_SHOW_INTL_OPTIONS");
		public final By POSTAGE_INTL_TYPE = getLocator("POSTAGE_INTL_TYPE");
		public final By POSTAGE_INTL_ADD = getLocator("POSTAGE_INTL_ADD");
		public final By POSTAGE_INTL_SRVC_PARENT = getLocator("POSTAGE_INTL_SRVC_PARENT");
		public final By POSTAGE_INTL_POST_TO = getLocator("POSTAGE_INTL_POST_TO");
		public final By POSTAGE_INTL_POSTTO_WORLD = getLocator("POSTAGE_INTL_POSTTO_WORLD");
		public final By POSTAGE_INTL_POSTTO_SAVE = getLocator("POSTAGE_INTL_POSTTO_SAVE");
	
	public final By ITEM_PAYMENT_CELL = getLocator("ITEM_PAYMENT_CELL");
		public final By PAYMENT_PAYPAL_EMAIL = getLocator("PAYMENT_PAYPAL_EMAIL");
		public final By PAYMENT_PAYPAL_MORE_OPTIONS = getLocator("PAYMENT_PAYPAL_MORE_OPTIONS");
			public final By PAYMENT_PAYPAL_IMMEDIATE = getLocator("PAYMENT_PAYPAL_IMMEDIATE");
		public final By PAYMENT_RETURNS_SWITCH = getLocator("PAYMENT_RETURNS_SWITCH");
			public final By PAYMENT_RETURNS_WITHIN_DROP = getLocator("PAYMENT_RETURNS_WITHIN_DROP");
			public final By PAYMENT_RETURNS_GIVEN_AS = getLocator("PAYMENT_RETURNS_GIVEN_AS");
			public final By PAYMENT_RETURN_PAID_BY = getLocator("PAYMENT_RETURN_PAID_BY");
			public final By PAYMENT_RETURN_OPTIONS = getLocator("PAYMENT_RETURN_OPTIONS");
	
	public final By SUBMIT_LISTING_BTN = getLocator("SUBMIT_LISTING_BTN");
	public final By PREVIEW_LISTING_BTN = getLocator("PREVIEW_LISTING_BTN");
	public final By VIEW_PUBLISHED_LISTING = getLocator("VIEW_PUBLISHED_LISTING");
		
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "CATALOG_OPTIONS_HDR",By.id("com.ebay.mobile:id/content_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SEE_YOUR_PROD_TITLE",By.xpath("//android.widget.TextView[@text='See your product?']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CATALOG_PROD",By.id("com.ebay.mobile:id/result_parent"));
			setLocator(LocatorType.ANDROID_LOCATOR, "CATALOG_PROD_IMG",By.id("com.ebay.mobile:id/product_image"));
			setLocator(LocatorType.ANDROID_LOCATOR, "CATALOG_PROD_TITLE",By.id("com.ebay.mobile:id/product_text"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "CATALOG_CAT_CHNG_ALERT_TITLE",By.id("com.ebay.mobile:id/alertTitle"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CATALOG_CAT_CHNG_ALERT_CONTENT",By.id("android:id/message"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CATALOG_CAT_CHNG_ALERT_CANCEL",By.id("android:id/button2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CATALOG_CAT_CHNG_ALERT_OK",By.id("android:id/button1"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "NAVIGATE_BACK",By.id("com.ebay.mobile:id/home"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TITLE",By.id("com.ebay.mobile:id/search_src_text"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LISTING_HEADER",By.id("com.ebay.mobile:id/listing_header"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CAT_LVL_1",By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Lots More...' or @text='Everything Else']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CAT_LVL_2",By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Test Auctions']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CAT_LVL_3",By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Attributes']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CAT_LVL_4",By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Attributes1']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TO_LIST",By.id("com.ebay.mobile:id/result_parent"));
		/*setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TO_LIST_CONTINUE",By.id("com.ebay.mobile:id/continueImage"));*/
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVE_LISTING",By.id("com.ebay.mobile:id/button_save"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CONTINUE_LISTING",By.id("com.ebay.mobile:id/button_continue"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TITLE_CELL",By.id("com.ebay.mobile:id/listing_hub_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TITLE_EDIT",By.id("com.ebay.mobile:id/edit_listing_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_PHOTOS_CELL",By.id("com.ebay.mobile:id/listing_hub_photos"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_CATEGORY_CELL",By.id("com.ebay.mobile:id/listing_hub_category"));
			setLocator(LocatorType.ANDROID_LOCATOR, "CAT_EDIT",By.id("com.ebay.mobile:id/edit_category"));
			setLocator(LocatorType.ANDROID_LOCATOR, "CAT_TREE",By.id("com.ebay.mobile:id/category_tree_card"));
				setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			
		/*PHOTO_UPLOAD*/
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_UPLOAD_PHOTO",By.id("com.ebay.mobile:id/photo_manager_photo_image"));
			/*VIA_EXISTING_IMG*/
			setLocator(LocatorType.ANDROID_LOCATOR, "PHOTO_FROM_GALLERY",By.xpath("//android.widget.TextView[@text='Select from gallery']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ALLOW_FROM_GALLERY",By.id("com.android.packageinstaller:id/permission_allow_button"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PHOTO_OPTION_IMAGES",By.id("//android.widget.TextView[@text='Images']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PHOTO_CAMERA_PHOTOS",By.id("com.android.documentsui:id/icon_thumb"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PHOTO_TO_UPLOAD",By.id("com.android.documentsui:id/icon_thumb"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PHOTO_UPLOAD_BTN",By.id("com.ebay.mobile:id/button_upload"));
			/*VIA_CAMERA*/
			setLocator(LocatorType.ANDROID_LOCATOR, "PHOTO_FROM_CAMERA",By.xpath("//android.widget.TextView[@text='Take a new photo']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PHOTO_TAKE_PIC",By.id("com.android.camera2:id/shutter_button"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PHOTO_CONFIRM_PIC",By.id("com.android.camera2:id/done_button"));
			
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_CONDITION_CELL",By.id("com.ebay.mobile:id/listing_hub_condition"));
			setLocator(LocatorType.ANDROID_LOCATOR, "CONDITION_VALUE",By.xpath("//android.widget.CheckedTextView[@text='Used' or @text='Good']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "CONDITION_DESC",By.id("com.ebay.mobile:id/condition_description"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_DESCRIPTION_CELL",By.id("com.ebay.mobile:id/listing_hub_description"));
			setLocator(LocatorType.ANDROID_LOCATOR, "DESC_DETAILS",By.id("com.ebay.mobile:id/listing_description"));
			
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_PRICEFORMAT_CELL",By.id("com.ebay.mobile:id/listing_hub_priceformat"));
			setLocator(LocatorType.ANDROID_LOCATOR, "LISTINGTYPE_AUCTION",By.xpath("//android.widget.CheckedTextView[@text='Auction' or @text='auction']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_AUCTION",By.id("com.ebay.mobile:id/auction_start_price"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_MORE_OPTIONS",By.id("com.ebay.mobile:id/more_options_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_BIN_WITHAUCTION",By.id("com.ebay.mobile:id/buy_it_now"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_DURATION_SEL",By.id("com.ebay.mobile:id/spinner_duration"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_DURATION_OPTION",By.xpath("//android.widget.CheckedTextView[@text='1 day']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_SCHEDULE_SEL",By.id("com.ebay.mobile:id/spinner_schedule"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_SCHEDULE_IMMEDIATE",By.xpath("//android.widget.CheckedTextView[@text='Start listing immediately']"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_SCHEDULE_LATER",By.xpath("//android.widget.CheckedTextView[@text='Schedule start time']"));
					setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_SCHEDULE_LATER_DATE_SEL",By.id("com.ebay.mobile:id/button_date_schedule"));
					setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_SCHEDULE_LATER_DATE_VALUE",By.xpath("//android.view.View"));	//[@index='28']
					setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_SCHEDULE_LATER_DATEVAL_OK",By.id("android:id/button1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			
		setLocator(LocatorType.ANDROID_LOCATOR, "LISTINGTYPE_BUYITNOW",By.xpath("//android.widget.CheckedTextView[@text='Fixed price' or @text='fixed price' or @text='Fixed Price']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_BUYITNOW",By.id("com.ebay.mobile:id/fixed_price"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_QUANTITY",By.id("com.ebay.mobile:id/quantity"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_BO_SWITCH",By.id("com.ebay.mobile:id/allow_best_offer"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_BO_AUTOACCEPT",By.id("com.ebay.mobile:id/automatically_accept_value"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_BO_AUTODECLINE",By.id("com.ebay.mobile:id/automatically_decline_value"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			
			
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_POSTAGE_CELL",By.id("com.ebay.mobile:id/listing_hub_all_shipping"));
		setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_ADD_SRVC",By.id("com.ebay.mobile:id/sell_add_first_shipping_service"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_SRVC_PARENT",By.xpath("//android.widget.TextView[@text='eBay postage services' or @text='Ebay postage services' or contains(@text, 'Local courier')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_SRVC_CHILD_OPTIONS",By.id("com.ebay.mobile:id/label"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_FLAT_SRVC_PRICE",By.id("com.ebay.mobile:id/shipping_price"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_SRVC_SAVE",By.id("android:id/button1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_PKG_INFO",By.id("com.ebay.mobile:id/sell_package_info_display"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_PKG_LENGTH",By.id("com.ebay.mobile:id/package_dim_length"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_PKG_WIDTH",By.id("com.ebay.mobile:id/package_dim_width"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_PKG_HEIGHT",By.id("com.ebay.mobile:id/package_dim_depth"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_PKG_WGT_KGS",By.id("com.ebay.mobile:id/package_weight_major"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_PKG_WGT_GMS",By.id("com.ebay.mobile:id/package_weight_minor"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_PKG_SAVE",By.id("com.ebay.mobile:id/menu_save"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "DEFAULT_POSTAGE_ADDED",By.id("com.ebay.mobile:id/domestic_service"));
		setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_LOCAL_PICKUP_SWITCH",By.id("com.ebay.mobile:id/local_pickup_checkbox"));
		setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_TYPE_SEL",By.id("com.ebay.mobile:id/spinner_domestic_shipping_type"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_TYPE_CALC",By.xpath("//android.widget.CheckedTextView[contains(@text,'Calculated')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_TYPE_FLAT",By.xpath("//android.widget.CheckedTextView[contains(@text,'Flat')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_TYPE_LOCALPICKUPONLY",By.xpath("//android.widget.CheckedTextView[contains(@text,'Local pickup')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_SHOW_INTL_OPTIONS",By.id("com.ebay.mobile:id/more_intl_options"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_INTL_TYPE",By.id("com.ebay.mobile:id/international_shipping_type_row"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_INTL_ADD",By.id("com.ebay.mobile:id/sell_add_intl_shipping_service"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_INTL_SRVC_PARENT",By.xpath("//android.widget.TextView[@text='Economy services']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_INTL_POST_TO",By.id("com.ebay.mobile:id/ships_to"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_INTL_POSTTO_WORLD",By.xpath("//android.widget.CheckedTextView[@text='Worldwide']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_INTL_POSTTO_SAVE",By.id("android:id/button1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_PAYMENT_CELL",By.id("com.ebay.mobile:id/listing_hub_preferences"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_PAYPAL_EMAIL",By.id("com.ebay.mobile:id/edit_paypal_email"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_PAYPAL_MORE_OPTIONS",By.id("com.ebay.mobile:id/more_options_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_PAYPAL_IMMEDIATE",By.id("com.ebay.mobile:id/immediatePaySwitch"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_RETURNS_SWITCH",By.id("com.ebay.mobile:id/return_policy_switch"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_RETURNS_WITHIN_DROP",By.id("com.ebay.mobile:id/label_returns_within_layout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_RETURNS_GIVEN_AS",By.id("com.ebay.mobile:id/label_refund_given_as_layout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_RETURN_PAID_BY",By.id("com.ebay.mobile:id/label_return_shipping_paid_by_layout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_RETURN_OPTIONS",By.id("android:id/text1"));
			
		setLocator(LocatorType.ANDROID_LOCATOR, "SUBMIT_LISTING_BTN",By.id("com.ebay.mobile:id/button_publish"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PREVIEW_LISTING_BTN",By.id("com.ebay.mobile:id/button_preview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "VIEW_PUBLISHED_LISTING",By.id("com.ebay.mobile:id/view_listing"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
	}


}
