package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SharePanelComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SharePanelComponentLocators extends BasePageObject<SharePanelComponent>{

	protected SharePanelComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By SHARE_CONTENT_PANEL = getLocator("SHARE_CONTENT_PANEL");
	public final By SHARE_PANEL_TITLE = getLocator("SHARE_PANEL_TITLE");
	public final By SHARE_PANEL_ITEMS_CONTAINER = getLocator("SHARE_PANEL_ITEMS_CONTAINER");
	public final By SHARE_PANEL_ITEMS = getLocator("SHARE_PANEL_ITEMS");
	
	public final By FACEBOOK_POST_BTN = getLocator("FACEBOOK_POST_BTN");
	
	public final By TWITTER_TWEET = getLocator("TWITTER_TWEET");
	
	public final By GMAIL_RCPNT_TO = getLocator("GMAIL_RCPNT_TO");
	public final By GMAIL_SEND_BTN = getLocator("GMAIL_SEND_BTN");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "SHARE_CONTENT_PANEL",By.id("android:id/contentPanel"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SHARE_PANEL_TITLE",By.id("android:id/title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SHARE_PANEL_ITEMS_CONTAINER",By.id("android:id/resolver_list"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SHARE_PANEL_ITEMS",By.xpath("//android.widget.LinearLayout"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "FACEBOOK_POST_BTN",By.id("com.facebook.katana:id/button_share"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "GMAIL_RCPNT_TO",By.id("com.google.android.gm:id/to"));
		setLocator(LocatorType.ANDROID_LOCATOR, "GMAIL_SEND_BTN",By.id("com.google.android.gm:id/send"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "TWITTER_TWEET",By.id("com.twitter.android:id/composer_post"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
	}
	
}
