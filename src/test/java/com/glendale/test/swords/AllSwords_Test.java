package com.glendale.test.swords;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.swords.AllSwordsPage;

public class AllSwords_Test extends BaseClass{
	
	AllSwordsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new AllSwordsPage(driver);
	}
	@Test
	public void verifyPageURL() {
		obj.verifyPageURL();
	}
	@Test
	public void verifyPageTitle() {
		obj.verifyPageTitle();
	}
	
	@Test
	public void verifyAllFltersEnable() {
		obj.verifyAllFltersEnable();
	}
	@Test
	public void testSortFunctionality() {
		obj.testSortFunctionality();
	}@Test
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		obj.verifyProductsNameAndPricePresenceAndButtonsEnable();
	}
	
	@Test
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}

}
