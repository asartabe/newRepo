package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SellingScheduledContainerComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SellingScheduledContainerComponentLocators extends BasePageObject<SellingScheduledContainerComponent>{

	protected SellingScheduledContainerComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By ITM_CONTAINER = getLocator("ITM_CONTAINER");
		public final By ITM_IMG = getLocator("ITM_IMG");
		public final By ITM_TITLE = getLocator("ITM_TITLE");
		public final By ITM_PRICE = getLocator("ITM_PRICE");
		public final By ITM_GOLIVE_DATE = getLocator("ITM_GOLIVE_DATE");
		public final By ITM_GOLIVE_TIME = getLocator("ITM_GOLIVE_TIME");
	
	@Override
	  protected void setLocators() {
	    
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_CONTAINER",By.id("com.ebay.mobile:id/main_item_container"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_IMG",By.id("com.ebay.mobile:id/image"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_TITLE",By.id("android:id/text1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PRICE",By.id("com.ebay.mobile:id/itemPrice"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_GOLIVE_DATE",By.id("com.ebay.mobile:id/subtext2"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_GOLIVE_TIME",By.id("com.ebay.mobile:id/subtext3"));
	}
	
}
