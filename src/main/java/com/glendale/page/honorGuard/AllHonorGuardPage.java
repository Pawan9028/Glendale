package com.glendale.page.honorGuard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllHonorGuardPage {
	
	WebDriver driver;
	
	public AllHonorGuardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='Honor Guard']")
	WebElement honorGuardTab;
	@FindBy(xpath = "//div[@id='navPages-121']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a")
	List<WebElement> listOfHonorGuard;
	
	@FindBy(xpath = "//div[@class='category_description_only']/p")
	List<WebElement> textOnThePage;

	@FindBy(id = "sort")
	WebElement sortByFilter;
	@FindBy(xpath = "//select[@id='sort']/option")
	List<WebElement> listOfSortByFilters;

	@FindBy(xpath = "//div[@class='accordion-block']/div[@class='accordion-nav-clear-holder']/button[@class='accordion-navigation toggleLink is-open']/span/*[@class='icon accordion-indicator toggleLink-text toggleLink-text--on']")
	List<WebElement> listOfAllFiltersCloseOpenIcons;

	@FindBy(xpath = "//div[@data-list-name='Category: Honor Guard']/ul[@class='productGrid']/li")
	List<WebElement> listOfProduct;
	@FindBy(xpath = "//h3[@class='card-title']/a")
	List<WebElement> nameOfTheProducts;
	@FindBy(xpath = "//span[@class='price price--withoutTax']")
	List<WebElement> priceOfTheProducts;
	@FindBy(xpath = "//div[@class='CartBtnCustom']/a")
	List<WebElement> buttonsOnTheProductCard;
	
	@FindBy(xpath = "//a[@class='pagination-link']")
	List<WebElement> paginationLinks;
	
	@FindBy(xpath = "//div[@id='sd-product-set-carousel-dbe19cd4-d646-4774-8e8b-44d6a79a64c9']//div[@class='css-1k0woj']")
	List<WebElement> ListOfBundleProducts;
	@FindBy(xpath = "//div[@data-test-id=\"product-set-widget-name\"]/a")
	List<WebElement> nameOfBundleProducts;
	@FindBy(xpath = "//div[@class='css-13w78ue']/a")
	List<WebElement> detailsButtonOnTheBundleProducts;
	
	public void methodToOpenTheAllHonorGuardPage() {
		Actions action = new Actions(driver);
		action.moveToElement(honorGuardTab).build().perform();
		listOfHonorGuard.get(0).click();
	}

	public void verifyPageURL() {
		methodToOpenTheAllHonorGuardPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/honor-guard/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheAllHonorGuardPage();
		String actTitle = driver.getTitle();
		String expTitle = "Glendale Parade Store - Honor Guard Supplies & Accessories";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}

	public void verifyAllFltersEnable() {
		methodToOpenTheAllHonorGuardPage();
		for (int i = 0; i < listOfAllFiltersCloseOpenIcons.size(); i++) {
			Assert.assertTrue(listOfAllFiltersCloseOpenIcons.get(i).isEnabled(), "Filters are not enabled.");
		}
		System.out.println("All filters are enabled.");
	}

	public void testSortFunctionality() {
		methodToOpenTheAllHonorGuardPage();
		sortByFilter.click();
		for (int i = 0; i < listOfSortByFilters.size(); i++) {
			System.out.println("Sort Option: " + listOfSortByFilters.get(i).getText());
			listOfSortByFilters.get(3).click();
		}
		Assert.assertTrue(listOfSortByFilters.get(3).isSelected(), "Sort option is not selected.");
		System.out.println("Sort By Functionality tested by selecting A to Z sorting option.");
	}

	public void verifyTextPresenceAndFontSize() {
		methodToOpenTheAllHonorGuardPage();
		for(int i=0;i<textOnThePage.size();i++) {
			Assert.assertTrue(textOnThePage.get(i).isDisplayed(), "Text on the the page is not displayed.");
			System.out.println("Text is present on the page");
			String actText = textOnThePage.get(0).getText();
			String expText = "Check out our Honor Guard accessories to find the items you";
			Assert.assertTrue(actText.contains(expText), "Text on the the page is not matched.");
			System.out.println("Text on the the page is matched.");
			String fontSize = textOnThePage.get(i).getCssValue("font-size");
			System.out.println("Font Size of the text= " + fontSize);
		}
	}

	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		verifyProductNameIsPresence();
		verifyProductPriceIsPresence();
		verifyProductButtonAddToCartAndSelectPresenceAndClickable();
	}

	public void verifyProductNameIsPresence() {
		methodToOpenTheAllHonorGuardPage();
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
		methodToOpenTheAllHonorGuardPage();
		for (int i = 0; i < paginationLinks.size(); i++) {
			Assert.assertTrue(paginationLinks.get(i).isEnabled(), "Pagination on the page is not enabled.");
		}
		System.out.println("Pagination on the page is enabled.");
	}

	public void verifyPaginationRedirection() {
		methodToOpenTheAllHonorGuardPage();
		for (int i = 0; i < paginationLinks.size(); i++) {
			String href = paginationLinks.get(i).getAttribute("href");
			driver.navigate().to(href);
			Assert.assertEquals(driver.getCurrentUrl(), href,
					"verifyPaginationRedirection - " + href + " URL is not matched");
			driver.navigate().back();
		}
		System.out.println("verifyPaginationRedirection testcase is passed successfully.");
	}
	public void verifyBundleProducts() {
		verifyBundleProductsIsPresence();
		verifyBundleProductNameIsPresence();
		verifyBundleProductsDetailsButtonPresenceAndClickable();
		
	}
	public void verifyBundleProductsIsPresence() {
		methodToOpenTheAllHonorGuardPage();
		for (int i = 0; i < ListOfBundleProducts.size(); i++) {
			Assert.assertTrue(nameOfTheProducts.get(i).isDisplayed(), "Bundle products are not displayed.");
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

}
