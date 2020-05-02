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

public class Ledger_Creditor_fieldsstaff {
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
	//String Phn         =	reader.getCellData("Ledger", "Phone No", 2);
	String Mobile1     =	reader.getCellData("Led_Bank_Mr", "Mobile 1", 2);
	String Mobl2 	   =	reader.getCellData("Led_Bank_Mr", "Mobile 2", 2);
	String Alt1        =  	reader.getCellData("Led_Bank_Mr", "Alternate Mobile1", 2);
	String Alt2  	   =	reader.getCellData("Led_Bank_Mr", "Alternate Mobile2", 2);
	String Alt3        =	reader.getCellData("Led_Bank_Mr", "Alternate Mobile3", 2);
	String BalMethod   =  	reader.getCellData("Led_Bank_Mr", "Balancing Method", 2);
	String OpenBal	   =	reader.getCellData("Led_Bank_Mr", "Opening Balance", 2);
	String DrCr        =	reader.getCellData("Led_Bank_Mr", "Debit/Credit", 2);
	String ACCNo         =	reader.getCellData("Led_Bank_Mr", "Acc_Led", 2);
	String Rtgs  	   =	reader.getCellData("Led_Bank_Mr", "RTGS_led", 2);
	String Ifsc         =  	reader.getCellData("Led_Bank_Mr", "IFSC_Code", 2);
	String MIR         =  	reader.getCellData("Led_Bank_Mr", "MIR_No", 2);
	String email         =  	reader.getCellData("Led_Bank_Mr", "Email", 2);
	
	 @BeforeSuite
		public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite");
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
			driver.findElement(By.xpath("//span[@class='box'][contains(text(),'New')]")).click();
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
		public void Accgrp() throws InterruptedException{
			Thread.sleep(3000);
			WebElement textbox1 = driver.findElement(By.xpath("//input[@id='drpAccountGroup']"));
			textbox1.clear();
			//textbox1.sendKeys(Keys.SPACE);
			textbox1.sendKeys(AccGroup);
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
		   // textbox1.sendKeys(Keys.ARROW_DOWN);
			textbox1.sendKeys(Keys.ENTER);
			/*Select Sud = new Select(driver.findElement(By.xpath("//*[@class='dropdown-menu show']")));
			Sud.selectByVisibleText("SUNDRY DEBTORS");*/
		}
	   @Test(priority=7)
		public void station() throws InterruptedException{
			if(!driver.findElements(By.xpath("//input[@id='ddlstation']")).isEmpty()){
			WebElement ston = driver.findElement(By.xpath("//input[@id='ddlstation']"));
			ston.clear();
			ston.sendKeys(Staion1);
			Thread.sleep(2000);
			List<WebElement> allOptions2= driver.findElements(By.xpath("//*[@id='ddlCountryLinkID']"));
			int count2=allOptions2.size();
			System.out.println("No.of Autosuggesion "+count2);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count2;i++)
			{
				String text2 = allOptions2.get(i).getText();
				System.out.println(text2);	
			}
			    //ston.sendKeys(Keys.ARROW_DOWN);			
				ston.sendKeys(Keys.ENTER);	
		}}
	   @Test(priority=8)
		public void Mailto() throws InterruptedException{
			WebElement milto = driver.findElement(By.xpath("//input[@id='txtMailTo']"));
			milto.clear();
			Thread.sleep(2000);
			//textbox1.sendKeys(Keys.SPACE);
			milto.sendKeys(Milto);
		}
	   @Test(priority=9)
		public void addressled() throws InterruptedException{
			WebElement Address1 = driver.findElement(By.xpath("//input[@id='txtaddress1']"));
			Address1.sendKeys(Ad1); 
			Thread.sleep(3000);
			
		}
	   @Test(priority=9)
		public void country() throws InterruptedException{
			/*WebElement cntry = driver.findElement(By.xpath("//*[@id='ddlCountryLinkID']"));
			 //cntry.clear();
			cntry.sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			cntry.sendKeys(Keys.ENTER);
			 //cntry.sendKeys("Vamsi");
			Thread.sleep(2000);
			
			driver.findElement(By.id("txtCountryName")).sendKeys("KGF12~!@#$%^34");
			driver.findElement(By.xpath("//input[@id='txtCountryCode']")).sendKeys("KGF7569");
			driver.findElement(By.xpath("//input[@id='txtCurrencySymbol']")).sendKeys("$@~~~~~!!!!!");
			driver.findElement(By.xpath("//input[@id='txtCurrencyString']")).sendKeys("GOLD7569");
			driver.findElement(By.xpath("//marg-button[@tabindex='5']//button[@id='btn-Save']")).click();*/
			WebElement textbox2 = driver.findElement(By.xpath("//*[@id='ddlCountryLinkID']"));
			textbox2.clear();
			textbox2.sendKeys(Country);
			Thread.sleep(2000);
			List<WebElement> allOptions2= driver.findElements(By.xpath("//*[@id='ddlCountryLinkID']"));
			int count2=allOptions2.size();
			System.out.println("No.of Autosuggesion "+count2);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count2;i++)
			{
				String text2 = allOptions2.get(i).getText();
				System.out.println(text2);	
			}
			   // textbox2.sendKeys(Keys.ARROW_DOWN);
				//textbox2.sendKeys(Keys.ARROW_DOWN);
				textbox2.sendKeys(Keys.ENTER);	
		}
	   @Test(priority=10)
		public void state() throws InterruptedException{
			WebElement stat1 = driver.findElement(By.id("ddlStateLinkID"));
			stat1.clear();
			
			stat1.sendKeys(State);
			Thread.sleep(2000);
			List<WebElement> allOptions3= driver.findElements(By.id("ddlStateLinkID"));
			int count3=allOptions3.size();
			System.out.println("No.of Autosuggesion "+count3);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<count3;i++)
			{
				String text3 = allOptions3.get(i).getText();
				System.out.println(text3);	
			}
			
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			//stat1.sendKeys(Keys.ARROW_DOWN);
			stat1.sendKeys(Keys.ENTER);
		}
	  @Test(priority=11)
		public void city(){
			driver.findElement(By.xpath("//*[@id='ddlCity']")).sendKeys(City);
			driver.findElement(By.xpath("//input[@id='txtPostalCode']")).sendKeys(Pin);	
		}
