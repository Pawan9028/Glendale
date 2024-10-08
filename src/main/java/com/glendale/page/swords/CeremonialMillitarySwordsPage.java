package com.glendale.page.swords;

import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CeremonialMillitarySwordsPage {
	
	WebDriver driver;
	
	public CeremonialMillitarySwordsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='Swords']")
	WebElement swords_Tab;
	@FindBy(xpath = "//div[@id='navPages-185']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> swordsDropdownList;
	
	@FindBy(xpath = "//h1[@class='page-heading sword-title']")private WebElement pageTitle;
	@FindBy(xpath = "//div[@class='titleSwords']")private WebElement pageSubTitle;
	@FindBy(xpath = "//ul[@class='sword-blocks']/li")private List<WebElement>listOfImgsBelowSubtitle;
	@FindBy(xpath = "//ul[@class='sword-blocks']/li/h3")private List<WebElement>listOfImgsnamesBelowSubtitle;
	
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
	
	@FindBy(xpath = "//div[@class='ExploreBtn']/a")
	private WebElement exploreLetterOpenerBtn;
	
	
	public void methodToOpenTheCeremonialMillitarySwordsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(swords_Tab).build().perform();
		swordsDropdownList.get(1).click();
	}
	public void verifyPageURL() {
		methodToOpenTheCeremonialMillitarySwordsPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/swords/ceremonial-military-swords/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheCeremonialMillitarySwordsPage();
		String actTitle = driver.getTitle();
		String expTitle = "Ceremonial Military Swords";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}
	
	public void verifyProductImageSize() {
		methodToOpenTheCeremonialMillitarySwordsPage();
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
		   methodToOpenTheCeremonialMillitarySwordsPage();
		   sortByFilter.click();
		   for(int i=0;i<listOfSortByFilters.size();i++) {
			   System.out.println("Sort Option: "+listOfSortByFilters.get(i).getText());
		   listOfSortByFilters.get(3).click();
		   }
	       Assert.assertTrue(listOfSortByFilters.get(3).isSelected(), "Sort option is not selected.");
	       System.out.println("Sort By Functionality tested by selecting A to Z sorting option.");
	   }
	 //Responsive testing(Mobile) code
	 	 public void verifyResponsiveDesign() {
	 		methodToOpenTheCeremonialMillitarySwordsPage();
	 		 driver.manage().window().setSize(new Dimension(375, 812)); //mobile resolution
	 		 Assert.assertTrue(listOfProduct.get(1).isDisplayed(),"Product image is not displayed correctly in mobile.");
	 	     System.out.println("Responsive (375,812) mobile test  passed  successfully for product image on the page.");
	 	 }
	 	//Load Time verify  method
	 	public void verifyPageLoadTime() {
	 		methodToOpenTheCeremonialMillitarySwordsPage();
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
	 	public void verifyExploreLetterOpenenersButton() {
			methodToOpenTheCeremonialMillitarySwordsPage();
			Assert.assertTrue(exploreLetterOpenerBtn.isEnabled(),"Explore Letter Openers button is not enabled.");
			exploreLetterOpenerBtn.click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.glendale.com/swords/letter-openers/");
			System.out.println("Explore Letter Openers button is present and navigated to the Letter-Openers page.");
		}
		
		public void verifyProductNameIsPresence() {
			methodToOpenTheCeremonialMillitarySwordsPage();
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
	
}
