package com.eBay.NativeApp.Flows;

import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchPage;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class SearchFlows {
	
	public static void searchFor(String kw, boolean sellerSrch){
		new HomeScreen(UIListener.uiDriver.get()).getHomeScreenHeaderComponent().clickInSearch();
		new SearchPage(UIListener.uiDriver.get()).getSearchPageQueryComponent().createSearch(kw, sellerSrch);
	}
	
	public static void searchAndSelectFirstItem(String kw, boolean sellerSrch){
		searchFor(kw, sellerSrch);
		new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().selectFirstItemFromResults();
	}
	
	public static void searchAndApplyCNC(String kw, boolean sellerSrch){
		new HomeScreen(UIListener.uiDriver.get()).getHomeScreenHeaderComponent().goToHome();
		searchFor(kw, sellerSrch);
		
	}
	
}
