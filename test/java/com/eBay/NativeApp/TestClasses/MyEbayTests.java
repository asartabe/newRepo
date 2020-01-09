package com.eBay.NativeApp.TestClasses;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.Commons.SearchRefinementType.Sort;
import com.eBay.NativeApp.CustomUtils.TimeAndDateUtils;
import com.eBay.NativeApp.Enums.DealsTabs;
import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Enums.SellContainerEnums.SellContainer;
import com.eBay.NativeApp.Flows.HamburgerMenuFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Flows.UpdateDCS;
import com.eBay.NativeApp.Pages.DealsPage;
import com.eBay.NativeApp.Pages.FollowingsPage;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.SellingPage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.CombinedSteps;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil;
import com.eBay.NativeApp.Validators.BidsOffersValidators;
import com.eBay.NativeApp.Validators.DealsPageValidator;
import com.eBay.NativeApp.Validators.EbayHamburgerValidators;
import com.eBay.NativeApp.Validators.FollowingsPageValidators;
import com.eBay.NativeApp.Validators.MessagesValidators;
import com.eBay.NativeApp.Validators.NotificationsValidators;
import com.eBay.NativeApp.Validators.PurchasesValidators;
import com.eBay.NativeApp.Validators.SellingContainerValidators;
import com.eBay.NativeApp.Validators.SellingValidators;
import com.eBay.NativeApp.Validators.SettingsValidators;
import com.eBay.NativeApp.Validators.ViewItemPageValidators;
import com.eBay.NativeApp.Validators.WatchingValidators;
import com.ebay.quality.testdataautil.api.ItemHelper.ItemTemplateType;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.quality.testdataautil.type.User;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class MyEbayTests extends UIBaseTest{

	@Test(description="Validates Menu options in Hamburger Menu Panel")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_MENUUI() throws InterruptedException{
		WebDriver driver = UIListener.uiDriver.get();
		SetupCountryInSettings.setupCountry(driver);
		
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickHamburgerMenu();
		new EbayHamburgerValidators.Use().uiAssertion(new UIChainAssert(driver)).validate(driver).setVEbayHamburger(new HamburgerMenuPanel(driver)).checkMenuElements();
	}

	@Test(description="Validates Notifications center within App")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_NOTIFICATIONS() throws Exception{

		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BASICSTORE));
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickHamburgerMenu();
		new NotificationsValidators.Use().uiAssertion(uiAssert).validate(driver).setNotificationValidators(new HamburgerMenuPanel(driver)).checkUnreadNotificationsCount();
		new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().clickNotification();
		new NotificationsValidators.Use().uiAssertion(uiAssert).validate(driver).setNotificationValidators(new HamburgerMenuPanel(driver)).checkNotificationsContent();
		String notifDetails = new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().getNotificationcomponent().dismissFirstNotification();
		new NotificationsValidators.Use().uiAssertion(uiAssert).validate(driver).setNotificationValidators(new HamburgerMenuPanel(driver))
		.checkForNotificationWithDetails(notifDetails);
		uiAssert.end();
	}

	@Test(description="Validates Message Center within App")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_MESSAGES() throws Exception {
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_PREMIUMSTORE));
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickHamburgerMenu();
		new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().getMessagesComponent().getInitialMessageCount();
		new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().clickMessages();
		new MessagesValidators.Use().uiAssertion(uiAssert).validate(driver).setNotificationValidators(new HamburgerMenuPanel(driver)).validateMessagePageElements();
		new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().getMessagesComponent().readAMessage();
		new MessagesValidators.Use().uiAssertion(uiAssert).validate(driver).setNotificationValidators(new HamburgerMenuPanel(driver)).validateMessageCount();

	}

	@SuppressWarnings("static-access")
	@Test(description="Validations for Watching: Active/Ended Containers")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_WATCHING() throws Exception {
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		SearchResultsPage srp = new SearchResultsPage(driver);
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BASICSTORE));

		if(UpdateDCS.enableDeveloperSettings())
			UpdateDCS.changeConfig("my ebay", "watchlistCategoryFilter", true).changeConfig("my ebay", "watchlist2", true).changeConfig("search", "watchAction", true)
			.saveConfigurations();

		new HamburgerMenuFlows(driver, HamburgerMenuOptions.WATCHING).openMenuOption();
		new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(new HamburgerMenuPanel(driver)).validateWatchingPage();

		CombinedSteps.watchContainerContentChecks(driver, uiAssert);
		CombinedSteps.watchContainerSortChecks("ACTIVE", Sort.HIGH_PRICE_POSTAGE, srp, driver, uiAssert);
		CombinedSteps.watchContainerSortChecks("ACTIVE", Sort.LOW_PRICE_POSTAGE, srp, driver, uiAssert);
		CombinedSteps.watchContainerSortChecks("ACTIVE", Sort.ENDING_SOON, srp, driver, uiAssert);
		CombinedSteps.watchContainerSortChecks("ACTIVE", Sort.RECENTLY_ADDED, srp, driver, uiAssert);

		CombinedSteps.watchContainerContentChecks(driver, uiAssert);
		CombinedSteps.watchContainerSortChecks("ENDED", Sort.HIGH_PRICE_POSTAGE, srp, driver, uiAssert);
		CombinedSteps.watchContainerSortChecks("ENDED", Sort.LOW_PRICE_POSTAGE, srp, driver, uiAssert);

		uiAssert.end();
	}

	@Test(description="Validations for Purchase Container")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_PURCHASES() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.PURCHASES).openMenuOption();
		
		new PurchasesValidators.Use().uiAssertion(uiAssert).validate(driver).setPurchasesValidators(new HamburgerMenuPanel(driver)).validatePurchasesPage().validatePurchasesStatusText();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().clickEditButton();
		new PurchasesValidators.Use().uiAssertion(uiAssert).validate(driver).setPurchasesValidators(new HamburgerMenuPanel(driver)).validateCheckboxEnabled();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().deleteItem();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().clicKRefineButton();
		new PurchasesValidators.Use().uiAssertion(uiAssert).validate(driver).setPurchasesValidators(new HamburgerMenuPanel(driver)).validateRefinementOptions();
		
		
		
		uiAssert.end();
	}

	@Test(description="Validations for Bids & Offers container")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_BIDSOFFERS() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		SearchResultsPage srp = new SearchResultsPage(driver);
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.BIDS_and_OFFERS).openMenuOption();
		new BidsOffersValidators.Use().uiAssertion(uiAssert).validate(driver).setBidsOffersValidators(new HamburgerMenuPanel(driver))
		.validateBidsOffersPageElements().validateTileElements_BIDS();

		CombinedSteps.bidsOffersContainerSortChecks(Sort.HIGH_PRICE_POSTAGE, srp, driver, uiAssert);
		CombinedSteps.bidsOffersContainerSortChecks(Sort.LOW_PRICE_POSTAGE, srp, driver, uiAssert);
		/*CombinedSteps.bidsOffersContainerSortChecks(Sort.ENDING_SOON, srp, driver, uiAssert);*/

		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().clickonOffersTab();
		new BidsOffersValidators.Use().uiAssertion(uiAssert).validate(driver).setBidsOffersValidators(new HamburgerMenuPanel(driver)).validateTileElements_OFFERS();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().clickonDidntWinTab();
		new BidsOffersValidators.Use().uiAssertion(uiAssert).validate(driver).setBidsOffersValidators(new HamburgerMenuPanel(driver)).validateTileElements_DIDNTWIN();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().clickonDidntWinEDITtab().deleteAnItem();
		uiAssert.end();
	}

	@Test(description="Validations for Selling Destination Page and related container: Drafts, Active, Sold & Unsold")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_SELLING() throws Exception {
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);

		TimeAndDateUtils.customDate = TimeAndDateUtils.getCalDate();
		ItemType itemType = TestDataProvider.getItemTypeObject(ItemTemplateType.FixedPrice);
		new TradingAPIUtil.ProdItemActions.ProdAddItem(itemType, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getPassword()).listItem();

		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE));
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SELLING).openMenuOption();
		new SellingValidators.Use().uiAssertion(uiAssert).validate(driver).setHamburgerMenuPanelObject(new HamburgerMenuPanel(driver)).validateSellingPage();
		new HomeScreen(driver).getHomeScreenHeaderComponent().goToHome();
		new HomeScreen(driver).getHomeScreenContentComponent().clickSellingCapsule();
		new SellingValidators.Use().uiAssertion(uiAssert).validate(driver).setHamburgerMenuPanelObject(new HamburgerMenuPanel(driver)).validateSellingPage();

		CombinedSteps.sellContainerChecks(SellContainer.ACTIVE, driver, uiAssert);
		CombinedSteps.sellContainerChecks(SellContainer.SOLD, driver, uiAssert);
		CombinedSteps.sellContainerChecks(SellContainer.UNSOLD, driver, uiAssert);

		/*DRAFTS CONTAINER*/
		new SellingPage(driver).getSellingPageComponent().seeAllDrafts();
		new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(new SellingPage(driver)).validateDraftContainer();
		new SellingPage(driver).getSellingDraftsComponent().deleteDraft(true);

		/*SCHEDULED LISTINGS CONTAINER*/
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SELLING).openMenuOption();
		new SellingPage(driver).getSellingPageComponent().clickScheduledListingLink();
		new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(new SellingPage(driver)).validateSellingScheduledContainer();
		new SellingPage(driver).getSellingScheduledContainerComponent().clickShceduledItem();
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver)).validateSellerScheduledListingHeader();
		new ViewItemPage(driver).getViewItemPageComponent().getSellerViewItemPageActions().endListing();
		uiAssert.end();
	}

	@Test(description="Validations for Settings Menu")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_SETTINGS() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE));
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SETTINGS).openMenuOption();
		new SettingsValidators.Use().uiAssertion(uiAssert).validate(driver).setSettingsValidators(new HamburgerMenuPanel(driver)).validateSettingsPageElements();
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().getSettingsComponent().clickPostageAdress(uiAssert);
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().getSettingsComponent().clickSigningIn(uiAssert); 
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().getSettingsComponent().clickCountryLink(uiAssert);
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().getSettingsComponent().clickCustomerServiceLink(uiAssert);
		uiAssert.end();
	}

	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getRegUserData", description="Validations for addition of Current Country & US Postage Address")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_POSTAGE_ADDRESS(TestObject testObject,User user) throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1));
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SETTINGS).openMenuOption();
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().getSettingsComponent().clickPostageAdress(uiAssert)
			.addPostageAddress(testObject, user)
			.makeAddressPrimary()
			.deletePostageAdress();
		uiAssert.end();
	}

	@Test(description="Validations for Deals Landing Page")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_DEALS_PAGE() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1));
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.DEALS).openMenuOption();

		List<DealsTabs> enumValues = new ArrayList<DealsTabs>(EnumSet.allOf(DealsTabs.class));
		for (DealsTabs dealTab : enumValues) {
			new DealsPage(driver).getDealsTabComponent().showTabContentsFor(dealTab, false);
			new DealsPageValidator.Use().uiAssertion(uiAssert).validate(driver).setDealsPage(new DealsPage(driver))
			.validateFeaturedSection(dealTab)
			.validateTrendingSection(dealTab)
			.validateFeaturedEventSection(dealTab)
			.validateSalesEventSection(dealTab);
		}
		uiAssert.end();
	}

	@Test(description="Validations for Following Container: Searches, Members & Collections(NA for now)")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_FOLLOWING() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1));

		Map<String, String> followedData = CombinedSteps.createFollowedData(driver);
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SAVED_or_FOLLOWED).openMenuOption();

		FollowingsPage followPage = new FollowingsPage(driver);

		followPage.getFollowingsPageComponent().showFollowedSearches();
		new FollowingsPageValidators.Use().uiAssertion(uiAssert).validate(driver).setFollowingsPageValidators(followPage)
		.validateFollowingsSearchesTab()
		.validateFollowedSearchItemExists(followedData.get("SRCH"));
		followPage.getFollowingsPageComponent().removeFollowedItems();

		followPage.getFollowingsPageComponent().showFollowedMembers();
		new FollowingsPageValidators.Use().uiAssertion(uiAssert).validate(driver).setFollowingsPageValidators(followPage)
		.validateFollowingsMembersTab()
		.validateFollowedMemberExists(followedData.get("MEM"));
		followPage.getFollowingsPageComponent().removeFollowedItems();

		/*followPage.getFollowingsPageComponent().showFollowedCollections();
		new FollowingsPageValidators.Use().uiAssertion(uiAssert).validate(driver).setFollowingsPageValidators(followPage).validateFollowingsCollectionsTab();
		followPage.getFollowingsPageComponent().removeFollowedItems();*/

		uiAssert.end();
	}

}