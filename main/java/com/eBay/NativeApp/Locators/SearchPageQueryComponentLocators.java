package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.SearchPageQueryComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class SearchPageQueryComponentLocators extends BasePageObject<SearchPageQueryComponent>{

	protected SearchPageQueryComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By SRCH_TOP_BACK_BTN = getLocator("SRCH_TOP_BACK_BTN");
	public final By SRCH_TOP_INPUT_KW = getLocator("SRCH_TOP_INPUT_KW");
	public final By SRCH_TOP_VOICE_INPUT = getLocator("SRCH_TOP_VOICE_INPUT");
	public final By SRCH_TOP_BARCODE_LNK = getLocator("SRCH_TOP_BARCODE_LNK");
	
	public final By TAB_RECENT = getLocator("TAB_RECENT");
	public final By TAB_FOLLOWING = getLocator("TAB_FOLLOWING");
	
	public final By RECENT_SRCH_ENTRIES = getLocator("RECENT_SRCH_ENTRIES");
	public final By RECENT_CLEAR = getLocator("RECENT_CLEAR");
	public final By YES = getLocator("YES");
	public final By NO = getLocator("NO");
	
	public final By FOLLOWED_ENTRIES = getLocator("FOLLOWED_ENTRIES");
	public final By SEE_ALL_FOLLOWED_SRCH = getLocator("SEE_ALL_FOLLOWED_SRCH");
	public final By SEE_ALL_FOLLOWED_MEM = getLocator("SEE_ALL_FOLLOWED_MEM");
	
	@Override
	  protected void setLocators() {
	    
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_TOP_BACK_BTN",By.id("com.ebay.mobile:id/back_button"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_TOP_INPUT_KW",By.id("com.ebay.mobile:id/search_src_text"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_TOP_VOICE_INPUT",By.id("com.ebay.mobile:id/search_voice_btn"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SRCH_TOP_BARCODE_LNK",By.id("com.ebay.mobile:id/button_scan"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_RECENT",By.xpath("//android.widget.TextView[@text='Recent' or @text='RECENT']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_FOLLOWING",By.xpath("//android.widget.TextView[@text='Following' or @text='FOLLOWING' or contains(@text,'Saved') or contains(@text,'SAVED')]"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "RECENT_SRCH_ENTRIES",By.id("com.ebay.mobile:id/text_recent_entry"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RECENT_CLEAR",By.id("com.ebay.mobile:id/button_clear_recent_searches"));
		setLocator(LocatorType.ANDROID_LOCATOR, "YES",By.id("android:id/button1"));
		setLocator(LocatorType.ANDROID_LOCATOR, "NO",By.id("android:id/button2"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "FOLLOWED_ENTRIES",By.id("com.ebay.mobile:id/text_followed_entry"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEE_ALL_FOLLOWED_SRCH",By.id("com.ebay.mobile:id/button_see_all_followed_searches"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SEE_ALL_FOLLOWED_MEM",By.id("com.ebay.mobile:id/button_see_all_followed_members"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
	}
	
}
