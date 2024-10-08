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
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		obj.verifyProductsNameAndPricePresenceAndButtonsEnable();
	}
	@Test
	public void verifyExploreLetterOpenenersButton() {
		obj.verifyExploreLetterOpenenersButton();
	}


}
