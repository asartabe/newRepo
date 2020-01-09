package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SellingContainersComponent;
import com.eBay.NativeApp.PageComponents.SellingDraftsComponent;
import com.eBay.NativeApp.PageComponents.SellingPageComponent;
import com.eBay.NativeApp.PageComponents.SellingScheduledContainerComponent;

public class SellingPage {
	
	WebDriver driver;
	public SellingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public SellingPageComponent getSellingPageComponent(){
		return new SellingPageComponent(driver);
	}
	
	public SellingDraftsComponent getSellingDraftsComponent(){
		return new SellingDraftsComponent(driver);
	}
	
	public SellingContainersComponent getSellingContainersComponent(){
		return new SellingContainersComponent(driver);
	}
	
	public SellingScheduledContainerComponent getSellingScheduledContainerComponent(){
		return new SellingScheduledContainerComponent(driver);
	}
	
}
