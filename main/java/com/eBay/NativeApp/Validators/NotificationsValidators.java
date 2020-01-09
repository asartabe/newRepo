package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.Pages.HamburgerMenuPanel;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class NotificationsValidators implements IValidator{
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	HamburgerMenuPanel hamPage;
	private NotificationsValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<NotificationsValidators.Use> {
		public NotificationsValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new NotificationsValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();
		
	}
	
	public NotificationsValidators setNotificationValidators(HamburgerMenuPanel hamPage){
		this.hamPage = hamPage;
		return this;
	}
	
	@Validator
	public NotificationsValidators checkUnreadNotificationsCount(){
		/*uiChainAssert.element()
			.withinParent(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIFICATION_LNK)
				.present(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().UNREAD_NOTIFICATIONS_COUNT, "No Unread Notifications present");*/
		if(actions.element().withinParent(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIFICATION_LNK)
				.notPresent(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().UNREAD_NOTIFICATIONS_COUNT, 5))
			breezeReport.logRedStep("No Unread Notifications present");
		return this;
	}
	
	@Validator
	public NotificationsValidators checkNotificationsContent(){
		if(actions.element().present().now(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILES)){
			uiChainAssert.element()
				.withinParent(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILES)
					.present(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILE_IMG, "")
					.present(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILE_TITLE, "")
					.present(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILE_BODY, "");
		}
		else
			breezeReport.logRedStep("No Notifications are present!!!");
		return this;
	}
	
	@Validator
	public NotificationsValidators checkForNotificationWithDetails(String details){
		List<WebElement> notifTiles = actions.element().get().allWebElementsWithSameLocator(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILES);
		for (WebElement notifTile : notifTiles) {
			String actual = actions.element().withinParent(notifTile).get().text(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILE_TITLE, "")
					 + actions.element().withinParent(notifTile).get().text(hamPage.getHamburgerMenuTopComponent().getNotificationcomponent().NOTIF_TILE_BODY, "");
			uiChainAssert.string()
				.notEquals(actual, details, "Dismissed Notification details are still visible. Notification wasn't dismissed!!!");
		}
		return this;
	}
	
}
