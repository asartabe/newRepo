package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.HamburgerMenuBottomComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class HamburgerMenuBottomComponentLocators extends BasePageObject<HamburgerMenuBottomComponent>{

	protected HamburgerMenuBottomComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By CATEGORIES_LNK = getLocator("CATEGORIES_LNK");
	public final By DEALS_LNK = getLocator("DEALS_LNK");
	public final By SETTINGS_LNK = getLocator("SETTINGS_LNK");
	public final By HELPCONTACT_LNK = getLocator("HELPCONTACT_LNK");

	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "CATEGORIES_LNK",By.xpath("//android.widget.CheckedTextView[@text='Categories']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DEALS_LNK",By.xpath("//android.widget.CheckedTextView[@text='Deals']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SETTINGS_LNK",By.xpath("//android.widget.CheckedTextView[@text='Settings']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "HELPCONTACT_LNK",By.xpath("//android.widget.CheckedTextView[@text='Help & Contact']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));

	}
}
