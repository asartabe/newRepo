package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.BrowsePageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class BrowsePageComponentLocators extends BasePageObject<BrowsePageComponent>{

	protected BrowsePageComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By SHOP_BY = getLocator("SHOP_BY");
	public final By SHOP_BY_SUBTEXT = getLocator("SHOP_BY_SUBTEXT");
	public final By SAVE_ON_HEADER = getLocator("SAVE_ON_HEADER");
	public final By BEST_SELLING = getLocator("BEST_SELLING");
	public final By LIMITED_TIME_DEALS = getLocator("LIMITED_TIME_DEALS");
	public final By HOT_THIS_WEEK = getLocator("HOT_THIS_WEEK");
	public final By RESULTS = getLocator("RESULTS");
	public final By VIEW_ALL_RESULTS_LNK = getLocator("VIEW_ALL_RESULTS_LNK");
	public final By START_SELLING_LNK = getLocator("START_SELLING_LNK");
	public final By YOU_MAY_ALSO_LIKE = getLocator("YOU_MAY_ALSO_LIKE");
	public final By CATEGORIES = getLocator("CATEGORIES");
	
	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SHOP_BY",By.xpath("//android.widget.TextView[@text='Shop by']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SHOP_BY_SUBTEXT",By.id("com.ebay.mobile:id/textview_header_subtitle"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVE_ON_HEADER",By.xpath("//android.widget.TextView[contains(@text, 'Save on')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BEST_SELLING",By.xpath("//android.widget.TextView[@text='Best Selling']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LIMITED_TIME_DEALS",By.xpath("//android.widget.TextView[@text='Limited Time Deals']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "HOT_THIS_WEEK",By.xpath("//android.widget.TextView[@text='Hot This Week']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RESULTS",By.xpath("//android.widget.TextView[@text='Results']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "VIEW_ALL_RESULTS_LNK",By.xpath("//android.widget.TextView[@text='VIEW ALL RESULTS']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "START_SELLING_LNK",By.xpath("//android.widget.TextView[@text='START SELLING']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "YOU_MAY_ALSO_LIKE",By.xpath("//android.widget.TextView[@text='You may also like']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CATEGORIES",By.xpath("//android.widget.TextView[@text='Categories']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
	}
	
}
