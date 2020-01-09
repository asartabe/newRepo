package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Enums.DealsTabs;
import com.eBay.NativeApp.Pages.DealsPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class DealsPageValidator implements IValidator{
	
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	DealsPage deals;
	
	private DealsPageValidator(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<DealsPageValidator.Use> {
		public DealsPageValidator validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new DealsPageValidator(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}
	
	public DealsPageValidator setDealsPage(DealsPage deals){
		this.deals = deals;
		return this;
	}
	
	@Validator
	public DealsPageValidator validateFeaturedSection(DealsTabs tab){
		
		uiChainAssert.element()
		.present(deals.getDealsContentComponent().FEATURED_DEALS_CONTAINER, "FEATURED_DEALS_CONTAINER is missing for "+tab.name())
			.withinParent(deals.getDealsContentComponent().FEATURED_DEALS_CONTAINER)
				.present(deals.getDealsContentComponent().FEATURED_DEALS_HEADER, "FEATURED_DEALS_HEADER is missing for "+tab.name())
				.withinParent(deals.getDealsContentComponent().FEATURED_DEALS_HEADER)
					.present(deals.getDealsContentComponent().FEATURED_DEALS_HDR_TITLE, "FEATURED_DEALS_HDR_TITLE is missing for "+tab.name());
		uiChainAssert.element()
			.withinParent(deals.getDealsContentComponent().FEATURED_DEALS_CONTAINER)
				.present(deals.getDealsContentComponent().FEATURED_DEALS_CARD, "FEATURED_DEALS_CARD is missing for "+tab.name())
				.withinParent(deals.getDealsContentComponent().FEATURED_DEALS_CARD)
					.present(deals.getDealsContentComponent().FEATURED_DEALS_CARD_IMG, "FEATURED_DEALS_CARD_IMG is missing for "+tab.name())
					.present(deals.getDealsContentComponent().FEATURED_DEALS_CARD_TITLE, "FEATURED_DEALS_CARD_TITLE is missing for "+tab.name())
					.present(deals.getDealsContentComponent().FEATURED_DEALS_CARD_PRICE, "FEATURED_DEALS_CARD_PRICE is missing for "+tab.name())
					.present(deals.getDealsContentComponent().FEATURED_DEALS_CARD_STP, "FEATURED_DEALS_CARD_STP is missing for "+tab.name());
		
		/*uiChainAssert.element()
		.withinParent(deals.getDealsContentComponent().FEATURED_DEALS_CONTAINER)
		.withinParent(deals.getDealsContentComponent().FEATURED_DEALS_HEADER)
			.present(deals.getDealsContentComponent().FEATURED_DEALS_HDR_MORE, "");*/
		
		return this;
	}
	
	@Validator
	public DealsPageValidator validateTrendingSection(DealsTabs tab){
		
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, deals.getDealsContentComponent().TRENDING_DEALS_CONTAINER, 10)){	
			uiChainAssert.element()
				.withinParent(deals.getDealsContentComponent().TRENDING_DEALS_CONTAINER)
					.present(deals.getDealsContentComponent().TRENDING_DEALS_HEADER, "TRENDING_DEALS_HEADER is missing for "+tab.name())
					.withinParent(deals.getDealsContentComponent().TRENDING_DEALS_HEADER)
						.present(deals.getDealsContentComponent().TRENDING_DEALS_HDR_TITLE, "TRENDING_DEALS_HDR_TITLE is missing for "+tab.name());
			uiChainAssert.element()
				.withinParent(deals.getDealsContentComponent().TRENDING_DEALS_CONTAINER)
					.present(deals.getDealsContentComponent().TRENDING_DEALS_CARD, "TRENDING_DEALS_CARD is missing for "+tab.name())
					.withinParent(deals.getDealsContentComponent().TRENDING_DEALS_CARD)
						.present(deals.getDealsContentComponent().TRENDING_DEALS_CARD_IMG, "TRENDING_DEALS_CARD_IMG is missing for "+tab.name())
						.present(deals.getDealsContentComponent().TRENDING_DEALS_CARD_PRICE, "TRENDING_DEALS_CARD_PRICE is missing for "+tab.name())
						.present(deals.getDealsContentComponent().TRENDING_DEALS_CARD_TITLE, "TRENDING_DEALS_CARD_TITLE is missing for "+tab.name());
		}
		else
			breezeReport.logRedStep("No TRENDING DEALS Section available for: "+tab.name());
		
		return this;
	}
	
	@Validator
	public DealsPageValidator validateFeaturedEventSection(DealsTabs tab){
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, deals.getDealsContentComponent().FEATURED_EVENT_HDR, 10)){
			uiChainAssert.element()
				.present(deals.getDealsContentComponent().FEATURED_EVENT_TILE, "FEATURED_EVENT_TILE is missing for "+tab.name())
				.withinParent(deals.getDealsContentComponent().FEATURED_EVENT_TILE)
					.present(deals.getDealsContentComponent().FEATURED_EVENT_TILE_IMG, "FEATURED_EVENT_TILE_IMG is missing for "+tab.name())
					.present(deals.getDealsContentComponent().FEATURED_EVENT_TILE_TITLE, "FEATURED_EVENT_TILE_TITLE is missing for "+tab.name())
					.present(deals.getDealsContentComponent().FEATURED_EVENT_TILE_DESC, "FEATURED_EVENT_TILE_DESC is missing for "+tab.name());
		}
		else
			breezeReport.logRedStep("No FEATURED EVENTS Section available for: "+tab.name());
		return this;
	}
	
	@Validator
	public DealsPageValidator validateSalesEventSection(DealsTabs tab){
		CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 15, ScrollDirection.DOWN);
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, deals.getDealsContentComponent().SALES_EVENTS_HDR, 10)){
			uiChainAssert.element()
				.present(deals.getDealsContentComponent().SALES_EVENTS_CAROUSEL, "SALES_EVENTS_CAROUSEL is missing for "+tab.name())
				.withinParent(deals.getDealsContentComponent().SALES_EVENTS_CAROUSEL)
					.present(deals.getDealsContentComponent().SALES_EVENTS_CAROUSEL_EVENT, "SALES_EVENT_TILE is missing for "+tab.name())
					.withinParent(deals.getDealsContentComponent().SALES_EVENTS_CAROUSEL_EVENT)
						.present(deals.getDealsContentComponent().SALES_EVENTS_CAROUSEL_EVENT_IMG, "SALES_EVENT_TILE_IMG is missing for "+tab.name())
						.present(deals.getDealsContentComponent().SALES_EVENTS_CAROUSEL_EVENT_TITLE, "SALES_EVENT_TILE_TITLE is missing for "+tab.name())
						.present(deals.getDealsContentComponent().SALES_EVENTS_CAROUSEL_EVENT_DESC, "SALES_EVENT_TILE_DESC is missing for "+tab.name());
		}
		else
			breezeReport.logRedStep("No FEATURED EVENTS Section available for: "+tab.name());
		
		return this;
	}
	
}
