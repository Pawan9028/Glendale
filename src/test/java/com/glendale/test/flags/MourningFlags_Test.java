package com.glendale.test.flags;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.flags.MourningFlagsPage;

public class MourningFlags_Test extends BaseClass{
	
	MourningFlagsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new MourningFlagsPage(driver);
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
