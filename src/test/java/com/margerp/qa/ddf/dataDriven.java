package com.margerp.qa.ddf;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class dataDriven {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		// copied and pasted ChromeDriver and version 78.0.3904.70
		// initialization
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.get("http://172.16.8.17/margwebsite/qa");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// Title check
		String title = driver.getTitle();
		assertEquals(title, "Marg");
		System.out.println("Home page is verified");
		// login
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		System.out.println("Login page opened successfully");
		driver.findElement(By.id("userid")).sendKeys("admin");
		System.out.println("User ID given successfully as admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
		System.out.println("password given successfully as 1234");
		driver.findElement(By.id("btnSave")).click();
		System.out.println("Company list opened successfully");
		// company search
		WebElement searchBox = driver.findElement(By
				.xpath("//input[@id='SearchBox']"));
		searchBox.sendKeys("Vijay");
		searchBox.sendKeys(Keys.ENTER);
		System.out.println("Main page opened successfully");

		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println("back to creating the company page");

		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		System.out.println("opened CREATE COMPANY page successfully");

		// Excel Code
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Admin.DESKTOP-P28CFV6\\Desktop\\ddf.xlsx");
		System.out.println("Excel path created Successfully");

		String Company_name = reader.getCellData("Sheet1", "company name", 2);
		System.out.println("Company name:-" + Company_name);
		driver.findElement(By.xpath("//input[@id='txtcompname']")).sendKeys(
				Company_name);
		System.out.println("company name given successfully");

		String address = reader.getCellData("Sheet1", "Address", 2);
		System.out.println("Addrees:-  " + address);
		driver.findElement(By.xpath("//input[@id='txtaddress1']")).sendKeys(
				address);
		System.out.println("address given successfully");
		/*
		String country = reader.getCellData("Sheet1", "country", 2);
		System.out.println("Country name:-  " + country);
		driver.findElement(By.xpath("//input[@id='ddlcountry']")).sendKeys(country);
		System.out.println("country given successfully");
		*/
		String state = reader.getCellData("Sheet1", "state", 2);
		System.out.println("State:-  " + state);
		driver.findElement(By.xpath("//input[@id='ddlstate']")).sendKeys(state);
		System.out.println("State give successfully ");

		String pincode = reader.getCellData("Sheet1", "pincode", 2);
		System.out.println("pincode:-  " + pincode);
		driver.findElement(By.xpath("//input[@id='txtpincode']")).sendKeys(
				pincode);
		System.out.println("pincode give successfully");

		String phone = reader.getCellData("Sheet1", "phone", 2);
		System.out.println("Phone:-  " + phone);
		int size = 0;
		if (size == 10) {
			driver.findElement(By.xpath("//input[@id='txtphone']")).sendKeys(phone);
		} else {
			System.out.println("No limit is set.");
		}
		System.out.println("Phone number given successfully");

		String website = reader.getCellData("Sheet1", "website", 2);
		System.out.println("Website is :-  " + website);
		driver.findElement(By.xpath("//input[@id='txtUrl']")).sendKeys(website);
		System.out.println("Website give successfully");
		
		 	//gst
		String gst = reader.getCellData("Sheet1", "GST", 2);
		String gst2 = reader.getCellData("Sheet1", "GST", 3);
		System.out.println("GST 1;-  "+gst);
		System.out.println("GST 2;-  "+gst2);
		if(driver.findElement(By.xpath("//*[@id='comptype']/option[1]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='gstnumber']")).sendKeys(gst);
			System.out.println("GST given successfully!");
			 WebElement datgst= driver.findElement(By.xpath("//input[@id='txtregdate']"));
		        datgst.sendKeys(gst2);
		}
		else if(driver.findElement(By.xpath("//*[@id='comptype']/option[2]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='gstnumber']")).sendKeys(gst);
	        WebElement datgst= driver.findElement(By.xpath("//input[@id='txtregdate']"));
	        datgst.sendKeys(gst2);
		}
		else if (driver.findElement(By.xpath("//*[@id='comptype']/option[3]")).isSelected()){
			driver.findElement(By.xpath("//select[@id='ddltaxstruc']"));
		}
		
			//Trade LIC
		String trade01 = reader.getCellData("Sheet1", "Trade LIC", 2);
		System.out.println("Trade LIC first value :-   " + trade01);
		String trade02 = reader.getCellData("Sheet1", "Trade LIC", 3);
		System.out.println("Trade LIC second Value:-   "+ trade02);
		if (driver.findElement(By.xpath("//*[@id='ddlbusinesstype']/option[2]")).isSelected()){
			WebElement trade =  driver.findElement(By.xpath("//input[@id='txtdlno']"));
			trade.sendKeys(trade01);
		        WebElement datst= driver.findElement(By.xpath("//input[@id='dlexpdate']"));
		        datst.sendKeys(trade02);
		        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		        driver.findElement(By.id("btn-Switch Tab")).click();
			}
			else if(driver.findElement(By.xpath("//*[@id='ddlbusinesstype']/option[3]")).isSelected()){
				WebElement trade1 =  driver.findElement(By.xpath("//*[@id='txtdlno']"));
				trade1.sendKeys(trade01);
				WebElement datst= driver.findElement(By.xpath("//input[@id='dlexpdate']"));
		        datst.sendKeys(trade02);
		        driver.findElement(By.id("btn-Switch Tab")).click();
			}
			else if(driver.findElement(By.xpath("//*[@id='ddlbusinesstype']/option[4]")).isSelected()){
				WebElement trade2 =  driver.findElement(By.xpath("//*[@id='txtdlno']"));
				trade2.sendKeys(trade01);
				WebElement datst= driver.findElement(By.xpath("//input[@id='dlexpdate']"));
		        //datst.sendKeys(trade);
		        driver.findElement(By.id("btn-Switch Tab")).click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
