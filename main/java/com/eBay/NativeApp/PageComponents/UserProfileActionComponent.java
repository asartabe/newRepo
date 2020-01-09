package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Enums.Feedback;
import com.eBay.NativeApp.Locators.UserProfileActionComponentLocators;
import com.eBay.NativeApp.Pages.UserProfilePage;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;

public class UserProfileActionComponent extends UserProfileActionComponentLocators{

	public UserProfileActionComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public UserProfileActionComponent followThisUser(){
		if(actions.element().present().now(FOLLOW_BTN))
			actions.element().click().by(FOLLOW_BTN);
		else
			new GenericAssert().fail("[FOLLOW] Button is missing!!!");
		return this;
	}
	
	public UserProfileActionComponent clickItemsForSaleLink(){
		if(actions.element().present().now(SELLER_OTHER_ITEMS))
			actions.element().click().by(SELLER_OTHER_ITEMS);
		else
			new GenericAssert().fail("[ITEMS_FOR_SALE] Link is missing!!!");
		return this;
	}
	
	public UserProfileActionComponent clickSeeAllFeedbackLink(){
		if(actions.element().present().now(SEE_ALL_FDBACK))
			actions.element().click().by(SEE_ALL_FDBACK);
		else
			new GenericAssert().fail("[SEE_ALL_FDBACK] Link is missing!!!");
		return this;
	}
	
	private void clickThisFeedbackType(By by){
		if(CustomTouchUtils.scrollToElement(actions, by, 3))
			actions.element().withinParent(new UserProfilePage(driver).getUserProfileContentComponent().RECENT_FDBACK_PANEL).click().by(by);
	}
	public UserProfileActionComponent showOnlyFeedbacksOfType(Feedback fd){
		if(fd.equals(Feedback.POSITIVE))
			clickThisFeedbackType(new UserProfilePage(driver).getUserProfileContentComponent().POSITIVE_BTN);
		else if(fd.equals(Feedback.NEUTRAL))
			clickThisFeedbackType(new UserProfilePage(driver).getUserProfileContentComponent().NEUTRAL_BTN);
		else if(fd.equals(Feedback.NEGATIVE))
			clickThisFeedbackType(new UserProfilePage(driver).getUserProfileContentComponent().NEGATIVE_BTN);
		else
			new ReportLogger().logWarningStep("Attempt to Click Some Element for ALL FeedbackType - No Such legend avaialable!!!");
			
		return this;
	}
	
}
