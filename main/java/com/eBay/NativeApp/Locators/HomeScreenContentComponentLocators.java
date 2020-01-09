package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.HomeScreenContentComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class HomeScreenContentComponentLocators extends BasePageObject<HomeScreenContentComponent>{

	protected HomeScreenContentComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*REGISTER/SIGNIN BUTTONS*/
	public final By REGISTER_BTN = getLocator("REGISTER_BTN");
	public final By SIGNIN_BTN = getLocator("SIGNIN_BTN");
	
	/*HOMESCREEN PILLS*/
	public final By PILL_SELLING = getLocator("PILL_SELLING");
	public final By PILL_DEALS = getLocator("PILL_DEALS");
	public final By PILL_CATEGORIES = getLocator("PILL_CATEGORIES");
	public final By PILL_FOLLOWING = getLocator("PILL_FOLLOWING");
	
	/*FEATURED_DEALS*/
	public final By FEAT_DEALS_CONTAINER = getLocator("FEAT_DEALS_CONTAINER");
	public final By FEAT_DEALS_TITLE = getLocator("FEAT_DEALS_TITLE");
	public final By FEAT_DEALS_MORE = getLocator("FEAT_DEALS_MORE");
		public final By FEAT_DEALS_CARDS = getLocator("FEAT_DEALS_CARDS");
		public final By FEAT_DEALS_CARD1 = getLocator("FEAT_DEALS_CARD1");
		public final By FEAT_DEALS_CARD2 = getLocator("FEAT_DEALS_CARD2");
		public final By FEAT_DEALS_CARD3 = getLocator("FEAT_DEALS_CARD3");
			public final By FEAT_DEALS_ITMIMG = getLocator("FEAT_DEALS_ITMIMG");
			public final By FEAT_DEALS_ITMTITLE = getLocator("FEAT_DEALS_ITMTITLE");
			public final By FEAT_DEALS_ITMPRICE = getLocator("FEAT_DEALS_ITMPRICE");
			public final By FEAT_DEALS_ITMPRICE2 = getLocator("FEAT_DEALS_ITMPRICE2");
	
	/*TRENDING ON EBAY*/
	public final By TRENDING_CONTAINER = getLocator("TRENDING_CONTAINER");
	public final By TRENDING_TITLE = getLocator("TRENDING_TITLE");
	public final By TRENDING_MORE = getLocator("TRENDING_MORE");
		public final By TRENDING_TILES = getLocator("TRENDING_TILES");
		public final By TRENDING_TILE1 = getLocator("TRENDING_TILE1");
		public final By TRENDING_TILE2 = getLocator("TRENDING_TILE2");
		public final By TRENDING_TILE3 = getLocator("TRENDING_TILE3");
			public final By TRENDING_TILE_POSITION = getLocator("TRENDING_TILE_POSITION");
			public final By TRENDING_TILE_TITLE = getLocator("TRENDING_TILE_TITLE");
			public final By TRENDING_TILE_STATS = getLocator("TRENDING_TILE_STATS");
			public final By TRENDING_TILE_IMG = getLocator("TRENDING_TILE_IMG");
	
	/*COLLECTIONS/HANDPICKED BY EBAY*/
	public final By COLLECTIONS_TITLE = getLocator("COLLECTIONS_TITLE");
	public final By COLLECTIONS_MORE = getLocator("COLLECTIONS_MORE");
		public final By COLLECTIONS_TILES = getLocator("COLLECTIONS_TILES");
			public final By COLLECTIONS_TILE_IMG = getLocator("COLLECTIONS_TILE_IMG");
			public final By COLLECTIONS_TILE_OWNERINFO = getLocator("COLLECTIONS_TILE_OWNERINFO");
			public final By COLLECTIONS_TILE_OWNER_CLXNNAME = getLocator("COLLECTIONS_TILE_OWNER_CLXNNAME");
			public final By COLLECTIONS_TILE_OWNER_NAME = getLocator("COLLECTIONS_TILE_OWNER_NAME");
	
	/*FEATURED SALES & EVENTS*/
	public final By SALES_EVENTS_CONTAINER = getLocator("SALES_EVENTS_CONTAINER");
	public final By EVENTS_TITLE = getLocator("EVENTS_TITLE");
	public final By EVENTS_MORE = getLocator("EVENTS_MORE");
	public final By EVENTS_CONTAINER = getLocator("EVENTS_CONTAINER");
		public final By EVENTS_IMG = getLocator("EVENTS_IMG");
		public final By EVENTS_DETAILS = getLocator("EVENTS_DETAILS");
			public final By EVENT_DESC_TITLE = getLocator("EVENT_DESC_TITLE");
			public final By EVENT_DESC = getLocator("EVENT_DESC");
			public final By EVENT_DESC_TIMELEFT = getLocator("EVENT_DESC_TIMELEFT");		
	
	/*AD*/
	public final By AD_CONTAINER = getLocator("AD_CONTAINER");
		public final By AD_ADVERTISER = getLocator("AD_ADVERTISER");
		public final By AD_ADTEXT = getLocator("AD_ADTEXT");
		public final By AD_IMAGE = getLocator("AD_IMAGE");
		public final By AD_HEADLINE = getLocator("AD_HEADLINE");
		public final By AD_BODYTEXT = getLocator("AD_BODYTEXT");
		public final By AD_CTA_BTN = getLocator("AD_CTA_BTN");
			
	/*NOTIFICATIONS*/	
	public final By NOTIF_CONTAINER = getLocator("NOTIF_CONTAINER");
		public final By NOTIF_TILES = getLocator("NOTIF_TILES");
			public final By NOTIF_TILE_IMG = getLocator("NOTIF_TILE_IMG");
			public final By NOTIF_TILE_TITLE = getLocator("NOTIF_TILE_TITLE");
			public final By NOTIF_TILE_SUBTITLE = getLocator("NOTIF_TILE_SUBTITLE");
		
	/*WATCHING ITEMS*/
	public final By WATCHING_ITEMS_CONTAINER = getLocator("WATCHING_ITEMS_CONTAINER");
		public final By WATCHING_HDR = getLocator("WATCHING_HDR");
		public final By WATCHING_MORE = getLocator("WATCHING_MORE");
		public final By WATCHING_ITEM_TILE = getLocator("WATCHING_ITEM_TILE");
			public final By WATCHING_ITEM_TILE_IMG = getLocator("WATCHING_ITEM_TILE_IMG");
			public final By WATCHING_ITEM_TILE_TITLE = getLocator("WATCHING_ITEM_TILE_TITLE");
			public final By WATCHING_ITEM_TILE_PRICE = getLocator("WATCHING_ITEM_TILE_PRICE");
			public final By WATCHING_ITEM_TILE_TIMELEFT = getLocator("WATCHING_ITEM_TILE_TIMELEFT");
		
	/*RECENTLY VIEWED ITEMS*/
	public final By RVI_CONTAINER = getLocator("RVI_CONTAINER");
		public final By RVI_HDR = getLocator("RVI_HDR");
		public final By RVI_MORE = getLocator("RVI_MORE");
		public final By RVI_ITEMS_PARENT_LIST = getLocator("RVI_ITEMS_PARENT_LIST");
			public final By RVI_ITEMS_CHILD_TILES = getLocator("RVI_ITEMS_CHILD_TILES");
				public final By RVI_ITM_TILE_IMG = getLocator("RVI_ITM_TILE_IMG");
				public final By RVI_ITM_TILE_TITLE = getLocator("RVI_ITM_TILE_TITLE");
				public final By RVI_ITM_TILE_PRICE = getLocator("RVI_ITM_TILE_PRICE");
			
	@Override
	protected void setLocators() {

		/*REGISTER/SIGNIN BUTTONS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "REGISTER_BTN",By.id("com.ebay.mobile:id/button_register"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SIGNIN_BTN",By.id("com.ebay.mobile:id/button_sign_in"));
		
		/*HOMESCREEN PILLS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "PILL_SELLING",By.xpath("//android.widget.TextView[@content-desc='Sellingbutton']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PILL_DEALS",By.xpath("//android.widget.TextView[@content-desc='Dealsbutton']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PILL_CATEGORIES",By.xpath("//android.widget.TextView[@content-desc='Categoriesbutton']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PILL_FOLLOWING",By.xpath("//android.widget.TextView[@content-desc='Savedbutton']"));
		
		/*FEATURED_DEALS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_CONTAINER",By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Featured Deals')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_TITLE",By.id("com.ebay.mobile:id/textview_deals"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_MORE",By.id("com.ebay.mobile:id/button_all_deals"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_CARDS",By.xpath("//*[contains(@resource-id,'com.ebay.mobile:id/card_item_')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_CARD1",By.id("com.ebay.mobile:id/card_item_1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_CARD2",By.id("com.ebay.mobile:id/card_item_2"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_CARD3",By.id("com.ebay.mobile:id/card_item_3"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_ITMIMG",By.id("com.ebay.mobile:id/imageview_deals"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_ITMTITLE",By.id("com.ebay.mobile:id/item_title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_ITMPRICE",By.id("com.ebay.mobile:id/item_price"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FEAT_DEALS_ITMPRICE2",By.id("com.ebay.mobile:id/item_price_details"));
		
		/*TRENDING ON EBAY*/
		setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_CONTAINER",By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Trending on eBay')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TITLE",By.id("com.ebay.mobile:id/textview_trending"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_MORE",By.id("com.ebay.mobile:id/button_all_trending"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TILES",By.xpath("//*[contains(@resource-id,'com.ebay.mobile:id/trending_item_')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TILE1",By.id("com.ebay.mobile:id/trending_item_0"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TILE2",By.id("com.ebay.mobile:id/trending_item_1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TILE3",By.id("com.ebay.mobile:id/trending_item_2"));
			setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TILE_POSITION",By.id("com.ebay.mobile:id/trend_topic_position"));
			setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TILE_TITLE",By.id("com.ebay.mobile:id/trend_topic_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TILE_STATS",By.id("com.ebay.mobile:id/trend_topic_stat"));
			setLocator(LocatorType.ANDROID_LOCATOR, "TRENDING_TILE_IMG",By.id("com.ebay.mobile:id/imageview_trending"));
		
		/*COLLECTIONS/HANDPICKED BY EBAY*/
		setLocator(LocatorType.ANDROID_LOCATOR, "COLLECTIONS_CONTAINER",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "COLLECTIONS_TITLE",By.id("com.ebay.mobile:id/textview_collections"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COLLECTIONS_MORE",By.id("com.ebay.mobile:id/button_all_collections"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COLLECTIONS_TILES",By.id("com.ebay.mobile:id/selectable"));
			setLocator(LocatorType.ANDROID_LOCATOR, "COLLECTIONS_TILE_IMG",By.id("com.ebay.mobile:id/imageview_collections"));
			setLocator(LocatorType.ANDROID_LOCATOR, "COLLECTIONS_TILE_OWNERINFO",By.id("com.ebay.mobile:id/collection_owner_info"));
				setLocator(LocatorType.ANDROID_LOCATOR, "COLLECTIONS_TILE_OWNER_CLXNNAME",By.id("com.ebay.mobile:id/user_collection_title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "COLLECTIONS_TILE_OWNER_NAME",By.id("com.ebay.mobile:id/user_name_subtitle"));
		
		/*FEATURED SALES & EVENTS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "SALES_EVENTS_CONTAINER",By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Featured Sales')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "EVENTS_TITLE",By.id("com.ebay.mobile:id/textview_events"));
		setLocator(LocatorType.ANDROID_LOCATOR, "EVENTS_MORE",By.id("com.ebay.mobile:id/button_all_events"));
			setLocator(LocatorType.ANDROID_LOCATOR, "EVENTS_CONTAINER",By.id("com.ebay.mobile:id/event_container"));
				setLocator(LocatorType.ANDROID_LOCATOR, "EVENTS_IMG",By.id("com.ebay.mobile:id/imageview_events"));
				setLocator(LocatorType.ANDROID_LOCATOR, "EVENTS_DETAILS",By.id("com.ebay.mobile:id/event_text_container"));
					setLocator(LocatorType.ANDROID_LOCATOR, "EVENT_DESC_TITLE",By.id("com.ebay.mobile:id/item_title"));
					setLocator(LocatorType.ANDROID_LOCATOR, "EVENT_DESC",By.id("com.ebay.mobile:id/item_description"));
					setLocator(LocatorType.ANDROID_LOCATOR, "EVENT_DESC_TIMELEFT",By.id("com.ebay.mobile:id/item_timeLeft"));
		
		/*AD*/
		setLocator(LocatorType.ANDROID_LOCATOR, "AD_CONTAINER",By.id("com.ebay.mobile:id/homescreen_ad_container"));
			setLocator(LocatorType.ANDROID_LOCATOR, "AD_ADVERTISER",By.id("com.ebay.mobile:id/ad_advertiser"));
			setLocator(LocatorType.ANDROID_LOCATOR, "AD_ADTEXT",By.id("com.ebay.mobile:id/ad_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "AD_IMAGE",By.id("com.ebay.mobile:id/ad_image"));
			setLocator(LocatorType.ANDROID_LOCATOR, "AD_HEADLINE",By.id("com.ebay.mobile:id/ad_headline"));
			setLocator(LocatorType.ANDROID_LOCATOR, "AD_BODYTEXT",By.id("com.ebay.mobile:id/ad_body"));
			setLocator(LocatorType.ANDROID_LOCATOR, "AD_CTA_BTN",By.id("com.ebay.mobile:id/ad_call_to_action"));
		
		/*NOTIFICATIONS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_CONTAINER",By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Notifications')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TILES",By.xpath("//*[contains(@resource-id,'com.ebay.mobile:id/card_notification_item_')]"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TILE_IMG",By.id("com.ebay.mobile:id/notification_item_image"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TILE_TITLE",By.id("com.ebay.mobile:id/notification_item_title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NOTIF_TILE_SUBTITLE",By.id("com.ebay.mobile:id/notification_item_details"));
		
		/*WATCHED ITEMS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_ITEMS_CONTAINER",By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Watched Items')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_HDR",By.id("com.ebay.mobile:id/textview_watching"));
			setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_MORE",By.id("com.ebay.mobile:id/button_all_watching"));
			setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_ITEM_TILE",By.id("com.ebay.mobile:id/button_watch_item"));
				setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_ITEM_TILE_IMG",By.id("com.ebay.mobile:id/watching_image"));
				setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_ITEM_TILE_TITLE",By.id("com.ebay.mobile:id/watching_title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_ITEM_TILE_PRICE",By.id("com.ebay.mobile:id/watching_price"));
				setLocator(LocatorType.ANDROID_LOCATOR, "WATCHING_ITEM_TILE_TIMELEFT",By.id("com.ebay.mobile:id/watching_timeleft"));
		
		/*RECENTLY VIEWED ITEMS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "RVI_CONTAINER",By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Recently Viewed')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RVI_HDR",By.id("com.ebay.mobile:id/textview_recently_viewed"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RVI_MORE",By.id("com.ebay.mobile:id/button_all_recent"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RVI_ITEMS_PARENT_LIST",By.id("com.ebay.mobile:id/carousel_list"));
			setLocator(LocatorType.ANDROID_LOCATOR, "RVI_ITEMS_CHILD_TILES",By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "RVI_ITM_TILE_IMG",By.id("com.ebay.mobile:id/imageview_item"));
				setLocator(LocatorType.ANDROID_LOCATOR, "RVI_ITM_TILE_TITLE",By.id("com.ebay.mobile:id/item_title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "RVI_ITM_TILE_PRICE",By.id("com.ebay.mobile:id/item_price"));
		
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
	}

}
