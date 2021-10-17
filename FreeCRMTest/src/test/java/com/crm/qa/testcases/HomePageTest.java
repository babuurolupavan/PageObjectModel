package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage  homepage;
	TestUtil  testutil;
	ContactsPage contactspage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		 loginpage=new LoginPage();
		 testutil=new TestUtil();
		 
		 
		 homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepagetitle= homepage.verifyHomePageTitle();
		 
		Assert.assertEquals(homepagetitle,"CRMPRO","HomePage title is not matched");
	}
	
	@Test(priority=2)
	public void verifUserNameTest() {
		testutil.switchtoFrame();
		
		Assert.assertTrue(homepage.verifyUserName());
				
		
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testutil.switchtoFrame();
		
		contactspage=homepage.clickOnContactsLink();
		System.out.print("");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
