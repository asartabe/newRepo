package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.UserProfileActionComponent;
import com.eBay.NativeApp.PageComponents.UserProfileContentComponent;

public class UserProfilePage {
	
	WebDriver driver;
	public UserProfilePage(WebDriver driver){
		this.driver = driver;
	}
	
	public UserProfileActionComponent getUserProfileActionComponent(){
		return new UserProfileActionComponent(driver);
	}
	
	public UserProfileContentComponent getUserProfileContentComponent(){
		return new UserProfileContentComponent(driver);
	}
	
}
