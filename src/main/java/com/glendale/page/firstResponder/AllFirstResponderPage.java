package com.glendale.page.firstResponder;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllFirstResponderPage {
	
	WebDriver driver;
	
	public AllFirstResponderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='First Responders']")
	WebElement firstResponder_Tab;
	@FindBy(xpath = "//div[@id='navPages-155']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> firstResponderDropdownList;
	
	@FindBy(xpath  = "//div[@class='gld-flag-banner gld-inner-banner-with-desc first-responder-banner']")
	WebElement banner;
	@FindBy(xpath = "//div[@class='gld-flag-txt']/p[contains(text(),\"Courage is not the absence of fear, but the will to act despite it. First responders exemplify this every day.\")]")
	WebElement textOnTheBanner;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr indpnt-driller-basics-bg']")
	WebElement fc_UniformItems;
	@FindBy(xpath = "//div[@class='gld-feat-simlr indpnt-driller-basics-bg']/ul/li/a")
	List<WebElement> uniformItemsList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr indpnt-driller-travel-bg']/h3")
	WebElement fc_accessories;
	@FindBy(xpath = "//div[@class='gld-feat-simlr indpnt-driller-travel-bg']/ul/li/a")
	List<WebElement> accessoriesList;
	
	@FindBy(xpath = "//div[@class='gld-feat-simlr first-responder-uniform-bg']/h3")
	WebElement fc_flags;
	@FindBy(xpath = "//div[@class='gld-feat-simlr first-responder-uniform-bg']/ul/li/a")
	List<WebElement> flagsList;
	
	@FindBy(xpath  = "//div[@class='gld-feat-simlr gld-feat-fifty cust-flags-bg']")
	WebElement designYourOwnBadgeSection;
	@FindBy(xpath = "//a[@href=\"/custom-visual-badge/\"]")
	WebElement ShopNowButtonOndesignYourOwnBadgeSection;
	
	@FindBy(xpath  = "//div[@class='gld-feat-simlr gld-feat-fifty home-cflags-bg']")
	WebElement customFlagsSection;
	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty home-cflags-bg']/a")
	WebElement customFlagsShopNowButton;
	
	@FindBy(xpath = "//div[@id='sd-product-set-carousel-fba60c32-c752-4148-81c4-0a4a7470066c']//div[@class='css-1k0woj']")
	List<WebElement> ListOfBundleProducts;
	@FindBy(xpath = "//div[@data-test-id=\"product-set-widget-name\"]/a")
	List<WebElement> nameOfBundleProducts;
	@FindBy(xpath = "//div[@class='css-13w78ue']/a")
	List<WebElement> detailsButtonOnTheBundleProducts;
	
	@FindBy(xpath = "//div[@class='slick-track']/li[@class='product slick-slide slick-cloned']")
	List<WebElement> bestSellersList;
	
	@FindBy(xpath = "//div[@class='gld-home-cards']/div[@class='gld-cards-inr gld-container']/div[@class='gld-cards-col']/a")
	List<WebElement> iconsBelowTheBestSellers;

	int count = 0;
	
	public void methodToOpenTheAllFirstResponderPage()  {
		Actions action = new Actions(driver);
		action.moveToElement(firstResponder_Tab).build().perform();
		firstResponderDropdownList.get(0).click();
	}
	public void verifyPageURL() {
		methodToOpenTheAllFirstResponderPage();
		String expURL = "https://www.glendale.com/first-responder/";
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(actURL , expURL,"Actual URL is not matched with the expected URL.");
		System.out.println("Actual URL is matched with the expected URL.");
	}
	public void verifyPageTitle() {
		methodToOpenTheAllFirstResponderPage();
		String expTitle = "First Responders Accessories | Glendale Parade Store";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Title of the page is not matched.");
		System.out.println("Title of the page is matched.");
	}

	public void verifyBannerIsPresence() {
		methodToOpenTheAllFirstResponderPage();
		// millitary_Tab.click();
		Assert.assertTrue(banner.isDisplayed(), "Banner is not displayed"); 
		System.out.println("Banner is Present");
	}
	public void verifyTextOnTheBanner()  {
		methodToOpenTheAllFirstResponderPage();
		String expText = "\"Courage is not the absence of fear, but the will ";
		String actText = textOnTheBanner.getText();
		Assert.assertTrue(actText.contains(expText),"Text on the banner are not matched.");
		System.out.println("Text on the banner is present and matched with the expectd text.");
		String fontSize = textOnTheBanner.getCssValue("font-size");
		System.out.println("Font Size of the text= "+fontSize);
	}

	public void verifyFeaturedCollectionUniformItems()  {
		methodToOpenTheAllFirstResponderPage();
		Assert.assertTrue(fc_UniformItems.isDisplayed(), "Uniform Items of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - Uniform Items section is displayed.");
		for (int i = 0; i < uniformItemsList.size(); i++) {
			String href = uniformItemsList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("href: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Uniform Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionAccessories() {
		methodToOpenTheAllFirstResponderPage();
		Assert.assertTrue(fc_accessories.isDisplayed(),
				"Flag Accessories of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - Accessories section is displayed.");
		for (int i = 0; i < accessoriesList.size(); i++) {
			String href = accessoriesList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Accessories child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyFeaturedCollectionFlagsSection() {
		methodToOpenTheAllFirstResponderPage();
		Assert.assertTrue(fc_flags.isDisplayed(),
				"Flags Items of Featrured Collection is not displayed.");
		System.out.println("Featured Collection - Flags section is displayed.");
		for (int i = 0; i < flagsList.size(); i++) {
			String href = flagsList.get(i).getAttribute("href");
			driver.navigate().to(href);
			System.out.println("URL: " + href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"Featured Collection Flags Items child options" + href + "not redirected to desired page");
			driver.navigate().back();
		}
	}

	public void verifyDesignYourOwnBadgeSectionPresenceAndRediredirection() {
		methodToOpenTheAllFirstResponderPage();
		Assert.assertTrue(designYourOwnBadgeSection.isDisplayed(), "Design Your Own Badge section is not displayed.");
		System.out.println("Design Your Own Badge section is displayed.");
		String href = ShopNowButtonOndesignYourOwnBadgeSection.getAttribute("href");
		driver.navigate().to(href);
		String exp = "https://www.glendale.com/custom-visual-";
		Assert.assertTrue(driver.getCurrentUrl().contains(exp),
				"Shop Now button on the Design Your Own Badge section is not redirected to the desired page.");
		System.out.println("Shop Now button on the Design Your Own Badge section is redirected to the desired page.");
	}

	public void verifyCustomFlagsSectionPresenceAndRediredirection() {
		methodToOpenTheAllFirstResponderPage();
		Assert.assertTrue(customFlagsSection.isDisplayed(), "Custom Flags section is not displayed.");
		System.out.println("Custom flags section is present.");
		String href = customFlagsShopNowButton.getAttribute("href");
		driver.navigate().to(href);
		Assert.assertEquals(driver.getCurrentUrl(), href,
				"Shop Now button on the Custom flags section is not redirected to the desired page.");
		System.out.println("Shop Now button on the Custom Flags section is redirected to the desired page.");
	}

		public void verifyBundleProducts() {
			verifyBundleProductsIsPresence();
			verifyBundleProductNameIsPresence();
			verifyBundleProductsDetailsButtonPresenceAndClickable();
			
		}
		public void verifyBundleProductsIsPresence() {
			methodToOpenTheAllFirstResponderPage();
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
		methodToOpenTheAllFirstResponderPage();
		Assert.assertFalse(bestSellersList.isEmpty(), "Best Sellers section is not displayed.");
		System.out.println("Best sellers section is Present.");
	}

	public void verifyIconsBelowTheBestSellersIsPresenceAndNavigation() {
		methodToOpenTheAllFirstResponderPage();
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
        methodToOpenTheAllFirstResponderPage();

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
