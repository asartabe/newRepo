package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.HamburgerMenuSettingsComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class HamburgerMenuSettingsComponentLocators extends BasePageObject<HamburgerMenuSettingsComponent>{

	protected HamburgerMenuSettingsComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By COUNTRY_MENU = getLocator("COUNTRY_MENU");
	public final By COUNTRY_AUTO_SWITCH = getLocator("COUNTRY_AUTO_SWITCH");
	public final By NAVBAR_BACK = getLocator("NAVBAR_BACK");
	public final By COUNTRY_SELECT = getLocator("COUNTRY_SELECT");
	public final By COUNTRY_SRCH_TXT = getLocator("COUNTRY_SRCH_TXT");
	public final By COUNTRY_SRCH_RESULTS = getLocator("COUNTRY_SRCH_RESULTS");
	
	public final By DEV_OPTIONS = getLocator("DEV_OPTIONS");
	public final By DEVICE_CONFIG = getLocator("DEVICE_CONFIG");
	public final By DCS_DISABLED = getLocator("DCS_DISABLED");
	public final By DCS_ENABLED = getLocator("DCS_ENABLED");
	
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_MENU",By.xpath("//android.widget.TextView[@text='Country/region' or @text='Country / region']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_AUTO_SWITCH",By.xpath("//android.widget.Switch"));	//[@id='android:id/switchWidget' or @id='android:id/switch_widget']
		setLocator(LocatorType.ANDROID_LOCATOR, "NAVBAR_BACK",By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_SELECT",By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Country/region' or @text='Country / region']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_SRCH_TXT",By.id("com.ebay.mobile:id/filter"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_SRCH_RESULTS",By.id("com.ebay.mobile:id/check_country"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "DEV_OPTIONS",By.xpath("//android.widget.TextView[@text='Developer options']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DEVICE_CONFIG",By.xpath("//android.widget.TextView[@text='Device configuration']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DCS_DISABLED",By.xpath("//android.widget.CheckedTextView[@text='disabled']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DCS_ENABLED",By.xpath("//android.widget.CheckedTextView[@text='enabled']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
	}
	
}
