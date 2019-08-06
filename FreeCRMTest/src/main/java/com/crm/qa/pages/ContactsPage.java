package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	HomePage homepage;
	WebDriverWait wait = new WebDriverWait(driver, 120);
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black' and (text()='Contacts')]")
	WebElement contactslabel;
	
//	@FindBy(xpath="//td[contains(text(), 'JIthin Rajan')]")
//	WebElement contact;
	
	@FindBy(xpath="//div[contains(text(), 'Actions')]")
	WebElement actions;
	
	@FindBy(xpath="//span[contains(text(), 'Delete')]")
	WebElement deleteoption;
	
	@FindBy(xpath="//i[@class='checkmark icon']")
    WebElement clickyes;
	
	@FindBy(xpath="//button[contains(text(), 'Delete')]")
	WebElement deletebutton;
	
	@FindBy(xpath="//button[@class='ui linkedin button']//i[@class='edit icon']")
	WebElement addnewcontact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//div[@name='company']//child::input")
	WebElement company;
	
	@FindBy(xpath="//i[@class='search icon']//parent::div[@name='company']//child::i")
	WebElement clickAdd;
	
	@FindBy(xpath="//div[@class='ui right corner labeled input']//input[@name='value']")
	WebElement email;
	
	@FindBy(xpath="//i[@class='dropdown icon']//parent::div[@name='channel_type']")
	WebElement social;
	
	@FindBy(xpath="//span[contains(text(), 'Facebook')]//parent::div[@role='option']//parent::div[@class='visible menu transition']")
	WebElement facebook;
	
	@FindBy(xpath="//input[@placeholder='[[facebook_profile_url]]']")
	WebElement fbmail;
	
	@FindBy(xpath="//input[@placeholder='Number']")
	WebElement number;
	
	@FindBy(xpath="//input[@name='do_not_text']//parent::div")
	WebElement dnt;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean conatactsLabel() {
		return contactslabel.isDisplayed();
	}
	
	public boolean contactName(String name) {
		return driver.findElement(By.xpath("//td[contains(text(), '"+name+"')]")).isDisplayed();
	}
	
	public void selectContact(String name) {
		driver.findElement(By.xpath("//td[contains(text(), '"+name+"')]")).click();
}
	
	public void actions() {
		actions.click();
	}
	
	public boolean deleteOption() {
		return deleteoption.isDisplayed();
	}
	
	public void selectDelete() {
		deleteoption.click();
	}
	
	public void deleteConfirmation() {
		clickyes.click();
	}
	
	public void delete() {
		deletebutton.click();
	}
	
	public void addNew(String first, String last, String companyname, String emailid, String sChannel, String fb, String country) {
		addnewcontact.click();
		
		firstname.sendKeys(first);
		lastname.sendKeys(last);
		
		JavascriptExecutor exe = (JavascriptExecutor) driver;
				
		String js = String.format("arguments[0].value='%s'",companyname);
	    exe.executeScript(js, company);
	    clickAdd.click();
	    
	    String js1 = String.format("arguments[0].value='%s'",emailid);
	    exe.executeScript(js1, email);
		
//        Select i = new Select(driver.findElement(By.xpath("//i[@class='dropdown icon']//parent::div[@name='channel_type']")));
//		i.selectByVisibleText(sChannel);
	    social.click();
	    facebook.click();
		fbmail.sendKeys(fb);
		
//		Select select1 = new Select(driver.findElement(By.xpath("//div[@name='hint']")));
//		select1.selectByVisibleText(country);
		number.sendKeys("8939022887");
		//dnt.click();
		save.click();
		
	}

}
