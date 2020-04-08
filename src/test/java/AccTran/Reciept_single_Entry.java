package AccTran;

//import java.util.Iterator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
//import java.util.Set;
import java.util.concurrent.TimeUnit;




















//import org.openqa.selenium.Alert;
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

import com.marg.qa.TestBase.TestBase;
import com.margerp.qa.xls_Reader.Xls_Reader;


public class Reciept_single_Entry extends TestBase {
	WebDriver driver;
	WebDriverWait Wait;
   
    public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
    
    String user = 			reader.getCellData("Reciept", "user", 2);
	String pass = 			reader.getCellData("Reciept", "password", 2);
	String Companyname = 	reader.getCellData("Reciept", "Company_name", 2);
	String ledgername = 	reader.getCellData("Reciept", "ledger_name", 2);
	String instno = 		reader.getCellData("Reciept", "Inst_No", 2);
	String mode =			reader.getCellData("Reciept", "Rec_Mode", 2);
	String Amount1  = 		reader.getCellData("Reciept", "Amount_1", 2);
	String shrtexes=		reader.getCellData("Reciept", "Sh_Exes", 2);
	String RefNo =			reader.getCellData("Reciept", "Ref_No", 2);
	/*String branchCode = 	reader.getCellData("Reciept", "branch code", 2);
	String FynYear = 		reader.getCellData("Reciept", "FinancialYear", 2);	
	String phone =			reader.getCellData("Reciept", "phone", 2);
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
		driver.get("http://172.16.8.17/margwebsite/QA");
		driver.manage().window().maximize();
		
		
	}
    @BeforeTest
	//login to app
	public void Login() {
		
		driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
		driver.findElement(By.id("userid")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("btnSave")).click();
		
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
			
			WebElement submenu1 = driver.findElement(By.linkText("Receipt"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Single Entry")).click();
			
			Thread.sleep(5000);
	 }
   
	 @Test(priority=2)
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
	// create voucher
	 @Test(priority=3)
	public void createVoucherEntry() throws InterruptedException {
		
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.now();
		 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'txtEntryDate')]")));
		 
		 Date.sendKeys(dtf.format(date));
		 System.out.println(dtf.format(date));
		 Thread.sleep(3000);
		 Date.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		WebElement eReceiptMode= driver.findElement(By.xpath("//*[contains(@id,'paymentMode')]"));
		Select rMode = new Select(eReceiptMode);
		rMode.selectByVisibleText("HDFC");
		//rMode.selectByVisibleText(mode);
		eReceiptMode.sendKeys(Keys.ENTER);
		
		if(!driver.findElements(By.xpath("//*[contains(@id,'txt-voucherNo')]")).isEmpty()){
			WebElement eInstNo=driver.findElement(By.xpath("//*[contains(@id,'txt-voucherNo')]"));
			
			eInstNo.sendKeys(Keys.ENTER);
		}
		
			WebElement eSearchAccount=driver.findElement(By.xpath("//input[@id='SearchBox']"));
			Thread.sleep(2000);
			eSearchAccount.sendKeys(ledgername);
			eSearchAccount.sendKeys(Keys.ENTER);
			//synAppWithSelenium();
			
	 }
	    @Test(priority=4)
		public void intno(){	
	    if(!driver.findElements(By.xpath("//*[contains(@id,'txt-insno-0')]")).isEmpty()){
		WebElement eInstNo=driver.findElement(By.xpath("//*[contains(@id,'txt-insno-0')]"));
		//eInstNo.sendKeys(Keys.BACK_SPACE);
		eInstNo.sendKeys(instno);
		eInstNo.sendKeys(Keys.ENTER);
	    }
	    }
	    @Test(priority=5)
		public void Amount1(){
			WebElement Amt1 = driver.findElement(By.xpath("//*[contains(@id,'txt-drAmount-0')]"));
			//Amt1.sendKeys(Keys.BACK_SPACE);
			Amt1.sendKeys(Amount1);
			Amt1.sendKeys(Keys.ENTER);
	
	 }
	    @Test(priority=6)
	    public void shortex() throws InterruptedException{
	    	WebElement Excess = driver.findElement(By.xpath("//input[@id='txt-crAmount-0']"));
	    	Excess.sendKeys(Keys.BACK_SPACE);
	    	Excess.sendKeys(shrtexes);
	    	Thread.sleep(5000);
	    	Excess.sendKeys(Keys.ENTER);
	    }
		@Test(priority=7)
		
		public void mode() throws InterruptedException{
		// WebElement ref = driver.findElement(By.xpath("//select[@id='drpRefType']"))	;
			
		if(!driver.findElements(By.xpath("//select[@id='drpRefType']")).isEmpty())	{
		Select eRefTyp = new Select(driver.findElement(By.xpath("//select[@id='drpRefType']")));
		eRefTyp.selectByIndex(1);
		Thread.sleep(5000);
		
		if(driver.findElement(By.xpath("//*[@id='drpRefType']/option[1]")).isSelected())
		{	
			List<WebElement> allchkbox = driver.findElements(By.xpath("//ag-grid-angular[@id='billAdjustmentGrid']//div[@class='ag-body-viewport ag-layout-normal']"));
		
			int count = allchkbox.size();
		System.out.println("Total no. of checkboxes: "+count);
		
		//select all check boxes from top to bottom
		
		for(int i=0;i<count;i++)
		{
		WebElement chkbox = allchkbox.get(i);
		chkbox.click();
		
		}
				
		WebElement eSearchBoxBill=driver.findElement(By.xpath("//*[@id='SearchBox']"));
		
		//eSearchBoxBill.sendKeys(Keys.ENTER);
		
		eSearchBoxBill.sendKeys(Keys.ENTER);
		
		//de select all checkboxes from bottom to top
		//for(int i=count-1;i>=0;i--)
		//{
        //allchkbox.get(i).click();
		//}
		
		//driver.findElement(By.xpath("//div[@class='pageButton text-right w-100']//button[@id='btn-Save']")).click();
		}
		else if (driver.findElement(By.xpath("//*[@id='drpRefType']/option[2]")).isSelected()){
			
			WebElement Ref1 = driver.findElement(By.xpath("//input[@id='txt-cus_invoiceNo-0']"));
			        Thread.sleep(2000);
					Ref1.sendKeys(RefNo);
					Ref1.sendKeys(Keys.ENTER);
					Thread.sleep(5000);
			WebElement adj = driver.findElement(By.xpath("//input[@id='txt-adjustmentAmount-0']"));
			adj.sendKeys(Keys.ENTER);
			
		}
		}
		//driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	}
	@Test(priority=8)
		
	public void Save(){
		
		WebElement save1 = driver.findElement(By.xpath("//*[contains(@id,'btn')]"));
		save1.sendKeys(Keys.F10);
		//save1.click();
	}
	
	
		 
		
	
    
}


