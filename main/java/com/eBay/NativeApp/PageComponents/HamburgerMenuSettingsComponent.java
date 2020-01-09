package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.HamburgerMenuSettingsComponentLocators;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.testdrivers.enums.Site;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;

public class HamburgerMenuSettingsComponent extends HamburgerMenuSettingsComponentLocators{

	public HamburgerMenuSettingsComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private HamburgerMenuSettingsComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");
			
		return this;
	}
	
	public HamburgerMenuSettingsComponent goBack(){
		actions.element().click().by(NAVBAR_BACK);
		return this;
	}
	
	public HamburgerMenuSettingsComponent setAutoSelectCountry(boolean toggle){
		this.clickThisElement(COUNTRY_MENU);
		if(toggle){
			if(actions.element().get().text(COUNTRY_AUTO_SWITCH, "").contentEquals("OFF"))
				actions.element().click().by(COUNTRY_AUTO_SWITCH);
		}else{
			if(actions.element().get().text(COUNTRY_AUTO_SWITCH, "").contentEquals("ON"))
				actions.element().click().by(COUNTRY_AUTO_SWITCH);
		}
		return this;
	}
	
	public HamburgerMenuSettingsComponent setCountry(){
		this.clickThisElement(COUNTRY_MENU);
		if(actions.element().get().text(COUNTRY_AUTO_SWITCH, "").contentEquals("ON"))
			actions.element().click().by(COUNTRY_AUTO_SWITCH);
		this.clickThisElement(COUNTRY_SELECT);
		actions.element().textBox().sendKeys(COUNTRY_SRCH_TXT, 
				Site.valueOf(TestParams.CommonTestEnv.site.get()).getSiteCodeTypeString());
		actions.element().click().by(COUNTRY_SRCH_RESULTS);
		return this;
	}
	
	public HamburgerMenuSettingsComponent setCustomCountry(Site site){
		this.clickThisElement(COUNTRY_MENU);
		if(actions.element().get().text(COUNTRY_AUTO_SWITCH, "").contentEquals("ON"))
			actions.element().click().by(COUNTRY_AUTO_SWITCH);
		this.clickThisElement(COUNTRY_SELECT);
		actions.element().textBox().sendKeys(COUNTRY_SRCH_TXT, site.getSiteCodeTypeString());
		actions.element().click().by(COUNTRY_SRCH_RESULTS);
		return this;
	}
	
	private HamburgerMenuSettingsComponent clickElement(By by){
		CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, by, 15);
		actions.element().click().by(by);
		return this;
	}
	private HamburgerMenuSettingsComponent changeVal(boolean enable){
		if(enable)
			actions.element().click().by(DCS_ENABLED);
		else
			actions.element().click().by(DCS_DISABLED);
		
		return this;
	}
	public HamburgerMenuSettingsComponent updateDCSValue(String dcsParent, String dcsKey, boolean enable){
		
		this.clickElement(By.xpath("//android.widget.TextView[contains(@text, '"+dcsParent+"')]"))
			.clickElement(By.xpath("//android.widget.TextView[contains(@text, '"+dcsKey+"')]"))
			.changeVal(enable);
		
		return this;
	}
	private boolean configOpen = false;
	public HamburgerMenuSettingsComponent openDeviceConfigs(){
		if(!configOpen)
		this.clickElement(DEV_OPTIONS)
			.clickElement(DEVICE_CONFIG);
		configOpen = true;
		return this;
	}
	
}
