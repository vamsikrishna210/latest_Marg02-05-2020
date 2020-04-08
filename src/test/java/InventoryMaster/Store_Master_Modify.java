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
import org.openqa.selenium.support.ui.WebDriverWait;

public class Store_Master_Modify {
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
		
		 WebElement textbox = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
		 textbox.clear();
			textbox.sendKeys("vamsikrishna");
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
	 public void searchStore() throws InterruptedException {
			WebElement textbox1 = driver.findElement(By.name("SearchBox"));
			textbox1.clear();
			textbox1.sendKeys("kgfstore1");
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
			WebElement textboxx = driver.findElement(By.id("txtStoreName"));
			textboxx.clear();
			textboxx.sendKeys("KGF1234~!`#$%^&&*");
			Thread.sleep(2000);
				
		}
		public void address() {
			WebElement textadd1 = driver.findElement(By.id("txtaddress1"));
			textadd1 .clear();
			textadd1 .sendKeys("KGF1234~!`#$%^&&*");
			
			WebElement textadd2 = driver.findElement(By.id("txtaddress2"));
			textadd2 .clear();
			textadd2 .sendKeys("KGF1234~!`#$%^&&*");
			
			WebElement textadd3 = driver.findElement(By.id("txtaddress3"));
			textadd3 .clear();
			textadd3 .sendKeys("KGF1234~!`#$%^&&*");
			
/*			driver.findElement(By.id("txtaddress1")).sendKeys("kgffsfs123~~!$%^&*");
			driver.findElement(By.id("txtaddress2")).sendKeys("kgffsfs123~~!$%^&*");
			driver.findElement(By.id("txtaddress3")).sendKeys("kgffsfs123~~!$%^&*");*/
			
		}
		public void updateStore() {
		driver.findElement(By.id("btn-Update")).click();	
		}

	public static void main(String[] args) throws InterruptedException {
		Store_Master_Modify sM= new Store_Master_Modify();
		sM.webLaunch();
		sM.login();
		sM.action();
		sM.searchStore();
		sM.suggestion();
		sM.name();
		sM.address();
		sM.updateStore();
		
	}

}
