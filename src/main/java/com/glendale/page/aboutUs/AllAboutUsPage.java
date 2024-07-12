package com.glendale.page.aboutUs;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllAboutUsPage {

	WebDriver driver;
	
	//@FindBy(id = "navPages-abt") WebElement aboutUs_Tab;
	@FindBy(xpath = "//li[@class='navPages-item only-about-menu-item']") 
	WebElement aboutUs_Tab;
	@FindBy(xpath = "//div[@id='navPages-abt']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a")
	List<WebElement> listOfAboutUs;
	
	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement pageHeading;
	
	@FindBy(xpath = "//h2[text()='OUR STORY']") WebElement ourStoryHeading;
	
	@FindBy(xpath = "//div[@class='gld-abt-col']/p")
	List<WebElement> listOfParagraph;
	
	@FindBy(xpath = "//h2[text()='OUR SERVICE']") WebElement ourServiceHeading;
	
	@FindBy(xpath = "//h2[text()='COME VISIT US IN PERSON']") WebElement comeVisitUsInPersonHeading;
	
	@FindBy(xpath = "//div[@class='gld-abt-img']") WebElement banner;
	
	@FindBy(xpath = "//div[@class='gld-abt-add-inr']/a") List<WebElement> listOfMailAndMoNumber;
	
	
	public AllAboutUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void methodToOpenTheAllAboutUsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(aboutUs_Tab).build().perform();
		//aboutUs_Tab.click();
		listOfAboutUs.get(0).click();
	}
	public void verifyAddreddAndPhoneEnable() {
		methodToOpenTheAllAboutUsPage();
		Assert.assertTrue(listOfMailAndMoNumber.get(0).isEnabled(),"Address is not enabled.");
		System.out.println("Address is enabled.");
		Assert.assertTrue(listOfMailAndMoNumber.get(1).isEnabled(),"Fist mobile number is not enabled");
		System.out.println("First mobile number is enabled");
		System.out.println("First Mobile number= "+listOfMailAndMoNumber.get(2).getText());
		Assert.assertTrue(listOfMailAndMoNumber.get(2).isEnabled(),"Second mobile number is not enabled");
		System.out.println("Second mobile number is enabled");
		System.out.println("Second Mobile number= "+listOfMailAndMoNumber.get(2).getText());
		
	}
	public void verifyComeVisitUsInPersonSection() {
		methodToOpenTheAllAboutUsPage();
		Assert.assertTrue(comeVisitUsInPersonHeading.isDisplayed(),"COME VISIT US IN PERSON heading is not displayed on the page.");
		System.out.println(comeVisitUsInPersonHeading.getText()+" is displayed on the page.");
		String fontSize = comeVisitUsInPersonHeading.getCssValue("font-size");
		System.out.println("Font-size of the COME VISIT US IN PERSON is  "+ fontSize);
		String expText = "At Glendale Parade Store, our passion is delivering friendly,";
		Assert.assertTrue(listOfParagraph.get(6).getText().contains(expText),"COME VISIT US IN PERSON section is not displayed.");
		System.out.println("COME VISIT US IN PERSON section's text is displayed and matched perfectly as expected.");
		String fontSize1 = listOfParagraph.get(6).getCssValue("font-size");
		System.out.println("Font size of the paragraph COME VISIT US IN PERSON Paragraph is "+fontSize1);
	}
	public void verifyOurServiceSection() {
		methodToOpenTheAllAboutUsPage();
		Assert.assertTrue(ourServiceHeading.isDisplayed(),"Our Service heading is not displayed on the page.");
		System.out.println(ourServiceHeading.getText()+" is displayed on the page.");
		String fontSize = ourServiceHeading.getCssValue("font-size");
		System.out.println("Font-size of the OUR SERVICE is  "+ fontSize);
		String expText = "At Glendale Parade Store, our passion is delivering friendly,";
		Assert.assertTrue(listOfParagraph.get(3).getText().contains(expText),"OUR STORY section is not displayed.");
		System.out.println("OUR SERVICE section's text is displayed and matched perfectly as expected.");
		String fontSize1 = listOfParagraph.get(3).getCssValue("font-size");
		System.out.println("Font size of the paragraph OUR SERVICE Paragraph is "+fontSize1);
	}
	public void verifyOurStorySection() {
		methodToOpenTheAllAboutUsPage();
		Assert.assertTrue(ourStoryHeading.isDisplayed(),"Our Story heading is not displayed on the page.");
		System.out.println(ourStoryHeading.getText()+" is displayed on the page.");
		String fontSize = ourStoryHeading.getCssValue("font-size");
		System.out.println("Font-size of the OUR STORY is  "+ fontSize);
		
		String actText = listOfParagraph.get(0).getText();
		String expText = "For over six decades, Glendale Parade Store’s products";
		System.out.println("Actual Test "+actText);
		Assert.assertTrue(actText.contains(expText),"OUR STORY section is not displayed.");
		System.out.println("OUR STORY sections text is displayed and matched perfectly as expected.");
		String fontSize1 = listOfParagraph.get(0).getCssValue("font-size");
		System.out.println("Font size of the paragraph is "+fontSize1);
	}
	public void verifyHeading() {
		methodToOpenTheAllAboutUsPage();
		Assert.assertTrue(pageHeading.isDisplayed(),"ALL ABOUT US heading is not displayed on the page.");
		System.out.println(pageHeading.getText()+" is displayed on the page.");
		String fontSize = pageHeading.getCssValue("font-size");
		System.out.println("Font-size of the heading is  "+ fontSize);
	}
	public void verifyBannerPesence() {
		methodToOpenTheAllAboutUsPage();
		Assert.assertTrue(banner.isDisplayed(),"Banner is not displayed.");
		System.out.println("Banner is displayed.");
	}
	
	public void verifyPageURL() {
		methodToOpenTheAllAboutUsPage();
		String actURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/about-us/";
		Assert.assertEquals(actURL,expURL,"Actual URL didn't match with the expected URL.");
		System.out.println("Actual URL matched with the expected URL.");
	}
	public void verifyTitlOfThePage() {
		methodToOpenTheAllAboutUsPage();
		String actTitle = driver.getTitle();
		String expTitle = "All About Us";
		Assert.assertEquals(actTitle,expTitle,"Actual title didn't match with the expected title of the page.");
		System.out.println("Actual title matched with the expected title of the page.");
	}
	 public void testPageLoadTime() {
	        // Record the start time
	        long startTime = System.currentTimeMillis();
	        methodToOpenTheAllAboutUsPage();
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
