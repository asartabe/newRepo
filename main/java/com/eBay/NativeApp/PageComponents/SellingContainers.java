package com.eBay.NativeApp.PageComponents;

import com.eBay.NativeApp.Enums.SellContainerEnums.SellContainer;
import com.eBay.NativeApp.Enums.SellContainerEnums.SellContainerFilters;

public interface SellingContainers {
	
	public SellingContainers switchContainer(SellContainer container);
	
	public SellingContainers filterContainerItems(SellContainerFilters filter);
	
	public SellingContainers deleteItem(String itemTitle);
	
}
