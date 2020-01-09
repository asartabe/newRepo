package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.TopProductPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class TopProductPageLocators extends  BasePageObject<TopProductPageComponent>
	{
	public TopProductPageLocators(WebDriver driver) {
		super(driver);
	}

	public final By TOPPRODUCT_TITLE = getLocator("TOPPRODUCT_TITLE");
	public final By TOPPRODUCT_CAT_HEADER = getLocator("TOPPRODUCT_CAT_HEADER");
	public final By TOPPRODUCT_PIVOT_BESTSELLING = getLocator("TOPPRODUCT_PIVOT_BESTSELLING");
	public final By TOPPRODUCT_PIVOT_TOPRATED = getLocator("TOPPRODUCT_PIVOT_TOPRATED");
	public final By TOPPRODUCT_PRODUCTCARD = getLocator("TOPPRODUCT_PRODUCTCARD");
	
	
	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "TOPPRODUCT_TITLE",By.id("com.ebay.mobile:id/title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TOPPRODUCT_CAT_HEADER",By.id("com.ebay.mobile:id/textview_header_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TOPPRODUCT_PIVOT_BESTSELLING",By.xpath("//android.widget.TextView[contains(@text, 'BESTSELLING')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TOPPRODUCT_PIVOT_TOPRATED",By.xpath("//android.widget.TextView[contains(@text, 'TOP RATED')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TOPPRODUCT_PRODUCTCARD",By.id("com.ebay.mobile:id/product_card"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
	}
}
