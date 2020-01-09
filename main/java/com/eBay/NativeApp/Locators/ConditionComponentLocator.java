package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.ConditionComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class ConditionComponentLocator extends BasePageObject<ConditionComponent> {
	
	public ConditionComponentLocator(WebDriver driver) {
		super(driver);
	}
	
	public final By COND_TITLE = getLocator("COND_TITLE");
	public final By COND_BRANDNEW = getLocator("COND_BRANDNEW");
	public final By INFO_POPUP = getLocator("INFO_POPUP");
	public final By GOT_IT_BTN = getLocator("GOT_IT_BTN");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "COND_TITLE",By.xpath("//android.widget.TextView[@text='Condition']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COND_BRANDNEW",By.xpath("//android.widget.RadioButton[@text='Brand New']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "INFO_POPUP",By.id("com.ebay.mobile:id/interstitial_heading"));
		setLocator(LocatorType.ANDROID_LOCATOR, "GOT_IT_BTN",By.id("com.ebay.mobile:id/close_interstitial_button"));
	}
	
}

