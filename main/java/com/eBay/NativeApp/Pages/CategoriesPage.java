package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.CategoriesComponent;

public class CategoriesPage {
	
	WebDriver driver;
	public CategoriesPage(WebDriver driver){
		this.driver = driver;
	}
	
	public CategoriesComponent getCategoriesComponent(){
		return new CategoriesComponent(driver);
	}
	
}
