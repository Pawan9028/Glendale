package com.glendale.page.honorGuard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MillitaryPage {
	
	WebDriver driver;
	
	public MillitaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='Honor Guard']")
	WebElement honorGuardTab;
	@FindBy(xpath = "//div[@id='navPages-121']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a")
	List<WebElement> listOfHonorGuard;

	@FindBy(id = "sort")
	WebElement sortByFilter;
	@FindBy(xpath = "//select[@id='sort']/option")
	List<WebElement> listOfSortByFilters;

	@FindBy(xpath = "//div[@class='accordion-block']/div[@class='accordion-nav-clear-holder']/button[@class='accordion-navigation toggleLink is-open']/span/*[@class='icon accordion-indicator toggleLink-text toggleLink-text--on']")
	List<WebElement> listOfAllFiltersCloseOpenIcons;

	@FindBy(xpath = "//div[@data-list-name='Category: Military']/ul[@class='productGrid']/li")
	List<WebElement> listOfProduct;
	@FindBy(xpath = "//h3[@class='card-title']/a")
	List<WebElement> nameOfTheProducts;
	@FindBy(xpath = "//span[@class='price price--withoutTax']")
	List<WebElement> priceOfTheProducts;
	@FindBy(xpath = "//div[@class='CartBtnCustom']/a")
	List<WebElement> buttonsOnTheProductCard;
	
	@FindBy(xpath = "//a[@class='pagination-link']")
	List<WebElement> paginationLinks;
	
	public void methodToOpenTheMillitaryPage() {
		Actions action = new Actions(driver);
		action.moveToElement(honorGuardTab).build().perform();
		listOfHonorGuard.get(1).click();
	}

	public void verifyPageURL() {
		methodToOpenTheMillitaryPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/honor-guard/military/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheMillitaryPage();
		String actTitle = driver.getTitle();
		String expTitle = "Honor Guard - Military - Page 1 - Glendale Parade Store";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}

	public void verifyAllFltersEnable() {
		methodToOpenTheMillitaryPage();
		for (int i = 0; i < listOfAllFiltersCloseOpenIcons.size(); i++) {
			Assert.assertTrue(listOfAllFiltersCloseOpenIcons.get(i).isEnabled(), "Filters are not enabled.");
		}
		System.out.println("All filters are enabled.");
	}

	public void testSortFunctionality() {
		methodToOpenTheMillitaryPage();
		sortByFilter.click();
		for (int i = 0; i < listOfSortByFilters.size(); i++) {
			System.out.println("Sort Option: " + listOfSortByFilters.get(i).getText());
			listOfSortByFilters.get(3).click();
		}
		Assert.assertTrue(listOfSortByFilters.get(3).isSelected(), "Sort option is not selected.");
		System.out.println("Sort By Functionality tested by selecting A to Z sorting option.");
	}


	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		verifyProductNameIsPresence();
		verifyProductPriceIsPresence();
		verifyProductButtonAddToCartAndSelectPresenceAndClickable();
	}

	public void verifyProductNameIsPresence() {
		methodToOpenTheMillitaryPage();
		for (int i = 0; i < nameOfTheProducts.size(); i++) {
			Assert.assertTrue(nameOfTheProducts.get(i).isDisplayed(), "Name of the products is not displayed.");
		}
		System.out.println("Name of the products is displayed.");
	}

	public void verifyProductPriceIsPresence() {
		for (int i = 0; i < priceOfTheProducts.size(); i++) {
			Assert.assertTrue(priceOfTheProducts.get(5).isDisplayed(), "Price of the products is not displayed.");
		}
		System.out.println("Price of the products is  displayed.");
	}

	public void verifyProductButtonAddToCartAndSelectPresenceAndClickable() {
		for (int i = 0; i < buttonsOnTheProductCard.size(); i++) {
			Assert.assertTrue(buttonsOnTheProductCard.get(i).isEnabled(), "Price of the products is not enabled.");
		}
		System.out.println("Button of the products is enabled.");
	}

	public void verifyPaginationEnable() {
		methodToOpenTheMillitaryPage();
		for (int i = 0; i < paginationLinks.size(); i++) {
			Assert.assertTrue(paginationLinks.get(i).isEnabled(), "Pagination on the page is not enabled.");
		}
		System.out.println("Pagination on the page is enabled.");
	}

	public void verifyPaginationRedirection() {
		methodToOpenTheMillitaryPage();
		for (int i = 0; i < paginationLinks.size(); i++) {
			String href = paginationLinks.get(i).getAttribute("href");
			driver.navigate().to(href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"verifyPaginationRedirection - " + href + " URL is not matched");
			driver.navigate().back();
		}
		System.out.println("verifyPaginationRedirection testcase is passed successfully.");
	}
	 public void testPageLoadTime() {
	        String url = "https://www.glendale.com/honor-guard/military/";

	        // Record the start time
	        long startTime = System.currentTimeMillis();

	        // Navigate to the page
	        driver.get(url);

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
