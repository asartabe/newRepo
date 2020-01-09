package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.DealsContentComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class DealsContentComponentLocators extends BasePageObject<DealsContentComponent>{

	protected DealsContentComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By FEATURED_DEALS_CONTAINER = getLocator("FEATURED_DEALS_CONTAINER");
		public final By FEATURED_DEALS_HEADER = getLocator("FEATURED_DEALS_HEADER");
			public final By FEATURED_DEALS_HDR_TITLE = getLocator("FEATURED_DEALS_HDR_TITLE");
			public final By FEATURED_DEALS_HDR_MORE = getLocator("FEATURED_DEALS_HDR_MORE");
			public final By FEATURED_DEALS_CARD = getLocator("FEATURED_DEALS_CARD");
				public final By FEATURED_DEALS_CARD_IMG = getLocator("FEATURED_DEALS_CARD_IMG");
				public final By FEATURED_DEALS_CARD_TITLE = getLocator("FEATURED_DEALS_CARD_TITLE");
				public final By FEATURED_DEALS_CARD_PRICE = getLocator("FEATURED_DEALS_CARD_PRICE");
				public final By FEATURED_DEALS_CARD_STP = getLocator("FEATURED_DEALS_CARD_STP");
	
	public final By TRENDING_DEALS_CONTAINER = getLocator("TRENDING_DEALS_CONTAINER");
		public final By TRENDING_DEALS_HEADER = getLocator("TRENDING_DEALS_HEADER");
			public final By TRENDING_DEALS_HDR_TITLE = getLocator("TRENDING_DEALS_HDR_TITLE");
			public final By TRENDING_DEALS_HDR_MORE = getLocator("TRENDING_DEALS_HDR_MORE");
			public final By TRENDING_DEALS_CARD = getLocator("TRENDING_DEALS_CARD");
				public final By TRENDING_DEALS_CARD_IMG = getLocator("TRENDING_DEALS_CARD_IMG");
				public final By TRENDING_DEALS_CARD_TITLE = getLocator("TRENDING_DEALS_CARD_TITLE");
				public final By TRENDING_DEALS_CARD_PRICE = getLocator("TRENDING_DEALS_CARD_PRICE");

	public final By FEATURED_EVENT_HDR = getLocator("FEATURED_EVENT_HDR");
		public final By FEATURED_EVENT_TILE = getLocator("FEATURED_EVENT_TILE");
			public final By FEATURED_EVENT_TILE_IMG = getLocator("FEATURED_EVENT_TILE_IMG");
			public final By FEATURED_EVENT_TILE_TITLE = getLocator("FEATURED_EVENT_TILE_TITLE");
			public final By FEATURED_EVENT_TILE_DESC = getLocator("FEATURED_EVENT_TILE_DESC");
					
	public final By SALES_EVENTS_HDR = getLocator("SALES_EVENTS_HDR");
		public final By SALES_EVENTS_CAROUSEL = getLocator("SALES_EVENTS_CAROUSEL");
			public final By SALES_EVENTS_CAROUSEL_EVENT = getLocator("SALES_EVENTS_CAROUSEL_EVENT");
				public final By SALES_EVENTS_CAROUSEL_EVENT_IMG = getLocator("SALES_EVENTS_CAROUSEL_EVENT_IMG");
				public final By SALES_EVENTS_CAROUSEL_EVENT_TITLE = getLocator("SALES_EVENTS_CAROUSEL_EVENT_TITLE");
				public final By SALES_EVENTS_CAROUSEL_EVENT_DESC = getLocator("SALES_EVENTS_CAROUSEL_EVENT_DESC");
					
	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_CONTAINER",By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Featured Deals')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_HEADER",By.id("com.ebay.mobile:id/titleLayout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_HDR_TITLE",By.id("com.ebay.mobile:id/title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_HDR_MORE",By.id("com.ebay.mobile:id/more_button"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_CARD",By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'com.ebay.mobile:id/card_item_')]"));
					setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_CARD_IMG",By.id("com.ebay.mobile:id/item_image"));
					setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_CARD_TITLE",By.id("com.ebay.mobile:id/item_title"));
					setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_CARD_PRICE",By.id("com.ebay.mobile:id/item_price"));
					setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_DEALS_CARD_STP",By.id("com.ebay.mobile:id/item_price_details"));
				
		setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_DEALS_CONTAINER",By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Trending deals')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_DEALS_HEADER",By.id("com.ebay.mobile:id/titleLayout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_DEALS_HDR_TITLE",By.id("com.ebay.mobile:id/title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_DEALS_HDR_MORE",By.id("com.ebay.mobile:id/more_button"));
				setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_DEALS_CARD",By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'card_item_')]"));
					setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_DEALS_CARD_IMG",By.id("com.ebay.mobile:id/item_image"));
					setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_DEALS_CARD_TITLE",By.id("com.ebay.mobile:id/item_title"));
					setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_DEALS_CARD_PRICE",By.id("com.ebay.mobile:id/item_price"));
				
		setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_EVENT_HDR",By.xpath("//android.widget.TextView[@text='Featured event']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_EVENT_TILE",By.id("com.ebay.mobile:id/event_container"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_EVENT_TILE_IMG",By.id("com.ebay.mobile:id/imageview_events"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_EVENT_TILE_TITLE",By.id("com.ebay.mobile:id/item_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEATURED_EVENT_TILE_DESC",By.id("com.ebay.mobile:id/item_description"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SALES_EVENTS_HDR",By.xpath("//android.widget.TextView[@text='Sales and events']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SALES_EVENTS_CAROUSEL",By.id("com.ebay.mobile:id/carousel_card_view"));
				setLocator(LocatorType.ANDROID_LOCATOR, "SALES_EVENTS_CAROUSEL_EVENT",By.id("com.ebay.mobile:id/event_container"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SALES_EVENTS_CAROUSEL_EVENT_IMG",By.id("com.ebay.mobile:id/imageview_events"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SALES_EVENTS_CAROUSEL_EVENT_TITLE",By.id("com.ebay.mobile:id/item_title"));
					setLocator(LocatorType.ANDROID_LOCATOR, "SALES_EVENTS_CAROUSEL_EVENT_DESC",By.id("com.ebay.mobile:id/item_description"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
	}

	
}
