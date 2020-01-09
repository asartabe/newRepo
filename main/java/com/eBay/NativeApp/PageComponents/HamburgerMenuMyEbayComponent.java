package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.HamburgerMenuMyEbayComponentLocators;

public class HamburgerMenuMyEbayComponent extends HamburgerMenuMyEbayComponentLocators{

	public HamburgerMenuMyEbayComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private HamburgerMenuMyEbayComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}
	
	public WatchingComponent getWatchingComponent(){
		return new WatchingComponent(driver);
	}
	
	public SellingPageComponent getSellingComponent(){
		return new SellingPageComponent(driver);
	}	
	
	public PurchasesComponent getPurchasesComponent(){
		return new PurchasesComponent(driver);
	}
	
	public BidsOffersComponent getBidsOffersComponent(){
		return new BidsOffersComponent(driver);
	}
	
	public WatchingComponent clickWatching(){
		this.clickThisElement(WATCHING_LNK);
		return new WatchingComponent(driver);
	}
	public PurchasesComponent clickPurchases(){
		this.clickThisElement(PURCHASES_LNK);
		return new PurchasesComponent(driver);
	}
	public BidsOffersComponent clickBidsOffers(){
		this.clickThisElement(BIDSOFFERS_LNK);
		return new BidsOffersComponent(driver);
	}
	public SellingComponent clickSelling(){
		this.clickThisElement(SELLING_LNK);
		return new SellingComponent(driver);
	}
	public HamburgerMenuMyEbayComponent clickFollowing(){
		this.clickThisElement(FOLLOWING_LNK);
		return this;
	}
}
