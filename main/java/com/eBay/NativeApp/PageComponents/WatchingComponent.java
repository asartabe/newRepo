package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Enums.ItemsToSearch;
import com.eBay.NativeApp.Flows.SearchFlows;
import com.eBay.NativeApp.Locators.WatchingLocators;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.ebay.testinfrastructure.params.TestParams;

public class WatchingComponent extends WatchingLocators{

	public WatchingComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private WatchingComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}
	public boolean clickActiveTab(){
		this.clickThisElement(ACTIVE_TAB);
		if(actions.element().present().byPolling(FIRST_ITEM))
			return true;
		else return false;
	}
	
	public boolean clickEndedTab(){
		this.clickThisElement(ENDED_TAB);
		if(actions.element().present().byPolling(FIRST_ITEM))
			return true;
		else return false;
	}
	public WatchingComponent clickEditTab(){
		this.clickThisElement(EDIT_LNK);
		return this;
	}
	public WatchingComponent clickSortLink(){
		this.clickThisElement(SORT_LINK);
		return this;
	}

	public WatchingComponent deleteTwoItems(){
		if(actions.element().get().allWebElementsWithSameLocator(ITEM_CHECKBOX).size() > 2){
			actions.element().click().oneFromManyWithSameLocator(ITEM_CHECKBOX, 0);
			actions.element().click().oneFromManyWithSameLocator(ITEM_CHECKBOX, 1);
		}
		else{
			this.clickThisElement(CANCEL_ITEM);
			System.out.println("No items are Present to be Deleted");
		}
		return this;
	}
	public WatchingComponent clickCancelSort(){
		this.clickThisElement(SORT_CANCEL);
		return this;
	}
	
	public static String expectedTitle = new String();
	
	public WatchingComponent WatchAnItem(){
		/*new HamburgerMenuFlows(driver, HamburgerMenuOptions.HOME).openMenuOption();*/
		SearchFlows.searchFor(ItemsToSearch.KeyWord.IPHONE.getKeyWord(), false);
		
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU")){
			actions.element().click().oneFromManyWithSameLocator(new SearchResultsPage(driver).getSRPResultsComponent().WATCH_ACTION_BTN, 0);
			actions.element().click().by(new SearchResultsPage(driver).getSRPResultsComponent().WATCH_LNK);
		}
		
		ViewItemPage viPage = new ViewItemPage(driver);
		if(viPage.getViewItemPageComponent().checkIfMSKU())
			viPage.getViewItemPageComponent().selectMSKUOptions(true);
		
		actions.element().click().oneFromManyWithSameLocator(new SearchResultsPage(driver).getSRPResultsComponent().SRCH_RESULTS, 0);
		
		if(!TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU"))
			viPage.getViewItemPageComponent().getBuyerViewItemPageActions().watchItem();
		
		if(CustomWaitUtils.waitForElement(viPage.getViewItemPageComponent().ITM_TITLE))
			expectedTitle = actions.element().get().text(viPage.getViewItemPageComponent().ITM_TITLE, ""); 
		
		return this;
	}
	
	public String getfirstWatchItemTitle(){
		WebElement parent = actions.element().get().allWebElementsWithSameLocator(ALL_ITEMS).get(0);
		if(actions.element().withinParent(parent).present().byPolling(ITEM_MSKU_TITLE))
			return  actions.element().withinParent(parent).get().text(ITEM_MSKU_TITLE, "");
		else return actions.element().withinParent(parent).get().text(ITEM_TITLE, "");
		
		/*List<WebElement> lst = driver.findElements(ITEM_TITLE);
        String Watch_ItemTitle=lst.get(0).getText();		
		return Watch_ItemTitle;*/
	}
}
