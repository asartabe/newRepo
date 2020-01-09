package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.TopProductPageLocators;

public class TopProductPageComponent extends TopProductPageLocators {

	public TopProductPageComponent(WebDriver driver) {
		super(driver);
	}
	private  TopProductPageComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return new TopProductPageComponent(driver);
	}
	public TopProductPageComponent clickProductCard() {
		clickThisElement(TOPPRODUCT_PRODUCTCARD);
		return new TopProductPageComponent(driver);
		
	}

	
}
