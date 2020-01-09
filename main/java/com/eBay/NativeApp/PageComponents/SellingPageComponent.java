package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.SellingPageComponentLocators;

public class SellingPageComponent extends SellingPageComponentLocators{

	public SellingPageComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private SellingPageComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}

	public SellingPageComponent clickListAnItemButton(){
		clickThisElement(LIST_AN_ITEM_BTN);
		return this;
	}

	public SellingPageComponent seeAllDrafts(){
		if(actions.element().present().now(DRAFTS_SEE_ALL))
			actions.element().click().by(DRAFTS_SEE_ALL);
		return this;
	}

	public SellingPageComponent goToActiveContainer(){
		if(actions.element().present().now(ACTIVE_LNK))
			actions.element().click().by(ACTIVE_LNK);
		return this;
	}

	public SellingPageComponent goToSoldContainer(){
		if(actions.element().present().now(SOLD_LNK))
			actions.element().click().by(SOLD_LNK);
		return this;
	}

	public SellingPageComponent goToUnsoldContainer(){
		if(actions.element().present().now(UNSOLD_LNK))
			actions.element().click().by(UNSOLD_LNK);
		return this;
	}
	
	public SellingPageComponent clickScheduledListingLink(){
		if(actions.element().present().now(SCHEDULED_ITEMS_LNK))
			actions.element().click().by(SCHEDULED_ITEMS_LNK);
		return this;
	}
	
	public SellingPageComponent clickSignInForUnsignedUser(){
		if(actions.element().present().now(UNSIGNED_SIGNIN_BTN))
			actions.element().click().by(UNSIGNED_SIGNIN_BTN);
		return this;
	}
	
}
