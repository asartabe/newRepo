package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.MessagesLocators;
import com.eBay.NativeApp.Pages.HomeScreen;

public class MessagesComponent extends MessagesLocators{

	public MessagesComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private MessagesComponent clickThisElement(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}

	public static String unReadCountEXP=new String();
	public static String unReadCountACT=new String();

	public MessagesComponent getInitialMessageCount(){
		actions.element().withinParent(MESSAGE_BAR).present().byPolling(UNREAD_MSG_COUNT);
		WebElement msgCount=actions.element().withinParent(MESSAGE_BAR).get().webElement(UNREAD_MSG_COUNT);
		unReadCountEXP = msgCount.getText();
		System.out.println(unReadCountEXP);
		return this;
	}

	public MessagesComponent readAMessage(){
		this.clickThisElement(ALL_MSGS_DROPDWN);
		this.clickThisElement(UNREAD_DRPDWN);
		List<WebElement> lst=driver.findElements(UNREAD_CHCKBOX);
		lst.get(1).click();
		actions.element().click().by(READ_UNREAD_ICON);
		new HomeScreen(driver).getHomeScreenHeaderComponent().clickHamburgerMenu();
		WebElement msgCount=actions.element().withinParent(MESSAGE_BAR).get().webElement(UNREAD_MSG_COUNT);
		unReadCountACT = msgCount.getText();
		System.out.println(unReadCountACT);
		return this;
	}


}
