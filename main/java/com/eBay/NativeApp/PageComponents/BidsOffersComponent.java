package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eBay.NativeApp.Commons.SearchRefinementType.Sort;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.BidsOffersLocators;

public class BidsOffersComponent extends BidsOffersLocators{

	public BidsOffersComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private BidsOffersComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}
	public BidsOffersComponent clickonSort(){
		this.clickThisElement(BID_SORT_LNK);
		return this;
	}
	
	public BidsOffersComponent selectSortOption(Sort sortType){
		this.clickThisElement(By.xpath(sortType.getLocator()));
		return this;
	}
	
	public BidsOffersComponent clickonBidTab(){
		this.clickThisElement(BIDS_TAB);
		return this;
	}
	public BidsOffersComponent clickonDidntWinTab(){
		this.clickThisElement(DIDNTWIN_TAB);
		return this;
	}
	public BidsOffersComponent clickonOffersTab(){
		this.clickThisElement(OFFERS_TAB);
		return this;
	}
	public BidsOffersComponent clickonDidntWinEDITtab(){
		this.clickThisElement(DIDNTWIN_EDIT_LNK);
		return this;
	}
	public BidsOffersComponent deleteAnItem(){
		List<WebElement> lst=driver.findElements(CHECKBOX);
		lst.get(0).click();
		this.clickThisElement(DELETE_ICON);
		actions.element().click().by(DELETE_YES);
		return this;
	}
}
