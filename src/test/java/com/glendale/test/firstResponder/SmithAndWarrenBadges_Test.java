package com.glendale.test.firstResponder;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.firstResponder.SmithAndWarrenBadgesPage;

public class SmithAndWarrenBadges_Test extends BaseClass{
	
	SmithAndWarrenBadgesPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new SmithAndWarrenBadgesPage(driver);
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
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}

}
