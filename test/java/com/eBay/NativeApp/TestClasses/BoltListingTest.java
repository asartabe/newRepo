package com.eBay.NativeApp.TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBay.NativeApp.BreezeTestParams.Owners;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.eBay.NativeApp.Flows.LoginFlows;
import com.eBay.NativeApp.Pages.ConditionPage;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SellingPage;
import com.eBay.NativeApp.TestHelpers.TestDataProvider;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.testdrivers.annotations.Automate;
import com.ebay.testinfrastructure.testdrivers.enums.Site;
import com.ebay.testinfrastructure.testdrivers.enums.Type;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIBaseTest;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class BoltListingTest extends UIBaseTest{ 
	
	@Automate(owner=Owners.VIJETA_JUNEJA, type={Type.UI, Type.FUNCTIONAL})
	@Test(description="BOLT Super Simple Listing Flow & validations for Catalogue Products")
	public void test_BOLT_CATALOG_LISTING() throws Exception{
		WebDriver driver = UIListener.uiDriver.get();
		UIChainAssert uiAssert = new UIChainAssert(driver);
		
		new HomeScreen(driver).getHomeScreenContentComponent().clickSignIn();
		LoginFlows.signIn(TestDataProvider.getProductionUser(ProdUserCredentials.TEST_NONESTORE));
		

		new HomeScreen(driver).getHomeScreenContentComponent().clickSellingCapsule();
		new SellingPage(driver).getSellingPageComponent().clickListAnItemButton();
		
		ItemType item = new ItemType();
		item.setTitle("xbox one");
		
		new ConditionPage(driver).getConditionComponent().selectConditionandproceed();
		
		
		
		
		
		
		
	}
}
