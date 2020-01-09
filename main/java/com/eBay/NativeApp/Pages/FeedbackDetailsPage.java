package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.FeedbackPageComponent;

public class FeedbackDetailsPage {

	WebDriver driver;
	public FeedbackDetailsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public FeedbackPageComponent getFeedbackPageActionsComponent(){
		return new FeedbackPageComponent(driver);
	}
	
}
