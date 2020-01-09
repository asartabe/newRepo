package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.PushNotificationComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class PushNotificationComponentLocators extends BasePageObject<PushNotificationComponent>{

	protected PushNotificationComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By NOTIF_ICON = getLocator("NOTIF_ICON");
	public final By NOTIF_TITLE = getLocator("NOTIF_TITLE");
	public final By NOTIF_CONTENT = getLocator("NOTIF_CONTENT");
	
	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_ICON",By.id("com.ebay.mobile:id/notification_icon"));
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TITLE",By.id("com.ebay.mobile:id/notification_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_CONTENT",By.id("com.ebay.mobile:id/notification_content"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
	
	}
	
}
