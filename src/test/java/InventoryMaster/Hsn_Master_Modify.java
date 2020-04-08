package InventoryMaster;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hsn_Master_Modify {

	WebDriver driver;
	WebDriverWait Wait;
	 public void webLaunch() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	driver.get("http://172.16.8.17/margwebsite/qa");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	Wait= new WebDriverWait(driver,20);
		}
	 public void login() {
		 driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	 public void action() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
			textbox.sendKeys("vamsikrishna");
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='textContent']"));
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
			driver.findElement(By.linkText("HSN/SAC Master")).click();
		
}
	 public void control() throws InterruptedException {
		 Select Control = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
			Control.selectByVisibleText("Name");
			Thread.sleep(2000);
	}
	 public void searchHsn() throws InterruptedException {
		 WebElement textbox1 = driver.findElement(By.name("SearchBox"));
			textbox1.clear();
			textbox1.sendKeys("vamsi3456");
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
			}
	}
	 public void editHsn() {
		 driver.findElement(By.className("mksBtn")).click();
		//driver.findElement(By.id("inphsncode")).sendKeys("7569383454");
			WebElement textbox2 = driver.findElement(By.id("inphsncode"));
			textbox2.clear();
			textbox2.sendKeys("7569383454");
			
	}
	 public void name() {
		//driver.findElement(By.id("inphsnname")).sendKeys("3454vam");
		 WebElement textbox3 = driver.findElement(By.id("inphsnname"));
			textbox3.clear();
			textbox3.sendKeys("3454vam");		
	}
	 public void update(){
		 driver.findElement(By.id("btn-Update")).click();
			driver.navigate().refresh();
	 }
	 public static void main(String[] args) throws Exception {
		 Hsn_Master_Modify hmm = new Hsn_Master_Modify();
		 hmm.webLaunch();
		 hmm.login();
		 hmm.action();
		 hmm.control();
		 hmm.searchHsn();
		 hmm.suggestion();
		 hmm.editHsn();
		 hmm.name();
		 hmm.update();
	}
}
