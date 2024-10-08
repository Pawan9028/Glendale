package com.glendale.page.millitary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NavyPage {
	
	WebDriver driver;
	
	public NavyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Military']")
	WebElement millitary_Tab;
	@FindBy(xpath = "//div[@id='navPages-Military']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPages-action']")
	List<WebElement> millitaryDropdownList;
	
	@FindBy(xpath  = "//div[@class='gld-flag-banner gld-inner-banner-with-desc gld-banner-long-desc navy-actdty-banner']")
	WebElement banner;
	@FindBy(xpath = "//a[@href=\"/military/navy/\"]")
	WebElement shopNowBbuttonOnTheBanner;
	@FindBy(xpath = "//div[@class='gld-flag-txt']/p[contains(text(),\"America's primary forward\")]")
	WebElement textOnTheBanner;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr unifrm-bg-jrotc']")
	WebElement fc_UniformItems;
	@FindBy(xpath = "//div[@class='gld-feat-simlr unifrm-bg-jrotc']/ul/li/a")
	List<WebElement> uniformItemsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr navy-actdty-flgsbg']/h3")
	WebElement fc_Flags;
	@FindBy(xpath = "//div[@class='gld-feat-simlr navy-actdty-flgsbg']/ul/li/a")
	List<WebElement> flagsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr accessr-bg-jrotc']/h3")
	WebElement fc_FlagAccessories;
	@FindBy(xpath = "//div[@class='gld-feat-simlr accessr-bg-jrotc']/ul/li/a")
	List<WebElement> flagAccessoriesList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr army-actdty-caremlbgnew']/h3")
	WebElement fc_CeremonialItems;
	@FindBy(xpath = "//div[@class='gld-feat-simlr army-actdty-caremlbgnew']/ul/li/a")
	List<WebElement> ceremonialItemsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty jrotc-flags-bg-lg']")
	WebElement flagsSection;
	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty jrotc-flags-bg-lg']/div/a")
	WebElement flagsShopNowButton;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty jrotc-cflags-bg-lg']")
	WebElement customFlagsSection;
	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty jrotc-cflags-bg-lg']/div/a")
	WebElement customFlagsShopNowButton;
	
	@FindBy(xpath = "//div[@id='sd-product-set-carousel-18b7442d-cc40-498a-ad69-dc226b5b98b7']/div/div/div")
	List<WebElement> bundlesProductList;
	@FindBy(xpath = "//div[@id='sd-product-set-carousel-18b7442d-cc40-498a-ad69-dc226b5b98b7']/div/div/div")
	List<WebElement> imagesOfBundleProducts;
	
	@FindBy(xpath = "//div[@class='slick-track']/li[@class='product slick-slide slick-cloned']")
	List<WebElement> bestSellersList;
	
	@FindBy(xpath = "//div[@class='gld-home-cards']/div[@class='gld-cards-inr gld-container']/div[@class='gld-cards-col']/a")
	List<WebElement> iconsBelowTheBestSellers;

	int count = 0;
	
	public void methodToOpenTheNavyPage() {
		Actions action = new Actions(driver);
		action.moveToElement(millitary_Tab).build().perform();
		millitaryDropdownList.get(4).click();
	}

	public void verifyBannerIsPresenceAndShopNowButtonRedirection() {
		methodToOpenTheNavyPage();
		// millitary_Tab.click();
		Assert.assertTrue(banner.isDisplayed(), "Banner is not displayed");
		System.out.println("Banner is Present");
		String href = shopNowBbuttonOnTheBanner.getAttribute("href");
		driver.navigate().to(href);
		Assert.assertEquals(driver.getCurrentUrl(), href, "Shop Now button is not redirected to the Shopping page");
		System.out.println("Clicked on the button on the banner and navigate to the URL: " + driver.getCurrentUrl());
		driver.navigate().back();
	}
	public void verifyTextOnTheBanner() throws InterruptedException {
		methodToOpenTheNavyPage();
		String expText = "America's primary forward deployed force.";
		String actText = textOnTheBanner.getText();
		Thread.sleep(10000);
		Assert.assertTrue(actText.contains(expText),"Text on the banner are not matched.");
		System.out.println("Text on the banner is present.");
	}

	public void verifyFeaturedCollectionUniformItems() {
		methodToOpenTheNavyPage();
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

	public void verifyFeaturedCollectionFlags() {
		methodToOpenTheNavyPage();
		Assert.assertTrue(fc_Flags.isDisplayed(), "Flags of Featrured Collection is not displayed.");
		for (int i = 0; i < flagsList.size(); i++) {
			String href = flagsList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Flags child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionFlagAccessories() {
		methodToOpenTheNavyPage();
		Assert.assertTrue(fc_FlagAccessories.isDisplayed(),
				"Flag Accessories of Featrured Collection is not displayed.");
		for (int i = 0; i < flagAccessoriesList.size(); i++) {
			String href = flagAccessoriesList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Flag Accessories child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionCeremonialItems() {
		methodToOpenTheNavyPage();
		Assert.assertTrue(fc_CeremonialItems.isDisplayed(),
				"Ceremonial Items of Featrured Collection is not displayed.");
		for (int i = 0; i < ceremonialItemsList.size(); i++) {
			String href = ceremonialItemsList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Ceremonial Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFlagsSectionPresenceAndRediredirection() {
		methodToOpenTheNavyPage();
		Assert.assertTrue(flagsSection.isDisplayed(), "Flags section is not displayed.");
		System.out.println("Flags section is Present");
		String href = flagsShopNowButton.getAttribute("href");
		driver.navigate().to(href);
		Assert.assertEquals(driver.getCurrentUrl(), href,
				"Shop Now button on the flags section is not redirected to the desired page.");
		System.out.println("Shop Now button redirected to the desired page.");
	}

	public void verifyCustomFlagsSectionPresenceAndRediredirection() {
		methodToOpenTheNavyPage();
		Assert.assertTrue(customFlagsSection.isDisplayed(), "Custom Flags section is not displayed.");
		System.out.println("Custom flags section is present.");
		String href = customFlagsShopNowButton.getAttribute("href");
		driver.navigate().to(href);
		Assert.assertEquals(driver.getCurrentUrl(), href,
				"Shop Now button on the Custom flags section is not redirected to the desired page.");
		System.out.println("Shop Now button redirected to the desired page.");
	}

	public void verifyBunleProductSectionPresenceWithProducts() {
		methodToOpenTheNavyPage();
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
		methodToOpenTheNavyPage();
		Assert.assertFalse(bestSellersList.isEmpty(), "Best Sellers section is not displayed.");
		System.out.println("Best sellers section is Present.");
	}

	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		methodToOpenTheNavyPage();
		// for (int i = 0; i < iconsBelowTheBestSellers.size(); i++) {

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
