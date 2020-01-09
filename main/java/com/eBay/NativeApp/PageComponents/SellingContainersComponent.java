package com.eBay.NativeApp.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eBay.NativeApp.Enums.SellContainerEnums.SellContainer;
import com.eBay.NativeApp.Enums.SellContainerEnums.SellContainerFilters;
import com.eBay.NativeApp.Locators.SellingContainersLocators;

public class SellingContainersComponent extends SellingContainersLocators{

	public SellingContainersComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SellingContainersComponent showContainer(SellContainer container){
		switch (container) {
		case ACTIVE:actions.element().click().by(TAB_ACTIVE);break;
		case SOLD:actions.element().click().by(TAB_SOLD);break;
		case UNSOLD:actions.element().click().by(TAB_UNSOLD);break;
		}
		return this;
	}

	public ActiveContainer getActiveContainer(){
		return new ActiveContainer();
	}

	public SoldContainer getSoldContainer(){
		return new SoldContainer();
	}

	public UnsoldContainer getUnsoldContainer(){
		return new UnsoldContainer();
	}


	/*=====================================================
	 * Container CLASSES
	 * =====================================================*/

	public class ActiveContainer implements SellingContainers{
		public ActiveContainer(){}

		@Override
		public SellingContainers switchContainer(SellContainer container) {
			showContainer(container);
			return new ActiveContainer();
		}

		@Override
		public SellingContainers filterContainerItems(SellContainerFilters filter) {
			actions.element().click().by(FILTER_BTN);
			switch (filter) {
			case ALL:
				actions.element().click().by(FILTER_OPT_ALL);
				break;
			case ACTIVE_AUCTIONS:
				actions.element().click().by(FILTER_ACTIVE_OPT_AUCTIONS);
				break;
			case ACTIVE_FIXEDPRICE:
				actions.element().click().by(FILTER_ACTIVE_OPT_FIXEDPRICE);
				break;
			case ACTIVE_NEWOFFERS:
				actions.element().click().by(FILTER_ACTIVE_OPT_HAVEOFFERS);
				break;

			default:breezeReport.logRedStep("Incorrect Filter Option Selected: "+filter.name()+"\nDefaulting to ALL");
					filterContainerItems(SellContainerFilters.ALL);
				break;
			}
			return new ActiveContainer();
		}

		@Override
		public SellingContainers deleteItem(String itemTitle) {
			breezeReport.logRedStep("No EDIT/DELETE available for current Container!!!");
			return new ActiveContainer();
		}

	}

	public class SoldContainer implements SellingContainers{
		public SoldContainer(){}

		@Override
		public SellingContainers switchContainer(SellContainer container) {
			showContainer(container);
			return new SoldContainer();
		}

		@Override
		public SellingContainers filterContainerItems(SellContainerFilters filter) {
			actions.element().click().by(FILTER_BTN);
			switch (filter) {
			case ALL:
				actions.element().click().by(FILTER_OPT_ALL);
				break;
			case SOLD_AWAITINGPAYMENT:
				actions.element().click().by(FILTER_SOLD_OPT_AWTNG_PAY);
				break;
			case SOLD_PAID_SENDNOW:
				actions.element().click().by(FILTER_SOLD_OPT_PAID_SENDNOW);
				break;
			
			default:breezeReport.logRedStep("Incorrect Filter Option Selected: "+filter.name()+"\nDefaulting to ALL");
					filterContainerItems(SellContainerFilters.ALL);
			break;
			}
			return new SoldContainer();
		}

		@Override
		public SellingContainers deleteItem(String itemTitle) {
			int counter = 0; 
			boolean flag = false;
			
			actions.element().click().by(EDIT_BTN);
			do{
				List<WebElement> items = actions.element().get().allWebElementsWithSameLocator(ITEM_CONTAINER);
				for (WebElement item : items) {
					if(itemTitle.contains(actions.element().withinParent(item).get().text(SOLD_ITM_TITLE, ""))){
						flag = true;
						actions.element().withinParent(item).click().by(ITM_CHKBX);
						break;
					}
				}
				++counter;
			}while((counter < 3) && !flag);
			actions.element().click().by(DELETE_BTN);
			actions.element().click().by(DELETE_YES);
			
			return new SoldContainer();
		}
		
		public SellingContainers deleteItem(boolean multiple) {
			actions.element().click().by(EDIT_BTN);
			List<WebElement> chkBoxes = actions.element().get().allWebElementsWithSameLocator(ITM_CHKBX);
			if(multiple){
				for (WebElement chkbx : chkBoxes)
					actions.element().click().webElement(chkbx);
			}
			else
				actions.element().click().webElement(chkBoxes.get(0));
			actions.element().click().by(DELETE_BTN);
			actions.element().click().by(DELETE_YES);
			return new SoldContainer();
		}
		
	}

	public class UnsoldContainer implements SellingContainers{
		public UnsoldContainer(){}

		@Override
		public SellingContainers switchContainer(SellContainer container) {
			showContainer(container);
			return new UnsoldContainer();
		}

		@Override
		public SellingContainers filterContainerItems(SellContainerFilters filter) {
			breezeReport.logRedStep("No Filters available for current Container!!!");
			return new UnsoldContainer();
		}

		@Override
		public SellingContainers deleteItem(String itemTitle) {
			int counter = 0; 
			boolean flag = false;
			
			actions.element().click().by(EDIT_BTN);
			do{
				List<WebElement> items = actions.element().get().allWebElementsWithSameLocator(ITEM_CONTAINER);
				for (WebElement item : items) {
					if(itemTitle.contains(actions.element().withinParent(item).get().text(UNSOLD_ITM_TITLE, ""))){
						flag = true;
						actions.element().withinParent(item).click().by(ITM_CHKBX);
						break;
					}
				}
				++counter;
			}while((counter < 3) && !flag);
			actions.element().click().by(DELETE_BTN);
			actions.element().click().by(DELETE_YES);
			
			return new UnsoldContainer();
		}
		
		public SellingContainers deleteItem(boolean multiple) {
			actions.element().click().by(EDIT_BTN);
			List<WebElement> chkBoxes = actions.element().get().allWebElementsWithSameLocator(ITM_CHKBX);
			if(multiple){
				for (WebElement chkbx : chkBoxes)
					actions.element().click().webElement(chkbx);
			}
			else
				actions.element().click().webElement(chkBoxes.get(0));
			actions.element().click().by(DELETE_BTN);
			actions.element().click().by(DELETE_YES);
			return new SoldContainer();
		}
		
	}

}
