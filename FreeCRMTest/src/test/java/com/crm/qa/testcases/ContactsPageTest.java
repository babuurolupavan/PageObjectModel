package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest  extends TestBase{
	LoginPage loginpage;
	HomePage  homepage;
	TestUtil  testutil;
	ContactsPage contactspage;
	String  sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		 loginpage=new LoginPage();
		 testutil=new TestUtil();
		 homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		 testutil.switchtoFrame();
		 	}
	
	
	@Test(priority=1)
	public void verifyContactspageTest() {
		contactspage=homepage.clickOnContactsLink();

		Assert.assertTrue(contactspage.verifyContactspage());
		
	}
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String ftName,String ltname,String comp) {
		contactspage=homepage.clickOnNewContactlink();
		 contactspage.createNewContact(title,ftName,ltname,comp);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		
		Object data[][]=testutil.getTestData(sheetName);
		
		return data;
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	
	
}
