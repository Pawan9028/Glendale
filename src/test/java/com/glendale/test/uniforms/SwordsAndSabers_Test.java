package com.glendale.test.uniforms;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.Uniforms.SwordsAndSabersPage;

public class SwordsAndSabers_Test extends BaseClass{
	SwordsAndSabersPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new SwordsAndSabersPage(driver);
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
	@Test
	public void verifyPaginationEnable() {
		obj.verifyPaginationEnable();
	}
	@Test
	public void verifyPaginationRedirection() {
		obj.verifyPaginationRedirection();
	}
	@Test
	public void verifyExploreLetterOpenenersButton() {
		obj.verifyExploreLetterOpenenersButton();
	}

}
