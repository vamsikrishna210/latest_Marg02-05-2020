package Opening_Balance;

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

public class Opening_Balance_Ledger {
	WebDriver driver;
	WebDriverWait Wait;
	
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
	
	String user	 		= reader.getCellData("Led_Bank_Mr", "User", 2);
	String pass 		= reader.getCellData("Led_Bank_Mr", "password", 2);
	String Companyname  = reader.getCellData("Led_Bank_Mr", "CompanyName", 2);
	String OpenBal   	= reader.getCellData("Led_Bank_Mr", "Opening Balance", 2);
	String DrCr 		= reader.getCellData("Led_Bank_Mr", "Debit/Credit", 2);
	String ACCNo 		= reader.getCellData("Led_Bank_Mr", "Acc_Led", 2);
	String Rtgs 		= reader.getCellData("Led_Bank_Mr", "RTGS_led", 2);
	String Ifsc		    = reader.getCellData("Led_Bank_Mr", "IFSC_Code", 2);
	String MIR 			= reader.getCellData("Led_Bank_Mr", "MIR_No", 2);
	String ledgername   = reader.getCellData("Led_Bank_Mr", "ledger_name", 2);
	String ledser	    = reader.getCellData("Led_Bank_Mr", "Led_Sel", 2);
	String Amt 			= reader.getCellData("Led_Bank_Mr", "Amount_1", 2);
	String Bill         = reader.getCellData("Led_Bank_Mr", "Bill_No", 2);
	String dys  	    = reader.getCellData("Led_Bank_Mr", "Days_ob", 2);
	String Bvalue 	    = reader.getCellData("Led_Bank_Mr", "Bill_Value", 2);
	String CD         = reader.getCellData("Led_Bank_Mr", "CR_Dr", 2);
	String Remarks  	    = reader.getCellData("Led_Bank_Mr", "Remarks", 2);
	
	
	
	
	//			

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
		 driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(user);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	@Test(priority=1)
	 public void action() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
			textbox.sendKeys(Companyname);
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
			
