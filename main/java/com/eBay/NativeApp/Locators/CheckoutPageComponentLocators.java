package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.CheckoutPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class CheckoutPageComponentLocators extends BasePageObject<CheckoutPageComponent>{

	protected CheckoutPageComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By CONFIRM_AND_PAY_BTN = getLocator("CONFIRM_AND_PAY_BTN");
	public final By SELLER_BLOCK = getLocator("SELLER_BLOCK");
		public final By SELLER_NAME = getLocator("SELLER_NAME");
		public final By SELLER_ITEMS = getLocator("SELLER_ITEMS");
			public final By SELLER_ITEM_DETAILS = getLocator("SELLER_ITEM_DETAILS");
				public final By SELLER_ITEM_DETAILS_IMG = getLocator("SELLER_ITEM_DETAILS_IMG");
				public final By SELLER_ITEM_DETAILS_TITLE = getLocator("SELLER_ITEM_DETAILS_TITLE");
				public final By SELLER_ITEM_DETAILS_PRICE = getLocator("SELLER_ITEM_DETAILS_PRICE");
				public final By SELLER_ITEM_DETAILS_QTY = getLocator("SELLER_ITEM_DETAILS_QTY");
			public final By SELLER_POSTAGE_DETAILS = getLocator("SELLER_POSTAGE_DETAILS");
				public final By SELLER_POSTAGE_DETAILS_TITLE = getLocator("SELLER_POSTAGE_DETAILS_TITLE");
				public final By SELLER_POSTAGE_DETAILS_EST = getLocator("SELLER_POSTAGE_DETAILS_EST");
				public final By SELLER_POSTAGE_DETAILS_POSTNAME = getLocator("SELLER_POSTAGE_DETAILS_POSTNAME");
				public final By SELLER_POSTAGE_DETAILS_POSTCOST = getLocator("SELLER_POSTAGE_DETAILS_POSTCOST");
		public final By CnC_OPTIONS = getLocator("CnC_OPTIONS");
			public final By CnC_STORE = getLocator("CnC_STORE");
			public final By CnC_STORE_SAVE = getLocator("CnC_STORE_SAVE");
			public final By CnC_STORE_SELECTED = getLocator("CnC_STORE_SELECTED");
			public final By CnC_STORE_SELECTED_NAME = getLocator("CnC_STORE_SELECTED_NAME");
		public final By SELLER_SEND_MESSAGE_LINK = getLocator("SELLER_SEND_MESSAGE_LINK");
			public final By MESSAGE_COMPOSE = getLocator("MESSAGE_COMPOSE");
			public final By MESSAGE_SAVE = getLocator("MESSAGE_SAVE");
			
	public final By BUYER_POST_TO_LINK = getLocator("BUYER_POST_TO_LINK");
		public final By BUYER_CURRENT_POSTTO_ADDR = getLocator("BUYER_CURRENT_POSTTO_ADDR");
	
	public final By PAYMENT_LINK = getLocator("PAYMENT_LINK");
		public final By PAYMENT_ADDED_PAYPAL = getLocator("PAYMENT_ADDED_PAYPAL");
		public final By PAYMENT_LNK_PAYPAL = getLocator("PAYMENT_LNK_PAYPAL");
			public final By PAYPAL_LOGIN_FIELDS = getLocator("PAYPAL_LOGIN_FIELDS");
			public final By PAYPAL_LOGIN_BTN = getLocator("PAYPAL_LOGIN_BTN");
		
	public final By PAYMENT_ADD_VOUCHERS = getLocator("PAYMENT_ADD_VOUCHERS");
	
	public final By XO_SUMMARY = getLocator("XO_SUMMARY");
		public final By XO_SUMMARY_LBL = getLocator("XO_SUMMARY_LBL");
		public final By XO_SUMMARY_VAL = getLocator("XO_SUMMARY_VAL");
	public final By XO_TOTAL_LBL = getLocator("XO_TOTAL_LBL");
	public final By XO_TOTAL_VALUE = getLocator("XO_TOTAL_VALUE");
	
	public final By ALERT_DETAILS = getLocator("ALERT_DETAILS");
	public final By ALERT_TXT = getLocator("ALERT_TXT");
	
	public final By SUCCESS_XO_TITLE = getLocator("SUCCESS_XO_TITLE");
	public final By SUCCESS_XO_SUBTITLE = getLocator("SUCCESS_XO_SUBTITLE");
	public final By SUCCESS_XO_PENDING_ITEMS = getLocator("SUCCESS_XO_PENDING_ITEMS");
	public final By SUCCESS_XO_BACKTO_CART = getLocator("SUCCESS_XO_BACKTO_CART");
	
	public final By EGD_TEXT=getLocator("EGD_TEXT");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "CONFIRM_AND_PAY_BTN",By.id("com.ebay.mobile:id/purchase_link"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_BLOCK",By.id("com.ebay.mobile:id/seller_block"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_NAME",By.id("com.ebay.mobile:id/seller_value"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_ITEMS",By.id("com.ebay.mobile:id/seller_items"));
				setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_ITEM_DETAILS",By.id("com.ebay.mobile:id/seller_summary"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_ITEM_DETAILS_IMG",By.id("com.ebay.mobile:id/item_image"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_ITEM_DETAILS_TITLE",By.id("com.ebay.mobile:id/item_title"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_ITEM_DETAILS_PRICE",By.id("com.ebay.mobile:id/item_price"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_ITEM_DETAILS_QTY",By.id("com.ebay.mobile:id/item_qty"));
				setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_POSTAGE_DETAILS",By.id("com.ebay.mobile:id/item_shipping_link"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_POSTAGE_DETAILS_TITLE",By.id("com.ebay.mobile:id/shipping_title"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_POSTAGE_DETAILS_EST",By.id("com.ebay.mobile:id/shipping_delivery"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_POSTAGE_DETAILS_POSTNAME",By.id("com.ebay.mobile:id/shipping_name"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_POSTAGE_DETAILS_POSTCOST",By.id("com.ebay.mobile:id/shipping_cost"));
			setLocator(LocatorType.ANDROID_LOCATOR, "CnC_OPTIONS",By.id("com.ebay.mobile:id/shipping_item_chevron"));
				setLocator(LocatorType.ANDROID_LOCATOR, "CnC_STORE",By.id("com.ebay.mobile:id/store_info"));
				setLocator(LocatorType.ANDROID_LOCATOR, "CnC_STORE_SAVE",By.id("com.ebay.mobile:id/checkout_menu_item_save"));
				setLocator(LocatorType.ANDROID_LOCATOR, "CnC_STORE_SELECTED",By.id("com.ebay.mobile:id/shipping_store_location"));
				setLocator(LocatorType.ANDROID_LOCATOR, "CnC_STORE_SELECTED_NAME",By.xpath("//*[@resource-id='com.ebay.mobile:id/store_info' or @resource-id='com.ebay.mobile:id/address']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_SEND_MESSAGE_LINK",By.id("com.ebay.mobile:id/message_link"));
				setLocator(LocatorType.ANDROID_LOCATOR, "MESSAGE_COMPOSE",By.id("com.ebay.mobile:id/checkout_seller_message"));
				setLocator(LocatorType.ANDROID_LOCATOR, "MESSAGE_SAVE",By.id("com.ebay.mobile:id/checkout_menu_item_done"));
				
		setLocator(LocatorType.ANDROID_LOCATOR, "BUYER_POST_TO_LINK",By.id("com.ebay.mobile:id/ship_to_link"));
			setLocator(LocatorType.ANDROID_LOCATOR, "BUYER_CURRENT_POSTTO_ADDR",By.id("com.ebay.mobile:id/ship_to_content"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_LINK",By.id("com.ebay.mobile:id/payment_link"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_ADDED_PAYPAL",By.id("com.ebay.mobile:id/payment_main_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_LNK_PAYPAL",By.id("com.ebay.mobile:id/payment_method_link"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PAYPAL_LOGIN_FIELDS",By.xpath("//android.widget.EditText"));
				setLocator(LocatorType.ANDROID_LOCATOR, "PAYPAL_LOGIN_BTN",By.xpath("//android.widget.Button[contains(@content-desc, 'Log In')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
			
		setLocator(LocatorType.ANDROID_LOCATOR, "PAYMENT_ADD_VOUCHERS",By.id("com.ebay.mobile:id/incentive_link"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "XO_SUMMARY",By.id("com.ebay.mobile:id/checkout_summary_items"));
			setLocator(LocatorType.ANDROID_LOCATOR, "XO_SUMMARY_LBL",By.id("com.ebay.mobile:id/checkout_summary_label"));
			setLocator(LocatorType.ANDROID_LOCATOR, "XO_SUMMARY_VAL",By.id("com.ebay.mobile:id/checkout_summary_value"));
		setLocator(LocatorType.ANDROID_LOCATOR, "XO_TOTAL_LBL",By.id("com.ebay.mobile:id/checkout_total_label"));
		setLocator(LocatorType.ANDROID_LOCATOR, "XO_TOTAL_VALUE",By.id("com.ebay.mobile:id/checkout_total_value"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ALERT_DETAILS",By.id("com.ebay.mobile:id/alert_layout"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ALERT_TXT",By.id("com.ebay.mobile:id/alert_text"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SUCCESS_XO_TITLE",By.id("com.ebay.mobile:id/checkout_success_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SUCCESS_XO_SUBTITLE",By.id("com.ebay.mobile:id/checkout_success_subtitle"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SUCCESS_XO_PENDING_ITEMS",By.id("com.ebay.mobile:id/xo_complete_checkoutable_item"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SUCCESS_XO_BACKTO_CART",By.id("com.ebay.mobile:id/xo_complete_cart_go_to_cart"));
		
		
		setLocator(LocatorType.ANDROID_LOCATOR, "EGD_TEXT",By.id("com.ebay.mobile:id/egd_message_text"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
	}
	
}
