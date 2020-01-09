package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.RegistrationFieldComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class RegistrationFieldComponentLocators extends BasePageObject<RegistrationFieldComponent>{

	protected RegistrationFieldComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/*PPA_FORM_LOCATORS*/
	public final By PERSONALACCT_RADIO = getLocator("PERSONALACCT_RADIO");
	public final By BIZACCT_RADIO = getLocator("BIZACCT_RADIO");
	public final By EMAIL_FLD = getLocator("EMAIL_FLD");
	public final By REEMAIL_FLD = getLocator("REEMAIL_FLD");
	public final By PASSWORD_FLD = getLocator("PASSWORD_FLD");
	public final By FNAME_FLD = getLocator("FNAME_FLD");
	public final By LNAME_FLD = getLocator("LNAME_FLD");
	public final By PHONE_FLD = getLocator("PHONE_FLD");
	public final By REGISTER_BTN = getLocator("REGISTER_BTN");
	public final By CONTINUE_BTN = getLocator("CONTINUE_BTN");
	public final By EDIT_USERNAME_LNK = getLocator("EDIT_USERNAME_LNK");
	public final By REG_USERNAME = getLocator("REG_USERNAME");
	
	/*PPA_FORM_NEW_ELEMENTS*/
	public final By PPA_NEW_FIELDS = getLocator("PPA_NEW_FIELDS");
	public final By PPA_NEW_REG_BTN = getLocator("PPA_NEW_REG_BTN");
	
	/*UPGRADE_FORM_LOCATORS*/
	public final By COUNTRY_SEL = getLocator("COUNTRY_SEL");
	public final By COUNTRY_OPTIONS = getLocator("COUNTRY_OPTIONS");
	public final By STREET_ADDR_1 = getLocator("STREET_ADDR_1");
	public final By STREET_ADDR_2 = getLocator("STREET_ADDR_2");
	public final By TOWN_SUBURB = getLocator("TOWN_SUBURB");
	public final By POSTCODE = getLocator("POSTCODE");
	public final By STATE_SEL = getLocator("STATE_SEL");
	public final By STATE_OPTIONS = getLocator("STATE_OPTIONS");
	public final By UPGRADE_CONTINUE = getLocator("UPGRADE_CONTINUE");
	
	/*UPGRADE_FORM_NEW_LOCATORS*/
	public final By UPGRADE_NEW_FIELDS = getLocator("UPGRADE_NEW_FIELDS");
	public final By UPGRADE_NEW_COUNTRY_SEL1 = getLocator("UPGRADE_NEW_COUNTRY_SEL1");
	public final By UPGRADE_NEW_COUNTRY_SEL2 = getLocator("UPGRADE_NEW_COUNTRY_SEL2");
	public final By UPGRADE_NEW_STATE_SEL = getLocator("UPGRADE_NEW_STATE_SEL");
		public final By UPGRADE_NEW_DROP_OPTIONS = getLocator("UPGRADE_NEW_DROP_OPTIONS");
	
	public final By REGCNFRM_CALLMENOW = getLocator("REGCNFRM_CALLMENOW");
	public final By REGCNFRM_TEXTMENOW = getLocator("REGCNFRM_TEXTMENOW");
	
	@Override
	  protected void setLocators() {
	    
		/*PPA_FORM_LOCATORS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "PERSONALACCT_RADIO",By.xpath("//android.widget.RadioButton[@content-desc='Personal account']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BIZACCT_RADIO",By.xpath("//android.widget.RadioButton[@content-desc='Business account']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "EMAIL_FLD",By.xpath("//android.widget.EditText[@content-desc='Email']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REEMAIL_FLD",By.xpath("//android.widget.EditText[@content-desc='Reenter email' or @content-desc='Re-enter email']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PASSWORD_FLD",By.xpath("//android.widget.EditText[@content-desc='Password']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "FNAME_FLD",By.xpath("//android.widget.EditText[@content-desc='First name']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "LNAME_FLD",By.xpath("//android.widget.EditText[@content-desc='Last name']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PHONE_FLD",By.xpath("//android.widget.EditText[@content-desc='Mobile phone']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REGISTER_BTN",By.xpath("//android.widget.Button[@content-desc='Register']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "CONTINUE_BTN",By.xpath("//android.view.View[@content-desc='Continue']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "EDIT_USERNAME_LNK",By.xpath("//android.view.View[@content-desc='Customize your username']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REG_USERNAME",By.xpath("//android.view.View/android.view.View[@index=1]"));
		
		/*PPA_FORM_NEW_ELEMENTS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "PPA_NEW_FIELDS",By.xpath("//android.widget.EditText"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PPA_NEW_REG_BTN",By.xpath("//android.widget.Button"));
		
		/*UPGRADE_FORM_LOCATORS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_SEL",By.xpath("//android.widget.Button[contains(@content-desc,'Country')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "COUNTRY_OPTIONS",By.xpath("//android.widget.CheckedTextView"));
		setLocator(LocatorType.ANDROID_LOCATOR, "STREET_ADDR_1",By.xpath("//android.widget.EditText[@content-desc='Street address 1']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "STREET_ADDR_2",By.xpath("//android.widget.EditText[@content-desc='Street address 2 (optional)']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TOWN_SUBURB",By.xpath("//android.widget.EditText[@content-desc='Town/Suburb']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "POSTCODE",By.xpath("//android.widget.EditText[@content-desc='Postcode']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "STATE_SEL",By.xpath("//android.widget.Button[@content-desc='State/Territory']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "STATE_OPTIONS",By.xpath("//android.widget.CheckedTextView"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_CONTINUE",By.xpath("//android.widget.Button[@content-desc='Continue' or @resource-id='sbtBtn' or @text='Continue']"));
		
		/*UPGRADE_FORM_NEW_LOCATORS*/
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_NEW_FIELDS",By.xpath("//android.widget.EditText"));	//total are 6
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_NEW_COUNTRY_SEL1",By.xpath("//android.widget.Button[@content-desc='Country/Region ']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_NEW_COUNTRY_SEL2",By.id("countryId"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_NEW_STATE_SEL",By.xpath("//*[contains(@content-desc,'State/Territory') or contains(@content-desc,'State') or contains(@text, 'State') or contains(@content-desc,'Province') or contains(@text, 'Province')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_NEW_DROP_OPTIONS",By.id("android:id/text1"));
		/*setLocator(LocatorType.ANDROID_LOCATOR, "UPGRADE_NEW_CONTINUE",By.xpath("//android.widget.Button[@content-desc='Continue']"));*/
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "REGCNFRM_CALLMENOW",By.xpath("//android.widget.Button[@content-desc='Call me now']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "REGCNFRM_TEXTMENOW",By.xpath("//android.widget.Button[@content-desc='Text me now']"));
	}
}
