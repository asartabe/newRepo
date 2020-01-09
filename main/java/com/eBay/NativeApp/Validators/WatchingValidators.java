package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.NumberUtils;
import com.eBay.NativeApp.Flows.UpdateDCS;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class WatchingValidators implements IValidator{
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HamburgerMenuPanel hamPage;
	private WatchingValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<WatchingValidators.Use> {
		public WatchingValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new WatchingValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public WatchingValidators setWatchingValidators(HamburgerMenuPanel hamPage){
		this.hamPage = hamPage;
		return this;
	}
	@Validator
	public WatchingValidators validateWatchingPage(){
		uiChainAssert.element()
		.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ACTIVE_TAB, "Active Tab not Present")
		.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ENDED_TAB, "Ended Tab not Present")
		.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().EDIT_LNK, "Edit Link not Present")
		/*.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().SORT_LNK, "Sort Link not Present")*/;
		return this;
	}
	
	@Validator
	public WatchingValidators validateWatchingItemSpecifications(){
		if(actions.element().present().byPolling(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().FIRST_ITEM)){
			uiChainAssert.element()
			.withinParent(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().FIRST_ITEM)
			.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().IMAGE_IMAGE, "Image not present")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_TITLE, "Item Title not present")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_PRICE, "Item price not present")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_POSTAGE, "Item Postage not present")
			.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_TIMELEFT, "Item Time Left not present");
		}
		else
			breezeReport.logRedStep("No items in Watching Container");
		return this;
	}
	
	@Validator
	public WatchingValidators validateSortOptions(){
		uiChainAssert.element()
		.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ENDING_SOONEST_FILTER, "Ended Soonest Filter not present")
		.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().NEWEST_LISTING_FILTER, "Newest Listings Filter not present")
		.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().PRICED_LOWEST_FILTER, "Priced Lowest Filter not present")
		.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().PRICED_HIGHEST_FILTER, "Priced Highest Filter not present")
		.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().SORT_CANCEL, "Cancel button in Sort not present");
		return this;
	}	
	
	@Validator
	public WatchingValidators validateCategoryCells(){
		if(UpdateDCS.isDCSEnabled())
			uiChainAssert.element()
				.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().WATCH_CAT_CONTAINER, "Category container section is missing")
				.withinParent(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().WATCH_CAT_CONTAINER)
				.present(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().WATCH_CAT_CONTAINER_CATTITLE, "Category cells are missing");
		return this;
	}
	
	@SuppressWarnings("static-access")
	@Validator
	public WatchingValidators validateWatchedItemsRecentlyAddedfilter(){
		uiChainAssert.string()
			.contains(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().expectedTitle, hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().getfirstWatchItemTitle(), "The Recently Added filter is not working As expected");
		return this;
	}
	
	@Validator
	public WatchingValidators validateWatchedItemsSortedByHighestPrice(){
		getPriceValues();
		uiChainAssert.numeric()
			.firstGreaterThanOrEqualsSecond(value1, value2, "SORT Applied: Price_Highest_First - Item-2 Total Price is Higher than 1st");
		
		return this;
	}
	@Validator
	public WatchingValidators validateWatchedItemsSortedByLowestPrice(){
		getPriceValues();
		uiChainAssert.numeric()
			.firstGreaterThanOrEqualsSecond(value2, value1, "SORT Applied: Price_Lowest_First - Item-1 Total Price is Higher than 2nd");
		
		return this;
	}
	@Validator
	public WatchingValidators validateWatchedItemsSortedByEndingSoon(){
		getTimeOrDistanceValues(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_TIMELEFT);
		uiChainAssert.numeric()
			.firstGreaterThanOrEqualsSecond(value2, value1, "SORT Applied: Ending Soon - Item-1 End Time is Higher than 2nd");
		return this;
	}
	
	private void getTimeOrDistanceValues(By forElement){
		List<WebElement> results = actions.element().get().allWebElementsWithSameLocator(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ALL_ITEMS);
		int index = 0;
		if(results.size() < 2)
			CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
		if(results.size() > 3)
			index=1;
		if(results.size() > 1){
			value1 = Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index, forElement)));
			value2 = Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index+1, forElement)));
		}
		else
			breezeReport.logRedStep("Not enough Items to compare Time/Distance...!!!");
	}
	private String convertTimeText(String text){
		String[] splits = text.split(" ");
		int h = 0, m = 0, s = 0;
		switch(splits.length){
		case 1:	//time is only left in seconds
				text = NumberUtils.extractNumberFromString(splits[0]);
				break;
				
		case 2:	//time is left in minutes & seconds
				m = Integer.parseInt(NumberUtils.extractNumberFromString(splits[0]))*60;
				s = Integer.parseInt(NumberUtils.extractNumberFromString(splits[1]));
				text = String.valueOf(m+s);
				break;
				
		case 3:	//time is in hours, minutes & seconds
				h = Integer.parseInt(NumberUtils.extractNumberFromString(splits[0]))*3600;
				m = Integer.parseInt(NumberUtils.extractNumberFromString(splits[1]))*60;
				s = Integer.parseInt(NumberUtils.extractNumberFromString(splits[2]));
				text = String.valueOf(h+m+s);
				break;
		}
		return text;
	}
	private static double value1 = 0.00, value2 = 0.00;

	private String getTextFromElement(List<WebElement> parent, int index, By child){
		String text = "0.00";
		
		if(actions.element().withinParent(parent.get(index)).present().now(child)){
			text = actions.element().withinParent(parent.get(index)).get().text(child, "Element ["+child.toString()+"] NOT_FOUND for Item Number: "+index+1);
			if(text.contains("FAST 'N FREE") || text.contains("Free Postage") || text.contains("Free"))
				text = "0.00";
			if(child.toString().equals(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_TIMELEFT.toString()))
				text = convertTimeText(text);
		}
		return text;
	}
	
	private void getPriceValues(){
		List<WebElement> results = actions.element().get().allWebElementsWithSameLocator(hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ALL_ITEMS);
		int index = 0;
		if(results.size() < 2)
			CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
		if(results.size() >= 3)
			index=1;
		
		if(results.size() > 1){
			value1 = Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index, hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_PRICE))) +
					Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index, hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_POSTAGE)));
			value2 = Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index+1, hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_PRICE))) +
					Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index+1, hamPage.getHamburgerMenuMyEbayComponent().getWatchingComponent().ITEM_POSTAGE)));
		}
		else
			breezeReport.logRedStep("Not enough Items to compare Prices...!!!");
	}
	

	
	
	

}
