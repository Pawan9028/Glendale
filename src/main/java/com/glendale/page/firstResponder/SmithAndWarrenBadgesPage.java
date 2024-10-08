package com.glendale.page.firstResponder;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SmithAndWarrenBadgesPage {
	
	WebDriver driver;
	
	public SmithAndWarrenBadgesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@aria-label='First Responders']")
	WebElement firstResponder_Tab;
	@FindBy(xpath = "//div[@id='navPages-155']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> firstResponderDropdownList;
	
	@FindBy(xpath = "//div[@class='page-content page-content--centered ']/h3[contains(text(),'Custom design your own badges, nameplates, or medals with any colors, text, and images you want to create unique awards, gifts, or official emblems.')]")
	WebElement textOnThePage;
	
	

	public void methodToOpenTheSmithAndWarrenBadgesPage() {
		Actions action = new Actions(driver);
		action.moveToElement(firstResponder_Tab).build().perform();
		firstResponderDropdownList.get(2).click();
	}
	public void verifyPageURL() {
		methodToOpenTheSmithAndWarrenBadgesPage();
		String currentURL = driver.getCurrentUrl();
		String expURL = "https://www.glendale.com/custom-visual-badges/";
		Assert.assertEquals(currentURL, expURL, "URL of the page not matched with the expected URL");
		System.out.println("Actual URL matched with the expected URL of the page.");
	}

	public void verifyPageTitle() {
		methodToOpenTheSmithAndWarrenBadgesPage();
		String actTitle = driver.getTitle();
		String expTitle = "Custom Visual Badge";
		Assert.assertEquals(actTitle, expTitle, "Title of the page does not matched.");
		System.out.println("Title of the page is matched.");
	}
	public void verifyTextOnThePage() {
		methodToOpenTheSmithAndWarrenBadgesPage();
		String actText = textOnThePage.getText();
		String expText = "Custom design your own badges, nameplates, or medals with any colors, text, and images you";
		String fontSize = textOnThePage.getCssValue("font-size");
		Assert.assertTrue(actText.contains(expText),"Text on the page not matched with the expected text.");
		System.out.println("Actual text on the page matched with the expected.");
		System.out.println("Font size of the text= "+fontSize);
	}
	 public void testPageLoadTime() {
	        // Record the start time
	        long startTime = System.currentTimeMillis();

	        // Navigate to the page
	        methodToOpenTheSmithAndWarrenBadgesPage();

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
