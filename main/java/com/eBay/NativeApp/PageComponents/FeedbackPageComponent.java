package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Enums.Feedback;
import com.eBay.NativeApp.Locators.FeedbackPageComponentLocators;

public class FeedbackPageComponent extends FeedbackPageComponentLocators{

	public FeedbackPageComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public FeedbackPageComponent viewFeedbackAsSeller(){
		actions.element().click().by(TAB_AS_SELLER);
		return this;
	}
	
	public FeedbackPageComponent viewFeedbackAsBuyer(){
		actions.element().click().by(TAB_AS_BUYER);
		return this;
	}
	
	private FeedbackPageComponent selectFeedbackType(By by){
		actions.element().click().by(FEEDBACK_TYPE_DROPDWN);
		actions.element().click().by(by);
		return this;
	}
	public FeedbackPageComponent showFeedbacksOfType(Feedback fdBack){
		switch (fdBack) {
		case ALL: selectFeedbackType(FEEDBACK_TYPE_ALL);
			break;
		case POSITIVE: selectFeedbackType(FEEDBACK_TYPE_POSITIVE);
			break;
		case NEUTRAL: selectFeedbackType(FEEDBACK_TYPE_NEUTRAL);
			break;
		case NEGATIVE: selectFeedbackType(FEEDBACK_TYPE_NEGATIVE);
			break;
		}
		return this;
	}
	
}
