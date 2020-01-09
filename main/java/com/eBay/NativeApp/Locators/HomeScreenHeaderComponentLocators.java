package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.HomeScreenHeaderComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class HomeScreenHeaderComponentLocators extends BasePageObject<HomeScreenHeaderComponent>{

	protected HomeScreenHeaderComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By HAMBURGERMENU_ICON = getLocator("HAMBURGERMENU_ICON");
	public final By EBAY_LOGO = getLocator("EBAY_LOGO");
	public final By CART_ICON = getLocator("CART_ICON");
	public final By SRCH_ICON = getLocator("SRCH_ICON");
	public final By SRCH_BOX = getLocator("SRCH_BOX");
	public final By GO_TO_HOME = getLocator("HAMBURGERMENU_ICON");
	
	@Override
	  protected void setLocators() {
	    
		setLocator(LocatorType.ANDROID_LOCATOR, "HAMBURGERMENU_ICON",By.id("com.ebay.mobile:id/home"));
		setLocator(LocatorType.ANDROID_LOCATOR, "EBAY_LOGO",By.id("com.ebay.mobile:id/logo"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CART_ICON",By.id("com.ebay.mobile:id/menu_cart"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_ICON",By.id("com.ebay.mobile:id/menu_search"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_BOX",By.id("com.ebay.mobile:id/search_box"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
	
	}
	
}
