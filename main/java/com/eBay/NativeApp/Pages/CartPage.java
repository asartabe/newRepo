package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.CartPageComponent;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver){
		this.driver = driver;
	}
	
	public CartPageComponent getCartPageComponent(){
		return new CartPageComponent(driver);
	}
	
}