			WebElement submenu1 = driver.findElement(By.linkText("Opening Balance"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ledger")).click();
	 }
	@Test(priority=2)
	public void serchledg() throws InterruptedException{
		Select led1 = new Select(driver.findElement(By.xpath("//*[@id='mrgSearchBox']")));
    	led1.selectByVisibleText(ledser);
    	
    	if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[2]")).isSelected()){
       	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(2000);
			textbox.sendKeys(ledgername);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[text()='Vamsi Debit']")).click();
			/*if(!driver.findElements(By.xpath("//p[contains(text(),'Not Found!')]")).isEmpty()){
			String Actul =driver.findElement(By.xpath("//p[contains(text(),'Not Found!')]")).getText();
			//String typedValue = textbox.getAttribute("value");
			String ttt= textbox.getText().trim();
			String exprt = ttt.concat(Actul).trim();
			
			System.out.println(Actul);
			System.out.println("==================");
			System.out.println(ttt);
			System.out.println("----------------");
			System.out.println(exprt);
			System.out.println("-------------------");
			
			}
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='textContent']"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}*/
			//textbox.sendKeys(Keys.ARROW_DOWN);
			textbox.sendKeys(Keys.ENTER);
			System.out.println("ledger Serched by Name");
			
       }
       // Code
       else  if(driver.findElement(By.xpath("//option[contains(text(),'Code')]")).isSelected()){
         	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
  			//textbox.clear();
  		    Thread.sleep(2000);
  			textbox.sendKeys(ledgername);
  			Thread.sleep(2000);
  			//driver.findElement(By.xpath("//*[text()='Vamsi Debit']")).click();
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
  			System.out.println("ledger Serched by Mobile");
  			
      }
       //Mobile
       else  if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[3]")).isSelected()){
      	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(2000);
			textbox.sendKeys(ledgername);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[text()='Vamsi Debit']")).click();
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
			System.out.println("ledger Serched by Mobile");
			
   }
     //DL No
       else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[4]")).isSelected()){
      	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(2000);
			textbox.sendKeys(ledgername);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[text()='Vamsi Debit']")).click();
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
			System.out.println("ledger Serched by DL No.");
			

}
    // Adress
       else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[5]")).isSelected()){
      	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(2000);
			textbox.sendKeys(ledgername);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[text()='Vamsi Debit']")).click();
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
			System.out.println("ledger Serched by Address");
			
       }
       // GSTIN
       else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[6]")).isSelected()){
      	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(2000);
			textbox.sendKeys(ledgername);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[text()='Vamsi Debit']")).click();
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
			System.out.println("ledger Serched by GSTIN");
   }
		
		
		
	}
	 
	@Test (priority=3)
	public void Amount (){
		WebElement amount = driver.findElement(By.xpath("//input[@id='txtAmount']"));
		amount.sendKeys(Keys.BACK_SPACE);
		amount.sendKeys(Amt);
		amount.sendKeys(Keys.ENTER);
		
		Select Dr = new Select (driver.findElement(By.xpath("//select[@id='drpCrDr']")));
		Dr.selectByVisibleText(CD);
		
		WebElement Dr1 =  driver.findElement(By.xpath("//select[@id='drpCrDr']"));
		Dr1.sendKeys(Keys.ENTER);
	}
	@Test (priority=4)
	public void Date() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.now();
		 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txt-dDate-0']")));
		 //WebElement dateFy= driver.findElement(By.xpath("//input[@id='txtbillDate']"));  
		 Date.sendKeys(dtf.format(date));
		 
		 Thread.sleep(3000);
		 Date.sendKeys(Keys.ENTER);
	}
	@Test(priority=5)
	public void billno(){
		WebElement bill = driver.findElement(By.xpath("//input[@id='txt-BillNo-0']"));
		bill.clear();
		//bill.sendKeys(Keys.BACK_SPACE);
		bill.sendKeys(Bill);
		bill.sendKeys(Keys.ENTER);
	}
	@Test(priority=6)
	public void Days() throws InterruptedException{
		WebElement day = driver.findElement(By.xpath("//*[contains(@id,'txt-Days')]"));
		day.clear();
		day.sendKeys(dys);
		String typedValue = day.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size <3 ) {
				
				day.sendKeys(Keys.ENTER);
			}

			else {
				System.out.println("No limit is set.");
				day.clear();
				Thread.sleep(3000);
	 			day.sendKeys("50");
				day.sendKeys(Keys.ENTER);
			}
	}
	@Test(priority=7)
	public void BillValue() throws InterruptedException{
		WebElement Value = driver.findElement(By.xpath("//input[@id='txt-BillValue-0']"));
		//Value.clear();
		Value.sendKeys(Keys.BACK_SPACE);
		
		Value.sendKeys(Bvalue);	
		Value.sendKeys(Keys.ENTER);		
		
		String typedValue = Value.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size <11 ) {
				//driver.findElement(By.xpath("//input[@id='txtUrl']")).sendKeys("w.com");
				Value.sendKeys(Keys.ENTER);
			}

			else {
				System.out.println("No limit is set.");
				Value.clear();
				Thread.sleep(3000);
				Value.sendKeys("5000");
				Value.sendKeys(Keys.ENTER);
			}
	}
	@Test(priority=8)
	public void DRCR(){
		WebElement Drcr = driver.findElement(By.xpath("//select[@id='drp-DebitOrCredit-0']"));
		Select Drc = new Select (driver.findElement(By.xpath("//select[@id='drp-DebitOrCredit-0']")));
		Drc.selectByVisibleText(DrCr);
		Drcr.sendKeys(Keys.ENTER);
	}
	@Test(priority=9)
	public void Remrak() throws InterruptedException{
		WebElement Remark = driver.findElement(By.xpath("//input[@id='txt-Remark-0']"));
		Remark.clear();
		Remark.sendKeys(Remarks);
		
		String typedValue = Remark.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size >35 ) {
				//driver.findElement(By.xpath("//input[@id='txtUrl']")).sendKeys("w.com");
				Remark.sendKeys(Keys.ENTER);
			}

			else {
				System.out.println("No limit is set.");
				Remark.clear();
				Thread.sleep(3000);
				Remark.sendKeys("no remarks");
				Remark.sendKeys(Keys.ENTER);
			}
			
	}
	 @Test(priority=10)
	public void Adjustment() throws InterruptedException{
		
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.now();
		 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txt-dDate-1']")));
		 //WebElement dateFy= driver.findElement(By.xpath("//input[@id='txtbillDate']"));  
		 Date.sendKeys(dtf.format(date));
		 
		 Thread.sleep(3000);
		 Date.sendKeys(Keys.ENTER);
		 
		 WebElement bill = driver.findElement(By.xpath("//input[@id='txt-BillNo-1']"));
			bill.clear();
			//bill.sendKeys(Keys.BACK_SPACE);
			bill.sendKeys("ABC1002");
			bill.sendKeys(Keys.ENTER);
			
			WebElement day = driver.findElement(By.xpath("//input[@id='txt-Days-1']"));
			day.clear();
			day.sendKeys("10");
			
			
			WebElement value1 = driver.findElement(By.xpath("//input[@id='txt-BillValue-1']"));
			value1.sendKeys(Keys.ENTER);
			
			WebElement DRc = driver.findElement(By.xpath("//select[@id='drp-DebitOrCredit-1']"));
			DRc.sendKeys(Keys.ENTER);
			
			WebElement adj = driver.findElement(By.xpath("//input[@id='txt-Remark-1']"));
			adj.sendKeys("Adjusted");
	 }
	 @Test(priority=11)
	 public void save(){
		 WebElement sav = driver.findElement(By.xpath("//button[@id='btn-Update']"));
		 sav.sendKeys(Keys.F10);
	 }
	}

