package com.marg.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.marg.qa.util.TestUtil;
import com.marg.qa.util.WebEventListener;
import com.marg.qa.util.Xls_Reader;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static Xls_Reader reader;
	public static WebEventListener EventListener;
	public static EventFiringWebDriver e_driver;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"E:\\ddF\\src\\main\\java\\com\\marg\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		
		
		
			System.setProperty("webdriver.chrome.driver",
					"E:\\ddF\\src\\main\\java\\com\\marg\\chromedriver\\qa\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		
		
		 e_driver = new EventFiringWebDriver(driver);	//EventFiringWebDriver class object
			//Create object of EvenetListenerHandler to register it with EventFiringWebDriver
		 EventListener = new WebEventListener();		//com.vienna.qa.utils.WebEventListener
		 e_driver.register(EventListener); 	// we have to register EventListener with EventFiringWebDriver
		 driver = e_driver;			//we have to assign the EventFiringWebDriver[e_driver] to the driver
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(65, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
}
	public static void excel(){
		 reader = new Xls_Reader(
				"E:\\ddF\\src\\main\\java\\com\\margerp\\qa\\ExcelData\\ddf.xlsx");
	}
	

	public static void login_Credentials() throws InterruptedException{
		prop = new Properties();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		Thread.sleep(20000);
	}
	
	}
	
