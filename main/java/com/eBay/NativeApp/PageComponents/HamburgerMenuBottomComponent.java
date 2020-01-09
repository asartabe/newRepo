package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.HamburgerMenuBottomComponentLocators;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;

public class HamburgerMenuBottomComponent extends HamburgerMenuBottomComponentLocators{

	public HamburgerMenuBottomComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public HamburgerMenuSettingsComponent getHamburgerMenuSettingsComponent(){
		return new HamburgerMenuSettingsComponent(driver);
	}
	
	private HamburgerMenuBottomComponent clickThisElement(By by){
		boolean flag = false; int count = 0;
		while(count < 5){
			count++;
			if(CustomWaitUtils.waitForElement(by)){
				actions.element().click().by(by);
				flag = true; break;
			}
			else{
				CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, by);
				continue;
			}
		}
		
		if(!flag)
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
		
		return this;
	}
	public SettingsComponent getSettingsComponent(){
		return new SettingsComponent(driver);
	}
	
	public HamburgerMenuBottomComponent clickCategories(){
		this.clickThisElement(CATEGORIES_LNK);
		return this;
	}
	
	public HamburgerMenuBottomComponent clickDeals(){
		this.clickThisElement(DEALS_LNK);
		return this;
	}
	
	public HamburgerMenuBottomComponent clickSettings(){
		this.clickThisElement(SETTINGS_LNK);
		return this;
	}
	
	public HamburgerMenuBottomComponent clickHelpContact(){
		this.clickThisElement(HELPCONTACT_LNK);
		return this;
	}
	
}
