package Inventory_Transaction;

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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Counter_Sale {
	WebDriver driver;
	WebDriverWait Wait;
	boolean found = false;
	// String specialCharacters="~!^";
		
		public static Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
	    
	   
	    String user        = 	reader.getCellData("Sale", "user", 2);
		String pass 	   = 	reader.getCellData("Sale", "password", 2);
		String Companyname = 	reader.getCellData("Sale", "Company_name", 2);
		String ledgername  = 	reader.getCellData("Sale", "ledger_name", 2);
		String OrderNo 	   = 	reader.getCellData("Sale", "Order_No", 2);
		String PatientId   = 	reader.getCellData("Sale", "Patient_Id", 2);
		String Prescription=	reader.getCellData("Sale", "Prescription_Id", 2);
		String DoctorId    =	reader.getCellData("Sale", "Doctor_Id", 2);
		String ItemCode1   =	reader.getCellData("Sale", "Item_Code", 2);
		String BarCode     =	reader.getCellData("Sale", "Bar_Code", 2);
		String Item1       =    reader.getCellData("Sale", "Item_1", 2);
		String SaleType    =	reader.getCellData("Sale", "Sale_Type", 2);
		String Qty1        =    reader.getCellData("Sale", "Quantity_main", 2);
		String Unit2       =	reader.getCellData("Sale", "Multi_unit_2", 2);
		String Unit1       =	reader.getCellData("Sale", "Multi_unit_1", 2);
		String Rate1       =    reader.getCellData("Sale", "Rate_1", 2);
		String Message     =	reader.getCellData("Sale", "conformation_msg", 2);
		String Discount    =	reader.getCellData("Sale", "Disc_1", 2);
		String Free        =	reader.getCellData("Sale", "Free_Qty", 2);
		String CashACC     =	reader.getCellData("Sale", "Cash_Bal", 2);
		String Remark      =	reader.getCellData("Sale", "Remark_cash", 2);
	
	@BeforeSuite
	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/QA");
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    	driver.manage().window().maximize();
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
			textbox.sendKeys(Companyname);
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
			Thread.sleep(2000);
			/*WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			pass.sendKeys("1234");
			pass.sendKeys(Keys.ENTER);*/
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Inventory Trans."));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Sale"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Counter Sale")).click();
	 }
    @Test(priority=2)
    public void first(){
    	
    }
}
