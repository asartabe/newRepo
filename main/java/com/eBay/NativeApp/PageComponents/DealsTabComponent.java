package com.eBay.NativeApp.PageComponents;

import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Enums.DealsTabs;
import com.eBay.NativeApp.Locators.DealsTabComponentLocators;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.ScrollTerminateCondition;

public class DealsTabComponent extends DealsTabComponentLocators{

	public DealsTabComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private DealsTabComponent clickThisTab(By by){
			LinkedHashSet<ScrollDirection> directionsToScrollToFindElement = new LinkedHashSet<ScrollDirection>();
			directionsToScrollToFindElement.add(ScrollDirection.RIGHT);
			directionsToScrollToFindElement.add(ScrollDirection.LEFT);
			if(actions.touchScreen().usingBy()
					.smartScrollTo(by)
					.directions(directionsToScrollToFindElement)
					.duration(800)
					.scrollCount(4)
					.terminateOn(ScrollTerminateCondition.ELEMENT_VISIBLE)
					.terminateConditionTimeout(20)
					.build().perform())
				actions.element().click().by(by);
		return this;
	}
	
	public DealsTabComponent showTabContentsFor(DealsTabs tab, boolean scrollToFind){
		if(scrollToFind) clickThisTab(tab.getLocator());
		else
			actions.element().click().by(tab.getLocator());
		return this;
	}
	
	public DealsTabComponent showFeaturedTab(){
		clickThisTab(TAB_FEATURED);
		return this;
	}
	
	public DealsTabComponent showElectronicsTab(){
		clickThisTab(TAB_ELECTRONICS);
		return this;
	}
	
	public DealsTabComponent showFashionTab(){
		clickThisTab(TAB_FASHION);
		return this;
	}
	
	public DealsTabComponent showHomeAndGardenTab(){
		clickThisTab(TAB_HOME_GARDEN);
		return this;
	}
	
	public DealsTabComponent showMoreDealsTab(){
		clickThisTab(TAB_MORE_DEALS);
		return this;
	}
	
}
