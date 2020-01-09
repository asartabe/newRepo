package com.eBay.NativeApp.Pages;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SharePanelComponent;

public class SharePanel {

	WebDriver driver;
	public SharePanel(WebDriver driver){
		this.driver = driver;
	}
	
	public SharePanelComponent getSharePanelComponent(){
		return new SharePanelComponent(driver);
	}
}
