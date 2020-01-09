package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.UserProfileActionComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class UserProfileActionComponentLocators extends BasePageObject<UserProfileActionComponent>{

	protected UserProfileActionComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By FOLLOW_BTN = getLocator("FOLLOW_BTN");
	public final By CONTACT_BTN = getLocator("CONTACT_BTN");
	public final By SELLER_OTHER_ITEMS = getLocator("SELLER_OTHER_ITEMS");
	public final By SEE_ALL_FDBACK = getLocator("SEE_ALL_FDBACK");

	@Override
	protected void setLocators() {
		setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOW_BTN",By.id("com.ebay.mobile:id/add_seller_to_favorites_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CONTACT_BTN",By.id("com.ebay.mobile:id/contact_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_OTHER_ITEMS",By.id("com.ebay.mobile:id/other_items_cell"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEE_ALL_FDBACK",By.id("com.ebay.mobile:id/recent_feedback_cell"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));

	}

}
