package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.Enums.Feedback;
import com.eBay.NativeApp.Pages.FeedbackDetailsPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class FeedbackDetailsPageValidators implements IValidator{

	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	FeedbackDetailsPage fdPage;
	
	private FeedbackDetailsPageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<FeedbackDetailsPageValidators.Use> {
		public FeedbackDetailsPageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new FeedbackDetailsPageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public FeedbackDetailsPageValidators setFeedbackDetailsPage(FeedbackDetailsPage fdPage){
		this.fdPage = fdPage;
		return this;
	}
	
	private static Feedback fdType = Feedback.ALL;
	private void setFeedbackType(Feedback fd){
		fdType = fd;
		/*String current = actions.element().withinParent(fdPage.getFeedbackPageActionsComponent().FEEDBACK_TYPE_DROPDWN)
				.get().text(fdPage.getFeedbackPageActionsComponent().FEEDBACK_TYPE_CURRENT, "");
		if(current.contentEquals("Positive"))
			fdType = Feedback.POSITIVE;
		else if(current.contentEquals("Neutral"))
			fdType = Feedback.NEUTRAL;
		else if(current.contentEquals("Negative"))
			fdType = Feedback.NEGATIVE;*/
	}
	@Validator
	public FeedbackDetailsPageValidators validateCurrentFeedbackSelection(Feedback fd){
		uiChainAssert.element()
			.present(fdPage.getFeedbackPageActionsComponent().FEEDBACK_TYPE_DROPDWN, "Feedback Type dropdown is missing")
			.withinParent(fdPage.getFeedbackPageActionsComponent().FEEDBACK_TYPE_DROPDWN)
				.present(fdPage.getFeedbackPageActionsComponent().FEEDBACK_TYPE_CURRENT, "Feedback Type name is missing");
		setFeedbackType(fd);
		return this;
	}
	
	@Validator
	public FeedbackDetailsPageValidators validateFeedbackContent(){

		if(actions.element().present().byCustomPolling(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITEMS, 5)){		

			List<WebElement> fdbItems = actions.element().get().allWebElementsWithSameLocator(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITEMS);
			fdbItems.remove(fdbItems.size()-1);
			/*int counter = 0;*/ 
			for (WebElement fdbItem : fdbItems) {
				uiChainAssert.element()
					.withinParent(fdbItem)
						.present(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITM_TYPE, "Feedback Type for Feedback")
						.present(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITM_TITLE, "Feedback Title for Feedback")
						.present(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITM_USER, "Feedback User details for Feedback")
						.present(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITM_DATE, "Feedback Date for Feedback");
				
				if(fdType.equals(Feedback.POSITIVE) || fdType.equals(Feedback.NEUTRAL) || fdType.equals(Feedback.NEGATIVE)){
					/*String attribVal = actions.element().get().allWebElementsWithSameLocator(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITM_TYPE).get(counter).getAttribute("name");*/
					switch (fdType) {
					case POSITIVE:	/*uiChainAssert.string().equals("Positive", attribVal, "Feedback Type is incorrect for Feedback");*/
						uiChainAssert.element()
									.withinParent(fdbItem)
									.attributeValueMatches(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITM_TYPE, "name", "Positive", "Feedback Type is incorrect for Feedback");
						break;

					case NEUTRAL:	/*uiChainAssert.string().equals("Neutral", attribVal, "Feedback Type is incorrect for Feedback");*/
						uiChainAssert.element()
									.withinParent(fdbItem)
										.attributeValueMatches(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITM_TYPE, "name", "Neutral", "Feedback Type is incorrect for Feedback");
						break;

					case NEGATIVE:	/*uiChainAssert.string().equals("Negative", attribVal, "Feedback Type is incorrect for Feedback");*/
						uiChainAssert.element()
									.withinParent(fdbItem)
										.attributeValueMatches(fdPage.getFeedbackPageActionsComponent().FEEDBACK_ITM_TYPE, "name", "Negative", "Feedback Type is incorrect for Feedback");
						break;
					default:break;
					}
				}
				/*++counter;*/
			}
		}
		else
			breezeReport.logRedStep("No Feedbacks for the User for FeedbackType ["+fdType.name()+"]");

		return this;
	}
	
	
	
	
	
	
	
	
	
	
}
