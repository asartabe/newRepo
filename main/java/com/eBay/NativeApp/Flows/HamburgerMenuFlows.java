package com.eBay.NativeApp.Flows;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Enums.HamburgerMenuOptions;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Pages.HomeScreen;

public class HamburgerMenuFlows {
	
	WebDriver driver;
	HamburgerMenuOptions menuItem;
	public HamburgerMenuFlows(WebDriver driver, HamburgerMenuOptions menuItem){
		this.driver = driver;
		this.menuItem = menuItem;
	}
	
	public void openMenuOption(){
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickHamburgerMenu();
		
		switch (menuItem) {
		case HOME: new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().clickHome();
			break;
		case NOTIFICATIONS: new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().clickNotification();
			break;
		case MESSAGES: new HamburgerMenuPanel(driver).getHamburgerMenuTopComponent().clickMessages();
			break;
		case WATCHING: new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().clickWatching();
			break;
		case SAVED_or_FOLLOWED: new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().clickFollowing();
			break;
		case PURCHASES: new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().clickPurchases();
			break;
		case BIDS_and_OFFERS: new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().clickBidsOffers();
			break;
		case SELLING: new HamburgerMenuPanel(driver).getHamburgerMenuMyEbayComponent().clickSelling();
			break;
		case CATEGORIES: new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().clickCategories();
			break;
		case DEALS: new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().clickDeals();
			break;
		case SETTINGS: new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().clickSettings();
			break;
		case HELP_and_CONTACT: new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().clickHelpContact();
			break;
		default: new HomeScreen(driver).getHomeScreenHeaderComponent().goToHome();
			break;
		}
		
	}
	
}
