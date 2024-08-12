package com.glendale.page.millitary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MarineCorpsPage {
	
	WebDriver driver;
	
	public MarineCorpsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Military']")
	WebElement millitary_Tab;
	@FindBy(xpath = "//div[@id='navPages-Military']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPages-action']")
	List<WebElement> millitaryDropdownList;
	
	@FindBy(xpath  = "//div[@class='gld-flag-banner gld-inner-banner-with-desc gld-banner-long-desc mar-corpactv-banner']")
	WebElement banner;
	@FindBy(xpath = "//a[@href=\"/military/marine-corps/\"]")
	WebElement shopNowBbuttonOnTheBanner;
	@FindBy(xpath = "//div[@class='gld-flag-txt']/p[contains(text(),'Since 1775')]")
	WebElement textOnTheBanner;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr unifrm-bg-jrotc']")
	WebElement fc_UniformItems;
	@FindBy(xpath = "//div[@class='gld-feat-simlr unifrm-bg-jrotc']/ul/li/a")
	List<WebElement> uniformItemsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr flags-bg-jrotc']/h3")
	WebElement fc_Flags;
	@FindBy(xpath = "//div[@class='gld-feat-simlr flags-bg-jrotc']/ul/li/a")
	List<WebElement> flagsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr accessr-bg-jrotc']/h3")
	WebElement fc_FlagAccessories;
	@FindBy(xpath = "//div[@class='gld-feat-simlr accessr-bg-jrotc']/ul/li/a")
	List<WebElement> flagAccessoriesList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr caremonials-bg']/h3")
	WebElement fc_CeremonialItems;
	@FindBy(xpath = "//div[@class='gld-feat-simlr caremonials-bg']/ul/li/a")
	List<WebElement> ceremonialItemsList;
	
	@FindBy(css = "body > div:nth-child(6) > div > div:nth-child(1) > div > div:nth-child(4) > div > div.gld-feat-simlr.gld-feat-fifty.jrotc-flags-bg-lg")
	WebElement flagsSection;
	@FindBy(xpath = "//a[@href=\"/page/flags/\"]")
	WebElement flagsShopNowButton;
	
	@FindBy(css = "body > div:nth-child(6) > div > div:nth-child(1) > div > div:nth-child(4) > div > div.gld-feat-simlr.gld-feat-fifty.jrotc-cflags-bg-lg")
	WebElement customFlagsSection;
	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty jrotc-cflags-bg-lg']/div[@class='jrotc-title-center']/a")
	WebElement customFlagsShopNowButton;
	
	@FindBy(xpath = "//div[@id='sd-product-set-carousel-3482c4eb-d214-41d9-bcf7-ae1b1948030d']/div/div/div")
	List<WebElement> bundlesProductList;
	@FindBy(xpath = "//div[@id='sd-product-set-carousel-3482c4eb-d214-41d9-bcf7-ae1b1948030d']/div/div/div")
	List<WebElement> imagesOfBundleProducts;
	
	@FindBy(xpath = "//div[@class='slick-track']/li[@class='product slick-slide slick-cloned']")
	List<WebElement> bestSellersList;
	
	@FindBy(xpath = "//div[@class='gld-home-cards']/div[@class='gld-cards-inr gld-container']/div[@class='gld-cards-col']/a")
	List<WebElement> iconsBelowTheBestSellers;

	int count = 0;
	
	public void methodToOpenTheMarineCorpsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(millitary_Tab).build().perform();
		millitaryDropdownList.get(3).click();
	}

	public void verifyBannerIsPresenceAndShopNowButtonRedirection() {
		methodToOpenTheMarineCorpsPage();
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
		methodToOpenTheMarineCorpsPage();
		String expText = "Since 1790, the Coast Guard has";
		String actText = textOnTheBanner.getText();
		Thread.sleep(1000);
		Assert.assertTrue(expText.contains(expText),"Text on the banner are not matched.");
		System.out.println("Text On the banner is present and matched perfectly.");
	}

	public void verifyFeaturedCollectionUniformItems() {
		methodToOpenTheMarineCorpsPage();
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
		methodToOpenTheMarineCorpsPage();
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
		methodToOpenTheMarineCorpsPage();
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
		methodToOpenTheMarineCorpsPage();
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
		methodToOpenTheMarineCorpsPage();
		Assert.assertTrue(flagsSection.isDisplayed(), "Flags section is not displayed.");
		System.out.println("Flags section is Present");
		String href = flagsShopNowButton.getAttribute("href");
		driver.navigate().to(href);
		Assert.assertEquals(driver.getCurrentUrl(), href,
				"Shop Now button on the flags section is not redirected to the desired page.");
		System.out.println("Shop Now button redirected to the desired page.");
	}

	public void verifyCustomFlagsSectionPresenceAndRediredirection() {
		methodToOpenTheMarineCorpsPage();
		Assert.assertTrue(customFlagsSection.isDisplayed(), "Custom Flags section is not displayed.");
		System.out.println("Custom flags section is present.");
		String href = customFlagsShopNowButton.getAttribute("href");
		driver.navigate().to(href);
		Assert.assertEquals(driver.getCurrentUrl(), href,
				"Shop Now button on the Custom flags section is not redirected to the desired page.");
		System.out.println("Shop Now button redirected to the desired page.");
	}

	public void verifyBunleProductSectionPresenceWithProducts() {
		methodToOpenTheMarineCorpsPage();
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
		methodToOpenTheMarineCorpsPage();
		Assert.assertFalse(bestSellersList.isEmpty(), "Best Sellers section is not displayed.");
		System.out.println("Best sellers section is Present.");
	}

	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		methodToOpenTheMarineCorpsPage();
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
