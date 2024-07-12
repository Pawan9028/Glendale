package com.glendale.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "quick-search-expand")
	WebElement searchTab;
	@FindBy(id = "nav-quick-search")
	WebElement searchBox;
	@FindBy(id = "search-results-heading")
	WebElement searchResultTest;

	@FindBy(css = "body > header > div > h1 > a > div > img")
	WebElement logo;

	@FindBy(css = "body > header > div > nav > ul.navUser-section.navUser-section--alt > li.navUser-item.navUser-item--cart > a > span.navUser-item-cartLabel")
	WebElement cartIcon;
	@FindBy(xpath = "//div[@class='previewCart-emptyBody']")
	WebElement cartIconText;

	@FindBy(css = "body > header > div > nav > ul.navUser-section.navUser-section--alt > li.navUser-item.navUser-item--account > a.head-signin-txt.navUser-action")
	WebElement accountIcon;

	@FindBy(css = "#main-content > section > div > div > div.slick-slide.slick-current.slick-active > div > a > img")
	WebElement bannerImg;

	@FindBy(xpath = "//ul[@class='navPages-list']/li[@class='navPages-item']/a[@aria-label=\"Military\"]")
	WebElement militaryDropdown;
	@FindBy(xpath = "//div[@id='navPages-Military']/ul[@class='navPage-subMenu-list']"
			+ "/li[@class='navPage-subMenu-item']/a[@class='navPages-action']")
	List<WebElement> militaryDropdownList;

	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label=\"Cadets\"]")
	WebElement codetDropdown;
	@FindBy(xpath = "//div[@id='navPages-44']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> codetDropdownsList;

	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label=\"Uniforms\"]")
	WebElement uniformDropdown;
	@FindBy(xpath = "//div[@id='navPages-29']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> uniformDropdownList;

	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Honor Guard']")
	WebElement honorGuardDropdown;
	@FindBy(xpath = "//div[@id='navPages-121']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> honorGuardDropdownList;

	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='First Responders']")
	WebElement firstResponderDropdown;
	@FindBy(xpath = "//div[@id='navPages-155']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> firstResponderDropdownList;

	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Replica Rifles']")
	WebElement replicaRifleDropdown;
	@FindBy(xpath = "//div[@id='navPages-49']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> replicaRifleDropdownList;

	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Flags']")
	WebElement flagsDropdown;
	@FindBy(xpath = "//div[@id='navPages-25']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> flagsDropdownList;

	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Custom Work']")
	WebElement customWorkDropdown;
	@FindBy(xpath = "//div[@id='navPages-172']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> customWorkDropdownList;

	@FindBy(xpath = "//li[@class='navPages-item']/a[@aria-label='Swords']")
	WebElement swordsDropdown;
	@FindBy(xpath = "//div[@id='navPages-185']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPage-subMenu-action navPages-action']")
	List<WebElement> swordsDropdownList;

	@FindBy(xpath = "//li[@class='navPages-item only-about-menu-item']/a[@aria-label='About Us']")
	WebElement aboutUsDropdown;
	@FindBy(xpath = "//div[@id='navPages-abt']/ul[@class='navPage-subMenu-list']/li[@class='navPage-subMenu-item']/a[@class='navPages-action']")
	List<WebElement> aboutUsDropdownList;

	@FindBy(xpath = "//div[@class='gld-feat-simlr rotc-and-jrotc-home-bg']/ul/li/a")
	List<WebElement> rotcAndJrotcFeaturedCollectionList;

	@FindBy(xpath = "//div[@class='gld-feat-simlr first-resp-home-bg']/ul/li/a")
	List<WebElement> firstResponderFeaturedCollectionList; // int i=1

	@FindBy(xpath = "//div[@class='gld-feat-simlr military-home-bg']/ul/li/a")
	List<WebElement> militaryFeaturedCollectionList;

	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty indepdrill-bg']/h3")
	WebElement soloTandemDrillersText;
	@FindBy(xpath = "//*[@id=\"main-content\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/a")
	WebElement soloTandemDrillersShopNowButton;

	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty cust-flags-bg']/h3")
	WebElement smithWarrenBadgesText;
	@FindBy(xpath = "//a[@href=\"/custom-visual-badges/\"]")
	WebElement smithWarrenBadgesShopNowButton;

	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty home-flags-bg']/h3")
	WebElement flagsText;
	@FindBy(xpath = "//a[@href=\"/page/flags/\"]")
	WebElement flagsShopNowButton;

	@FindBy(xpath = "//div[@class='gld-feat-simlr gld-feat-fifty home-cflags-bg']/h3")
	WebElement customFlagsText;
	@FindBy(xpath = "//a[@href=\"/custom-flags-guidons-banners-streamers/\"]")
	WebElement customFlagsShopNowButton;

	@FindBy(xpath = "//div[@class='cus-patch-home-banner gld-feat-simlr gld-feat-fifty gld-cus-patch-home-full']/h3")
	WebElement customPatchesAndFlashesText;
	@FindBy(xpath = "//a[@href=\"/custom-patches-flashes/\"]")
	WebElement customPatchesAbdFlashesShopNowButton;
	
	@FindBy(xpath = "//div[@class='category-products']/div[@class='container']")
	WebElement bestSellersSection;
	@FindBy(xpath = "//div[@class='category-product-list']/ul[@class='productGrid-bslider slick-initialized slick-slider']/div[@class='slick-list draggable']/div[@class='slick-track']/li[@class='product slick-slide slick-cloned']")
	List<WebElement> bestSellersList; //start from 5
	
	@FindBy(xpath = "//div[@class='testim-outer']") WebElement testimonials;
	
	@FindBy(xpath = "//div[@class='home_page_blog']") WebElement latestBlogsSestion;
	@FindBy(xpath = "//a[text()='View all blogs']") WebElement latestBlogsViewAllButton;
	
	@FindBy(xpath = "//div[@class='gld-footer-cols gld-col-two']/ul[@id='subcategory-list']/li/a")
	List<WebElement> footerCompanyAllLinks; //first 2 links not in footer UI
	
	@FindBy(xpath = "//div[@class='gld-footer-cols gld-col-thr']/ul/li/a")
	List<WebElement> footerProductsLinks;
	
	@FindBy(css = "body > footer > div.gld-footer-contnr > div.gld-footer-cols.gld-col-one > a > img")
	WebElement footerLogo;
	
	@FindBy(xpath = "//div[@class='gld-footer-cols gld-col-one']/p[@class='gld-addrs']")
	WebElement footerAddress;
	
	@FindBy(xpath = "//div[@class='gld-footer-cols gld-col-one']/p[@class='gld-calls']/a")
	List<WebElement> footerMobileNumber;
	
	@FindBy(xpath = "//div[@class='gld-footer-cols gld-col-one']/p[@class='gld-faxes']")
	WebElement footerFaxNumber;
	
	@FindBy(xpath = "//div[@class='gld-footer-cols gld-col-one']/p[@class='gld-email']")
	WebElement footerMail;
	
	@FindBy(xpath = "//div[@class='gld-footer-cols gld-col-four']/div[@class='gld-social-icons']/a")
	List<WebElement> footerSocialMediaLinks;
	
	@FindBy(id  = "button_go_to_top") 
	

	int count = 0;

	public boolean verifyHomePageTitle() {
		String expRes = "Glendale Parade Store";
		String actRes = driver.getTitle();
		Assert.assertEquals(actRes, expRes, "Homepage title does not match!");
		return true;
	}

	public boolean verifyLogoPresenceAndClickable() {
		Assert.assertTrue(logo.isDisplayed() && logo.isEnabled(), "Logo is not displayed");
		String exp = "https://www.glendale.com/";
		String act = driver.getCurrentUrl();
		Assert.assertEquals(act, exp, "Clicking the logo did not navigate to the homepage!");
		return true;
	}

	public boolean verifyCartIconPresenceAndClickable() {
		Assert.assertTrue(cartIcon.isDisplayed(), "Cart icon is not displayed");
		cartIcon.click();
		Assert.assertEquals(cartIconText.getText(), "Your cart is empty",
				"Clicking the cart icon did not navigate to the cart page!");
		return true;
	}

	public boolean verifyAccountIconPresenceAndClickable() {
		Assert.assertTrue(accountIcon.isDisplayed(), "Account icon is not displayed");
		accountIcon.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.glendale.com/login.php",
				"Clicking the account icon did not navigate to the account page!");
		return true;
	}

	public boolean verifyBannerPresence() {
		Assert.assertTrue(bannerImg.isDisplayed(), "Banner is not displayed");
		return true;
	}

	public boolean verifySearchFunctionality() {
		searchTab.click();
		searchBox.sendKeys("Ties");
		searchBox.submit();
		Assert.assertTrue(searchResultTest.isDisplayed(), "Search results did not load correctly");
		return true;
	}

	public void verifyMilitaryNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(militaryDropdown).build().perform();
		// militaryDropdown.click();
		Thread.sleep(1000);
		// List<WebElement>options = militaryDropdownList;
		// for(WebElement option:options) {
		// Thread.sleep(1000);
		// System.out.println("Dropdown: "+option.getText());
		// }
		for (int i = 0; i < militaryDropdownList.size(); i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + militaryDropdownList.get(i).getText());
			militaryDropdownList.get(i).click();
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(militaryDropdown).build().perform();
			count++;
			Thread.sleep(1000);
		}
		System.out.println("Military Dropdown Count: " + count);
	}

	public void verifyCodetsNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(codetDropdown).build().perform();
		for (int i = 1; i < codetDropdownsList.size(); i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + codetDropdownsList.get(i).getText());
			codetDropdownsList.get(i).click();
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(codetDropdown).build().perform();
			count++;
		}
		System.out.println("Codet Dropdown Count: " + count);
	}

	public void verifyUniformsNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(uniformDropdown).build().perform();
		for (int i = 0; i < uniformDropdownList.size(); i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + uniformDropdownList.get(i).getText());
			uniformDropdownList.get(i).click();
			count++;
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(uniformDropdown).build().perform();
		}
		System.out.println("Uniform Dropdown Count: " + count);
	}

	public void verifyHonorGuradNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(honorGuardDropdown).build().perform();
		for (int i = 0; i < honorGuardDropdownList.size(); i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + honorGuardDropdownList.get(i).getText());
			honorGuardDropdownList.get(i).click();
			count++;
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(honorGuardDropdown).build().perform();
			Thread.sleep(1000);
		}
		System.out.println("Honor Guard Dropdown Count: " + count);
	}

	public void verifyFirstRespondersNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(firstResponderDropdown).build().perform();
		for (int i = 0; i < firstResponderDropdownList.size(); i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + firstResponderDropdownList.get(i).getText());
			firstResponderDropdownList.get(i).click();
			count++;
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(firstResponderDropdown).build().perform();
		}
		System.out.println("First Responder Dropdown Count: " + count);

	}

	public void verifyReplicaRiflesNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(replicaRifleDropdown).build().perform();
		for (int i = 0; i < replicaRifleDropdownList.size(); i++) {
			Thread.sleep(10000);
			System.out.println("Dropdown: " + replicaRifleDropdownList.get(i).getText());
			replicaRifleDropdownList.get(i).click();
			count++;
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(replicaRifleDropdown).build().perform();
		}
		System.out.println("Replica Rifles Dropdown Count: " + count);

	}

	public void verifyFlagsNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(flagsDropdown).build().perform();
		for (int i = 0; i < flagsDropdownList.size() - 2; i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + flagsDropdownList.get(i).getText());
			flagsDropdownList.get(i).click();
			count++;
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(flagsDropdown).build().perform();
		}
		System.out.println("Flags Dropdown Count: " + count);

	}

	public void verifyCustomWorksNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(customWorkDropdown).build().perform();
		for (int i = 1; i < customWorkDropdownList.size(); i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + customWorkDropdownList.get(i).getText());
			customWorkDropdownList.get(i).click();
			count++;
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(customWorkDropdown).build().perform();
		}
		System.out.println("Custom Works Dropdown Count: " + count);

	}

	public void verifySwordsNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(swordsDropdown).build().perform();
		for (int i = 0; i < swordsDropdownList.size(); i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + swordsDropdownList.get(i).getText());
			swordsDropdownList.get(i).click();
			count++;
			System.out.println("URL: " + driver.getCurrentUrl());
			action.moveToElement(swordsDropdown).build().perform();
		}
		System.out.println("Swords Dropdown Count: " + count);

	}

	public void verifyAboutUsNavigationLinks() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(aboutUsDropdown).build().perform();
		for (int i = 0; i < aboutUsDropdownList.size(); i++) {
			Thread.sleep(1000);
			System.out.println("Dropdown: " + aboutUsDropdownList.get(i).getText());
			aboutUsDropdownList.get(i).click();
			count++;
			System.out.println("URL: " + driver.getCurrentUrl());
			driver.get("https://www.glendale.com/");
			action.moveToElement(aboutUsDropdown).build().perform();
		}
		System.out.println("About Us Dropdown Count: " + count);
	}

	public boolean verifyrotcAndJrotcFeaturedCollectionsItems() {
		for (int i = 0; i < rotcAndJrotcFeaturedCollectionList.size(); i++) {
			System.out.println("ROTC & JROTC Items: " + rotcAndJrotcFeaturedCollectionList.get(i).getText());
			rotcAndJrotcFeaturedCollectionList.get(i).click();
			System.out.println("URL: " + driver.getCurrentUrl());
			count++;
			driver.get("https://www.glendale.com/");
		}
		System.out.println("Total items Count= " + count);
		return true;
	}

	public boolean verifyFirstResponderFeaturedCollectionsItems() {
		for (int i = 1; i < firstResponderFeaturedCollectionList.size(); i++) {
			System.out.println("ROTC & JROTC Items: " + firstResponderFeaturedCollectionList.get(i).getText());
			firstResponderFeaturedCollectionList.get(i).click();
			System.out.println("URL: " + driver.getCurrentUrl());
			count++;
			driver.get("https://www.glendale.com/");
		}
		System.out.println("Total items Count= " + count);
		return true;
	}

	public boolean verifyMilitaryFeaturedCollectionsItems() {
		for (int i = 0; i < militaryFeaturedCollectionList.size(); i++) {
			System.out.println("ROTC & JROTC Items: " + militaryFeaturedCollectionList.get(i).getText());
			militaryFeaturedCollectionList.get(i).click();
			System.out.println("URL: " + driver.getCurrentUrl());
			count++;
			driver.get("https://www.glendale.com/");
		}
		System.out.println("Total items Count= " + count);
		return true;
	}

	public boolean verifySoloTandemDrillersPresenceAndClickable() {
		Assert.assertTrue(soloTandemDrillersText.isDisplayed(), "SOLO/TANDEM DRILLERS is not displayed");
		soloTandemDrillersShopNowButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.glendale.com/solo-tandem-drillers/");
		return true;
	}

	public boolean verifySmithAndWarrenBadgesPresenceAndClickable() {
		Assert.assertTrue(smithWarrenBadgesText.isDisplayed(), "SOLO/TANDEM DRILLERS are not displayed");
		smithWarrenBadgesShopNowButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.glendale.com/custom-visual-badges/");
		return true;
	}
	public boolean verifyFlagsPresenceAndClickable() {
		Assert.assertTrue(flagsText.isDisplayed(), "Flags are not displayed");
		flagsShopNowButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.glendale.com/page/flags/");
		return true;
	}
	public boolean verifyCustomFlagsPresenceAndClickable() {
		Assert.assertTrue(customFlagsText.isDisplayed(), "Custom Flags are not displayed");
		customFlagsShopNowButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.glendale.com/custom-flags-guidons-banners-streamers/");
		return true;
	}
	public boolean verifyCustomPatchesAndFlashesPresenceAndClickable() {
		Assert.assertTrue(customPatchesAndFlashesText.isDisplayed(), "Custom Patches And Flashes are not displayed");
		customPatchesAbdFlashesShopNowButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.glendale.com/custom-patches-flashes/");
		return true;
	}
	public boolean verifyBestSellersSectionPresent() {
		Assert.assertTrue(bestSellersSection.isDisplayed(),"Best Sellers section is not displayed.");
		return true;
	}
	public boolean verifyTestimonialsSectionPresence() {
		Assert.assertTrue(testimonials.isDisplayed(),"Testimonials is not displayed");
		return true;
	}
	public boolean verifyLatestBolgsPresenceAndClickable() {
		Assert.assertTrue(latestBlogsSestion.isDisplayed(),"Latest Blogs section is not displayed");
		latestBlogsViewAllButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.glendale.com/blog/");
		return true;
	}
	public void verifyFooterCompanyLinkRedirections() throws InterruptedException {
		//code for all links redirects to the correct page
		List<WebElement> links = footerCompanyAllLinks;
		Thread.sleep(10000);
		for(int i=0;i<links.size();i++) {
			
				Thread.sleep(10000);
				//link.click();
			String href = links.get(i).getAttribute("href");
			System.out.println("href: "+href);
			driver.navigate().to(href);
			
			//link.click();
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(currentUrl, href,"Link redirection failed for: "+href);
			//driver.navigate().back();
			driver.navigate().to("https://www.glendale.com/");
		}	
	}
	public void verifyFooterProductsLinksRedirection() throws InterruptedException {
		/*for(int i=0;i<footerProductsLinks.size();i++) {
			String href = footerProductsLinks.get(i).getAttribute("href");
			driver.navigate().to(href);
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(currentUrl, href,"Link redirection failed for: "+href);
			driver.navigate().to("https://www.glendale.com/");*/
			
			for (int i = 0; i < footerProductsLinks.size(); i++) {
				Thread.sleep(1000);
				System.out.println("Footer Product link: " + footerProductsLinks.get(i).getText());
				footerProductsLinks.get(i).click();
				System.out.println("URL: " + driver.getCurrentUrl());
				driver.navigate().to("https://www.glendale.com/");
				count++;
			}
			System.out.println("Footer Products links Count: " + count);
		}
	public void verifyFooterSocialMediaLinksRedirection() {
		for(int i=0;i<footerSocialMediaLinks.size();i++) {
			String href = footerSocialMediaLinks.get(i).getAttribute("href");
			System.out.println("href: "+href);
			driver.navigate().to(href);
			String act = driver.getCurrentUrl();
			Assert.assertEquals(act, href,"Link redirection failed for: "+href);
			driver.navigate().to("https://www.glendale.com/");
		}
	}
	public boolean verigyFooterLogoPresenceAndClickable() {
		Assert.assertTrue(footerLogo.isDisplayed() && footerLogo.isEnabled(), "Logo is not displayed");
		String exp = "https://www.glendale.com/";
		String act = driver.getCurrentUrl();
		Assert.assertEquals(act, exp, "Clicking the logo did not navigate to the homepage!");
		return true;
		
	}
	
	}
	
	

