package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SignInComponent;

public class SignInScreen {

	WebDriver driver;
	public SignInScreen(WebDriver driver){
		this.driver = driver;
	}
	
	public SignInComponent getSignInComponent(){
		return new SignInComponent(driver);
	}
}
