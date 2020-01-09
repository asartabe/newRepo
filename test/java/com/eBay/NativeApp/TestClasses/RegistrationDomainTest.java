package com.eBay.NativeApp.TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.BreezeTestParams.TestNGPara;
import com.eBay.NativeApp.Commons.SearchRefinementType.BuyingFormat;
import com.eBay.NativeApp.CustomUtils.TimeAndDateUtils;
import com.eBay.NativeApp.Enums.TestPayPalEmail;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Flows.SearchFlows;
import com.eBay.NativeApp.Flows.SetupCountryInSettings;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.RegistrationScreen;
import com.eBay.NativeApp.Pages.SearchPage;
import com.eBay.NativeApp.Pages.SearchResultsPage;
import com.eBay.NativeApp.Pages.SignInScreen;
import com.eBay.NativeApp.Pages.ViewItemPage;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.eBay.NativeApp.Validators.RegistrationValidators;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.quality.testdataautil.type.User;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Priority;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class RegistrationDomainTest extends UIBaseTest{
	
	@Test(description="Validates Error for Registration using Existing Email")
	@Automate(owner=Owners.DEEPAK_THORECHA, type={Type.UI})
	public void test_ERROR_EXISTING_EMAIL(){
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		SetupCountryInSettings.setupCountry(driver);
		
		User user = new User();
		user.setBaseEmail(TestPayPalEmail.PAYPAL_ADDRESS1.getEmailAddress());
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickRegister();
		new RegistrationScreen(driver).getRegistrationFieldComponent().enterRegistrationEmail(user);
		new RegistrationValidators.Use().uiAssertion(uiAssert).validate(driver).validateExistingEmailErrorMessage();
		uiAssert.end();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="getRegUserData", 
			description="Registration Flows: PPA, Upgrade Flow (Sited/Unsited), Registration via Follow & Watch")
	@Automate(priority=Priority.P1, owner=Owners.DEEPAK_THORECHA, type={Type.UI, Type.FUNCTIONAL})
	public void test_REGISTRATION(TestObject testObject, User user){

		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		user.setBaseEmail(user.getBaseEmail()+TimeAndDateUtils.getTimeStamp()+"@unicorn.qa.ebay.com");
		SetupCountryInSettings.setupCountry(driver);
		
		if(testObject.getTestTitle().contains("FOLLOW") || testObject.getTestTitle().contains("WATCH")){
			SearchFlows.searchFor("Test Item Do Not Buy", false);
			if(testObject.getTestTitle().contains("FOLLOW"))
				new SearchResultsPage(driver).getSRPHeaderComponent().justClickFollowSearch();
			else if(testObject.getTestTitle().contains("WATCH")){
				new SearchResultsPage(driver).getSRPHeaderComponent().getRefinementPanel(true).addBuyingFormat(BuyingFormat.BUYITNOW).saveRefinements();
				new SearchResultsPage(driver).getSRPResultsComponent().selectFirstItemFromResults();
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().watchItem();
			}
			new SignInScreen(driver).getSignInComponent().tapOnRegisterButton();
			new RegistrationScreen(driver).getRegistrationFieldComponent().completeRegistrationForm(user);
			
			if(!TestNGPara.getSite().equalsIgnoreCase("AU") || testObject.getTestTitle().contains("FOLLOW"))
				new RegistrationScreen(driver).getRegistrationFieldComponent().completeUpgradeFlow(user);
			else if(testObject.getTestTitle().contains("WATCH"))
				LoginFlows.signIn(user.getBaseEmail(), user.getPassword());
		}
		else{
			switch (TestNGPara.getSite()) {
			case "AU":
				new HomeScreen(driver).getHomeScreenContentComponent().clickRegister();
				new RegistrationScreen(driver).getRegistrationFieldComponent().completeRegistrationForm(user);

				new SignInScreen(driver).getSignInComponent().signIn(user.getBaseEmail(), user.getPassword());

				if(testObject.getTestTitle().contains("_UPGRADE_"+TestParams.CommonTestEnv.site.get())){
					new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
					new SearchPage(driver).getSearchPageQueryComponent().createSearch("Test Item Do Not Buy", false);

					if(testObject.getTestTitle().contains("UNSITED"))
						this.helpWithUpgradeFlow(driver, BuyingFormat.BUYITNOW, false, user);
					else if(testObject.getTestTitle().contains("SITED"))
						this.helpWithUpgradeFlow(driver, BuyingFormat.AUCTION, true, user);

					new RegistrationValidators.Use().uiAssertion(uiAssert).validate(driver).setRegistrationScreenObject(new RegistrationScreen(driver))
						.validateRegistered();
				}
				break;

			default:
				new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
				new SearchPage(driver).getSearchPageQueryComponent().createSearch("Test Item Do Not Buy", false);
				if(testObject.getTestTitle().contains("UNSITED"))
					this.helpWithUpgradeFlow(driver, BuyingFormat.BUYITNOW, false, user);
				else if(testObject.getTestTitle().contains("SITED"))
					this.helpWithUpgradeFlow(driver, BuyingFormat.AUCTION, true, user);
				
				break;
			}
			
		}
		uiAssert.end();
	}
	
	private void helpWithUpgradeFlow(WebDriver driver, BuyingFormat format, boolean sited, User user){
		new SearchResultsPage(driver).getSRPHeaderComponent().getRefinementPanel(true)
			.addBuyingFormat(format).saveRefinements();
		new SearchResultsPage(driver).getSRPResultsComponent().selectFirstItemFromResults();
		if(format.equals(BuyingFormat.BUYITNOW)){
			if(TestNGPara.getSite().equalsIgnoreCase("AU"))	
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickBINToUpgrade();
			else
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickBINButton();
		}
		else if(format.equals(BuyingFormat.AUCTION)){
			if(TestNGPara.getSite().equalsIgnoreCase("AU"))
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickBIDToUpgrade();
			else
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().clickPLACEBIDButton();
		}
		
		if(!TestNGPara.getSite().equalsIgnoreCase("AU")){
			new HomeScreen(driver).getHomeScreenContentComponent().clickRegister();
			new RegistrationScreen(driver).getRegistrationFieldComponent().completeRegistrationForm(user);
		}
		new RegistrationScreen(driver).getRegistrationFieldComponent().completeUpgradeFlow(sited, user);
	}
}
