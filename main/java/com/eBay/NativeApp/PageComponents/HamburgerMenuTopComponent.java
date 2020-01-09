package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.HamburgerMenuTopComponentLocators;
import com.eBay.NativeApp.Pages.HomeScreen;

public class HamburgerMenuTopComponent extends HamburgerMenuTopComponentLocators{

	public HamburgerMenuTopComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private HamburgerMenuTopComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}
	
	public NotificationComponent getNotificationcomponent(){
		return new NotificationComponent(driver);
	}

	public MessagesComponent getMessagesComponent(){
		return new MessagesComponent(driver);
	}
	
	public SignInComponent clickSignin(){
		this.clickThisElement(HAM_SIGN_LNK);
		return new SignInComponent(driver);
	}
	
	public HomeScreen clickSignOut(){
		this.clickThisElement(USER_NAME_LINK);
		this.clickThisElement(HAM_SIGN_OUT);
		return new HomeScreen(driver);
	}
	
	public NotificationComponent clickNotification(){
		this.clickThisElement(NOTIFICATION_LNK);
		return new NotificationComponent(driver);
	}
	
	public MessagesComponent clickMessages(){
		this.clickThisElement(MESSAGES_LNK);
		return new MessagesComponent(driver);
	}
	
	
	public HomeScreen clickHome(){
		this.clickThisElement(HOME_LNK);
		return new HomeScreen(driver);
	}
	
}
