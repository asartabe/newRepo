package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.CartPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class CartPageComponentLocators extends BasePageObject<CartPageComponent>{

	protected CartPageComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By CLOSE_CART = getLocator("CLOSE_CART");
	public final By CART_LINE_ITM = getLocator("CART_LINE_ITM");
		public final By LINE_ITM_DETAILS = getLocator("LINE_ITM_DETAILS");
			public final By ITM_IMG = getLocator("ITM_IMG");
			public final By ITM_TITLE = getLocator("ITM_TITLE");
			public final By ITM_PRICE = getLocator("ITM_PRICE");
			public final By ITM_POSTAGE = getLocator("ITM_POSTAGE");
	
	public final By REMOVE_BTN = getLocator("REMOVE_BTN");
	public final By SAVE_FOR_LATER_BTN = getLocator("SAVE_FOR_LATER_BTN");
	public final By QUANTITY_BTN = getLocator("QUANTITY_BTN");
		public final By QTY_LBL = getLocator("QTY_LBL");
		public final By QTY_VALUE = getLocator("QTY_VALUE");
	
	public final By REM_CONFIRM_BTN = getLocator("REM_CONFIRM_BTN");
	public final By REM_CANCEL_BTN = getLocator("REM_CANCEL_BTN");
	
	public final By SME_PANEL = getLocator("SME_PANEL");
		public final By SME_PROMO_TITLE = getLocator("SME_PROMO_TITLE");
		public final By SME_PROMO_DICOUNTED_PRICE = getLocator("SME_PROMO_DICOUNTED_PRICE");
	
	public final By TAB_IN_CART = getLocator("TAB_IN_CART");
	public final By TAB_SAVED = getLocator("TAB_SAVED");
	
	public final By ADD_BACK_TO_CART = getLocator("ADD_BACK_TO_CART");
	
	public final By CART_SUBTOTAL_AMT = getLocator("CART_SUBTOTAL_AMT");
	
	public final By CHECKOUT_BTN = getLocator("CHECKOUT_BTN");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "CLOSE_CART",By.id("com.ebay.mobile:id/toolbar_close_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CART_LINE_ITM",By.id("com.ebay.mobile:id/cart_line_item"));
			setLocator(LocatorType.ANDROID_LOCATOR, "LINE_ITM_DETAILS",By.id("com.ebay.mobile:id/item_details"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ITM_IMG",By.id("com.ebay.mobile:id/item_thumbnail"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ITM_TITLE",By.id("com.ebay.mobile:id/title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PRICE",By.id("com.ebay.mobile:id/item_price"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ITM_POSTAGE",By.id("com.ebay.mobile:id/item_est_shipping_cost"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REMOVE_BTN",By.id("com.ebay.mobile:id/item_action_remove_from_cart"));
		//By.xpath("//*[@resource-id='com.ebay.mobile:id/remove_from_cart_button' or @resource-id='com.ebay.mobile:id/remove_from_saved_button']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVE_FOR_LATER_BTN",By.id("com.ebay.mobile:id/save_for_later_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "QUANTITY_BTN",By.id("com.ebay.mobile:id/quantity_button"));
			setLocator(LocatorType.ANDROID_LOCATOR, "QTY_LBL",By.id("com.ebay.mobile:id/quantity_button_label"));
			setLocator(LocatorType.ANDROID_LOCATOR, "QTY_VALUE",By.id("com.ebay.mobile:id/quantity_button_value"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ADD_BACK_TO_CART",By.id("com.ebay.mobile:id/add_to_cart_button"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "CHECKOUT_BTN",By.id("com.ebay.mobile:id/shopping_cart_checkout"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "REM_CONFIRM_BTN",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REM_CANCEL_BTN",By.id("android:id/button2"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_IN_CART",By.xpath("//android.widget.TextView[@text='IN CART']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_SAVED",By.xpath("//android.widget.TextView[@text='SAVED']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SME_PANEL",By.id("com.ebay.mobile:id/shopping_cart_promotion"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SME_PROMO_TITLE",By.id("com.ebay.mobile:id/promotion_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SME_PROMO_DICOUNTED_PRICE",By.id("com.ebay.mobile:id/promotion_discount"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "CART_SUBTOTAL_AMT",By.id("com.ebay.mobile:id/shopping_cart_subtotal_amount"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
	}
	
}
