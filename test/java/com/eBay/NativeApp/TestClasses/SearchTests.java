package com.eBay.NativeApp.TestClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.Commons.SearchRefinementType.BuyingFormat;
import com.eBay.NativeApp.Commons.SearchRefinementType.ItemLocation;
import com.eBay.NativeApp.Commons.SearchRefinementType.View;
import com.eBay.NativeApp.Commons.SearchRefinementType.eGD;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Enums.ICDFeatures;
import com.eBay.NativeApp.Enums.ItemsToSearch;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Flows.HamburgerMenuFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SearchFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Flows.UpdateDCS;
import com.eBay.NativeApp.Pages.FollowingsPage;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchPage;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.TestHelpers.CombinedSteps;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.Validators.FollowingsPageValidators;
import com.eBay.NativeApp.Validators.SRPValidators;
import com.eBay.NativeApp.Validators.SearchPageValidators;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class SearchTests extends UIBaseTest{

	@Test(description="Validations on SRP & various Refinement Filters")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_SEARCH_RESULTS_PAGE() throws Exception{

		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SearchResultsPage srp = new SearchResultsPage(driver);
		SetupCountryInSettings.setupCountry(driver);

		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		
		if(UpdateDCS.enableDeveloperSettings())
			UpdateDCS.changeConfig("search", "refinementLockRedesign", true).saveConfigurations();
		
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(driver).getSearchPageQueryComponent().createSearch(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);

		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateSRPHeaders();

		CombinedSteps.checkSortingOnSRP(driver, uiAssert, srp);
		breezeReport.logBoldStep("SORTING Checks completed");
		
		CombinedSteps.checkDisplayFormat(driver, uiAssert, srp, BuyingFormat.AUCTION);
		CombinedSteps.checkDisplayFormat(driver, uiAssert, srp, BuyingFormat.BUYITNOW);
		CombinedSteps.checkDisplayFormat(driver, uiAssert, srp, BuyingFormat.BESTOFFER);
		srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).resetRefinements().saveRefinements();
		breezeReport.logBoldStep("BUYING FORMAT and Lock Checks completed");
		
		CombinedSteps.checkViewFormat(driver, uiAssert, srp, View.GRID);
		CombinedSteps.checkViewFormat(driver, uiAssert, srp, View.LIST);
		srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).resetRefinements().saveRefinements();
		breezeReport.logBoldStep("VIEW Checks completed");
		
		CombinedSteps.checkPriceRange(driver, uiAssert, srp, 100.00, 200.00);
		srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).resetRefinements().saveRefinements();
		breezeReport.logBoldStep("PRICE FILTER Checks completed");
		
		if(UpdateDCS.isDCSEnabled()){
			CombinedSteps.checkLocationFilters(driver, uiAssert, srp, ItemLocation.AUSTRALIA_ONLY);
			CombinedSteps.checkLocationFilters(driver, uiAssert, srp, ItemLocation.WORLDWIDE);
			srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).resetRefinements().saveRefinements();
			breezeReport.logBoldStep("ITEM LOCATION Lock Checks completed");
		}
		
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU"))
		{
			Iterator<Object[]> ite = TestDataProvider.getCnCSearchData();
			while(ite.hasNext()){	
				Object[] object = ite.next();
				String srchKey = Arrays.copyOf(object, object.length, String[].class)[0];
				CombinedSteps.searchCNCAndGoToSRP(driver, uiAssert, srchKey);
				new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(new SearchResultsPage(driver))
				.validateCnCLabel();
			}
		}
		
		uiAssert.end();
	}
	
	@Test(description="Validations for Search Landing Page: Recent & Following tabs")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_SEARCH_PAGE() throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);

		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1));
		
		String srch = ItemsToSearch.KeyWord.IPHONE.getKeyWord(), 
				member = ItemsToSearch.Member.valueOf(TestParams.CommonTestEnv.site.get().toUpperCase()+"_SELLER").getMemberName();  
		
		CombinedSteps.searchAndGetToSearchlandingPage(driver, uiAssert, srch, false, true);
		CombinedSteps.searchAndGetToSearchlandingPage(driver, uiAssert, member, true, true);
		
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPageValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchPage(new SearchPage(driver))
			.validateRecentSearchedItem(srch)
			.validateRecentSearchedItem(member);
		new SearchPage(driver).getSearchPageQueryComponent().getFollowingTabActions();
		new SearchPageValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchPage(new SearchPage(driver))
			.validateFollowedSearch(srch)
			.validateFollowedMember(member);
		
		uiAssert.end();
	}
	
	@Test(description="Validations for Related Searches on SRP")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_RELATED_SEARCHES() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);

		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1));
		SearchFlows.searchFor(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);
		
		SearchResultsPage srp = new SearchResultsPage(driver); 
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateViewIs(View.LIST);
		srp.getSRPResultsComponent().navigateToARelatedSearch();
		srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).changeView(View.GRID).saveRefinements();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateViewIs(View.GRID);
		new CustomTouchUtils().deviceBack(driver);
		CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.UP, 200);
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateViewIs(View.LIST);
	}
	
	@Test(description="Validations for Item Card Density on SRP")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_ITEM_CARD_DENSITY() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));

		if(UpdateDCS.enableDeveloperSettings())
			UpdateDCS.changeConfig("search", "useItemCardRedesign", true).saveConfigurations();
		
		SearchResultsPage srp = new SearchResultsPage(driver);
		List<ICDFeatures> pending = new ArrayList<>();
		for (ICDFeatures feature : ICDFeatures.values()) {
			SearchFlows.searchFor(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);
			if(!new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp)
					.validateICDItems(feature))
				pending.add(feature);
		}
		if(!pending.isEmpty()){
			List<ICDFeatures> retest = pending;
			pending = new ArrayList<>();
			for (ICDFeatures icdFeatures : retest) {
				SearchFlows.searchFor(ItemsToSearch.KeyWord.CAMERA.getKeyWord(), false);
				if(!new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp)
						.validateICDItems(icdFeatures))
					pending.add(icdFeatures);
			}
		}
		
		for (ICDFeatures icdFeatures : pending) {
			uiAssert.generic().fail("["+icdFeatures.getDetails()+"] was not found!");
		}
		uiAssert.end();
	}
	
	@Test(description="Validations for Deals and Savings Filter")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_DEALS_SAVINGS_FILTER() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));

		if(UpdateDCS.enableDeveloperSettings())
			UpdateDCS.changeConfig("search", "refineDealsAndSavings", true).saveConfigurations();
		
		SearchResultsPage srp = new SearchResultsPage(driver);
		
		SearchFlows.searchFor(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp)
			.validateDealsAndSavingsFilter(false);
		srp.getSRPHeaderComponent().getRefinementPanel(true).switchDealsAndSavingsFilter(true).clickShowLess().saveRefinements();
		srp.getSRPHeaderComponent().clickToFollowSearch("DEALS_IPHONE", false, false);
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SAVED_or_FOLLOWED).openMenuOption();
		new FollowingsPage(driver).getFollowingsPageComponent().showFollowedSearches();
		new FollowingsPageValidators.Use().uiAssertion(uiAssert).validate(driver).setFollowingsPageValidators(new FollowingsPage(driver))
			.validateFollowedSearchItemExists("DEALS_IPHONE");
		new FollowingsPage(driver).getFollowingsPageComponent().clickToOpenFollowedSearch("DEALS_IPHONE");
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp)
			.validateDealsAndSavingsFilter(true);
		
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SAVED_or_FOLLOWED).openMenuOption();
		new FollowingsPage(driver).getFollowingsPageComponent().showFollowedSearches();
		new FollowingsPage(driver).getFollowingsPageComponent().removeSpecificSearchItem("DEALS_IPHONE");
		
		uiAssert.end();
	}
	
	@Test(description="Validations for Merchant Promotions on SRP")
	@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI})
	public void test_MERCHANT_PROMOTIONS() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		SearchResultsPage srp = new SearchResultsPage(driver);
		
		SearchFlows.searchFor(ItemsToSearch.KeyWord.MERCHPROMO.getKeyWord(), false);
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp)
		.validateMerchantPromotions();
	}
	
	@Test(description="Validations for eGD on SRP")
	@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI})
	public void test_EGD_ON_SRP() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		SearchResultsPage srp = new SearchResultsPage(driver);
		
		SearchFlows.searchFor(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);
		srp.getSRPResultsComponent().turneGDToggleON();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateeGDText();
		srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(true).addeGDOptions(eGD.THREE_DAY_SHIPPING).saveRefinements();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateeGDText();
	}
	
	
}