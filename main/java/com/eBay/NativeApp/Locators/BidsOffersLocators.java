package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.BidsOffersComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class BidsOffersLocators extends BasePageObject<BidsOffersComponent>{

	public BidsOffersLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public final By BIDS_TAB = getLocator("BIDS_TAB");
	public final By OFFERS_TAB = getLocator("OFFERS_TAB");
	public final By DIDNTWIN_TAB = getLocator("DIDNTWIN_TAB");
	public final By DIDNTWIN_EDIT_LNK = getLocator("DIDNTWIN_EDIT_LNK");
	public final By ALL_ITEMS = getLocator("ALL_ITEMS");
	public final By BID_STATUS = getLocator("BID_STATUS");
	public final By ITEM_TITLE = getLocator("ITEM_TITLE");
	public final By IMAGE_IMAGE = getLocator("IMAGE_IMAGE");
	public final By ITEM_PRICE = getLocator("ITEM_PRICE");
	public final By ITEM_POSTAGE = getLocator("ITEM_POSTAGE");
	public final By ITEM_TIMELEFT = getLocator("ITEM_TIMELEFT");
	public final By CHECKBOX = getLocator("CHECKBOX");
	public final By CANCEL_LNK = getLocator("CANCEL_LNK");
	public final By DELETE_ICON = getLocator("DELETE_ICON");
	public final By DELETE_YES = getLocator("DELETE_YES");
	public final By BID_COUNT = getLocator("BID_COUNT");
	public final By BID_SORT_LNK = getLocator("BID_SORT_LNK");
	public final By ENDING_SOONEST_SORT = getLocator("ENDING_SOONEST_SORT");
	public final By NEWEST_LISTING_SORT = getLocator("NEWEST_LISTING_SORT");
	public final By PRICED_LOWEST_SORT = getLocator("PRICED_LOWEST_SORT");
	public final By PRICED_HIGHEST_SORT = getLocator("PRICED_HIGHEST_SORT");
	public final By SORT_CANCEL = getLocator("SORT_CANCEL");	
	

	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "BIDS_TAB",By.xpath("//android.widget.TextView[@text='Bids' or @text='BIDS']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "OFFERS_TAB",By.xpath("//android.widget.TextView[@text='Offers' or @text='OFFERS']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DIDNTWIN_TAB",By.xpath("//android.widget.TextView[contains(@text,'win') or contains(@text,'WIN')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DIDNTWIN_EDIT_LNK",By.xpath("//android.widget.Button[@text='Edit' or @text='EDIT']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ALL_ITEMS",By.id("com.ebay.mobile:id/main_item_container"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BID_STATUS",By.id("com.ebay.mobile:id/item_user_status"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TITLE",By.id("com.ebay.mobile:id/item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "IMAGE_IMAGE",By.id("com.ebay.mobile:id/image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_PRICE",By.id("com.ebay.mobile:id/item_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_POSTAGE",By.id("com.ebay.mobile:id/item_shipping_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TIMELEFT",By.id("com.ebay.mobile:id/item_time_left"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CHECKBOX",By.id("com.ebay.mobile:id/multiselect_checkbox"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CANCEL_LNK",By.xpath("//android.widget.Button[@text='Cancel']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_ICON",By.id("com.ebay.mobile:id/menu_item_delete"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_YES",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BID_COUNT",By.id("com.ebay.mobile:id/item_bid_count"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BID_SORT_LNK",By.id("com.ebay.mobile:id/button_refine"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ENDING_SOONEST_SORT",By.xpath("//android.widget.CheckedTextView[@text='Ending soonest']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "NEWEST_LISTING_SORT",By.xpath("//android.widget.CheckedTextView[@text='Newest listings']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRICED_LOWEST_SORT",By.xpath("//android.widget.CheckedTextView[@text='Priced lowest']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRICED_HIGHEST_SORT",By.xpath("//android.widget.CheckedTextView[@text='Priced highest']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SORT_CANCEL",By.xpath("//android.widget.Button[@text='Cancel' or @text='CANCEL']"));
		
	}
}
