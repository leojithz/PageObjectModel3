package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	//creating constructor and used super() to call its super constructor of Base Class
	//So, configuration/properties will be initialized
	public LoginPageTest() { 
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization(); //performs the browser actions
		loginpage = new LoginPage(); //creating LoginPage class Object, so that using which we can invoke the methods from
		                             //LoginPage class directly here
	}
	
	@Test(priority=1)
	public void validatetitle() {
	
		String title = loginpage.ValidateLoginPageTitle(); //using LoginPage class object, accessing its method directly
		Assert.assertEquals(title, "Free CRM software for any Business");	
	}
	
	@Test(priority=2)
	public void validatelogo() {
		boolean value = loginpage.ValidateCRMLogo();
		Assert.assertTrue(value);
		//Assert.assertEquals(value, true);
	}
	
	@Test(priority=3)
	public void login() throws InterruptedException {
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		 if (driver != null) {
		driver.close();
		 }
		}
	

}
