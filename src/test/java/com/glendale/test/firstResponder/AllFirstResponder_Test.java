package com.glendale.test.firstResponder;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.firstResponder.AllFirstResponderPage;

public class AllFirstResponder_Test extends BaseClass{
	
	AllFirstResponderPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new AllFirstResponderPage(driver);
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
	public void verifyFeaturedCollectionUniformItems() {
		obj.verifyFeaturedCollectionUniformItems();
	}
	@Test
	public void verifyFeaturedCollectionAccessories() {
		obj.verifyFeaturedCollectionAccessories();
	}
	@Test
	public void verifyFeaturedCollectionFlagsSection() {
		obj.verifyFeaturedCollectionFlagsSection();
	}
	@Test
	public void verifyDesignYourOwnBadgeSectionPresenceAndRediredirection() {
		obj.verifyDesignYourOwnBadgeSectionPresenceAndRediredirection();
	}
	@Test
	public void verifyCustomFlagsSectionPresenceAndRediredirection() {
		obj.verifyCustomFlagsSectionPresenceAndRediredirection();
	}
	
	@Test
	public void verifyBundleProducts() {
		obj.verifyBundleProducts();
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
