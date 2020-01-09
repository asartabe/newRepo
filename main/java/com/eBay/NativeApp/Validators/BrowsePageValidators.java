package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Pages.BrowsePage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class BrowsePageValidators implements IValidator{

	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	BrowsePage browse;
	
	private BrowsePageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<BrowsePageValidators.Use> {
		public BrowsePageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new BrowsePageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}
	
	public BrowsePageValidators setBrowsePage(BrowsePage browse){
		this.browse = browse;
		return this;
	}
	
	@Validator
	public BrowsePageValidators validateModulesOnBrowsePage(){
		
		uiChainAssert.element()
			.present(browse.getBrowsePageComponent().SHOP_BY, "SHOP BY module not present");
		
		/*if(!uiChainAssert.getAllFailuresInCurrentAssertorInstance().contains("SHOP BY module not present")){
			breezeReport.logInConsoleAndReport(actions.element().get().allWebElementsWithSameLocator(browse.getBrowsePageComponent().SHOP_BY).size() + " SHOP BY Modules are present.");
			List<WebElement> shopBy = actions.element().get().allWebElementsWithSameLocator(browse.getBrowsePageComponent().SHOP_BY);
			for (WebElement element : shopBy) {
				String text = element.findElement(By.xpath("/..")).findElement(browse.getBrowsePageComponent().SHOP_BY_SUBTEXT).getText();
				breezeReport.logInConsoleAndReport("SHOP BY module present for: "+text);	
			}
		}*/
		
		uiChainAssert.element()
			.present(browse.getBrowsePageComponent().SAVE_ON_HEADER, "Save On <category> module section is missing")
			.present(browse.getBrowsePageComponent().BEST_SELLING, "Best Selling module is missing")
			.present(browse.getBrowsePageComponent().LIMITED_TIME_DEALS, "Limited Time Deals module is missing")
			.present(browse.getBrowsePageComponent().HOT_THIS_WEEK, "Hot This Week module is missing")
			.present(browse.getBrowsePageComponent().RESULTS, "Search Results section is missing");
		
		CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, browse.getBrowsePageComponent().VIEW_ALL_RESULTS_LNK);
		
		uiChainAssert.element()
			.present(browse.getBrowsePageComponent().START_SELLING_LNK, "Start Selling link is missing")
			.present(browse.getBrowsePageComponent().YOU_MAY_ALSO_LIKE, "YOu May Also Like section is missing")
			.present(browse.getBrowsePageComponent().CATEGORIES, "Categories section is missing");
		
		return this;
	}
	
	
	
	
	
	
	
	
}
