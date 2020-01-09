package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.ReviewPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class ReviewPageComponentLocators extends BasePageObject<ReviewPageComponent>{

	protected ReviewPageComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By BTN_LIST_IT = getLocator("BTN_LIST_IT");
	public final By BTN_PREVIEW = getLocator("BTN_PREVIEW");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_LIST_IT",By.id("com.ebay.mobile:id/button_publish"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_PREVIEW",By.id("com.ebay.mobile:id/button_preview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
	}
	
	
}
