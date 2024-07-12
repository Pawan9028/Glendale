package com.glendale.page.swords;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	
	@FindBy(xpath = "//h1[@class='productView-title']")
	WebElement titleOfTheProfuct;
	
	@FindBy(css = "#main-content > div.container > div > div.productView > div > section.productView-details.product-data > div > div.productView-price > div:nth-child(3) > span.price.price--withoutTax")
	WebElement priceOfTheProduct;
	
	@FindBy(xpath = "//dl[@class='productView-info']/dd[@class='productView-info-value']")
	List<WebElement> listOfSKU;
	
	@FindBy(id = "attribute_select_1190")
	WebElement branchDropdown;
	
	@FindBy(id = "attribute_select_1191")
	WebElement nameDropdown;
	
	@FindBy(id = "attribute_select_1192")
	WebElement lengthDropdown;
	
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
	

	public void methodToOpenTheCeremonialMillitarySwordsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(swords_Tab).build().perform();
		swordsDropdownList.get(1).click();
	}
	public void verifyPageURL() {
		methodToOpenTheCeremonialMillitarySwordsPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/premium-quality-swords-and-sabers-handcrafted-in-germany/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheCeremonialMillitarySwordsPage();
		String actTitle = driver.getTitle();
		String expTitle = "Premium Quality Swords and Sabers, handcrafted in Germany";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}
	
	public void verifyTitleOfTheProductIsPresent() {
		methodToOpenTheCeremonialMillitarySwordsPage();
		Assert.assertTrue(titleOfTheProfuct.isDisplayed(),"Title of the product is not displayed");
		System.out.println(titleOfTheProfuct.getText()+" is present.");
	}
	
	public void verifyPriceOfTheProductIsPresence() {
		methodToOpenTheCeremonialMillitarySwordsPage();
		Assert.assertTrue(priceOfTheProduct.isDisplayed(),"Price of the product is not displayed.");
		System.out.println(priceOfTheProduct.getText()+ " price of the product is present.");
	}
	public void veryImageOfTheProductIsPresence() {
		methodToOpenTheCeremonialMillitarySwordsPage();
		Assert.assertTrue(imgOfTheProduct.isDisplayed(),"Image of the product is not displayed");
		System.out.println("Image of the product is present");
	}
	public void testBranchDropdown() {
		methodToOpenTheCeremonialMillitarySwordsPage();
       // WebElement branchDropdown = driver.findElement(By.id("branchDropdown"));
        Select select = new Select(branchDropdown);

        // Verify the default selected option
        List<WebElement> option = select.getOptions();
        String defaultOption = option.get(1).getText();
        Assert.assertEquals(defaultOption, "Army", "Default selected option is incorrect");
        System.out.println("Default selected option "+defaultOption+" is correct");

        // Select an option and verify
        select.selectByVisibleText("Army");
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Army", "Selected option is incorrect");
        System.out.println("Default selected option "+selectedOption+" is correct");
    }
	public void testNameDropdown() {
		methodToOpenTheCeremonialMillitarySwordsPage();
        //WebElement nameDropdown = driver.findElement(By.id("nameDropdownId"));
        Select select = new Select(nameDropdown);

        // Verify the default selected option
        List<WebElement> option = select.getOptions();
        String defaultOption = option.get(1).getText();
        Assert.assertEquals(defaultOption, "Premium Stainless Steel Army Officer Saber", "Default selected option is incorrect");
        System.out.println("Default selected option "+defaultOption+" is correct");

        // Select an option and verify
        select.selectByVisibleText("Premium Stainless Steel Army Officer Saber");
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Premium Stainless Steel Army Officer Saber", "Selected option is incorrect");
    }
	public void testLengthDropdown() {
		methodToOpenTheCeremonialMillitarySwordsPage();
        //WebElement lengthDropdown = driver.findElement(By.id("lengthDropdownId"));
        Select select = new Select(lengthDropdown);

        // Verify the default selected option
        List<WebElement> option = select.getOptions();
        String defaultOption = option.get(1).getText();
        Assert.assertEquals(defaultOption, "28”", "Default selected option is incorrect");
        System.out.println("Default selected option "+defaultOption+" is correct");

        // Select an option and verify
        select.selectByVisibleText("30”");
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "30”", "Selected option is incorrect");
    }
	public void testBranchDropdownOptions() {
		methodToOpenTheCeremonialMillitarySwordsPage();
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
	public void testLengthDropdownOptions() {
		methodToOpenTheCeremonialMillitarySwordsPage();
        // Verify the options in the branch dropdown
       // WebElement branchDropdown = driver.findElement(By.id("branchDropdownId"));
        Select select = new Select(lengthDropdown);
        List<WebElement> options = select.getOptions();
        Assert.assertTrue(options.size() > 1, "Length dropdown does not contain multiple options");
        System.out.println("Length dropdown contains multiple options");
        for(WebElement obj:options) {
        	System.out.println("Dropdown of Length: "+obj.getText());
        }
        
        // Repeat the above verification for name and length dropdowns
    }
	public void testNameDropdownOptions() {
		methodToOpenTheCeremonialMillitarySwordsPage();
        // Verify the options in the branch dropdown
       // WebElement branchDropdown = driver.findElement(By.id("branchDropdownId"));
        Select select = new Select(nameDropdown);
        List<WebElement> options = select.getOptions();
        Assert.assertTrue(options.size() > 1, "Name dropdown does not contain multiple options");
        System.out.println("Name dropdown contains multiple options");
        for(WebElement obj:options) {
        	System.out.println("Dropdown of Name: "+obj.getText());
        } 
    }
	 public void testPageLoadTime() {
	        // Record the start time
	        long startTime = System.currentTimeMillis();

	        // Navigate to the page
	        //driver.navigate().to("https://www.glendale.com/premium-quality-swords-and-sabers-handcrafted-in-germany/");
	        methodToOpenTheCeremonialMillitarySwordsPage();

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
		 methodToOpenTheCeremonialMillitarySwordsPage();
		 String expDesc = "Since 1883, Weyersberg, Kirschbaum & Co. (WKC";
		 for(int i=0;i<descriptionList.size();i++) {
			 Assert.assertTrue(descriptionList.get(0).getText().contains(expDesc),"Description of the product is not matched");
		 }
		 System.out.println("Description of the product is matched with the expected description.");
	 }
	 public void verifyRelatedProductSection() {
		 methodToOpenTheCeremonialMillitarySwordsPage();
		 for(int i=0;i<listOfRelatedProduct.size();i++) {
			 Assert.assertTrue(listOfRelatedProduct.get(2).isDisplayed(),"Related product section is not displayed.");
			 
		 }
		 System.out.println("Related product section is displayed.");
	 }
	 public void verifyTestimonialSectionIsPresence() {
		 methodToOpenTheCeremonialMillitarySwordsPage();
		 Assert.assertTrue(testiminialSection.isDisplayed(),"Testimonial section is not displayed.");
		 System.out.println("Testimonial section is displayed.");
	 }
	 public void verifyAddToCartButtonPresence() {
		 methodToOpenTheCeremonialMillitarySwordsPage();
		 Assert.assertTrue(addToCartButton.isDisplayed(),"Add To Cart button is not displayed.");
		 System.out.println("Add To Cart button is displayed.");
	 }
	 public void verifyAddToCartButtonFunctionality() {
		 methodToOpenTheCeremonialMillitarySwordsPage();
		 Assert.assertTrue(addToCartButton.isEnabled(),"Add To Cart button is not enabled.");
		 System.out.println("Add To Cart button is enabled.");
	 }
	 public void testProductIncreaseButton() {
		 methodToOpenTheCeremonialMillitarySwordsPage();
		 int initialQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        //int initialQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        listOfQuantityIncDec.get(3).click();  
	    
		 int updatedQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        Assert.assertEquals(updatedQuantity, initialQuantity + 1, "Product quantity did not increase");
		 System.out.println("Product quantity increased");
	 }

	   
	    public void testProductDecreaseButton() {
	    	methodToOpenTheCeremonialMillitarySwordsPage();
	        // Increase the quantity first to avoid negative value
	        	listOfQuantityIncDec.get(3).click();
	        int initialQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        listOfQuantityIncDec.get(2).click();
	        int updatedQuantity = Integer.parseInt(quantityField.getAttribute("value"));
	        Assert.assertEquals(updatedQuantity, initialQuantity - 1, "Product quantity did not decrease");
	        System.out.println("Product quantity decreased");
	    }
}
