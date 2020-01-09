package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SearchPageQueryComponent;

public class SearchPage {

	WebDriver driver;
	public SearchPage(WebDriver driver){
		this.driver = driver;
	}
	
	public SearchPageQueryComponent getSearchPageQueryComponent(){
		return new SearchPageQueryComponent(driver);
	}
	
}
