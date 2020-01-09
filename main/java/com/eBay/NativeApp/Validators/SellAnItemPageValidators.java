package com.eBay.NativeApp.Validators;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.Pages.SellAnItemPage;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.actions.WebActions;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;
import com.ebay.testinfrastructure.webautil.validator.IValidator;
import com.ebay.testinfrastructure.webautil.validator.UIValidator;
import com.ebay.testinfrastructure.webautil.validator.Validator;

public class SellAnItemPageValidators implements IValidator{
	
	WebDriver driver;
	WebActions actions;
	UIChainAssert uiChainAssert;
	ReportLogger breezeReport;
	boolean isAssertSetByPartner;
	SellAnItemPage syi;
	
	private SellAnItemPageValidators(WebDriver driver, WebActions actions,
			UIChainAssert uiChainAssert, ReportLogger breezeReport) {
		this.driver = driver;
		this.actions = actions;
		this.breezeReport = breezeReport;
		this.uiChainAssert = uiChainAssert;
	}

	public static class Use extends UIValidator<SellAnItemPageValidators.Use> {
		public SellAnItemPageValidators validate(WebDriver driver) {
			/*ensures that both Breeze projects and non breeze projects can use this Validator.*/
			actions = isWebActionsNotNull() ? actions : new WebActions(driver);
			uiAssert = isUIAssertNotNull() ? uiAssert : new UIChainAssert(driver);
			return new SellAnItemPageValidators(driver, actions, uiAssert, breezeReport);
		}
	}

	public List<String> getAllFailures() {
		return uiChainAssert.getAllFailuresInCurrentAssertorInstance();

	}

	public SellAnItemPageValidators setSellAnItemPage(SellAnItemPage syi){
		this.syi = syi;
		return this;
	}
	
	@Validator
	public SellAnItemPageValidators validateCatalogProductSuggestions(){
		uiChainAssert.element()
			.present(syi.getSellAnItemPageComponent().CATALOG_OPTIONS_HDR, "Catalog Suggestions section Header is missing")
			.present(syi.getSellAnItemPageComponent().CATALOG_PROD, "Catalog Suggestions/Products are missing")
				.withinParent(syi.getSellAnItemPageComponent().CATALOG_PROD)
				.present(syi.getSellAnItemPageComponent().CATALOG_PROD_IMG, "Catalog Suggested product image is missing")
				.present(syi.getSellAnItemPageComponent().CATALOG_PROD_TITLE, "Catalog Suggested product title is missing");
		return this;
	}
	
	@Validator
	public SellAnItemPageValidators validateTitleText(ItemType item){
		uiChainAssert.element()
			.present(syi.getSellAnItemPageComponent().ITEM_TITLE_CELL, "")
			.attributeValueContains(syi.getSellAnItemPageComponent().ITEM_TITLE_CELL, 
					"name", item.getTitle(), "Listing Title mis-match for Catalog Product");
		return this;
	} 
	
	@Validator
	public SellAnItemPageValidators validateSuggestedPostage(){
		uiChainAssert.element()
			.present(syi.getSellAnItemPageComponent().ITEM_POSTAGE_CELL, "")
			.attributeValueContains(syi.getSellAnItemPageComponent().ITEM_POSTAGE_CELL, 
					"name", "Suggested postage", "Suggested postage is missing");
		return this;
	}
	
	@Validator
	public SellAnItemPageValidators validateNoSuggestedPostage(){
		uiChainAssert.element()
			.present(syi.getSellAnItemPageComponent().ITEM_POSTAGE_CELL, "");
		String attrib = actions.element().get().webElement(syi.getSellAnItemPageComponent().ITEM_POSTAGE_CELL).getAttribute("name");
		uiChainAssert.string()
			.notContains(attrib, "Suggested postage", "Sugges postage should not be present (after Category Change)");
		
		return this;
	}
	
	@Validator
	public SellAnItemPageValidators validateCatalogCategoryChangeAlert(){
		uiChainAssert.element()
			.present(syi.getSellAnItemPageComponent().CATALOG_CAT_CHNG_ALERT_TITLE, "Catalog Product Category Change alert title is missing")
			.present(syi.getSellAnItemPageComponent().CATALOG_CAT_CHNG_ALERT_CONTENT, "Catalog Product Category Change alert content is missing")
			.present(syi.getSellAnItemPageComponent().CATALOG_CAT_CHNG_ALERT_OK, "")
			.present(syi.getSellAnItemPageComponent().CATALOG_CAT_CHNG_ALERT_CANCEL, "");
		return this;
	}
	
	
	
	
}
