package com.eBay.NativeApp.Flows;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Pages.HomeScreen;

public class SetupCountryInSettings {
	
	public static void setupAutoSelectCountry(WebDriver driver){
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickHamburgerMenu();
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().clickSettings();
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent()
				.getHamburgerMenuSettingsComponent().setAutoSelectCountry(true).goBack().goBack();
	}
	
	/**
	 * Sets up Country in Settings as per Site param in TestNG
	 */
	public static void setupCountry(WebDriver driver){
		
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickHamburgerMenu();
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().clickSettings();
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent()
				.getHamburgerMenuSettingsComponent().setCountry().goBack().goBack();
		
	}
	
}
