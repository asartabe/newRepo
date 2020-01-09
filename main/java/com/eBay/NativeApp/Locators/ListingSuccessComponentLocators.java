package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.ListingSuccessComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class ListingSuccessComponentLocators extends BasePageObject<ListingSuccessComponent>{

	protected ListingSuccessComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By TXT_CONGRATULATIONS = getLocator("TXT_CONGRATULATIONS");
	public final By TXT_ITEM_LISTED = getLocator("TXT_ITEM_LISTED");
	public final By BTN_VIEW_LISTING = getLocator("BTN_VIEW_LISTING");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "TXT_CONGRATULATIONS",By.id("com.ebay.mobile:id/text1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TXT_ITEM_LISTED",By.id("com.ebay.mobile:id/congrats_subtext"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_VIEW_LISTING",By.id("com.ebay.mobile:id/view_listing"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
	}
	
}
