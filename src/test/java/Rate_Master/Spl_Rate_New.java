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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Spl_Rate_New {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
	String user        = 	reader.getCellData("Pant", "user", 2);
   	String pass 	   = 	reader.getCellData("Pant", "password", 2);
   	String Companyname = 	reader.getCellData("Pant", "Company_name", 2);
   	
   	String ledgername  = 	reader.getCellData("purchase", "ledger_name", 2);
   	String Item1       =    reader.getCellData("purchase", "Item_1", 2);
	String SplRtae     =	reader.getCellData("Ledger", "Special_Rates", 2);
	String Spldsc      =	reader.getCellData("Ledger", "Special_Disc", 2);
	String VolDsc      =	reader.getCellData("Ledger", "Volume_Disc", 2);
	String BanItem     =	reader.getCellData("Ledger", "Ban_Item", 2);
	String BanDsc      =	reader.getCellData("Ledger", "Ban_Disc", 2);
	String minrate     =	reader.getCellData("Ledger", "Min_Margin", 2);
	String LSertype    =	reader.getCellData("purchase", "Serch_Led_By", 2);
	@BeforeSuite
	 	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/qa");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
	   	 
		}
	@BeforeTest
	 public void login() {
		driver.findElement(By.xpath("//a[@class='nav-link login']")).click();
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(user);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	@Test(priority=1)
	 public void action() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
			Thread.sleep(3000);
			textbox.sendKeys(Companyname);
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
	@Test(priority=2)
	 public void SerchLed() throws InterruptedException{
		 Select LSerch = new Select(driver.findElement(By.xpath("//select[@id='mrgSearchBox']")));
			LSerch.selectByVisibleText(LSertype);
			
			Thread.sleep(3000);
			if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[2]")).isSelected()){
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
			 Serach1.sendKeys(ledgername);
				//Thread.sleep(2000);
				List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
				int count=allOptions.size();
				System.out.println("No.of Autosuggesion "+count);
				System.out.println("List of Autosuggesion");
				for(int i=0;i<count;i++){
					String text = allOptions.get(i).getText();
					System.out.println(text);	
				}
				
				//textbox.sendKeys(Keys.ARROW_DOWN);
				
				Serach1.sendKeys(Keys.ENTER);
				System.out.println("ledger Selected Sucessfully");
				System.out.println("_-___----__----___");
				Thread.sleep(2000);
			 
		 }
			else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[3]")).isSelected()){
				 WebDriverWait wait = new WebDriverWait(driver, 10);
				 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
				 Serach1.sendKeys(ledgername);
					//Thread.sleep(2000);
					List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
					int count=allOptions.size();
					System.out.println("No.of Autosuggesion "+count);
					System.out.println("List of Autosuggesion");
					for(int i=0;i<count;i++){
						String text = allOptions.get(i).getText();
						System.out.println(text);	
					}
					
					//textbox.sendKeys(Keys.ARROW_DOWN);
					
					Serach1.sendKeys(Keys.ENTER);
					System.out.println("ledger Selected Sucessfully");
					System.out.println("_-___----__----___");
					Thread.sleep(2000);
			}
			else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[4]")).isSelected()){
				 WebDriverWait wait = new WebDriverWait(driver, 10);
				 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
				 Serach1.sendKeys(ledgername);
					//Thread.sleep(2000);
					List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
					int count=allOptions.size();
					System.out.println("No.of Autosuggesion "+count);
					System.out.println("List of Autosuggesion");
					for(int i=0;i<count;i++){
						String text = allOptions.get(i).getText();
						System.out.println(text);	
					}
					
					//textbox.sendKeys(Keys.ARROW_DOWN);
					
					Serach1.sendKeys(Keys.ENTER);
					System.out.println("ledger Selected Sucessfully");
					System.out.println("_-___----__----___");
					Thread.sleep(2000);
			}
			else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[5]")).isSelected()){
				 WebDriverWait wait = new WebDriverWait(driver, 10);
				 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
				 Serach1.sendKeys(ledgername);
					//Thread.sleep(2000);
					List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
					int count=allOptions.size();
					System.out.println("No.of Autosuggesion "+count);
					System.out.println("List of Autosuggesion");
					for(int i=0;i<count;i++){
						String text = allOptions.get(i).getText();
						System.out.println(text);	
					}
					
					//textbox.sendKeys(Keys.ARROW_DOWN);
					
					Serach1.sendKeys(Keys.ENTER);
					System.out.println("ledger Selected Sucessfully");
					System.out.println("_-___----__----___");
					Thread.sleep(2000);
			}
			else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[6]")).isSelected()){
				 WebDriverWait wait = new WebDriverWait(driver, 10);
				 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
				 Serach1.sendKeys(ledgername);
					//Thread.sleep(2000);
					List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
					int count=allOptions.size();
					System.out.println("No.of Autosuggesion "+count);
					System.out.println("List of Autosuggesion");
					for(int i=0;i<count;i++){
						String text = allOptions.get(i).getText();
						System.out.println(text);	
					}
					
					//textbox.sendKeys(Keys.ARROW_DOWN);
					
					Serach1.sendKeys(Keys.ENTER);
					System.out.println("ledger Selected Sucessfully");
					System.out.println("_-___----__----___");
					Thread.sleep(2000);
			}
			}
	 @Test(priority=3)
	 public void serchitem() throws InterruptedException{
		 WebElement itemserch = driver.findElement(By.xpath("//input[@id='SearchItemRate']"));
		itemserch.clear();
		Thread.sleep(2000);
		itemserch.sendKeys(Item1);
		itemserch.sendKeys(Keys.ENTER);
		
		 }
	 
	 @Test(priority=4)
	 public void rate(){
		 WebElement splrate = driver.findElement(By.xpath("//*[contains(@id,'txt-SpecRate')]"));
		// splrate.clear();
		 splrate.sendKeys(Keys.BACK_SPACE);
		 splrate.sendKeys(SplRtae);
		 splrate.sendKeys(Keys.ENTER);
	 }
	 @Test(priority=5)
	 public void Discper(){
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 WebElement Dper = driver.findElement(By.xpath("//*[contains(@id,'txt-Discount1')]"));
		 Dper.clear();
		 Dper.sendKeys(Spldsc);
		 Dper.sendKeys(Keys.ENTER);
		 
	 }
	 @Test(priority=6)
	 public void ban(){
		 WebElement ban1 = driver.findElement(By.xpath("//*[contains(@id,'drp-ItemBan')]"));
		 Select ban = new Select(driver.findElement(By.xpath("//*[contains(@id,'drp-ItemBan')]")));
		 ban.selectByVisibleText(BanItem);
		 ban1.sendKeys(Keys.ENTER);
	 }
	 @Test(priority=7)
	 public void bandisc(){
		 WebElement bandis = driver.findElement(By.xpath("//*[contains(@id,'drp-BanDisc')]"));
		 Select bandisc = new Select(driver.findElement(By.xpath("//*[contains(@id,'drp-BanDisc')]")));
		 bandisc.selectByVisibleText(BanDsc);
		 bandis.sendKeys(Keys.ENTER);
	 }
	 @Test(priority=8)
	 public void minMargin(){
		 WebElement minmar = driver.findElement(By.xpath("//*[contains(@id,'txt-MinMargin')]"));
		 minmar.clear();
		 minmar.sendKeys(minrate);
		 minmar.sendKeys(Keys.ENTER);
		 }
	 /*public static void main(String[] args) throws InterruptedException {
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
		 
	}*/
}
