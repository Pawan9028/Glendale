package com.glendale.test.firstResponder;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.firstResponder.BadgeHoldersAndWalletsPage;

public class BadgeHoldersWallets_Test extends BaseClass{
	
	BadgeHoldersAndWalletsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new BadgeHoldersAndWalletsPage(driver);
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
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		obj.verifyProductsNameAndPricePresenceAndButtonsEnable();
	}
	@Test
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}
}
