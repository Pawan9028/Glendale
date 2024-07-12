package com.glendale.page.flags;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllFlagsPage {
	
	WebDriver driver;
	
	public AllFlagsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='Flags']")
	WebElement flags_Tab;
	@FindBy(xpath = "//div[@id='navPages-25']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> flagsDropdownList;
	
	@FindBy(xpath  = "//div[@class='gld-flag-banner gld-inner-banner-with-desc gld-flagpg-banner banner-with-logo-main']")
	WebElement banner;
	@FindBy(xpath = "//div[@class='gld-flag-txt banner-with-logo']/p[contains(text(),\"Glendale is part of the FMAA and NIFDA, ensuring that our national symbols are preserved and made in America.\")]")
	WebElement textOnTheBanner;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr usflg-bg-new']")
	WebElement fc_USFlags;
	@FindBy(xpath = "//div[@class='gld-feat-simlr usflg-bg-new']/ul/li/a")
	List<WebElement> fc_USFlagsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr miltrcl-bg-new']/h3")
	WebElement fc_millitary;
	@FindBy(xpath = "//div[@class='gld-feat-simlr miltrcl-bg-new']/ul/li/a")
	List<WebElement> fc_millitaryList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr state-bg']/h3")
	WebElement fc_stateAndTerritorial;
	@FindBy(xpath = "//div[@class='gld-feat-simlr state-bg']/ul/li/a")
	List<WebElement> fc_stateAndTerritorialList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr intern-usflg-bg']/h3")
	WebElement fc_international;
	@FindBy(xpath = "//div[@class='gld-feat-simlr intern-usflg-bg']/ul/li/a")
	List<WebElement> fc_internationalList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr flag-access-bg']/h3")
	WebElement fc_FlagAccessories;
	@FindBy(xpath = "//div[@class='gld-feat-simlr flag-access-bg']/ul/li/a")
	List<WebElement> fc_FlagAccessoriesList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr rotc-and-jrotc-home-bg']/h3")
	WebElement fc_JROTC;
	@FindBy(xpath = "//div[@class='gld-feat-simlr rotc-and-jrotc-home-bg']/ul/li/a")
	List<WebElement> fc_JROTCList;
	
	@FindBy(xpath = "//div[@id='sd-product-set-carousel-da3214e4-53a9-4db3-be5b-a5b73d9d0b37']//div[@class='css-1k0woj']")
	List<WebElement> ListOfBundleProducts;
	@FindBy(xpath = "//div[@data-test-id='product-set-widget-name']/a")
	List<WebElement> nameOfBundleProducts;
	@FindBy(xpath = "//div[@class='css-13w78ue']/a")
	List<WebElement> detailsButtonOnTheBundleProducts;
	
	@FindBy(xpath = "//div[@class='slick-track']/li[@class='product slick-slide slick-cloned']")
	List<WebElement> bestSellersList;
	
	@FindBy(xpath = "//div[@class='gld-home-cards']/div[@class='gld-cards-inr gld-container']/div[@class='gld-cards-col']/a")
	List<WebElement> iconsBelowTheBestSellers;

	int count = 0;
	
	public void methodToOpenTheAllFlagsPage()  {
		Actions action = new Actions(driver);
		action.moveToElement(flags_Tab).build().perform();
		flagsDropdownList.get(0).click();
	}
	public void verifyPageURL() {
		methodToOpenTheAllFlagsPage();
		String expURL = "https://www.glendale.com/page/flags/";
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(actURL , expURL,"Actual URL is not matched with the expected URL.");
		System.out.println("Actual URL is matched with the expected URL.");
	}
	public void verifyPageTitle() {
		methodToOpenTheAllFlagsPage();
		String expTitle = "Flags";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Title of the page is not matched.");
		System.out.println("Title of the page is matched.");
	}

	public void verifyBannerIsPresence() {
		methodToOpenTheAllFlagsPage();
		// millitary_Tab.click();
		Assert.assertTrue(banner.isDisplayed(), "Banner is not displayed"); 
		System.out.println("Banner is Present");
	}
	public void verifyTextOnTheBanner()  {
		methodToOpenTheAllFlagsPage();
		String expText = "Glendale is part of the FMAA and NIFDA";
		String actText = textOnTheBanner.getText();
		Assert.assertTrue(actText.contains(expText),"Text on the banner are not matched.");
		System.out.println("Text on the banner is present and matched with the expectd text.");
		String fontSize = textOnTheBanner.getCssValue("font-size");
		System.out.println("Font Size of the text= "+fontSize);
	}

	public void verifyFeaturedCollectionUSFlagsSection()  {
		methodToOpenTheAllFlagsPage();
		Assert.assertTrue(fc_USFlags.isDisplayed(), "U.S. Flags Items of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - U.S. Flags Items section is displayed.");
		for (int i = 0; i < fc_USFlagsList.size(); i++) {
			String href = fc_USFlagsList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("href: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection U.S. Flags Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionMillitarySection() {
		methodToOpenTheAllFlagsPage();
		Assert.assertTrue(fc_millitary.isDisplayed(),
				"Millitary section of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - Accessories section is displayed.");
		for (int i = 0; i < fc_millitaryList.size(); i++) {
			String href = fc_millitaryList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Millitary child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionStateAndTerritorialSection() {
		methodToOpenTheAllFlagsPage();
		Assert.assertTrue(fc_stateAndTerritorial.isDisplayed(),
				"State And Terrotorial section of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - State And Terrotorial section is displayed.");
		for (int i = 0; i < fc_stateAndTerritorialList.size(); i++) {
			String href = fc_stateAndTerritorialList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection State And Terrotorial Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}
	public void verifyFeaturedCollectionInternationalSection() {
		methodToOpenTheAllFlagsPage();
		Assert.assertTrue(fc_international.isDisplayed(),
				"International section of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - International section is displayed.");
		for (int i = 0; i < fc_internationalList.size(); i++) {
			String href = fc_internationalList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection International Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}
	public void verifyFeaturedCollectionFlagAccessoriesSection() {
		methodToOpenTheAllFlagsPage();
		Assert.assertTrue(fc_FlagAccessories.isDisplayed(),
				"Flag Accessories section of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - Flag Accessories section is displayed.");
		for (int i = 0; i < fc_FlagAccessoriesList.size(); i++) {
			String href = fc_FlagAccessoriesList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Flag Accessories Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}
	public void verifyFeaturedCollectionJROTCSection() {
		methodToOpenTheAllFlagsPage();
		Assert.assertTrue(fc_JROTC.isDisplayed(),
				"JROTC section of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - JROTC section is displayed.");
		for (int i = 0; i < fc_JROTCList.size(); i++) {
			String href = fc_JROTCList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection JROTC Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

		public void verifyBundleProducts() {
			verifyBundleProductsIsPresence();
			verifyBundleProductNameIsPresence();
			verifyBundleProductsDetailsButtonPresenceAndClickable();
			
		}
		public void verifyBundleProductsIsPresence() {
			methodToOpenTheAllFlagsPage();
			for (int i = 0; i < ListOfBundleProducts.size(); i++) {
				Assert.assertTrue(ListOfBundleProducts.get(i).isDisplayed(), "Bundle products are not displayed.");
			}
			System.out.println("Bundle products are displayed.");
		}
		public void verifyBundleProductNameIsPresence() {
			for (int i = 0; i < nameOfBundleProducts.size(); i++) {
				Assert.assertTrue(nameOfBundleProducts.get(1).isDisplayed(), "Nameof the bundle products is not displayed.");
			}
			System.out.println("Nameof the bundle products are displayed.");
		}
		public void verifyBundleProductsDetailsButtonPresenceAndClickable() {
			for (int i = 0; i < detailsButtonOnTheBundleProducts.size(); i++) {
				Assert.assertTrue(detailsButtonOnTheBundleProducts.get(i).isEnabled(), "Details button of the bundle products is not enabled.");
			}
			System.out.println("Details button of the bundle products is enabled.");
	}

	public void verifyBestSellersSectionPresence() {
		methodToOpenTheAllFlagsPage();
		Assert.assertFalse(bestSellersList.isEmpty(), "Best Sellers section is not displayed.");
		System.out.println("Best sellers section is Present.");
	}

	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		methodToOpenTheAllFlagsPage();
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
	public void testPageLoadTime() {
       // String url = "https://www.glendale.com/honor-guard/military/";

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Navigate to the page
        methodToOpenTheAllFlagsPage();

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate the load time
        long loadTime = endTime - startTime;

        // Output the load time
        System.out.println("Page load time: " + loadTime + " milliseconds");

        // Assert that the load time is within an acceptable range (e.g., less than 5000 milliseconds)
        long acceptableLoadTime = 5000;
        Assert.assertTrue(loadTime < acceptableLoadTime, "Page load time is too high.");
    }

}
