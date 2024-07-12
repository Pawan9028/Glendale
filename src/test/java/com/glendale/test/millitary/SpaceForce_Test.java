package com.glendale.test.millitary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.glendale.base.BaseClass;
import com.glendale.page.millitary.SpaceForcePage;

public class SpaceForce_Test extends BaseClass{
	
	SpaceForcePage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new SpaceForcePage(driver);
	}
	
	@Test
	public void verifyBannerIsPresenceAndShopNowButtonRedirection() {
		obj.verifyBannerIsPresenceAndShopNowButtonRedirection();
	}
	@Test
	public void verifyTextOnTheBanner() throws InterruptedException {
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
