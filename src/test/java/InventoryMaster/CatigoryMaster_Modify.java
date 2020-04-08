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

public class CatigoryMaster_Modify {
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
			driver.findElement(By.linkText("Category Master")).click();
}
	 public void search() throws InterruptedException{
		 WebElement textboxser = driver.findElement(By.name("SearchBox"));
			textboxser.clear();
			textboxser.sendKeys("vamsikrishna");
			Thread.sleep(2000);
	 }
	 public void list1(){
		 List<WebElement> allOptionsL= driver.findElements(By.xpath("//*[@class='ag-body ag-layout-normal ag-row-no-animation']"));
			int countL=allOptionsL.size();
			System.out.println("No.of Autosuggesion "+countL);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<countL;i++){
				String textL = allOptionsL.get(i).getText();
				System.out.println(textL);	
			}
			}
		public void edit1(){
			
			driver.findElement(By.className("mksBtn")).click();	
		}
       public void ctgry() throws InterruptedException{
    	   WebElement textboxx = driver.findElement(By.id("txtCategoryName"));
			textboxx.clear();
			Thread.sleep(2000);
			textboxx.sendKeys("vam@3454");
}
       public void margcont() throws InterruptedException{
    	   driver.findElement(By.id("txtMargin")).sendKeys("123456");
			Select Continued = new Select(driver.findElement(By.id("drpContinued")));
			Continued.selectByVisibleText("Yes");
       }
 public void save() throws InterruptedException{
	 driver.findElement(By.xpath("//*[@id='btn-Update']/span[1]")).click();
		
		Thread.sleep(2000);
		driver.navigate().refresh();
 }
 public static void main(String[] args) throws Exception {
	 CatigoryMaster_Modify cmm = new CatigoryMaster_Modify();
	 cmm.webLaunch();
	 cmm.login();
	 cmm.action();
	 cmm.search();
	 cmm.list1();
	 cmm.edit1();
	 cmm.ctgry();
	 cmm.margcont();
	 cmm.save();
}
}
