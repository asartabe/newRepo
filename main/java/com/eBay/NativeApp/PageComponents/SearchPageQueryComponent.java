package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.SearchPageQueryComponentLocators;
import com.ebay.testinfrastructure.webautil.actions.DeviceAction.Keys;

public class SearchPageQueryComponent extends SearchPageQueryComponentLocators{

	public SearchPageQueryComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public SearchPageQueryComponent createSearch(String keyword, boolean sellerSearch){
		if(sellerSearch)
			actions.element().textBox().sendKeys(SRCH_TOP_INPUT_KW, "seller:"+keyword);
		else
			actions.element().textBox().sendKeys(SRCH_TOP_INPUT_KW, keyword);
		
		//CustomWaitUtils.waitForSeconds(5);
		actions.device().sendKeyEvent(Keys.ANDROID_ENTER);
		
		return this;
	}
	
	public RecentTab getRecentTabActions(){
		return new RecentTab();
	}
	
	public FollowingTab getFollowingTabActions(){
		return new FollowingTab();
	}
	
	public class RecentTab{
		
		public RecentTab(){
			actions.element().click().by(TAB_RECENT);
		}
		
		public SearchPageQueryComponent clearRecentSearches(){
			if(actions.element().present().now(RECENT_CLEAR))
				actions.element().click().by(RECENT_CLEAR);
			return new SearchPageQueryComponent(driver);
		}
		
		public SearchPageQueryComponent clickRecentEntryWithText(String text){
			List<WebElement> recEntries = actions.element().get().allWebElementsWithSameLocator(RECENT_SRCH_ENTRIES);
			for (WebElement entry : recEntries) {
				if(CustomTouchUtils.scrollToElement(actions, entry, 2) && actions.element().get().text(entry).contains(text)){
					actions.element().click().webElement(entry);
					break;
				}
			}
			return new SearchPageQueryComponent(driver);
		}
		
	}
	
	public class FollowingTab{
		
		public FollowingTab(){
			actions.element().click().by(TAB_FOLLOWING);
		}
		
		public SearchPageQueryComponent clickSeeAllSearches(){
			if(actions.element().present().now(SEE_ALL_FOLLOWED_SRCH))
				actions.element().click().by(SEE_ALL_FOLLOWED_SRCH);
			return new SearchPageQueryComponent(driver);
		}
		
		public SearchPageQueryComponent clickSeeAllMembers(){
			if(actions.element().present().now(SEE_ALL_FOLLOWED_MEM))
				actions.element().click().by(SEE_ALL_FOLLOWED_MEM);
			return new SearchPageQueryComponent(driver);
		}
		
		public SearchPageQueryComponent clickFollowedEntryWithText(String text){
			List<WebElement> follEntries = actions.element().get().allWebElementsWithSameLocator(FOLLOWED_ENTRIES);
			for (WebElement entry : follEntries) {
				if(CustomTouchUtils.scrollToElement(actions, entry, 2) && actions.element().get().text(entry).contains(text)){
					actions.element().click().webElement(entry);
					break;
				}
			}
			return new SearchPageQueryComponent(driver);
		}
		
	}
	
}
