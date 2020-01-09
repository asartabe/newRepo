package com.eBay.NativeApp.TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.CustomUtils.TestDataUtils;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Flows.BuyingFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchPage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.CombinedSteps;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIException;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class BuyingDomainTest extends UIBaseTest{
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Purchase Flows for BIN/Auction/ABIN/Bin with BO (incl Auto-Accept/Decline)")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_PURCHASE(TestObject testObject, ItemType item) throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		if(testObject.getTestTitle().contentEquals("FP_BO_AUTO_ACCEPT") || testObject.getTestTitle().contentEquals("FP_BO_AUTO_DECLINE"))
			item = TestDataUtils.setAutoBODetails(item);
		
		CombinedSteps.executeBuyingSetupSteps(driver, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_PREMIUMSTORE), item, 1, uiAssert);
		
		if(testObject.getTestTitle().equalsIgnoreCase("FIXED_PRICE_ITEM") ||
				testObject.getTestTitle().equalsIgnoreCase("AUCTION_ITEM") ||
				testObject.getTestTitle().equalsIgnoreCase("FP_BESTOFFER_ITEM"))
			BuyingFlows.purchaseThisItem(item, 1);
		else if(testObject.getTestTitle().equalsIgnoreCase("BINAUCTION_ITEM_viaBIN"))
			BuyingFlows.purchaseABINItem(item, ListingTypeCodeType.FIXED_PRICE_ITEM);
		else if(testObject.getTestTitle().equalsIgnoreCase("BINAUCTION_ITEM_viaBID"))
			BuyingFlows.purchaseABINItem(item, ListingTypeCodeType.AUCTION);		
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Review Offer FLows: Accept/Decline/Counter Offer")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_REVIEWOFFERS(TestObject testObject, ItemType item) throws APIException, Exception {
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		Double initPrice = item.getStartPrice().getValue();
		SetupCountryInSettings.setupCountry(driver);
		
		CombinedSteps.getItemForOfferReview(driver, item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1));
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE));
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(driver).getSearchPageQueryComponent().createSearch(item.getItemID(), false);
		
		if(testObject.getTestTitle().contains("ACCEPT"))
			new ViewItemPage(driver).getViewItemPageComponent().getSellerViewItemPageActions().clickToReviewOffers()
				.getRespondOffersComponent()
				.acceptOffer(uiAssert);
		else if(testObject.getTestTitle().contains("DECLINE"))
			new ViewItemPage(driver).getViewItemPageComponent().getSellerViewItemPageActions().clickToReviewOffers()
				.getRespondOffersComponent()
				.declineOffer(uiAssert);
		else if(testObject.getTestTitle().contains("COUNTER"))
			new ViewItemPage(driver).getViewItemPageComponent().getSellerViewItemPageActions().clickToReviewOffers()
				.getRespondOffersComponent()
				.counterOffer(initPrice-1.00, 1, uiAssert);
		
		uiAssert.end();
	}
	
} 