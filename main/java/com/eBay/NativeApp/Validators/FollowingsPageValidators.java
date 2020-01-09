package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Pages.FollowingsPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class FollowingsPageValidators implements IValidator{
	
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	FollowingsPage follow;
	
	private FollowingsPageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<FollowingsPageValidators.Use> {
		public FollowingsPageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new FollowingsPageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}

	public FollowingsPageValidators setFollowingsPageValidators(FollowingsPage follow){
		this.follow = follow;
		return this;
	}
	
	private FollowingsPageValidators validateTabs(){
		uiChainAssert.element()
			.present(follow.getFollowingsPageComponent().TAB_SEARCHES, "SEARCHES Tab is missing.")
			.present(follow.getFollowingsPageComponent().TAB_MEMBERS, "MEMBERS Tab is missing.")
			.present(follow.getFollowingsPageComponent().TAB_COLLECTIONS, "COLLECTIONS Tab is missing.");
		return this;
	}
	
	private FollowingsPageValidators validateCommonElements(){
		uiChainAssert.element()
			.present(follow.getFollowingsPageComponent().BTN_EDIT, "EDIT Button is missing.")
			.present(follow.getFollowingsPageComponent().BTN_SORT, "SORT Button is missing.");
		return this;
	}
	
	private FollowingsPageValidators validateFeedData(String tabName){
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, follow.getFollowingsPageComponent().MY_FEED_HDR, 5)){
			uiChainAssert.element()
				.present(follow.getFollowingsPageComponent().MY_FEED_HDR, "My Feed header is missing")
				.present(follow.getFollowingsPageComponent().MY_FEED_SUBTITLE, "My Feed subtitle is missing")
				.present(follow.getFollowingsPageComponent().MY_FEED_ITEMS, "My Feed items are missing");
		}else
			uiChainAssert.generic().fail("Feed data is missing for ["+tabName+"]...!!!");
		return this;
	}
	
	@Validator
	public FollowingsPageValidators validateFollowingsSearchesTab(){
		validateTabs().validateCommonElements();
		uiChainAssert.element()
			.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER, "FOLLOWED SEARCH item container is missing")
			.withinParent(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER)
				.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_SRCH_TITLE, "FOLLOWED SEARCH title is missing");
		actions.element().click().by(follow.getFollowingsPageComponent().BTN_EDIT);
		uiChainAssert.element().withinParent(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER)
			.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_SRCH_MAIL_NOTIF, "FOLLOWED SEARCH Mail Notif icon missing")
			.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_SRCH_PHONE_NOTIF, "FOLLOWED SEARCH Phone Notif icon is missing")
			.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CHKBOX, "FOLLOWED SEARCH selection checkbox is missing");
		actions.element().click().by(follow.getFollowingsPageComponent().BTN_DONE);
		validateFeedData("SEARCHES");
		return this;
	}
	
	@Validator
	public FollowingsPageValidators validateFollowedSearchItemExists(String name){
		List<String> titles = actions.element().get().textFromAllElementsWithSameLocatorAsList(follow.getFollowingsPageComponent().FOLLOWED_ITM_SRCH_TITLE);
		uiChainAssert.collection()
			.contains(titles, name, "Search: ["+name+"] wasn't found in Followed Searches List!!!");
		return this;
	}
	
	@Validator
	public FollowingsPageValidators validateFollowingsMembersTab(){
		validateTabs().validateCommonElements();
		uiChainAssert.element()
			.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER, "FOLLOWED MEMBERS item container is missing")
			.withinParent(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER)
				.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_MEMBER_IMG, "FOLLOWED MEMBERS member-image is missing")
				.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_MEMBER_TITLE, "FOLLOWED MEMBERS title name is missing");
		actions.element().click().by(follow.getFollowingsPageComponent().BTN_EDIT);
		uiChainAssert.element().withinParent(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER)
			.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CHKBOX, "FOLLOWED MEMBERS selection checkbox is missing");
		actions.element().click().by(follow.getFollowingsPageComponent().BTN_DONE);
		validateFeedData("MEMBERS");
		return this;
	}
	
	@Validator
	public FollowingsPageValidators validateFollowedMemberExists(String name){
		List<String> titles = actions.element().withinParent(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER)
				.get().textFromAllElementsWithSameLocatorAsList(follow.getFollowingsPageComponent().FOLLOWED_ITM_MEMBER_TITLE);
		uiChainAssert.collection()
			.contains(titles, name, "Search: ["+name+"] wasn't found in Followed Searches List!!!");
		return this;
	}
	
	@Validator
	public FollowingsPageValidators validateFollowingsCollectionsTab(){
		validateTabs().validateCommonElements();
		uiChainAssert.element()
		.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER, "FOLLOWED COLLECTIONS item container is missing")
			.withinParent(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER)
				.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CLXN_IMAGES, "FOLLOWED COLLECTIONS images are missing")
				.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CLXN_DETAILS, "FOLLOWED COLLECTIONS details are missing")
				.withinParent(follow.getFollowingsPageComponent().FOLLOWED_ITM_CLXN_DETAILS)
					.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CLXN_DETAILS_TITLE, "FOLLOWED COLLECTIONS title is missing")
					.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CLXN_DETAILS_SUBTITLE, "FOLLOWED COLLECTIONS subtitle is missing");
		actions.element().click().by(follow.getFollowingsPageComponent().BTN_EDIT);
		uiChainAssert.element().withinParent(follow.getFollowingsPageComponent().FOLLOWED_ITM_CONTAINER)
			.present(follow.getFollowingsPageComponent().FOLLOWED_ITM_CHKBOX, "FOLLOWED COLLECTIONS selection checkbox is missing");
		actions.element().click().by(follow.getFollowingsPageComponent().BTN_DONE);
		validateFeedData("COLLECTIONS");
		return this;
	}
	
}
