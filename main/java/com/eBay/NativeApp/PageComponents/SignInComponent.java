package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.SignInComponentLocators;

public class SignInComponent extends SignInComponentLocators{

	public SignInComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected SignInComponent enterCredentials(String username, String password) {
		if(CustomWaitUtils.waitForElement(TXT_USERNAME)){
			actions.element().textBox().clearAndSendKeys(TXT_USERNAME, username);
			actions.element().textBox().clearAndSendKeys(TXT_PASSWORD, password+"\n");
//			actions.element().click().by(BTN_LOGIN);
		}
		
		/*try{
			actions.element().textBox().sendKeys(TXT_PASSWORD, ""+Keys.ANDROID_ENTER);
		}catch(Exception e){
			actions.element().textBox().sendKeys(TXT_PASSWORD, "\n");
		}*/
		
		return this;
	}
	
	protected void tapOnSignInButton() {
		actions.touchScreen().usingBy().tap(BTN_LOGIN);
	}
	
	public void signIn(String username, String password) {

		this.enterCredentials(username, password);
		this.tapOnSignInButton();
		
		
		if(actions.element().present().byPolling(By.id("com.ebay.mobile:id/button_google_deny")))
			actions.touchScreen().usingBy().tap(By.id("com.ebay.mobile:id/button_google_deny"));
		
		
		
		/*actions.element().textBox().sendKeys(TXT_USERNAME, username);
		actions.element().textBox().sendKeys(TXT_PASSWORD, password);
		actions.touchScreen().usingBy().tap(BTN_LOGIN);*/
	}

	public void tapOnCrossButtonToDispose() {
		actions.touchScreen().usingBy().tap(BTN_SIGNIN_CLOSE);
	}

	public SignInComponent tapOnShowHidePassword() {

		actions.touchScreen().usingBy().tap(BTN_SHOWHIDE_PASSWORD);
		return this;  
	}

	public void tapOnRegisterButton() {
		actions.touchScreen().usingBy().tap(BTN_REGISTER);

	}
	public void chooseUsernameAndPasswordOption()
	{
		actions.touchScreen().usingBy().tap(BTN_CLASSIC);
	}
	
	public void skipLinkingAccounts()
	{
		if(actions.element().present().byPolling(BTN_NOTHANKS))
		actions.touchScreen().usingBy().tap(BTN_NOTHANKS);
	}

}
