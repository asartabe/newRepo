package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SRPHeaderComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SRPHeaderComponentLocators extends BasePageObject<SRPHeaderComponent>{

	protected SRPHeaderComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By FOLLOW_BTN = getLocator("FOLLOW_BTN");
		public final By FOLLOW_PANEL_NAME = getLocator("FOLLOW_PANEL_NAME");
		public final By FOLLOW_PANEL_EMAILALERT = getLocator("FOLLOW_PANEL_EMAILALERT");
		public final By FOLLOW_PANEL_PHONEALERT = getLocator("FOLLOW_PANEL_PHONEALERT");
		public final By CANCEL = getLocator("CANCEL");
		public final By SAVE_OK = getLocator("SAVE_OK");
	public final By SORT_BTN = getLocator("SORT_BTN");
	public final By FILTER_BTN = getLocator("FILTER_BTN");
	public final By SAVE_QUICKTIP = getLocator("SAVE_QUICKTIP");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOW_BTN",By.id("com.ebay.mobile:id/button_follow"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SORT_BTN",By.xpath("//*[@text='Sort' or @text='SORT' or @text='Refine' or @text='REFINE']"));	//@resource-id='com.ebay.mobile:id/button_sort' or 
		setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_BTN",By.xpath("//*[@resource-id='com.ebay.mobile:id/button_filter' or @resource-id='com.ebay.mobile:id/button_refine']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOW_PANEL_NAME",By.id("com.ebay.mobile:id/search_name_edittext"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOW_PANEL_EMAILALERT",By.id("com.ebay.mobile:id/email_notify_checkbox"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOW_PANEL_PHONEALERT",By.id("com.ebay.mobile:id/push_notify_checkbox"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CANCEL",By.id("android:id/button2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVE_OK",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVE_QUICKTIP",By.id("com.ebay.mobile:id/popup_container"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
	
	}
	
	
}
