package AccTran;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

import com.marg.qa.TestBase.TestBase;
import com.margerp.qa.xls_Reader.Xls_Reader;
//import com.marg.qa.TestBase.TestBase;


public class Reciept_Double_Entry extends TestBase{
	//public TestBase Tb;
	
	/*public Reciept_Double_Entry (){
		super();
		
	}*/
	WebDriver driver;
	WebDriverWait Wait;
   
    public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
    
    String user        =    reader.getCellData("Reciept", "user", 2);
	String pass		   = 	reader.getCellData("Reciept", "password", 2);
	String Companyname = 	reader.getCellData("Reciept", "Company_name", 2);
	String ledgername  = 	reader.getCellData("Reciept", "ledger_name", 2);
	String vono		   = 	reader.getCellData("Reciept", "Vocher_No", 2);
	String ledser	   = 	reader.getCellData("Reciept", "Led_Sel", 2);
	String instno      = 	reader.getCellData("Reciept", "Inst_No", 2);
	String mode        =	reader.getCellData("Reciept", "Rec_Mode", 2);
	String Crmt        = 	reader.getCellData("Reciept", "Cr_Amount", 2);
	String shrtexes    =	reader.getCellData("Reciept", "Sh_Exes", 2);
	String RefNo       =	reader.getCellData("Reciept", "Ref_No", 2);
	String Drmt        = 	reader.getCellData("Reciept", "Dr_Amount", 2);
	String ledser2     =	reader.getCellData("Reciept", "Ledger_2", 2);
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
			
			WebElement submenu1 = driver.findElement(By.linkText("Receipt"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Double Entry")).click();
			
			Thread.sleep(5000);
	 }
    @Test(priority=2)
    public void DobDate() throws InterruptedException{
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
	public void vocher () throws InterruptedException{
    	WebElement vocherno = driver.findElement(By.xpath("//*[contains(@id,'txtVoucherNo')]"));
    	if(vocherno.getSize().equals(1)){
    		vocherno.sendKeys(Keys.ENTER);
    		
    	}
    	else{
    		vocherno.sendKeys(vono);
    		vocherno.sendKeys(Keys.ENTER);
    	}
    }
    @Test(priority=4)
    public void LedSelection() throws InterruptedException{
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
    public void CrAmount() throws InterruptedException{
    	WebElement cramt = driver.findElement(By.xpath("//input[@id='txt-crAmount-0']"));
    	//cramt.sendKeys(Keys.BACK_SPACE);
    	Thread.sleep(2000);
    	cramt.sendKeys(Crmt);
    	Thread.sleep(2000);
    	cramt.sendKeys(Keys.ENTER);
    }
    @Test(priority=6)
    public void BillAdjust() throws InterruptedException{
    	
    	Select reftype = new Select(driver.findElement(By.xpath("//select[@id='drpRefType']"))) ;
    	reftype.selectByIndex(1);
    	
    	
    	if(driver.findElement(By.xpath("//*[@id='drpRefType']/option[1]")).isSelected()){
    		
    		String checkboxes1 = "//div[@class='ag-body-container ag-layout-normal']//div[1]//div[1]//span[1]//span[1]//span[2]";
			List<WebElement> elementToClick1 = driver.findElements(By.xpath(checkboxes1));
			for (WebElement AllCheck1 : elementToClick1) {
			    AllCheck1.click();
			}
			WebElement esc1 = driver.findElement(By.xpath("//button[@id='btn-Close']"));
	      		esc1.click();
			Thread.sleep(5000);
    		
    	}
    	else if(driver.findElement(By.xpath("//*[@id='drpRefType']/option[2]")).isSelected()){
    		WebElement ref = driver.findElement(By.xpath("//input[@id='txt-cus_invoiceNo-0']"));
    		ref.sendKeys(RefNo);
    		ref.sendKeys(Keys.ENTER);
    		Thread.sleep(3000);
    		WebElement AdjAmount = driver.findElement(By.xpath("//input[@id='txt-adjustmentAmount-0']"));
    		AdjAmount.sendKeys(Keys.ENTER);
    		
    	}
    	
    }
    @Test(priority=7)
    public void Drselection() throws InterruptedException{
    	
    	Select drs = new Select(driver.findElement(By.xpath("//*[@id='drp-creditOrDebit-1']")));
    	drs.selectByVisibleText(crd);
    	Thread.sleep(3000);
    	WebElement dr = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-1']"));
     	dr.sendKeys(Keys.ENTER);
    	
    	if(driver.findElement(By.xpath("//*[@id='drp-creditOrDebit-1']/option[1]")).isSelected()){
    		
         	/*WebElement dr = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-1']"));
         	dr.sendKeys(Keys.ENTER);
  	   */
    	    WebElement Ammt = driver.findElement(By.xpath("//input[@id='txt-drAmount-1']"));
    	    Ammt.sendKeys(Drmt);
    	    Ammt.sendKeys(Keys.ENTER);
    }
    	else if(driver.findElement(By.xpath("//*[@id='drp-creditOrDebit-1']/option[2]")).isSelected()){
    		Thread.sleep(5000);
    		WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			//textbox.clear();   
		    Thread.sleep(5000);
			textbox.sendKeys(ledser2);
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
}















