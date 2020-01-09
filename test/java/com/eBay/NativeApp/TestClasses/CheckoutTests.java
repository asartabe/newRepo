package com.eBay.NativeApp.TestClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.Commons.SearchRefinementType.eGD;
import com.eBay.NativeApp.Enums.ItemsToSearch;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Enums.TestPayPalEmail;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SearchFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.CartPage;
import com.eBay.NativeApp.Pages.CheckoutPage;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchPage;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.CombinedSteps;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.Validators.CartPageValidators;
import com.eBay.NativeApp.Validators.CheckoutPageValidators;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.soap.eBLBaseComponents.BidActionCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIException;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Site;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class CheckoutTests extends UIBaseTest{
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Completes XO via PayPal Flow")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_CHECKOUT_viaPAYPAL(TestObject testObject, ItemType item) throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		item = CombinedSteps.getItemForXO(driver, uiAssert, item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2),
				BidActionCodeType.PURCHASE);
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(driver).getSearchPageQueryComponent().createSearch(item.getItemID(), false);
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickPayNow();
		
		new CheckoutPageValidators.Use().uiAssertion(uiAssert).validate(driver).setCheckoutPage(new CheckoutPage(driver))
			.validateSellerAndItemDetailsOnXO()
			.validateSellerPostageInfo()
			.validateSendMessageToSellerLink()
			.validateXOSummary();
		
		new CheckoutPage(driver).getCheckoutPageComponent()
			.selectPaymentOption()
			.payViaPayPal(TestPayPalEmail.PAYPAL_ADDRESS1)
			.confirmAndPay();
		
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Completes Multiple Currency XO via Cart")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL}, dontRunFor={Site.SG, Site.MY, Site.PH})
	public void test_XO_viaCART(TestObject testObject, ItemType item) throws APIException, Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		List<String> itemIDs = CombinedSteps.getItemsToXOviaCart(driver, item, 
									TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE), 
									TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		for (String itemID : itemIDs) new CombinedSteps().addThisItemToCart(driver, uiAssert, itemID);
		
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickCart();
		
		for(int i=0; i<itemIDs.size(); i++){
			new CartPageValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(new CartPage(driver))
				.validateCartContents()
				.validateLineItemDetails();
			new CartPage(driver).getCartPageComponent().proceedToCheckout();
			
			if(i < itemIDs.size()-1)
				new CheckoutPageValidators.Use().uiAssertion(uiAssert).validate(driver).setCheckoutPage(new CheckoutPage(driver))
					.validateAlertDetails();
			
			new CheckoutPage(driver).getCheckoutPageComponent()
				.selectPaymentOption()
				.payViaPayPal(TestPayPalEmail.PAYPAL_ADDRESS1)
				.confirmAndPay();
			
			if(i < itemIDs.size()-1)
				new CheckoutPage(driver).getCheckoutPageComponent().goBackToCartFromXOSuccess();
		}
		
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="srchData", description="Validates Store Info for C&C Items on VI & XO")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL}, dontRunFor={Site.SG, Site.MY, Site.PH})
	public void test_STORES_FOR_CnC(String srchKey) throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		
		CombinedSteps.searchCNCAndGoToSRP(driver, uiAssert, srchKey);
		new SearchResultsPage(driver).getSRPResultsComponent().selectFirstItemFromResults();
		
		ViewItemPage viPage = new ViewItemPage(driver);
		viPage.getViewItemPageComponent().getBuyerViewItemPageActions().clickBINButton();
		
		new CheckoutPageValidators.Use().uiAssertion(uiAssert).validate(driver).setCheckoutPage(new CheckoutPage(driver))
			.validateCnCAvailable();
		new CheckoutPage(driver).getCheckoutPageComponent().selectClickAndCollectOption();
		new CheckoutPageValidators.Use().uiAssertion(uiAssert).validate(driver).setCheckoutPage(new CheckoutPage(driver))
			.validateCnCSelectedStoreDetails();
		
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="srchData", description="Validates XO of an eGD item")
	@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI, Type.FUNCTIONAL})
	public void test_XO_FOR_eGD(String srchKey) throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		
		SearchFlows.searchFor(ItemsToSearch.Member.AU_TESTAUBASIC.getMemberName(), true);
		new SearchResultsPage(driver).getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(true).addeGDOptions(eGD.THREE_DAY_SHIPPING).saveRefinements();
		new SearchResultsPage(driver).getSRPResultsComponent().selectFirstItemFromResults();
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickPayNow();
		new CheckoutPageValidators.Use().uiAssertion(uiAssert).validate(driver).setCheckoutPage(new CheckoutPage(driver)).validateEGDLabel();
		
		new CheckoutPage(driver).getCheckoutPageComponent()
		.selectPaymentOption()
		.payViaPayPal(TestPayPalEmail.PAYPAL_ADDRESS1)
		.confirmAndPay();
		
		new CheckoutPageValidators.Use().uiAssertion(uiAssert).validate(driver).setCheckoutPage(new CheckoutPage(driver)).validateEGDLabel();
		uiAssert.end();
	}
	
}
