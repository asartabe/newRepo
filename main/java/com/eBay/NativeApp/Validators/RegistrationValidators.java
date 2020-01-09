package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.RegistrationScreen;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.testdrivers.enums.Priority;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class RegistrationValidators  implements IValidator{

	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	RegistrationScreen reg;

	private RegistrationValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<RegistrationValidators.Use> {
		public RegistrationValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new RegistrationValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}
	
	public RegistrationValidators setRegistrationScreenObject(RegistrationScreen reg){
		this.reg = reg;
		return this;
	}
	
	@Validator(priority=Priority.P1)
	public RegistrationValidators validateRegistered(){
		uiChainAssert.element()
			.present(reg.getRegistrationFieldComponent().REGCNFRM_CALLMENOW, "[CALL_ME_NOW] button wasn't found!!!")
			.then().element()
			.present(reg.getRegistrationFieldComponent().REGCNFRM_TEXTMENOW, "[TEXT_ME_NOW] button wasn't found!!!");
		return this;
	}
	
	@Validator
	public void validateExistingEmailErrorMessage(){
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU"))
			uiChainAssert.element()
				.present(By.xpath("//android.view.View[contains(@content-desc, 'Your email address is already registered with eBay.')]"), "");
		else
			uiChainAssert.element()
				.present(By.xpath("//android.view.View[contains(@content-desc, 'Please enter a different email address.')]"), "");
	}

}
