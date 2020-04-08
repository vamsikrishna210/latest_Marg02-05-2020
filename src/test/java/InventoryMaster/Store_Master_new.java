package InventoryMaster;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Store_Master_new {
	WebDriver driver;
	WebDriverWait Wait;
	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
		}
	 public void login() {
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("vamsikrishna");
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	 public void action() throws InterruptedException{
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
			driver.findElement(By.linkText("Store Master")).click();
	 }
	public void newb() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='btn-New']/span[1]")).click();
		Thread.sleep(2000);
	}
	public void controlroom() throws InterruptedException{
		driver.findElement(By.id("btnControlRoom")).click();
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    WebElement textboxx = driver.findElement(By.id("txtstore"));
		textboxx.clear();
		Thread.sleep(2000);
		textboxx.sendKeys("kgf12");
		driver.findElement(By.id("txtstoreNo")).sendKeys("30");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='close itemcontrolClose']")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	public void address(){
		driver.findElement(By.id("txtStoreName")).sendKeys("kgfstore1");
		driver.findElement(By.id("txtaddress1")).sendKeys("kgfstore1");
		driver.findElement(By.id("txtaddress2")).sendKeys("kgfstore2");
		driver.findElement(By.id("txtaddress3")).sendKeys("kgfstore3");
	}
	public void savestr(){
		driver.findElement(By.id("btn-Save")).click();
	}
	public static void main(String[] args) throws Exception {
		Store_Master_new str = new Store_Master_new();
		str.webLaunch();
		str.login();
		str.action();
		str.newb();
		str.controlroom();
		str.address();
		str.savestr();
	}
}
