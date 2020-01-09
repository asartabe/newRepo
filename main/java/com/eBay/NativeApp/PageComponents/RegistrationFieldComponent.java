package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eBay.NativeApp.BreezeTestParams.TestNGPara;
import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.eBay.NativeApp.Locators.RegistrationFieldComponentLocators;
import com.ebay.quality.testdataautil.type.User;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.webautil.actions.ScrollDirection;

import io.appium.java_client.MobileElement;

@SuppressWarnings("unused")
public class RegistrationFieldComponent extends RegistrationFieldComponentLocators{

	public RegistrationFieldComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private RegistrationFieldComponent enterText(By by, String data){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().textBox().clearAndSendKeys(by, data);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}
	
	private RegistrationFieldComponent enterText(WebElement element, String data){
		if(element.isDisplayed() && element.isEnabled()){
			actions.element().textBox().clear(element);
			actions.element().textBox().sendKeys(element, data);
		}
		else
			Assert.fail("Element referenced with Locators : ["+element.toString()+"] wasn't found!");

		return this;
	}
	
	private RegistrationFieldComponent clickThis(By by){
		if(CustomWaitUtils.waitForElement(by))
			actions.element().click().by(by);
		else
			Assert.fail("Element referenced with Locators : ["+by.toString()+"] wasn't found!");

		return this;
	}
	
	public RegistrationFieldComponent enterRegistrationEmail(User user){
		this.enterText(actions.element().get().allWebElementsWithSameLocator(PPA_NEW_FIELDS).get(2), user.getBaseEmail());
			actions.element().click().webElement(actions.element().get().allWebElementsWithSameLocator(PPA_NEW_FIELDS).get(0));
		return this;
	}
	
	public RegistrationFieldComponent completeRegistrationForm(User user){
		
		/*this.enterText(EMAIL_FLD, user.getBaseEmail())
			.enterText(REEMAIL_FLD, user.getBaseEmail())
			.enterText(PASSWORD_FLD, user.getPassword())
			.enterText(FNAME_FLD, user.getFirstName())
			.enterText(LNAME_FLD, user.getLastName())
			.enterText(PHONE_FLD, user.getDayPhone())
			.clickRegister()
			.clickContinue();*/
		
		List<WebElement> ppaFields = actions.element().get().allWebElementsWithSameLocator(PPA_NEW_FIELDS);
		if(ppaFields.size() == 4){
			this.enterText(ppaFields.get(0), user.getFirstName())
				.enterText(ppaFields.get(1), user.getLastName())
				.enterText(ppaFields.get(2), user.getBaseEmail())
				.enterText(ppaFields.get(3), user.getPassword());
			actions.element().click().webElement(actions.element().get().webElement(PPA_NEW_REG_BTN));
		}
		else
			Assert.fail("PPA FORM has issues... Either have More or Less Editable fields! "
					+ "Expected to have [FirstName, LastName, Email Address & Password] fields.");
		
		
		return this;
	}

	private RegistrationFieldComponent clickRegister(){
		this.clickThis(REGISTER_BTN);
		return this;
	}

	private RegistrationFieldComponent clickContinue(){
		/*String userID = this.getRegisteredUserID();*/
		this.clickThis(CONTINUE_BTN);
		return this;
	}

	private String getRegisteredUserID(){
		String temp =  driver.findElement(REG_USERNAME).getAttribute("content-desc");
		String userId = temp.split(":")[1];
		return userId;

	}

	private static boolean isSited = true;
	
	/**Use for distinguished SITED & UNSITED Upgrades
	 */
	public RegistrationFieldComponent completeUpgradeFlow(boolean sited, User user){
		isSited = sited;
		if(actions.element().present().now(UPGRADE_NEW_COUNTRY_SEL1))
			actions.element().click().by(UPGRADE_NEW_COUNTRY_SEL1);
		else if(actions.element().present().now(UPGRADE_NEW_COUNTRY_SEL2))
			actions.element().click().by(UPGRADE_NEW_COUNTRY_SEL2);
		By by;

		if(sited)
			by = By.xpath("//android.widget.CheckedTextView[@text='Canada']");
		else
			by = By.xpath("//android.widget.CheckedTextView[@text='Argentina']");

		CustomTouchUtils.scrollToElement(actions, ScrollDirection.DOWN, by);
		this.clickThis(by);

		if(sited){
			CustomWaitUtils.waitForSeconds(5);
			List<WebElement> signInFlds = actions.element().get().allWebElementsWithSameLocator(UPGRADE_NEW_FIELDS);
			this.enterText(signInFlds.get(0), user.getBaseEmail())
				.enterText(signInFlds.get(1), user.getPassword())
				.clickThis(By.xpath("//android.widget.Button[@content-desc='Sign in' or @resource-id='sgnBt' or @text='Sign in']"));
		}
		this.completeUpgradeFlow(user);

		return this;
	}

	public RegistrationFieldComponent completeUpgradeFlow(User user){
		
		List<WebElement> upgradeFields = actions.element().get().allWebElementsWithSameLocator(UPGRADE_NEW_FIELDS);
		if(isSited || TestNGPara.getSite().equalsIgnoreCase("AU")){
			new GenericAssert().assertTrue(upgradeFields.size() == 6, "UPGRADE FORM has issues... Either have More or Less Editable fields than Expected! ").end();;
			this.enterText(upgradeFields.get(0), user.getAddress())
				.enterText(upgradeFields.get(2), user.getCity())
				.enterText(upgradeFields.get(3), user.getZip());
			this.clickThis(UPGRADE_NEW_STATE_SEL)
				.clickThis(By.xpath("//android.widget.CheckedTextView[@text='"+user.getState()+"']"));
			try{
				((MobileElement)upgradeFields.get(5)).setValue(user.getDayPhone2());
			}catch(Exception ex){
				actions.element().click().webElement(upgradeFields.get(5));	
				enterText(upgradeFields.get(5), user.getDayPhone2());	//Entering Phone Number is having Issues
			}
		}
		else if(!isSited){
			new GenericAssert().assertTrue(upgradeFields.size() == 7, "UPGRADE FORM has issues... Either have More or Less Editable fields than Expected! ").end();
			this.enterText(upgradeFields.get(0), user.getAddress())
				.enterText(upgradeFields.get(2), user.getCity())
				.enterText(upgradeFields.get(3), user.getState())
				.enterText(upgradeFields.get(4), user.getZip());
			try{
				((MobileElement)upgradeFields.get(6)).setValue(user.getDayPhone2());
			}catch(Exception ex){
				actions.element().click().webElement(upgradeFields.get(6));	
				enterText(upgradeFields.get(6), user.getDayPhone2());	//Entering Phone Number is having Issues
			}
		}
		else if(!TestNGPara.getSite().equalsIgnoreCase("AU")){
			new GenericAssert().assertTrue(upgradeFields.size() == 5, "UPGRADE FORM has issues... Either have More or Less Editable fields than Expected! ").end();;
			this.enterText(upgradeFields.get(0), user.getAddress())
				.enterText(upgradeFields.get(1), user.getCity() +", "+ user.getState())
				.enterText(upgradeFields.get(2), user.getZip());
			try{
				((MobileElement)upgradeFields.get(4)).setValue(user.getDayPhone2());
			}catch(Exception ex){
				actions.element().click().webElement(upgradeFields.get(4));	
				enterText(upgradeFields.get(4), user.getDayPhone2());	//Entering Phone Number is having Issues
			}
		}
		
		
		this.clickThis(UPGRADE_CONTINUE);
		
		return this;
	}
	
	





}
