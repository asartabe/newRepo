package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.PushNotificationComponent;

public class PushNotificationPanel{

	WebDriver driver;
	public PushNotificationPanel(WebDriver driver){
		this.driver = driver;
	}
	
	public PushNotificationComponent getPushNotifications(){
		return new PushNotificationComponent(driver);
	}
	
}
