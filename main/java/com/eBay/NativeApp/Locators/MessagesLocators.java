package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.MessagesComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class MessagesLocators extends BasePageObject<MessagesComponent> {

	protected MessagesLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By MESSAGE_BAR = getLocator("MESSAGE_BAR"); 
	public final By UNREAD_MSG_COUNT=getLocator("UNREAD_MSG_COUNT");
	public final By INBOX_TAB=getLocator("INBOX_TAB");
	public final By INBOX_COUNT=getLocator("INBOX_COUNT");
	public final By SENT_TAB=getLocator("SENT_TAB");
	public final By MYFOLDER_TAB=getLocator("MYFOLDER_TAB");
	public final By ARCHIVE_TAB=getLocator("ARCHIVE_TAB");
	public final By ALL_MSGS_DROPDWN=getLocator("ALL_MSGS_DROPDWN");
	public final By UNREAD_DRPDWN=getLocator("UNREAD_DRPDWN");
	public final By FIRST_UNREAD_MSG_LNK=getLocator("FIRST_UNREAD_MSG_LNK");
	public final By UNREAD_CHCKBOX=getLocator("UNREAD_CHCKBOX");
	public final By READ_UNREAD_ICON=getLocator("READ_UNREAD_ICON");
	@Override
	protected void setLocators(){
		setLocator(LocatorType.ANDROID_LOCATOR, "MESSAGE_BAR",By.id("com.ebay.mobile:id/menuitem_messages"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNREAD_MSG_COUNT",By.id("com.ebay.mobile:id/nav_count"));
		setLocator(LocatorType.ANDROID_LOCATOR, "INBOX_TAB",By.xpath("//android.widget.TextView[@text='INBOX']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SENT_TAB",By.xpath("//android.widget.TextView[@text='SENT']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "MYFOLDER_TAB",By.xpath("//android.widget.TextView[@text='MY FOLDER 1']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "INBOX_COUNT",By.xpath("(//android.widget.TextView[@index='1'])[2]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ARCHIVE_TAB",By.xpath("//android.widget.TextView[@text='ARCHIVE']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ALL_MSGS_DROPDWN",By.xpath("//android.widget.TextView[@text='All Messages']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNREAD_DRPDWN",By.xpath("//android.widget.CheckedTextView[@text='Unread']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FIRST_UNREAD_MSG_LNK",By.xpath("//android.widget.FrameLayout[@index='2']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNREAD_CHCKBOX",By.id("com.ebay.mobile:id/selection"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "READ_UNREAD_ICON",By.id("com.ebay.mobile:id/unread"));
		
	}
	
}
