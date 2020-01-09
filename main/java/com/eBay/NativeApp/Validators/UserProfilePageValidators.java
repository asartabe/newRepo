package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Pages.UserProfilePage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class UserProfilePageValidators implements IValidator{
	
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	UserProfilePage profilePage;
	
	private UserProfilePageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<UserProfilePageValidators.Use> {
		public UserProfilePageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new UserProfilePageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public UserProfilePageValidators setUserProfilePage(UserProfilePage profilePage){
		this.profilePage = profilePage;
		return this;
	}

	@Validator
	public UserProfilePageValidators validateUserDetails(){
		uiChainAssert.element()
			.present(profilePage.getUserProfileContentComponent().SELLER_IMAGE, "User profile Image is missing")
			.present(profilePage.getUserProfileContentComponent().SELLER_NAME, "User Name is missing")
			.present(profilePage.getUserProfileContentComponent().SELLER_FDBACK_COUNT, "User feedback count is missing")
			.present(profilePage.getUserProfileActionComponent().CONTACT_BTN, "Contact Button is missing")
			.present(profilePage.getUserProfileActionComponent().FOLLOW_BTN, "Follow Button is missing")
			.present(profilePage.getUserProfileActionComponent().SELLER_OTHER_ITEMS, "Link to Seller's Other Items is missing")
			.present(profilePage.getUserProfileActionComponent().SEE_ALL_FDBACK, "Link to See All Feedback for Seller is missing");
		return this;
	}
	
	@Validator
	public UserProfilePageValidators validateDSRifPresent(){
		if(actions.element().present().byCustomPolling(profilePage.getUserProfileContentComponent().DETAILED_SELLER_RATINGS_HDR, 10)){
			uiChainAssert.element()
				.present(profilePage.getUserProfileContentComponent().DSR_PARENT_PANEL, "DSR Panel is missing")
				.withinParent(profilePage.getUserProfileContentComponent().DSR_PARENT_PANEL)
					.present(profilePage.getUserProfileContentComponent().DSR_TITLE, "DSR Titles are missing")
					.present(profilePage.getUserProfileContentComponent().DSR_STAR_RATINGS, "DSR Star Ratings are missing")
					.present(profilePage.getUserProfileContentComponent().DSR_FDBACK_COUNT, "DSR Feedback Counts are missing");
		}
		else
			new ReportLogger().logRedStep("DETAILED SELLER RATINGS are not available for the Seller: [ "+
		actions.element().get().text(profilePage.getUserProfileContentComponent().SELLER_NAME, "")+" ]");
		
		return this;
	}
	
	@Validator
	public UserProfilePageValidators validateRecentFeedbackRatings(){
		CustomTouchUtils.swipe(actions.touchScreen().getScreenCenter(), 5, ScrollDirection.DOWN);
		
		uiChainAssert.element()
			.present(profilePage.getUserProfileContentComponent().RECENT_FDBACK_RATINGS_HDR, "Recent Feedback Ratings (RFR) header is missing")
			.present(profilePage.getUserProfileContentComponent().RECENT_FDBACK_PANEL, "RFR Panel is missing")
				.withinParent(profilePage.getUserProfileContentComponent().RECENT_FDBACK_PANEL)
					.present(profilePage.getUserProfileContentComponent().POSITIVE_BTN, "RFR Positive Button is missing")
					.present(profilePage.getUserProfileContentComponent().POSITIVE_1MON_COUNT, "RFR Positive 1Month Count is missing")
					.present(profilePage.getUserProfileContentComponent().POSITIVE_6MON_COUNT, "RFR Positive 6Month Count is missing")
					.present(profilePage.getUserProfileContentComponent().POSITIVE_12MON_COUNT, "RFR Positive 12Month Count is missing")
					.present(profilePage.getUserProfileContentComponent().NEUTRAL_BTN, "RFR Neutral Button is missing")
					.present(profilePage.getUserProfileContentComponent().NEUTRAL_1MON_COUNT, "RFR Neutral 1Month Count is missing")
					.present(profilePage.getUserProfileContentComponent().NEUTRAL_6MON_COUNT, "RFR Neutral 6Month Count is missing")
					.present(profilePage.getUserProfileContentComponent().NEUTRAL_12MON_COUNT, "RFR Neutral 12Month Count is missing")
					.present(profilePage.getUserProfileContentComponent().NEGATIVE_BTN, "RFR Negative Button is missing")
					.present(profilePage.getUserProfileContentComponent().NEGATIVE_1MON_COUNT, "RFR Negative 1Month Count is missing")
					.present(profilePage.getUserProfileContentComponent().NEGATIVE_6MON_COUNT, "RFR Negative 6Month Count is missing")
					.present(profilePage.getUserProfileContentComponent().NEGATIVE_12MON_COUNT, "RFR Negative 12Month Count is missing");
		
		CustomTouchUtils.swipe(actions.touchScreen().getScreenCenter(), 5, ScrollDirection.UP);
		return this;
	}
	
	
	
	
	
}
