package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SellingPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SellingPageComponentLocators extends BasePageObject<SellingPageComponent>{

	protected SellingPageComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By LIST_AN_ITEM_BTN = getLocator("LIST_AN_ITEM_BTN");
	
	public final By UNSIGNED_REG_BTN = getLocator("UNSIGNED_REG_BTN");
	public final By UNSIGNED_SIGNIN_BTN = getLocator("UNSIGNED_SIGNIN_BTN");
	public final By UNSIGNED_HOW_IT_WORKS = getLocator("UNSIGNED_HOW_IT_WORKS");
	public final By UNSIGNED_TIPS_ALL = getLocator("UNSIGNED_TIPS_ALL");
	public final By UNSIGNED_TIP1 = getLocator("UNSIGNED_TIP1");
	public final By UNSIGNED_TIP2 = getLocator("UNSIGNED_TIP2");
	public final By UNSIGNED_TIP3 = getLocator("UNSIGNED_TIP3");
		public final By UNSIGNED_TIP_IMG = getLocator("UNSIGNED_TIP_IMG");
		public final By UNSIGNED_TIP_DESC = getLocator("UNSIGNED_TIP_DESC");
	public final By UNSIGNED_LEARN_MORE = getLocator("UNSIGNED_LEARN_MORE");
	
	public final By ACTIVE_LNK = getLocator("ACTIVE_LNK");
	public final By SOLD_LNK = getLocator("SOLD_LNK");
	public final By UNSOLD_LNK = getLocator("UNSOLD_LNK");
	public final By TOTAL_DAY_TEXT = getLocator("TOTAL_DAY_TEXT");
	
	public final By SCHEDULED_ITEMS_LNK = getLocator("SCHEDULED_ITEMS_LNK");
	
	public final By SELL_NOTIF_ROWS = getLocator("SELL_NOTIF_ROWS");
		public final By SELL_NOTIF_BADGE = getLocator("SELL_NOTIF_BADGE");
		public final By SELL_NOTIF_TITLE = getLocator("SELL_NOTIF_TITLE");
	
	public final By DRAFTS_TITLE = getLocator("DRAFTS_TITLE");
	public final By DRAFTS_SEE_ALL = getLocator("DRAFTS_SEE_ALL");
	public final By DRAFTS_TILES = getLocator("DRAFTS_TILES");
		public final By DRAFTS_ITM_IMG = getLocator("DRAFTS_ITM_IMG");
		public final By DRAFTS_ITM_TITLE = getLocator("DRAFTS_ITM_TITLE");
		public final By DRAFTS_ITM_DATE = getLocator("DRAFTS_ITM_DATE");
	
	@Override
	  protected void setLocators() {
	    
		setLocator(LocatorType.ANDROID_LOCATOR, "LIST_AN_ITEM_BTN",By.id("com.ebay.mobile:id/sell_something_button"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "ACTIVE_LNK",By.id("com.ebay.mobile:id/selling_overview_text_active"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "SOLD_LNK",By.id("com.ebay.mobile:id/selling_overview_text_sold"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSOLD_LNK",By.id("com.ebay.mobile:id/selling_overview_text_unsold"));	
		setLocator(LocatorType.ANDROID_LOCATOR, "TOTAL_DAY_TEXT",By.id("com.ebay.mobile:id/selling_overview_number_totalmetric"));	
	
		setLocator(LocatorType.ANDROID_LOCATOR, "DRAFTS_TITLE",By.id("com.ebay.mobile:id/textview_drafts"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DRAFTS_SEE_ALL",By.id("com.ebay.mobile:id/button_all_drafts"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DRAFTS_TILES",By.id("com.ebay.mobile:id/carousel_card_view"));
			setLocator(LocatorType.ANDROID_LOCATOR, "DRAFTS_ITM_IMG",By.id("com.ebay.mobile:id/item_image"));
			setLocator(LocatorType.ANDROID_LOCATOR, "DRAFTS_ITM_TITLE",By.id("com.ebay.mobile:id/item_title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "DRAFTS_ITM_DATE",By.id("com.ebay.mobile:id/item_date"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SCHEDULED_ITEMS_LNK",By.xpath("//android.widget.TextView[contains(@text, 'Scheduled')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "SELL_NOTIF_ROWS",By.xpath("//android.widget.FrameLayout[contains(@resource-id,'selling_overview_cell_row')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SELL_NOTIF_BADGE",By.xpath("//android.widget.TextView[contains(@resource-id,'_badge')]"));
			setLocator(LocatorType.ANDROID_LOCATOR, "SELL_NOTIF_TITLE",By.xpath("//android.widget.TextView[contains(@resource-id,'_text')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_REG_BTN",By.id("com.ebay.mobile:id/button_register"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_SIGNIN_BTN",By.id("com.ebay.mobile:id/button_sign_in"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_HOW_IT_WORKS",By.xpath("//android.widget.TextView[@text='How it works']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_TIPS_ALL",By.xpath("//*[contains(@resource-id, 'com.ebay.mobile:id/inspiration_step')]"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_TIP1",By.id("com.ebay.mobile:id/inspiration_step1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_TIP2",By.id("com.ebay.mobile:id/inspiration_step2"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_TIP3",By.id("com.ebay.mobile:id/inspiration_step3"));
			setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_TIP_IMG",By.id("com.ebay.mobile:id/inspiration_image"));
			setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_TIP_DESC",By.id("com.ebay.mobile:id/inspiration_description"));
		setLocator(LocatorType.ANDROID_LOCATOR, "UNSIGNED_LEARN_MORE",By.id("com.ebay.mobile:id/learn_more_button"));
		
	}
	
	
	
}
