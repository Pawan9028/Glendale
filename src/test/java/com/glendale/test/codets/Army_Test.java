package com.glendale.test.codets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.glendale.base.BaseClass;
import com.glendale.page.codets.ArmyPage;


public class Army_Test extends BaseClass {

	ArmyPage obj;
	
    @BeforeMethod
	public void loadObject() {
		obj = new ArmyPage(driver);
	}

	@Test
	public void verifyBannerIsPresenceAndShopNowButtonRedirection() throws InterruptedException {
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
