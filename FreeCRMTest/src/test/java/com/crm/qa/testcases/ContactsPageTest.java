package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	String sheetname = "Contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testutil = new TestUtil();
		homepage = new HomePage();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyConatactsLabel() {
		Boolean bn = contactspage.conatactsLabel();
	    Assert.assertTrue("Label not displayed", bn);
	}
	
	@Test(priority=2)
	public void searchContactName() {
		Boolean bn2 = contactspage.contactName("Test2 Test2");
		if((bn2==true)) {
			contactspage.selectContact("Test2 Test2");
			contactspage.actions();
			Boolean bn3 = contactspage.deleteOption();
			if(bn3==true) {
				contactspage.selectDelete();
				contactspage.deleteConfirmation();
				contactspage.delete();
			}
		}
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
		
	@Test(priority=3, dataProvider="getCRMTestData")
	public void addNewContact(String firstname, String lastname, String companyname, String emailid, String socialchannel, String facebook_emailid, String country) {
	
		contactspage.addNew(firstname, lastname, companyname, emailid, socialchannel, facebook_emailid, country);
	}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.close();
		}
}
}
