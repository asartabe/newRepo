package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SignInComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SignInComponentLocators extends BasePageObject<SignInComponent>{

	protected SignInComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By TXT_USERNAME = getLocator("TXT_USERNAME");
	public final By TXT_PASSWORD = getLocator("TXT_PASSWORD");
	public final By BTN_LOGIN = getLocator("BTN_LOGIN");
	public final By LBL_PLEASESIGN_IN = getLocator("LBL_PLEASESIGN_IN");
	public final By LBL_NEWTOEBAY = getLocator("LBL_NEWTOEBAY");
	public final By BTN_SIGNIN_CLOSE  = getLocator("BTN_SIGNIN_CLOSE");
	public final By BTN_SHOWHIDE_PASSWORD = getLocator("BTN_SHOWHIDE_PASSWORD");
	public final By BTN_REGISTER = getLocator("BTN_REGISTER");
	public final By LNK_FORGOT = getLocator("LNK_FORGOT");
		public final By BTN_CLASSIC = getLocator("BTN_CLASSIC");
		public final By BTN_FACEBOOK = getLocator("BTN_FACEBOOK");
		public final By BTN_CREATE_ACCOUNT= getLocator("BTN_CREATE_ACCOUNT");
		
		public final By BTN_NOTHANKS= getLocator("BTN_NOTHANKS");

	@Override
	public void setLocators()
	{
		setLocator(LocatorType.ANDROID_LOCATOR, "TXT_USERNAME", By.id("com.ebay.mobile:id/edit_text_username"));	//com.ebay.mobile:id/sign_in_username_entry
		setLocator(LocatorType.ANDROID_LOCATOR, "TXT_PASSWORD", By.id("com.ebay.mobile:id/view_ebay_password"));	//com.ebay.mobile:id/sign_in_password_entry
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_LOGIN", By.id("com.ebay.mobile:id/button_sign_in"));	 //com.ebay.mobile:id/button_sign_in
		setLocator(LocatorType.ANDROID_LOCATOR, "LBL_PLEASESIGN_IN", By.id("com.ebay.mobile:id/sign_in_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_SIGNIN_CLOSE", By.id("com.ebay.mobile:id/button_close"));	//com.ebay.mobile:id/sign_in_close
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_SHOWHIDE_PASSWORD", By.id("com.ebay.mobile:id/text_show_password"));	//com.ebay.mobile:id/sign_in_show_hide
		setLocator(LocatorType.ANDROID_LOCATOR, "LBL_NEWTOEBAY", By.xpath("//android.widget.TextView[@text='New to eBay?']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_REGISTER", By.id("com.ebay.mobile:id/button_register"));	//com.ebay.mobile:id/register_button
		setLocator(LocatorType.ANDROID_LOCATOR, "LNK_FORGOT", By.id("com.ebay.mobile:id/button_forgot"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_CLASSIC", By.id("com.ebay.mobile:id/button_classic"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_FACEBOOK", By.id("com.ebay.mobile:id/button_facebook"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_CREATE_ACCOUNT", By.id("com.ebay.mobile:id/button_create_account"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BTN_NOTHANKS", By.id("com.ebay.mobile:id/button_google_deny"));
		

	}

}
