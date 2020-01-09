package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.BuyerVIPContentComponent;

public class BuyingViewItemPage {

	WebDriver driver;
	public BuyingViewItemPage(WebDriver driver){
		this.driver = driver;
	}
	
	public BuyerVIPContentComponent getBuyerVIPContentComponent(){
		return new BuyerVIPContentComponent(driver);
	}
	
}
