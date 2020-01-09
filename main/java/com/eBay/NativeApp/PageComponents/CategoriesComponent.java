package com.eBay.NativeApp.PageComponents;

import org.openqa.selenium.WebDriver;

import com.eBay.NativeApp.CustomUtils.CustomTouchUtils;
import com.eBay.NativeApp.Enums.ItemsToSearch.Categories;
import com.eBay.NativeApp.Locators.CategoriesComponentLocators;
import com.ebay.testinfrastructure.webautil.asserts.UIChainAssert;

public class CategoriesComponent extends CategoriesComponentLocators{

	public CategoriesComponent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CategoriesComponent selectCategory(Categories cat){
		
		String[] categoryTree = cat.getCategoryTree().split(">");
		for (String catNode : categoryTree) {
			if(CustomTouchUtils.scrollToElementUsingText(actions, CAT_NODE_NAME, catNode, 10, true))
					actions.element().click().oneFromManyWithSameLocator(CAT_NODE_NAME, catNode);
			else
				new UIChainAssert(driver).generic().fail("CAT_NODE ["+catNode+"] wasn't found!!!");
		}
		
		return this;
	}
	
}
