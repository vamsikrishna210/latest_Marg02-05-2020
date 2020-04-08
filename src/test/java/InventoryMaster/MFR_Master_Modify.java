package InventoryMaster;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MFR_Master_Modify {
	WebDriver driver;
	WebDriverWait Wait;
	@BeforeSuite
	 public void webLaunchMf() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
		}
	@BeforeTest
	 public void loginMf() {
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("vamsikrishna");
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();
	}
	@Test(priority=1)
	 public void actionMf() throws InterruptedException{
		 WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
			textbox.clear();
			textbox.sendKeys("JAGGI PHARMA DISTUBUTORS");
			Thread.sleep(2000);
			List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			textbox.sendKeys(Keys.ENTER);
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Inventory Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Manufacturer")).click();
	 }
	@Test(priority=2)
	 public void EditMf() throws InterruptedException{
		 WebElement serchbox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search here..')]"));
		 serchbox.clear();
		 serchbox.sendKeys("vam");
	     Thread.sleep(2000);

	     List<WebElement> allOptions1= driver.findElements(By.xpath("//*[@class='ag-body ag-layout-normal ag-row-no-animation']"));
			int count1=allOptions1.size();
			
			System.out.println("No.of Autosuggesion "+count1);
			System.out.println("List of Autosuggesion");
			
			for(int i=0;i<count1;i++){
				String text1 = allOptions1.get(i).getText();
				System.out.println(text1);	
			}
	}
	@Test(priority=3)
	public void editmf(){
		driver.findElement(By.className("mksBtn")).click();
	}
	@Test(priority=4)
	public void RenameMF(){
		WebElement name = driver.findElement(By.xpath("//input[@id='txtName']"));
		name.clear();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		name.sendKeys("mycompanykgf12345");
	}
	@Test(priority=5)
	public void chngcontry() throws InterruptedException{
		List<WebElement> allOptions1= driver.findElements(By.xpath("//select[@id='drpCountry']"));
		int count1=allOptions1.size();
		
		System.out.println("No.of Autosuggesion "+count1);
		System.out.println("List of Autosuggesion");
		
		for(int i=0;i<count1;i++){
			String text1 = allOptions1.get(i).getText();
			System.out.println(text1);	
		}
		
		Select country = new Select(driver.findElement(By.id("drpCountry")));
		country.selectByIndex(85);
		Thread.sleep(2000);
	}
	@Test(priority=6)
	public void state() throws InterruptedException{
		List<WebElement> allOptions1= driver.findElements(By.xpath("//select[@id='drpState']"));
	int count1=allOptions1.size();
	
	System.out.println("No.of Autosuggesion "+count1);
	System.out.println("List of Autosuggesion");
	
	for(int i=0;i<count1;i++){
		String text1 = allOptions1.get(i).getText();
		System.out.println(text1);	
	}
	
	Select country = new Select(driver.findElement(By.id("drpState")));
	country.selectByIndex(85);
	Thread.sleep(2000);
}
	
	@Test(priority=7)
public void update(){
	driver.findElement(By.xpath("//button[@title='Update']")).click();
}
	}

//*[@class='ag-body ag-layout-normal ag-row-no-animation']









