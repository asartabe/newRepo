package com.eBay.NativeApp.Validators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.testdrivers.enums.Priority;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class ViewItemPageValidators implements IValidator{

	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;

	ViewItemPage viPage;
	
	private ViewItemPageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<ViewItemPageValidators.Use> {
		public ViewItemPageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new ViewItemPageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}
	
	public ViewItemPageValidators setViewItemPageObject(ViewItemPage viPage){
		this.viPage = viPage;
		return this;
	}
	
	@Validator(priority=Priority.P1)
	public ViewItemPageValidators checkBasicUIElements(){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().ITM_IMAGE, "ITEM_PHOTOS missing")
			.present(viPage.getViewItemPageComponent().ITM_TITLE, "ITEM_TITLE missing")
			.present(viPage.getViewItemPageComponent().ITM_PRICE, "ITEM_PRICE missing");
		
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU"))
			uiChainAssert.element()
			.withinParent(viPage.getViewItemPageComponent().ITM_HIGHLIGHTS)
				.present(viPage.getViewItemPageComponent().ITM_HIGHLIGHT_1, "")
				.present(viPage.getViewItemPageComponent().ITM_HIGHLIGHT_2, "");
		
		return this;
	}
	
	@Validator(priority=Priority.P1)
	public ViewItemPageValidators checkVISectionsAndOtherComponents(){
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU"))
			uiChainAssert.element().present(viPage.getViewItemPageComponent().ITM_ATC_BTN, "ADD_TO_CART_BTN missing");
			
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().ITM_WATCH_BTN, "WATCH_BTN missing")
			.present(viPage.getViewItemPageComponent().SEC_ITEM_SPECIFICS, "ITEM_SPECIFICS_Section is missing")
			.withinParent(viPage.getViewItemPageComponent().SEC_ITEM_SPECIFICS)
				.present(viPage.getViewItemPageComponent().SEC_ABOUT_THIS_ITEM, "ABOUT_THIS_ITEM_Header missing")
				.present(viPage.getViewItemPageComponent().ITM_DESCRIPTION_LNK, "ITM_DESCRIPTION_Link missing");
			
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SEC_SPR, "POSTAGE_PAYMENT_RETURN_Section missing")
			.withinParent(viPage.getViewItemPageComponent().SEC_SPR)
				.present(viPage.getViewItemPageComponent().SEC_SPR_HDR, "Postage, Returns & Payments Header is missing")
				.present(viPage.getViewItemPageComponent().ITM_SPR, "Details in PRP Section missing")
				.present(viPage.getViewItemPageComponent().ITM_SPR_MORE, "Link to More PRP Details is missing");
		
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU"))
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SEC_MORE_LIKE_THIS, "More Like This items are missing")
			.present(viPage.getViewItemPageComponent().ITM_MERCH_IMG, "More Like This - Merch Item Image is missing")
			.present(viPage.getViewItemPageComponent().ITM_MERCH_TXT, "More Like This - Merch Item Details is missing");
		
		uiChainAssert.element()	
			.present(viPage.getViewItemPageComponent().SEC_ABOUT_THE_SELLER, "ABOUT_SELLER_Section missing")
			.withinParent(viPage.getViewItemPageComponent().SEC_ABOUT_THE_SELLER)
				.present(viPage.getViewItemPageComponent().SEC_ABOUT_THE_SELLER_HDR, "About The Seller Header is missing")
				.present(viPage.getViewItemPageComponent().ITM_SELLER_MOREITEMS, "Link to Seller's more items is missing")
				.present(viPage.getViewItemPageComponent().ITM_SELLER_PROFILELNK, "Link to Seller's Profile Page is missing");
		
		if((TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU")) && actions.element().present().byCustomPolling(viPage.getViewItemPageComponent().SEC_RATINGS_REVIEWS, 5))
		{
			uiChainAssert.element()
				.withinParent(viPage.getViewItemPageComponent().SEC_RATINGS_REVIEWS)
					.present(viPage.getViewItemPageComponent().SEC_RnR_HDR, "Ratings Review section Header is missing")
					.present(viPage.getViewItemPageComponent().RnR_RATINGS_SUMMARY, "R&R Ratings Summary is missing")
					.present(viPage.getViewItemPageComponent().RnR_ASPECTS_CONTAINER, "R&R Aspects are missing")
					.present(viPage.getViewItemPageComponent().RnR_RELEVANT_RVWS, "R&R Relevant Reviews details missing");
		}
		
		return this;
	}
	
	@Validator(priority=Priority.P1)
	public ViewItemPageValidators validateViewItemUIElements(ItemType item){
		
		this.checkBasicUIElements();
		
		Double value = new Double(0.00);
		try{value = item.getBuyItNowPrice().getValue();}catch (Exception e) {value = 0.00;}
		
		if(item.getListingType().equals(ListingTypeCodeType.CHINESE)){
			uiChainAssert.element()
				.present(viPage.getViewItemPageComponent().ITM_PLACEBID_BTN, "PLACE_BID_BTN missing");
				if(value > 0)
				uiChainAssert.element()
					.present(viPage.getViewItemPageComponent().ITM_BIN_BTN, "BIN_BTN missing");
		}
		else if(item.getListingType().equals(ListingTypeCodeType.FIXED_PRICE_ITEM)){
			uiChainAssert.element()
				.present(viPage.getViewItemPageComponent().ITM_BIN_BTN, "BIN_BTN missing");
			if(item.getBestOfferDetails().isBestOfferEnabled()){
				uiChainAssert.element()
					.present(viPage.getViewItemPageComponent().ITM_MAKEOFFER_BTN, "MAKEOFFER_BTN missing");
			}
		}
		
		return this;
	}
	
	@Validator(priority=Priority.P1)
	public ViewItemPageValidators validatePostageReturnPaymentPageUI(){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SPR_ITM_HDR_PANEL, "SPR Page Item Details panel is missing")
			.withinParent(viPage.getViewItemPageComponent().SPR_ITM_HDR_PANEL)
				.present(viPage.getViewItemPageComponent().SPR_ITM_IMG, "SPR Item Image is missing")
				.present(viPage.getViewItemPageComponent().SPR_ITM_TITLE, "SPR Item Title is missing")
				.present(viPage.getViewItemPageComponent().SPR_ITM_PRICES, "SPR Item Prices are missing");
		
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SPR_POSTAGE_TITLE, "SPR Postage Title is missing")
			.present(viPage.getViewItemPageComponent().SPR_POSTAGE_DETAILS, "SPR Postage details are missing")
			.present(viPage.getViewItemPageComponent().SPR_RETURNS_TITLE, "SPR Returns Title is missing")
			.present(viPage.getViewItemPageComponent().SPR_RETURNS_DETAILS, "SPR Returns details are missing")
			.present(viPage.getViewItemPageComponent().SPR_PAYMENTS_TITLE, "SPR Payments Title is missing")
			.present(viPage.getViewItemPageComponent().SPR_PAYMENTS_DETAILS, "SPR Payments details are missing");
		
		return this;
	}
	
	@Validator(priority=Priority.P1)
	public ViewItemPageValidators validateItemTitle(ItemType item){
		uiChainAssert.string()
			.contains(item.getTitle(), actions.element().get().text(viPage.getViewItemPageComponent().ITM_TITLE, ""), "Title doesn't match");
		
		return this;
	}
	
	private ViewItemPageValidators validateSellerItemVI(String name){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SELLER_VIP_PAGE_HDR, "Seller VIP Header is missing")
			.textContains(viPage.getViewItemPageComponent().SELLER_VIP_PAGE_HDR, name, "Seller VIP Header is incorrect");
		return this;
	}
	
	private List<String> getSellerVIPKeyStatsNames(){
		List<WebElement> statKeys = actions.element().withinParent(viPage.getViewItemPageComponent().SELLER_VIP_STATS)
				.get().allWebElementsWithSameLocator(viPage.getViewItemPageComponent().SELLER_VIP_STAT_KEY);
		List<String> keyStrings = new ArrayList<>();
		for (WebElement statKey : statKeys) {
			keyStrings.add(actions.element().get().text(statKey));
		}
		return keyStrings;
	}
	
	@Validator
	public ViewItemPageValidators validateSellerActiveItemVI(ItemType item){
		validateSellerItemVI("Active listing");
		
		List<String> keyStrings = getSellerVIPKeyStatsNames();
		uiChainAssert.collection()
			.contains(keyStrings, "Start date", "ACTIVE_LISTING: Start Date is missing")
			.contains(keyStrings, "Views", "ACTIVE_LISTING: View count is missing")
			.contains(keyStrings, "Watchers", "ACTIVE_LISTING: Watcher count is missing");
		if(item.getListingType().equals(ListingTypeCodeType.AUCTION) && item.getListingType().equals(ListingTypeCodeType.CHINESE))
			uiChainAssert.collection()
				.contains(keyStrings, "Starting bid", "ACTIVE_LISTING: Starting Bid is missing")
				.contains(keyStrings, "Time left", "ACTIVE_LISTING: Time Left details are missing")
				.contains(keyStrings, "Bids", "ACTIVE_LISTING: Bid count is missing");
		else if(item.getListingType().equals(ListingTypeCodeType.FIXED_PRICE_ITEM))
			uiChainAssert.collection()
			.contains(keyStrings, "Buy It Now", "ACTIVE_LISTING: Buy It Now Price details is missing");
			
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateSellerEndedItemVI(){
		CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 2, ScrollDirection.UP);
		validateSellerItemVI("Sorry, this item did not sell");
		
		List<String> keyStrings = getSellerVIPKeyStatsNames();
		uiChainAssert.collection()
			.contains(keyStrings, "List date", "ENDED_LISTING: ")
			.contains(keyStrings, "End date", "ENDED_LISTING: ");
		
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateCnCLabelOnVIP(){
		uiChainAssert.element()
			.withinParent(viPage.getViewItemPageComponent().SEC_SPR)
				.withinParent(viPage.getViewItemPageComponent().ITM_SPR)
				.present(viPage.getViewItemPageComponent().ITM_CNC_LBL, "Click & Collect Label missing on VIP!");
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateCnCDetailsOnSPRPage(){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SPR_CnC_TITLE, "Collection near <POSTCODE> Header is missing!")
			.present(viPage.getViewItemPageComponent().SPR_CnC_DETAILS, "Click & Collect Details are missing!");
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validatePRPElements(){
		uiChainAssert.element()
			.present(viPage.getProductRelatedPageComponent().PRP_PRODUCT_RANK, "PRP Product Rank is missing" )
			.present(viPage.getProductRelatedPageComponent().PRP_MINI_TITLE, "PRP ITEM_TITLE is missing")
			.present(viPage.getProductRelatedPageComponent().PRP_MINI_RATING_BAR, "PRP ITEM_RATINGS are missing")
			.present(viPage.getProductRelatedPageComponent().PRP_BIG_IMG, "PRP ITEM_IMAGE is missing")
			.present(viPage.getProductRelatedPageComponent().PRP_ITM_PRICE, "PRP ITEM_PRICE is missing")
			.present(viPage.getProductRelatedPageComponent().PRP_ITM_POSTAGE_PRICE, "PRP ITEM_POSTAGE_PRICE is missing");
		
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateBPPonPRP(){
		uiChainAssert.element()
			.present(viPage.getProductRelatedPageComponent().BPP_ICON, "BPP icon is missing" )
			.present(viPage.getProductRelatedPageComponent().BPP_TEXT, "BPP text is missing");
		
		return this;
	}
	@Validator
	private ViewItemPageValidators validateMSKUOptions(){
		if(actions.element().present().now(viPage.getProductRelatedPageComponent().PRP_CHANGE_OPTIONS_BTN)){
			actions.element().click().by(viPage.getProductRelatedPageComponent().PRP_CHANGE_OPTIONS_BTN);
			uiChainAssert.element()
				.present(viPage.getProductRelatedPageComponent().ASPECTS_LIST, "Aspects List is not present")
				.present(viPage.getProductRelatedPageComponent().ASPECTS_DONE, "Aspects Done button is missing")
				.withinParent(viPage.getProductRelatedPageComponent().ASPECTS_LIST)
					.present(viPage.getProductRelatedPageComponent().ASPECT_NAME, "Aspects names are missing")
					.present(viPage.getProductRelatedPageComponent().ASPECT_CURRENT_VALUE, "Aspects current value is missing");
			actions.element().click().by(viPage.getProductRelatedPageComponent().ASPECTS_DONE);
		}
		else
			breezeReport.logRedStep("No MSKU options available for this item.");
		return this;
	}
	
	@Validator
	private ViewItemPageValidators validateThemes(){
		if(actions.element().present().now(viPage.getProductRelatedPageComponent().THEME_LAYOUT)){
			uiChainAssert.element()
				.withinParent(viPage.getProductRelatedPageComponent().THEME_LAYOUT)
				.present(viPage.getProductRelatedPageComponent().THEME_TABS, "Theme tabs are missing")
					.withinParent(viPage.getProductRelatedPageComponent().THEME_TABS)
						.present(viPage.getProductRelatedPageComponent().THEME_TAB_HDR, "Header for Theme is missing.")
						.present(viPage.getProductRelatedPageComponent().THEME_TAB_PRICE, "Price details for theme is missing.");
		}
		else
			breezeReport.logRedStep("No Themes available for this item.");
		return this;
	}
	
	@Validator
	private ViewItemPageValidators validateSimilarProducts(){
		if(CustomTouchUtils.scrollToElement(actions, viPage.getProductRelatedPageComponent().SIMILAR_PRODUCTS, 5)){
			uiChainAssert.element()
				.present(viPage.getProductRelatedPageComponent().SIMILAR_PROD_1, "Similar Product Tile1 is missing")
				.present(viPage.getProductRelatedPageComponent().SIMILAR_PROD_2, "Similar Product Tile2 is missing");
		}
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validatePRPSectionHeaders(){
		validateMSKUOptions().validateThemes().validateSimilarProducts();
		
		uiChainAssert.generic()
			.assertTrue(CustomTouchUtils.scrollToElement(actions, viPage.getProductRelatedPageComponent().PRP_ALL_LISTINGS, 5), "[All Listings for this Product] section wasn't found!")
			.assertTrue(CustomTouchUtils.scrollToElement(actions, viPage.getProductRelatedPageComponent().PRP_ABOUT_PRODUCT, 5), "[About this Product] section wasn't found!")
			.assertTrue(CustomTouchUtils.scrollToElement(actions, viPage.getProductRelatedPageComponent().PRP_RATING_REVIEWS, 5), "[Ratings and reviews] section wasn't found!")
			.assertTrue(CustomTouchUtils.scrollToElement(actions, viPage.getProductRelatedPageComponent().PRP_RELEVANT_REVIEWS, 5), "[Most relevant reviews] section wasn't found!")
			.assertTrue(CustomTouchUtils.scrollToElement(actions, viPage.getProductRelatedPageComponent().PRP_BESTSELLING_CAT, 5), "[BestSelling] section wasn't found")
			.assertTrue(CustomTouchUtils.scrollToElement(actions, viPage.getProductRelatedPageComponent().PRP_SAVEON, 5), "[Save On] section wasn't found");
		
		
		CustomTouchUtils.swipe(actions.touchScreen().getScreenCenter(), 10, ScrollDirection.UP);
		
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateCBTPricesOnVIP(){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().CBT_VI_PRICE, "CBT Converted prices are missing on VIP");
		
		viPage.getViewItemPageComponent().viewPostageReturnPaymentDetails();
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().CBT_SPR_PRICE, "CBT Converted Item Price missing in SPR Screen");
		if(!actions.element().withinParent(viPage.getViewItemPageComponent().SPR_ITM_PRICES)
				.get().text(By.id("com.ebay.mobile:id/shipping_textview"), "").equalsIgnoreCase("Free"))
			uiChainAssert.element()
				.present(viPage.getViewItemPageComponent().CBT_SPR_POSTAGE_PRICE, "CBT Converted Postage Price missing in SPR Screen");
		
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateRatingsAndReviewsOnVIP(){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SEC_RATINGS_REVIEWS, "Review & Ratings section is missing")
			.withinParent(viPage.getViewItemPageComponent().SEC_RATINGS_REVIEWS)
				.present(viPage.getViewItemPageComponent().SEC_RnR_HDR, "Review & Ratings header is missing")
				.present(viPage.getViewItemPageComponent().RnR_RATINGS_SUMMARY, "Review & Ratings Summary container is missing")
				.present(viPage.getViewItemPageComponent().RnR_ASPECTS_CONTAINER, "Review & Ratings Aspects container is missing")
				.present(viPage.getViewItemPageComponent().RnR_RELEVANT_RVWS, "Review & Ratings Relevant reviews container is missing")
				.present(viPage.getViewItemPageComponent().RnR_SEE_MORE_REVIEWS, "Review & Ratings Link to see more reviews is missing");
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateRatingsAndReviewsLandingPage(){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().PRVW_RATINGS_HDR, "RATINGS AND REVIEWS PAGE: Ratings Header is missing")
			/*.present(viPage.getViewItemPageComponent().PRVW_HISTOGRAM_CONTAINER, "RATINGS AND REVIEWS PAGE: Histogram container is missing")*/
			.present(viPage.getViewItemPageComponent().PRVW_RATING_SUMMARY_CONTAINER, "RATINGS AND REVIEWS PAGE: Rating Summary container is missing")
			.present(viPage.getViewItemPageComponent().PRVW_RATING_1STAR, "RATINGS AND REVIEWS PAGE: 1 Star Rating details")
			.present(viPage.getViewItemPageComponent().PRVW_RATING_2STAR, "RATINGS AND REVIEWS PAGE: 2 Star Rating details")
			.present(viPage.getViewItemPageComponent().PRVW_RATING_3STAR, "RATINGS AND REVIEWS PAGE: 3 Star Rating details")
			.present(viPage.getViewItemPageComponent().PRVW_RATING_4STAR, "RATINGS AND REVIEWS PAGE: 4 Star Rating details")
			.present(viPage.getViewItemPageComponent().PRVW_RATING_5STAR, "RATINGS AND REVIEWS PAGE: 5 Star Rating details")
			.present(viPage.getViewItemPageComponent().PRVW_ASPECTS_CONTAINER, "RATINGS AND REVIEWS PAGE: Aspects container is missing")
			.present(viPage.getViewItemPageComponent().PRVW_SORT_BTN, "RATINGS AND REVIEWS PAGE: Sort Button is missing");
		
		actions.element().click().by(viPage.getViewItemPageComponent().PRVW_SORT_BTN);
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().PRVW_SORT_OPT_MOSTRELEVANT, "RATINGS AND REVIEWS PAGE: Sort  is missing")
			.present(viPage.getViewItemPageComponent().PRVW_SORT_OPT_MOSTRECENT, "RATINGS AND REVIEWS PAGE: Sort  is missing")
			.present(viPage.getViewItemPageComponent().PRVW_SORT_OPT_RATE_HIGHESTFIRST, "RATINGS AND REVIEWS PAGE: Sort  is missing")
			.present(viPage.getViewItemPageComponent().PRVW_SORT_OPT_RATE_LOWESTFIRST, "RATINGS AND REVIEWS PAGE: Sort  is missing");
		actions.element().click().by(viPage.getViewItemPageComponent().PRVW_SORT_OPT_MOSTRELEVANT);
		
		if(actions.element().present().now(viPage.getViewItemPageComponent().PRVW_WRITE_REVIEW_CONTAINER))
		uiChainAssert.element()
			.withinParent(viPage.getViewItemPageComponent().PRVW_WRITE_REVIEW_CONTAINER)
				.present(viPage.getViewItemPageComponent().PRVW_WRITE_REVIEW_BTN, "RATINGS AND REVIEWS PAGE: Write-A-Review Button is missing");
		
		return this;
	}
	
	@Validator 
	public ViewItemPageValidators validateWriteAReviewPage(){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().PRVW_WAR_STAR_HDR, "RATINGS AND REVIEWS Write-A-Review Page: Star ratings header is missing")
			.present(viPage.getViewItemPageComponent().PRVW_WAR_STARS, "RATINGS AND REVIEWS Write-A-Review Page: Star ratings are missing")
			.present(viPage.getViewItemPageComponent().PRVW_WAR_ASPECTS, "RATINGS AND REVIEWS Write-A-Review Page: Aspects sections is missing")
			.present(viPage.getViewItemPageComponent().PRVW_WAR_RVW_TITLE, "RATINGS AND REVIEWS Write-A-Review Page: Review Title Field is missing")
			.present(viPage.getViewItemPageComponent().PRVW_WAR_RVW_DESC, "RATINGS AND REVIEWS Write-A-Review Page: Review Description Field is missing")
			.present(viPage.getViewItemPageComponent().PRVW_WAR_RVW_ADD_PHOTOS, "RATINGS AND REVIEWS Write-A-Review Page: Add Photos sections is missing")
			.present(viPage.getViewItemPageComponent().PRVW_WAR_CANCEL_BTN, "RATINGS AND REVIEWS Write-A-Review Page: Cancel Button is missing")
			.present(viPage.getViewItemPageComponent().PRVW_WAR_SUBMIT_BTN, "RATINGS AND REVIEWS Write-A-Review Page: Submit Button is missing");
		
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateSMEPanelOnVIP(){
		checkBasicUIElements();
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SME_PANEL, "SME Panel is missing")
			.withinParent(viPage.getViewItemPageComponent().SME_PANEL)
				.present(viPage.getViewItemPageComponent().SME_TITLE, "SME Promotion Title is missing")
				.present(viPage.getViewItemPageComponent().SME_MOREITEMS, "SME Panel chevron to see more items is missing");
		return this;
	}
	
	@Validator 
	public ViewItemPageValidators validateSellerScheduledListingHeader(){
		uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().SELLER_VIP_PAGE_HDR, "")
			.textContains(viPage.getViewItemPageComponent().SELLER_VIP_PAGE_HDR, "scheduled", "VIP Header for Scheduled Listing is incorrect!");
		return this;
	}
	
	@Validator
	public ViewItemPageValidators validateEgdTextOnVIP() {
		uiChainAssert.element()
		.present(viPage.getViewItemPageComponent().eGD_TEXT_ATF, "Guaranteed By date text absent on ATF VIP");
		
		if(actions.element().present().now(viPage.getViewItemPageComponent().eGD_TEXT_BTF))
			uiChainAssert.element()
			.present(viPage.getViewItemPageComponent().eGD_TEXT_BTF, "Guaranteed By date text absent on BTF VIP");
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
