package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SellingComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SellingLocators extends BasePageObject<SellingComponent>{

	public SellingLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By LIST_ITEM_BUTTON = getLocator("LIST_ITEM_BUTTON");
	
	
	@Override
	protected void setLocators() {
		setLocator(LocatorType.ANDROID_LOCATOR, "LIST_ITEM_BUTTON",By.xpath("//android.widget.Button[@text='List an item']"));	
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
	
	}

}
