package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class EbayHamburgerValidators implements IValidator {
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HamburgerMenuPanel hamPage;
	private EbayHamburgerValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<EbayHamburgerValidators.Use> {
		public EbayHamburgerValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new EbayHamburgerValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
		
	}
	
	public EbayHamburgerValidators setVEbayHamburger(HamburgerMenuPanel hamPage){
		this.hamPage = hamPage;
		return this;
	}
	
	@Validator
	public EbayHamburgerValidators checkMenuElements(){
			uiChainAssert.element()
				.present(hamPage.getHamburgerMenuTopComponent().HAM_SIGN_LNK, "SIGN_IN missing ")
			    .present(hamPage.getHamburgerMenuTopComponent().NOTIFICATION_LNK, "NOTIFICATION_LNK missing")
				.present(hamPage.getHamburgerMenuTopComponent().MESSAGES_LNK, "MESSAGES_LNK missing")	
			    .present(hamPage.getHamburgerMenuMyEbayComponent().WATCHING_LNK, "WATCHING_LNK missing")	
			    .present(hamPage.getHamburgerMenuMyEbayComponent().PURCHASES_LNK, "PURCHASES_LNK missing")	
			    .present(hamPage.getHamburgerMenuMyEbayComponent().BIDSOFFERS_LNK, "BIDSOFFERS_LNK missing")	
			    .present(hamPage.getHamburgerMenuMyEbayComponent().SELLING_LNK, "SELLING_LNK missing")
			    .present(hamPage.getHamburgerMenuMyEbayComponent().FOLLOWING_LNK, "FOLLOWING_LNK missing")	
			    .present(hamPage.getHamburgerMenuMyEbayComponent().CATEGORIES_LNK, "ITEM_PHOTOS missing")	
			    .present(hamPage.getHamburgerMenuMyEbayComponent().DEALS_LNK, "DEALS_LNK missing")
			    .present(hamPage.getHamburgerMenuMyEbayComponent().SETTINGS_LNK, "SETTINGS_LNK missing")	
			    .present(hamPage.getHamburgerMenuMyEbayComponent().HELP_LNK, "HELP_LNK missing").end();	
		return this;
	}


	
}
