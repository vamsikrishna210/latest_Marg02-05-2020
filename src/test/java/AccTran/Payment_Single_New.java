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

public class Payment_Single_New {
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
	String Amount1  = 		reader.getCellData("Reciept", "Amount_1", 2);
	String mode        =	reader.getCellData("payment", "Rec_Mode", 2);
	String Crmt        = 	reader.getCellData("payment", "Cr_Amount", 2);
	String shrtexes    =	reader.getCellData("payment", "Sh_Exes", 2);
	String RefNo       =	reader.getCellData("payment", "Ref_No", 2);
	String Drmt        = 	reader.getCellData("payment", "Dr_Amount", 2);
	String ledser2     =	reader.getCellData("payment", "Ledger_2", 2);
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
    @Test(priority=3)
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
    @Test(priority=4)
    public void PayMode() throws InterruptedException{
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
    @Test(priority=5)
    public void insnt() throws InterruptedException{
    	//if(!driver.findElements(By.xpath("//input[@id='txt-insno-0']")).isEmpty()){
    		WebElement eInstNo=driver.findElement(By.xpath("//input[@id='txt-insno-0']"));
    		System.out.println("pk test insno"+eInstNo);
    		boolean isDisplayed = eInstNo.isDisplayed();
    	   //  String inst = eInstNo.getText();
    		//eInstNo.sendKeys(Keys.BACK_SPACE);
    		//if(eInstNo.getSize().equals(inst)){
    		if(isDisplayed){
    			
    			System.out.println("checked condition successfully !");
    			Thread.sleep(3000);
    			eInstNo.sendKeys(Keys.ENTER);
    		
    			
    		}
    		else{
    		eInstNo.sendKeys(instno);
    		eInstNo.sendKeys(Keys.ENTER);
    	    } }
    //}
    @Test(priority=6)
    public void Amount(){
    	WebElement Amt1 = driver.findElement(By.xpath("//*[contains(@id,'txt-drAmount-0')]"));
    	 if(Amt1.getSize().equals(1)){
    		Amt1.sendKeys(Keys.ENTER);
    	}
    	else{
    		Amt1.sendKeys(Keys.BACK_SPACE);
    		Amt1.sendKeys(Amount1);
    		Amt1.sendKeys(Keys.ENTER);
    	}
		
    }
    @Test(priority=7)
    public void short1(){
    	WebElement shrt = driver.findElement(By.xpath("//input[@id='txt-crAmount-0']"));
    	if(shrt.getSize().equals(1)){
    		shrt.sendKeys(Keys.ENTER);
    	}
    	else{
    		shrt.sendKeys(Keys.BACK_SPACE);
    		shrt.sendKeys(shrtexes);
    		shrt.sendKeys(Keys.ENTER);
    	}
    }
    @Test(priority=8)
    public void adj(){
    	Select adjamt = new Select(driver.findElement(By.xpath("//select[@id='drpRefType']")));
    	adjamt.selectByVisibleText("Advance");
    	// Adjust
    	if(driver.findElement(By.xpath("//*[@id='drpRefType']/option[1]")).isSelected()){
    		
    		
    		 String checkboxes = "//*[@id='billAdjustmentGrid']/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]";
 			List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
 			for (WebElement AllCheck : elementToClick) {
 			    AllCheck.click();
 			}
    	}
    	
    	//else if(driver.findElement(By.xpath("//*[@id='drpRefType']/option[2]")).isSelected()){
    		
    		
    		
    	}
    }
//}
















