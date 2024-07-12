package com.glendale.test.uniforms;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.Uniforms.SocksPage;

public class Socks_Test extends BaseClass {

	SocksPage obj;

	@BeforeMethod
	public void loadObject() {
		obj = new SocksPage(driver);
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
	public void verifyProductImageSize() {
		obj.verifyProductImageSize();
	}

	@Test
	public void testSortFunctionality() {
		obj.testSortFunctionality();
	}

	@Test
	public void verifyResponsiveDesign() {
		obj.verifyResponsiveDesign();
	}

	@Test
	public void verifyPageLoadTime() {
		obj.verifyPageLoadTime();
	}

	@Test
	public void verifyCrossBrowserCompatibility() {
		obj.verifyCrossBrowserCompatibility();
	}

	@Test
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		obj.verifyProductsNameAndPricePresenceAndButtonsEnable();
	}

	@Test
	public void verifyAllFltersEnable() {
		obj.verifyAllFltersEnable();
	}
}
