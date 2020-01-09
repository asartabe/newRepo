package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.CheckoutPageComponent;

public class CheckoutPage {

	WebDriver driver;
	public CheckoutPage(WebDriver driver){
		this.driver = driver;
	}
	
	public CheckoutPageComponent getCheckoutPageComponent(){
		return new CheckoutPageComponent(driver);
	}
	
}
