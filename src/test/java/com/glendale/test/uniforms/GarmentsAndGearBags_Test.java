package com.glendale.test.uniforms;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.Uniforms.GarmentAndGearBagsPage;

public class GarmentsAndGearBags_Test extends BaseClass{
	
	GarmentAndGearBagsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new GarmentAndGearBagsPage(driver);
	}
	@Test
	public void verifyPageTitle() {
		obj.verifyPageTitle();
	}

	@Test
	public void verifyPageURL() {
		obj.verifyPageURL();
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
	public void verifyProductButtonAddToCartAndSelectPresenceAndClickable() {
		obj.verifyProductButtonAddToCartAndSelectPresenceAndClickable();
	}
}
