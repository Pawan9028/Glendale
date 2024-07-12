package com.glendale.test.replicaRifles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.ReplicaRifles.RifleSlingsPage;

public class RifleSlings_Test extends BaseClass{
	
	RifleSlingsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new RifleSlingsPage(driver);
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
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}

}
