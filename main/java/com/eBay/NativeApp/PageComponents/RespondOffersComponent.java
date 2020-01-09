package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.RespondOffersComponentLocators;
import com.eBay.NativeApp.Pages.RespondOffersPage;
import com.eBay.NativeApp.Validators.ReviewOfferValidators;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;

public class RespondOffersComponent extends RespondOffersComponentLocators{

	public RespondOffersComponent(WebDriver driver) {
		super(driver);
	}
	
	private RespondOffersComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return new RespondOffersComponent(driver);
	}
	
	private RespondOffersComponent checkLandingPage(UIChainAssert uiAssert){
		new ReviewOfferValidators.Use().uiAssertion(uiAssert).validate(driver).setRespondOffersPage(new RespondOffersPage(driver))
			.validateReviewOfferLandingPage();
		return this;
	}
	
	public RespondOffersComponent acceptOffer(UIChainAssert uiAssert){
		checkLandingPage(uiAssert);
		clickThisElement(BTN_ACCEPT);
		new ReviewOfferValidators.Use().uiAssertion(uiAssert).validate(driver).setRespondOffersPage(new RespondOffersPage(driver))
			.validateAcceptOfferPage();
		clickThisElement(BTN_ACCEPT_CONFIRM);
		new ReviewOfferValidators.Use().uiAssertion(uiAssert).validate(driver).setRespondOffersPage(new RespondOffersPage(driver))
			.validateSuccessAcceptMessage();
		return this;
	}
	
	public RespondOffersComponent declineOffer(UIChainAssert uiAssert){
		checkLandingPage(uiAssert);
		clickThisElement(BTN_DECLINE);
		new ReviewOfferValidators.Use().uiAssertion(uiAssert).validate(driver).setRespondOffersPage(new RespondOffersPage(driver))
			.validateDeclineOfferPage();
		clickThisElement(BTN_DECLINE_CONFIRM);
		new ReviewOfferValidators.Use().uiAssertion(uiAssert).validate(driver).setRespondOffersPage(new RespondOffersPage(driver))
			.validateSuccessDeclineMessage();
		return this;
	}
	
	public RespondOffersComponent counterOffer(Double offerPrice, int quantity, UIChainAssert uiAssert){
		checkLandingPage(uiAssert);
		clickThisElement(BTN_COUNTER);
		new ReviewOfferValidators.Use().uiAssertion(uiAssert).validate(driver).setRespondOffersPage(new RespondOffersPage(driver))
			.validateCounterOfferPage();
		actions.element().textBox().clearAndSendKeys(CTR_OFFER_TXT, Double.toString(offerPrice));
		if(actions.element().present().now(CTR_OFFER_QTY))
			actions.element().textBox().clearAndSendKeys(CTR_OFFER_QTY, Integer.toString(quantity));
		clickThisElement(CTR_RVW_OFFER);
		clickThisElement(BTN_COUNTER_CONFIRM);
		new ReviewOfferValidators.Use().uiAssertion(uiAssert).validate(driver).setRespondOffersPage(new RespondOffersPage(driver))
			.validateSuccessCounterMessage();
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
