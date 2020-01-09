package com.eBay.NativeApp.TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Enums.Feedback;
import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Enums.ItemsToSearch;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Flows.HamburgerMenuFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchPage;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.UserProfilePage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.CombinedSteps;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.Validators.HomeScreenValidators;
import com.eBay.NativeApp.Validators.SRPValidators;
import com.eBay.NativeApp.Validators.SellingValidators;
import com.eBay.NativeApp.Validators.UserProfilePageValidators;
import com.ebay.quality.testdataautil.type.UserType;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class UserProfilePageTest extends UIBaseTest{
	
	@Test(description="Validations for Signed/Unsigned User HomeScreen & Selling Destination Page & then User Profile Page for Signed User")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_USER_PROFILE_PAGE() throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		HomeScreen home = new HomeScreen(driver);
		new HomeScreenValidators.Use().uiAssertion(uiAssert).validate(driver).setHomeScreenObject(home)
			.validateHeaderElements()
			.validateNavigationPills()
			.validateCTAButtonsForUnsignedUser()
			.validateFeaturedDeals();
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU")){
			new HomeScreenValidators.Use().uiAssertion(uiAssert).validate(driver).setHomeScreenObject(home)
				.validateTrendingOnEbay()
				.validateSalesAndEvents()
				.validateAdContent();
		}
		
		home.getHomeScreenContentComponent().clickSellingCapsule();
		new SellingValidators.Use().uiAssertion(uiAssert).validate(driver).setHamburgerMenuPanelObject(new HamburgerMenuPanel(driver))
			.validateSellingPageUnsignedUser();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getSellingComponent().clickSignInForUnsignedUser();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1));
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.HOME).openMenuOption();
		
		new HomeScreenValidators.Use().uiAssertion(uiAssert).validate(driver).setHomeScreenObject(home)
			.validateHeaderElements()
			.validateNavigationPills()
			.validateCTAButtonsForSignedUser()
			.validateNotifications()
			.validateWatchingContainer()
			.validateRVIContainer()
			.validateFeaturedDeals();
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU")){
			new HomeScreenValidators.Use().uiAssertion(uiAssert).validate(driver).setHomeScreenObject(home)
				.validateTrendingOnEbay()
				.validateSalesAndEvents()
				.validateAdContent();
		}
		
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(driver).getSearchPageQueryComponent().createSearch(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);
		new SearchResultsPage(driver).getSRPResultsComponent().selectFirstItemFromResults();
		new ViewItemPage(driver).getViewItemPageComponent().viewSellerDetails();
		new UserProfilePageValidators.Use().uiAssertion(uiAssert).validate(driver).setUserProfilePage(new UserProfilePage(driver))
			.validateUserDetails()
			.validateDSRifPresent()
			.validateRecentFeedbackRatings();
		
		new UserProfilePage(driver).getUserProfileActionComponent().clickSeeAllFeedbackLink();
		CombinedSteps.checkFeedbackAsandType(driver, uiAssert, UserType.SELLER, Feedback.POSITIVE);
		CombinedSteps.checkFeedbackAsandType(driver, uiAssert, UserType.SELLER, Feedback.NEUTRAL);
		CombinedSteps.checkFeedbackAsandType(driver, uiAssert, UserType.SELLER, Feedback.NEGATIVE);
		CombinedSteps.checkFeedbackAsandType(driver, uiAssert, UserType.BUYER, Feedback.POSITIVE);
		CombinedSteps.checkFeedbackAsandType(driver, uiAssert, UserType.BUYER, Feedback.NEUTRAL);
		CombinedSteps.checkFeedbackAsandType(driver, uiAssert, UserType.BUYER, Feedback.NEGATIVE);
		new CustomTouchUtils().deviceBack(driver);
		
		CombinedSteps.checkFeedbackDetailsForType(driver, uiAssert, Feedback.POSITIVE);
		CombinedSteps.checkFeedbackDetailsForType(driver, uiAssert, Feedback.NEUTRAL);
		CombinedSteps.checkFeedbackDetailsForType(driver, uiAssert, Feedback.NEGATIVE);
		
		new UserProfilePage(driver).getUserProfileActionComponent().clickItemsForSaleLink();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(new SearchResultsPage(driver))
			.validateSRPHeaders();
		
		uiAssert.end();
	}
	
}
