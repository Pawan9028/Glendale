package com.glendale.test.uniforms;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.Uniforms.AllUniformsPage;

public class AllUnifoms_Test extends BaseClass {

	AllUniformsPage obj;

	@BeforeMethod
	public void loadObject() {
		obj = new AllUniformsPage(driver);
	}

	@Test
	public void verifyPageTitle() {
		obj.verifyPageTitle();
	}

	@Test
	public void verifyPageURL() {
		obj.verifyPageURL();
	}

	@Test
	public void verifyBannerAndTextOnTheBannerPresence() {
		obj.verifyBannerAndTextOnTheBannerPresence();
	}

	@Test
	public void verifyBannerSizeAndFontSizeOfTheTextOnTheBanner() {
		obj.verifyBannerSizeAndFontSizeOfTheTextOnTheBanner();
	}

	@Test
	public void verifyFeaturedCollectionSectionPresenceAndRedirection() {
		obj.verifyFeaturedCollectionSectionPresenceAndRedirection();
	}

	@Test
	public void verifySwordsAndSabersSectionPresenceAndRedirection() {
		obj.verifySwordsAndSabersSectionPresenceAndRedirection();
	}

	@Test
	public void verifyApparelAndCustomWearSectionPresenceAndRedirection() {
		obj.verifyApparelAndCustomWearSectionPresenceAndRedirection();
	}

}
