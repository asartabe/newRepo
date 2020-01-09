package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.DealsContentComponent;
import com.eBay.NativeApp.PageComponents.DealsTabComponent;

public class DealsPage {
	
	WebDriver driver;
	public DealsPage(WebDriver driver){
		this.driver = driver;
	} 
	
	public DealsTabComponent getDealsTabComponent(){
		return new DealsTabComponent(driver);
	}
	
	public DealsContentComponent getDealsContentComponent(){
		return new DealsContentComponent(driver);
	}
	
}
