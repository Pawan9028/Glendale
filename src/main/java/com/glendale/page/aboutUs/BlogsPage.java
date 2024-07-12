package com.glendale.page.aboutUs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlogsPage {
	
	WebDriver driver;
	
	public BlogsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//li[@class='navPages-item only-about-menu-item']") 
	WebElement aboutUs_Tab;
	@FindBy(xpath = "//div[@id='navPages-abt']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a")
	List<WebElement> listOfAboutUs;
	
	@FindBy(xpath = "//h1[@class='page-heading']") WebElement blogTitle;
	
	@FindBy(xpath = "//article[@class='blog']") List<WebElement> blogPosts;
	
	@FindBy(xpath = "//header[@class='blog-header']/h2[@class='blog-title']/a") List<WebElement> blogPostTitles;
	
	@FindBy(xpath = "//a[@class='pagination-link']") List<WebElement> paginationLinks;
	
	@FindBy(xpath = "//div[@class='blog-post']/a") List<WebElement> readMoreLinks;
	
	
	public void methodToOpenTheBlogsPage() {
		Actions action = new Actions(driver);
		action.moveToElement(aboutUs_Tab).build().perform();
		//aboutUs_Tab.click();
		listOfAboutUs.get(16).click();
	}
	
	 public void verifyReadMoreLinks(){
		 methodToOpenTheBlogsPage();
	        // Verify the functionality of "Read More" links on blog posts
	        for (int i=0;i< readMoreLinks.size();i++) {
	        	//Thread.sleep(10000);
	            String href = readMoreLinks.get(i).getAttribute("href");
	            readMoreLinks.get(i).click();
	            Assert.assertEquals(driver.getCurrentUrl(), href, "Read More link did not navigate to the correct page");
	            driver.navigate().back();  // Navigate back to the blog page
	        }
	    }
	
	 public void verifyPagination() {
		 methodToOpenTheBlogsPage();
	        // Verify the presence and functionality of pagination if available
	        if (!paginationLinks.isEmpty()) {
	            for (int i=0;i<paginationLinks.size();i++) {
	            	paginationLinks.get(i).click();
	                Assert.assertTrue(driver.getCurrentUrl().contains("page="), "Pagination did not navigate to the correct page");
	                driver.navigate().back();
	            }
	        }
	    }
	
	 public void verifyBlogPostTitlesPresence() {
		 methodToOpenTheBlogsPage();
	        // Verify the presence of titles for each blog post
	        for (WebElement title : blogPostTitles) {
	            Assert.assertTrue(title.isDisplayed(), "Blog post title is not displayed");
	            System.out.println(title.getText()+"\n");
	        }
	        System.out.println("Blog post titles are displayed.");
	    }
	
	 public void verifyNumberOfBlogPosts() {
		 methodToOpenTheBlogsPage();
	        // Verify the number of blog posts
	        Assert.assertTrue(blogPosts.size() > 0, "No blog posts found on the page");
	        System.out.println(blogPosts.size()+" BLog posts found on the page.");
	    }
	
	    public void verifyBlogTitlePresence() {
	    	methodToOpenTheBlogsPage();
	        // Verify the presence of the blog title
	        Assert.assertTrue(blogTitle.isDisplayed(), "Blog title is not displayed");
	        System.out.println("The title BLOG is present.");
	    }
	
	public void verifyPageTitle() {
		methodToOpenTheBlogsPage();
		String expTitle = "Blog - Glendale Parade Store";
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle, actTitle,"Actual title of the page is not matched with the expected.");
		System.out.println("Actual title of the page is matched with the expected title.");
	}
	public void verifyPageURL() {
		methodToOpenTheBlogsPage();
		String expURL = "https://www.glendale.com/blog/";
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(actURL, expURL,"Actual URL of the page is not matched with the expected URL.");
		System.out.println("Actual URL of the page is matched with the expected URL.");
	}
	public void testPageLoadTime() {
        // Record the start time
        long startTime = System.currentTimeMillis();
        methodToOpenTheBlogsPage();
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
