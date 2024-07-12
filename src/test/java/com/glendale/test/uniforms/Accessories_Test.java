package com.glendale.test.uniforms;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.Uniforms.AccessoriesPage;

public class Accessories_Test extends BaseClass{

	AccessoriesPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new AccessoriesPage(driver);
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
	public void verifyTextPresenceAndFontSize() {
		obj.verifyTextPresenceAndFontSize();
	}

	@Test
	public void verifyPaginationEnableAndRedirection() {
		obj.verifyPaginationEnableAndRedirection();
	}

	@Test
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		obj.verifyProductsNameAndPricePresenceAndButtonsEnable();
	}	
}
