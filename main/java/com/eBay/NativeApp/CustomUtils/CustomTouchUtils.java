package com.eBay.NativeApp.CustomUtils;

import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ebay.testinfrastructure.webautil.actions.DeviceAction.Keys;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;
import com.ebay.testinfrastructure.webautil.actions.ScrollLength;
import com.ebay.testinfrastructure.webautil.actions.ScrollTerminateCondition;
//import com.ebay.testinfrastructure.webautil.actions.TouchAction;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.PerformsTouchActions;

@SuppressWarnings({"unchecked"})
public class CustomTouchUtils {

	private static LinkedHashSet<ScrollDirection> directionsToScrollToFindElement = new LinkedHashSet<ScrollDirection>();
	private static LinkedHashSet<ScrollDirection> getScrollDirections(){
		directionsToScrollToFindElement.add(ScrollDirection.DOWN);
		directionsToScrollToFindElement.add(ScrollDirection.UP);
		return directionsToScrollToFindElement;
	}

	public static boolean scrollToElement(WebActions actions, ScrollDirection direction, By by){

		return actions.touchScreen().usingBy()
				.smartScrollTo(by)
				.direction(direction)
				.duration(800)
				.scrollCount(10)
				.terminateOn(ScrollTerminateCondition.ELEMENT_VISIBLE)
				.terminateConditionTimeout(10)
				.build().perform();
	}

	public static boolean scrollToElement(WebActions actions, ScrollDirection direction, By by, int scrollCount){

		return actions.touchScreen().usingBy()
				.smartScrollTo(by)
				.direction(direction)
				.duration(800)
				.scrollCount(scrollCount)
				.terminateOn(ScrollTerminateCondition.ELEMENT_VISIBLE)
				.terminateConditionTimeout(10)
				.build().perform();
	}

	public static boolean scrollToElement(WebActions actions, By by, int scrollCount){
		return actions.touchScreen().usingBy()
				.smartScrollTo(by)
				.directions(getScrollDirections())
				.duration(800)
				.scrollCount(scrollCount)
				.terminateOn(ScrollTerminateCondition.ELEMENT_VISIBLE)
				.terminateConditionTimeout(20)
				.build().perform();
	}

	public static boolean scrollToElement(WebActions actions, WebElement element, int scrollCount){
		return actions.touchScreen().usingWebElement()
				.smartScrollTo(element)
				.directions(getScrollDirections())
				.duration(800)
				.scrollCount(scrollCount)
				.terminateOn(ScrollTerminateCondition.ELEMENT_VISIBLE)
				.terminateConditionTimeout(20)
				.build().perform();
	}

	public static boolean scrollToElementUsingText(WebActions actions, By by, String elementText, int scrollCount, boolean exactMatch){

		if(exactMatch)
			return actions.touchScreen().usingBy().smartScrollTo(by)
					.directions(getScrollDirections()).length(ScrollLength.LONG)
					.terminateOn(ScrollTerminateCondition.ELEMENT_IN_VIEWPORT)
					.terminateOnTextMatch(elementText).scrollCount(scrollCount).terminateConditionTimeout(10).build().perform(); 
		else
			return actions.touchScreen().usingBy().smartScrollTo(by)
					.directions(getScrollDirections()).length(ScrollLength.LONG)
					.terminateOn(ScrollTerminateCondition.ELEMENT_IN_VIEWPORT)
					.terminateOnTextContains(elementText).scrollCount(scrollCount).terminateConditionTimeout(10).build().perform();
	}

	public static Point getPointOnScreen(){
		AppiumDriver<MobileElement> driver = (AppiumDriver<MobileElement>) UIListener.uiDriver.get();
		Dimension dim = driver.manage().window().getSize();
		Point point = new Point((dim.width)/2, (dim.height)/2);
		return point;
	}

	public static void swipe(Point query, int count, ScrollDirection dir){
		AppiumDriver<MobileElement> driver = (AppiumDriver<MobileElement>) UIListener.uiDriver.get();
		/*TouchScreen driver = (TouchScreen) UIListener.uiDriver.get();*/
//		TouchAction action = new TouchAction(performsTouchActions);
//		
//		
//		
		for(int i=0; i<count; i++){
			if(dir.equals(ScrollDirection.DOWN))
				//driver.performTouchAction(touchAction);
			
				
				driver.swipe(query.getX(), query.getY(), query.getX(), query.getY()-1000, 1000);
			else if(dir.equals(ScrollDirection.UP))
				driver.swipe(query.getX(), query.getY(), query.getX(), query.getY()+1000, 1000);
			else if(dir.equals(ScrollDirection.LEFT))
				driver.swipe(query.getX(), query.getY(), query.getX()-1000, query.getY(), 1000);
			else if(dir.equals(ScrollDirection.RIGHT))
				driver.swipe(query.getX(), query.getY(), query.getX()+1000, query.getY(), 1000);
		}
	}
	
	public static void swipe(Point query, int count, ScrollDirection dir, int byValue){
		AppiumDriver<MobileElement> driver = (AppiumDriver<MobileElement>) UIListener.uiDriver.get();
		/*TouchScreen driver = (TouchScreen) UIListener.uiDriver.get();*/
		for(int i=0; i<count; i++){
			if(dir.equals(ScrollDirection.DOWN))
				driver.swipe(query.getX(), query.getY(), query.getX(), query.getY()-byValue, 1000);
			else if(dir.equals(ScrollDirection.UP))
				driver.swipe(query.getX(), query.getY(), query.getX(), query.getY()+byValue, 1000);
			else if(dir.equals(ScrollDirection.LEFT))
				driver.swipe(query.getX(), query.getY(), query.getX()-byValue, query.getY(), 1000);
			else if(dir.equals(ScrollDirection.RIGHT))
				driver.swipe(query.getX(), query.getY(), query.getX()+byValue, query.getY(), 1000);
		}
		
	}
	
	public CustomTouchUtils deviceBack(WebDriver driver){
		new WebActions(driver).device().sendKeyEvent(Keys.ANDROID_BACK);
		CustomWaitUtils.waitForSeconds(5);
		return new CustomTouchUtils();
	}
	
	public CustomTouchUtils appBack(WebDriver driver){
		new WebActions(driver).element().click().by(By.id("com.ebay.mobile:id/back_button"));
		return new CustomTouchUtils();
	}
	
	/*public CustomTouchUtils closeCurrentPage(WebDriver driver){
		new WebActions(driver).element().click().by(By.id("com.ebay.mobile:id/home"));
		return new CustomTouchUtils();
	}*/
	
}
