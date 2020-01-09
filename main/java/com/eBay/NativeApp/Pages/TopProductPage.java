package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.TopProductPageComponent;

public class TopProductPage {
	
	WebDriver driver;
	public TopProductPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public TopProductPageComponent getTopProductPageComponent() {
		return new TopProductPageComponent(driver);
	}

}
