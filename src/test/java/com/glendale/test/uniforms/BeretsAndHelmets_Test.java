package com.glendale.test.uniforms;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.Uniforms.BeretsAndHelmetsPage;

public class BeretsAndHelmets_Test extends BaseClass{
	
	BeretsAndHelmetsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new BeretsAndHelmetsPage(driver);
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
