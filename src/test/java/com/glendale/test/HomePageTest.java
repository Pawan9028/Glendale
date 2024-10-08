package com.glendale.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.HomePage;

public class HomePageTest extends BaseClass{
	
	HomePage hp;
	
	@BeforeMethod
	public void loadObject() {
		hp = new HomePage(driver);
	}
	
	@Test
	public void verifyHonePageTitle() {
		Assert.assertTrue(hp.verifyHomePageTitle());
	}
	@Test
	public void verifyLogoPresenceAndClickable() {
		Assert.assertTrue(hp.verifyLogoPresenceAndClickable());
	}
	@Test
	public void verifyCartIconPresenceAndClickable() {
		Assert.assertTrue(hp.verifyCartIconPresenceAndClickable());
	}
	@Test
	public void verifyAccountIconPresenceAndClickable() {
		Assert.assertTrue(hp.verifyAccountIconPresenceAndClickable());
	}
	@Test
	public void verifyBannerPresence() {
		Assert.assertTrue(hp.verifyBannerPresence());
	}
	@Test
	public void verifySearchFunctionality() {
		Assert.assertTrue(hp.verifySearchFunctionality());
	}
	@Test
	public void verifyMilitaryNavigationLinks() throws InterruptedException {
		hp.verifyMilitaryNavigationLinks();
	}
	@Test
	public void verifyCodetsNavigationLinks() throws InterruptedException {
		hp.verifyCodetsNavigationLinks();
	}
	@Test
	public void verifyUniformsNavigationLinks() throws InterruptedException {
		hp.verifyUniformsNavigationLinks();
	}
	@Test
	public void verifyHonorGuradNavigationLinks() throws InterruptedException {
		hp.verifyHonorGuradNavigationLinks();
	}
	@Test
	public void verifyFirstRespondersNavigationLinks() throws InterruptedException {
		hp.verifyFirstRespondersNavigationLinks();
	}
	@Test
	public void verifyReplicaRiflesNavigationLinks() throws InterruptedException {
		hp.verifyReplicaRiflesNavigationLinks();
	}
	@Test
	public void verifyFlagsNavigationLinks() throws InterruptedException {
		hp.verifyFlagsNavigationLinks();
	}
	@Test
	public void verifyCustomWorksNavigationLinks() throws InterruptedException {
		hp.verifyCustomWorksNavigationLinks();
	}
	@Test
	public void verifySwordsNavigationLinks() throws InterruptedException {
		hp.verifySwordsNavigationLinks();
	}
	@Test
	public void verifyAboutUsNavigationLinks() throws InterruptedException {
		hp.verifyAboutUsNavigationLinks();
	}
	@Test
	public void verifyrotcAndJrotcFeaturedCollectionsItems() {
		Assert.assertTrue(hp.verifyrotcAndJrotcFeaturedCollectionsItems());
	}
	@Test
	public void verifyFirstResponderFeaturedCollectionsItems() {
		Assert.assertTrue(hp.verifyFirstResponderFeaturedCollectionsItems());
	}
	@Test
	public void verifyMilitaryFeaturedCollectionsItems() {
		Assert.assertTrue(hp.verifyMilitaryFeaturedCollectionsItems());
	}

	/*
	 * @Test public void verifySoloTandemDrillersPresenceAndClickable() {
	 * Assert.assertTrue(hp.verifySoloTandemDrillersPresenceAndClickable()); }
	 */
	@Test
	public void verifySmithAndWarrenBadgesPresenceAndClickable() {
		Assert.assertTrue(hp.verifySmithAndWarrenBadgesPresenceAndClickable());
	}
	@Test
	public void verifyFlagsPresenceAndClickable() {
		Assert.assertTrue(hp.verifyFlagsPresenceAndClickable());
	}
	@Test
	public void verifyCustomFlagsPresenceAndClickable() {
		Assert.assertTrue(hp.verifyCustomFlagsPresenceAndClickable());
	}
	@Test
	public void verifyCustomPatchesAndFlashesPresenceAndClickable() {
		Assert.assertTrue(hp.verifyCustomPatchesAndFlashesPresenceAndClickable());
	}
	@Test
	public void verifyBestSellersSectionPresent() {
		Assert.assertTrue(hp.verifyBestSellersSectionPresent());
	}
	@Test
	public void verifyTestimonialsSectionPresence() {
		Assert.assertTrue(hp.verifyTestimonialsSectionPresence());
	}
	@Test
	public void verifyLatestBolgsPresenceAndViewAllBlogsClickable() {
		Assert.assertTrue(hp.verifyLatestBolgsPresenceAndClickable());
	}
	@Test
	public void verifyFooterCompanyLinkRedirections() throws InterruptedException {
		hp.verifyFooterCompanyLinkRedirections();
	}
	@Test
	public void verifyFooterProductsLinksRedirection() throws InterruptedException {
		hp.verifyFooterProductsLinksRedirection();
	}
	@Test
	public void verifyFooterSocialMediaLinksRedirection() {
		hp.verifyFooterSocialMediaLinksRedirection();
	}
	@Test
	public void verigyFooterLogoPresenceAndClickable() {
		hp.verigyFooterLogoPresenceAndClickable();
	}

}
