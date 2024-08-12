package com.glendale.page.codets;


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

public class ThePershingRiflesGroupPage {
	
	WebDriver driver;
	
	public ThePershingRiflesGroupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Cadets']")
	WebElement codets_Tab;
	@FindBy(xpath = "//div[@id='navPages-44']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> codetsDropdownList;
	
	@FindBy(xpath = "//img[@alt='Military']")
	WebElement mainImgonThePage;
	@FindBy(xpath = "//div[@class='cadets-rgt-txt']")
	WebElement textOnThePage;
	
	@FindBy(id = "sort") WebElement sortByFilter;
	@FindBy(xpath = "//select[@id='sort']/option")List<WebElement>listOfSortByFilters;
	
	@FindBy(xpath = "//div[@class='accordion-block']/div[@class='accordion-nav-clear-holder']/button[@class='accordion-navigation toggleLink is-open']/span/*[@class='icon accordion-indicator toggleLink-text toggleLink-text--on']")
	List<WebElement> listOfAllFiltersCloseOpenIcons;
	
	@FindBy(xpath = "//div[@data-list-name='Category: The Pershing Rifles Group']/ul[@class='productGrid']/li")
	List<WebElement> listOfProduct;
	@FindBy(xpath = "//h3[@class='card-title']/a")
	List<WebElement> nameOfTheProducts;
	@FindBy(xpath = "//span[@class='price price--withoutTax']")
	List<WebElement> priceOfTheProducts;
	@FindBy(xpath = "//div[@class='CartBtnCustom']/a")
	List<WebElement> buttonsOnTheProductCard;
	
	@FindBy(xpath = "//li[@class='pagination-item ']/a[@class='pagination-link']")
	WebElement paginationLink;
	
	 @FindBy(tagName = "img") List<WebElement> images;
	
	
	public void methodToOpenThePershingRiflesGroupPage()  {
		Actions action = new Actions(driver);
		action.moveToElement(codets_Tab).build().perform();
		codetsDropdownList.get(7).click();
	}
	public void verifyPageTitle() {
		methodToOpenThePershingRiflesGroupPage();
		Assert.assertEquals(driver.getTitle(), "Pershing Rifles Group | Glendale Parade Store","Page title does not match the expected title.");
		System.out.println("Title of the page is matched.& title= "+ driver.getTitle());
	}
	public void verifyCurrentURL() {
		methodToOpenThePershingRiflesGroupPage();
		String expURL = "https://www.glendale.com/cadets/the-pershing-rifles-group/";
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(actURL, expURL,"Current URL does not match the expected URL.");
		System.out.println("Current URL matched with the expected URL.");
	}
	public void verifyMainImgOnThePageLoadingAndText() {
		methodToOpenThePershingRiflesGroupPage();
		Assert.assertTrue(mainImgonThePage.isDisplayed(),"Image not displayed.");
		System.out.println("Main image of the page loaded successfully.");
		String expText = "Pershing Rifles is a military-oriented, national honor";
		String actText = textOnThePage.getText();
		Assert.assertTrue(actText.contains(expText),"Text on the page does not matched.");
		System.out.println("Text on the page matched.");
	}
	public void verifySortByFilterEnable() {
		methodToOpenThePershingRiflesGroupPage();
		Assert.assertTrue(sortByFilter.isEnabled(),"Sort By Filter not enable.");
		System.out.println("Sort By Filetr is enable.");
		Select select = new Select(sortByFilter);
		List<WebElement> allOptions = select.getOptions();
		for(int i=0;i<allOptions.size();i++) {
			System.out.println("Dropdown= "+allOptions.get(i).getText());
		}	
	}
	public void verifyAllFltersEnable() {
		methodToOpenThePershingRiflesGroupPage();
		for(int i=0;i<listOfAllFiltersCloseOpenIcons.size();i++) {
			Assert.assertTrue(listOfAllFiltersCloseOpenIcons.get(i).isEnabled(),"Filters are not enabled.");
		}
		System.out.println("All filters are enabled.");
	}
	public void verifyAllProductsOnThePageLoaded() throws InterruptedException {
		methodToOpenThePershingRiflesGroupPage();
		Thread.sleep(1000);
		for(int i=0;i<listOfProduct.size();i++) {
			Assert.assertTrue(listOfProduct.get(i).isDisplayed(), "Products not displayed.");
		}
		
	}
	public void verifyProductsNameAndPricePresenceAndButtonsEnable() {
		verifyProductNameIsPresence();
		verifyProductPriceIsPresence();
		verifyProductButtonAddToCartAndSelectPresenceAndClickable();
	}
	
	public void verifyProductNameIsPresence() {
		methodToOpenThePershingRiflesGroupPage();
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
	public void verifyPaginationIsClickable() {
		methodToOpenThePershingRiflesGroupPage();
		String exp = paginationLink.getAttribute("href");
		paginationLink.click();
		//driver.navigate().to(exp);
		String act = driver.getCurrentUrl();
		Assert.assertEquals(act, exp,"Paginaion URL not matched.");
		System.out.println("Pagination link working fine.");
	}
	//Load Time verify  method
	public void verifyPageLoadTime() {
		methodToOpenThePershingRiflesGroupPage();
		long start = System.currentTimeMillis();
		driver.navigate().refresh();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		Assert.assertTrue(totalTime <3000,"Page load time is more than 3 seconds.");
		System.out.println("Load Time for this page(The Pershing Rifles Group) is= "+totalTime);
	}
	//Responsive testing(Mobile) code
	 public void verifyResponsiveDesign() {
		 methodToOpenThePershingRiflesGroupPage();
		 driver.manage().window().setSize(new Dimension(375, 812)); //mobile resolution
		 Assert.assertTrue(mainImgonThePage.isDisplayed(),"Banner is not displayed correctly in mobile.");
	     System.out.println("Responsive (375,812) mobile test  passed  successfully for main image on the page.");
	 }
	 public void verifyAccessibility() {
		 methodToOpenThePershingRiflesGroupPage();
		 for (WebElement img : images) {
	            String altText = img.getAttribute("alt");
	            Assert.assertNotNull(altText, "Image does not have alt text: " + img.getAttribute("src"));
	        }
		 System.out.println("Accessibility test case is passed.(image have an alt tag)");
	 }
	 public void verifyCrossBrowserCompatibility() {
	        // This test requires multiple browser configurations. Selenium Grid or BrowserStack can be used.
	        // Example shown for Chrome and Firefox only.
	        WebDriver firefoxDriver = new FirefoxDriver();
	        firefoxDriver.get("https://www.glendale.com/cadets/the-pershing-rifles-group/");
	        String firefoxTitle = firefoxDriver.getTitle();
	        firefoxDriver.quit();
	        methodToOpenThePershingRiflesGroupPage();
	        driver.navigate().to("https://www.glendale.com/cadets/the-pershing-rifles-group/");
	        String chromeTitle = driver.getTitle();
	        Assert.assertEquals(chromeTitle, firefoxTitle, "Page title does not match between Chrome and Firefox.");
	        System.out.println("Page title  matched between Chrome and Firefox.");
	        
	    }

}
