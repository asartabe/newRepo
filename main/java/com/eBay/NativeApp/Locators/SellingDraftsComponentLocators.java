package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SellingDraftsComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SellingDraftsComponentLocators extends BasePageObject<SellingDraftsComponent>{

	public SellingDraftsComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By EDIT_BTN = getLocator("EDIT_BTN");
	public final By ITM_CONTAINER = getLocator("ITM_CONTAINER");
	public final By ITM_IMAGE = getLocator("ITM_IMAGE");
	public final By ITM_CHKBX = getLocator("ITM_CHKBX");
	public final By DELETE_BTN = getLocator("DELETE_BTN");
	public final By CANCEL_BTN = getLocator("CANCEL_BTN");
	public final By DELETE_NO = getLocator("DELETE_NO");
	public final By DELETE_YES = getLocator("DELETE_YES");
	
	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "EDIT_BTN",By.id("com.ebay.mobile:id/button_edit"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITM_CONTAINER",By.id("com.ebay.mobile:id/main_item_container"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_IMAGE",By.id("com.ebay.mobile:id/image"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_CHKBX",By.id("com.ebay.mobile:id/multiselect_checkbox"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_BTN",By.xpath("//*[contains(@resource-id, 'action_view_icon') or contains(@resource-id, 'menu_search')]"));	//com.ebay.mobile:id/action_view_icon
		setLocator(LocatorType.ANDROID_LOCATOR, "CANCEL_BTN",By.id("com.ebay.mobile:id/button_edit"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_NO",By.id("android:id/button2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_YES",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
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
