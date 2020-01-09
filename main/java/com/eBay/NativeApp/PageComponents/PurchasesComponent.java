package com.eBay.NativeApp.PageComponents;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.PurchasesLocators;

public class PurchasesComponent extends PurchasesLocators{

	public PurchasesComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private PurchasesComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}
	public PurchasesComponent clickEditButton(){
		this.clickThisElement(EDIT_BTN);
		return this;
	}

	public PurchasesComponent clicKRefineButton(){
		this.clickThisElement(REFINE_BTN);
		return this;
	}
	
	public PurchasesComponent deleteItem(){
		if(actions.element().present().byPolling(ITEM_CHECKBOX)){
			List<WebElement> chkBoxes = actions.element().get().allWebElementsWithSameLocator(ITEM_CHECKBOX);
			actions.element().click().multipleElements(chkBoxes);
			actions.element().click().by(DELETE_ICON);
			if(actions.element().found().now(DELETE_YES_LNK))
				actions.element().click().by(DELETE_YES_LNK);
		}
		return this;
	}
	
}
