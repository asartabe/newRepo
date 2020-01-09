package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.HomeScreenContentComponentLocators;

public class HomeScreenContentComponent extends HomeScreenContentComponentLocators{

	public HomeScreenContentComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private HomeScreenContentComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else if(CustomTouchUtils.scrollToElement(actions, by, 5))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}
	
	public HomeScreenContentComponent clickRegister(){
		this.clickThisElement(REGISTER_BTN);
		return this;
	}
	
	public HomeScreenContentComponent clickSignIn(){
		this.clickThisElement(SIGNIN_BTN);
		return this;
	}
	
	public HomeScreenContentComponent showMoreFeaturedDeals(){
		this.clickThisElement(FEAT_DEALS_MORE);
		return this;
	}
	
	public HomeScreenContentComponent showMoreTrendingOnEbay(){
		this.clickThisElement(TRENDING_MORE);
		return this;
	}
	
	public HomeScreenContentComponent showMoreCollections(){
		this.clickThisElement(COLLECTIONS_MORE);
		return this;
	}
	
	public HomeScreenContentComponent showMoreFeaturedEvents(){
		this.clickThisElement(EVENTS_MORE);
		return this;
	}
	
	public HomeScreenContentComponent clickSellingCapsule(){
		this.clickThisElement(PILL_SELLING);
		return this;
	}
	
	public HomeScreenContentComponent clickCategoriesCapsule(){
		this.clickThisElement(PILL_CATEGORIES);
		return this;
	}
	
	public HomeScreenContentComponent clickDealsCapsule(){
		this.clickThisElement(PILL_DEALS);
		return this;
	}
	
	public HomeScreenContentComponent clickFollowingCapsule(){
		this.clickThisElement(PILL_FOLLOWING);
		return this;
	}
	
}
