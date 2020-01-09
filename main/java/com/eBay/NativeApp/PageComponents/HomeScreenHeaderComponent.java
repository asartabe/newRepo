package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.HomeScreenHeaderComponentLocators;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;

public class HomeScreenHeaderComponent extends HomeScreenHeaderComponentLocators{

	public HomeScreenHeaderComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private HomeScreenHeaderComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}
	
	public HomeScreenHeaderComponent clickHamburgerMenu(){
		this.clickThisElement(HAMBURGERMENU_ICON);
		return this;
	}
	
	public HomeScreenHeaderComponent clickCart(){
		this.clickThisElement(CART_ICON);
		return this;
	}
	
	public HomeScreenHeaderComponent goToHome(){
		this.clickHamburgerMenu();
		new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().clickHome();
		return this;
	}
	
	/*public HomeScreenHeaderComponent createSearch(String kw){
		if(CustomWaitUtils.waitForElement(SRCH_ICON))
			actions.element().click().by(SRCH_ICON);
		else if(CustomWaitUtils.waitForElement(SRCH_BOX))
			actions.element().textBox().clearAndSendKeys(SRCH_BOX, kw + "\n");
		
		return this;
	}*/
	
	public HomeScreenHeaderComponent clickInSearch(){
		if(CustomWaitUtils.waitForElement(SRCH_ICON))
			actions.element().click().by(SRCH_ICON);
		else if(CustomWaitUtils.waitForElement(SRCH_BOX))
			actions.element().click().by(SRCH_BOX);
		
		return this;
	}
}
