package com.glendale.test.aboutUs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glendale.base.BaseClass;
import com.glendale.page.aboutUs.BlogsPage;

public class Blogs_Test extends BaseClass{
	
	BlogsPage obj;
	
	@BeforeMethod
	public void loadObject() {
		obj = new BlogsPage(driver);
	}
	@Test
	public void verifyReadMoreLinks(){
		obj.verifyReadMoreLinks();
	}
	@Test
	public void verifyPagination() {
		obj.verifyPagination();
	}
	@Test
	public void verifyBlogPostTitlesPresence() {
		obj.verifyBlogPostTitlesPresence();
	}
	@Test
	public void verifyNumberOfBlogPosts() {
		obj.verifyNumberOfBlogPosts();
	}
	@Test
	public void verifyBlogTitlePresence() {
		obj.verifyBlogTitlePresence();
	}
	@Test
	public void verifyPageTitle() {
		obj.verifyPageTitle();
	}
	@Test
	public void verifyPageURL() {
		obj.verifyPageURL();
	}
	@Test
	public void testPageLoadTime() {
		obj.testPageLoadTime();
	}

}
