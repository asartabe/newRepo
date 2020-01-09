package com.eBay.NativeApp.TestClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.Commons.ProdUserData;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Flows.HamburgerMenuFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SearchFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.SellingPage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil.PurchaseAPI;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil.ProdItemActions.EndItemAction;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil.ProdItemActions.ProdAddItem;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.soap.eBLBaseComponents.AddItemResponseType;
import com.ebay.soap.eBLBaseComponents.BidActionCodeType;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class OtherTests extends UIBaseTest{
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getProdItem", description="Validate LOCAL PICKUP labels at various pages/screens")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_LOCAL_PICKUP_ITEM(TestObject testObject, ItemType item) throws Exception{
		
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiChainAssert = new UIChainAssert(driver); 
		WebActions actions = new WebActions(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		ProdUserData buyer = TestDataProvider.getProductionUser(ProdUserCredentials.TEST_BUYER2);
		
		AddItemResponseType addResp = new ProdAddItem(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_PREMIUMSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_PREMIUMSTORE).getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		
		new PurchaseAPI(item, buyer.getUserName(), buyer.getPassword()).placePurchase(BidActionCodeType.BID);
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(buyer);
		
		if(searchForMyLocalPickupItem(driver, actions, item)){
			uiChainAssert.element().withinParent(actions.element().get().allWebElementsWithSameLocator(new SearchResultsPage(driver).getSRPResultsComponent().SRCH_RESULTS).get(0))
				.attributeValueMatches(new SearchResultsPage(driver).getSRPResultsComponent().SRP_ITM_EDD, "name", "Local pickup", "Incorrect Label for LOCAL PICKUP Item on SRP");
			breezeReport.logBoldStep("LOCAL PICKUP Label Verified on SRP");
		}
		else new GenericAssert().fail("Local Pickup Item was not found on SRP...").end();
		
		actions.element().click().by(new SearchResultsPage(driver).getSRPResultsComponent().SRCH_RESULTS);
		uiChainAssert.element()
			.present(new ViewItemPage(driver).getViewItemPageComponent().LOCAL_PICKUP_INFO, "LOCAL PICKUP element is missing on VIP")
			.textMatches(new ViewItemPage(driver).getViewItemPageComponent().LOCAL_PICKUP_INFO, "Local Pickup", "Incorrect Label for LOCAL PICKUP on VIP");
		
		WebElement lineItem = null;
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.BIDS_and_OFFERS).openMenuOption();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().clickonBidTab();
		lineItem = getMyLocalPickupItem(driver, actions, item, "BIDS");
		if(found)
			uiChainAssert.element().withinParent(lineItem)
				.textMatches(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_POSTAGE, "See description", "Label for Postage Info for LOCAL PICKUP Item in BIDS Container is Incorrect.");
		else uiChainAssert.generic().assertTrue(found, "Required LINE_ITEM was not found in BIDS Container");
		
		new EndItemAction(item, 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_PREMIUMSTORE).getUserName(), 
				TestDataProvider.getProductionUser(ProdUserCredentials.TEST_PREMIUMSTORE).getPassword()).endItem(EndReasonCodeType.SELL_TO_HIGH_BIDDER);
		
		new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().clickSignOut();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_PREMIUMSTORE));
		
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SELLING).openMenuOption();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getSellingComponent().goToSoldContainer();
		lineItem = getMyLocalPickupItem(driver, actions, item, "SOLD");
		if(found)
			uiChainAssert.element().withinParent(lineItem)
				.textMatches(new SellingPage(driver).getSellingContainersComponent().SOLD_ITM_POSTAGE, "", "Label for Postage Info for LOCAL PICKUP Item in SELLING > SOLD Container is Incorrect.");
		else uiChainAssert.generic().assertTrue(found, "Required LINE_ITEM was not found in SELLING > SOLD Container");
		
		uiChainAssert.end();
	}
	
	boolean found = false;
	private boolean searchForMyLocalPickupItem(WebDriver driver, WebActions actions, ItemType item){
		found = false;
		int ctr = 0;
		while(!found && ctr < 5){
			SearchFlows.searchFor(item.getTitle(), false);
			CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 4, ScrollDirection.UP);
			if(actions.element().present().now(new SearchResultsPage(driver).getSRPResultsComponent().SRCH_RESULTS) &&
					actions.element().withinParent(new SearchResultsPage(driver).getSRPResultsComponent().SRCH_RESULTS)
					.get().text(new SearchResultsPage(driver).getSRPResultsComponent().SRP_ITM_TITLE, "").contentEquals(item.getTitle()))
			{	found = true; 
				break;
			}
			else CustomWaitUtils.waitForSeconds(4);
		}
		
		return found;
	}
	
	private WebElement getMyLocalPickupItem(WebDriver driver, WebActions actions, ItemType item, String container){
		List<WebElement> allItems = new ArrayList<>();
		WebElement element = null;
		found = false;
		int tries = 0; 
		while(tries < 3 && !found){
			if(container.contentEquals("BIDS") && (actions.element().present().byPolling(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS)))
			{
				allItems = actions.element().get().allWebElementsWithSameLocator(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS);
				for (WebElement el : allItems) {
					if((item.getTitle().toString())
							.contains(actions.element().withinParent(el).get().text(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_TITLE, ""))){
						found = true;
						element = el;
					}
				}
			}
			else if(container.contentEquals("ACTIVE") || container.contentEquals("SOLD") ||container.contentEquals("UNSOLD") 
					&& (actions.element().present().byPolling(new SellingPage(driver).getSellingContainersComponent().ITEM_CONTAINER))){
				allItems = actions.element().get().allWebElementsWithSameLocator(new SellingPage(driver).getSellingContainersComponent().ITEM_CONTAINER);
				for (WebElement el : allItems) {
					switch(container){
					case "ACTIVE":
						if((item.getTitle().toString())
								.contains(actions.element().withinParent(el).get().text(new SellingPage(driver).getSellingContainersComponent().ACTIVE_ITM_TITLE, ""))){
							found = true;
							element = el;
						}
						break;
					case "SOLD":
						if((item.getTitle().toString())
								.contains(actions.element().withinParent(el).get().text(new SellingPage(driver).getSellingContainersComponent().SOLD_ITM_TITLE, ""))){
							found = true;
							element = el;
						}
						break;
					case "UNSOLD":
						if((item.getTitle().toString())
								.contains(actions.element().withinParent(el).get().text(new SellingPage(driver).getSellingContainersComponent().UNSOLD_ITM_TITLE, ""))){
							found = true;
							element = el;
						}
						break;
					default: element = null;
					}
					if(found) break;
				}
			}
			if(!found){
					CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.UP);
					tries++;
				}
		}
		
		if(element == null)
			found = false;
		
		return element;
		
	}
	
}
