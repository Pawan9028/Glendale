package com.glendale.test.flags;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.flags.AllFlagsPage;

public class AllFlags_Test extends BaseClass{
	
	AllFlagsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new AllFlagsPage(driver);
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
	public void verifyBannerIsPresence() {
		obj.verifyBannerIsPresence();
	}
	@Test
	public void verifyTextOnTheBanner() {
		obj.verifyTextOnTheBanner();
	}
	@Test
	public void verifyFeaturedCollectionUSFlagsSection() {
		obj.verifyFeaturedCollectionUSFlagsSection();
	}@Test
	public void verifyFeaturedCollectionMillitarySection() {
		obj.verifyFeaturedCollectionMillitarySection();
	}
	@Test
	public void verifyFeaturedCollectionStateAndTerritorialSection() {
		obj.verifyFeaturedCollectionStateAndTerritorialSection();
	}
	@Test
	public void verifyFeaturedCollectionInternationalSection() {
		obj.verifyFeaturedCollectionInternationalSection();
	}
	@Test
	public void verifyFeaturedCollectionFlagAccessoriesSection() {
		obj.verifyFeaturedCollectionFlagAccessoriesSection();
	}
	@Test
	public void verifyFeaturedCollectionJROTCSection() {
		obj.verifyFeaturedCollectionJROTCSection();
	}
	@Test
	public void verifyBundleProducts() {
		obj.verifyBundleProducts();
	}
	@Test
	public void verifyBestSellersSectionPresence() {
		obj.verifyBestSellersSectionPresence();
	}
	@Test
	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		obj.verifyIconsBelowTheBestSellersIsPresenceAndNavigation();
	}
	@Test
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}
}
