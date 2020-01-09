package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.HamburgerMenuTopComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class HamburgerMenuTopComponentLocators extends BasePageObject<HamburgerMenuTopComponent>{

	protected HamburgerMenuTopComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public final By HAM_SIGN_LNK = getLocator("HAM_SIGN_LNK");
	public final By HOME_LNK = getLocator("HOME_LNK");
	public final By NOTIFICATION_LNK = getLocator("NOTIFICATION_LNK");
	public final By MESSAGES_LNK = getLocator("MESSAGES_LNK");
	
	public final By USER_NAME_LINK = getLocator("USER_NAME_LINK");	
	public final By HAM_SIGN_OUT = getLocator("HAM_SIGN_OUT");
	
	/*public final By SIGNIN_LNK = getLocator("SIGNIN_LNK");
	public final By HOME_LNK = getLocator("HOME_LNK");
	public final By NOTIFS_LNK = getLocator("NOTIFS_LNK");
	public final By MSGZ_LNK = getLocator("MSGZ_LNK");*/

	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "HAM_SIGN_LNK",By.xpath("//android.widget.TextView[@text='Sign in' or @text='SIGN IN']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "HOME_LNK",By.xpath("//android.widget.CheckedTextView[@text='Home']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIFICATION_LNK",By.xpath("//android.widget.CheckedTextView[@text='Notifications']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "MESSAGES_LNK",By.xpath("//android.widget.CheckedTextView[@text='Messages']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "USER_NAME_LINK",By.id("com.ebay.mobile:id/textview_sign_in_status"));
		setLocator(LocatorType.ANDROID_LOCATOR, "HAM_SIGN_OUT",By.xpath("//android.widget.CheckedTextView[@text='Sign out']"));
		
		/*setLocator(LocatorType.ANDROID_LOCATOR, "SIGNIN_LNK",By.id("com.ebay.mobile:id/textview_sign_out_status"));
		setLocator(LocatorType.ANDROID_LOCATOR, "HOME_LNK",By.xpath("//android.widget.CheckedTextView[@text='Home']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIFS_LNK",By.xpath("//android.widget.CheckedTextView[@text='Notifications']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "MSGZ_LNK",By.xpath("//android.widget.CheckedTextView[@text='Messages']"));*/
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
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
