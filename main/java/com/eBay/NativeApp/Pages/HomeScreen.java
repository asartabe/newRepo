package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.HomeScreenContentComponent;
import com.eBay.NativeApp.PageComponents.HomeScreenHeaderComponent;

public class HomeScreen {

	WebDriver driver;
	public HomeScreen(WebDriver driver){
		this.driver = driver;
	}
	
	public HomeScreenHeaderComponent getHomeScreenHeaderComponent(){
		return new HomeScreenHeaderComponent(driver);
	}
	
	public HomeScreenContentComponent getHomeScreenContentComponent(){
		return new HomeScreenContentComponent(driver);
	}
	
}
