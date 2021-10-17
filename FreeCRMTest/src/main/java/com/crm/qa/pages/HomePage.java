package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
 
	@FindBy(xpath="//td[contains(text(),'User: Gayatri das')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink ;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink ;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newcontactLink ;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
	}
	
   public String verifyHomePageTitle() {
	   
	   
	   return driver.getTitle();
   }
   
   public boolean  verifyUserName() {
	    return userNameLabel.isDisplayed();
	   
   }
   
   public ContactsPage clickOnContactsLink() {
	   
	    contactLink.click();
	    return new ContactsPage();
   }
   
   public DealsPage clickOnDealsLink() {
	
	   dealsLink.click();
	    return new DealsPage();
	   
  }
   
   public TasksPage clickTasksLink() {
		
	   TasksLink.click();
	    return new TasksPage();
	   
  }
   
 public ContactsPage clickOnNewContactlink()  {
	 Actions action=new Actions(driver);
	 action.moveToElement(contactLink).build().perform();
	 
	 newcontactLink.click(); 
	 
	 return new ContactsPage();
 }
   
   
   
   
}


