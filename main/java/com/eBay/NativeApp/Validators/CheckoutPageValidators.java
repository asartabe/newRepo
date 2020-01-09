package com.eBay.NativeApp.Validators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.Pages.CheckoutPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class CheckoutPageValidators implements IValidator{

	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	CheckoutPage xoPage;
	
	private CheckoutPageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<CheckoutPageValidators.Use> {
		public CheckoutPageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new CheckoutPageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}
	
	public CheckoutPageValidators setCheckoutPage(CheckoutPage xoPage){
		this.xoPage = xoPage;
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateSellerAndItemDetailsOnXO(){
		uiChainAssert.element()
			.present(xoPage.getCheckoutPageComponent().SELLER_BLOCK, "Seller/Item Details Block is missing")
			.withinParent(xoPage.getCheckoutPageComponent().SELLER_BLOCK)
				.present(xoPage.getCheckoutPageComponent().SELLER_NAME, "Seller Name details is missing")
				.present(xoPage.getCheckoutPageComponent().SELLER_ITEMS, "XO Items are missing")
				.withinParent(xoPage.getCheckoutPageComponent().SELLER_ITEMS)
				.present(xoPage.getCheckoutPageComponent().SELLER_ITEM_DETAILS, "Item Details are missing")
				.withinParent(xoPage.getCheckoutPageComponent().SELLER_ITEM_DETAILS)
					.present(xoPage.getCheckoutPageComponent().SELLER_ITEM_DETAILS_IMG, "Item Image is missing")
					.present(xoPage.getCheckoutPageComponent().SELLER_ITEM_DETAILS_TITLE, "Item Title is missing")
					.present(xoPage.getCheckoutPageComponent().SELLER_ITEM_DETAILS_PRICE, "Item Price details are missing")
					.present(xoPage.getCheckoutPageComponent().SELLER_ITEM_DETAILS_QTY, "Item Quantity is missing");
		
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateSellerPostageInfo(){
		uiChainAssert.element()
			.withinParent(xoPage.getCheckoutPageComponent().SELLER_BLOCK)
			.withinParent(xoPage.getCheckoutPageComponent().SELLER_ITEMS)
				.present(xoPage.getCheckoutPageComponent().SELLER_POSTAGE_DETAILS, "Item Postage Info is mssing")
				.withinParent(xoPage.getCheckoutPageComponent().SELLER_POSTAGE_DETAILS)
					.present(xoPage.getCheckoutPageComponent().SELLER_POSTAGE_DETAILS_TITLE, "Item PostageInfo Title")
					.present(xoPage.getCheckoutPageComponent().SELLER_POSTAGE_DETAILS_POSTNAME, "Item Postage Service Name")
					.present(xoPage.getCheckoutPageComponent().SELLER_POSTAGE_DETAILS_EST, "Item Postage Service ETA")
					.present(xoPage.getCheckoutPageComponent().SELLER_POSTAGE_DETAILS_POSTCOST, "Item Postage Service Cost");
		
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateCnCAvailable(){
		uiChainAssert.element()
			.withinParent(xoPage.getCheckoutPageComponent().SELLER_BLOCK)
			.present(xoPage.getCheckoutPageComponent().CnC_OPTIONS, "Click & Collect Options are missing");
		
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateCnCSelectedStoreDetails(){
		uiChainAssert.element()
			.withinParent(xoPage.getCheckoutPageComponent().SELLER_BLOCK)
			.present(xoPage.getCheckoutPageComponent().CnC_STORE_SELECTED, "Selected Store details are missing");
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateCnCSelectedStoreDetails(String storeName){
		uiChainAssert.element()
			.withinParent(xoPage.getCheckoutPageComponent().SELLER_BLOCK)
			.present(xoPage.getCheckoutPageComponent().CnC_STORE_SELECTED, "Selected Store details are missing")
			.textContains(xoPage.getCheckoutPageComponent().CnC_STORE_SELECTED, storeName, "Selected Store details doesn't matches Store selected in SPW");
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateSendMessageToSellerLink(){
		uiChainAssert.element()
		.withinParent(xoPage.getCheckoutPageComponent().SELLER_BLOCK)
			.present(xoPage.getCheckoutPageComponent().SELLER_SEND_MESSAGE_LINK, "Send Message To Seller Link is missing");
		
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateXOSummary(){
		uiChainAssert.element()
			.present(xoPage.getCheckoutPageComponent().XO_SUMMARY, "XO Summary is missing")
			.present(xoPage.getCheckoutPageComponent().XO_TOTAL_LBL, "XO Total Price Label is missing")
			.present(xoPage.getCheckoutPageComponent().XO_TOTAL_VALUE, "XO Total Price Value Label is missing")
			.present(xoPage.getCheckoutPageComponent().CONFIRM_AND_PAY_BTN, "Confirm & Pay button is missing");
		
		/*CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 10, ScrollDirection.UP);*/
		
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateAlertDetails(){
		uiChainAssert.element()
			.present(xoPage.getCheckoutPageComponent().ALERT_DETAILS, "Alert Details are missing")
			.withinParent(xoPage.getCheckoutPageComponent().ALERT_DETAILS)
				.present(xoPage.getCheckoutPageComponent().ALERT_TXT, "Alert text is missing");
		new ReportLogger().logBoldStep(actions.element().withinParent(xoPage.getCheckoutPageComponent().ALERT_DETAILS)
				.get().text(xoPage.getCheckoutPageComponent().ALERT_TXT, ""));
		
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateSMEDiscountLabel(){
		validateXOSummary();
		uiChainAssert.element()
			.withinParent(xoPage.getCheckoutPageComponent().XO_SUMMARY)
				.present(xoPage.getCheckoutPageComponent().XO_SUMMARY_LBL, "XO Summary Labels are missing")
				.present(xoPage.getCheckoutPageComponent().XO_SUMMARY_VAL, "XO Summary Values are missing");
		
		List<WebElement> xoLabels = actions.element().withinParent(xoPage.getCheckoutPageComponent().XO_SUMMARY)
					.get().allWebElementsWithSameLocator(xoPage.getCheckoutPageComponent().XO_SUMMARY_LBL);
		List<String> lblText = new ArrayList<>();
		for (WebElement lbl : xoLabels) {
			lblText.add(lbl.getText());
		}
		uiChainAssert.collection()
			.contains(lblText, "Discount", "No [Discount] summary label is present");
		
		return this;
	}
	
	@Validator
	public CheckoutPageValidators validateEGDLabel(){
		uiChainAssert.element()
		.present(xoPage.getCheckoutPageComponent().EGD_TEXT, "eGD label absent on XO page");
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
