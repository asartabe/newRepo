package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Enums.SellContainerEnums.SellContainerFilters;
import com.eBay.NativeApp.Pages.SellingPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class SellingContainerValidators implements IValidator{
	
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	SellingPage sellPage;
	
	private SellingContainerValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<SellingContainerValidators.Use> {
		public SellingContainerValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new SellingContainerValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public SellingContainerValidators setSellingPage(SellingPage sellPage){
		this.sellPage = sellPage;
		return this;
	}
	
	private SellingContainerValidators checkContainerTabs(){
		uiChainAssert.element()
			.present(sellPage.getSellingContainersComponent().TAB_ACTIVE, "ACTIVE Tab is missing")
			.present(sellPage.getSellingContainersComponent().TAB_SOLD, "SOLD Tab is missing")
			.present(sellPage.getSellingContainersComponent().TAB_UNSOLD, "UNSOLD Tab is missing");
		return this;
	}
	
	@Validator
	public SellingContainerValidators validateSellActiveContainer(){
		checkContainerTabs();
		uiChainAssert.element()
			.present(sellPage.getSellingContainersComponent().FILTER_BTN, "ACTIVE Container: FILTER Button is missing")
			.present(sellPage.getSellingContainersComponent().ITEM_CONTAINER, "ACTIVE Container: Item Containers are missing")
			.withinParent(sellPage.getSellingContainersComponent().ITEM_CONTAINER)
				.present(sellPage.getSellingContainersComponent().ITM_IMAGE, "ACTIVE Container: Item Image is missing")
				.present(sellPage.getSellingContainersComponent().ITM_PRICE, "ACTIVE Container: Item Price details are missing")
				.present(sellPage.getSellingContainersComponent().ACTIVE_ITM_TITLE, " ACTIVE Container: Item Title is missing")
				.present(sellPage.getSellingContainersComponent().ACTIVE_ITM_TIMELEFT, "ACTIVE Container: Item Time Left details are missing")
				.present(sellPage.getSellingContainersComponent().ACTIVE_ITM_WATCHER, "ACTIVE Container: Item Watcher count is missing");
		return this;
	}
	
	@Validator
	public SellingContainerValidators validateFilterHeaderText(SellContainerFilters filter){
		if(!filter.equals(SellContainerFilters.ALL)){
			uiChainAssert.element()
				.present(sellPage.getSellingContainersComponent().FILTER_HDR_CONTAINER, "Filter Header is missing")
				.withinParent(sellPage.getSellingContainersComponent().FILTER_HDR_CONTAINER)
				.attributeValueMatches(sellPage.getSellingContainersComponent().FILTER_HDR_TEXT, "text", filter.getValue(), "Filter Header Text doesn't match as expected.");
		}
		return this;
	}
	
	@Validator
	public SellingContainerValidators validateBidCount(boolean presence){
		if(actions.element().present().byCustomPolling(sellPage.getSellingContainersComponent().ITEM_CONTAINER, 5)){
			if(presence)
				uiChainAssert.element()
				.withinParent(sellPage.getSellingContainersComponent().ITEM_CONTAINER)
				.present(sellPage.getSellingContainersComponent().ACTIVE_BID_COUNT, "ACTIVE Container: Item Bid Count is missing with AUCTIONS Filter applied");
			else
				uiChainAssert.element()
				.withinParent(sellPage.getSellingContainersComponent().ITEM_CONTAINER)
				.notPresent(sellPage.getSellingContainersComponent().ACTIVE_BID_COUNT, "ACTIVE Container: Item Bid Count is present with FIXEDPRICE Filter applied");
		}
		return this;
	}
	
	@Validator
	public SellingContainerValidators validateSellSoldContainer(){
		checkContainerTabs();
		uiChainAssert.element()
			.present(sellPage.getSellingContainersComponent().FILTER_BTN, "SOLD Container: FILTER Button is missing")
			.present(sellPage.getSellingContainersComponent().EDIT_BTN, "SOLD Container: EDIT Button is missing")
			.withinParent(sellPage.getSellingContainersComponent().ITEM_CONTAINER)
				.present(sellPage.getSellingContainersComponent().ITM_IMAGE, "SOLD Container: Item Image is missing")
				.present(sellPage.getSellingContainersComponent().ITM_PRICE, "SOLD Container: Item Price details are missing")
				.present(sellPage.getSellingContainersComponent().SOLD_ITM_TITLE, "SOLD Container: Item Title missing")
				.present(sellPage.getSellingContainersComponent().SOLD_ITM_POSTAGE, "SOLD Container: Item Postage details are missing")
				.present(sellPage.getSellingContainersComponent().SOLD_ITM_STATUS, "SOLD Container: Item Sold Status is missing")
				.present(sellPage.getSellingContainersComponent().SOLD_ITM_BUYER, "SOLD Container: Item Buyer name missing")
				.present(sellPage.getSellingContainersComponent().SOLD_ITM_SELLDATE, "SOLD Container: Item Sold Date is missing");
		return this;
	}
	
	@Validator
	public SellingContainerValidators validateSellUnsoldContainer(){
		checkContainerTabs();
		uiChainAssert.element()
			.present(sellPage.getSellingContainersComponent().EDIT_BTN, "UNSOLD Container: EDIT Button is missing")
			.withinParent(sellPage.getSellingContainersComponent().ITEM_CONTAINER)
				.present(sellPage.getSellingContainersComponent().ITM_IMAGE, "UNSOLD Container: Item Image is missing")
				.present(sellPage.getSellingContainersComponent().ITM_PRICE, "UNSOLD Container: Item Price details are missing")
				.present(sellPage.getSellingContainersComponent().UNSOLD_ITM_TITLE, "UNSOLD Container: Item Title is missing")
				.present(sellPage.getSellingContainersComponent().UNSOLD_ITM_POSTAGE, "UNSOLD Container: Item Postage details are missing")
				.present(sellPage.getSellingContainersComponent().UNSOLD_ITM_ENDDATE, "UNSOLD Container: Item End Date is missing")
				.present(sellPage.getSellingContainersComponent().UNSOLD_ITM_WATCHER, "UNSOLD Container: Item Watcher count is missing");
		return this;
	}
	
	@Validator
	public SellingContainerValidators validateDraftContainer(){
		uiChainAssert.element()
			.present(sellPage.getSellingDraftsComponent().EDIT_BTN, "EDIT Button is missing")
			.present(sellPage.getSellingDraftsComponent().ITM_CONTAINER, "Item Container is missing")
			.withinParent(sellPage.getSellingDraftsComponent().ITM_CONTAINER)
				.present(sellPage.getSellingDraftsComponent().ITM_IMAGE, "Item image is missing");
		return this;
	}
	
	@Validator
	public SellingContainerValidators validateSellingScheduledContainer(){
		uiChainAssert.element()
			.present(sellPage.getSellingScheduledContainerComponent().ITM_CONTAINER, "Item Cell is missing")
			.withinParent(sellPage.getSellingScheduledContainerComponent().ITM_CONTAINER)
				.present(sellPage.getSellingScheduledContainerComponent().ITM_IMG, "Item image is missing")
				.present(sellPage.getSellingScheduledContainerComponent().ITM_TITLE, "Item title is missing")
				.present(sellPage.getSellingScheduledContainerComponent().ITM_PRICE, "item price is missing")
				.present(sellPage.getSellingScheduledContainerComponent().ITM_GOLIVE_DATE, "Item Go-Live Date is missing")
				.present(sellPage.getSellingScheduledContainerComponent().ITM_GOLIVE_TIME, "item Go-Live Time is missing");
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
