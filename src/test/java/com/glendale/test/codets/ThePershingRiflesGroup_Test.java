package com.glendale.test.codets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.codets.ThePershingRiflesGroupPage;

public class ThePershingRiflesGroup_Test extends BaseClass{
	
	ThePershingRiflesGroupPage obj;

	@BeforeMethod
	public void loadObject() {
		obj = new ThePershingRiflesGroupPage(driver);
	}
	
	@Test
	public void verifyPageTitle() {
		obj.verifyPageTitle();
	}

	@Test
	public void verifyCurrentURL() throws InterruptedException {
		obj.verifyCurrentURL();
	}

	@Test
	public void verifyMainImgOnThePageLoadingAndText() {
		obj.verifyMainImgOnThePageLoadingAndText();
	}

	@Test
	public void verifySortByFilterEnable() {
		obj.verifySortByFilterEnable();
	}

	@Test
	public void verifyAllFltersEnable() {
		obj.verifyAllFltersEnable();
	}

	@Test
	public void verifyAllProductsOnThePageLoaded() {
		obj.verifyAllProductsOnThePageLoaded();
	}

	@Test
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		obj.verifyProductsNameAndPricePresenceAndButtonsEnable();
	}

	@Test
	public void verifyPaginationIsClickable() {
		obj.verifyPaginationIsClickable();
	}

	@Test
	public void verifyPageLoadTime() {
		obj.verifyPageLoadTime();
	}

	@Test
	public void verifyResponsiveDesign() {
		obj.verifyResponsiveDesign();
	}

	@Test
	public void verifyAccessibility() {
		obj.verifyAccessibility();
	}
	@Test
	public void verifyCrossBrowserCompatibility() {
		obj.verifyCrossBrowserCompatibility();
	}
}
