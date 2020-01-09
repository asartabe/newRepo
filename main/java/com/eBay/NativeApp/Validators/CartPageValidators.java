package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.CartPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class CartPageValidators implements IValidator{
	
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	CartPage cart;
	
	private CartPageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<CartPageValidators.Use> {
		public CartPageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new CartPageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}

	public CartPageValidators setSearchResultsPage(CartPage cart){
		this.cart = cart;
		return this;
	}
	
	@Validator
	public CartPageValidators validateCartContents(){
		uiChainAssert.element()
			.present(cart.getCartPageComponent().TAB_IN_CART, "IN CART Tab is missing")
			.present(cart.getCartPageComponent().TAB_SAVED, "SAVED Tab is missing");
		return this;
	}
	
	@Validator 
	public CartPageValidators validateLineItemDetails(){
		uiChainAssert.element()
			.present(cart.getCartPageComponent().CART_LINE_ITM, "Cart Line Items are missing")
			.present(cart.getCartPageComponent().LINE_ITM_DETAILS, "Line Item Details section is missing")
			.withinParent(cart.getCartPageComponent().LINE_ITM_DETAILS)
				.present(cart.getCartPageComponent().ITM_IMG, "Line Item Image is missing")
				.present(cart.getCartPageComponent().ITM_TITLE, "Line Item Title is missing")
				.present(cart.getCartPageComponent().ITM_PRICE, "Line Item Price is missing")
				.present(cart.getCartPageComponent().ITM_POSTAGE, "Line Item Postage is missing");
		return this;
	}
	
	@Validator
	public CartPageValidators validateSMEDetails(){
		uiChainAssert.element()
			.present(cart.getCartPageComponent().SME_PANEL, "SME panel is missing")
				.withinParent(cart.getCartPageComponent().SME_PANEL)
					.present(cart.getCartPageComponent().SME_PROMO_TITLE, "SME Promo Title is missing")
					.present(cart.getCartPageComponent().SME_PROMO_DICOUNTED_PRICE, "SME Promo Discout Price details is missing");
		return this;
	}
	
}
