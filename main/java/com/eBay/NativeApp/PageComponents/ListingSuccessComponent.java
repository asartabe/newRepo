package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.ListingSuccessComponentLocators;

public class ListingSuccessComponent extends ListingSuccessComponentLocators{

	public ListingSuccessComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private ListingSuccessComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}
	
	public ListingSuccessComponent clickViewListedItem(){
		this.clickThisElement(BTN_VIEW_LISTING);
		return this;
	}
	
}
