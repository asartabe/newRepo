package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Locators.ItemCardDensityLocators;
import com.eBay.NativeApp.Locators.SRPResultsComponentLocators;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.ScrollLength;

public class SRPResultsComponent extends SRPResultsComponentLocators{

	public SRPResultsComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ICDElements getICDElements(){
		return new ICDElements(driver);
	}
	
	public SRPResultsComponent selectFirstItemFromResults(){
		actions.element().click().webElement(
				actions.element().get().allWebElementsWithSameLocator(SRCH_RESULTS).get(0));
		return this;
	}
	
	public SRPResultsComponent clickMerchantPromotion() {
		if(actions.element().present().now(PROMO_IMAGE)){
			actions.element().click().by(PROMO_IMAGE);
			
		}
		return this;
	}
	
	public SRPResultsComponent selectBestSellingItem(){
		
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, SRP_BEST_SELLING_HDR)){
			if(actions.element().found().now(SRP_BEST_SELLING_ITMS))
				actions.element().click().webElement(actions.element().get().allWebElementsWithSameLocator(SRP_BEST_SELLING_ITMS).get(0));
		}else
			new GenericAssert().fail("BEST_SELLING section wasn't found on SRP!!!");
		
		return this;
	}
	
	public SRPResultsComponent navigateToARelatedSearch(){
		actions.touchScreen().scroll(ScrollDirection.DOWN, ScrollLength.LONG, 18);
		
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, RELATED_SEARCHES_HDR, 10)){
			List<WebElement> relSrch = actions.element().withinParent(RELATED_SRCHS_NAMES).get().allWebElementsWithSameLocator(RELATED_SRCHS_NAMEVAL);
			breezeReport.logBoldStep("Following Related Searches available...\n");
			for (WebElement webElement : relSrch) {
				breezeReport.logBoldStep(webElement.getText() + "\n");
			}
			actions.element().click().webElement(relSrch.get(0));
		}else{
			breezeReport.logRedStep("No RELATED_SEARCHES for your Search-Query.");
			new GenericAssert().fail("No RELATED_SEARCHES for your Search-Query.");
		}
		return this;
	}
	
	public class ICDElements extends ItemCardDensityLocators{

		public ICDElements(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public SRPResultsComponent turneGDToggleON(){
		if(actions.element().present().now(PROMO_IMAGE)) {
		actions.element().click().by(EGD_TOGGLE);
		
		}
		return this;
		
	}
	
}
