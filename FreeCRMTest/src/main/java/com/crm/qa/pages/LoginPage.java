package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	//Creating PageFactory or Object Repository
	@FindBy(xpath="//span[@class='icon icon-xs mdi-chart-bar']")
	WebElement loginprime;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	@FindBy(xpath="//span[contains(@class, 'brand-slogan')]//parent::a[@title='free crm home']//parent::div[@class='rd-navbar-brand']")
	WebElement image;
	
	public LoginPage() {
		PageFactory.initElements(driver, this); //Initializing page factory
	}
	
	
	//Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateCRMLogo() {
		return image.isDisplayed();
	}
	
	public void PrimaryLogin() {
		loginprime.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}
	
	public HomePage Login(String un, String pwd) throws InterruptedException { //returning HomePage
		loginprime.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		return new HomePage();
	}

}
