package com.glendale.page.Uniforms;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AllUniformsPage {

	WebDriver driver;

	public AllUniformsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@aria-label='Uniforms']")
	WebElement uniformTab;
	@FindBy(xpath = "//div[@id='navPages-29']/ul[@class='navPage-subMenu-list']/li/a")
	List<WebElement> uniformsList;

	@FindBy(xpath = "//div[@class='gld-flag-banner gld-inner-banner-with-desc gld-banner-long-desc uniform-pg-banner']")
	WebElement banner;
	@FindBy(xpath = "//div[@class='gld-flag-txt']/p")
	WebElement bannerText;
	
	@FindBy(xpath = "//div[@class='gld-container feat-small-box-only uniform-pg-feat-only']/h2")
	WebElement fc_Section;
	@FindBy(xpath = "//div[@class='uniform-pg-cords-main']/div[@class='uniform-single-cord']/a")
	List<WebElement> fc_list;
	
	@FindBy(xpath = "//div[@class='gld-container sword-and-sabers-bg']")
	WebElement swordsAndSabersSection;
	@FindBy(xpath = "//div[@class='gld-container sword-and-sabers-bg']/a[@class='swsabers-btn']")
	WebElement swordsAndSabersSectionShopNowButton;
	
	@FindBy(xpath = "//div[@class='gld-container appar-and-cutmwr-bg']")
	WebElement apparelAndCustomWearSection;
	@FindBy(xpath = "//div[@class='gld-container appar-and-cutmwr-bg']/a[@class='swsabers-btn']")
	WebElement apparelAndCustomWearSectionShopNowButton;

	public void methodToOpenTheAllUniformsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(uniformTab).build().perform();
			uniformsList.get(0).click();
	}

	public void verifyPageTitle() {
		methodToOpenTheAllUniformsPage();
		String actTitle = driver.getTitle();
		String expTitle = "Uniforms";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}

	public void verifyPageURL(){
		methodToOpenTheAllUniformsPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/page/uniforms/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyBannerAndTextOnTheBannerPresence() {
		methodToOpenTheAllUniformsPage();
		Assert.assertTrue(banner.isDisplayed(), "Banner is not displayed");
		System.out.println("Banner is displayed");
		String act = bannerText.getText();
		String exp = "As any military or ROTC member knows,";
		Assert.assertTrue(act.contains(exp), "Text on the banner does not matched.");
		System.out.println("Text on the banner is matched.");
	}
	public void verifyBannerSizeAndFontSizeOfTheTextOnTheBanner() {
		methodToOpenTheAllUniformsPage();
		// Get the size of the banner
		Dimension bannerSize = banner.getSize();
		int bannerWidth = bannerSize.getWidth();
		int bannerHeight = bannerSize.getHeight();
		// Print the size of the banner
		System.out.println("Banner width= "+bannerWidth+" And height= "+bannerHeight );
		
		// Get the font size of the text
		String fontSize = bannerText.getCssValue("font-size");
		 // Print the font size
		System.out.println("Font size of the text= "+fontSize);
	}
	public void verifyFeaturedCollectionSectionPresenceAndRedirection() {
		//Featured collection section presence code
		methodToOpenTheAllUniformsPage();
		Assert.assertTrue(fc_Section.isDisplayed(),"Featured collection section is not displayed.");
		System.out.println("Featured collection section is displayed.");
		//Featured collection redirection code
		for(int i=0;i<fc_list.size();i++) {
			String href = fc_list.get(i).getAttribute("href");
			driver.navigate().to(href);
			String actRes = driver.getCurrentUrl();
			Assert.assertEquals(actRes, href,"Actual and expected URL doesn't matched.");
			driver.navigate().back();
		}
		System.out.println("Actual and expected URL matched successfully.");
	}
	public void verifySwordsAndSabersSectionPresenceAndRedirection() {
		methodToOpenTheAllUniformsPage();
		//swords & sabers section presence code
		Assert.assertTrue(swordsAndSabersSection.isDisplayed(),"Swords & Sabers section is not displayed");
		System.out.println("Swords & Sabers section is displayed");
		//Shop now button redirection code
		String expURL = swordsAndSabersSectionShopNowButton.getAttribute("href");
		driver.navigate().to(expURL);
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(actURL,expURL,"Actual and expected URL not matched.");
		System.out.println("Actual and expected URL matched and test case passed successfully.");
	}
   public void verifyApparelAndCustomWearSectionPresenceAndRedirection() {
	   methodToOpenTheAllUniformsPage();
	 //swords & sabers section presence code
	 		Assert.assertTrue(apparelAndCustomWearSection.isDisplayed(),"Swords & Sabers section is not displayed");
	 		System.out.println("Apparel & Customer Wear section is displayed");
	 		//Shop now button redirection code
	 		String expURL = apparelAndCustomWearSectionShopNowButton.getAttribute("href");
	 		driver.navigate().to(expURL);
	 		String actURL = driver.getCurrentUrl();
	 		Assert.assertEquals(actURL,expURL,"Actual and expected URL not matched.");
	 		System.out.println("Actual and expected URL matched and test case passed successfully.");
	}
	
}
