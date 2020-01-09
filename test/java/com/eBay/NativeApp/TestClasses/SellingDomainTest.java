package com.eBay.NativeApp.TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Flows.HamburgerMenuFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SellAnItemPage;
import com.eBay.NativeApp.Pages.SellingPage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.CombinedSteps;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.Validators.SellAnItemPageValidators;
import com.eBay.NativeApp.Validators.ViewItemPageValidators;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Site;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class SellingDomainTest extends UIBaseTest{
	
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL}, dontRunFor={Site.SG, Site.MY, Site.PH})
	@Test(description="Listing Flow & validations for Catalogue Products")
	public void test_CATALOG_LISTING() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE));
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSellingCapsule();
		new SellingPage(driver).getSellingPageComponent().clickListAnItemButton();
		
		ItemType item = new ItemType();
		item.setTitle("DVD Movies");
		
		SellAnItemPage syi = new SellAnItemPage(driver);
		syi.getSellAnItemPageComponent().enterTitleAndProceed(item);
		new SellAnItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setSellAnItemPage(syi)
			.validateCatalogProductSuggestions();
		item.setTitle(syi.getSellAnItemPageComponent().selectCatalogProduct());
		new SellAnItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setSellAnItemPage(syi)
			.validateTitleText(item)
			.validateSuggestedPostage();
		syi.getSellAnItemPageComponent().editCategory(true);
		new SellAnItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setSellAnItemPage(syi)
			.validateNoSuggestedPostage();
		
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getSellItem", description="Listing Flow for BIN/Auction/ABIN & BIN with BO")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_LISTING_FLOW(TestObject testObject, ItemType item) throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE));
		
		try{new HomeScreen(driver).getHomeScreenContentComponent().clickSellingCapsule();}
		catch(Exception ex){new HamburgerMenuFlows(driver, HamburgerMenuOptions.SELLING).openMenuOption();}
		new SellingPage(driver).getSellingPageComponent().clickListAnItemButton();
		
		item.setTitle("DT_TEST-TestItemDoNotBuy_"+System.currentTimeMillis());
		ViewItemPage vip = new ViewItemPage(driver);
		
		if(testObject.getTestTitle().equalsIgnoreCase("BIN_Listing") || 
				testObject.getTestTitle().equalsIgnoreCase("AUCTION_Listing") ||
				testObject.getTestTitle().equalsIgnoreCase("AUCTION_wRESERVE_Listing")){
			CombinedSteps.executeListingSteps(driver, item, false, false, false);
			new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(vip)
				.validateItemTitle(item);
		}
		else if(testObject.getTestTitle().equalsIgnoreCase("ABIN_Listing")){
			CombinedSteps.executeListingSteps(driver, item, true, false, false);
			new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(vip)
				.validateItemTitle(item);
		}
		else if(testObject.getTestTitle().equalsIgnoreCase("BIN_wBO_Listing")){
			CombinedSteps.executeListingSteps(driver, item, false, true, false);
			new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(vip)
				.validateItemTitle(item);
		}
		if(testObject.getTestTitle().equalsIgnoreCase("BIN_Listing")){
			/*REVISE_FLOW*/
			vip.getViewItemPageComponent().getSellerViewItemPageActions().clickToReviseListing();
			item.setTitle("REVISED_TEST_ITEM_"+System.currentTimeMillis());
			item.setDescription("REVISED_DESC - TEST ITEM DO NOT BUY");
			CombinedSteps.executeRevisionSteps(driver, item);
			new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(vip).validateItemTitle(item);
		}
		
		new ViewItemPage(driver).getViewItemPageComponent().getSellerViewItemPageActions().clickToEndListingAndConfirm();
		new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(vip)
			.validateSellerEndedItemVI();
		
		if(testObject.getTestTitle().equalsIgnoreCase("BIN_Listing")){
			/*RELIST_FLOW*/
			vip.getViewItemPageComponent().getSellerViewItemPageActions().clickToRelist();
			new SellAnItemPage(driver).getReviewPageComponent().clickListItButton();
			new SellAnItemPage(driver).getListingSuccessComponent().clickViewListedItem();
			
			vip.getViewItemPageComponent().getSellerViewItemPageActions().clickToEndListingAndConfirm();
			
			/*SELL_SIMILAR_FLOW*/
			vip.getViewItemPageComponent().getSellerViewItemPageActions().clickToSellSimilar();
			item.setTitle("SELL_SIMILAR_TEST_ITEM_"+System.currentTimeMillis());
			new SellAnItemPage(driver).getSellAnItemPageComponent().editTitle(item)
				.continueToFinishListing();
			new SellAnItemPage(driver).getReviewPageComponent().clickListItButton();
			new SellAnItemPage(driver).getListingSuccessComponent().clickViewListedItem();
			new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver).setViewItemPageObject(vip).validateItemTitle(item);
			vip.getViewItemPageComponent().getSellerViewItemPageActions().clickToEndListingAndConfirm();
		}
	
		uiAssert.end();
	}
	
}
