package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.NotificationComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class NotificationsLocators extends BasePageObject<NotificationComponent> {

	protected NotificationsLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By NOTIFICATION_LNK = getLocator("NOTIFICATION_LNK");
	public final By UNREAD_NOTIFICATIONS_COUNT = getLocator("UNREAD_NOTIFICATIONS_COUNT"); 
	public final By FIRST_NOTIFICATION = getLocator("FIRST_NOTIFICATION");
	
	public final By NOTIF_TILES = getLocator("NOTIF_TILES");
		public final By NOTIF_TILE_TITLE = getLocator("NOTIF_TILE_TITLE");
		public final By NOTIF_TILE_BODY = getLocator("NOTIF_TILE_BODY");
		public final By NOTIF_TILE_IMG = getLocator("NOTIF_TILE_IMG");
	
	@Override
	protected void setLocators() {
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIFICATION_LNK", By.id("com.ebay.mobile:id/menuitem_notifications"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNREAD_NOTIFICATIONS_COUNT",By.id("com.ebay.mobile:id/nav_count"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FIRST_NOTIFICATION",By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]"));	//(//android.widget.FrameLayout[@index='0'])[7]
		
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TILES",By.id("com.ebay.mobile:id/row"));
			setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TILE_TITLE",By.id("com.ebay.mobile:id/title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TILE_BODY",By.id("com.ebay.mobile:id/body"));
			setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TILE_IMG",By.id("com.ebay.mobile:id/image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
	}
}
