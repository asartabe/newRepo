package com.eBay.NativeApp.TestHelpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Commons.ProdUserData;
import com.eBay.NativeApp.Commons.SearchRefinementType.BuyingFormat;
import com.eBay.NativeApp.Commons.SearchRefinementType.DeliveryOptions;
import com.eBay.NativeApp.Commons.SearchRefinementType.ItemLocation;
import com.eBay.NativeApp.Commons.SearchRefinementType.Sort;
import com.eBay.NativeApp.Commons.SearchRefinementType.View;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.TestDataUtils;
import com.eBay.NativeApp.Enums.Feedback;
import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Enums.ItemsToSearch;
import com.eBay.NativeApp.Enums.SellContainerEnums.SellContainer;
import com.eBay.NativeApp.Enums.SellContainerEnums.SellContainerFilters;
import com.eBay.NativeApp.Flows.HamburgerMenuFlows;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SearchFlows;
import com.eBay.NativeApp.Flows.UpdateDCS;
import com.eBay.NativeApp.Pages.FeedbackDetailsPage;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchPage;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.SellAnItemPage;
import com.eBay.NativeApp.Pages.SellingPage;
import com.eBay.NativeApp.Pages.UserProfilePage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil.ProdItemActions.ProdAddItem;
import com.eBay.NativeApp.TestHelpers.TradingAPIUtil.PurchaseAPI;
import com.eBay.NativeApp.Validators.BidsOffersValidators;
import com.eBay.NativeApp.Validators.FeedbackDetailsPageValidators;
import com.eBay.NativeApp.Validators.SRPValidators;
import com.eBay.NativeApp.Validators.SellingContainerValidators;
import com.eBay.NativeApp.Validators.UserProfilePageValidators;
import com.eBay.NativeApp.Validators.WatchingValidators;
import com.ebay.quality.testdataautil.type.UserType;
import com.ebay.soap.eBLBaseComponents.AddItemResponseType;
import com.ebay.soap.eBLBaseComponents.BidActionCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIException;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;

public class CombinedSteps {

