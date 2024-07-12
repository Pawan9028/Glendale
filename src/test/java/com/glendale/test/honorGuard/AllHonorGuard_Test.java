package com.glendale.test.honorGuard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.honorGuard.AllHonorGuardPage;

public class AllHonorGuard_Test extends BaseClass{

	AllHonorGuardPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new AllHonorGuardPage(driver);
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
	}
	@Test
	public void verifyTextPresenceAndFontSize() {
		obj.verifyTextPresenceAndFontSize();
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
	public void verifyBundleProducts() {
		obj.verifyBundleProducts();
	}
}
