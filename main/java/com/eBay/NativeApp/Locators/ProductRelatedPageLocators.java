package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.ProductRelatedPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class ProductRelatedPageLocators extends BasePageObject<ProductRelatedPageComponent>{

	protected ProductRelatedPageLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public final By PRP_PRODUCT_RANK= getLocator("PRP_PRODUCT_RANK");
	
	public final By PRP_MINI_IMG = getLocator("PRP_MINI_IMG");
	public final By PRP_MINI_TITLE = getLocator("PRP_MINI_TITLE");
	
	public final By THEME_LAYOUT = getLocator("THEME_LAYOUT");
		public final By THEME_TABS = getLocator("THEME_TABS");
			public final By THEME_TAB_HDR = getLocator("THEME_TAB_HDR");
			public final By THEME_TAB_PRICE = getLocator("THEME_TAB_PRICE");
	
	public final By PRP_CHANGE_OPTIONS_BTN = getLocator("PRP_CHANGE_OPTIONS_BTN");
		public final By ASPECTS_DONE = getLocator("ASPECTS_DONE");
		public final By ASPECTS_LIST = getLocator("ASPECTS_LIST");
			public final By ASPECT_NAME = getLocator("ASPECT_NAME");
			public final By ASPECT_CURRENT_VALUE = getLocator("ASPECT_CURRENT_VALUE");
	
	public final By PRP_MINI_RATING_BAR = getLocator("PRP_MINI_RATING_BAR");
	public final By PRP_BIG_IMG = getLocator("PRP_BIG_IMG");
	public final By PRP_ITM_PRICE = getLocator("PRP_ITM_PRICE");
	public final By PRP_ITM_POSTAGE_PRICE = getLocator("PRP_ITM_POSTAGE_PRICE");
	public final By PRP_ALL_LISTINGS = getLocator("PRP_ALL_LISTINGS");
	public final By PRP_ABOUT_PRODUCT = getLocator("PRP_ABOUT_PRODUCT");
	public final By PRP_RATING_REVIEWS = getLocator("PRP_RATING_REVIEWS");
	public final By PRP_RELEVANT_REVIEWS = getLocator("PRP_RELEVANT_REVIEWS");
	public final By PRP_ALL_BUTTONS = getLocator("PRP_ALL_BUTTONS");
	public final By PRP_BTN_CTA1 = getLocator("PRP_BTN_CTA1");
	public final By PRP_BTN_CTA2 = getLocator("PRP_BTN_CTA2");
	
	public final By PRP_BESTSELLING_CAT= getLocator("PRP_BESTSELLING_CAT");
	
	public final By PRP_SAVEON = getLocator("PRP_SAVEON");
	
	public final By PRP_THEME_TAB = getLocator("PRP_THEME_TAB");
	
	public final By PRP_QnA_SECTION = getLocator("PRP_QnA_SECTION");
	public final By PRP_QnA_POSTED_QUES = getLocator("PRP_QnA_POSTED_QUES");
	public final By PRP_QnA_ALL_ANS = getLocator("PRP_QnA_ALL_ANS");
	
	public final By SPONSORED_ITEMS = getLocator("SPONSORED_ITEMS");
	
	public final By SIMILAR_PRODUCTS = getLocator("SIMILAR_PRODUCTS");
	public final By SIMILAR_PROD_1 = getLocator("SIMILAR_PROD_1");
	public final By SIMILAR_PROD_2 = getLocator("SIMILAR_PROD_2");
	
	public final By BPP_ICON= getLocator("BPP_ICON");
	public final By BPP_TEXT= getLocator("BPP_TEXT");
	public final By BPP_TITLE= getLocator("BPP_TITLE");
	public final By BPP_CLOSE= getLocator("BPP_CLOSE");
	
	public final By PRP_MORE_OPTIONS = getLocator("PRP_MORE_OPTIONS");
	public final By SHARE_OPTN = getLocator("SHARE_OPTN");
	
	
	
	@Override
	protected void setLocators() {
		
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_MINI_IMG",By.id("com.ebay.mobile:id/imageview_item_image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_MINI_TITLE",By.id("com.ebay.mobile:id/textview_item_title"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_CHANGE_OPTIONS_BTN",By.id("com.ebay.mobile:id/button_change_aspects"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ASPECTS_DONE",By.id("com.ebay.mobile:id/button_done"));
			setLocator(LocatorType.ANDROID_LOCATOR, "ASPECTS_LIST",By.id("com.ebay.mobile:id/list"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ASPECT_NAME",By.id("com.ebay.mobile:id/aspect_name"));
				setLocator(LocatorType.ANDROID_LOCATOR, "ASPECT_CURRENT_VALUE",By.id("com.ebay.mobile:id/aspect_current_value"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_MINI_RATING_BAR",By.id("com.ebay.mobile:id/rating_bar"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_BIG_IMG",By.id("com.ebay.mobile:id/prp_mtp_image"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ITM_PRICE",By.id("com.ebay.mobile:id/price"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ITM_POSTAGE_PRICE",By.id("com.ebay.mobile:id/shipping"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ALL_LISTINGS",By.xpath("//android.widget.TextView[@text='All listings for this product']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ABOUT_PRODUCT",By.xpath("//android.widget.TextView[@text='About this product']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_RATING_REVIEWS",By.xpath("//android.widget.TextView[@text='Ratings and reviews']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_RELEVANT_REVIEWS",By.xpath("//android.widget.TextView[@text='Most relevant reviews']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_THEME_TAB",By.xpath("//android.support.v7.app.ActionBar.Tab/android.widget.LinearLayout"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_ALL_BUTTONS",By.id("//android.widget.Button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_BTN_CTA1",By.id("com.ebay.mobile:id/prp_primary_button_0"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_BTN_CTA2",By.id("com.ebay.mobile:id/prp_secondary_button_0"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_QnA_SECTION",By.id("com.ebay.mobile:id/label_ask_question"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRP_QnA_POSTED_QUES",By.id("com.ebay.mobile:id/question_text"));
			setLocator(LocatorType.ANDROID_LOCATOR, "PRP_QnA_ALL_ANS",By.id("com.ebay.mobile:id/button_all_answers"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SPONSORED_ITEMS",By.xpath("//android.widget.TextView[contains(@text, 'sponsored items')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SIMILAR_PRODUCTS",By.xpath("//android.widget.TextView[contains(@text, 'similar products')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SIMILAR_PROD_1",By.id("com.ebay.mobile:id/product_left"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SIMILAR_PROD_2",By.id("com.ebay.mobile:id/product_right"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "THEME_LAYOUT",By.id("com.ebay.mobile:id/container_tablayout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "THEME_TABS",By.xpath("//android.support.v7.app.ActionBar.Tab"));
				setLocator(LocatorType.ANDROID_LOCATOR, "THEME_TAB_HDR",By.id("com.ebay.mobile:id/textview_header_title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "THEME_TAB_PRICE",By.id("com.ebay.mobile:id/textview_header_subtitle"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_PRODUCT_RANK",By.id("com.ebay.mobile:id/product_rank"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_BESTSELLING_CAT",By.xpath("//android.widget.TextView[contains(@text,'Best-selling')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_SAVEON",By.xpath("//android.widget.TextView[contains(@text,'Save on')]"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "BPP_ICON",By.id("com.ebay.mobile:id/prp_bpp_icon"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BPP_TEXT",By.id("com.ebay.mobile:id/prp_bpp_text"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BPP_TITLE",By.xpath("//android.widget.TextView[contains(@text,'Best Price Guarantee')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "BPP_CLOSE",By.id("com.ebay.mobile:id/home"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "PRP_MORE_OPTIONS",By.xpath("//android.widget.ImageView[@content-desc= 'More options']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SHARE_OPTN",By.id("com.ebay.mobile:id/title"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
	}
	
	
}
