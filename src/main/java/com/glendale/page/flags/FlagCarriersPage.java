package com.glendale.page.flags;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FlagCarriersPage {
	
	WebDriver driver;
	
	public FlagCarriersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='Flags']")
	WebElement flags_Tab;
	@FindBy(xpath = "//div[@id='navPages-25']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> flagsDropdownList;

	@FindBy(xpath = "//div[@class='category_description_only']/p")
	WebElement textOnThePage;
	
	@FindBy(id = "sort")
	WebElement sortByFilter;
	@FindBy(xpath = "//select[@id='sort']/option")
	List<WebElement> listOfSortByFilters;

	@FindBy(xpath = "//div[@class='accordion-block']/div[@class='accordion-nav-clear-holder']/button[@class='accordion-navigation toggleLink is-open']/span/*[@class='icon accordion-indicator toggleLink-text toggleLink-text--on']")
	List<WebElement> listOfAllFiltersCloseOpenIcons;

	@FindBy(xpath = "//div[@data-list-name='Category: Flag Carriers']/ul[@class='productGrid']/li")
	List<WebElement> listOfProduct;
	@FindBy(xpath = "//h3[@class='card-title']/a")
	List<WebElement> nameOfTheProducts;
	@FindBy(xpath = "//span[@class='price price--withoutTax']")
	List<WebElement> priceOfTheProducts;
	@FindBy(xpath = "//div[@class='CartBtnCustom']/a")
	List<WebElement> buttonsOnTheProductCard;
	
	@FindBy(xpath = "//a[@class='pagination-link']")
	List<WebElement> paginationLinks;

	
	public void methodToOpenTheFlagCarriersPage() {
		Actions action = new Actions(driver);
		action.moveToElement(flags_Tab).build().perform();
		flagsDropdownList.get(1).click();
	}

	public void verifyPageURL() {
		methodToOpenTheFlagCarriersPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/flags/flag-carriers/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheFlagCarriersPage();
		String actTitle = driver.getTitle();
		String expTitle = "Flags - Flag Carriers - Page 1 - Glendale Parade Store";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}
	public void verifyTextOnThePage() {
		methodToOpenTheFlagCarriersPage();
			String actText = textOnThePage.getText();
			String extTest = "Marching in a parade or participating in a military ";
			Assert.assertTrue(actText.contains(extTest),"Actual text doesn't matched with the expectd text.");
			String fontSize = textOnThePage.getCssValue("font-size");
			System.out.println("Font Size of the text= "+fontSize);
		    System.out.println("Actual text on the page matched with the expected text.");
	}

	public void verifyAllFltersEnable() {
		methodToOpenTheFlagCarriersPage();
		for (int i = 0; i < listOfAllFiltersCloseOpenIcons.size(); i++) {
			Assert.assertTrue(listOfAllFiltersCloseOpenIcons.get(i).isEnabled(), "Filters are not enabled.");
		}
		System.out.println("All filters are enabled.");
	}

	public void testSortFunctionality() {
		methodToOpenTheFlagCarriersPage();
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
		methodToOpenTheFlagCarriersPage();
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
		methodToOpenTheFlagCarriersPage();
		for (int i = 0; i < paginationLinks.size(); i++) {
			Assert.assertTrue(paginationLinks.get(i).isEnabled(), "Pagination on the page is not enabled.");
		}
		System.out.println("Pagination on the page is enabled.");
	}

	public void verifyPaginationRedirection() {
		methodToOpenTheFlagCarriersPage();
		for (int i = 0; i < paginationLinks.size(); i++) {
			String href = paginationLinks.get(i).getAttribute("href");
			driver.navigate().to(href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"verifyPaginationRedirection - " + href + " URL is not matched");
			driver.navigate().back();
		}
		System.out.println("verify Pagination Redirection testcase is passed successfully.");
	}

	 public void testPageLoadTime() {
	        // Record the start time
	        long startTime = System.currentTimeMillis();

	        // Navigate to the page
	        methodToOpenTheFlagCarriersPage();

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
