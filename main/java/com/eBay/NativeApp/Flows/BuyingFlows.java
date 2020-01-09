package com.eBay.NativeApp.Flows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eBay.NativeApp.Pages.ViewItemPage;
import com.ebay.soap.eBLBaseComponents.BidActionCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.testinfrastructure.asserts.GenericAssert;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class BuyingFlows {

	/**
	 * Specify Quantity need be purcahsed, if specified quantity exceeds total available quantity, Total available Quantity will be purcahsed
	 */
	public static void purchaseThisItem(ItemType item, int quantity){

		if(quantity > item.getQuantity().intValue())
			quantity = item.getQuantity().intValue();
		
		WebDriver driver = UIListener.uiDriver.get();
		if(item.getListingType().equals(ListingTypeCodeType.AUCTION)
				|| item.getListingType().equals(ListingTypeCodeType.CHINESE)){
			new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().placeBID(item.getStartPrice().getValue()+1.00, false, 0);
			new ReportLogger().logBoldStep("BID placed on item: ["+item.getItemID()+"]");
		}
		else if(item.getListingType().equals(ListingTypeCodeType.FIXED_PRICE_ITEM) &&
				item.getBestOfferDetails().isBestOfferEnabled()){
			if(item.getDescription().contains("ACCEPT")){
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().placeOffer(false, quantity, item.getStartPrice().getValue()-0.50);
				new ReportLogger().logBoldStep("Offer placed on item: ["+item.getItemID()+"] for Auto-Accept");
			}
			else if(item.getDescription().contains("DECLINE")){
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().placeOffer(false, quantity, item.getStartPrice().getValue()-3.50);
				new ReportLogger().logBoldStep("Offer placed on item: ["+item.getItemID()+"] for Auto-Decline");
			}
			else{
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().placeOffer(false, quantity, item.getStartPrice().getValue()-1.00);
				new ReportLogger().logBoldStep("Offer placed on item: ["+item.getItemID()+"]");
			}
		}
		else if(item.getListingType().equals(ListingTypeCodeType.FIXED_PRICE_ITEM)){
			new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().makeBINPurchase(false, quantity);
			new ReportLogger().logBoldStep("Purchased item: ["+item.getItemID()+"]");
		}
	}
	
	/**
	 * @param buyAs - supply value as either AUCTION or FIXED_PRICE_ITEM
	 */
	public static void purchaseABINItem(ItemType item, ListingTypeCodeType buyAs){
		WebDriver driver = UIListener.uiDriver.get();
		if(item.getListingType().equals(ListingTypeCodeType.CHINESE)){
			if(buyAs.equals(ListingTypeCodeType.AUCTION))
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().placeBID(item.getStartPrice().getValue()+1.00, false, 0);
			else if(buyAs.equals(ListingTypeCodeType.FIXED_PRICE_ITEM))
				new ViewItemPage(driver).getViewItemPageComponent().getBuyerViewItemPageActions().makeBINPurchase(false, 1);
		}
		else
			Assert.fail("INVALID Item & Purchase Options!!!");
		
	}

	/**Use values for BidActionCodeType as:
	 *<br>ACCEPT <br>DECLINE <br>COUNTER
	 */
	public static void respondToOffer(ItemType item, BidActionCodeType action, int quantity){
		/*WebDriver driver = UIListener.uiDriver.get();*/
		if(item.getListingType().equals(ListingTypeCodeType.FIXED_PRICE_ITEM) &&
				item.getBestOfferDetails().isBestOfferEnabled()){
			switch (action) {
			case ACCEPT:
				break;
			
			case DECLINE:
				break;
			
			case COUNTER:
				break;	
			default: new GenericAssert().fail("Incorrect Action chosen to Respond to Offer Placed!!!");
				break;
			}
			
		}
	}
	
}