@Test(priority=12)
	public void contact() throws InterruptedException{
		driver.findElement(By.xpath("//input[@id='txtPhoneNo']")).sendKeys(Phn);
		driver.findElement(By.xpath("//input[@id='txtMobile']")).sendKeys(Mobile1);
		driver.findElement(By.xpath("//input[@id='txtMobile2']")).sendKeys(Mobl2);
		 driver.findElement(By.xpath("//button[@id='btnMoreMobile']")).click();
		  Thread.sleep(1000);
		  
		  driver.findElement(By.id("txtMobile1")).sendKeys(Alt1);
		  driver.findElement(By.id("txtMobile2")).sendKeys(Alt2);
		  driver.findElement(By.id("txtMobile3")).sendKeys(Alt3);
		  driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		
	}
@Test(priority=13)
	public void email(){
		driver.findElement(By.xpath("//input[@id='txtEmail1']")).sendKeys(email);
	}
@Test(priority=14)
	public void save(){
		driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
		//driver.findElement(By.xpath(" //button[@id='btn-Clear']")).click();
	}
	/*public static void main(String[] args) throws InterruptedException {
		Ledger_Creditor_fieldsstaff lcf = new Ledger_Creditor_fieldsstaff();
		lcf.webLaunch();
		lcf.login();
		lcf.serchCompany();
		lcf.Master();
		lcf.newleder();
		lcf.ctrlrm();
		lcf.newname();
		lcf.Mailto();
		lcf.addressled();
		lcf.country();
		lcf.state();
		lcf.city();
		lcf.contact();
		lcf.email();
		lcf.save();
		
	}*/}


