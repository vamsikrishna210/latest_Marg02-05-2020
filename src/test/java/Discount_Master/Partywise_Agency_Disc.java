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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Partywise_Agency_Disc {
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
	@BeforeSuite
	 	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/qa");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
	    	driver.findElement(By.xpath("//a[@class='nav-link login']")).click();
		}
	@BeforeTest
	
	 public void login() {
		// driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	@Test(priority=1)
	 public void action() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
		Thread.sleep(3000);
		textbox.sendKeys(Companyname);
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
			driver.findElement(By.linkText("Party Wise Agency Discount")).click();
	 }
	
	@Test(priority=2)
	 public void ledgsel(){
		 WebElement Serchbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
		 Serchbox.sendKeys("vamsi Deb");
		 
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
			Serchbox.sendKeys(Keys.ENTER);
	 }
	@Test(priority=3)
	 public void serAgency(){
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 WebElement seragy = driver.findElement(By.xpath("//input[@id='SearchBox1']"));
			seragy.clear();
			seragy.sendKeys("VAMMSSIIIIKJNK75");
			seragy.sendKeys(Keys.ENTER);
	 }
	@Test(priority=4)
	 public void disc()  {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 WebElement disc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt-Discount-0")));
		 disc.sendKeys(Keys.BACK_SPACE);
		 disc.sendKeys("4232");
		
        	
        	
        	//WebElement disc = driver.findElement(By.xpath("//input[@id='txt-Discount-0']"));
		 //WebElement disc = driver.findElement(By.xpath("//*[contains(@id,'txt-Discount-0')]"));
		 /*disc.clear();
//		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 disc.sendKeys("1");*/
		 disc.sendKeys(Keys.ENTER);
	 }
	@Test(priority=5)
	 public void Brk(){
		 WebElement brk = driver.findElement(By.xpath("//*[contains(@id,'txt-BRK_EXP_Discount')]"));
		 brk.clear();
		 brk.sendKeys("00");
		 brk.sendKeys(Keys.ENTER);
		 	 
	 }
	@Test(priority=6)
	 public void volume (){
		 if(driver.findElement(By.xpath("//*[@id='discount1']/option[1]")).isSelected()){
	    	 WebElement voldisc = driver.findElement(By.xpath("//*[contains(@id,'txt-VDisc')]"));
	    	 voldisc.sendKeys("00");
	    	 voldisc.sendKeys(Keys.ENTER);
	     }
	     else if(driver.findElement(By.xpath("//*[@id='discount1']/option[2]")).isSelected()){
	    	 WebElement brk = driver.findElement(By.xpath("//*[contains(@id,'txt-BRK_EXP_Discount')]"));
	    	 brk.sendKeys(Keys.ENTER);
	     }
	     else if(driver.findElement(By.xpath("//*[@id='discount1']/option[3]")).isSelected()){
	    	 WebElement voldisc = driver.findElement(By.xpath("//*[contains(@id,'txt-VDisc')]"));
	    	 voldisc.sendKeys("00");
	    	 voldisc.sendKeys(Keys.ENTER);
	     }
	     else if(driver.findElement(By.xpath("//*[@id='discount1']/option[4]")).isSelected()){
	    	 WebElement voldisc = driver.findElement(By.xpath("//*[contains(@id,'txt-VDisc')]"));
	    	 voldisc.sendKeys("00");
	    	 voldisc.sendKeys(Keys.ENTER);
	     }
	     else if(driver.findElement(By.xpath("//*[@id='discount1']/option[5]")).isSelected()){
	    	 WebElement voldisc = driver.findElement(By.xpath("//*[contains(@id,'txt-VDisc')]"));
	    	 voldisc.sendKeys("00");
	    	 voldisc.sendKeys(Keys.ENTER);
	     }
	    
	 }
	@Test(priority=7)
	 public void banAgen(){
		 WebElement AgBan = driver.findElement(By.xpath("//*[contains(@id,'drp-BanCompany')]"));
		 Select AgenBan = new Select (driver.findElement(By.xpath("//*[contains(@id,'drp-BanCompany')]")));
		 AgenBan.selectByVisibleText("Yes");
		 AgBan.sendKeys(Keys.ENTER);
	 }
	@Test(priority=8)
	 public void banDisc(){
		 WebElement DiscBan = driver.findElement(By.xpath("//*[contains(@id,'drp-BanDisc')]"));
		 Select DicBan = new Select(driver.findElement(By.xpath("//*[contains(@id,'drp-BanDisc')]")));
		 DicBan.selectByVisibleText("No");
		 DiscBan.sendKeys(Keys.ENTER);
	 }
	@Test(priority=9)
	 public void MinMar() throws InterruptedException{
		 if(driver.findElement(By.xpath("//*[@id='minimumMargin']/option[1]")).isSelected()){
			 WebElement DiscBan = driver.findElement(By.xpath("//*[contains(@id,'drp-BanDisc')]"));
			 DiscBan.sendKeys(Keys.ENTER); 
		 }
		 else if(driver.findElement(By.xpath("//*[@id='minimumMargin']/option[2]")).isSelected()){
			 WebElement min = driver.findElement(By.xpath("//*[contains(@id,'txt-MinMargin-0')]"));
			// min.clear();
			 min.sendKeys(Keys.BACK_SPACE);
			 Thread.sleep(2000);
			 min.sendKeys("500");
			 min.sendKeys(Keys.ENTER);
		 }
	 }
	 /*public static void main(String[] args) throws InterruptedException {
		 Partywise_Agency_Disc pad =new Partywise_Agency_Disc();
		 pad.webLaunch();
		 pad.login();
		 pad.action();
		 pad.ledgsel();
		 pad.serAgency();
		 pad.disc();
		 pad.Brk();
		 pad.volume();
		 pad.banAgen();
		 pad.banDisc();
		 pad.MinMar();
		 
	}*/
	
	 
}
