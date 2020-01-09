package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.HamburgerMenuMyEbayComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class HamburgerMenuMyEbayComponentLocators extends BasePageObject<HamburgerMenuMyEbayComponent>{

	protected HamburgerMenuMyEbayComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By ALL_LINKS=getLocator("ALL_LINKS");
	
	public final By WATCHING_LNK = getLocator("WATCHING_LNK");
	public final By PURCHASES_LNK = getLocator("PURCHASES_LNK");
	public final By BIDSOFFERS_LNK = getLocator("BIDSOFFERS_LNK");
	public final By SELLING_LNK = getLocator("SELLING_LNK");
    public final By FOLLOWING_LNK = getLocator("FOLLOWING_LNK");
	public final By CATEGORIES_LNK = getLocator("CATEGORIES_LNK");
	public final By DEALS_LNK = getLocator("DEALS_LNK");
	public final By SETTINGS_LNK = getLocator("SETTINGS_LNK");
	public final By HELP_LNK= getLocator("HELP_LNK");
	public final By USER_PROFILE = getLocator("USER_PROFILE");
	
	@Override
	protected void setLocators() {
	
		setLocator(LocatorType.ANDROID_LOCATOR, "ALL_LINKS",By.xpath("//android.widget.CheckedTextView"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_LNK",By.xpath("//android.widget.CheckedTextView[@text='Watching']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PURCHASES_LNK",By.xpath("//android.widget.CheckedTextView[@text='Purchases']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BIDSOFFERS_LNK",By.xpath("//android.widget.CheckedTextView[contains(@text, 'Bids')]"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLING_LNK",By.xpath("//android.widget.CheckedTextView[@text='Selling']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWING_LNK",By.xpath("//android.widget.CheckedTextView[@text='Saved']"));	//@text='Following' or 
		setLocator(LocatorType.ANDROID_LOCATOR, "CATEGORIES_LNK",By.xpath("//android.widget.CheckedTextView[@text='Categories']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DEALS_LNK",By.xpath("//android.widget.CheckedTextView[@text='Deals']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SETTINGS_LNK",By.xpath("//android.widget.CheckedTextView[@text='Settings']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "HELP_LNK",By.xpath("//android.widget.CheckedTextView[@text='Help & Contact']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "USER_PROFILE",By.xpath("//android.widget.CheckedTextView[@text='Profile']"));
		
	}
}
