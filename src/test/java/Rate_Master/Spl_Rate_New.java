package Rate_Master;

import java.util.List;
import java.util.concurrent.TimeUnit;




//import org.openqa.grid.web.servlet.handler.WebDriverRequestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Spl_Rate_New {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
	String user        = 	reader.getCellData("Pant", "user", 2);
   	String pass 	   = 	reader.getCellData("Pant", "password", 2);
   	String Companyname = 	reader.getCellData("Pant", "Company_name", 2);
	
	String SplRtae     =	reader.getCellData("Ledger", "Special_Rates", 2);
	String Spldsc      =	reader.getCellData("Ledger", "Special_Disc", 2);
	String VolDsc      =	reader.getCellData("Ledger", "Volume_Disc", 2);
	String BanItem     =	reader.getCellData("Ledger", "Ban_Item", 2);
	String BanDsc      =	reader.getCellData("Ledger", "Ban_Disc", 2);
	String minrate     =	reader.getCellData("Ledger", "Min_Margin", 2);
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
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
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
			
			WebElement submenu1 = driver.findElement(By.linkText("Rate Master"));
	                              		action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Party Wise Special Rate")).click();
	 }
	 public void SerchLed(){
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
	 public void serchitem() throws InterruptedException{
		 WebElement itemserch = driver.findElement(By.xpath("//input[@id='SearchItemRate']"));
		itemserch.clear();
		Thread.sleep(2000);
		itemserch.sendKeys("pro1");
		itemserch.sendKeys(Keys.ENTER);
		
		 }
	 public void rate(){
		 WebElement splrate = driver.findElement(By.xpath("//*[contains(@id,'txt-SpecRate')]"));
		// splrate.clear();
		 splrate.sendKeys(Keys.BACK_SPACE);
		 splrate.sendKeys("100");
		 splrate.sendKeys(Keys.ENTER);
	 }
	 public void Discper(){
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 WebElement Dper = driver.findElement(By.xpath("//*[contains(@id,'txt-Discount1')]"));
		 Dper.clear();
		 Dper.sendKeys("0");
		 Dper.sendKeys(Keys.ENTER);
		 
	 }
	 public void ban(){
		 WebElement ban1 = driver.findElement(By.xpath("//*[contains(@id,'drp-ItemBan')]"));
		 Select ban = new Select(driver.findElement(By.xpath("//*[contains(@id,'drp-ItemBan')]")));
		 ban.selectByVisibleText("Yes");
		 ban1.sendKeys(Keys.ENTER);
	 }
	 public void bandisc(){
		 WebElement bandis = driver.findElement(By.xpath("//*[contains(@id,'drp-BanDisc')]"));
		 Select bandisc = new Select(driver.findElement(By.xpath("//*[contains(@id,'drp-BanDisc')]")));
		 bandisc.selectByVisibleText("Yes");
		 bandis.sendKeys(Keys.ENTER);
	 }
	 public void minMargin(){
		 WebElement minmar = driver.findElement(By.xpath("//*[contains(@id,'txt-MinMargin')]"));
		 minmar.clear();
		 minmar.sendKeys("10");
		 minmar.sendKeys(Keys.ENTER);
		 }
	 public static void main(String[] args) throws InterruptedException {
		 Spl_Rate_New srn = new Spl_Rate_New();
		 srn.webLaunch();
		 srn.login();
		 srn.action();
		 srn.SerchLed();
		 srn.serchitem();
		 srn.rate();
		 srn.Discper();
		 srn.ban();
		 srn.bandisc();
		 srn.minMargin();
		 
	}
}
