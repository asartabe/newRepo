package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.ListingSuccessComponent;
import com.eBay.NativeApp.PageComponents.ReviewPageComponent;
import com.eBay.NativeApp.PageComponents.SellAnItemPageComponent;

public class SellAnItemPage {

	WebDriver driver;
	public SellAnItemPage(WebDriver driver){
		this.driver = driver;
	}
	
	public SellAnItemPageComponent getSellAnItemPageComponent(){
		return new SellAnItemPageComponent(driver);
	}
	
	public ReviewPageComponent getReviewPageComponent(){
		return new ReviewPageComponent(driver);
	}
	
	public ListingSuccessComponent getListingSuccessComponent(){
		return new ListingSuccessComponent(driver);
	}
}
