package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Locators.CartPageComponentLocators;

public class CartPageComponent extends CartPageComponentLocators{

	public CartPageComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CartPageComponent clickInCartTab(){
		actions.element().click().by(TAB_IN_CART);
		return this;
	}
	
	public CartPageComponent clickSavedTab(){
		actions.element().click().by(TAB_SAVED);
		return this;
	}
	
	public CartPageComponent closeCart(){
		actions.element().click().by(CLOSE_CART);
		return this;
	}
	
	public CartPageComponent proceedToCheckout(){
		actions.element().click().by(CHECKOUT_BTN);
		return this;
	}
	
	public CartPageComponent removeItem(){
		actions.element().click().by(REMOVE_BTN);
	//	actions.element().click().by(REM_CONFIRM_BTN);
		return this;
	}
	
	public CartPageComponent saveItemForLater(){
		actions.element().click().by(SAVE_FOR_LATER_BTN);
		return this;
	}
	
	public CartPageComponent addBackToCartFromSaved(){
		actions.element().click().by(ADD_BACK_TO_CART);
		return this;
	}
	
}
