package com.glendale.test.aboutUs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.aboutUs.AllAboutUsPage;

public class AllAboutUs_Test extends BaseClass{

	AllAboutUsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new AllAboutUsPage(driver);
	}
	@Test
	public void verifyAddreddAndPhoneEnable() {
		obj.verifyAddreddAndPhoneEnable();
	}
	
	@Test
	public void verifyComeVisitUsInPersonSection() {
		obj.verifyComeVisitUsInPersonSection();
	}
	
	@Test

	public void verifyOurServiceSection() {
		obj.verifyOurServiceSection();
	}
	@Test
	public void verifyOurStorySection() {
		obj.verifyOurStorySection();
	}
	
	@Test
	public void verifyHeading() {
		obj.verifyHeading();
	}
	
	@Test

	public void verifyBannerPesence() {
		obj.verifyBannerPesence();
	}
	@Test
	public void verifyPageURL() {
		obj.verifyPageURL();
	}
	
	@Test
	public void verifyTitlOfThePage() {
		obj.verifyTitlOfThePage();
	}
	
	@Test

	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}
}
