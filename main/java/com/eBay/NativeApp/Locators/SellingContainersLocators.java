package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SellingContainersComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SellingContainersLocators extends BasePageObject<SellingContainersComponent>{

	protected SellingContainersLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By TAB_ACTIVE = getLocator("TAB_ACTIVE");
	public final By TAB_SOLD = getLocator("TAB_SOLD");
	public final By TAB_UNSOLD = getLocator("TAB_UNSOLD");
	
	public final By FILTER_HDR_CONTAINER = getLocator("FILTER_HDR_CONTAINER");
	public final By FILTER_HDR_TEXT = getLocator("FILTER_HDR_TEXT");
	
	public final By FILTER_BTN = getLocator("FILTER_BTN");
		public final By FILTER_CANCEL = getLocator("FILTER_CANCEL");
		public final By FILTER_OPT_ALL = getLocator("FILTER_OPT_ALL");
	
	public final By FILTER_ACTIVE_OPT_AUCTIONS = getLocator("FILTER_ACTIVE_OPT_AUCTIONS");
	public final By FILTER_ACTIVE_OPT_FIXEDPRICE = getLocator("FILTER_ACTIVE_OPT_FIXEDPRICE");
	public final By FILTER_ACTIVE_OPT_HAVEOFFERS = getLocator("FILTER_ACTIVE_OPT_HAVEOFFERS");
	
	public final By FILTER_SOLD_OPT_AWTNG_PAY = getLocator("FILTER_SOLD_OPT_AWTNG_PAY");
	public final By FILTER_SOLD_OPT_PAID_SENDNOW = getLocator("FILTER_SOLD_OPT_PAID_SENDNOW");
	
	public final By EDIT_BTN = getLocator("EDIT_BTN");
	public final By CANCEL_BTN = getLocator("CANCEL_BTN");
	public final By DELETE_BTN = getLocator("DELETE_BTN");
	public final By DELETE_NO = getLocator("DELETE_NO");
	public final By DELETE_YES = getLocator("DELETE_YES");
	
	public final By ITEM_CONTAINER = getLocator("ITEM_CONTAINER");
	public final By ITM_IMAGE = getLocator("ITM_IMAGE");
	public final By ITM_PRICE = getLocator("ITM_PRICE");
	public final By ITM_CHKBX = getLocator("ITM_CHKBX");
	
	public final By ACTIVE_ITM_TITLE = getLocator("ACTIVE_ITM_TITLE");
	public final By ACTIVE_ITM_WATCHER = getLocator("ACTIVE_ITM_WATCHER");
	public final By ACTIVE_ITM_TIMELEFT = getLocator("ACTIVE_ITM_TIMELEFT");
	public final By ACTIVE_BID_COUNT = getLocator("ACTIVE_BID_COUNT");
	
	public final By SOLD_ITM_STATUS = getLocator("SOLD_ITM_STATUS");
	public final By SOLD_ITM_TITLE = getLocator("SOLD_ITM_TITLE");
	public final By SOLD_ITM_POSTAGE = getLocator("SOLD_ITM_POSTAGE");
	public final By SOLD_ITM_BUYER = getLocator("SOLD_ITM_BUYER");
	public final By SOLD_ITM_SELLDATE = getLocator("SOLD_ITM_SELLDATE");
	
	public final By UNSOLD_ITM_TITLE = getLocator("UNSOLD_ITM_TITLE");
	public final By UNSOLD_ITM_POSTAGE = getLocator("UNSOLD_ITM_POSTAGE");
	public final By UNSOLD_ITM_WATCHER = getLocator("UNSOLD_ITM_WATCHER");
	public final By UNSOLD_ITM_ENDDATE = getLocator("UNSOLD_ITM_ENDDATE");
	
	@Override
	  protected void setLocators() {
	    
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_ACTIVE",By.xpath("//android.widget.TextView[@text='Active' or @text='ACTIVE']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_SOLD",By.xpath("//android.widget.TextView[@text='Sold' or @text='SOLD']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_UNSOLD",By.xpath("//android.widget.TextView[@text='Unsold' or @text='UNSOLD']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_BTN",By.id("com.ebay.mobile:id/button_refine"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_CANCEL",By.id("android:id/button2"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_OPT_ALL",By.xpath("//android.widget.CheckedTextView[@text='All']"));
			
			setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_ACTIVE_OPT_AUCTIONS",By.xpath("//android.widget.CheckedTextView[@text='Auctions']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_ACTIVE_OPT_FIXEDPRICE",By.xpath("//android.widget.CheckedTextView[@text='Fixed price']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_ACTIVE_OPT_HAVEOFFERS",By.xpath("//android.widget.CheckedTextView[@text='Have new offers']"));
			
			setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_SOLD_OPT_AWTNG_PAY",By.xpath("//android.widget.CheckedTextView[@text='Awaiting payment']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_SOLD_OPT_PAID_SENDNOW",By.xpath("//android.widget.CheckedTextView[@text='Paid - send now']"));
			
		setLocator(LocatorType.ANDROID_LOCATOR, "EDIT_BTN",By.id("com.ebay.mobile:id/button_edit"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CANCEL_BTN",By.id("com.ebay.mobile:id/button_edit"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_BTN",By.xpath("//*[contains(@resource-id, 'menu_search') or contains(@resource-id, 'menu_cart')]"));	//com.ebay.mobile:id/menu_cart
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_NO",By.id("android:id/button2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_YES",By.id("android:id/button1"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_CONTAINER",By.id("com.ebay.mobile:id/main_item_container"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_IMAGE",By.id("com.ebay.mobile:id/image"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_PRICE",By.id("com.ebay.mobile:id/itemPrice"));
			
			setLocator(LocatorType.ANDROID_LOCATOR, "ACTIVE_ITM_TITLE",By.id("android:id/text1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ACTIVE_ITM_WATCHER",By.id("com.ebay.mobile:id/subtext1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ACTIVE_ITM_TIMELEFT",By.id("com.ebay.mobile:id/subtext2"));
		
			setLocator(LocatorType.ANDROID_LOCATOR, "SOLD_ITM_STATUS",By.id("android:id/text1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SOLD_ITM_TITLE",By.id("com.ebay.mobile:id/title2"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SOLD_ITM_POSTAGE",By.id("com.ebay.mobile:id/subtext1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SOLD_ITM_BUYER",By.id("com.ebay.mobile:id/subtext2"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SOLD_ITM_SELLDATE",By.id("com.ebay.mobile:id/subtext3"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ITM_CHKBX",By.id("com.ebay.mobile:id/multiselect_checkbox"));
			
			setLocator(LocatorType.ANDROID_LOCATOR, "UNSOLD_ITM_TITLE",By.id("android:id/text1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "UNSOLD_ITM_POSTAGE",By.id("com.ebay.mobile:id/subtext1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "UNSOLD_ITM_WATCHER",By.id("com.ebay.mobile:id/subtext2"));
			setLocator(LocatorType.ANDROID_LOCATOR, "UNSOLD_ITM_ENDDATE",By.id("com.ebay.mobile:id/subtext3"));
			
			setLocator(LocatorType.ANDROID_LOCATOR, "ACTIVE_BID_COUNT",By.xpath("//android.widget.TextView[contains(@text, 'bid')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
			
		setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_HDR_CONTAINER",By.id("com.ebay.mobile:id/filter_header_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FILTER_HDR_TEXT",By.id("android:id/text1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
	}
	
	
}
