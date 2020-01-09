package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Enums.ShareOptionsMenu;
import com.eBay.NativeApp.Locators.SharePanelComponentLocators;

public class SharePanelComponent extends SharePanelComponentLocators{

	public SharePanelComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void shareViaOption(ShareOptionsMenu option){
		
		actions.touchScreen().withinParent(SHARE_PANEL_ITEMS_CONTAINER).scrollTo(By.xpath("//android.widget.TextView[@text='"+ShareOptionsMenu.MESSAGING.getValue()+"']"));
		
		List<String> allOptions = actions.element()
				.withinParent(SHARE_PANEL_ITEMS_CONTAINER)
				.withinParent(SHARE_PANEL_ITEMS).get()
				.textFromAllElementsWithSameLocatorAsList(By.xpath("//android.widget.TextView"), "Share Menu Options could not be found!");
		if(allOptions.contains(option.getValue())){
			actions.touchScreen().withinParent(SHARE_PANEL_ITEMS_CONTAINER)
				.tap((By.xpath("//android.widget.TextView[@text='"+option.getValue()+"']")));
			
			switch (option) {
			case FACEBOOK: clickPostForFacebook(); break;
			case TWITTER: clickTweetForTwitter(); break;
			case GMAIL: clickSendViaGmail(); break;
			default:
				break;
			}
		}
		else
			breezeReport.logRedStep("["+option.getValue()+"] Menu option is not available!");
	
	}
	
	private void clickTweetForTwitter(){
		if(actions.element().present().byPolling(TWITTER_TWEET))
			actions.element().click().by(TWITTER_TWEET);
		else breezeReport.logRedStep("Seems Twitter Share window did not open...!!!");
	}
	
	private void clickPostForFacebook(){
		if(actions.element().present().byPolling(FACEBOOK_POST_BTN))
			actions.element().click().by(FACEBOOK_POST_BTN);
		else breezeReport.logRedStep("Seems Facebook Share window did not open...!!!");
	}
	
	private void clickSendViaGmail(){
		if(actions.element().present().byPolling(GMAIL_RCPNT_TO)){
			actions.element().textBox().sendKeys(GMAIL_RCPNT_TO, "ebaymobreg@gmail.com");
			actions.element().click().by(GMAIL_SEND_BTN);
		}
		else breezeReport.logRedStep("Seems Gmail Share window did not open...!!!");
			
	}
	
}
