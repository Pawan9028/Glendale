package com.glendale.page.Uniforms;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SocksPage {
	
	WebDriver driver;
	
	public SocksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath = "//a[@aria-label='Uniforms']")
	WebElement uniformTab;
	@FindBy(xpath = "//div[@id='navPages-29']/ul[@class='navPage-subMenu-list']/li/a")
	List<WebElement> uniformsList;
	
	
	@FindBy(id = "sort") WebElement sortByFilter;
	@FindBy(xpath = "//select[@id='sort']/option")List<WebElement>listOfSortByFilters;
	
	@FindBy(xpath = "//div[@class='accordion-block']/div[@class='accordion-nav-clear-holder']/button[@class='accordion-navigation toggleLink is-open']/span/*[@class='icon accordion-indicator toggleLink-text toggleLink-text--on']")
	List<WebElement> listOfAllFiltersCloseOpenIcons;
	
	@FindBy(xpath = "//div[@class='card-img-container']")
	List<WebElement> listOfProduct;
	@FindBy(xpath = "//h3[@class='card-title']/a")
	List<WebElement> nameOfTheProducts;
	@FindBy(xpath = "//span[@class='price price--withoutTax']")
	List<WebElement> priceOfTheProducts;
	@FindBy(xpath = "//div[@class='CartBtnCustom']/a")
	List<WebElement> buttonsOnTheProductCard;

	public void methodToOpenTheSocksPage() {
		Actions action = new Actions(driver);
		action.moveToElement(uniformTab).build().perform();
			uniformsList.get(1).click();
	}

	public void verifyPageTitle() {
		methodToOpenTheSocksPage();
		String actTitle = driver.getTitle();
		String expTitle = "Uniforms - Socks - Page 1 - Glendale Parade Store";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}

	public void verifyPageURL(){
		methodToOpenTheSocksPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/uniforms/socks/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	
	public void verifyProductImageSize() {
		methodToOpenTheSocksPage();
		// Get the size of the banner
		for(int i=0;i<listOfProduct.size();i++) {
		Dimension productSize = listOfProduct.get(i).getSize();
		int productWidth = productSize.getWidth();
		int productHeight = productSize.getHeight();
		// Print the size of the banner
		System.out.println("Prodcut width= "+productWidth+" And height= "+productHeight );
		}
	}
	

   public void testSortFunctionality() {
	   methodToOpenTheSocksPage();
	   sortByFilter.click();
	   for(int i=0;i<listOfSortByFilters.size();i++) {
		   System.out.println("Sort Option: "+listOfSortByFilters.get(i).getText());
	   listOfSortByFilters.get(3).click();
	   }
       Assert.assertTrue(listOfSortByFilters.get(3).isSelected(), "Sort option is not selected.");
       System.out.println("Sort By Functionality tested by selecting A to Z sorting option.");
   }
   public void verifyCrossBrowserCompatibility() {
       // This test requires multiple browser configurations. Selenium Grid or BrowserStack can be used.
       // Example shown for Chrome and Firefox only.
       WebDriver firefoxDriver = new FirefoxDriver();
       firefoxDriver.get("https://www.glendale.com/uniforms/socks/");
       String firefoxTitle = firefoxDriver.getTitle();
       firefoxDriver.quit();
       methodToOpenTheSocksPage();
       driver.navigate().to("https://www.glendale.com/uniforms/socks/");
       String chromeTitle = driver.getTitle();
       Assert.assertEquals(chromeTitle, firefoxTitle, "Page title does not match between Chrome and Firefox.");
       System.out.println("Page title  matched between Chrome and Firefox.");
       
   }
 //Responsive testing(Mobile) code
 	 public void verifyResponsiveDesign() {
 		methodToOpenTheSocksPage();
 		 driver.manage().window().setSize(new Dimension(375, 812)); //mobile resolution
 		 Assert.assertTrue(listOfProduct.get(1).isDisplayed(),"Product image is not displayed correctly in mobile.");
 	     System.out.println("Responsive (375,812) mobile test  passed  successfully for product image on the page.");
 	 }
 	//Load Time verify  method
 	public void verifyPageLoadTime() {
 		methodToOpenTheSocksPage();
 		long start = System.currentTimeMillis();
 		driver.navigate().refresh();
 		long finish = System.currentTimeMillis();
 		long totalTime = finish - start;
 		Assert.assertTrue(totalTime <3000,"Page load time is more than 3 seconds.");
 		System.out.println("Load Time for this page(The Socks) is= "+totalTime);
 	}
 	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		verifyProductNameIsPresence();
		verifyProductPriceIsPresence();
		verifyProductButtonAddToCartAndSelectPresenceAndClickable();
	}
	
	public void verifyProductNameIsPresence() {
		methodToOpenTheSocksPage();
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
		public void verifyAllFltersEnable() {
			methodToOpenTheSocksPage();
			for(int i=0;i<listOfAllFiltersCloseOpenIcons.size();i++) {
				Assert.assertTrue(listOfAllFiltersCloseOpenIcons.get(i).isEnabled(),"Filters are not enabled.");
			}
			System.out.println("All filters are enabled.");
		}
		/*
		 * public void verifySortByFilterEnable() { methodToOpenTheSocksPage();
		 * Assert.assertTrue(sortByFilter.isEnabled(),"Sort By Filter not enable.");
		 * System.out.println("Sort By Filetr is enable."); Select select = new
		 * Select(sortByFilter); List<WebElement> allOptions = select.getOptions();
		 * for(int i=0;i<allOptions.size();i++) {
		 * System.out.println("Dropdown= "+allOptions.get(i).getText()); } }
		 */
}
