package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.RespondOffersPage;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class ReviewOfferValidators implements IValidator{
	
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	RespondOffersPage rvwOffer;
	
	private ReviewOfferValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<ReviewOfferValidators.Use> {
		public ReviewOfferValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new ReviewOfferValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public ReviewOfferValidators setRespondOffersPage(RespondOffersPage rvwOffer){
		this.rvwOffer = rvwOffer;
		return this;
	}
	
	@Validator
	private ReviewOfferValidators validateItemDetails(){
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().PANEL_ITM_DETAILS, "Item details panel is missing")
			.withinParent(rvwOffer.getRespondOffersComponent().PANEL_ITM_DETAILS)
				.present(rvwOffer.getRespondOffersComponent().ITM_IMG, "Item Image is missing")
				.present(rvwOffer.getRespondOffersComponent().ITM_TITLE, "Item Title is missing")
				.present(rvwOffer.getRespondOffersComponent().ITM_PRICE, "Item Price is missing")
				/*.present(rvwOffer.getRespondOffersComponent().ITM_POSTAGE, "Item Postage details are missing")*/;
		return this;
	}
	
	@Validator
	private ReviewOfferValidators validateCTAButtons(){
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().BTN_ACCEPT, "ACCEPT Button is missing")
			.present(rvwOffer.getRespondOffersComponent().BTN_COUNTER, "COUNTER Button is missing")
			.present(rvwOffer.getRespondOffersComponent().BTN_DECLINE, "DECLINE Button is missing");
		return this;
	}
	
	@Validator
	public ReviewOfferValidators validateReviewOfferLandingPage(){
		validateItemDetails();
		
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().PANEL2_OFFER_DETAILS, "Offer details Panel is missing")
			.withinParent(rvwOffer.getRespondOffersComponent().PANEL2_OFFER_DETAILS)
				.present(rvwOffer.getRespondOffersComponent().PANEL2_BUYER, "Buyer-ID is missing")
				.present(rvwOffer.getRespondOffersComponent().PANEL2_BUYERADDR, "Buyer Address is missing")
				.present(rvwOffer.getRespondOffersComponent().PANEL2_EXPIRETIME, "TIme Left to Offer Expire is missing")
				.present(rvwOffer.getRespondOffersComponent().PANEL2_OFFERPRICE, "Offered Price is missing")
				.present(rvwOffer.getRespondOffersComponent().PANEL2_QTY, "Quantity is missing")
				.present(rvwOffer.getRespondOffersComponent().PANEL2_REMAINING, "Remaining Offers is missing");
		
		validateCTAButtons();
		
		return this;
	}
	
	@Validator
	public ReviewOfferValidators validateAcceptOfferPage(){
		validateItemDetails();
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().LEGAL_TERMS_ACCEPT, "Legal Terms for Offer Acceptance is missing")
			.present(rvwOffer.getRespondOffersComponent().BTN_ACCEPT_CONFIRM, "Confirm Offer Accept Button is missing");
		return this;
	}
	
	@Validator
	public ReviewOfferValidators validateDeclineOfferPage(){
		validateItemDetails();
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().DEC_MESSAGE, "Decline Message Box is missing")
			.present(rvwOffer.getRespondOffersComponent().BTN_DECLINE_CONFIRM, "Confirm Offer Decline Button is missing");
		return this;
	}
	
	@Validator
	public ReviewOfferValidators validateCounterOfferPage(){
		validateItemDetails();
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().CTR_OFFER_TXT, "Couner Offer Price TextBox is missing")
			.present(rvwOffer.getRespondOffersComponent().CTR_RVW_OFFER, "Review Counter Offer Button is missing");
		return this;
	}
	
	@Validator
	public ReviewOfferValidators validateSuccessAcceptMessage(){
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().SUCCESS_MSG_ACCEPT, "Offer Accepted Success Message is missing");
		return this;
	}
	
	@Validator
	public ReviewOfferValidators validateSuccessCounterMessage(){
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().SUCCESS_MSG_COUNTER, "Offer Countered Success Message is missing");
		return this;
	}
	
	@Validator
	public ReviewOfferValidators validateSuccessDeclineMessage(){
		uiChainAssert.element()
			.present(rvwOffer.getRespondOffersComponent().SUCCESS_MSG_DECLINE, "Offer Declined Success Message is missing");
		return this;
	}
	
	
	
	
}
