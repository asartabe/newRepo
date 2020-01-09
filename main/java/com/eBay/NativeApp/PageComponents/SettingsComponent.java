package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.SettingsLocators;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Validators.SettingsValidators;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.quality.testdataautil.type.User;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.testdrivers.enums.Site;
import com.ebay.testinfrastructure.webautil.actions.DeviceAction.Keys;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;

public class SettingsComponent extends SettingsLocators {

	public SettingsComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private SettingsComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}
	
	private SettingsComponent enterText(By by, String data){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().textBox().clearAndSendKeys(by, data);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}

	public SettingsComponent clickPostageAdress(UIChainAssert assertname){
		this.clickThisElement(POSTAGE_ADD_LNK);
		new SettingsValidators.Use().uiAssertion(assertname).validate(driver).setSettingsValidators(new HamburgerMenuPanel(driver)).validatePrimaryAdress();
		return this;
	}

	public SettingsComponent clickSigningIn(UIChainAssert assertname){
		actions.device().sendKeyEvent(Keys.ANDROID_BACK);
		this.clickThisElement(SIGNIN_LNK);
		new SettingsValidators.Use().uiAssertion(assertname).validate(driver).setSettingsValidators(new HamburgerMenuPanel(driver)).validateChangePasswordLnk();
		return this;
	}
	public SettingsComponent clickCountryLink(UIChainAssert assertname){
		actions.device().sendKeyEvent(Keys.ANDROID_BACK);
		this.clickThisElement(COUNTRY_LNK);
		new SettingsValidators.Use().uiAssertion(assertname).validate(driver).setSettingsValidators(new HamburgerMenuPanel(driver)).validateCountryToggleSwitch();
		return this;
	}
	public SettingsComponent clickCustomerServiceLink(UIChainAssert assertname){
		actions.device().sendKeyEvent(Keys.ANDROID_BACK);
		this.clickThisElement(CUST_SER_LNK);
		new SettingsValidators.Use().uiAssertion(assertname).validate(driver).setSettingsValidators(new HamburgerMenuPanel(driver)).validateCustomerServiceLnk();
		return this;
	}

	private SettingsComponent selectState(String state){
		boolean flag = false;
		do{
			List<WebElement> options = actions.element().get().allWebElementsWithSameLocator(By.xpath("//android.widget.CheckedTextView"));
			for (WebElement option : options) {
				if(actions.element().get().text(option).contentEquals(state)){
					flag = true;
					actions.element().click().webElement(option);
					break;
				}
			}
			if(!flag) CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
		}while(!flag);
		return this;
	}
	
	public SettingsComponent addPostageAddress(TestObject testObject, User user){
		actions.element().click().by(NEW_ADD_LINK);	
		/*if(testObject.getTestTitle().contains("US")){
			actions.element().click().by(COUNTRY_SELECT);
			actions.element().textBox().clearAndSendKeys(COUNTRY_TEXTBOX, "UNITED STATES");
			actions.element().click().by(COUNTRY_US);
		}
		else{
			actions.element().click().by(COUNTRY_SELECT);
			actions.element().textBox().clearAndSendKeys(COUNTRY_TEXTBOX, "AUSTRALIA");
			actions.element().click().by(COUNTRY_AUS);
		}*/
		
		actions.element().click().by(COUNTRY_SELECT);
		actions.element().textBox().clearAndSendKeys(COUNTRY_TEXTBOX, 
				(testObject.getTestTitle().contains("US")) 
				? "UNITED STATES"
				: Site.valueOf(TestParams.CommonTestEnv.site.get()).getSiteCodeTypeString());
		actions.element().click().by(COUNTRY_TO_SELECT);
		
		this.enterText(NAME_TXTBOX, user.getFirstName())
			.enterText(PHONE_TXTBOX, user.getDayPhone())
			.enterText(STREET_1_TXTBOX, user.getAddress())
			.enterText(CITY_TEXTBOX,user.getCity())
			.enterText(POSTCODE_TXTBOX, user.getZip());
		
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU") || testObject.getTestTitle().contains("US")){
			actions.element().click().by(STATE_DRPDWN);
			selectState(user.getState());
		}
		actions.element().click().by(SAVE_BTN);
		return this;
	}
	
	private SettingsComponent revertPrimaryAddress(){
		boolean flag = false;
		for (int i = 0; i < 5; i++){
			if(i>0)
				CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 3, ScrollDirection.DOWN);
			List<WebElement> savedAddresses = actions.element().get().allWebElementsWithSameLocator(SAVED_ADDRESS_LST);
			String childText=new String() ;
			for (WebElement savedAddr : savedAddresses) {
				childText = actions.element().withinParent(savedAddr).get().text(SAVED_ADDR_USER_NAME, "Not able to read name of the user");
				if(!childText.contentEquals("testAutomationUser"))
				{	flag = true;
					actions.element().withinParent(savedAddr).click().by(SAVED_ADDR_OPTIONS_ICON);
					actions.element().click().by(MAKE_PRIMARY_ADDR_LNK);
					break;
				}
			}
			if(flag) break;
		}
		return this;
	}
	
	public SettingsComponent makeAddressPrimary(){
		boolean flag = false;
		for (int i = 0; i < 5; i++){
			if(i>0)
				CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 3, ScrollDirection.DOWN);
			List<WebElement> savedAddresses = actions.element().get().allWebElementsWithSameLocator(SAVED_ADDRESS_LST);
			String childText=new String() ;
			for (WebElement savedAddr : savedAddresses) {
				childText = actions.element().withinParent(savedAddr).get().text(SAVED_ADDR_USER_NAME, "Not able to read name of the user");
				if(childText.contentEquals("testAutomationUser"))
				{	flag = true;
					actions.element().withinParent(savedAddr).click().by(SAVED_ADDR_OPTIONS_ICON);
					actions.element().click().by(MAKE_PRIMARY_ADDR_LNK);
					break;
				}
			}
			if(flag) break;
		}
		revertPrimaryAddress();
		
		return this;
	}
	 
	public SettingsComponent deletePostageAdress(){
		boolean flag = false;
		for (int i = 0; i < 5; i++){
			if(i>0)
				CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 3, ScrollDirection.DOWN);
			List<WebElement> savedAddresses = actions.element().get().allWebElementsWithSameLocator(SAVED_ADDRESS_LST);
			String childText=new String() ;
			for (WebElement savedAddr : savedAddresses) {
				childText = actions.element().withinParent(savedAddr).get().text(SAVED_ADDR_USER_NAME, "Not able to read name of the user");
				if(childText.contentEquals("testAutomationUser"))
				{	flag = true;
					actions.element().withinParent(savedAddr).click().by(SAVED_ADDR_OPTIONS_ICON);
					actions.element().click().by(DELETE_ADDR_LNK);
					break;
				}
			}
			if(flag) break;
		}
		return this;
	}
}
