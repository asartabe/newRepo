package com.eBay.NativeApp.TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Flows.HamburgerMenuFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.PushNotificationPanel;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil.ProdItemActions.ProdAddItem;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil.PurchaseAPI;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.soap.eBLBaseComponents.AddItemResponseType;
import com.ebay.soap.eBLBaseComponents.BidActionCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIException;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class NotificationsTest extends UIBaseTest{

	private void dismissOldNotifsFirst(WebDriver driver){
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.NOTIFICATIONS).openMenuOption();
		while (new WebActions(driver).element().present().byPolling(new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILES)) {
				new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().getNotificationcomponent().dismissFirstNotification();
		}
	}
	
	private String getNotifDetails(WebDriver driver){
		return new PushNotificationPanel(driver).getPushNotifications()
				.getNotificationsPanel().getNotificationDetails();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Notif Title should contain OUTBID")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_OUTBID_NOTIF(TestObject testObject, ItemType item) throws APIException, Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		Double initPrice = item.getStartPrice().getValue();
		SetupCountryInSettings.setupCountry(driver);
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2));
		dismissOldNotifsFirst(driver);
		
		AddItemResponseType addResp = new ProdAddItem(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		new PurchaseAPI(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2).getPassword(), initPrice+2.00).placePurchase(BidActionCodeType.BID);
		new PurchaseAPI(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1).getPassword(), initPrice+5.00).placePurchase(BidActionCodeType.BID);
		
		CustomWaitUtils.waitForSeconds(5);
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.NOTIFICATIONS).openMenuOption();
		String notifDetails = new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().getNotificationcomponent().getTitleForFirstNotification(); 
		uiAssert.string().containsIgnoringCase(notifDetails, "outbid", "Notification Details doesn't contain Outbid");
		breezeReport.logBoldStep("In-App Notification Title: \n"+ notifDetails);
		
		notifDetails = getNotifDetails(driver);
		uiAssert.string().containsIgnoringCase(notifDetails, "outbid", "Notification Details doesn't contain Outbid");
		breezeReport.logBoldStep("PUSH Notification Details: \n"+ notifDetails);
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Notif Title chould contain NEW OFFER")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_OFFERPLACED_NOTIF(TestObject testObject, ItemType item) throws APIException, Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		Double initPrice = item.getStartPrice().getValue();
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE));
		dismissOldNotifsFirst(driver);
		
		AddItemResponseType addResp = new ProdAddItem(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		new PurchaseAPI(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1).getPassword(), initPrice-2.00).placePurchase(BidActionCodeType.OFFER);
		
		CustomWaitUtils.waitForSeconds(5);
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.NOTIFICATIONS).openMenuOption();
		String notifDetails = new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().getNotificationcomponent().getTitleForFirstNotification(); 
		uiAssert.string().containsIgnoringCase(notifDetails, "offer", "Notification Details doesn't contain Offer-text");
		breezeReport.logBoldStep("In-App Notification Title: \n"+ notifDetails);
		
		notifDetails = getNotifDetails(driver);
		uiAssert.string().containsIgnoringCase(notifDetails, "offer", "Notification Details doesn't contain Offer-text");
		breezeReport.logBoldStep("Notification Details: \n"+ notifDetails);
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Notif Title chould contain ITEM SOLD")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_ITEMSOLD_NOTIF(TestObject testObject, ItemType item) throws APIException, Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE));
		dismissOldNotifsFirst(driver);
		
		AddItemResponseType addResp = new ProdAddItem(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		new PurchaseAPI(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER1).getPassword()).placePurchase(BidActionCodeType.PURCHASE);
		
		CustomWaitUtils.waitForSeconds(5);
		String notifDetails = getNotifDetails(driver);
		uiAssert.string().containsIgnoringCase(notifDetails, "sold", "Notification Details doesn't contain Sold-text");
		breezeReport.logBoldStep("Notification Details: \n"+ notifDetails);
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Notif Title chould contain BID RECEIVED")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_BIDRECEIVED_NOTIF(TestObject testObject, ItemType item) throws APIException, Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		Double initPrice = item.getStartPrice().getValue();
		SetupCountryInSettings.setupCountry(driver);
		
		LoginFlows.signInFromHomeScreen(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE));
		dismissOldNotifsFirst(driver);
		
		AddItemResponseType addResp = new ProdAddItem(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE).getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		new PurchaseAPI(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2).getPassword(), initPrice+2.00).placePurchase(BidActionCodeType.BID);
		
		CustomWaitUtils.waitForSeconds(5);
		String notifDetails = getNotifDetails(driver);
		uiAssert.string().containsIgnoringCase(notifDetails, "bid", "Notification Details doesn't contain Bid-text");
		breezeReport.logBoldStep("Notification Details: \n"+ notifDetails);
		uiAssert.end();
	}
	
}
