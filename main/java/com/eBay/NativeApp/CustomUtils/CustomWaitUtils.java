package com.eBay.NativeApp.CustomUtils;

import org.openqa.selenium.By;

import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class CustomWaitUtils {
	
	public static void waitForSeconds(int seconds){
		try{
			Thread.sleep(seconds*1000);
		}catch(Exception e){}
	}

	/**
	 * Waits for an element to be present & enabled
	 * @param elementBy
	 */
	public static boolean waitForElement(By elementBy){

		WebActions actions = new WebActions(UIListener.uiDriver.get());
		CustomWaitUtils.waitForSeconds(5);
		/*if(actions.element().present().now(By.id("com.ebay.mobile:id/progress_bar")))*/
		
		if(	actions.element().found().byPolling(elementBy) &&
			actions.element().present().byPolling(elementBy) &&
			actions.element().isEnabled().byCustomPolling(elementBy, 15))
			return true;
		else
			return false;

	}
	
	
}
