package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.WatchingComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class WatchingLocators extends BasePageObject<WatchingComponent>{

	protected WatchingLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public final By ACTIVE_TAB = getLocator("ACTIVE_TAB");
	public final By ENDED_TAB = getLocator("ENDED_TAB");
	public final By EDIT_LNK = getLocator("EDIT_LNK");
	public final By SORT_LNK = getLocator("SORT_LNK");
	public final By FIRST_ITEM=getLocator("FIRST_ITEM");
	public final By IMAGE_IMAGE=getLocator("IMAGE_IMAGE");
	public final By ITEM_MSKU_TITLE=getLocator("ITEM_MSKU_TITLE");
	public final By ITEM_TITLE=getLocator("ITEM_TITLE");
	public final By ITEM_PRICE=getLocator("ITEM_PRICE");
	public final By ITEM_POSTAGE=getLocator("ITEM_POSTAGE");
	public final By ITEM_TIMELEFT=getLocator("ITEM_TIMELEFT");
	public final By ITEM_CHECKBOX=getLocator("ITEM_TIMELEFT");
	public final By DELETE_ITEM=getLocator("DELETE_ITEM");
	public final By CANCEL_ITEM=getLocator("CANCEL_ITEM");
	public final By SORT_LINK=getLocator("SORT_LINK");
	public final By ENDING_SOONEST_FILTER=getLocator("ENDING_SOONEST_FILTER");
	public final By NEWEST_LISTING_FILTER=getLocator("NEWEST_LISTING_FILTER");
	public final By PRICED_LOWEST_FILTER=getLocator("PRICED_LOWEST_FILTER");
	public final By PRICED_HIGHEST_FILTER=getLocator("PRICED_HIGHEST_FILTER");
	public final By RECENTLY_ADDED_FILTER=getLocator("RECENTLY_ADDED_FILTER");
	public final By SORT_CANCEL=getLocator("SORT_CANCEL");
	public final By ALL_ITEMS=getLocator("ALL_ITEMS");
	
	public final By WATCH_CAT_CONTAINER=getLocator("WATCH_CAT_CONTAINER");
	public final By WATCH_CAT_CONTAINER_CATTITLE=getLocator("WATCH_CAT_CONTAINER_CATTITLE");
	
	@Override
	protected void setLocators() {
		setLocator(LocatorType.ANDROID_LOCATOR, "ACTIVE_TAB",By.xpath("//android.widget.TextView[@text='Active' or @text='ACTIVE']"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "ENDED_TAB",By.xpath("//android.widget.TextView[@text='Ended' or @text='ENDED']"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "EDIT_LNK",By.xpath("//android.widget.Button[@text='Edit' or @text='EDIT']"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "SORT_LNK",By.xpath("//android.widget.Button[@text='Sort' or @text='SORT']"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "FIRST_ITEM",By.xpath("(//android.widget.RelativeLayout)[1]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "IMAGE_IMAGE",By.id("com.ebay.mobile:id/image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_MSKU_TITLE",By.id("com.ebay.mobile:id/item_msku_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TITLE",By.id("com.ebay.mobile:id/item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_PRICE",By.id("com.ebay.mobile:id/item_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_POSTAGE",By.id("com.ebay.mobile:id/item_shipping_price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_TIMELEFT",By.id("com.ebay.mobile:id/item_time_left"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ITEM_CHECKBOX",By.id("com.ebay.mobile:id/multiselect_checkbox"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_ITEM",By.id("com.ebay.mobile:id/menu_item_delete"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CANCEL_ITEM",By.xpath("//android.widget.Button[@text='Cancel']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SORT_LINK",By.id("com.ebay.mobile:id/button_refine"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ENDING_SOONEST_FILTER",By.xpath("//android.widget.CheckedTextView[@text='Ending soonest']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "NEWEST_LISTING_FILTER",By.xpath("//android.widget.CheckedTextView[@text='Newest listings']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRICED_LOWEST_FILTER",By.xpath("//android.widget.CheckedTextView[@text='Priced lowest']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRICED_HIGHEST_FILTER",By.xpath("//android.widget.CheckedTextView[@text='Priced highest']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RECENTLY_ADDED_FILTER",By.xpath("//android.widget.CheckedTextView[@text='Recently added']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SORT_CANCEL",By.id("android:id/button2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ALL_ITEMS",By.id("com.ebay.mobile:id/main_item_container"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "WATCH_CAT_CONTAINER",By.id("com.ebay.mobile:id/watch_category_container"));
			setLocator(LocatorType.ANDROID_LOCATOR, "WATCH_CAT_CONTAINER_CATTITLE",By.id("com.ebay.mobile:id/item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
	}
}