	public static void executeBuyingSetupSteps(WebDriver driver, ProdUserData prodBuyer, ProdUserData prodSeller, ItemType item, int qty, UIChainAssert uiAssert) throws Exception{
		//new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signInFromHomeScreen(prodBuyer);

		if(UpdateDCS.enableDeveloperSettings())
			UpdateDCS.changeConfig("view item", "useUpdatedBestOfferFlow", true).saveConfigurations();

		AddItemResponseType addResp = new ProdAddItem(item, prodSeller.getUserName(), prodSeller.getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(driver).getSearchPageQueryComponent().createSearch(item.getItemID(), false);
		/*new ViewItemPageValidators.Use().uiAssertion(uiAssert).validate(driver)
			.setViewItemPageObject(new ViewItemPage(driver)).validateViewItemUIElements(item);*/
	}

	public static void executeListingSteps(WebDriver driver, ItemType item, boolean isABIN, boolean isAutoBO, boolean intlPostage){

		new SellAnItemPage(driver).getSellAnItemPageComponent()
		.enterTitleAndProceed(item)
		.selectCategory()
		.addCondition()
		.addPhotos()
		.addDescription();

		if(isAutoBO)
			new SellAnItemPage(driver).getSellAnItemPageComponent()
			.addPriceDetails(item, isABIN, true, true);
		else
			new SellAnItemPage(driver).getSellAnItemPageComponent()
			.addPriceDetails(item, isABIN, false, false);

		new SellAnItemPage(driver).getSellAnItemPageComponent()
		.addPostageDetails(item, intlPostage);

		if(item.getReturnPolicy().getReturnsAcceptedOption().equalsIgnoreCase("ReturnsAccepted"))
			new SellAnItemPage(driver).getSellAnItemPageComponent()
			.addPaymentDetails(item, true)
			.continueToFinishListing();
		else
			new SellAnItemPage(driver).getSellAnItemPageComponent()
			.addPaymentDetails(item, false)
			.continueToFinishListing();

		new SellAnItemPage(driver).getReviewPageComponent().clickListItButton();
		new SellAnItemPage(driver).getListingSuccessComponent().clickViewListedItem();
	}

	public static void executeRevisionSteps(WebDriver driver, ItemType item){

		new SellAnItemPage(driver).getSellAnItemPageComponent()
		.editTitle(item)
		.addDescription(item)
		.continueToFinishListing();
		new SellAnItemPage(driver).getReviewPageComponent().clickListItButton();
		new SellAnItemPage(driver).getListingSuccessComponent().clickViewListedItem();
	}

	public static void checkSortingOnSRP(WebDriver driver, UIChainAssert uiAssert, SearchResultsPage srp){
		srp.getSRPHeaderComponent().sortBy(Sort.HIGH_PRICE_POSTAGE);
		CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateSRPItemContents(View.LIST).validateSRPItemsSortedByHighestPrice();

		srp.getSRPHeaderComponent().sortBy(Sort.LOW_PRICE_POSTAGE);
		CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateSRPItemContents(View.LIST).validateSRPItemsSortedByLowestPrice();

		/*srp.getSRPHeaderComponent().sortBy(Sort.ENDING_SOON);
		CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateSRPItemContents(View.LIST).validateSRPItemsSortedByEndingSoon();

		srp.getSRPHeaderComponent().sortBy(Sort.NEAREST_FIRST);
		CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateSRPItemContents(View.LIST).validateSRPItemsSortedByNearestFirst();*/

		srp.getSRPHeaderComponent().sortBy(Sort.BESTMATCH);
	}

	public static void checkDisplayFormat(WebDriver driver, UIChainAssert uiAssert, SearchResultsPage srp, BuyingFormat format){
		srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).addBuyingFormat(format).saveRefinements();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp)
			.validateLockDisplayedForBuyingFormat(format)
			.validateItemInfoDisplayed(format);
	}

	public static void checkViewFormat(WebDriver driver, UIChainAssert uiAssert, SearchResultsPage srp, View viewType){
		srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).changeView(viewType).saveRefinements();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateSRPItemContents(viewType);
	}

	public static void checkPriceRange(WebDriver driver, UIChainAssert uiAssert, SearchResultsPage srp, Double min, Double max){
		srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).addPriceRange(min, max).saveRefinements();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validatePriceWithinRange(min, max);
		srp.getSRPHeaderComponent().getRefinementPanel(true).resetRefinements().saveRefinements();
	}

	public static void checkLocationFilters(WebDriver driver, UIChainAssert uiAssert, SearchResultsPage srp, ItemLocation loc){
		srp.getSRPHeaderComponent().getRefinementPanel(true).addItemLocationOptions(loc).saveRefinements();
		new SRPValidators.Use().uiAssertion(uiAssert).validate(driver).setSearchResultsPage(srp).validateItemLocationLockDisplayed(loc);
	}

	public static void searchAndGetToSearchlandingPage(WebDriver driver, UIChainAssert uiAssert, String kw, boolean sellerSrch, boolean follow){
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(driver).getSearchPageQueryComponent().createSearch(kw, sellerSrch);
		if(follow){ 
			if(!sellerSrch)
				new SearchResultsPage(driver).getSRPHeaderComponent().clickToFollowSearch("NATIVEAPP_"+kw, true, true);
			else{
				new SearchResultsPage(driver).getSRPResultsComponent().selectFirstItemFromResults();
				new ViewItemPage(driver).getViewItemPageComponent().viewSellerDetails();
				new UserProfilePageValidators.Use().uiAssertion(uiAssert).validate(driver).setUserProfilePage(new UserProfilePage(driver))
				.validateUserDetails()
				.validateDSRifPresent()
				.validateRecentFeedbackRatings();
				new UserProfilePage(driver).getUserProfileActionComponent().followThisUser();
			}
		}
		/*new HomeScreen(driver).getHomeScreenHeaderComponent().goToHome();*/
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.HOME).openMenuOption();
	}

	public static void checkFeedbackAsandType(WebDriver driver, UIChainAssert uiAssert, UserType type, Feedback fd)
	{
		if(type.equals(UserType.BUYER))
			new FeedbackDetailsPage(driver).getFeedbackPageActionsComponent().viewFeedbackAsBuyer();
		else
			new FeedbackDetailsPage(driver).getFeedbackPageActionsComponent().viewFeedbackAsSeller();

		new FeedbackDetailsPage(driver).getFeedbackPageActionsComponent().showFeedbacksOfType(fd);
		new FeedbackDetailsPageValidators.Use().uiAssertion(uiAssert).validate(driver).setFeedbackDetailsPage(new FeedbackDetailsPage(driver))
		.validateCurrentFeedbackSelection(fd)
		.validateFeedbackContent();
	}

	public static void checkFeedbackDetailsForType(WebDriver driver, UIChainAssert uiAssert, Feedback fd){
		new UserProfilePage(driver).getUserProfileActionComponent().showOnlyFeedbacksOfType(fd);
		new FeedbackDetailsPageValidators.Use().uiAssertion(uiAssert).validate(driver).setFeedbackDetailsPage(new FeedbackDetailsPage(driver))
		.validateCurrentFeedbackSelection(fd);
		new CustomTouchUtils().deviceBack(driver);
	}

	public static ItemType getItemForXO(WebDriver driver, UIChainAssert uiAssert, ItemType item, ProdUserData prodSeller, ProdUserData prodBuyer, BidActionCodeType action) throws APIException{
		AddItemResponseType addResp = new ProdAddItem(item, prodSeller.getUserName(), prodSeller.getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		if(new PurchaseAPI(item, prodBuyer.getUserName(), prodBuyer.getPassword()).placePurchase(action))
			return item;
		else{
			uiAssert.generic().fail("Issues performing Purchase for Item ["+item.getItemID()+"] via API. Purchase-Type: "+action.toString());
			return null;
		}
	}

	public static void searchItemWithReviewsAndRatings(WebDriver driver){
		boolean flag = false;
		String[] options = {	ItemsToSearch.Member.AU_BOPIS_THEGOODGUYSAU.getMemberName(),
				ItemsToSearch.Member.AU_PUDO_FUTUONLINE.getMemberName(),
				ItemsToSearch.Member.AU_BINGLEE.getMemberName()
		};
		for (String option : options) {
			SearchFlows.searchAndSelectFirstItem(option, true);
			if(new WebActions(driver).element().present().now(new ViewItemPage(driver).getViewItemPageComponent().ITM_RVWSTARS)){
				flag = true;
				break;
			}
		}

		if(!flag)
			new GenericAssert().fail("Could not find an Item with Ratings & Reviews!!!");
	}

	public static void searchCNCAndGoToSRP(WebDriver driver, UIChainAssert uiAssert, String srchKey){
		new HomeScreen(driver).getHomeScreenHeaderComponent().goToHome();
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(driver).getSearchPageQueryComponent()
		.createSearch(srchKey, true);
		
		
		new SearchResultsPage(driver).getSRPHeaderComponent().getRefinementPanel(true)
		.addDeliveryOptions(DeliveryOptions.CLICK_AND_COLLECT).saveRefinements();
	}

	public static List<String> getItemsToXOviaCart(WebDriver driver, ItemType item, ProdUserData prodSeller, ProdUserData prodBuyer) throws APIException{
		List<String> itemIDs = new ArrayList<>();
		for(int i=1; i<=2; i++){
			if(i==2) item = TestDataUtils.getCBT_Item(item);
			AddItemResponseType addResp = new ProdAddItem(item, prodSeller.getUserName(), prodSeller.getPassword()).listItem(); 
			item = new ProdAddItem(addResp).getItem();
			itemIDs.add(item.getItemID());
		}
		return itemIDs;
	}

	public CombinedSteps addThisItemToCart(WebDriver driver, UIChainAssert uiAssert, String srchKey){
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(driver).getSearchPageQueryComponent().createSearch(srchKey, false);
		new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickATCButton();
		new HomeScreen(driver).getHomeScreenHeaderComponent().goToHome();
		return new CombinedSteps();
	}

	public static ItemType getItemForOfferReview(WebDriver driver, ItemType item, ProdUserData prodSeller, ProdUserData prodBuyer) throws APIException{
		AddItemResponseType addResp = new ProdAddItem(item, prodSeller.getUserName(), prodSeller.getPassword()).listItem(); 
		item = new ProdAddItem(addResp).getItem();
		new PurchaseAPI(item, prodBuyer.getUserName(), prodBuyer.getPassword()).placePurchase(BidActionCodeType.OFFER);

		return item;
	}

	public static void watchContainerContentChecks(WebDriver driver, UIChainAssert uiAssert){
		new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(new HamburgerMenuPanel(driver)).validateWatchingItemSpecifications();
		/*new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getWatchingComponent().clickEditTab().deleteTwoItems().clickSortLink();
		new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(new HamburgerMenuPanel(driver)).validateSortOptions();
		new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getWatchingComponent().clickCancelSort();*/
	}

	public static void watchContainerSortChecks(String container, Sort type, SearchResultsPage srp, WebDriver driver, UIChainAssert uiAssert){
		HamburgerMenuPanel menu = new HamburgerMenuPanel(driver);

		if(container.contentEquals("ACTIVE")){
			if(menu.getHamburgerMenuMyEbayComponent().getWatchingComponent().clickActiveTab()){
				new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(new HamburgerMenuPanel(driver)).validateCategoryCells();
				srp.getSRPHeaderComponent().sortBy(type);
				switch (type) {
				case HIGH_PRICE_POSTAGE:
					new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsSortedByHighestPrice();
					break;
				case LOW_PRICE_POSTAGE:
					new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsSortedByLowestPrice();
					break;
				case ENDING_SOON:
					new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsSortedByEndingSoon();
					break;
				case RECENTLY_ADDED:
					menu.getHamburgerMenuMyEbayComponent().getWatchingComponent().WatchAnItem();
					new HamburgerMenuFlows(driver, HamburgerMenuOptions.WATCHING).openMenuOption();
					new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsRecentlyAddedfilter();
					break;
				default:
					break;
				}
			}
			else new ReportLogger().logRedStep("No ITEMS in WATCHING > ACTIVE Container to validate SORTING");
		}else{
			if(menu.getHamburgerMenuMyEbayComponent().getWatchingComponent().clickEndedTab()){
				new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(new HamburgerMenuPanel(driver)).validateCategoryCells();
				srp.getSRPHeaderComponent().sortBy(type);
				switch (type) {
				case HIGH_PRICE_POSTAGE:
					new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsSortedByHighestPrice();
					break;
				case LOW_PRICE_POSTAGE:
					new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsSortedByLowestPrice();
					break;
				default:
					break;
				}
			}
			else new ReportLogger().logRedStep("No ITEMS in WATCHING > ENDED Container to validate SORTING");
		}
	}

	public static void bidsOffersContainerSortChecks(Sort type, SearchResultsPage srp, WebDriver driver, UIChainAssert uiAssert){
		HamburgerMenuPanel menu = new HamburgerMenuPanel(driver);
		menu.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().clickonSort();
		new BidsOffersValidators.Use().uiAssertion(uiAssert).validate(driver).setBidsOffersValidators(menu).validateSortOptions();
		menu.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().selectSortOption(type);
		if(new WebActions(driver).element().present().now(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS)){
			switch (type) {
			case HIGH_PRICE_POSTAGE:
				new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsSortedByHighestPrice();
				break;
			case LOW_PRICE_POSTAGE:
				new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsSortedByLowestPrice();
				break;
			case ENDING_SOON:
				new WatchingValidators.Use().uiAssertion(uiAssert).validate(driver).setWatchingValidators(menu).validateWatchedItemsSortedByEndingSoon();
				break;
			default:
				break;
			}
		}else
			new ReportLogger().logRedStep("No items in container to validate Sorting");
	}

	public static void sellContainerChecks(SellContainer container, WebDriver driver, UIChainAssert uiAssert){
		SellingPage sellPage = new SellingPage(driver);
		boolean flag = false;
		switch (container) {
		case ACTIVE:
			sellPage.getSellingPageComponent().goToActiveContainer();
			if(new WebActions(driver).element().present().now(sellPage.getSellingContainersComponent().ITEM_CONTAINER) && new WebActions(driver).element().get().allWebElementsWithSameLocator(sellPage.getSellingContainersComponent().ITEM_CONTAINER).size() > 0){
				new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(sellPage).validateSellActiveContainer();
				sellPage.getSellingContainersComponent().getActiveContainer().filterContainerItems(SellContainerFilters.ACTIVE_AUCTIONS);
				new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(sellPage).validateFilterHeaderText(SellContainerFilters.ACTIVE_AUCTIONS)
				.validateBidCount(true);
				sellPage.getSellingContainersComponent().getActiveContainer().filterContainerItems(SellContainerFilters.ACTIVE_FIXEDPRICE);
				new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(sellPage).validateFilterHeaderText(SellContainerFilters.ACTIVE_FIXEDPRICE)
				.validateBidCount(false);
				sellPage.getSellingContainersComponent().getActiveContainer().filterContainerItems(SellContainerFilters.ACTIVE_NEWOFFERS);
				new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(sellPage).validateFilterHeaderText(SellContainerFilters.ACTIVE_NEWOFFERS)
				.validateBidCount(false);
			}
			else flag = true;
			break;
		case SOLD:
			sellPage.getSellingPageComponent().goToSoldContainer();
			if(new WebActions(driver).element().present().now(sellPage.getSellingContainersComponent().ITEM_CONTAINER) && new WebActions(driver).element().get().allWebElementsWithSameLocator(sellPage.getSellingContainersComponent().ITEM_CONTAINER).size() > 0){
				new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(sellPage).validateSellSoldContainer();
				sellPage.getSellingContainersComponent().getSoldContainer().filterContainerItems(SellContainerFilters.SOLD_AWAITINGPAYMENT);
				new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(sellPage).validateFilterHeaderText(SellContainerFilters.SOLD_AWAITINGPAYMENT);
				sellPage.getSellingContainersComponent().getSoldContainer().filterContainerItems(SellContainerFilters.SOLD_PAID_SENDNOW);
				new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(sellPage).validateFilterHeaderText(SellContainerFilters.SOLD_PAID_SENDNOW);
				sellPage.getSellingContainersComponent().getSoldContainer().filterContainerItems(SellContainerFilters.ALL);
				sellPage.getSellingContainersComponent().getSoldContainer().deleteItem(false);
			}
			else flag = true;
			break;
		case UNSOLD:
			sellPage.getSellingPageComponent().goToUnsoldContainer();
			if(new WebActions(driver).element().present().now(sellPage.getSellingContainersComponent().ITEM_CONTAINER) && new WebActions(driver).element().get().allWebElementsWithSameLocator(sellPage.getSellingContainersComponent().ITEM_CONTAINER).size() > 0){
				new SellingContainerValidators.Use().uiAssertion(uiAssert).validate(driver).setSellingPage(sellPage).validateSellUnsoldContainer();
				sellPage.getSellingContainersComponent().getUnsoldContainer().deleteItem(true);
			}
			else flag = true;
			break;
		default:
			break;
		}
		if(flag)
			new ReportLogger().logRedStep("No items in ["+container.name()+"] container to validate...");
		new HamburgerMenuFlows(driver, HamburgerMenuOptions.SELLING).openMenuOption();
	}

	public static Map<String, String> createFollowedData(WebDriver driver){
		Map<String, String> followedData = new HashMap<>();
		/*Creating Followed Search*/
		SearchFlows.searchFor(ItemsToSearch.KeyWord.CAMERA.getKeyWord(), false);
		new SearchResultsPage(driver).getSRPHeaderComponent().clickToFollowSearch("FOLLOWED_CAMERA", false, true);
		followedData.put("SRCH", "FOLLOWED_CAMERA");

		/*Creating Followed Member*/
		new HomeScreen(driver).getHomeScreenHeaderComponent().goToHome();
		String memName = new String();
		switch (TestParams.CommonTestEnv.site.get()) {
		case "AU": memName = ItemsToSearch.Member.AU_BINGLEE.getMemberName();
			break;
		case "SG": memName = ItemsToSearch.Member.SG_SELLER.getMemberName();
			break;
		case "MY": memName = ItemsToSearch.Member.MY_SELLER.getMemberName();
			break;
		case "PH": memName = ItemsToSearch.Member.PH_SELLER.getMemberName();
			break;
		default:
			break;
		}
		SearchFlows.searchAndSelectFirstItem(memName, true);
		new ViewItemPage(driver).getViewItemPageComponent().viewSellerDetails();
		new UserProfilePage(driver).getUserProfileActionComponent().followThisUser();
		followedData.put("MEM", memName);

		/*Creating Followed Collection - Need to add*/

		return followedData;
	}

}
