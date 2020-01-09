package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.ConditionComponent;

public class ConditionPage {
	
	WebDriver driver;
	public ConditionPage(WebDriver driver){
		this.driver = driver;
	}
	
	public ConditionComponent getConditionComponent()
	{
		return new ConditionComponent(driver);
		
	}
	

}
