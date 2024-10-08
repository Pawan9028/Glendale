package com.glendale.page.swords;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllSwordsPage {
	
	WebDriver driver;
	
	public AllSwordsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='Swords']")
	WebElement swords_Tab;
	@FindBy(xpath = "//div[@id='navPages-185']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> swordsDropdownList;
	
	@FindBy(id = "sort")
	WebElement sortByFilter;
	@FindBy(xpath = "//select[@id='sort']/option")
	List<WebElement> listOfSortByFilters;

	@FindBy(xpath = "//div[@class='accordion-block']/div[@class='accordion-nav-clear-holder']/button[@class='accordion-navigation toggleLink is-open']/span/*[@class='icon accordion-indicator toggleLink-text toggleLink-text--on']")
	List<WebElement> listOfAllFiltersCloseOpenIcons;

	@FindBy(xpath = "//div[@data-list-name='Category: Swords']/ul[@class='productGrid']/li")
	List<WebElement> listOfProduct;
	@FindBy(xpath = "//h3[@class='card-title']/a")
	List<WebElement> nameOfTheProducts;
	@FindBy(xpath = "//span[@class='price price--withoutTax']")
	List<WebElement> priceOfTheProducts;
	@FindBy(xpath = "//div[@class='CartBtnCustom']/a")
	List<WebElement> buttonsOnTheProductCard;

	
	public void methodToOpenTheAllSwordsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(swords_Tab).build().perform();
		swordsDropdownList.get(0).click();
	}

	public void verifyPageURL() {
		methodToOpenTheAllSwordsPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/swords/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheAllSwordsPage();
		String actTitle = driver.getTitle();
		String expTitle = "Swords - Page 1 - Glendale Parade Store";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}
	
	public void verifyAllFltersEnable() {
		methodToOpenTheAllSwordsPage();
		for (int i = 0; i < listOfAllFiltersCloseOpenIcons.size(); i++) {
			Assert.assertTrue(listOfAllFiltersCloseOpenIcons.get(i).isEnabled(), "Filters are not enabled.");
		}
		System.out.println("All filters are enabled.");
	}

	public void testSortFunctionality() {
		methodToOpenTheAllSwordsPage();
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
		methodToOpenTheAllSwordsPage();
		for (int i = 0; i < nameOfTheProducts.size(); i++) {
			Assert.assertTrue(nameOfTheProducts.get(i).isDisplayed(), "Name of the products is not displayed.");
		}
		System.out.println("Name of the products is displayed.");
	}

	public void verifyProductPriceIsPresence() {
		for (int i = 0; i < priceOfTheProducts.size(); i++) {
			Assert.assertTrue(priceOfTheProducts.get(1).isDisplayed(), "Price of the products is not displayed.");
		}
		System.out.println("Price of the products is  displayed.");
	}

	public void verifyProductButtonAddToCartAndSelectPresenceAndClickable() {
		for (int i = 0; i < buttonsOnTheProductCard.size(); i++) {
			Assert.assertTrue(buttonsOnTheProductCard.get(i).isEnabled(), "Price of the products is not enabled.");
		}
		System.out.println("Button of the products is enabled.");
	}

	 public void testPageLoadTime() {
	        // Record the start time
	        long startTime = System.currentTimeMillis();

	        // Navigate to the page
	        methodToOpenTheAllSwordsPage();

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
