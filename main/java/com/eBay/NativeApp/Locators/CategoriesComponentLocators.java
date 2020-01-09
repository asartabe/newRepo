package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.CategoriesComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class CategoriesComponentLocators extends BasePageObject<CategoriesComponent>{

	protected CategoriesComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By CAT_SEE_ALL = getLocator("CAT_SEE_ALL");
	public final By CAT_NODE_NAME = getLocator("CAT_NODE_NAME");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "CAT_SEE_ALL",By.id("com.ebay.mobile:id/textview_see_all"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CAT_NODE_NAME",By.id("com.ebay.mobile:id/textview_category"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
	}
	
}
