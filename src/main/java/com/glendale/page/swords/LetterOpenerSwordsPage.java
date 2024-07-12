package com.glendale.page.swords;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LetterOpenerSwordsPage {

	WebDriver driver;
	
	public LetterOpenerSwordsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='Swords']")
	WebElement swords_Tab;
	@FindBy(xpath = "//div[@id='navPages-185']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> swordsDropdownList;
	
	@FindBy(xpath = "//h1[@class='productView-title']")
	WebElement titleOfTheProfuct;
	
	@FindBy(css = "#main-content > div.container > div > div.productView > div > section.productView-details.product-data > div > div.productView-price > div:nth-child(3) > span.price.price--withoutTax")
	WebElement priceOfTheProduct;
	
	@FindBy(id = "attribute_select_651")
	WebElement branchDropdown;
	
	@FindBy(xpath = "//div[@class='productView-img-container']/a/img")
	WebElement imgOfTheProduct;
	
	@FindBy(xpath = "//div[@id='tab-description']/p")
	List<WebElement> descriptionList;
	
	@FindBy(xpath = "//div[@class='card-img-container']/img")
	List<WebElement> listOfRelatedProduct;
	
	@FindBy(xpath = "//div[@class='testim-outer']")
	WebElement testiminialSection;
	
	@FindBy(id = "form-action-addToCart") WebElement addToCartButton;
	
	@FindBy(xpath = "//i[@class='icon']") List<WebElement> listOfQuantityIncDec;
	
	@FindBy(xpath = "//input[@id='qty[]']") WebElement quantityField;
	

	public void methodToOpenTheLetterOpenerSwordsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(swords_Tab).build().perform();
		swordsDropdownList.get(2).click();
	}
	public void verifyPageURL() {
		methodToOpenTheLetterOpenerSwordsPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/sword-saber-letter-openers/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheLetterOpenerSwordsPage();
		String actTitle = driver.getTitle();
		String expTitle = "Sword/Saber Letter Openers";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}
	
	public void verifyTitleOfTheProductIsPresent() {
		methodToOpenTheLetterOpenerSwordsPage();
		Assert.assertTrue(titleOfTheProfuct.isDisplayed(),"Title of the product is not displayed");
		System.out.println(titleOfTheProfuct.getText()+" is present.");
	}
	
	public void verifyPriceOfTheProductIsPresence() {
		methodToOpenTheLetterOpenerSwordsPage();
		Assert.assertTrue(priceOfTheProduct.isDisplayed(),"Price of the product is not displayed.");
		System.out.println(priceOfTheProduct.getText()+ " price of the product is present.");
	}
	public void veryImageOfTheProductIsPresence() {
		methodToOpenTheLetterOpenerSwordsPage();
		Assert.assertTrue(imgOfTheProduct.isDisplayed(),"Image of the product is not displayed");
		System.out.println("Image of the product is present");
	}
	public void testBranchDropdown() {
		methodToOpenTheLetterOpenerSwordsPage();
       // WebElement branchDropdown = driver.findElement(By.id("branchDropdown"));
        Select select = new Select(branchDropdown);

        // Verify the default selected option
        List<WebElement> option = select.getOptions();
        String defaultOption = option.get(1).getText();
        Assert.assertEquals(defaultOption, "USAF Officer", "Default selected option is incorrect");
        System.out.println("Default selected option "+defaultOption+" is correct");

        // Select an option and verify
        select.selectByVisibleText("USAF Officer");
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "USAF Officer", "Selected option is incorrect");
        System.out.println("Default selected option "+selectedOption+" is correct");
    }
	
	public void testBranchDropdownOptions() {
		methodToOpenTheLetterOpenerSwordsPage();
        // Verify the options in the branch dropdown
       // WebElement branchDropdown = driver.findElement(By.id("branchDropdownId"));
        Select select = new Select(branchDropdown);
        List<WebElement> options = select.getOptions();
        Assert.assertTrue(options.size() > 1, "Branch dropdown does not contain multiple options");
        System.out.println("Branch dropdown contains multiple options");
        for(WebElement obj:options) {
        	System.out.println("Dropdown of Branch: "+obj.getText());
        }
        
        // Repeat the above verification for name and length dropdowns
    }
	
	 public void testPageLoadTime() {
	        // Record the start time
	        long startTime = System.currentTimeMillis();

	        // Navigate to the page
	        //driver.navigate().to("https://www.glendale.com/premium-quality-swords-and-sabers-handcrafted-in-germany/");
	        methodToOpenTheLetterOpenerSwordsPage();

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
	 public void verifyDescriptionOfTheProduct() {
		 methodToOpenTheLetterOpenerSwordsPage();
		 String expDesc = "These beautifully-crafted letter openers are excellent";
		 for(int i=0;i<descriptionList.size();i++) {
			 Assert.assertTrue(descriptionList.get(0).getText().contains(expDesc),"Description of the product is not matched");
		 }
		 System.out.println("Description of the product is matched with the expected description.");
	 }
	 public void verifyRelatedProductSection() {
		 methodToOpenTheLetterOpenerSwordsPage();
		 for(int i=0;i<listOfRelatedProduct.size();i++) {
			 Assert.assertTrue(listOfRelatedProduct.get(2).isDisplayed(),"Related product section is not displayed.");
			 
		 }
		 System.out.println("Related product section is displayed.");
	 }
	 public void verifyTestimonialSectionIsPresence() {
		 methodToOpenTheLetterOpenerSwordsPage();
		 Assert.assertTrue(testiminialSection.isDisplayed(),"Testimonial section is not displayed.");
		 System.out.println("Testimonial section is displayed.");
	 }
	 public void verifyAddToCartButtonPresence() {
		 methodToOpenTheLetterOpenerSwordsPage();
		 Assert.assertTrue(addToCartButton.isDisplayed(),"Add To Cart button is not displayed.");
		 System.out.println("Add To Cart button is displayed.");
	 }
	 public void verifyAddToCartButtonFunctionality() {
		 methodToOpenTheLetterOpenerSwordsPage();
		 Assert.assertTrue(addToCartButton.isEnabled(),"Add To Cart button is not enabled.");
		 System.out.println("Add To Cart button is enabled.");
	 }
	 public void testProductIncreaseButton() {
		 methodToOpenTheLetterOpenerSwordsPage();
		 int initialQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        //int initialQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        listOfQuantityIncDec.get(3).click();  
	    
		 int updatedQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        Assert.assertEquals(updatedQuantity, initialQuantity + 1, "Product quantity did not increase");
		 System.out.println("Product quantity increased");
	 }

	   
	    public void testProductDecreaseButton() {
	    	methodToOpenTheLetterOpenerSwordsPage();
	        // Increase the quantity first to avoid negative value
	        	listOfQuantityIncDec.get(3).click();
	        int initialQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        listOfQuantityIncDec.get(2).click();
	        int updatedQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        Assert.assertEquals(updatedQuantity, initialQuantity - 1, "Product quantity did not decrease");
	        System.out.println("Product quantity decreased");
	    }
}
