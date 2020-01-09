package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Locators.ProductRelatedPageLocators;
import com.ebay.testinfrastructure.asserts.GenericAssert;

public class ProductRelatedPageComponent extends ProductRelatedPageLocators{

	public ProductRelatedPageComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ProductRelatedPageComponent clickPRPBuyItNowButton(){
		if(CustomTouchUtils.scrollToElement(actions, PRP_BTN_CTA1, 1) && actions.element().get().text(PRP_BTN_CTA1, "").contentEquals("Buy It Now"))
			actions.element().click().by(PRP_BTN_CTA1);
		else
			new GenericAssert().fail("No Primary Action Button available");
		
		return new ProductRelatedPageComponent(driver);
	}
	
	
	public ViewItemPageComponent clickPRPSeeItemDetailsButton(){
		if(CustomTouchUtils.scrollToElement(actions, PRP_BTN_CTA2, 1) && actions.element().get().text(PRP_BTN_CTA2, "").contentEquals("See details"))
			actions.element().click().by(PRP_BTN_CTA2);
		else
			new GenericAssert().fail("No Primary Action Button available");
		
		return new ViewItemPageComponent(driver);
	}
	
	public ViewItemPageComponent gotoTopRatedModuleFromPRP(){
		
		actions.element().click().by(PRP_PRODUCT_RANK);
		return new ViewItemPageComponent(driver);
	}
	
	public ViewItemPageComponent BPPVerifyLearnMore() {
		actions.element().click().by(BPP_TEXT);
		actions.element().found().byPolling(BPP_TITLE);
		actions.element().click().by(BPP_CLOSE);
		return new ViewItemPageComponent(driver);
	}
	
	public ProductRelatedPageComponent clickShare(){
			actions.element().click().by(PRP_MORE_OPTIONS);
			actions.element().click().by(SHARE_OPTN);
		
		return new ProductRelatedPageComponent(driver);
	}
	
}
