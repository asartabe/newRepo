package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.RespondOffersComponent;

public class RespondOffersPage {

	WebDriver driver;
	public RespondOffersPage(WebDriver driver){
		this.driver = driver;
	}
	
	public RespondOffersComponent getRespondOffersComponent(){
		return new RespondOffersComponent(driver);
	}
	
}
