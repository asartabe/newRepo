package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class SellingValidators implements IValidator{
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HamburgerMenuPanel hamPage;
	private SellingValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<SellingValidators.Use> {
		public SellingValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new SellingValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public SellingValidators setHamburgerMenuPanelObject(HamburgerMenuPanel hamPage){
		this.hamPage = hamPage;
		return this;
	}
	
	@Validator
	public SellingValidators validateSellingPage(){
		uiChainAssert.element()
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().LIST_AN_ITEM_BTN, "List an item Button not Present")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().ACTIVE_LNK, "Active Link not Present")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSOLD_LNK, "Unsold Link not Present")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().SOLD_LNK, "Sold Link not Present")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().TOTAL_DAY_TEXT, "Total Day Count not Present");	
		return this;
	}
	
	@Validator
	public SellingValidators validateSellingPageUnsignedUser(){
		uiChainAssert.element()
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_REG_BTN, "Register button is absent for Unsigned User")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_SIGNIN_BTN, "SignIn button is absent for Unsigned User")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_HOW_IT_WORKS, "How It Works section is absent for Unsigned User")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_TIP1, "Tip-1 is absent for Unsigned User")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_TIP2, "Tip-2 is absent for Unsigned User")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_TIP3, "Tip-3 is absent for Unsigned User")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_LEARN_MORE, "Learn More link is absent for Unsigned User");
			
		List<WebElement> tips = actions.element().get().allWebElementsWithSameLocator(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_TIPS_ALL);
		int i=1;
		for (WebElement tip : tips) {
			uiChainAssert.element()
				.withinParent(tip)
				.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_TIP_IMG, "Tip Image is missing for Tip-"+i)
				.present(hamPage.getHamburgerMenuMyEbayComponent().getSellingComponent().UNSIGNED_TIP_DESC, "Tip Description is missing for Tip-"+i);
			i++;
		}
		return this;
	}
	
	
	
}
