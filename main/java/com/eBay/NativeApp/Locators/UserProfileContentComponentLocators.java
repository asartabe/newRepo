package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.UserProfileContentComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class UserProfileContentComponentLocators extends BasePageObject<UserProfileContentComponent>{

	protected UserProfileContentComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By SELLER_IMAGE = getLocator("SELLER_IMAGE");
	public final By SELLER_NAME = getLocator("SELLER_NAME");
	public final By SELLER_FDBACK_COUNT = getLocator("SELLER_FDBACK_COUNT");
	public final By SELLER_FDBACK_STAR = getLocator("SELLER_FDBACK_STAR");
	
	public final By DETAILED_SELLER_RATINGS_HDR = getLocator("DETAILED_SELLER_RATINGS_HDR");
		public final By DSR_PARENT_PANEL = getLocator("DSR_PARENT_PANEL");
			public final By DSR_TITLE = getLocator("DSR_TITLE");
			public final By DSR_STAR_RATINGS = getLocator("DSR_STAR_RATINGS");
			public final By DSR_FDBACK_COUNT = getLocator("DSR_FDBACK_COUNT");
	
	public final By RECENT_FDBACK_RATINGS_HDR = getLocator("RECENT_FDBACK_RATINGS_HDR");
		public final By RECENT_FDBACK_PANEL = getLocator("RECENT_FDBACK_PANEL");
			public final By POSITIVE_BTN = getLocator("POSITIVE_BTN");
			public final By POSITIVE_1MON_COUNT = getLocator("POSITIVE_1MON_COUNT");
			public final By POSITIVE_6MON_COUNT = getLocator("POSITIVE_6MON_COUNT");
			public final By POSITIVE_12MON_COUNT = getLocator("POSITIVE_12MON_COUNT");
			public final By NEUTRAL_BTN = getLocator("NEUTRAL_BTN");
			public final By NEUTRAL_1MON_COUNT = getLocator("NEUTRAL_1MON_COUNT");
			public final By NEUTRAL_6MON_COUNT = getLocator("NEUTRAL_6MON_COUNT");
			public final By NEUTRAL_12MON_COUNT = getLocator("NEUTRAL_12MON_COUNT");
			public final By NEGATIVE_BTN = getLocator("NEGATIVE_BTN");
			public final By NEGATIVE_1MON_COUNT = getLocator("NEGATIVE_1MON_COUNT");
			public final By NEGATIVE_6MON_COUNT = getLocator("NEGATIVE_6MON_COUNT");
			public final By NEGATIVE_12MON_COUNT = getLocator("NEGATIVE_12MON_COUNT");
	
	@Override
	protected void setLocators() {
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_IMAGE",By.id("com.ebay.mobile:id/seller_image_imageview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_NAME",By.id("com.ebay.mobile:id/seller_name_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_FDBACK_COUNT",By.id("com.ebay.mobile:id/feedback_count_textview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "SELLER_FDBACK_STAR",By.id("com.ebay.mobile:id/feedback_star_imageview"));
		setLocator(LocatorType.ANDROID_LOCATOR, "DETAILED_SELLER_RATINGS_HDR",By.id("com.ebay.mobile:id/detail_header"));
			setLocator(LocatorType.ANDROID_LOCATOR, "DSR_PARENT_PANEL",By.id("com.ebay.mobile:id/detail_layout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "DSR_TITLE",By.id("com.ebay.mobile:id/title"));
				setLocator(LocatorType.ANDROID_LOCATOR, "DSR_STAR_RATINGS",By.id("com.ebay.mobile:id/rating_bar"));
				setLocator(LocatorType.ANDROID_LOCATOR, "DSR_FDBACK_COUNT",By.id("com.ebay.mobile:id/number"));
		setLocator(LocatorType.ANDROID_LOCATOR, "RECENT_FDBACK_RATINGS_HDR",By.id("com.ebay.mobile:id/feedback_header"));
			setLocator(LocatorType.ANDROID_LOCATOR, "RECENT_FDBACK_PANEL",By.id("com.ebay.mobile:id/feedback_layout"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSITIVE_BTN",By.id("com.ebay.mobile:id/positive_table_row"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSITIVE_1MON_COUNT",By.id("com.ebay.mobile:id/seller_positive_1mo_textview"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSITIVE_6MON_COUNT",By.id("com.ebay.mobile:id/seller_positive_6mo_textview"));
				setLocator(LocatorType.ANDROID_LOCATOR, "POSITIVE_12MON_COUNT",By.id("com.ebay.mobile:id/seller_positive_12mo_textview"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NEUTRAL_BTN",By.id("com.ebay.mobile:id/neutral_table_row"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NEUTRAL_1MON_COUNT",By.id("com.ebay.mobile:id/seller_neutral_1mo_textview"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NEUTRAL_6MON_COUNT",By.id("com.ebay.mobile:id/seller_neutral_6mo_textview"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NEUTRAL_12MON_COUNT",By.id("com.ebay.mobile:id/seller_neutral_12mo_textview"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NEGATIVE_BTN",By.id("com.ebay.mobile:id/negative_table_row"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NEGATIVE_1MON_COUNT",By.id("com.ebay.mobile:id/seller_negative_1mo_textview"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NEGATIVE_6MON_COUNT",By.id("com.ebay.mobile:id/seller_negative_6mo_textview"));
				setLocator(LocatorType.ANDROID_LOCATOR, "NEGATIVE_12MON_COUNT",By.id("com.ebay.mobile:id/seller_negative_12mo_textview"));
	}

}
