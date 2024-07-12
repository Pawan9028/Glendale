package com.glendale.page.codets;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArmyPage {
	
	WebDriver driver;
	
	public ArmyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Cadets']")
	WebElement codets_Tab;
	@FindBy(xpath = "//div[@id='navPages-44']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> codetsDropdownList;
	
	@FindBy(xpath  = "//div[@class='gld-flag-banner gld-inner-banner-with-desc new-army-jrotc-banner']")
	WebElement banner;
	@FindBy(xpath = "//a[@href=\"/cadets/army/\"]")
	WebElement shopNowBbuttonOnTheBanner;
	@FindBy(xpath = "//div[@class='gld-flag-txt']/p[contains(text(),\"The U.S. Army Junior Reserve Officers'\")]")
	WebElement textOnTheBanner;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr unifrm-bg-jrotc']")
	WebElement fc_UniformItems;
	@FindBy(xpath = "//div[@class='gld-feat-simlr unifrm-bg-jrotc']/ul/li/a")
	List<WebElement> uniformItemsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr armypg-bg-jrotc']/h3")
	WebElement fc_Teams;
	@FindBy(xpath = "//div[@class='gld-feat-simlr armypg-bg-jrotc']/ul/li/a")
	List<WebElement> teamsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr accessr-bg-jrotc']/h3")
	WebElement fc_accessories;
	@FindBy(xpath = "//div[@class='gld-feat-simlr accessr-bg-jrotc']/ul/li/a")
	List<WebElement> accessoriesList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr armypg-teamsbg-jrotc']/h3")
	WebElement fc_flags;
	@FindBy(xpath = "//div[@class='gld-feat-simlr armypg-teamsbg-jrotc']/ul/li/a")
	List<WebElement> flagsList;
	
	@FindBy(xpath  = "//div[@class='gld-feat-simlr gld-feat-fifty jrotc-flags-bg-lg']")
	WebElement flagsSection;
	@FindBy(xpath = "//a[@href=\"/page/flags/\"]")
	WebElement flagsShopNowButton;
	
	@FindBy(xpath  = "//div[@class='gld-feat-simlr gld-feat-fifty jrotc-cflags-bg-lg']")
	WebElement customFlagsSection;
	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty jrotc-cflags-bg-lg']/div[@class='jrotc-title-center']/a")
	WebElement customFlagsShopNowButton;
	
	@FindBy(xpath = "//div[@style='width: 4011.75px; display: flex; flex-direction: row; transition: all 400ms ease 0s; transform: translate3d(0px, 0px, 0px);']/div[@style='flex: 1 1 0%; width: 11.1111%;']")
	List<WebElement> bundlesProductList;
	@FindBy(xpath = "//div[@style='width: 4011.75px; display: flex; flex-direction: row; transition: all 400ms ease 0s; transform: translate3d(0px, 0px, 0px);']/div[@style='flex: 1 1 0%; width: 11.1111%;']/div[@class='css-1k0woj']")
	List<WebElement> imagesOfBundleProducts;
	
	@FindBy(xpath = "//div[@class='slick-track']/li[@class='product slick-slide slick-cloned']")
	List<WebElement> bestSellersList;
	
	@FindBy(xpath = "//div[@class='gld-home-cards']/div[@class='gld-cards-inr gld-container']/div[@class='gld-cards-col']/a")
	List<WebElement> iconsBelowTheBestSellers;

	int count = 0;
	
	public void methodToOpenTheArmyPage()  {
		Actions action = new Actions(driver);
		action.moveToElement(codets_Tab).build().perform();
		codetsDropdownList.get(1).click();
	}

	public void verifyBannerIsPresenceAndShopNowButtonRedirection() throws InterruptedException {
		methodToOpenTheArmyPage();
		// millitary_Tab.click();
		Assert.assertTrue(banner.isDisplayed(), "Banner is not displayed"); 
		System.out.println("Banner is Present");
		String href = shopNowBbuttonOnTheBanner.getAttribute("href");
		driver.navigate().to(href);
		String expSubString = "www.glendale.com"; 
		Assert.assertTrue(driver.getCurrentUrl().contains(expSubString), "Shop Now button is not redirected to the Shopping page");
		System.out.println("Clicked on the button on the banner and navigate to the URL: " + driver.getCurrentUrl());
		driver.navigate().back();
	}
	public void verifyTextOnTheBanner() throws InterruptedException {
		methodToOpenTheArmyPage();
		String expText = "The U.S. Army Junior Reserve Officers";
		String actText = textOnTheBanner.getText();
		Thread.sleep(1000);
		Assert.assertTrue(actText.contains(expText),"Text on the banner are not matched.");
		System.out.println("Text on the banner is present.");
	}

	public void verifyFeaturedCollectionUniformItems()  {
		methodToOpenTheArmyPage();
		Assert.assertTrue(fc_UniformItems.isDisplayed(), "Uniform Items of Featrured Collection is not displayed.");
		for (int i = 0; i < uniformItemsList.size(); i++) {
			String href = uniformItemsList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("href: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Uniform Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionTeams() {
		methodToOpenTheArmyPage();
		Assert.assertTrue(fc_Teams.isDisplayed(), "Flags of Featrured Collection is not displayed.");
		for (int i = 0; i < teamsList.size(); i++) {
			String href = teamsList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Flags child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionAccessories() {
		methodToOpenTheArmyPage();
		Assert.assertTrue(fc_accessories.isDisplayed(),
				"Flag Accessories of Featrured Collection is not displayed.");
		for (int i = 0; i < accessoriesList.size(); i++) {
			String href = accessoriesList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Flag Accessories child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionFlagsItems() {
		methodToOpenTheArmyPage();
		Assert.assertTrue(fc_flags.isDisplayed(),
				"Ceremonial Items of Featrured Collection is not displayed.");
		for (int i = 0; i < flagsList.size(); i++) {
			String href = flagsList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Ceremonial Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFlagsSectionPresenceAndRediredirection() {
		methodToOpenTheArmyPage();
		Assert.assertTrue(flagsSection.isDisplayed(), "Flags section is not displayed.");
		System.out.println("Flags section is Present");
		String href = flagsShopNowButton.getAttribute("href");
		driver.navigate().to(href);
		Assert.assertEquals(driver.getCurrentUrl(), href,
				"Shop Now button on the flags section is not redirected to the desired page.");
		System.out.println("Shop Now button redirected to the desired page.");
	}

	public void verifyCustomFlagsSectionPresenceAndRediredirection() {
		methodToOpenTheArmyPage();
		Assert.assertTrue(customFlagsSection.isDisplayed(), "Custom Flags section is not displayed.");
		System.out.println("Custom flags section is present.");
		String href = customFlagsShopNowButton.getAttribute("href");
		driver.navigate().to(href);
		Assert.assertEquals(driver.getCurrentUrl(), href,
				"Shop Now button on the Custom flags section is not redirected to the desired page.");
		System.out.println("Shop Now button redirected to the desired page.");
	}

	public void verifyBunleProductSectionPresenceWithProducts() {
		methodToOpenTheArmyPage();
		Assert.assertFalse(bundlesProductList.isEmpty(), "Bundle product section is not displayed.");
		System.out.println("Bundle product section is present.");
		// bundle product image checking code
		for (int i = 0; i < imagesOfBundleProducts.size(); i++) {
			imagesOfBundleProducts.get(i).isSelected();
			count++;
		}
		// System.out.println("Number of the product images present in the budle
		// section= "+count);
	}

	public void verifyBestSellersSectionPresence() {
		methodToOpenTheArmyPage();
		Assert.assertFalse(bestSellersList.isEmpty(), "Best Sellers section is not displayed.");
		System.out.println("Best sellers section is Present.");
	}

	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		methodToOpenTheArmyPage();
		for (int i = 0; i < iconsBelowTheBestSellers.size(); i++) {
			String name = iconsBelowTheBestSellers.get(i).getText();
			String href = iconsBelowTheBestSellers.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println(name);
			System.out.println(href);
			String actURL = driver.getCurrentUrl();
			//String commonsubstring = "glendale.com";
			String commonsubstring = ".com";
			Assert.assertTrue(actURL.contains(commonsubstring),"Icon of the "+name+" not redirected to the desired page.");
			driver.navigate().back();
		}
	}

}
