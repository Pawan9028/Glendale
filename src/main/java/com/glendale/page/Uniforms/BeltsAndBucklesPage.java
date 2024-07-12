package com.glendale.page.Uniforms;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BeltsAndBucklesPage {
	
	WebDriver driver;
	
	public BeltsAndBucklesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='Uniforms']")
	WebElement uniformTab;
	@FindBy(xpath = "//div[@id='navPages-29']/ul[@class='navPage-subMenu-list']/li/a")
	List<WebElement> uniformsList;

	@FindBy(xpath = "//div[@class='category_description_only']/p")
	WebElement textOnThePage;

	@FindBy(id = "sort")
	WebElement sortByFilter;
	@FindBy(xpath = "//select[@id='sort']/option")
	List<WebElement> listOfSortByFilters;

	@FindBy(xpath = "//div[@class='accordion-block']/div[@class='accordion-nav-clear-holder']/button[@class='accordion-navigation toggleLink is-open']/span/*[@class='icon accordion-indicator toggleLink-text toggleLink-text--on']")
	List<WebElement> listOfAllFiltersCloseOpenIcons;

	@FindBy(xpath = "//div[@data-list-name='Category: Belts & Buckles']/ul[@class='productGrid']/li")
	List<WebElement> listOfProduct;
	@FindBy(xpath = "//h3[@class='card-title']/a")
	List<WebElement> nameOfTheProducts;
	@FindBy(xpath = "//span[@class='price price--withoutTax']")
	List<WebElement> priceOfTheProducts;
	@FindBy(xpath = "//div[@class='CartBtnCustom']/a")
	List<WebElement> buttonsOnTheProductCard;

	@FindBy(xpath = "//ul[@class='pagination-list']/li/a")
	List<WebElement> listOfPagination;

	public void methodToOpenTheBeltsAndBuclesPage() {
		Actions action = new Actions(driver);
		action.moveToElement(uniformTab).build().perform();
		uniformsList.get(7).click();
	}

	public void verifyPageURL() {
		methodToOpenTheBeltsAndBuclesPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/uniforms/belts-buckles/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheBeltsAndBuclesPage();
		String actTitle = driver.getTitle();
		String expTitle = "Uniforms - Belts & Buckles - Page 1 - Glendale Parade Store";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}

	public void verifyAllFltersEnable() {
		methodToOpenTheBeltsAndBuclesPage();
		for (int i = 0; i < listOfAllFiltersCloseOpenIcons.size(); i++) {
			Assert.assertTrue(listOfAllFiltersCloseOpenIcons.get(i).isEnabled(), "Filters are not enabled.");
		}
		System.out.println("All filters are enabled.");
	}

	public void testSortFunctionality() {
		methodToOpenTheBeltsAndBuclesPage();
		sortByFilter.click();
		for (int i = 0; i < listOfSortByFilters.size(); i++) {
			System.out.println("Sort Option: " + listOfSortByFilters.get(i).getText());
			listOfSortByFilters.get(3).click();
		}
		Assert.assertTrue(listOfSortByFilters.get(3).isSelected(), "Sort option is not selected.");
		System.out.println("Sort By Functionality tested by selecting A to Z sorting option.");
	}
	public void verifyTextPresenceAndFontSize() {
		methodToOpenTheBeltsAndBuclesPage();
		Assert.assertTrue(textOnThePage.isDisplayed(),"Text on the the page is not displayed.");
		System.out.println("Text is present on the page");
		String actText = textOnThePage.getText();
		String expText = "Belts are an essential element of many military dress regulations";
		Assert.assertTrue(actText.contains(expText),"Text on the the page is not matched.");
		System.out.println("Text on the the page is matched.");
		String fontSize = textOnThePage.getCssValue("font-size");
		System.out.println("Font Size of the text= "+fontSize);
	}
	
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		verifyProductNameIsPresence();
		verifyProductPriceIsPresence();
		verifyProductButtonAddToCartAndSelectPresenceAndClickable();
	}
	
	public void verifyProductNameIsPresence() {
		methodToOpenTheBeltsAndBuclesPage();
		for(int i=0;i<nameOfTheProducts.size();i++) {
			Assert.assertTrue(nameOfTheProducts.get(i).isDisplayed(),"Name of the products is not displayed.");
		}
		System.out.println("Name of the products is displayed.");
	}
	
		public void verifyProductPriceIsPresence() {
		for(int i=0;i<priceOfTheProducts.size();i++) {
			Assert.assertTrue(priceOfTheProducts.get(5).isDisplayed(),"Price of the products is not displayed.");
		}
		System.out.println("Price of the products is  displayed.");
		}
		
		public void verifyProductButtonAddToCartAndSelectPresenceAndClickable() {
		for(int i=0;i<buttonsOnTheProductCard.size();i++) {
			Assert.assertTrue(buttonsOnTheProductCard.get(i).isEnabled(),"Price of the products is not enabled.");
		}
		System.out.println("Button of the products is enabled.");
	}
		public void verifyPaginationEnable() {
			methodToOpenTheBeltsAndBuclesPage();
			for(int i=0;i<listOfPagination.size();i++) {
				Assert.assertTrue(listOfPagination.get(i).isEnabled(),"Pagination on the page is not enabled.");	
			}
			System.out.println("Pagination on the page is enabled.");	
		}
		public void verifyPaginationRedirection() {
			methodToOpenTheBeltsAndBuclesPage();
			for(int i=0;i<listOfPagination.size();i++) {
				String href = listOfPagination.get(i).getAttribute("href");
				driver.navigate().to(href);
				Assert.assertEquals(driver.getCurrentUrl(),href,"verifyPaginationRedirection - "+href+" URL is not matched");
				driver.navigate().back();
			}
			System.out.println("verifyPaginationRedirection testcase is passed successfully.");
		}

}
