package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Locators.FollowingsPageComponentLocators;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;

public class FollowingsPageComponent extends FollowingsPageComponentLocators{

	public FollowingsPageComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public FollowingsPageComponent showFollowedSearches(){
		actions.element().click().by(TAB_SEARCHES);
		return this;
	}
	
	public FollowingsPageComponent showFollowedMembers(){
		actions.element().click().by(TAB_MEMBERS);
		return this;
	}
	
	public FollowingsPageComponent showFollowedCollections(){
		actions.element().click().by(TAB_COLLECTIONS);
		return this;
	}
	
	public FollowingsPageComponent removeFollowedItems(){
		actions.element().click().by(BTN_EDIT);
		List<WebElement> items = actions.element().get().allWebElementsWithSameLocator(FOLLOWED_ITM_CHKBOX);
		actions.element().click().multipleElements(items);
		actions.element().click().by(BTN_DELETE);
		actions.element().click().by(REMOVE_YES);
		return this;
	}
	
	public FollowingsPageComponent removeSpecificSearchItem(String name){
		actions.element().click().by(BTN_EDIT);
		boolean flag = true;
		for(int i=0; i<3 && flag; i++){
			List<WebElement> items = actions.element().get().allWebElementsWithSameLocator(FOLLOWED_ITM_CONTAINER);
			for (WebElement item : items) {
				if(actions.element().withinParent(item).get().text(FOLLOWED_ITM_SRCH_TITLE, "").equalsIgnoreCase(name)){
					actions.element().withinParent(item).click().by(FOLLOWED_ITM_CHKBOX);
					flag = false;
					break;
				}
			}
			if(flag)
				CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 3, ScrollDirection.DOWN);
		}
		actions.element().click().by(BTN_DELETE);
		actions.element().click().by(REMOVE_YES);
		return this;
	}
	
	private FollowingsPageComponent sort(int i){
		actions.element().click().by(BTN_SORT);
		switch (i) {
		case 1:	actions.element().click().by(SORT_OPT_BYNAME);
			break;
		case 2:	actions.element().click().by(SORT_OPT_DATEADDED);
			break;
		case 3:	actions.element().click().by(SORT_OPT_LASTVIEWED);
			break;
		default:
			break;
		}
		return this;
	}
	
	public FollowingsPageComponent sortFollowedItemsByName(){
		this.sort(1);
		return this;
	}
	
	public FollowingsPageComponent sortFollowedItemsByDateAdded(){
		this.sort(2);
		return this;
	}
	
	public FollowingsPageComponent sortFollowedItemsByLastViewed(){
		this.sort(3);
		return this;
	}
	
	public FollowingsPageComponent clickToOpenFollowedSearch(String text){
		actions.element().click().oneFromManyWithSameLocator(FOLLOWED_ITM_SRCH_TITLE, text);
		return this;
	}
	
}
