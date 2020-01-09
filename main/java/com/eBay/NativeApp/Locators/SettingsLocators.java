package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SettingsComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SettingsLocators extends BasePageObject<SettingsComponent>{
	
	public SettingsLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By POSTAGE_ADD_LNK = getLocator("POSTAGE_ADD_LNK");
	public final By PRIMARY_ADD_LNK = getLocator("PRIMARY_ADD_LNK");
	
	public final By SIGNOUT_LNK = getLocator("SIGNOUT_LNK");
	
	public final By SIGNIN_LNK = getLocator("SIGNIN_LNK");
	public final By CHNGE_PWD_LNK = getLocator("CHNGE_PWD_LNK");
	
	public final By NOTIFICATIONS_LNK = getLocator("NOTIFICATIONS_LNK");
	public final By COUNTRY_LNK = getLocator("COUNTRY_LNK");
	public final By COUNTRY_SWITCH_TOGGLE = getLocator("COUNTRY_SWITCH_TOGGLE");
	
	public final By CLEAR_HISTORY_LNK = getLocator("CLEAR_HISTORY_LNK");
	public final By USER_AGREEMENT_LNK = getLocator("USER_AGREEMENT_LNK");
	public final By PRIVACY_LNK = getLocator("PRIVACY_LNK");
	public final By ADV_LNK = getLocator("ADV_LNK");
	public final By CUST_SER_LNK = getLocator("CUST_SER_LNK");
	public final By HELP_CONTACT_TEXT = getLocator("HELP_CONTACT_TEXT");
	public final By ABOUT_LNK = getLocator("ABOUT_LNK");

	/*ENTER NEW ADDRESS*/
	public final By NEW_ADD_LINK = getLocator("NEW_ADD_LINK");
	public final By COUNTRY_SELECT = getLocator("COUNTRY_SELECT");
	public final By COUNTRY_TEXTBOX=getLocator("COUNTRY_TEXTBOX");
	public final By COUNTRY_AUS = getLocator("COUNTRY_AUS");
	public final By COUNTRY_US = getLocator("COUNTRY_US");
	public final By COUNTRY_TO_SELECT = getLocator("COUNTRY_TO_SELECT");
	public final By NAME_TXTBOX = getLocator("NAME_TXTBOX");
	public final By PHONE_TXTBOX = getLocator("PHONE_TXTBOX");
	public final By STREET_1_TXTBOX = getLocator("STREET_1_TXTBOX");
	public final By CITY_TEXTBOX = getLocator("CITY_TEXTBOX");
	public final By STATE_DRPDWN = getLocator("STATE_DRPDWN");
	public final By FIRST_STATE = getLocator("FIRST_STATE");
	public final By POSTCODE_TXTBOX = getLocator("POSTCODE_TXTBOX");
	public final By SAVE_BTN=getLocator("SAVE_BTN");
	public final By SAVED_ADDRESS_LST = getLocator("SAVED_ADDRESS_LST");
	public final By SAVED_ADDR_USER_NAME = getLocator("SAVED_ADDR_USER_NAME");
	public final By SAVED_ADDR_OPTIONS_ICON = getLocator("SAVED_ADDR_OPTIONS_ICON");
	public final By DELETE_ADDR_LNK = getLocator("DELETE_ADDR_LNK");
	public final By MAKE_PRIMARY_ADDR_LNK = getLocator("MAKE_PRIMARY_ADDR_LNK");
	public final By EDIT_ADDR_LNK = getLocator("EDIT_ADDR_LNK");
	
	@Override
	protected void setLocators() {
		setLocator(LocatorType.ANDROID_LOCATOR, "POSTAGE_ADD_LNK",By.xpath("//android.widget.TextView[@text='Postage address']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRIMARY_ADD_LNK",By.xpath("//android.widget.TextView[@text='Primary delivery address']"));
	
		setLocator(LocatorType.ANDROID_LOCATOR, "SIGNOUT_LNK",By.xpath("//android.widget.TextView[@text='Sign out']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SIGNIN_LNK",By.xpath("//android.widget.TextView[@text='Signing in']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CHNGE_PWD_LNK",By.xpath("//android.widget.TextView[@text='Change password']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "NOTIFICATIONS_LNK",By.xpath("//android.widget.TextView[@text='Notifications']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_LNK",By.xpath("//android.widget.TextView[@text='Country/region']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_SWITCH_TOGGLE",By.xpath("//android.widget.Switch[@text='ON']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CLEAR_HISTORY_LNK",By.xpath("//android.widget.TextView[@text='Clear search history']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "USER_AGREEMENT_LNK",By.xpath("//android.widget.TextView[@text='User Agreement']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRIVACY_LNK",By.xpath("//android.widget.TextView[@text='Privacy']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ADV_LNK",By.xpath("//android.widget.TextView[@text='Advertising opt-out']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CUST_SER_LNK",By.xpath("//android.widget.TextView[@text='Customer Service']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "HELP_CONTACT_TEXT",By.xpath("//android.widget.TextView[@text='Help & Contact']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ABOUT_LNK",By.xpath("//android.widget.TextView[@text='About']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "NEW_ADD_LINK",By.xpath("//android.widget.TextView[@text='Enter a new address']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_SELECT",By.id("com.ebay.mobile:id/address_edit_country_layout"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_TEXTBOX",By.id("com.ebay.mobile:id/filter"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_AUS",By.xpath("//android.widget.CheckedTextView[@text='Australia']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_US",By.xpath("//android.widget.CheckedTextView[@text='United States']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_TO_SELECT",By.id("com.ebay.mobile:id/check_country"));
		setLocator(LocatorType.ANDROID_LOCATOR, "NAME_TXTBOX",By.xpath("//android.widget.EditText[@text='Name']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PHONE_TXTBOX",By.xpath("//android.widget.EditText[@text='Phone number']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "STREET_1_TXTBOX",By.xpath("//android.widget.EditText[@text='Street 1']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CITY_TEXTBOX",By.xpath("//android.widget.EditText[@text='City']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "STATE_DRPDWN",By.id("android:id/text1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FIRST_STATE",By.xpath("//android.widget.CheckedTextView[@index='1']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "POSTCODE_TXTBOX",By.xpath("//android.widget.EditText[@text='Postcode']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVE_BTN",By.xpath("//android.widget.Button[@text='Save']"));
		//setLocator(LocatorType.ANDROID_LOCATOR, "ADDRESS_LST",By.xpath("//android.widget.LinearLayout"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVED_ADDRESS_LST",By.xpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVED_ADDR_USER_NAME",By.id("com.ebay.mobile:id/xo_cart_address_item_name"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SAVED_ADDR_OPTIONS_ICON",By.xpath("//android.widget.ImageView"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DELETE_ADDR_LNK",By.xpath("//android.widget.TextView[@text='Delete']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "MAKE_PRIMARY_ADDR_LNK",By.xpath("//android.widget.TextView[@text='Make primary']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "EDIT_ADDR_LNK",By.xpath("//android.widget.TextView[@text='Edit']"));
	}
}
