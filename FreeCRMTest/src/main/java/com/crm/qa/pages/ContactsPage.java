package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabelname;
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit']")
	WebElement saveBtn;
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean verifyContactspage() {
		
		return contactslabelname.isDisplayed();
	}
	
	public void createNewContact(String title,String ftName,String ltName,String comp) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}

}
