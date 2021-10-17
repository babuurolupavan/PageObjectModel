package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFacory -OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(linkText="Sign Up")
	WebElement signup;
	@FindBy(xpath="//a[contains(@class,'navbar')]//img")
	WebElement crmlogo;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
		
	}
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
		
	}
	public HomePage login(String un,String pw) {
		
		username.sendKeys(un);
		password.sendKeys(pw);
		loginButton.click();
		
		return new HomePage();
	}
	
	
	
	
}
