package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.ReviewPageComponentLocators;

public class ReviewPageComponent extends ReviewPageComponentLocators{

	public ReviewPageComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private ReviewPageComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}
	
	public ReviewPageComponent clickListItButton(){
		this.clickThisElement(BTN_LIST_IT);
		return this;
	}
	
	public ReviewPageComponent clickPreviewButton(){
		this.clickThisElement(BTN_PREVIEW);
		return this;
	}
	
}
