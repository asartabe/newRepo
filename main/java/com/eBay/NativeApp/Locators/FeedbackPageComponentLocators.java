package com.eBay.NativeApp.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.FeedbackPageComponent;
import com.ebay.testinfrastructure.webautil.page.BasePageObject;
import com.ebay.testinfrastructure.webautil.page.locator.LocatorType;

public class FeedbackPageComponentLocators extends BasePageObject<FeedbackPageComponent>{

	protected FeedbackPageComponentLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final By TAB_AS_SELLER = getLocator("TAB_AS_SELLER");
	public final By TAB_AS_BUYER = getLocator("TAB_AS_BUYER");
	
	public final By FEEDBACK_TYPE_DROPDWN = getLocator("FEEDBACK_TYPE_DROPDWN");
		public final By FEEDBACK_TYPE_CURRENT = getLocator("FEEDBACK_TYPE_CURRENT");
		public final By FEEDBACK_TYPE_ALL = getLocator("FEEDBACK_TYPE_ALL");
		public final By FEEDBACK_TYPE_POSITIVE = getLocator("FEEDBACK_TYPE_POSITIVE");
		public final By FEEDBACK_TYPE_NEUTRAL = getLocator("FEEDBACK_TYPE_NEUTRAL");
		public final By FEEDBACK_TYPE_NEGATIVE = getLocator("FEEDBACK_TYPE_NEGATIVE");
	
	public final By FEEDBACK_ITEMS = getLocator("FEEDBACK_ITEMS");
		public final By FEEDBACK_ITM_TYPE = getLocator("FEEDBACK_ITM_TYPE");
		public final By FEEDBACK_ITM_TITLE = getLocator("FEEDBACK_ITM_TITLE");
		public final By FEEDBACK_ITM_DATE = getLocator("FEEDBACK_ITM_DATE");
		public final By FEEDBACK_ITM_USER = getLocator("FEEDBACK_ITM_USER");
	
	@Override
	protected void setLocators() {

		setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_TYPE_DROPDWN",By.id("com.ebay.mobile:id/listSpinner"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_TYPE_CURRENT",By.id("android:id/text1"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_TYPE_ALL",By.xpath("//android.widget.CheckedTextView[@text='All Feedback']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_TYPE_POSITIVE",By.xpath("//android.widget.CheckedTextView[@text='Positive']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_TYPE_NEUTRAL",By.xpath("//android.widget.CheckedTextView[@text='Neutral']"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_TYPE_NEGATIVE",By.xpath("//android.widget.CheckedTextView[@text='Negative']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_ITEMS",By.id("com.ebay.mobile:id/feedback_content_layout"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_ITM_TYPE",By.id("com.ebay.mobile:id/feedback_type"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_ITM_TITLE",By.id("com.ebay.mobile:id/title"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_ITM_DATE",By.id("com.ebay.mobile:id/date"));
			setLocator(LocatorType.ANDROID_LOCATOR, "FEEDBACK_ITM_USER",By.id("com.ebay.mobile:id/user"));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.id(""));
		

		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_AS_SELLER",By.xpath("//android.widget.TextView[@text='AS SELLER']"));
		setLocator(LocatorType.ANDROID_LOCATOR, "TAB_AS_BUYER",By.xpath("//android.widget.TextView[@text='AS BUYER']"));
		
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));
		setLocator(LocatorType.ANDROID_LOCATOR, "",By.xpath(""));

	}

}
