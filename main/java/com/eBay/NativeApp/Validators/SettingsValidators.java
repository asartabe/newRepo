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

public class SettingsValidators implements IValidator{
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HamburgerMenuPanel hamPage;
	private SettingsValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<SettingsValidators.Use> {
		public SettingsValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new SettingsValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public SettingsValidators setSettingsValidators(HamburgerMenuPanel hamPage){
		this.hamPage = hamPage;
		return this;
	}

	@Validator
	public SettingsValidators validateSettingsPageElements(){
		uiChainAssert.element()
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().POSTAGE_ADD_LNK, "Postage Adress link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().SIGNOUT_LNK, "Signout link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().SIGNIN_LNK, "Signin link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().NOTIFICATIONS_LNK, "Notification Link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().COUNTRY_LNK, "Country Link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().CLEAR_HISTORY_LNK, "Clear Search History Link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().USER_AGREEMENT_LNK, "User Agreement Link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().PRIVACY_LNK, "Privacy Link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().ADV_LNK, "Advertising Opt Out Link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().ABOUT_LNK, "About Link not Present")
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().CUST_SER_LNK, "Customer Service Link not Present");
		return this;
	}
	@Validator
	public SettingsValidators validatePrimaryAdress(){
		uiChainAssert.element()
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().PRIMARY_ADD_LNK, "Primary Adress link not Present");
		return this;
	}
	@Validator
	public SettingsValidators validateChangePasswordLnk(){
		uiChainAssert.element()
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().CHNGE_PWD_LNK, "Change Password link not Present");
		return this;
	}
	@Validator
	public SettingsValidators validateCountryToggleSwitch(){
		uiChainAssert.element()
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().COUNTRY_SWITCH_TOGGLE, "Country Toggle Switch not Present");
		return this;
	}
	@Validator
	public SettingsValidators validateCustomerServiceLnk(){
		uiChainAssert.element()
		.present(hamPage.getHamburgerMenuBottomComponent().getSettingsComponent().HELP_CONTACT_TEXT, "Help and Contact Page not Displayed");
		return this;
	}

}
