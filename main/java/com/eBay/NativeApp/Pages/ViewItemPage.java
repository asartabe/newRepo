package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.ProductRelatedPageComponent;
import com.eBay.NativeApp.PageComponents.ViewItemPageComponent;

public class ViewItemPage {
	
	WebDriver driver;
	public ViewItemPage(WebDriver driver){
		this.driver = driver;
	}
	
	public ViewItemPageComponent getViewItemPageComponent(){
		return new ViewItemPageComponent(driver);
	}
	
	public ProductRelatedPageComponent getProductRelatedPageComponent(){
		return new ProductRelatedPageComponent(driver);
	}
	
}
