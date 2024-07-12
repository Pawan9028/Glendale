package com.glendale.test.codets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.codets.CoastGuardPage;

public class CoastGuard_Test extends BaseClass{
	
	CoastGuardPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new CoastGuardPage(driver);
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
	public void verifyFeaturedCollectionTeams() {
		obj.verifyFeaturedCollectionTeams();
	}

	@Test
	public void verifyFeaturedCollectionAccessories() {
		obj.verifyFeaturedCollectionAccessories();
	}

	@Test
	public void verifyFeaturedCollectionFlagsItems() {
		obj.verifyFeaturedCollectionFlagsItems();
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
