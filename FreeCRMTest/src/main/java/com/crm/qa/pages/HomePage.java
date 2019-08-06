package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//span[contains(text(), 'Jithin Rajan')]")
	WebElement userinfo;
	
	@FindBy(xpath="//span[contains(text(), 'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//span[contains(text(), 'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//span[contains(text(), 'Tasks')]")
	WebElement taskslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUNLabel() {
		return userinfo.isDisplayed(); 
	}
	
	public String verifyHomePagetitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickContactsLink() {
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealsLink() {
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickTasksLink() {
		taskslink.click();
		return new TasksPage();
	}
	
	

}
