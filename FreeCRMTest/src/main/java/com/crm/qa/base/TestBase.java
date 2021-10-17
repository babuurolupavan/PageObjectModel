package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebElementListener;

public class TestBase {
	public static WebDriver driver ;
	public static Properties prop ;
	public  static EventFiringWebDriver e_driver;
	public static WebElementListener eventListener;
	
	 
	public TestBase() {
	prop=new Properties();
	
	try {
		FileInputStream fis=new FileInputStream("C:\\Users\\laxmi\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm"
				+ "\\qa\\config\\config.properties");
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	} 
	
	public static void initialization() {
		String  browserName=prop.getProperty("browser");
if(browserName.equals("chrome") ){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Tools\\chromedriver.exe");
		       driver= new  ChromeDriver();
		}

e_driver = new EventFiringWebDriver(driver);
// Now create object of EventListerHandler to register it with EventFiringWebDriver
eventListener = new WebElementListener();
e_driver.register(eventListener);
driver = e_driver;

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS );
    driver.get(prop.getProperty("url"));
    
	}
	

}
