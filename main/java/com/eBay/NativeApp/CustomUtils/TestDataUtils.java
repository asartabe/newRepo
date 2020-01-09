package com.eBay.NativeApp.CustomUtils;

import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.testinfrastructure.params.TestParams;

/**
 * @author dthorecha
 *
 */
public class TestDataUtils {
	
	/**Sets Auto Accept & Decline BO Prices.
	 * <br> Accept Price is set to 1$ less than Start-Price
	 * <br> Decline Price is set to 3$ less than Start Price
	 */
	public static ItemType setAutoBODetails(ItemType item){
		ListingDetailsType autoBODetails = new ListingDetailsType();
		AmountType decAmt = new AmountType(), accptAmt = new AmountType();
		decAmt.setValue(item.getStartPrice().getValue()-3.00);
		autoBODetails.setMinimumBestOfferPrice(decAmt);
		accptAmt.setValue(item.getStartPrice().getValue()-1.00);
		autoBODetails.setBestOfferAutoAcceptPrice(accptAmt);
		item.setListingDetails(autoBODetails);
		return item;
	}
	
	/**Updates Currency, Country & Postage Details for <b>item</b>
	 * <br>Currently changes above parameters to SINGAPORE
	 * <br><br>Assumes both Domestic & International Postages are available
	 */
	public static ItemType getCBT_Item(ItemType item){
		ItemType cbtItem = item;
		if(TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU")){
			cbtItem.setCurrency(CurrencyCodeType.SGD);
			cbtItem.setSite(SiteCodeType.SINGAPORE);
			cbtItem.setCountry(CountryCodeType.SG);
			cbtItem.setPostalCode("554914");
			cbtItem.setLocation(SiteCodeType.SINGAPORE.value());

			ShippingDetailsType shipDetails = cbtItem.getShippingDetails();
			ShippingServiceOptionsType[] shipOptions = shipDetails.getShippingServiceOptions();
			shipOptions[0].setShippingService(ShippingServiceCodeType.SG_DOMESTIC_STANDARD_MAIL.value());

			InternationalShippingServiceOptionsType[] intl = shipDetails.getInternationalShippingServiceOption();
			intl[0].setShippingService("SG_StandardInternationalShipping");

			shipDetails.setShippingServiceOptions(shipOptions);
			cbtItem.setShippingDetails(shipDetails);
		}
		return cbtItem;
	}
	
}
