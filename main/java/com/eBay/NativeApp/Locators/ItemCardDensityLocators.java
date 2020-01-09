package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SRPResultsComponent.ICDElements;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class ItemCardDensityLocators extends BasePageObject<ICDElements>{

	protected ItemCardDensityLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By SRCH_RESULT_TILES = getLocator("SRCH_RESULT_TILES");
		public final By ICD_MSKU_PRICERANGE = getLocator("ICD_MSKU_PRICERANGE");
		public final By ICD_TRENDING_LBL = getLocator("ICD_TRENDING_LBL");
		public final By ICD_POST_FNF = getLocator("ICD_POST_FNF");
		public final By ICD_POST_ESTDEL = getLocator("ICD_POST_ESTDEL");
		public final By ICD_PROD_RVWS = getLocator("ICD_PROD_RVWS");
			public final By ICD_PROD_RVW_STARS = getLocator("ICD_PROD_RVW_STARS");
			public final By ICD_PROD_RVW_COUNT = getLocator("ICD_PROD_RVW_COUNT");
		public final By ICD_POST_TXT_CONTAIN_FROM = getLocator("ICD_POST_TXT_CONTAIN_FROM");
		public final By ICD_STP_LBL = getLocator("ICD_STP_LBL");
		public final By ICD_CNC_LBL = getLocator("ICD_CNC_LBL");
	
	
	@Override
	  protected void setLocators() {
	    
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_RESULT_TILES",By.id("com.ebay.mobile:id/cell_collection_item"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ICD_MSKU_PRICERANGE",By.id("com.ebay.mobile:id/textview_item_price_range"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ICD_TRENDING_LBL",By.id("com.ebay.mobile:id/trending_price_label"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ICD_POST_FNF",By.xpath("//android.widget.TextView[contains(@text, 'FAST')][contains(@text, 'FREE')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ICD_POST_ESTDEL",By.id("com.ebay.mobile:id/estimated_delivery_text"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ICD_PROD_RVWS",By.id("com.ebay.mobile:id/product_review_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ICD_PROD_RVW_STARS",By.id("com.ebay.mobile:id/view_stars"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ICD_PROD_RVW_COUNT",By.id("com.ebay.mobile:id/reviews_count"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ICD_POST_TXT_CONTAIN_FROM",By.id("com.ebay.mobile:id/shipping_text"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ICD_STP_LBL",By.id("com.ebay.mobile:id/strikethrough_text"));
		setLocator(LocatorType.ANDROID_LOCATOR, "ICD_CNC_LBL",By.xpath("//android.widget.TextView[contains(@text, 'Click')][contains(@text, 'Collect')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
	
	}
	
}
