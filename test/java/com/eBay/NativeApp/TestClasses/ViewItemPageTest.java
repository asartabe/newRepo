package com.eBay.NativeApp.TestClasses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.Commons.ResourceFiles;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.TestDataUtils;
import com.eBay.NativeApp.Enums.ItemsToSearch;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Enums.ShareOptionsMenu;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SearchFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.CartPage;
import com.eBay.NativeApp.Pages.CheckoutPage;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.SharePanel;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.CombinedSteps;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil.ProdItemActions.ProdAddItem;
import com.eBay.NativeApp.Validators.CartPageValidators;
import com.eBay.NativeApp.Validators.CheckoutPageValidators;
import com.eBay.NativeApp.Validators.SRPValidators;
import com.eBay.NativeApp.Validators.SharePanelValidators;
import com.eBay.NativeApp.Validators.ViewItemPageValidators;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.soap.eBLBaseComponents.AddItemResponseType;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIException;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class ViewItemPageTest extends UIBaseTest{
	
	@Test(description="Validates all UI Elements/Sections on VIP")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_VIP_COMPLETE() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);

		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1));
		SearchFlows.searchAndSelectFirstItem(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);
		
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver))
			.checkBasicUIElements()
			.checkVISectionsAndOtherComponents();
		
		new ViewItemPage(driver).getViewItemPageComponent().viewPostageReturnPaymentDetails();
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver))
			.validatePostageReturnPaymentPageUI();
		new CustomTouchUtils().deviceBack(driver);
		
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU")){
			Iterator<Object[]> ite = TestDataProvider.getCnCSearchData();
			while(ite.hasNext()){	
				Object[] object = ite.next();
				String srchKey = Arrays.copyOf(object, object.length, String[].class)[0];

				CombinedSteps.searchCNCAndGoToSRP(driver, uiAssert, srchKey);
				new SearchResultsPage(driver).getSRPResultsComponent().selectFirstItemFromResults();

				ViewItemPage viPage = new ViewItemPage(driver);
				if(CustomTouchUtils.scrollToElement(new WebActions(driver), ScrollDirection.DOWN, 
						viPage.getViewItemPageComponent().SEC_SPR))
					new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(viPage)
					.validateCnCLabelOnVIP();

				viPage.getViewItemPageComponent().viewPostageReturnPaymentDetails();
				new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(viPage)
				.validateCnCDetailsOnSPRPage();
			}
		}
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Validates UI Element specifics for CBT Items")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_CBT_ITEM_VI(TestObject testObject, ItemType item) throws APIException, Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		item = TestDataUtils.getCBT_Item(item);
		AddItemResponseType addResp = new ProdAddItem(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		SearchFlows.searchFor(item.getItemID(), false);
		
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver))
			.validateCBTPricesOnVIP();
		
		new TradingAPIUtil.ProdItemActions.EndItemAction(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getPassword()).endItem(EndReasonCodeType.INCORRECT);
	
		uiAssert.end();
	}
	
	@Test(description="Validates Ratings & Reviews Section and R&R Details Page and Submit Reviews page")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_RATINGS_REVIEWS_VI() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		CombinedSteps.searchItemWithReviewsAndRatings(driver);
		
		ViewItemPage viPage = new ViewItemPage(driver);
		viPage.getViewItemPageComponent().getBuyerViewItemPageActions().clickReviewStarsAndGoToRatingsReviewsSection();
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(viPage).validateRatingsAndReviewsOnVIP();
		viPage.getViewItemPageComponent().getBuyerViewItemPageActions().clickToSeeAllReviews();
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(viPage).validateRatingsAndReviewsLandingPage();
		viPage.getViewItemPageComponent().getBuyerViewItemPageActions().clickToWriteAReview();
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(viPage).validateWriteAReviewPage();
		
		uiAssert.end();
	}
	
	@Test(description="Validates VIP, SOP & Cart/XO Pages for SME Item")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_SME_ITEM() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		HashMap<String, String> smeItems = TestDataProvider.getResourceData(ResourceFiles.PROMOTION_DATA);
		
		SearchFlows.searchFor(smeItems.get(ItemsToSearch.SME.PROMO_ITEM1.getValue()), false);
		
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver)).validateSMEPanelOnVIP();
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().getMoreSMEItems();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(new SearchResultsPage(driver)).validateSMEOfferItemSRP();
		new SearchResultsPage(driver).getSRPResultsComponent().selectFirstItemFromResults();
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickATCButton();
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickCart();
		new CartPageValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(new CartPage(driver))
			.validateCartContents()
			.validateLineItemDetails()
			.validateSMEDetails();
		new CartPage(driver).getCartPageComponent().proceedToCheckout();
		new CheckoutPageValidators.Use().uiAssertion(uiAssert).validate(driver).setCheckoutPage(new CheckoutPage(driver)).validateSMEDiscountLabel();
		new CustomTouchUtils().deviceBack(driver);
		new CartPage(driver).getCartPageComponent().removeItem();
		uiAssert.end();
	}
	
	@Test(description="Validates Share Item functionality on VIP")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_VIEW_ITEM_SHARE() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		SearchFlows.searchAndSelectFirstItem(ItemsToSearch.KeyWord.CAMERA.getKeyWord(), false);
		
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickShareItemButton();
		new SharePanelValidators.Use().uiAssertion(uiAssert).validate(driver).setSharePanel(new SharePanel(driver)).validateSharePanelDetails();
		new SharePanel(driver).getSharePanelComponent().shareViaOption(ShareOptionsMenu.FACEBOOK);
		
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickShareItemButton();
		new SharePanel(driver).getSharePanelComponent().shareViaOption(ShareOptionsMenu.TWITTER);
		
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickShareItemButton();
		new SharePanel(driver).getSharePanelComponent().shareViaOption(ShareOptionsMenu.GMAIL);
		
	}
	
	@Test(description="Validates eGD on VIP")
	@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI})
	public void test_eGD_ON_VIP() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BASICSTORE));
		SearchResultsPage srp = new SearchResultsPage(driver);
		SearchFlows.searchFor(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);
		srp.getSRPResultsComponent().turneGDToggleON();
		new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().selectFirstItemFromResults();
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(new ViewItemPage(driver))
		.validateEgdTextOnVIP();		
	}
}
