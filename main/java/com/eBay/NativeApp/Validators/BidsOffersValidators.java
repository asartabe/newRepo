package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class BidsOffersValidators implements IValidator{
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HamburgerMenuPanel hamPage;
	
	private BidsOffersValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<BidsOffersValidators.Use> {
		public BidsOffersValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new BidsOffersValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public BidsOffersValidators setBidsOffersValidators(HamburgerMenuPanel hamPage){
		this.hamPage = hamPage;
		return this;
	}

	@Validator
	public BidsOffersValidators validateBidsOffersPageElements(){
		uiChainAssert.element()
		.present(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().BIDS_TAB, "Bids tab not Present")
		.present(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().OFFERS_TAB, "Offers tab not Present")
		.present(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().DIDNTWIN_TAB, "Didn't Win tab not Present");
		return this;
	}
	public BidsOffersValidators validateTileElements_BIDS(){
		uiChainAssert.element()
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().BID_SORT_LNK, "Sort Link not present");

		if(actions.element().present().now(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS))
			uiChainAssert.element()
			.withinParent(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS)
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().BID_COUNT, "Bid Count not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_PRICE, "Item Cost not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().IMAGE_IMAGE, "Item Image not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_TITLE, "Item Title not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_POSTAGE, "Item Postage not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_TIMELEFT, "Item time left not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().BID_STATUS, "Item Status not Present");
		else
			breezeReport.logRedStep("No Items in BID Container");
		return this;
	}
	public BidsOffersValidators validateSortOptions(){
		uiChainAssert.element()
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ENDING_SOONEST_SORT, "Ending Soonest Sort not present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().NEWEST_LISTING_SORT, "Newest Listing Sort not present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().PRICED_HIGHEST_SORT, "Price Highest Sort Link not present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().PRICED_LOWEST_SORT, "Price Lowest Sort Link not present")
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().SORT_CANCEL, "Sort Cancel Link not present");

		return this;
	}
	public BidsOffersValidators validateTileElements_OFFERS(){
		uiChainAssert.element()
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().BID_SORT_LNK, "Sort Link not present");

		if(actions.element().present().now(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS))
			uiChainAssert.element()
			.withinParent(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS)
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_PRICE, "Item Cost not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().IMAGE_IMAGE, "Item Image not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_TITLE, "Item Title not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_POSTAGE, "Item Postage not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_TIMELEFT, "Item time left not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().BID_STATUS, "Item Status not Present");
		else
			breezeReport.logRedStep("No Items in OFFERS Container");
		return this;
	}
	
	public BidsOffersValidators validateTileElements_DIDNTWIN(){
		uiChainAssert.element()
		.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().BID_SORT_LNK, "Sort Link not present");
		
		if(actions.element().present().now(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS))
			uiChainAssert.element()
			.withinParent(hamPage.getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ALL_ITEMS)
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().BID_COUNT, "Bid Count not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_PRICE, "Item Cost not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().IMAGE_IMAGE, "Item Image not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_TITLE, "Item Title not Present")
			.present(new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().getBidsOffersComponent().ITEM_TIMELEFT, "Item time left not Present");
		else
			breezeReport.logRedStep("No Items in DIDNT WIN Container");
		return this;
	}
}
