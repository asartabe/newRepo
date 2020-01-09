package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.FollowingsPageComponent;

public class FollowingsPage {
	
	WebDriver driver;
	public FollowingsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public FollowingsPageComponent getFollowingsPageComponent(){
		return new FollowingsPageComponent(driver);
	}
}
