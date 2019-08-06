package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	//creating constructor and used super() to call its super constructor of Base Class
	//So, configuration/properties will be initialized
	public HomePageTest() {
		super();
	}
	
	//TCS should be separated & independent of each other
	//before each TCS --> launch the browser & login
	//execute tests'
	//after each TCS --> close the browser
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization(); //performing browser actions
		loginpage = new LoginPage(); //creating object to access methods of LoginPage
		contactspage = new ContactsPage();
		//loginpage.PrimaryLogin(); //performing prime login
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password")); //logging in using config values
	}
	
	@Test(priority=1)
	public void homePageTitleValidate() {
		String title = homepage.verifyHomePagetitle();
		Assert.assertEquals(title, "CRM", "HomePage title not matched");
		System.out.println(title);
	}
	
	@Test(priority=2)
	public void verifyUNLabdisp() {
		boolean bl = homepage.verifyUNLabel();
		Assert.assertTrue(bl);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactspage = homepage.clickContactsLink();
	}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.close();
		}
	}

}
