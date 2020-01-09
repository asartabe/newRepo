package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.NotificationsLocators;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;

public class NotificationComponent extends NotificationsLocators{

	public NotificationComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public NotificationComponent clickFirstNotification(){
		actions.element().click().by(FIRST_NOTIFICATION);
		return this;
	}
	
	public String getTitleForFirstNotification(){
		CustomWaitUtils.waitForSeconds(5);
		for(int i=0; i<3; i++){
			CustomTouchUtils.swipe(CustomTouchUtils.getPointOnScreen(), 1, ScrollDirection.DOWN);
		}
		return actions.element().withinParent(actions.element().get().allWebElementsWithSameLocator(NOTIF_TILES).get(0))
				.get().text(NOTIF_TILE_TITLE, "");
	}
	
	private static boolean moreNotifs = false;
	public boolean moreNotifications(){
		return moreNotifs;
	}
	
	public String dismissFirstNotification(){
		String notifContent = new String();
		if(actions.element().get().allWebElementsWithSameLocator(NOTIF_TILES).size() >= 1){
			moreNotifs = true;
			WebElement notif = actions.element().get().allWebElementsWithSameLocator(NOTIF_TILES).get(0);
			notifContent = actions.element().withinParent(notif).get().text(NOTIF_TILE_TITLE, "") + 
					actions.element().withinParent(notif).get().text(NOTIF_TILE_BODY, "");
			CustomTouchUtils.swipe(actions.element().withinParent(actions.element().get().allWebElementsWithSameLocator(NOTIF_TILES).get(0)).get().centerPoint(NOTIF_TILE_IMG), 1, ScrollDirection.RIGHT);
			CustomWaitUtils.waitForSeconds(5);
		}
		return notifContent;
	}
	
	public void dismissNotificationTile(WebElement notifTile){
		CustomTouchUtils.swipe(actions.element().withinParent(notifTile).get().centerPoint(NOTIF_TILE_IMG), 1, ScrollDirection.RIGHT);
		CustomWaitUtils.waitForSeconds(5);
	}
	
}
