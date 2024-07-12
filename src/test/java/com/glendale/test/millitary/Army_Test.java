package com.glendale.test.millitary;
import org.testng.annotations.Test;
import com.glendale.base.BaseClass;
import com.glendale.page.millitary.ArmyPage;

import org.testng.annotations.BeforeMethod;


@Test
public class Army_Test extends BaseClass{
	
	//WebDriver driver;
	ArmyPage mp;
	
	@BeforeMethod
	public void loadObject() {
		mp = new ArmyPage(driver);
	}
	@Test
	public void verifyBannerIsPresenceAndShopNowButtonRedirection() {
		mp.verifyBannerIsPresenceAndShopNowButtonRedirection();
	}
	@Test
	public void verifyFeaturedCollectionUniformItems() {
		mp.verifyFeaturedCollectionUniformItems();
	}
	@Test
	public void verifyFeaturedCollectionFlags() {
		mp.verifyFeaturedCollectionFlags();
	}
	@Test
	public void verifyFeaturedCollectionFlagAccessories() {
		mp.verifyFeaturedCollectionFlagAccessories();
	}
	
	@Test
	public void verifyFeaturedCollectionCeremonialItems() {
		mp.verifyFeaturedCollectionCeremonialItems();
	}
	@Test
	public void verifyFlagsSectionPresenceAndRediredirection() {
		mp.verifyFlagsSectionPresenceAndRediredirection();
	}
	@Test
	public void verifyCustomFlagsSectionPresenceAndRediredirection() {
		mp.verifyCustomFlagsSectionPresenceAndRediredirection();
	}
	@Test
	public void verifyBunleProductSectionPresenceWithProducts() {
		mp.verifyBunleProductSectionPresenceWithProducts();
	}
	@Test
	public void verifyBestSellersSectionPresence() {
		mp.verifyBestSellersSectionPresence();
	}
	@Test
	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		mp.verifyIconsBelowTheBestSellersIsPresenceAndNavigation();
	}

}
