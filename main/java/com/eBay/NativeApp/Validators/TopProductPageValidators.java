package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.TopProductPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.testdrivers.enums.Priority;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class TopProductPageValidators implements IValidator{
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;

	TopProductPage tpPage;
	
	
	private TopProductPageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<TopProductPageValidators.Use> {
		public TopProductPageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new TopProductPageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}
	
	public TopProductPageValidators setTopProductPageObject(TopProductPage tpPage){
		this.tpPage = tpPage;
		return this;
	}
	
	@Validator(priority=Priority.P1)
	public TopProductPageValidators checkBasicUIElements(){
		uiChainAssert.element()
			.present(tpPage.getTopProductPageComponent().TOPPRODUCT_CAT_HEADER, "Category Header missing")
			.present(tpPage.getTopProductPageComponent().TOPPRODUCT_PIVOT_BESTSELLING, "BestSelling pivot missing")
			.present(tpPage.getTopProductPageComponent().TOPPRODUCT_PIVOT_TOPRATED, "TopRated Pivot missing" )
			.present(tpPage.getTopProductPageComponent().TOPPRODUCT_PRODUCTCARD, "Products card missing");
		return this;
	}

}
