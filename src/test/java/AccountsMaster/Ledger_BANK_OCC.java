package AccountsMaster;

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

public class Ledger_BANK_OCC {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
    
    String user        = 	reader.getCellData("Led_Bank_Mr", "User", 2);
	String pass 	   = 	reader.getCellData("Led_Bank_Mr", "password", 2);
	String Companyname = 	reader.getCellData("Led_Bank_Mr", "CompanyName", 2);
	String LedCode	   = 	reader.getCellData("Led_Bank_Mr", "LedgerCodeReq", 2);
	String Staion 	   = 	reader.getCellData("Led_Bank_Mr", "Station Required", 2);
	String DupLed      =  	reader.getCellData("Led_Bank_Mr", "Duplicate allowed", 2);
	String Altercode   =	reader.getCellData("Led_Bank_Mr", "Alternate Code", 2);
	String LedName     =	reader.getCellData("Led_Bank_Mr", "Ledger Name", 2);
	String AccGroup    =  	reader.getCellData("Led_Bank_Mr", "Account Group", 2);
	String Staion1     =	reader.getCellData("Led_Bank_Mr", "Station", 2);
	String Milto       =	reader.getCellData("Led_Bank_Mr", "Mail to", 2);
	String Ad1         =	reader.getCellData("Led_Bank_Mr", "Address1", 2);
	String Ad2  	   =	reader.getCellData("Led_Bank_Mr", "Address2", 2);
	String Ad3         =  	reader.getCellData("Led_Bank_Mr", "Address3", 2);
	String Country	   =	reader.getCellData("Led_Bank_Mr", "Country", 2);
	String State       =	reader.getCellData("Led_Bank_Mr", "State", 2);
	String City        =  	reader.getCellData("Led_Bank_Mr", "City", 2);
	String Pin	       =	reader.getCellData("Led_Bank_Mr", "Pincode", 2);
	String Phn         =	reader.getCellData("Led_Bank_Mr", "Phone No", 2);
	String BalMethod   =  	reader.getCellData("Led_Bank_Mr", "Balancing Method", 2);
	String OpenBal	   =	reader.getCellData("Led_Bank_Mr", "Opening Balance", 2);
	String DrCr        =	reader.getCellData("Led_Bank_Mr", "Debit/Credit", 2);
	String ACCNo         =	reader.getCellData("Led_Bank_Mr", "Acc_Led", 2);
	String Rtgs  	   =	reader.getCellData("Led_Bank_Mr", "RTGS_led", 2);
	String Ifsc         =  	reader.getCellData("Led_Bank_Mr", "IFSC_Code", 2);
	String MIR         =  	reader.getCellData("Led_Bank_Mr", "MIR_No", 2);
	
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
		public void serchCompany() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//input[@id='SearchBox']")));
			textbox.sendKeys(Companyname);
			Thread.sleep(5000);
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='textContent']"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARFROW_DOWN);
			textbox.sendKeys(Keys.ENTER);
		}
		@Test(priority=2)
		public void Master() throws InterruptedException {
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Accounts Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ledger Master")).click();
			Thread.sleep(3000);
			
		}
		@Test(priority=3)
		public void newleder (){
			driver.findElement(By.xpath("//button[@title='New']")).click();
		}
		@Test(priority=4)
		public void ctrlrm () throws InterruptedException {
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//img[@src='./assets/images/setting.png'")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//a[@id='aControlRoomSetting']//img")));
			
			textbox1.click();
			
			Thread.sleep(2000);
			Select Codereq = new Select(driver.findElement(By.id("code")));
		    Codereq.selectByVisibleText(LedCode);
		    Thread.sleep(2000);
		    
		    Select Dupname = new Select(driver.findElement(By.xpath("//select[@id='name']")));
		    Dupname.selectByVisibleText(DupLed);
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[@class='close itemcontrolClose']")).click();
		}
		@Test(priority=5)
		public void newname() throws InterruptedException{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//*[@id='code']/option[1]")).isSelected()){
				driver.findElement(By.id("txtlegername")).sendKeys(LedName);
			}
			else if (driver.findElement(By.xpath("//*[@id='code']/option[2]")).isSelected()){
				driver.findElement(By.id("txtalternatecode")).sendKeys(Altercode);
				driver.findElement(By.id("txtlegername")).sendKeys(LedName);
			}
			else if(driver.findElement(By.xpath("//*[@id='code']/option[3]")).isSelected()){
				driver.findElement(By.id("txtalternatecode")).sendKeys(Altercode);
				driver.findElement(By.id("txtlegername")).sendKeys(LedName);
			}		
			
		}
		@Test(priority=6)
		public void Accountgroup() throws InterruptedException{
			WebElement Accgrp = driver.findElement(By.xpath("//input[@id='drpAccountGroup']"));
			Accgrp .clear();
			//textbox1.sendKeys(Keys.SPACE);
			Accgrp .sendKeys(AccGroup);
			Thread.sleep(5000);
			List<WebElement> allOptions1= driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
			int count1=allOptions1.size();
			System.out.println("No.of Autosuggesion "+count1);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count1;i++)
			{
				String text1 = allOptions1.get(i).getText();
				System.out.println(text1);
				//System.out.println(allOptions1.get(i).getText());
			}
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Accgrp.sendKeys(Keys.ARROW_DOWN);
			Accgrp.sendKeys(Keys.ENTER);
		}
		
		
		@Test(priority=7)
		public void openbal(){
			driver.findElement(By.xpath("//input[@id='txtOpeningBalance']")).sendKeys(OpenBal);
			
			Select OPBL = new Select(driver.findElement(By.id("ddlIsDebitCredit")));
			OPBL.selectByVisibleText(DrCr);
		}

}
