package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.Locators.SellingDraftsComponentLocators;

public class SellingDraftsComponent extends SellingDraftsComponentLocators{

	public SellingDraftsComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public SellingDraftsComponent deleteDraft(boolean multiple){
		actions.element().click().by(EDIT_BTN);
		List<WebElement> chkBoxes = actions.element().get().allWebElementsWithSameLocator(ITM_CHKBX);
		if(multiple){
			for (WebElement chkbx : chkBoxes)
				actions.element().click().webElement(chkbx);
		}
		else
			actions.element().click().webElement(chkBoxes.get(0));
		actions.element().click().by(DELETE_BTN);
		actions.element().click().by(DELETE_YES);
		return this;
	}
	
}
