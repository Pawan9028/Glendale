package com.glendale.page.aboutUs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactUsPage {
	
	WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//li[@class='navPages-item only-about-menu-item']") 
	WebElement aboutUs_Tab;
	@FindBy(xpath = "//div[@id='navPages-abt']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a")
	List<WebElement> listOfAboutUs;
	
	@FindBy(xpath = "//h1[@class='page-heading']") WebElement heading;
	
	@FindBy(xpath = "//div[@class='cont_pg_col cont_pg_email']/h2") WebElement emailSection;
	@FindBy(xpath = "//div[@class='cont_pg_col cont_pg_email']/a") List<WebElement> listOfEmails;
	
	@FindBy(xpath = "//div[@class='cont_pg_col cont_pg_phone']/h2") WebElement phoneSection;
	@FindBy(xpath = "//div[@class='cont_pg_col cont_pg_phone']/p/a") List<WebElement> listOfPhone;
	@FindBy(xpath = "//div[@class='cont_pg_col cont_pg_phone']/p") List<WebElement> listForPrint;
	@FindBy(xpath = "//div[@class='cont_pg_fax']/p") WebElement fax;
	
	@FindBy(xpath = "//div[@class='cont_pg_col cont_pg_mail']/h2") WebElement addSection;
	@FindBy(xpath = "//div[@class='cont_pg_col cont_pg_mail']/a") WebElement addText;

	
	public void methodToOpenTheContactUsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(aboutUs_Tab).build().perform();
		//aboutUs_Tab.click();
		listOfAboutUs.get(2).click();
	}
	public void verifyPageTitle() {
		methodToOpenTheContactUsPage();
		String expTitle = "Contact Us";
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle, actTitle,"Actual title of the page is not matched with the expected.");
		System.out.println("Actual title of the page is matched with the expected title.");
	}
	public void verifyPageURL() {
		methodToOpenTheContactUsPage();
		String expURL = "https://www.glendale.com/contact-us/";
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(actURL, expURL,"Actual URL of the page is not matched with the expected URL.");
		System.out.println("Actual URL of the page is matched with the expected URL.");
	}
	public void verifyAddressSection() {
		methodToOpenTheContactUsPage();
		Assert.assertTrue(addSection.isDisplayed(),"ADDRESS heading is not displayed.");
		System.out.println(addSection.getText()+" is displayed.");
		String fontSize = addSection.getCssValue("font-size");
		System.out.println("Font-size of the text heading ADDRESS is "+fontSize);
		
		Assert.assertTrue(addText.isEnabled(),"ADDRESS is not displayed.");
		System.out.println(addText.getText());
		String fontSize1 = addText.getCssValue("font-size");
		System.out.println("Font-size of the ADDRESS is "+fontSize1);
	}
		
	public void verifyPhoneSection() {
		methodToOpenTheContactUsPage();
		Assert.assertTrue(phoneSection.isDisplayed(),"PHONE heading is not displayed.");
		System.out.println(phoneSection.getText()+" is displayed.");
		String fontSize = phoneSection.getCssValue("font-size");
		System.out.println("Font-size of the text heading PHONE is "+fontSize);
		
		for(WebElement option:listOfPhone) {
			Assert.assertTrue(option.isEnabled(),"PHONE is not displayed.");
			System.out.println("Phone- "+option.getText());
		}
		System.out.println("Phone number is enabled.");
		Assert.assertTrue(listForPrint.get(1).isDisplayed());
		System.out.println();
		System.out.println(listForPrint.get(1).getText());
		
		Assert.assertTrue(fax.isDisplayed()," FAX is not displayed.");
		System.out.println();
		System.out.println(fax.getText()+" FAX is displayed.");
	}
	
	public void verifyEmailSection() {
		methodToOpenTheContactUsPage();
		Assert.assertTrue(emailSection.isDisplayed(),"E-MAIL heading is not displayed.");
		System.out.println(emailSection.getText()+" is displayed.");
		String fontSize = emailSection.getCssValue("font-size");
		System.out.println("Font-size of the text heading E-MAIL is "+fontSize);
		for(int i=0;i<listOfEmails.size();i++) {
			System.out.println("E-Mail= "+listOfEmails.get(i).getText());
			Assert.assertTrue(listOfEmails.get(i).isEnabled(),"E-MAIL is not enabled.");
		}
	}
	public void verifyHeading() {
		methodToOpenTheContactUsPage();
		Assert.assertTrue(heading.isDisplayed(),"CONTACT US heading is not displayed.");
		System.out.println(heading.getText()+" is displayed.");
		String fontSize = heading.getCssValue("font-size");
		System.out.println("Font-size of the heading CONTACT US is "+fontSize);
	}
	
	public void testPageLoadTime() {
        // Record the start time
        long startTime = System.currentTimeMillis();
        methodToOpenTheContactUsPage();
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
