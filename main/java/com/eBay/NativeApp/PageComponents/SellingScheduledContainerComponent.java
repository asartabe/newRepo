package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Locators.SellingScheduledContainerComponentLocators;

public class SellingScheduledContainerComponent extends SellingScheduledContainerComponentLocators{

	public SellingScheduledContainerComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public SellingScheduledContainerComponent clickShceduledItem(){
		actions.element().click().by(ITM_CONTAINER);
		return this;
	}
	
}
