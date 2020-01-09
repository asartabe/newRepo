package com.eBay.NativeApp.Flows;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Enums.ItemsToSearch;
import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SearchPage;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class UpdateDCS {
	
	private static boolean enabledDCS = false;
	static
	{
		if(TestParams.get("testType").equalsIgnoreCase("REGRESSION"))
			enabledDCS = true;
	}
	
	public static boolean isDCSEnabled(){
		return enabledDCS;
	}
	
	/** Assumes User is on HomeScreen
	 */
	public static boolean enableDeveloperSettings(){
		if(enabledDCS){
			WebDriver driver = UIListener.uiDriver.get();
			new HomeScreen(driver).getHomeScreenHeaderComponent().clickInSearch();
			new SearchPage(driver).getSearchPageQueryComponent().createSearch(ItemsToSearch.KeyWord.DCS_KEYWORD.getKeyWord(), false);
			new HomeScreen(driver).getHomeScreenHeaderComponent().clickHamburgerMenu();
			new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().clickSettings();
			return CustomTouchUtils.scrollToElement(new WebActions(driver), ScrollDirection.DOWN, 
					new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().getHamburgerMenuSettingsComponent().DEV_OPTIONS);
		}
		return false;
	}
	
	/**
	 * <b>dcsParent:</b> Provide value for the parent of DCS-Key. For ex. search, selling, prp etc <br>
	 * <b>dcsKey:</b> Key for which the DCS value needs to be updated. For ex. fitsInfo, listingPreviewUrl, features etc <br>
	 * <b>enable:</b> TRUE if needs to be Enabled or FALSE otherwise.
	 * <br><br><b>Use recursively to enable more than one DCS Key. CallTo: <i>saveConfigurations</i> to save configurations in the end.
	 */
	public static UpdateDCS changeConfig(String dcsParent, String dcsKey, boolean enable){
		WebDriver driver = UIListener.uiDriver.get();
		new HamburgerMenuPanel(driver).getHamburgerMenuBottomComponent().getHamburgerMenuSettingsComponent().openDeviceConfigs()
			.updateDCSValue(dcsParent, dcsKey, enable);
		new CustomTouchUtils().deviceBack(driver);
		return new UpdateDCS();
	} 
	
	public void saveConfigurations(){
		WebDriver driver = UIListener.uiDriver.get();
		new CustomTouchUtils().deviceBack(driver).deviceBack(driver).deviceBack(driver);
	}
}
