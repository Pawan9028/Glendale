package com.glendale.test.swords;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.swords.CeremonialMillitarySwordsPage;

public class CeremonialMillitarySwords_Test extends BaseClass{
	
	CeremonialMillitarySwordsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new CeremonialMillitarySwordsPage(driver);
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

	public void testBranchDropdown() {
		obj.testBranchDropdown();
	}
	
	@Test
	public void testNameDropdown() {
		obj.testNameDropdown();
	}
	
	@Test
	public void testLengthDropdown() {
		obj.testLengthDropdown();
	}
	
	@Test
	public void testBranchDropdownOptions() {
		obj.testBranchDropdownOptions();
	}
	@Test
	public void testLengthDropdownOptions() {
		obj.testLengthDropdownOptions();
	}
	@Test
	public void testNameDropdownOptions() {
		obj.testNameDropdownOptions();
	}
	
	@Test
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}
	@Test
	public void verifyTitleOfTheProductIsPresent() {
		obj.verifyTitleOfTheProductIsPresent();
	}
	@Test
	public void verifyPriceOfTheProductIsPresence() {
		obj.verifyPriceOfTheProductIsPresence();
	}
	@Test
	public void veryImageOfTheProductIsPresence() {
		obj.veryImageOfTheProductIsPresence();
	}
	@Test
	public void verifyDescriptionOfTheProduct() {
		obj.verifyDescriptionOfTheProduct();
	}
	@Test
	public void verifyRelatedProductSection() {
		obj.verifyRelatedProductSection();
	}
	@Test
	public void verifyTestimonialSectionIsPresence() {
		obj.verifyTestimonialSectionIsPresence();
	}
	@Test
	public void verifyAddToCartButtonPresence() {
		obj.verifyAddToCartButtonPresence();
	}
	@Test
	public void verifyAddToCartButtonFunctionality() {
		obj.verifyAddToCartButtonFunctionality();
	}
	@Test
	public void testProductIncreaseButton() {
		obj.testProductIncreaseButton();
	}
	@Test
	public void testProductDecreaseButton() {
		obj.testProductDecreaseButton();
	}


}
