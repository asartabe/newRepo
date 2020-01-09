package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.BrowsePageComponent;

public class BrowsePage {
	
	WebDriver driver;
	public BrowsePage(WebDriver driver){
		this.driver = driver;
	}
	
	public BrowsePageComponent getBrowsePageComponent(){
		return new BrowsePageComponent(driver);
	}
	
}
