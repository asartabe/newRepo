package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SRPResultsComponent;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SRPResultsComponentLocators extends BasePageObject<SRPResultsComponent>{

	protected SRPResultsComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By SRCH_RESULTS = getLocator("SRCH_RESULTS");
		public final By SRP_ITM_IMG = getLocator("SRP_ITM_IMG");
		public final By SRP_ITM_TITLE = getLocator("SRP_ITM_TITLE");
		public final By SRP_ITM_PRICE = getLocator("SRP_ITM_PRICE");
		public final By SRP_ITM_POSTAGEPRICE = getLocator("SRP_ITM_POSTAGEPRICE");
		public final By SRP_ITM_EDD = getLocator("SRP_ITM_EDD");
		public final By SRP_ITM_BIDCOUNT = getLocator("SRP_ITM_BIDCOUNT");
		public final By SRP_ITM_TIMELEFT = getLocator("SRP_ITM_TIMELEFT");
		public final By SRP_ITM_ORBUYITNOW = getLocator("SRP_ITM_ORBUYITNOW");
		public final By SRP_ITM_PROMOTED = getLocator("SRP_ITM_PROMOTED");
		public final By SRP_ITM_MSKU_MORE = getLocator("SRP_ITM_MSKU_MORE");
		public final By SRP_ITM_ORBESTOFFER = getLocator("SRP_ITM_ORBESTOFFER");
		public final By SRP_ITM_DISTANCE = getLocator("SRP_ITM_DISTANCE");
		
		public final By PROMO_LABEL =getLocator("PROMO_LABEL");
		public final By PROMO_LOGO=getLocator("PROMO_LOGO");
		public final By PROMO_TEXT=getLocator("PROMO_TEXT");
		public final By PROMO_IMAGE=getLocator("PROMO_IMAGE");
		
		public final By SALES_EVENTS_TITLE=getLocator("SALES_EVENTS_TITLE");
	
	public final By SRP_BEST_SELLING_HDR = getLocator("SRP_BEST_SELLING_HDR");
	public final By SRP_BEST_SELLING_ITMS = getLocator("SRP_BEST_SELLING_ITMS");
	
	public final By RELATED_SEARCHES_HDR = getLocator("RELATED_SEARCHES_HDR");
	public final By RELATED_SRCHS_NAMES = getLocator("RELATED_SRCHS_NAMES");
		public final By RELATED_SRCHS_NAMEVAL = getLocator("RELATED_SRCHS_NAMEVAL");
		
		public final By EGD_TOGGLE=getLocator("EGD_TOGGLE");
		public final By EGD_TEXT=getLocator("EGD_TEXT");
		
		
	public final By SME_PANEL = getLocator("SME_PANEL");
	public final By SME_PROMO_TITLE = getLocator("SME_PROMO_TITLE");
	public final By SME_PROMO_SUBTITLE = getLocator("SME_PROMO_SUBTITLE");
	
	public final By WATCH_ACTION_BTN = getLocator("WATCH_ACTION_BTN");
		public final By WATCH_LNK = getLocator("WATCH_LNK");
	
	@Override
	  protected void setLocators() {
	    
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_RESULTS",By.id("com.ebay.mobile:id/cell_collection_item"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_IMG",By.id("com.ebay.mobile:id/image"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_TITLE",By.id("com.ebay.mobile:id/textview_item_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_PRICE",By.xpath("//*[contains(@resource-id, 'textview_item_price')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_POSTAGEPRICE",By.id("com.ebay.mobile:id/shipping_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_EDD",By.id("com.ebay.mobile:id/estimated_delivery_text"));
			/*FOR AUCTION ITEMS*/
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_BIDCOUNT",By.xpath("//android.widget.TextView[contains(@content-desc, 'bids') or contains(@resource-id, 'bid_count_text')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_TIMELEFT",
					(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU")) 
					? By.xpath("//android.widget.TextView[contains(@content-desc, 'days') or contains(@content-desc, 'hours') or contains(@content-desc, 'minutes') or contains(@content-desc, 'seconds')]")
					: By.id("com.ebay.mobile:id/time_left_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_ORBUYITNOW",By.id("com.ebay.mobile:id/bin_label"));
			/*FOR PROMOTED ITEMS*/
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_PROMOTED",By.id("com.ebay.mobile:id/promoted_label"));
			/*FOR MSKU ITEMS*/
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_MSKU_MORE",By.id("com.ebay.mobile:id/more_options_label"));
			/*FOR BEST OFFER ITEMS*/
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_ORBESTOFFER",By.id("com.ebay.mobile:id/obo_label"));
			/*DISTANCE*/
			setLocator(LocatorType.ANDROID_LOCATOR, "SRP_ITM_DISTANCE",By.id("com.ebay.mobile:id/distance_text"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SRP_BEST_SELLING_HDR",By.xpath("//android.widget.TextView[@text='Best Selling']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SRP_BEST_SELLING_ITMS",By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout"));	//com.ebay.mobile:id/recyclerview_items
		
		setLocator(LocatorType.ANDROID_LOCATOR, "RELATED_SEARCHES_HDR",By.xpath("//android.widget.TextView[@text='Related searches']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RELATED_SRCHS_NAMES",By.id("com.ebay.mobile:id/container_items"));
			setLocator(LocatorType.ANDROID_LOCATOR, "RELATED_SRCHS_NAMEVAL",By.id("com.ebay.mobile:id/textview_item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SME_PANEL",By.id("com.ebay.mobile:id/seller_offer_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SME_PROMO_TITLE",By.id("com.ebay.mobile:id/seller_offer_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SME_PROMO_SUBTITLE",By.id("com.ebay.mobile:id/seller_offer_subtitle"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "BRWS_LNK_TITLE",By.id("com.ebay.mobile:id/browse_link_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BRWS_LNK_SUBTITLE",By.id("com.ebay.mobile:id/browse_link_subtitle"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BRWS_LNK_IMG",By.id("com.ebay.mobile:id/browse_link_image"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SPONSORED_TXT",By.id("com.ebay.mobile:id/promoted_label"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "WATCH_ACTION_BTN",By.id("com.ebay.mobile:id/watch_action"));
			setLocator(LocatorType.ANDROID_LOCATOR, "WATCH_LNK",By.xpath("//android.widget.TextView[@text='Watch']"));
		
			setLocator(LocatorType.ANDROID_LOCATOR, "PROMO_LABEL",By.id("com.ebay.mobile:id/promoted_label"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PROMO_LOGO",By.id("com.ebay.mobile:id/vp_logo"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PROMO_TEXT",By.id("com.ebay.mobile:id/vertical_promotion_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PROMO_IMAGE",By.id("com.ebay.mobile:id/vp_image"));
			
			setLocator(LocatorType.ANDROID_LOCATOR, "SALES_EVENTS_TITLE", By.id("om.ebay.mobile:id/title"));
			
			setLocator(LocatorType.ANDROID_LOCATOR, "EGD_TOGGLE", By.id("com.ebay.mobile:id/button_toggle"));
			setLocator(LocatorType.ANDROID_LOCATOR, "EGD_TEXT", By.xpath("//android.widget.TextView[contains(@content-desc, 'Guaranteed by']"));
	}
	
}
