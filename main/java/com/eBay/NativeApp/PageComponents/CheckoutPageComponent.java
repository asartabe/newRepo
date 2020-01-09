package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Enums.TestPayPalEmail;
import com.eBay.NativeApp.Locators.CheckoutPageComponentLocators;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;

public class CheckoutPageComponent extends CheckoutPageComponentLocators{

	public CheckoutPageComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/*private CheckoutPageComponent waitAndClickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}*/
	
	private static boolean ppAdded = false;
	
	public CheckoutPageComponent selectPaymentOption(){
		if(CustomTouchUtils.scrollToElement(actions, PAYMENT_LINK, 5)){
			String text = actions.element().withinParent(PAYMENT_LINK).get().text(PAYMENT_ADDED_PAYPAL, ""); 
			if(text.contains("Select payment option") || text.contains("SELECT PAYMENT OPTION"))
				actions.element().withinParent(PAYMENT_LINK).click().by(PAYMENT_ADDED_PAYPAL);
		}else{
			new ReportLogger().logRedStep("A PayPal Address is already added to account for Checkout & Payments.");
			ppAdded = true;
		}
		return this;
	}
	
	private CheckoutPageComponent enterTextToWebElement(WebElement element, String text){
		actions.element().textBox().clear(element);
		actions.element().textBox().sendKeys(element, text);
		return this;
	}
	
	public CheckoutPageComponent payViaPayPal(TestPayPalEmail ppAddress){
		if(!ppAdded){
			if(CustomWaitUtils.waitForElement(PAYMENT_LNK_PAYPAL))
				actions.element().click().oneFromManyWithSameLocator(PAYMENT_LNK_PAYPAL, 0);
			else if(CustomWaitUtils.waitForElement(PAYMENT_LINK)){
				actions.touchScreen().usingBy().tap(PAYMENT_ADDED_PAYPAL);
				payViaPayPal(ppAddress);
			}			
			List<WebElement> ppFields = actions.element().get().allWebElementsWithSameLocator(PAYPAL_LOGIN_FIELDS);
			this.enterTextToWebElement(ppFields.get(0), ppAddress.getEmailAddress())
			.enterTextToWebElement(ppFields.get(1), ppAddress.getPassword());
			actions.element().click().by(PAYPAL_LOGIN_BTN);
		}
		return this;
	}
	
	public String selectClickAndCollectOption(){
		String storeName = new String();
		if(CustomTouchUtils.scrollToElement(actions, CnC_OPTIONS, 5)){
			//actions.element().click().by(CnC_OPTIONS);
			List<WebElement> options = actions.element().get().allWebElementsWithSameLocator(CnC_OPTIONS); 
			if(options.size()>1) actions.element().click().webElement(options.get(1));
			else actions.element().click().webElement(options.get(0));
			
			storeName = actions.element().get().allWebElementsWithSameLocator(CnC_STORE_SELECTED_NAME).get(0).getText();
			actions.element().click().oneFromManyWithSameLocator(CnC_STORE, 0);
			actions.element().click().by(CnC_STORE_SAVE);
		}
		return storeName;
	}
	
	public CheckoutPageComponent confirmAndPay(){
		if(CustomTouchUtils.scrollToElement(actions, CONFIRM_AND_PAY_BTN, 5))
			actions.element().click().by(CONFIRM_AND_PAY_BTN);
		
		return this;
	}
	
	public CheckoutPageComponent addMessageToSeller(String message){
		if(CustomTouchUtils.scrollToElement(actions, SELLER_SEND_MESSAGE_LINK, 5)){
			actions.element().click().by(SELLER_SEND_MESSAGE_LINK);
			actions.element().textBox().clearAndSendKeys(MESSAGE_COMPOSE, message);
			actions.element().click().by(MESSAGE_SAVE);
		}
		return this;
	}
	
	public CheckoutPageComponent goBackToCartFromXOSuccess(){
		actions.element().click().by(SUCCESS_XO_BACKTO_CART);
		return this;
	}
	
}
