package com.glendale.test.aboutUs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.aboutUs.ContactUsPage;

public class ContactUs_Test extends BaseClass{
	
	ContactUsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new ContactUsPage(driver);
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
	public void verifyAddressSection() {
		obj.verifyAddressSection();
	}
	@Test
	public void verifyPhoneSection() {
		obj.verifyPhoneSection();
	}
	@Test
	public void verifyEmailSection() {
		obj.verifyEmailSection();
	}
	@Test
	public void verifyHeading() {
		obj.verifyHeading();
	}
	@Test
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}
	
}
