package com.glendale.test.millitary;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.millitary.CoastGuardPage;

public class CoastGuard_Test extends BaseClass {
	
	//WebDriver driver;

	CoastGuardPage obj;
	
	@BeforeMethod
	public void loadObjects() {
		obj = new CoastGuardPage(driver);
	}
	@Test
	public void verifyBannerIsPresenceAndShopNowButtonRedirection() {
		obj.verifyBannerIsPresenceAndShopNowButtonRedirection();
	}
	@Test
	public void verifyTextOnTheBanner() {
		obj.verifyTextOnTheBanner();
	}
	@Test
	public void verifyFeaturedCollectionUniformItems() {
		obj.verifyFeaturedCollectionUniformItems();
	}
	@Test
	public void verifyFeaturedCollectionFlags() {
		obj.verifyFeaturedCollectionFlags();
	}
	@Test
	public void verifyFeaturedCollectionFlagAccessories() {
		obj.verifyFeaturedCollectionFlagAccessories();
	}
	
	@Test
	public void verifyFeaturedCollectionCeremonialItems() {
		obj.verifyFeaturedCollectionCeremonialItems();
	}
	@Test
	public void verifyFlagsSectionPresenceAndRediredirection() {
		obj.verifyFlagsSectionPresenceAndRediredirection();
	}
	@Test
	public void verifyCustomFlagsSectionPresenceAndRediredirection() {
		obj.verifyCustomFlagsSectionPresenceAndRediredirection();
	}
	@Test
	public void verifyBunleProductSectionPresenceWithProducts() {
		obj.verifyBunleProductSectionPresenceWithProducts();
	}
	@Test
	public void verifyBestSellersSectionPresence() {
		obj.verifyBestSellersSectionPresence();
	}
	@Test
	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		obj.verifyIconsBelowTheBestSellersIsPresenceAndNavigation();
	}
}
