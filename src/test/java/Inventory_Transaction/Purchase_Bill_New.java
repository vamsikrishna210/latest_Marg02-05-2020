package Inventory_Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class Purchase_Bill_New {
	WebDriver driver;
	WebDriverWait Wait;
	//String[] invalidChars= {"#", "!", "$", "@", "%", "^","~"};
	
	  String specialCharacters="~!^";
	
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
  
 
    String user        = 	reader.getCellData("purchase", "user", 2);
	String pass 	   = 	reader.getCellData("purchase", "password", 2);
	String Companyname = 	reader.getCellData("purchase", "Company_name", 2);
	String ledgername  = 	reader.getCellData("purchase", "ledger_name", 2);
	String Challanno   = 	reader.getCellData("purchase", "Order_No", 2);
	//String Challanno   = 	reader.getCellData("purchase", "Order_No", 2);
	String PenOrd	   =	reader.getCellData("purchase", "pending_Order", 2);
	String ItemCode1   =	reader.getCellData("purchase", "Item_Code", 2);
	String ItemCode2   =	reader.getCellData("purchase", "Item_Code", 3);
	String BarCode     =	reader.getCellData("purchase", "Bar_Code", 2);
	String BarCode2     =	reader.getCellData("purchase", "Bar_Code", 3);
	String Item1       =    reader.getCellData("purchase", "Item_1", 2);
	String Item2       =    reader.getCellData("purchase", "Item_1", 3);
	String PurchaseTy    =	reader.getCellData("purchase", "Pur_Type", 2);
	String Qty1        =    reader.getCellData("purchase", "Quantity_main", 2);
	String Qty2        =    reader.getCellData("purchase", "Quantity_main", 3);
	String Unit2       =	reader.getCellData("purchase", "Multi_unit_2", 2);
	String Unit1       =	reader.getCellData("purchase", "Multi_unit_1", 2);
	String Rate        =    reader.getCellData("purchase", "Rate_1", 2);
	String Rate2       =    reader.getCellData("purchase", "Rate_1", 3);
	String Message     =	reader.getCellData("purchase", "conformation_msg", 2);
	String Discount    =	reader.getCellData("purchase", "Disc_1", 2);
	String Discount2   =	reader.getCellData("purchase", "Disc_1", 3);
	String BillDisc    =	reader.getCellData("purchase", "Bill_Disc", 3);
	String BillAmount1 =	reader.getCellData("purchase", "Bill_Amount", 3);
	String Free        =	reader.getCellData("purchase", "Free_Qty", 2);
	String LSertype    =	reader.getCellData("purchase", "Serch_Led_By", 2);
	
	

	@BeforeSuite
	 public void webLaunch() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/vamsi");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
	    	driver.findElement(By.xpath("//a[@class='nav-link login']")).click();
		}
	@BeforeTest
	 public void login() {
		 driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(user);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	@Test(priority=1)
	 public void action() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
		 
		// WebElement textbox = driver.findElement(By.xpath("//*[@id='SearchBox']"));
			//textbox.clear();
		 Thread.sleep(3000);
			textbox.sendKeys(Companyname);
			
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
			Thread.sleep(2000);
			
			System.out.println("company Selected Sucessfully");
			/*WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			pass.sendKeys("1234");
			pass.sendKeys(Keys.ENTER);*/
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Inventory Trans."));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Purchase"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("New Bill")).click();
			System.out.println("purchase Bill opend Sucessfully");
	 }
	@Test(priority=2)
	 public void createPB() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.now();
		 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'txtbillDate')]")));
		 Date.sendKeys(dtf.format(date));
		 System.out.println(dtf.format(date));
		 Thread.sleep(3000);
		 Date.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		System.out.println("local date Enterd");
		 
	 }
	@Test(priority=3)
	 public void selectLedger() throws InterruptedException{
		//Serch Ledger By
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
}




