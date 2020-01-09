package com.eBay.NativeApp.Enums;

import org.openqa.selenium.By;

import com.eBay.NativeApp.Pages.DealsPage;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public enum DealsTabs {
	
	FEATURED(new DealsPage(UIListener.uiDriver.get()).getDealsTabComponent().TAB_FEATURED),
	ELECTRONICS(new DealsPage(UIListener.uiDriver.get()).getDealsTabComponent().TAB_ELECTRONICS),
	FASHION(new DealsPage(UIListener.uiDriver.get()).getDealsTabComponent().TAB_FASHION),
	HOME_AND_GARDEN(new DealsPage(UIListener.uiDriver.get()).getDealsTabComponent().TAB_HOME_GARDEN),
	MORE_DEALS(new DealsPage(UIListener.uiDriver.get()).getDealsTabComponent().TAB_MORE_DEALS);
	
	private By loc = null; 
	DealsTabs(By by){
		loc = by;
	}
	
	public By getLocator(){
		return loc;
	}
}
