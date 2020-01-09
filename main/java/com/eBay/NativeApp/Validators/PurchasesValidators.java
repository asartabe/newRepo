package com.eBay.NativeApp.Validators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class PurchasesValidators implements IValidator{
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HamburgerMenuPanel hamPage;
	private PurchasesValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<PurchasesValidators.Use> {
		public PurchasesValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new PurchasesValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public PurchasesValidators setPurchasesValidators(HamburgerMenuPanel hamPage){
		this.hamPage = hamPage;
		return this;
	}
	@Validator
	public PurchasesValidators validatePurchasesPage(){
		uiChainAssert.element()
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().EDIT_BTN, "Edit Button not present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().REFINE_BTN, "Refine button not present")
		.withinParent(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().FIRST_ITEM).present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().IMAGE_IMAGE, "Item Image not Present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_STATUS, "Item Status not Present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_POSTAGE, "Item Postage not Present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_PRICE, "Item Price not Present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_TITLE, "Item Title not Present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_TIMELEFT, "Item Time Left not Present");
		return this;
	}

	@Validator
	public PurchasesValidators validatePurchasesStatusText(){
		List<WebElement> ele = actions.element().get().allWebElementsWithSameLocator(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_STATUS);
		boolean flag = false;
		for (WebElement webElement : ele) {
			if(webElement.getText().equalsIgnoreCase("SENT") || webElement.getText().contains("PAY NOW") || webElement.getText().contains("PAID") || webElement.getText().contains("CANCEL CLOSED") || webElement.getText().contains("CANCEL CLOSED WITH REFUND"))
				flag = true;
			else{
				flag = false;
				break;
			}
		}
		uiChainAssert.generic().assertTrue(flag, "Incorrect Status Message for Some Items");
		return this;	
	}
	@Validator
	public PurchasesValidators validateCheckboxEnabled(){
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			List<WebElement> parent = new ArrayList<>();
			
			if(actions.element().present().now(hamPage.getHamburgerMenuMyEbayComponent().getPurchasesComponent().ALL_ITEMS))
				parent = actions.element().get().allWebElementsWithSameLocator(hamPage.getHamburgerMenuMyEbayComponent().getPurchasesComponent().ALL_ITEMS);
			
			if(parent.size() > 1)
				parent.remove(0);
			if(parent.size() > 1)
				parent.remove(parent.size()-1);
			
			if(parent.size() >= 1){
				String childText = new String() ;
				for (WebElement itrParent : parent) {
					childText = actions.element().withinParent(itrParent).get().text(hamPage.getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_STATUS, "Not able to read Item Status");
					if(childText.equalsIgnoreCase("SENT") || childText.equalsIgnoreCase("Paid") || childText.equalsIgnoreCase("Cancel closed") || childText.equalsIgnoreCase("cancel closed with refund"))
							{
						flag = true;
						uiChainAssert.element()
							.withinParent(itrParent).attributeValueContains(hamPage.getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_CHECKBOX, "enabled", "true", "Checkbox isn't Enabled!!!");
					}
					else
						uiChainAssert.element().withinParent(itrParent).attributeValueContains(hamPage.getHamburgerMenuMyEbayComponent().getPurchasesComponent().ITEM_CHECKBOX, "enabled", "false", "Checkbox is Enabled for unpaid item!!!");
				}
			}
			if(!flag) CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
			else break;
		}
		return this;
	}
	
	@Validator
	public PurchasesValidators validateRefinementOptions() {
		uiChainAssert.element()
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().REFINE_TITLE, "Refine title not present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getPurchasesComponent().REFINE_DONE_LNK, "Refine done not found");
		
		return this;
		
	}

}
