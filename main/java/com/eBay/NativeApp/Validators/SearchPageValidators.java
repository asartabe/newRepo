package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.SearchPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class SearchPageValidators implements IValidator{

	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	SearchPage srchPage;
	
	private SearchPageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<SearchPageValidators.Use> {
		public SearchPageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new SearchPageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public SearchPageValidators setSearchPage(SearchPage srchPage){
		this.srchPage = srchPage;
		return this;
	}
	
	@Validator
	public SearchPageValidators validateRecentSearchedItem(String recentSrch){
		uiChainAssert.element().atleastOneElementFromMany()
			.textContains(srchPage.getSearchPageQueryComponent().RECENT_SRCH_ENTRIES, recentSrch, "No Recent Search with Text containing ["+recentSrch+"] was Found!!!");
		return this;
	}
	
	@Validator
	public SearchPageValidators validateFollowedSearch(String srchName){
		if(actions.element().present().now(srchPage.getSearchPageQueryComponent().SEE_ALL_FOLLOWED_SRCH))
			uiChainAssert.element().atleastOneElementFromMany()
				.textContains(srchPage.getSearchPageQueryComponent().FOLLOWED_ENTRIES, srchName, "No Followed Search with Text containing ["+srchName+"] was Found!!!");
		return this;
	}
	
	@Validator
	public SearchPageValidators validateFollowedMember(String memName){
		if(actions.element().present().now(srchPage.getSearchPageQueryComponent().SEE_ALL_FOLLOWED_MEM))
			uiChainAssert.element().atleastOneElementFromMany()
				.textContains(srchPage.getSearchPageQueryComponent().FOLLOWED_ENTRIES, memName, "No Followed Member with Text containing ["+memName+"] was Found!!!");
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}