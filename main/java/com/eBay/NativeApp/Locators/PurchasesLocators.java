package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.PurchasesComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class PurchasesLocators extends BasePageObject<PurchasesComponent>{

	public PurchasesLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public final By EDIT_BTN = getLocator("EDIT_BTN");
	public final By REFINE_BTN = getLocator("REFINE_BTN");
	public final By ALL_ITEMS=getLocator("ALL_ITEMS");
	public final By FIRST_ITEM=getLocator("FIRST_ITEM");
	public final By ITEM_STATUS=getLocator("ITEM_STATUS");
	public final By IMAGE_IMAGE=getLocator("IMAGE_IMAGE");
	public final By ITEM_TITLE=getLocator("ITEM_TITLE");
	public final By ITEM_PRICE=getLocator("ITEM_PRICE");
	public final By ITEM_POSTAGE=getLocator("ITEM_POSTAGE");
	public final By ITEM_TIMELEFT=getLocator("ITEM_TIMELEFT");
	public final By DELETE_ICON=getLocator("DELETE_ICON");
	public final By CANCEL_LNK=getLocator("CANCEL_LNK");
	public final By ITEM_CHECKBOX=getLocator("ITEM_CHECKBOX");
	public final By CHKBOX_ENABLED=getLocator("CHKBOX_ENABLED");
	public final By DELETE_YES_LNK=getLocator("DELETE_YES_LNK");
	public final By REFINE_DONE_LNK=getLocator("REFINE_DONE_LNK");
	public final By REFINE_TITLE= getLocator("REFINE_TITLE");
	
	@Override
	protected void setLocators() {
		setLocator(LocatorType.ANDROID_LOCATOR, "EDIT_BTN",By.id("com.ebay.mobile:id/button_edit"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REFINE_BTN", By.id("com.ebay.mobile:id/button_refine"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ALL_ITEMS",By.id("com.ebay.mobile:id/main_item_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FIRST_ITEM",By.xpath("//android.widget.RelativeLayout[@index='1']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "IMAGE_IMAGE",By.id("com.ebay.mobile:id/image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_STATUS",By.id("com.ebay.mobile:id/item_user_status"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TITLE",By.id("com.ebay.mobile:id/item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_PRICE",By.id("com.ebay.mobile:id/item_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_POSTAGE",By.id("com.ebay.mobile:id/item_shipping_price"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TIMELEFT",By.id("com.ebay.mobile:id/item_time_left"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_ICON",By.id("com.ebay.mobile:id/menu_item_delete"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CANCEL_LNK",By.xpath("//android.widget.Button[@text='Cancel']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_CHECKBOX",By.id("com.ebay.mobile:id/multiselect_checkbox"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CHKBOX_ENABLED",By.xpath("//android.widget.CheckedTextView[@enabled='true']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_YES_LNK",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REFINE_DONE_LNK",By.id("com.ebay.mobile:id/watching_refine_done"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REFINE_TITLE",By.id("com.ebay.mobile:id/simple_refine_title"));
	
		
		
		
	}
}
