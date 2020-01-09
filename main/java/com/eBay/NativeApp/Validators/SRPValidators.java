package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.Commons.SearchRefinementType;
import com.eBay.NativeApp.Commons.SearchRefinementType.BuyingFormat;
import com.eBay.NativeApp.Commons.SearchRefinementType.ItemLocation;
import com.eBay.NativeApp.Commons.SearchRefinementType.View;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.NumberUtils;
import com.eBay.NativeApp.Enums.ICDFeatures;
import com.eBay.NativeApp.Flows.UpdateDCS;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class SRPValidators implements IValidator{

	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	SearchResultsPage srp;
	
	private SRPValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<SRPValidators.Use> {
		public SRPValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new SRPValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public SRPValidators setSearchResultsPage(SearchResultsPage srp){
		this.srp = srp;
		return this;
	}
	
	@Validator
	public SRPValidators validateSRPHeaders(){
		uiChainAssert.element()
			.present(srp.getSRPHeaderComponent().FOLLOW_BTN, "FOLLOW_BTN is missing")
			.present(srp.getSRPHeaderComponent().SORT_BTN, "SORT_BTN is missing")
			.present(srp.getSRPHeaderComponent().FILTER_BTN, "FILTER_BTN is missing");
		return this;
	}
	
	@Validator
	public SRPValidators validateSRPItemContents(View viewType){
		uiChainAssert.element()
			.present(srp.getSRPResultsComponent().SRCH_RESULTS, "SEARCH RESULT Items are present");
		uiChainAssert.element()
		.withinParent(actions.element().get().allWebElementsWithSameLocator(srp.getSRPResultsComponent().SRCH_RESULTS).get(0))
			.present(srp.getSRPResultsComponent().SRP_ITM_IMG, "ITEM_IMAGE is missing")
			.present(srp.getSRPResultsComponent().SRP_ITM_TITLE, "ITEM_TITLE is missing")
			.present(srp.getSRPResultsComponent().SRP_ITM_PRICE, "ITEM_PRICE is missing");

		if(viewType.equals(View.LIST)){
			uiChainAssert.element()
				.withinParent(actions.element().get().allWebElementsWithSameLocator(srp.getSRPResultsComponent().SRCH_RESULTS).get(0))
					.present(srp.getSRPResultsComponent().SRP_ITM_POSTAGEPRICE, "ITEM_POSTAGE_PRICE is missing");
		}
		return this;
	}
	
	private static double value1 = 0.00, value2 = 0.00;
	private String getTextFromElement(List<WebElement> parent, int index, By child){
		String text = new String();
		
		if(actions.element().withinParent(parent.get(index)).present().now(child)){
			text = actions.element().withinParent(parent.get(index)).get().text(child, "Element ["+child.toString()+"] NOT_FOUND for Item Number: "+index+1);
			if(text.contains("FAST 'N FREE") || text.contains("Free Postage") || text.contains("Free"))
				text = "0.00";
			if(child.toString().equals(srp.getSRPResultsComponent().SRP_ITM_TIMELEFT.toString()))
				text = convertTimeText(text);
		}
		return text;
	}
	
	private void getPriceValues(){
		List<WebElement> results = actions.element().get().allWebElementsWithSameLocator(srp.getSRPResultsComponent().SRCH_RESULTS);
		int index = 0;
		if(results.size() < 2){
			CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
			validateSRPItemsSortedByHighestPrice();
		}
		if(results.size() > 3)
			index=1;
		
		value1 = Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index, srp.getSRPResultsComponent().SRP_ITM_PRICE))) +
					Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index, srp.getSRPResultsComponent().SRP_ITM_POSTAGEPRICE)));
		value2 = Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index+1, srp.getSRPResultsComponent().SRP_ITM_PRICE))) +
					Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index+1, srp.getSRPResultsComponent().SRP_ITM_POSTAGEPRICE)));
	}
	@Validator
	public SRPValidators validateSRPItemsSortedByHighestPrice(){
		getPriceValues();
		uiChainAssert.numeric()
			.firstGreaterThanOrEqualsSecond(value1, value2, "SORT Applied: Price_Highest_First - Item-2 Total Price is Higher than 1st");
		
		return this;
	}
	
	@Validator
	public SRPValidators validateSRPItemsSortedByLowestPrice(){
		getPriceValues();
		uiChainAssert.numeric()
			.firstGreaterThanOrEqualsSecond(value2, value1, "SORT Applied: Price_Lowest_First - Item-1 Total Price is Higher than 2nd");
		
		return this;
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
	private void getTimeOrDistanceValues(By forElement){
		List<WebElement> results = actions.element().get().allWebElementsWithSameLocator(srp.getSRPResultsComponent().SRCH_RESULTS);
		int index = 0;
		if(results.size() < 2){
			CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.DOWN);
			validateSRPItemsSortedByHighestPrice();
		}
		if(results.size() > 3)
			index=1;
		
		value1 = Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index, forElement)));
		value2 = Double.parseDouble(NumberUtils.extractNumberFromString(getTextFromElement(results, index+1, forElement)));
		
	}
	@Validator
	public SRPValidators validateSRPItemsSortedByEndingSoon(){
		getTimeOrDistanceValues(srp.getSRPResultsComponent().SRP_ITM_TIMELEFT);
		uiChainAssert.numeric()
			.firstGreaterThanOrEqualsSecond(value2, value1, "SORT Applied: Ending Soon - Item-1 End Time is Higher than 2nd");
		return this;
	}
	
	@Validator
	public SRPValidators validateSRPItemsSortedByNearestFirst(){
		getTimeOrDistanceValues(srp.getSRPResultsComponent().SRP_ITM_DISTANCE);
		uiChainAssert.numeric()
			.firstGreaterThanOrEqualsSecond(value2, value1, "SORT Applied: Nearest First - Item-1 Distance is Higher than 2nd");
		return this;
	}
	
	@Validator
	public SRPValidators validateItemInfoDisplayed(BuyingFormat format){
		this.validateSRPItemContents(View.LIST);
		
		if(format.equals(BuyingFormat.AUCTION)){
			uiChainAssert.element()
				.withinParent(actions.element().get().allWebElementsWithSameLocator(srp.getSRPResultsComponent().SRCH_RESULTS).get(0))
					.present(srp.getSRPResultsComponent().SRP_ITM_BIDCOUNT, "BID_COUNT is missing")
					.present(srp.getSRPResultsComponent().SRP_ITM_TIMELEFT, "Time Left to End is missing");
			
			if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, srp.getSRPResultsComponent().SRP_ITM_ORBUYITNOW))
				new ReportLogger().logBoldStep("AUCTION + BIN Item was Found!!!");
			else
				new ReportLogger().logRedStep("AUCTION + BIN Item was Found!!!");
			
		}else if(format.equals(BuyingFormat.BUYITNOW)){
			uiChainAssert.element()
				.withinParent(actions.element().get().allWebElementsWithSameLocator(srp.getSRPResultsComponent().SRCH_RESULTS).get(0))
					.notPresent(srp.getSRPResultsComponent().SRP_ITM_BIDCOUNT, "BID_COUNT is present with BIN Filter");
		}else if(format.equals(BuyingFormat.BESTOFFER)){
			uiChainAssert.element()
				.withinParent(actions.element().get().allWebElementsWithSameLocator(srp.getSRPResultsComponent().SRCH_RESULTS).get(0))
					.present(srp.getSRPResultsComponent().SRP_ITM_ORBESTOFFER, "BEST_OFFER Label is missing");
		}
		
		return this;
	}
	
	@Validator
	public SRPValidators validateLockDisplayedForBuyingFormat(BuyingFormat format){
		if(UpdateDCS.isDCSEnabled()){
			srp.getSRPHeaderComponent().clickFilterBtn().getRefinementPanel(false).openBuyingFormatMenu();
			switch (format) {
			case AUCTION:
				uiChainAssert.element()
				.present(srp.getSRPHeaderComponent().getRefinementPanel(false).LOCK_BUY_BID, "");
				break;
			case BUYITNOW:
				uiChainAssert.element()
				.present(srp.getSRPHeaderComponent().getRefinementPanel(false).LOCK_BUY_BIN, "");
				break;
			case BESTOFFER:
				uiChainAssert.element()
				.present(srp.getSRPHeaderComponent().getRefinementPanel(false).LOCK_BUY_BO, "");
				break;
			default:
				break;
			}
			srp.getSRPHeaderComponent().getRefinementPanel(false).saveRefinements();
		}
		return this;
	}
	
	@Validator
	public SRPValidators validateItemLocationLockDisplayed(ItemLocation location){
		srp.getSRPHeaderComponent().getRefinementPanel(true).openItemLocationMenu();
		switch (location) {
		case AUSTRALIA_ONLY:
			uiChainAssert.element()
				.present(srp.getSRPHeaderComponent().getRefinementPanel(false).LOCK_LOCATION_AUONLY, "");
			break;
		case WORLDWIDE:
			uiChainAssert.element()
				.present(srp.getSRPHeaderComponent().getRefinementPanel(false).LOCK_LOCATION_WORLDWIDE, "");
			break;
		default:
			break;
		}
		srp.getSRPHeaderComponent().getRefinementPanel(false).saveRefinements();
		return this;
	}
	
	@Validator
	public SRPValidators validatePriceWithinRange(Double minPrice, Double maxPrice){
		this.getPriceValues();
		uiChainAssert.numeric()
			.firstGreaterThanOrEqualsSecond(value1, minPrice, "")
			.firstGreaterThanOrEqualsSecond(value2, minPrice, "")
			.firstGreaterThanOrEqualsSecond(maxPrice, value1, "")
			.firstGreaterThanOrEqualsSecond(maxPrice, value2, "");
		return this;
	}
	
	@Validator 
	public SRPValidators validateCnCLabel(){
		uiChainAssert.element()
			.textContains(srp.getSRPResultsComponent().SRP_ITM_EDD, "Click & Collect", "Click & Collect Labelling is missing!");
		return this;
	}
	
	@Validator
	public SRPValidators validateViewIs(View viewType){
		srp.getSRPHeaderComponent().clickFilterBtn();
		switch (viewType) {
		case LIST:
			uiChainAssert.element()
				.attributeValueMatches(srp.getSRPHeaderComponent().getRefinementPanel(false).VIEW_ASLIST, "checked", "true", "LIST_ViewType is not selected");
			break;
		case GRID:
			uiChainAssert.element()
				.attributeValueMatches(srp.getSRPHeaderComponent().getRefinementPanel(false).VIEW_ASGRID, "checked", "true", "GRID_ViewType is not selected");
			break;
		default:
			break;
		}
		srp.getSRPHeaderComponent().getRefinementPanel(false).saveRefinements();
		return this;
	}
	
	@Validator
	public SRPValidators validateSMEOfferItemSRP(){
		uiChainAssert.element()
			.present(srp.getSRPResultsComponent().SME_PANEL, "SME Panel on SRP is missing")
				.withinParent(srp.getSRPResultsComponent().SME_PANEL)
					.present(srp.getSRPResultsComponent().SME_PROMO_TITLE, "SME Promo Title is missing")
					.present(srp.getSRPResultsComponent().SME_PROMO_SUBTITLE, "SME Promo Subtitle is missing");
		uiChainAssert.element()
			.present(srp.getSRPResultsComponent().SRCH_RESULTS, "SME Items container")
				.withinParent(srp.getSRPResultsComponent().SRCH_RESULTS)
					.present(srp.getSRPResultsComponent().SRP_ITM_IMG, "SME Item Image is missing")
					.present(srp.getSRPResultsComponent().SRP_ITM_TITLE, "SME Item Title is missing")
					.present(srp.getSRPResultsComponent().SRP_ITM_PRICE, "SME Item Price is missing");
		return this;
	}
	
	@Validator 
	public boolean validateICDItems(ICDFeatures feature){
		boolean found = false;
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, feature.getLocator(), 5)){
			if(feature.equals(ICDFeatures.FAST_N_FREE)){
				if(actions.element().notPresent(srp.getSRPResultsComponent().getICDElements().ICD_POST_ESTDEL, 5))
					uiChainAssert.generic().fail("Estimated Delivery missing with "+feature.getDetails());
			}
			else if(feature.equals(ICDFeatures.PROD_RATINGS)){
				if(actions.element().notPresent(srp.getSRPResultsComponent().getICDElements().ICD_PROD_RVW_STARS, 5) &&
						actions.element().notPresent(srp.getSRPResultsComponent().getICDElements().ICD_PROD_RVW_COUNT, 5))
					uiChainAssert.generic().fail("Review Stars/Count missing for "+feature.getDetails());
			}
			found = true;
		}
		return found;
	}
	
	@Validator
	public SRPValidators validateDealsAndSavingsFilter(boolean mode){
		By dealSwitch = By.xpath(SearchRefinementType.GlobalFilterSwitches.DEALS_SAVINGS.getLocator());
		String expectedVal = mode?"ON":"OFF";
		
		srp.getSRPHeaderComponent().getRefinementPanel(true);
		uiChainAssert.generic()
			.assertTrue(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, dealSwitch, 4), "[DEALS AND SAVINGS] Filter Switch was not found!");
		uiChainAssert.element()
			.attributeValueContains(dealSwitch, "text", expectedVal, "[DEALS AND SAVINGS] state is not as expected.");
		srp.getSRPHeaderComponent().getRefinementPanel(false).clickShowLess().saveRefinements();
		return this;
	}
	
	@Validator
	public SRPValidators validateMerchantPromotions(){
		uiChainAssert.element()
		.present(srp.getSRPResultsComponent().PROMO_LABEL, "Promotion label absent")
		.present(srp.getSRPResultsComponent().PROMO_LOGO, "Promotion logo absent")
		.present(srp.getSRPResultsComponent().PROMO_TEXT, "Promotion text absent")
		.present(srp.getSRPResultsComponent().PROMO_IMAGE, "Promotion image absent");
		
		srp.getSRPResultsComponent().clickMerchantPromotion();
		
		uiChainAssert.element()
		.present(srp.getSRPResultsComponent().SALES_EVENTS_TITLE, "Page opened has errors");
		return this;
		
	}
	@Validator
	public SRPValidators validateeGDText(){
		uiChainAssert.element()
		.present(srp.getSRPResultsComponent().EGD_TEXT, "Guaranteed Delivery text absent");
		return this;
	
	}
}
