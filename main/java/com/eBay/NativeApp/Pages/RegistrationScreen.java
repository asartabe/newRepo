package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.RegistrationFieldComponent;

public class RegistrationScreen {

	WebDriver driver;
	public RegistrationScreen(WebDriver driver){
		this.driver = driver;
	}
	
	public RegistrationFieldComponent getRegistrationFieldComponent(){
		return new RegistrationFieldComponent(driver);
	}
}
