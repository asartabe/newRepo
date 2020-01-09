package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.SharePanel;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class SharePanelValidators implements IValidator{
	
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	SharePanel share;
	
	private SharePanelValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<SharePanelValidators.Use> {
		public SharePanelValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new SharePanelValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public SharePanelValidators setSharePanel(SharePanel share){
		this.share = share;
		return this;
	}
	
	@Validator
	public SharePanelValidators validateSharePanelDetails(){
		uiChainAssert.element()
			.present(share.getSharePanelComponent().SHARE_CONTENT_PANEL, "Share Content Panel is not displayed")
			.withinParent(share.getSharePanelComponent().SHARE_CONTENT_PANEL)
				.present(share.getSharePanelComponent().SHARE_PANEL_TITLE, "Share Panel Title is missing")
				.present(share.getSharePanelComponent().SHARE_PANEL_ITEMS_CONTAINER, "Share Panel Menu Options container is missing")
				.withinParent(share.getSharePanelComponent().SHARE_PANEL_ITEMS_CONTAINER)
					.present(share.getSharePanelComponent().SHARE_PANEL_ITEMS, "Share Panel Menu options are missing");
		return this;
	}
	
	
	
	
	
	
	
}
