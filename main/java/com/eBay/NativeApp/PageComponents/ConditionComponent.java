package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Locators.ConditionComponentLocator;

public class ConditionComponent extends ConditionComponentLocator{

	public ConditionComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public ConditionComponent selectConditionandproceed()
{
	if(actions.element().present().byPolling(COND_TITLE))
	actions.element().click().by(COND_BRANDNEW);
	
	if(actions.element().present().byPolling(INFO_POPUP))
		actions.element().click().by(GOT_IT_BTN);
	return this;
	
}
	
	}

