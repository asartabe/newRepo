package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.DealsTabComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class DealsTabComponentLocators extends BasePageObject<DealsTabComponent>{

	protected DealsTabComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By TAB_FEATURED = getLocator("TAB_FEATURED");
	public final By TAB_ELECTRONICS = getLocator("TAB_ELECTRONICS");
	public final By TAB_FASHION = getLocator("TAB_FASHION");
	public final By TAB_HOME_GARDEN = getLocator("TAB_HOME_GARDEN");
	public final By TAB_MORE_DEALS = getLocator("TAB_MORE_DEALS");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_FEATURED",By.xpath("//android.widget.TextView[contains(@content-desc, 'Featured') or @text='FEATURED']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_ELECTRONICS",By.xpath("//android.widget.TextView[contains(@content-desc, 'Electronics') or @text='ELECTRONICS']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_FASHION",By.xpath("//android.widget.TextView[contains(@content-desc, 'Fashion') or @text='FASHION']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_HOME_GARDEN",By.xpath("//android.widget.TextView[contains(@content-desc, 'Home') or contains(@text,'HOME')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_MORE_DEALS",By.xpath("//android.widget.TextView[contains(@content-desc, 'More') or contains(@text,'MORE')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
	}
	
}
