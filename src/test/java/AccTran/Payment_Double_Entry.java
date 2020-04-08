package AccTran;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Payment_Double_Entry {
	WebDriver driver;
	WebDriverWait Wait;
   
    public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
    
    String user        =    reader.getCellData("payment", "user", 2);
	String pass		   = 	reader.getCellData("payment", "password", 2);
	String Companyname = 	reader.getCellData("payment", "Company_name", 2);
	String ledgername  = 	reader.getCellData("payment", "ledger_name", 2);
	String vono		   = 	reader.getCellData("payment", "Vocher_No", 2);
	String ledser	   = 	reader.getCellData("payment", "Led_Sel", 2);
	String instno      = 	reader.getCellData("payment", "Inst_No", 2);
	String Amount1     =    reader.getCellData("Reciept", "Amount_1", 2);
	String invc        = 	reader.getCellData("Reciept", "invoice_No", 2);
	String mode        =	reader.getCellData("payment", "Rec_Mode", 2);
	String Crmt        = 	reader.getCellData("payment", "Cr_Amount", 2);
	String shrtexes    =	reader.getCellData("payment", "Sh_Exes", 2);
	String RefNo       =	reader.getCellData("payment", "Ref_No", 2);
	String Drmt        = 	reader.getCellData("payment", "Dr_Amount", 2);
	String ledser2     =	reader.getCellData("payment", "Ledger_2", 2);
	String crd         =	reader.getCellData("payment", "Cr_Dr", 2);
	
	/*String branchCode = 	reader.getCellData("Reciept", "branch code", 2);
		
	
	String gst1 =			reader.getCellData("Reciept", "GST", 2);
	String gst2 =			reader.getCellData("Reciept", "GST", 3);
	String trade01 =		reader.getCellData("Reciept", "Trade LIC", 2);
	String trade02 =		reader.getCellData("Reciept", "Trade LIC", 3);
	String workingstyle=	reader.getCellData("Reciept", "working style", 2);*/
    
    @BeforeSuite
    // web lauch    
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://172.16.8.17/margwebsite/vamsi");
		driver.manage().window().maximize();
    
    	/*TestBase.initialization();
    	Tb = new TestBase(); */
		
		
	}
    @BeforeTest
	//login to app
	public void Login() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
		driver.findElement(By.id("userid")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("btnSave")).click();
		
    	//login_Credentials();
	}
    @Test(priority=1)
	// search and select company
	public void searchCompany() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		 WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
		 
		// WebElement textbox = driver.findElement(By.xpath("//*[@id='SearchBox']"));
			//textbox.clear();
		 Thread.sleep(3000);
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
			WebElement menu = driver.findElement(By.linkText("Accounting Trans."));
			action.moveToElement(menu).perform();
		    menu.sendKeys(Keys.ENTER);
			//menu.click();
			
			Thread.sleep(2000);
			WebElement submenu1 = driver.findElement(By.linkText("Payment"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			//submenu1.click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Double Entry")).click();
			
			Thread.sleep(5000);
	 }
 //   @Test(priority=2)
   	// control room setting  addEffset
   	public void setting() throws InterruptedException {
   		 
   		 WebElement ele = driver.findElement(By.xpath("//a[@id='aControlRoomSetting']//img"));
   			JavascriptExecutor executor = (JavascriptExecutor)driver;
   			executor.executeScript("arguments[0].click();", ele);
   		 
   		 
   		
   	  /* WebElement	eSetting=driver.findElement(By.xpath("//a[@id='aControlRoomSetting']//img"));
   		eSetting.click();*/
   		Thread.sleep(5000);
   	    Select vDrp=new Select(driver.findElement(By.xpath("//select[@id='code']")));
   	    vDrp.selectByIndex(1);
   	    driver.findElement(By.xpath("//button[@class='close itemcontrolClose']")).click();
   	    }
    @Test(priority=2)
    public void createpayDte() throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.now();
		 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'txtEntryDate')]")));
		 
		 Date.sendKeys(dtf.format(date));
		 System.out.println(dtf.format(date));
		 Thread.sleep(3000);
		 Date.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
    }
    @Test(priority=3)
    public void PayMode() throws InterruptedException{
    	WebElement voch = driver.findElement(By.xpath("//*[contains(@id,'txtVoucherNo')]"));
    	System.out.println(voch);
    	if(voch.isDisplayed()){
    		voch.sendKeys(Keys.ENTER);
    	}
    	else{
    		voch.sendKeys(vono);
    	}

}
    @Test(priority=4)
    public void Serled() throws InterruptedException{
    	Select led = new Select(driver.findElement(By.xpath("//select[@id='mrgSearchBox']")));
    	led.selectByVisibleText(ledser);
    	 // Name
        if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[2]")).isSelected()){
        	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
 			//textbox.clear();
 		    Thread.sleep(5000);
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
 			
        }
        //Mobile
        else  if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[3]")).isSelected()){
       	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(5000);
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
			
    }
      //DL No
        else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[4]")).isSelected()){
       	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(5000);
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
			

}
     // Adress
        else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[5]")).isSelected()){
       	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(5000);
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
			
        }
        // GSTIN
        else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[6]")).isSelected()){
       	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(5000);
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
    
    }
  
    	
    }
    @Test(priority=5)
    public void Dbt(){
    	WebElement dbt1 = driver.findElement(By.xpath("//input[@id='txt-drAmount-0']"));
    	dbt1.sendKeys(Amount1);
    	dbt1.sendKeys(Keys.ENTER);
    }
    
    @Test(priority=6)
    public void Adjwindow(){
    	if(driver.findElement(By.xpath("//*[@id='drpRefType']/option[1]")).isDisplayed()){
    		//WebDriverWait wait = new WebDriverWait(driver, 20);
   		 //WebElement Srchinvc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
   		/* WebElement Srchinvc = driver.findElement(By.xpath("//input[@id='SearchBox']"));
    	 Srchinvc.sendKeys(invc);*/
   		
   		 String checkboxes = "//*[@id='billAdjustmentGrid']/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]";
			List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
			for (WebElement AllCheck : elementToClick) {
			    AllCheck.click();
			    
    	}
			WebElement Adjamnt = driver.findElement(By.xpath("//input[@id='txt-adjustmentAmount-0']"));
			Adjamnt.sendKeys(Amount1);
			Adjamnt.sendKeys(Keys.ENTER);
			
    	
    	
    }
    	/*else if(driver.findElement(By.xpath("//*[@id='drpRefType']/option[1]")).isDisplayed()){
    		WebElement Refno = driver.findElement(By.xpath("//input[@id='txt-cus_invoiceNo-0']"));
    		Refno.sendKeys(RefNo);
    		Refno.sendKeys(Keys.ENTER);
    	}*/
}
    @Test(priority=7)
    public void CRDR(){
    	Select cdr = new Select(driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-1']")));
    	cdr.selectByVisibleText(crd);
    	WebElement crd1 = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-1']"));
    	crd1.sendKeys(Keys.ENTER);
    }
    @Test(priority=8)
    public void amnt2() throws InterruptedException{
    	Thread.sleep(2000);
    	WebElement Cramt = driver.findElement(By.xpath("//input[@id='txt-crAmount-1']"));
    	if(Cramt.isDisplayed()){
    		
    		Cramt.sendKeys(Keys.ENTER);
    	}
    	else{
    		Cramt.sendKeys(Amount1);
    		Cramt.sendKeys(Keys.ENTER);
    	}
    }
    @Test(priority=9)
    public void save(){
    	WebElement sav = driver.findElement(By.xpath("//*[contains(@id,'save')]"));
    	//sav.click();
    	//sav.sendKeys(Keys.F10);
    	sav.sendKeys(Keys.END);
    	 
    }
    }

















