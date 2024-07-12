package com.glendale.test.millitary;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.millitary.AirForcePage;

public class AirForce_Test extends BaseClass{

	
	AirForcePage af;
	
	@BeforeMethod
	public void loadObjects() {
		af = new AirForcePage(driver);
	}
	@Test
	public void verifyBannerIsPresenceAndShopNowButtonRedirection() {
		af.verifyBannerIsPresenceAndShopNowButtonRedirection();
	}
	@Test
	public void verifyFeaturedCollectionUniformItems() {
		af.verifyFeaturedCollectionUniformItems();
	}
	@Test
	public void verifyFeaturedCollectionFlags() {
		af.verifyFeaturedCollectionFlags();
	}
	@Test
	public void verifyFeaturedCollectionFlagAccessories() {
		af.verifyFeaturedCollectionFlagAccessories();
	}
	
	@Test
	public void verifyFeaturedCollectionCeremonialItems() {
		af.verifyFeaturedCollectionCeremonialItems();
	}
	@Test
	public void verifyFlagsSectionPresenceAndRediredirection() {
		af.verifyFlagsSectionPresenceAndRediredirection();
	}
	@Test
	public void verifyCustomFlagsSectionPresenceAndRediredirection() {
		af.verifyCustomFlagsSectionPresenceAndRediredirection();
	}
	@Test
	public void verifyBunleProductSectionPresenceWithProducts() {
		af.verifyBunleProductSectionPresenceWithProducts();
	}
	@Test
	public void verifyBestSellersSectionPresence() {
		af.verifyBestSellersSectionPresence();
	}
	@Test
	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		af.verifyIconsBelowTheBestSellersIsPresenceAndNavigation();
	}
}
