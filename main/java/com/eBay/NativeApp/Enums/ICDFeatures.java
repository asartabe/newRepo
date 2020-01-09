package com.eBay.NativeApp.Enums;

import org.openqa.selenium.By;

import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public enum ICDFeatures {
	
	MSKU_PRICERANGE("Price Range for MSKU Items", new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().getICDElements().ICD_MSKU_PRICERANGE),
	TRENDING("Trending Price details", new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().getICDElements().ICD_TRENDING_LBL),
	FAST_N_FREE("Fast N Free Label", new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().getICDElements().ICD_POST_FNF),
	PROD_RATINGS("Product Ratings & Reviews", new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().getICDElements().ICD_PROD_RVWS),
	CBT_POSTAGE("Item Postage from CBT Location", new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().getICDElements().ICD_POST_TXT_CONTAIN_FROM),
	/*ITM_CONDITION,*/
	STP_DETAILS("Strike Through Price details", new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().getICDElements().ICD_STP_LBL),
	CLICK_N_COLLECT("Click & Collect Label", new SearchResultsPage(UIListener.uiDriver.get()).getSRPResultsComponent().getICDElements().ICD_CNC_LBL);
	
	private String s = new String();
	private By loc;
	ICDFeatures(String val, By by){
		s = val;
		loc = by;
	}
	
	public String getDetails(){
		return s;
	}
	
	public By getLocator(){
		return loc;
	}
	
}
