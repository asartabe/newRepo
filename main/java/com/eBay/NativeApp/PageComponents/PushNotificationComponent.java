package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.PushNotificationComponentLocators;
import com.ebay.testinfrastructure.asserts.GenericAssert;

public class PushNotificationComponent extends PushNotificationComponentLocators{

	public PushNotificationComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public PushNotificationComponent getNotificationsPanel(){
		actions.device().openNotifications();
		return this;
	}
	
	public String getNotificationDetails(){
		CustomWaitUtils.waitForSeconds(5);
		if(CustomWaitUtils.waitForElement(NOTIF_ICON) && CustomWaitUtils.waitForElement(NOTIF_TITLE))
			return "TITLE: "+actions.element().get().text(NOTIF_TITLE, "")
				+"\n"+"Notification Details:\n"+actions.element().get().text(NOTIF_CONTENT, "");
		else{
			breezeReport.logRedStep("Notification took too long to appear...!!!");
			new GenericAssert().fail("Notification took too long to appear...!!!");
		}
		
		return null;
	}
	
}
