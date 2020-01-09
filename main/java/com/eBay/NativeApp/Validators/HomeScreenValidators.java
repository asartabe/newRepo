package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class HomeScreenValidators implements IValidator {
	  
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HomeScreen home;
	  
	private HomeScreenValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}
	  
	public static class Use extends UIValidator<HomeScreenValidators.Use> {
		public HomeScreenValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new HomeScreenValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
	}
	 
	public HomeScreenValidators setHomeScreenObject(HomeScreen home){
		this.home = home;
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateHeaderElements(){
		uiChainAssert.element()
			.present(home.getHomeScreenHeaderComponent().HAMBURGERMENU_ICON, "Hamburger Menu icon is missing")
			.present(home.getHomeScreenHeaderComponent().EBAY_LOGO, "Ebay Logo is missing")
			.present(home.getHomeScreenHeaderComponent().SRCH_BOX, "Search Box is missing");
		
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU"))
			uiChainAssert.element().present(home.getHomeScreenHeaderComponent().CART_ICON, "Cart icon is missing");
		
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateNavigationPills(){
		uiChainAssert.element()
			.present(home.getHomeScreenContentComponent().PILL_SELLING, "Selling Pill is missing")
			.present(home.getHomeScreenContentComponent().PILL_DEALS, "Deals Pill is missing")
			.present(home.getHomeScreenContentComponent().PILL_CATEGORIES, "Categories Pill is missing")
			.present(home.getHomeScreenContentComponent().PILL_FOLLOWING, "Following Pill is missing");
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateCTAButtonsForUnsignedUser(){
		uiChainAssert.element()
			.present(home.getHomeScreenContentComponent().SIGNIN_BTN, "SignIn button is missing for unsigned user")
			.present(home.getHomeScreenContentComponent().REGISTER_BTN, "Register button is missing for unsigned user");
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateCTAButtonsForSignedUser(){
		uiChainAssert.element()
			.notPresent(home.getHomeScreenContentComponent().SIGNIN_BTN, 5, "SignIn button is present for signed user")
			.notPresent(home.getHomeScreenContentComponent().REGISTER_BTN, 5, "Register button is present for signed user");
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateFeaturedDeals(){
		uiChainAssert.element()
			.present(home.getHomeScreenContentComponent().FEAT_DEALS_CONTAINER, "Featured Deals container is missing")
			.withinParent(home.getHomeScreenContentComponent().FEAT_DEALS_CONTAINER)
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_TITLE, "Featured Deals header title is missing")
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_MORE, "Featured Deals More button is missing")
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_CARD1, "Featured Deals Tile1 is missing")
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_CARD2, "Featured Deals Tile2 is missing")
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_CARD3, "Featured Deals Tile3 is missing");
		
		List<WebElement> featDealCards = actions.element().withinParent(home.getHomeScreenContentComponent().FEAT_DEALS_CONTAINER)
				.get().allWebElementsWithSameLocator(home.getHomeScreenContentComponent().FEAT_DEALS_CARDS);
		int i=1;
		for (WebElement featDealCard : featDealCards) {
			uiChainAssert.element()
			.withinParent(home.getHomeScreenContentComponent().FEAT_DEALS_CONTAINER)
			.withinParent(featDealCard)
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_ITMIMG, "Featured Deals Tile image is missing for Tile-"+i)
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_ITMTITLE, "Featured Deals Tile title is missing for Tile-"+i)
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_ITMPRICE, "Featured Deals Tile price is missing for Tile-"+i)
				.present(home.getHomeScreenContentComponent().FEAT_DEALS_ITMPRICE2, "Featured Deals Tile price additional details is missing for Tile-"+i);
			i++;
		}
		
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateTrendingOnEbay(){
		uiChainAssert.element()
			.present(home.getHomeScreenContentComponent().TRENDING_CONTAINER, "Trending On eBay Container is missing")
			.withinParent(home.getHomeScreenContentComponent().TRENDING_CONTAINER)
				.present(home.getHomeScreenContentComponent().TRENDING_TITLE, "Trending On eBay header title is missing")
				.present(home.getHomeScreenContentComponent().TRENDING_MORE, "Trending On eBay More button is missing")
				.present(home.getHomeScreenContentComponent().TRENDING_TILE1, "Trending On eBay Tile1 is missing")
				.present(home.getHomeScreenContentComponent().TRENDING_TILE2, "Trending On eBay Tile2 is missing")
				.present(home.getHomeScreenContentComponent().TRENDING_TILE3, "Trending On eBay Tile3 is missing");
			
		List<WebElement> trendingCards = actions.element().withinParent(home.getHomeScreenContentComponent().TRENDING_CONTAINER)
				.get().allWebElementsWithSameLocator(home.getHomeScreenContentComponent().TRENDING_TILES);
		int i=0;
		for (WebElement trendingCard : trendingCards) {
			uiChainAssert.element()
			.withinParent(home.getHomeScreenContentComponent().TRENDING_CONTAINER)
			.withinParent(trendingCard)
				.present(home.getHomeScreenContentComponent().TRENDING_TILE_POSITION, "Trending On eBay Tile-position is missing for Tile-"+i)
				.present(home.getHomeScreenContentComponent().TRENDING_TILE_IMG, "Trending On eBay Tile-image is missing for Tile-"+i)
				.present(home.getHomeScreenContentComponent().TRENDING_TILE_TITLE, "Trending On eBay Tile-title is missing for Tile-"+i)
				.present(home.getHomeScreenContentComponent().TRENDING_TILE_STATS, "Trending On eBay Tile-statistics is missing for Tile-"+i);
			i++;
		}
		
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateSalesAndEvents(){
		uiChainAssert.element()
			.present(home.getHomeScreenContentComponent().SALES_EVENTS_CONTAINER, "Sales and Events container is missing")
			.withinParent(home.getHomeScreenContentComponent().SALES_EVENTS_CONTAINER)
				.present(home.getHomeScreenContentComponent().EVENTS_TITLE, "Sales and Events Title header is missing")
				.present(home.getHomeScreenContentComponent().EVENTS_MORE, "Sales and Events More buttons is missing")
				.present(home.getHomeScreenContentComponent().EVENTS_CONTAINER, "Sales and Events events-tile is missing")
				.withinParent(home.getHomeScreenContentComponent().EVENTS_CONTAINER)
					.present(home.getHomeScreenContentComponent().EVENTS_IMG, "Sales and Events events-tile image is missing")
					.present(home.getHomeScreenContentComponent().EVENTS_DETAILS, "Sales and Events events-tile content details is missing")
					.withinParent(home.getHomeScreenContentComponent().EVENTS_DETAILS)
						.present(home.getHomeScreenContentComponent().EVENT_DESC_TITLE, "Sales and Events events-tile description title is missing")
						.present(home.getHomeScreenContentComponent().EVENT_DESC, "Sales and Events events-tile description details is missing")
						/*.present(home.getHomeScreenContentComponent().EVENT_DESC_TIMELEFT, "Sales and Events events-tile time-left details is missing")*/;
		
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateAdContent(){
		if(CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, home.getHomeScreenContentComponent().AD_CONTAINER, 5)){
			uiChainAssert.element()
				.withinParent(home.getHomeScreenContentComponent().AD_CONTAINER)
					.present(home.getHomeScreenContentComponent().AD_ADVERTISER, "AD: Advertiser details missing")
					.present(home.getHomeScreenContentComponent().AD_ADTEXT, "AD:  AdText is missing")
					.present(home.getHomeScreenContentComponent().AD_IMAGE, "AD: image is missing")
					.present(home.getHomeScreenContentComponent().AD_HEADLINE, "AD: headline is missing")
					.present(home.getHomeScreenContentComponent().AD_BODYTEXT, "AD: body-text-details is missing")
					.present(home.getHomeScreenContentComponent().AD_CTA_BTN, "AD: CTA Button is missing");
		}else
			breezeReport.logRedStep("No ADs on HomeScreen.");
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateWatchingContainer(){
		uiChainAssert.element()
			.present(home.getHomeScreenContentComponent().WATCHING_ITEMS_CONTAINER, "Watching Container is missing")
			.withinParent(home.getHomeScreenContentComponent().WATCHING_ITEMS_CONTAINER)
				.present(home.getHomeScreenContentComponent().WATCHING_HDR, "Your Watched Items container header title is missing")
				.present(home.getHomeScreenContentComponent().WATCHING_MORE, "Watching More button is missing")
				.present(home.getHomeScreenContentComponent().WATCHING_ITEM_TILE, "Watched Item tile is missing")
				.withinParent(home.getHomeScreenContentComponent().WATCHING_ITEM_TILE)
					.present(home.getHomeScreenContentComponent().WATCHING_ITEM_TILE_IMG, "Watched Item tile image is missing")
					.present(home.getHomeScreenContentComponent().WATCHING_ITEM_TILE_TITLE, "Watched Item tile title is missing")
					.present(home.getHomeScreenContentComponent().WATCHING_ITEM_TILE_PRICE, "Watched Item tile price is missing")
					.present(home.getHomeScreenContentComponent().WATCHING_ITEM_TILE_TIMELEFT, "Watched Item tile time-left is missing");
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateRVIContainer(){
		uiChainAssert.element()
			.present(home.getHomeScreenContentComponent().RVI_CONTAINER, "Recently Viewed Item container is missing")
			.withinParent(home.getHomeScreenContentComponent().RVI_CONTAINER)
				.present(home.getHomeScreenContentComponent().RVI_HDR, "RVI header title is missing")
				.present(home.getHomeScreenContentComponent().RVI_MORE, "RVI More button is missing")
				.present(home.getHomeScreenContentComponent().RVI_ITEMS_PARENT_LIST, "RVI Items carousel list is missing")
				.withinParent(home.getHomeScreenContentComponent().RVI_ITEMS_PARENT_LIST)
					.present(home.getHomeScreenContentComponent().RVI_ITEMS_CHILD_TILES, "RVI Item tiles is missing")
					.withinParent(home.getHomeScreenContentComponent().RVI_ITEMS_CHILD_TILES)
						.present(home.getHomeScreenContentComponent().RVI_ITM_TILE_IMG, "RVI Item image is missing")
						.present(home.getHomeScreenContentComponent().RVI_ITM_TILE_TITLE, "RVI Item title is missing")
						.present(home.getHomeScreenContentComponent().RVI_ITM_TILE_PRICE, "RVI Item price is missing");
		return this;
	}
	
	@Validator
	public HomeScreenValidators validateNotifications(){
		if(actions.element().present().byCustomPolling(home.getHomeScreenContentComponent().NOTIF_CONTAINER, 5)){
			uiChainAssert.element()
				.withinParent(home.getHomeScreenContentComponent().NOTIF_CONTAINER)
				.present(home.getHomeScreenContentComponent().NOTIF_TILES, "Notification tiles are missing");

			List<WebElement> notifs = actions.element().withinParent(home.getHomeScreenContentComponent().NOTIF_CONTAINER)
					.get().allWebElementsWithSameLocator(home.getHomeScreenContentComponent().NOTIF_TILES);
			for (WebElement notif : notifs) {
				uiChainAssert.element()
				.withinParent(home.getHomeScreenContentComponent().NOTIF_CONTAINER)
				.withinParent(notif)
					.present(home.getHomeScreenContentComponent().NOTIF_TILE_IMG, "Notification image is missing")
					.present(home.getHomeScreenContentComponent().NOTIF_TILE_TITLE, "Notification title is missing")
					.present(home.getHomeScreenContentComponent().NOTIF_TILE_SUBTITLE, "Notification subtitle is missing");
			}
		}else
			breezeReport.logRedStep("No unread/active notifications present.");
		return this;
	}
	
}
