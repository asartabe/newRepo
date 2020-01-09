package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.FollowingsPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class FollowingsPageComponentLocators extends BasePageObject<FollowingsPageComponent>{

	protected FollowingsPageComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By TAB_SEARCHES = getLocator("TAB_SEARCHES");
	public final By TAB_MEMBERS = getLocator("TAB_MEMBERS");
	public final By TAB_COLLECTIONS = getLocator("TAB_COLLECTIONS");
	
	public final By BTN_EDIT = getLocator("BTN_EDIT");
	public final By BTN_DELETE = getLocator("BTN_DELETE");
	public final By BTN_DONE = getLocator("BTN_EDIT");
		public final By REMOVE_YES = getLocator("REMOVE_YES");
		public final By REMOVE_NO = getLocator("REMOVE_NO");
	
	public final By BTN_SORT = getLocator("BTN_SORT");
		public final By SORT_OPT_BYNAME = getLocator("SORT_OPT_BYNAME");
		public final By SORT_OPT_DATEADDED = getLocator("SORT_OPT_DATEADDED");
		public final By SORT_OPT_LASTVIEWED = getLocator("SORT_OPT_LASTVIEWED");
		public final By SORT_CANCEL = getLocator("SORT_CANCEL");
	
	public final By FOLLOWED_ITM_CONTAINER = getLocator("FOLLOWED_ITM_CONTAINER");
		public final By FOLLOWED_ITM_SRCH_TITLE = getLocator("FOLLOWED_ITM_SRCH_TITLE");
		public final By FOLLOWED_ITM_SRCH_PHONE_NOTIF = getLocator("FOLLOWED_ITM_SRCH_PHONE_NOTIF");
		public final By FOLLOWED_ITM_SRCH_MAIL_NOTIF = getLocator("FOLLOWED_ITM_SRCH_MAIL_NOTIF");
		
		public final By FOLLOWED_ITM_MEMBER_TITLE = getLocator("FOLLOWED_ITM_MEMBER_TITLE");
		public final By FOLLOWED_ITM_MEMBER_IMG = getLocator("FOLLOWED_ITM_MEMBER_IMG");
		
		public final By FOLLOWED_ITM_CLXN_IMAGES = getLocator("FOLLOWED_ITM_CLXN_IMAGES");
		public final By FOLLOWED_ITM_CLXN_DETAILS = getLocator("FOLLOWED_ITM_CLXN_DETAILS");
			public final By FOLLOWED_ITM_CLXN_DETAILS_TITLE = getLocator("FOLLOWED_ITM_CLXN_DETAILS_TITLE");
			public final By FOLLOWED_ITM_CLXN_DETAILS_SUBTITLE = getLocator("FOLLOWED_ITM_CLXN_DETAILS_SUBTITLE");
		
		public final By FOLLOWED_ITM_CHKBOX = getLocator("FOLLOWED_ITM_CHKBOX");
		
	public final By MY_FEED_HDR = getLocator("MY_FEED_HDR");
	public final By MY_FEED_SUBTITLE = getLocator("MY_FEED_SUBTITLE");
	public final By MY_FEED_ITEMS = getLocator("MY_FEED_ITEMS");
		
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_EDIT",By.id("com.ebay.mobile:id/button_edit"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_SORT",By.id("com.ebay.mobile:id/button_refine"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SORT_OPT_BYNAME",By.xpath("//android.widget.CheckedTextView[@text='By Name']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SORT_OPT_DATEADDED",By.xpath("//android.widget.CheckedTextView[@text='Date Added']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SORT_OPT_LASTVIEWED",By.xpath("//android.widget.CheckedTextView[@text='Last Viewed']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SORT_CANCEL",By.id("android:id/button2"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_CONTAINER",By.id("com.ebay.mobile:id/main_item_container"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_SRCH_TITLE",By.id("com.ebay.mobile:id/following_item_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_SRCH_MAIL_NOTIF",By.id("com.ebay.mobile:id/email_notification_icon"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_SRCH_PHONE_NOTIF",By.id("com.ebay.mobile:id/push_notification_icon"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_MEMBER_TITLE",By.id("android:id/text1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_MEMBER_IMG",By.id("com.ebay.mobile:id/thumbnail"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_CHKBOX",By.id("com.ebay.mobile:id/multiselect_checkbox"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_CLXN_IMAGES",By.id("com.ebay.mobile:id/images_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_CLXN_DETAILS",By.id("com.ebay.mobile:id/collection_title_subtitle"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_CLXN_DETAILS_TITLE",By.id("com.ebay.mobile:id/title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ITM_CLXN_DETAILS_SUBTITLE",By.id("com.ebay.mobile:id/subtitle"));
			
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_DELETE",By.id("com.ebay.mobile:id/menu_item_delete"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "REMOVE_YES",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REMOVE_NO",By.id("android:id/button2"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "MY_FEED_HDR",By.xpath("//android.widget.TextView[@text='My Feed']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "MY_FEED_SUBTITLE",By.id("com.ebay.mobile:id/feed_header_subtitle"));
		setLocator(LocatorType.ANDROID_LOCATOR, "MY_FEED_ITEMS",By.xpath("//*[contains(@resource-id, 'com.ebay.mobile:id/following_feed_item')]"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_SEARCHES",By.xpath("//android.widget.TextView[@text='SEARCHES' or @text='Searches']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_MEMBERS",By.xpath("//android.widget.TextView[@text='MEMBERS' or @text='Members' or @text='SELLERS' or @text='Sellers']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_COLLECTIONS",By.xpath("//android.widget.TextView[@text='COLLECTIONS' or @text='Collections']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
	}

}
