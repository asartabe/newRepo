package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SRPHeaderComponent.SRPRefinePanel;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

import io.appium.java_client.MobileBy;

public class SRPRefinePanelLocators extends BasePageObject<SRPRefinePanel>{

	protected SRPRefinePanelLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By SAVE_REFINEMENTS = getLocator("SAVE_REFINEMENTS");
	public final By SHOW_MORE = getLocator("SHOW_MORE");
	public final By RESET_REFINEMENTS = getLocator("RESET_REFINEMENTS");
	public final By VIEW_ASLIST = getLocator("VIEW_ASLIST");
	public final By VIEW_ASGRID = getLocator("VIEW_ASGRID");
	public final By BACK_TO_REFINEPANEL = getLocator("BACK_TO_REFINEPANEL");
	
	public final By OK = getLocator("OK");
	public final By CANCEL = getLocator("CANCEL");
	
	public final By SORT_BY_MENU = getLocator("SORT_BY_MENU");
	public final By CATEGORY_MENU = getLocator("CATEGORY_MENU");
	public final By BUYINGFORMAT_MENU = getLocator("BUYINGFORMAT_MENU");
	public final By ITEMCONDITION_MENU = getLocator("ITEMCONDITION_MENU");
	public final By PRICERANGE_MENU = getLocator("PRICERANGE_MENU");
		public final By PRICE_SET_RANGE = getLocator("PRICE_SET_RANGE");
		public final By PRICE_MINVAL = getLocator("PRICE_MINVAL");
		public final By PRICE_MAXVAL = getLocator("PRICE_MAXVAL");
		public final By PRICE_APPLY = getLocator("PRICE_APPLY");
		public final By PRICE_CANCEL = getLocator("PRICE_CANCEL");
	public final By DELIVERYOPTS_MENU = getLocator("DELIVERYOPTS_MENU");
	public final By ITEMLOCATION_MENU = getLocator("ITEMLOCATION_MENU");
	public final By COMPLETEDITEMS_SWITCH = getLocator("COMPLETEDITEMS_SWITCH");
	public final By SOLDITEMS_SWITCH = getLocator("SOLDITEMS_SWITCH");
	public final By SRCH_IN_DESC_SWITCH = getLocator("SRCH_IN_DESC_SWITCH");
	
	public final By LOCK_BUY_BID = getLocator("LOCK_BUY_BID");
	public final By LOCK_BUY_BIN = getLocator("LOCK_BUY_BIN");
	public final By LOCK_BUY_BO = getLocator("LOCK_BUY_BO");
	public final By LOCK_LOCATION_AUONLY = getLocator("LOCK_LOCATION_AUONLY");
	public final By LOCK_LOCATION_WORLDWIDE = getLocator("LOCK_LOCATION_WORLDWIDE");
	
	public final By GUARANTEED_DELIVERY=getLocator("GUARANTEED_DELIVERY");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "SAVE_REFINEMENTS",By.id("com.ebay.mobile:id/button_done"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SHOW_MORE",By.id("com.ebay.mobile:id/button_resize_list"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RESET_REFINEMENTS",By.id("com.ebay.mobile:id/button_reset_filters"));
		setLocator(LocatorType.ANDROID_LOCATOR, "VIEW_ASLIST",By.id("com.ebay.mobile:id/button_view_list"));
		setLocator(LocatorType.ANDROID_LOCATOR, "VIEW_ASGRID",By.id("com.ebay.mobile:id/button_view_grid"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BACK_TO_REFINEPANEL",By.id("com.ebay.mobile:id/button_back_all_filters"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "OK",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CANCEL",By.id("android:id/button2"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "SORT_BY_MENU",By.xpath("//android.widget.TextView[@text='Sort by']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "CATEGORY_MENU",By.xpath("//android.widget.TextView[@text='Category']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BUYINGFORMAT_MENU",By.xpath("//android.widget.TextView[@text='Buying format']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEMCONDITION_MENU",By.xpath("//android.widget.TextView[@text='Item condition']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRICERANGE_MENU",By.xpath("//android.widget.TextView[@text='Price range']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_SET_RANGE",By.xpath("//android.widget.TextView[@text='Custom price range']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_MINVAL",By.id("com.ebay.mobile:id/minimum_price_view"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_MAXVAL",By.id("com.ebay.mobile:id/maximum_price_view"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_APPLY",By.id("android:id/button1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRICE_CANCEL",By.id("android:id/button2"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELIVERYOPTS_MENU",By.xpath("//android.widget.TextView[@text='Delivery options']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEMLOCATION_MENU",By.xpath("//android.widget.TextView[@text='Item location']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COMPLETEDITEMS_SWITCH",By.xpath("//android.widget.Switch[contains(@text,'Completed items')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SOLDITEMS_SWITCH",By.xpath("//android.widget.Switch[contains(@text,'Sold items')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_IN_DESC_SWITCH",By.xpath("//android.widget.Switch[contains(@text,'Search in description')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "GUARANTEED_DELIVERY",By.xpath("//android.widget.TextView[@text='Guaranteed Delivery')]"));
	
		setLocator(LocatorType.ANDROID_LOCATOR, "LOCK_BUY_BID",MobileBy.AccessibilityId("Lock Auction refinement"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LOCK_BUY_BIN",MobileBy.AccessibilityId("Lock Buy It Now refinement"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LOCK_BUY_BO",MobileBy.AccessibilityId("Lock Best Offer refinement"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LOCK_LOCATION_AUONLY",MobileBy.AccessibilityId("Lock Australia Only refinement"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LOCK_LOCATION_WORLDWIDE",MobileBy.AccessibilityId("Lock Worldwide refinement"));
		
	}

}
