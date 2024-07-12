package com.glendale.test.replicaRifles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.ReplicaRifles.RifleAccessoriesPage;

public class RifleAccessories_Test extends BaseClass{
	
	RifleAccessoriesPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new RifleAccessoriesPage(driver);
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
	public void verifyTextOnThePage() {
		obj.verifyTextOnThePage();
	}
	
	@Test
	public void verifyAllFltersEnable() {
		obj.verifyAllFltersEnable();
	}
	@Test
	public void testSortFunctionality() {
		obj.testSortFunctionality();
	}
	@Test
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		obj.verifyProductsNameAndPricePresenceAndButtonsEnable();
	}
	@Test
	public void verifyPaginationEnable() {
		obj.verifyPaginationEnable();
	}
	@Test
	public void verifyPaginationRedirection() {
		obj.verifyPaginationRedirection();
	}

	@Test
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}


}
