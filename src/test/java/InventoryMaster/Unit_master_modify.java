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

public class Unit_master_modify {

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
			driver.findElement(By.linkText("Unit Master")).click();
	
}
	 
	public void searchUnit() throws InterruptedException {
		WebElement textbox1 = driver.findElement(By.name("SearchBox"));
		textbox1.clear();
		textbox1.sendKeys("12345vam@");
		Thread.sleep(2000);
	
	} 
	public void suggestion() {
		List<WebElement> allOptions1= driver.findElements(By.xpath("//*[@class='ag-body ag-layout-normal ag-row-no-animation']"));
		int count1=allOptions1.size();
		System.out.println("No.of Autosuggesion "+count1);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count1;i++){
			String text1 = allOptions1.get(i).getText();
			System.out.println(text1);
			//Thread.sleep(2000);
			//textbox.sendKeys(Keys.ARROW_DOWN);
			//textbox.sendKeys(Keys.ENTER);
		}
	}
	public void name() throws InterruptedException {
		driver.findElement(By.className("mksBtn")).click();
		WebElement textboxx = driver.findElement(By.id("txtUnitName"));
		textboxx.clear();
		textboxx.sendKeys("vamsi@3454");
		Thread.sleep(2000);
			
	}
	public void uqcSuggestion() {
		List<WebElement> allOptions2= driver.findElements(By.xpath("//*[@id='drpUqc']"));
		int count2=allOptions2.size();
		System.out.println("No.of Autosuggesion "+count2);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count2;i++){
			String text2 = allOptions2.get(i).getText();
			System.out.println(text2);
		}
		
		Select UQC1 = new Select(driver.findElement(By.id("drpUqc")));
		UQC1.selectByVisibleText("BOX-BOX");
		driver.findElement(By.id("btn-Update")).click();
	}
	public static void main(String[] args) throws InterruptedException {
		Unit_master_modify  unitM= new Unit_master_modify();
		unitM.webLaunch();
	    unitM.login();	
	    unitM.action();
	    unitM.searchUnit();
	    unitM.suggestion();
	    unitM.name();
	    unitM.uqcSuggestion();
	    System.out.println("Unit Modify");
	    
		
		
		
	}
	 
	 
	 }
