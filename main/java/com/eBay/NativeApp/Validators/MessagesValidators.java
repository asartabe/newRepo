package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.PageComponents.MessagesComponent;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class MessagesValidators implements IValidator {
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HamburgerMenuPanel hamPage;
	private MessagesValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<MessagesValidators.Use> {
		public MessagesValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new MessagesValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
		
	}
	
	public MessagesValidators setNotificationValidators(HamburgerMenuPanel hamPage){
		this.hamPage = hamPage;
		return this;
	}
	@Validator
	public MessagesValidators validateMessagePageElements(){
			uiChainAssert.element()
			.present(hamPage.getHamburgerMenuTopComponent().getMessagesComponent().INBOX_TAB, "Inbox tab not Present")
			.present(hamPage.getHamburgerMenuTopComponent().getMessagesComponent().SENT_TAB, "Sent tab not Present")
			.present(hamPage.getHamburgerMenuTopComponent().getMessagesComponent().MYFOLDER_TAB, "My Folder tab not Present")
			.present(hamPage.getHamburgerMenuTopComponent().getMessagesComponent().ALL_MSGS_DROPDWN, "All Messages Dropdown not Present");
			return this;
	}
	
	@Validator
	public MessagesValidators validateMessageCount(){
		int actual = Integer.parseInt(MessagesComponent.unReadCountACT);
		int expected = Integer.parseInt(MessagesComponent.unReadCountEXP);
		
		uiChainAssert.generic()
		.equals(expected, actual-1, "Message count does not match");
		
		return this;
	}
	
}
