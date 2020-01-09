package com.eBay.NativeApp.TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Enums.ItemsToSearch.Categories;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Enums.ShareOptionsMenu;
import com.eBay.NativeApp.Flows.HamburgerMenuFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.BrowsePage;
import com.eBay.NativeApp.Pages.CategoriesPage;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.SharePanel;
import com.eBay.NativeApp.Pages.TopProductPage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.Validators.BrowsePageValidators;
import com.eBay.NativeApp.Validators.SRPValidators;
import com.eBay.NativeApp.Validators.SharePanelValidators;
import com.eBay.NativeApp.Validators.TopProductPageValidators;
import com.eBay.NativeApp.Validators.ViewItemPageValidators;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class BrowseAndPRP extends UIBaseTest{

	private void srchCategory(WebDriver driver, Categories cat){
		new HomeScreen(driver).getHomeScreenContentComponent().clickCategoriesCapsule();
		new CategoriesPage(driver).getCategoriesComponent().selectCategory(cat);
	}
	
	@Test(description="Validations for Category Search & PR Page ")
	@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI})
	public void test_CATEGORY_SRCH_AND_PRP() throws Exception{

		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		UIChainAssert brwsAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		
		srchCategory(driver, Categories.MOBILE_PHONES);
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU")){
			new BrowsePageValidators.Use().uiAssertion(brwsAssert).validate(driver).setBrowsePage(new BrowsePage(driver))
				.validateModulesOnBrowsePage();
			breezeReport.logBoldStep("Browse Page Validations Finished. \n");
		
			new HamburgerMenuFlows(driver, HamburgerMenuOptions.HOME).openMenuOption();
		
			srchCategory(driver, Categories.MOBILE_PHONES);
			new SearchResultsPage(driver).getSRPResultsComponent().selectBestSellingItem();
			new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver))
				.validatePRPElements()
				.validatePRPSectionHeaders();

			new ViewItemPage(driver).getProductRelatedPageComponent().clickPRPSeeItemDetailsButton();
			new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver)).checkBasicUIElements();
		}
		else new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(new SearchResultsPage(driver)).validateSRPHeaders();
		
		String errors = new String();
		if(brwsAssert.getNoOfFailuresInCurrentAssertorInstance() > 0){
			breezeReport.logInConsoleAndReport("Browse Page missing Modules/Sections: \n");
			int count = 0;
			for (String missingModule : brwsAssert.getAllFailuresInCurrentAssertorInstance()) {
				errors += ++count + ". "+missingModule;
			}
			if(uiAssert.getNoOfFailuresInCurrentAssertorInstance() > 0){
				for (String missingModule : uiAssert.getAllFailuresInCurrentAssertorInstance()) {
					errors += ++count + ". "+missingModule;
				}
			}
		}
		
		if(errors.length() > 0)
			new GenericAssert().fail(errors);
		else uiAssert.end();
	}
	
	@Test(description="Validations for BPP & Top Product Page")
	@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI})
	public void test_PRP_BPP_and_TopProducts() throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
	
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		
		srchCategory(driver, Categories.MOBILE_PHONES);
		new SearchResultsPage(driver).getSRPResultsComponent().selectBestSellingItem();
	//	validating BPP on PRP
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver))
		.validateBPPonPRP();
		new ViewItemPage(driver).getProductRelatedPageComponent().BPPVerifyLearnMore();
		// validating top products on PRP
		new ViewItemPage(driver).getProductRelatedPageComponent().gotoTopRatedModuleFromPRP();
		new TopProductPageValidators.Use().uiAssertion(uiAssert).validate(driver).setTopProductPageObject(new TopProductPage(driver)).checkBasicUIElements();
		new TopProductPage(driver).getTopProductPageComponent().clickProductCard();
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver))
		.validatePRPElements()
		.validatePRPSectionHeaders();
	
	}

	@Test(description="Validations for PRP Modules")
	@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI})
	public void test_PRP_SHARE() throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		srchCategory(driver, Categories.MOBILE_PHONES);
		new SearchResultsPage(driver).getSRPResultsComponent().selectBestSellingItem();
		
		new ViewItemPage(driver).getProductRelatedPageComponent().clickShare();
		
		
		new SharePanelValidators.Use().uiAssertion(uiAssert).validate(driver).setSharePanel(new SharePanel(driver)).validateSharePanelDetails();
		new SharePanel(driver).getSharePanelComponent().shareViaOption(ShareOptionsMenu.FACEBOOK);
		
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickShareItemButton();
		new SharePanel(driver).getSharePanelComponent().shareViaOption(ShareOptionsMenu.TWITTER);
		
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickShareItemButton();
		new SharePanel(driver).getSharePanelComponent().shareViaOption(ShareOptionsMenu.GMAIL);
		
	}
		
		
		
		
	
//
//@Test(description="Validations for PRP Modules")
//@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI})
//public void test_PRP_Modules() throws Exception{
//	
//	WebDriver driver = UIListener.uiDriver.get();
//	UIChainAssert uiAssert = new UIChainAssert(driver);
//	LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
//	
//	srchCategory(driver, Categories.MOBILE_PHONES);
//	new SearchResultsPage(driver).getSRPResultsComponent().selectBestSellingItem();
//	new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver))
//  }
//	
	

}