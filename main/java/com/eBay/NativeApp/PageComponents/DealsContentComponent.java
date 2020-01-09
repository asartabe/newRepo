package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Enums.DealsTabs;
import com.eBay.NativeApp.Locators.DealsContentComponentLocators;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;

public class DealsContentComponent extends DealsContentComponentLocators{

	public DealsContentComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private DealsContentComponent clickThisElement(By parent, By by, DealsTabs tab){
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, parent, 20))
			actions.element().withinParent(parent).click().by(by);
		else
			breezeReport.logRedStep("Can't find <<["+by.toString()+"]>> within Parent: <<["+parent.toString()+"]>> in "+tab.name());
	return this;
}
	
	public DealsContentComponent showMoreFeaturedDeals(DealsTabs tab){
		clickThisElement(FEATURED_DEALS_HEADER, FEATURED_DEALS_HDR_MORE, tab);
		return this;
	}
	
	public DealsContentComponent showMoreTrendingDeals(DealsTabs tab){
		clickThisElement(TRENDING_DEALS_HEADER, TRENDING_DEALS_HDR_MORE, tab);
		return this;
	}
	
}
