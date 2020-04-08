package Discount_Master;

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

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Agency_Disc_New {
	WebDriver driver;
	WebDriverWait Wait;
	
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
	String user        = 	reader.getCellData("Pant", "user", 2);
   	String pass 	   = 	reader.getCellData("Pant", "password", 2);
   	String Companyname = 	reader.getCellData("Pant", "Company_name", 2);
   	
	String ItemDisc    =	reader.getCellData("Ledger", "Item Discount %", 2);
	String BrkExpon    =	reader.getCellData("Ledger", "BRK/EXP Discount on", 2);
	String Brkexpper   =	reader.getCellData("Ledger", "BRK/EXP Discount %", 2);
	String AgenDisc    =	reader.getCellData("Ledger", "Agency_Discount", 2);
	String BrkDisc     =	reader.getCellData("Ledger", "Brk_Disc", 2);
	String BanAgen     =	reader.getCellData("Ledger", "Ban_Agen", 2);
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
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
			textbox.sendKeys("vamsikrishna");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Discount Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Agency General Discount")).click();
	 }
	public void serchAgency(){
		WebElement seragy = driver.findElement(By.xpath("//input[@id='searchItemsAgency']"));
		seragy.clear();
		seragy.sendKeys("Agency1");
		seragy.sendKeys(Keys.ENTER);
	}
	public void retailers(){
		WebElement retail = driver.findElement(By.xpath("//*[contains(@id,'txt-RetailerDiscount1')]"));
		retail.clear();
		retail.sendKeys("2");
		retail.sendKeys(Keys.ENTER);
	}
	public void stockstis(){
		WebElement stock = driver.findElement(By.xpath("//*[contains(@id,'txt-StockistDiscount1')]"));
		stock.clear();
		stock.sendKeys("2");
		stock.sendKeys(Keys.ENTER);
		
	}
	public void DistDisc(){
		WebElement DD = driver.findElement(By.xpath("//*[contains(@id,'txt-DistributorDiscount1')]"));
		DD.clear();
		DD.sendKeys("2");
		DD.sendKeys(Keys.ENTER);
	}
	public void OtherDisc(){
		WebElement Other = driver.findElement(By.xpath("//*[contains(@id,'txt-OtherDiscount1')]"));
		Other.clear();
		Other.sendKeys("0");
		Other.sendKeys(Keys.ENTER);
	}
	public void days(){
		 WebElement datfrom= driver.findElement(By.xpath("//*[contains(@id,'txt-DiscountAppFromDate')]"));
	        datfrom.sendKeys("30042019");
	        datfrom.sendKeys(Keys.ENTER);
	        
	        //to date
	     WebElement dateto= driver.findElement(By.xpath("//*[contains(@id,'txt-DiscountAppToDate')]"));
	     dateto.sendKeys("30052019");
	     dateto.sendKeys(Keys.ENTER);
	     
	     if(driver.findElement(By.xpath("//*[@id='discount1']/option[1]")).isSelected()){
	    	 WebElement voldisc = driver.findElement(By.xpath("//*[contains(@id,'txt-VDisc1')]"));
	    	 voldisc.sendKeys("00");
	    	 voldisc.sendKeys(Keys.ENTER);
	     }
	     else if(driver.findElement(By.xpath("//*[@id='discount1']/option[2]")).isSelected()){
	    	 dateto.sendKeys(Keys.ENTER);
	     }
	     else if(driver.findElement(By.xpath("//*[@id='discount1']/option[3]")).isSelected()){
	    	 WebElement voldisc = driver.findElement(By.xpath("//*[contains(@id,'txt-VDisc1')]"));
	    	 voldisc.sendKeys("00");
	    	 voldisc.sendKeys(Keys.ENTER);
	     }
	     else if(driver.findElement(By.xpath("//*[@id='discount1']/option[4]")).isSelected()){
	    	 WebElement voldisc = driver.findElement(By.xpath("//*[contains(@id,'txt-VDisc1')]"));
	    	 voldisc.sendKeys("00");
	    	 voldisc.sendKeys(Keys.ENTER);
	     }
	     else if(driver.findElement(By.xpath("//*[@id='discount1']/option[5]")).isSelected()){
	    	 WebElement voldisc = driver.findElement(By.xpath("//*[contains(@id,'txt-VDisc1')]"));
	    	 voldisc.sendKeys("00");
	    	 voldisc.sendKeys(Keys.ENTER);
	     }
	    
	        
	}
	 public static void main(String[] args) throws InterruptedException {
		 Agency_Disc_New adn = new Agency_Disc_New();	
		 adn.webLaunch();
		 adn.login();
		 adn.action();
		 adn.serchAgency(); 
		 adn.retailers();
		 adn.stockstis();
		 adn.DistDisc();
		 adn.OtherDisc();
		 adn.days();
		 
	}
	
	 
}
