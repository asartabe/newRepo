package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.HamburgerMenuBottomComponent;
import com.eBay.NativeApp.PageComponents.HamburgerMenuMyEbayComponent;
import com.eBay.NativeApp.PageComponents.HamburgerMenuTopComponent;

public class HamburgerMenuPanel {

	WebDriver driver;
	
	public HamburgerMenuPanel(WebDriver driver){
		this.driver = driver;
	}
	
	public HamburgerMenuTopComponent getHamburgerMenuTopComponent(){
		return new HamburgerMenuTopComponent(driver);
	}
	
	public HamburgerMenuBottomComponent getHamburgerMenuBottomComponent(){
		return new HamburgerMenuBottomComponent(driver);
	}
	
	public HamburgerMenuMyEbayComponent getHamburgerMenuMyEbayComponent(){
		return new HamburgerMenuMyEbayComponent(driver);
	}
}
