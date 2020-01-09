package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SRPHeaderComponent;
import com.eBay.NativeApp.PageComponents.SRPResultsComponent;

public class SearchResultsPage {

	WebDriver driver;
	public SearchResultsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public SRPHeaderComponent getSRPHeaderComponent(){
		return new SRPHeaderComponent(driver);
	}
	
	public SRPResultsComponent getSRPResultsComponent(){
		return new SRPResultsComponent(driver);
	}
	
}
