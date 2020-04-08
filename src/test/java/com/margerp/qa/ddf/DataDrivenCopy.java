package com.margerp.qa.ddf;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;





public class DataDrivenCopy {
	public static WebDriver driver;
	WebDriverWait Wait;
	
	//excel code
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Admin.DESKTOP-P28CFV6\\Desktop\\ddf.xlsx");
	String user = 			reader.getCellData("Sheet1", "user", 2);
	String pass = 			reader.getCellData("Sheet1", "password", 2);
	String Company_name = 	reader.getCellData("Sheet1", "company name", 2);
	String Address1 = 		reader.getCellData("Sheet1", "Address1", 2);
	String Address2 = 		reader.getCellData("Sheet1", "Addrees2", 2);
	String Address3 = 		reader.getCellData("Sheet1", "Addree3", 2);
	String state=			reader.getCellData("Sheet1", "state", 2);
	String pincode=			reader.getCellData("Sheet1", "pincode", 2);
	String branchCode = 	reader.getCellData("Sheet1", "branch code", 2);
	String FynYear = 		reader.getCellData("Sheet1", "FinancialYear", 2);	
	String phone =			reader.getCellData("Sheet1", "phone", 2);
	String gst1 =			reader.getCellData("Sheet1", "GST", 2);
	String gst2 =			reader.getCellData("Sheet1", "GST", 3);
	String trade01 =		reader.getCellData("Sheet1", "Trade LIC", 2);
	String trade02 =		reader.getCellData("Sheet1", "Trade LIC", 3);
	String workingstyle=	reader.getCellData("Sheet1", "working style", 2);
	
	//WebDriver COde
	@BeforeSuite
    public void webLaunch() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin.DESKTOP-P28CFV6\\Desktop\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	driver.get("http://172.16.8.17/margwebsite/qa");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
	public void create() throws InterruptedException{
        Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='btn-New']")).click();
		System.out.println("Company name:-" + Company_name);
		driver.findElement(By.xpath("//input[@id='txtcompname']")).sendKeys(Company_name);
		System.out.println("company name given successfully");
		driver.findElement(By.id("txtaddress1")).sendKeys(Address1);
		System.out.println("Address 1 given successfully");
		driver.findElement(By.id("txtaddress2")).sendKeys(Address2);
		System.out.println("Address 2 given successfully");
		driver.findElement(By.id("txtaddress3")).sendKeys(Address3);
		System.out.println("Address 3 given successfully");
	}
	@Test(priority=2)
	public void country() throws InterruptedException{
		//to create country
		/*	WebElement textbox1 = driver.findElement(By.xpath("//*[@id='ddlcountry']"));
			textbox1.clear();
			textbox1.sendKeys(Keys.SPACE);
			Thread.sleep(2000);
				textbox1.sendKeys(Keys.ENTER);
				//creat country
			driver.findElement(By.xpath("//input[@id='txtCountryName']")).sendKeys("vamsikgf");	
			driver.findElement(By.xpath("//input[@id='txtCountryCode']")).sendKeys("~!~@#*|>?345");
			driver.findElement(By.xpath("//input[@id='txtCurrencySymbol']")).sendKeys("!`~*");
			driver.findElement(By.xpath("//input[@id='txtCurrencyString']")).sendKeys("!#^*1234");
			Thread.sleep(2000);
			driver.findElement(By.id("btn-Save")).click();
			*/	
			WebElement textbox = driver.findElement(By.xpath("//*[@id='ddlcountry']"));
			textbox.clear();
			textbox.sendKeys("India");
			Thread.sleep(2000);
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			textbox.sendKeys(Keys.ARROW_DOWN);
			textbox.sendKeys(Keys.ENTER);
	}
	@Test(priority=3)
	public void state() throws InterruptedException{
		WebElement textboxS = driver.findElement(By.xpath(" //input[@id='ddlstate']"));
		textboxS.clear();
		textboxS.sendKeys(state);
		Thread.sleep(2000);
		List<WebElement> allOptionsSt = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		int countSt=allOptionsSt.size();
		System.out.println("No.of Autosuggesion "+countSt);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<countSt;i++){
			String textSt = allOptionsSt.get(i).getText();
			System.out.println(textSt);	
		}
		Thread.sleep(2000);
		textboxS.sendKeys(Keys.ARROW_DOWN);
		textboxS.sendKeys(Keys.ENTER);
	
	}
	@Test(priority=4)
	public void Pincode() {
		driver.findElement(By.xpath("//*[@id='txtpincode']")).sendKeys(pincode);
		
	}
	@Test(priority=5)
	public void branchcode(){
		WebElement textboxbr = driver.findElement(By.xpath("//input[@id='txtbranchcode']"));
	textboxbr.clear();
        textboxbr.sendKeys(branchCode);
        
        String typedValue = textboxbr.getAttribute("value");
        int size = typedValue.length();
        if (size < 12) {
			System.out.println("lenght is less ");
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter Branch code");
		}
        
        
        List<WebElement> eBusType = driver.findElements(By.xpath("//select[@id='ddlbusinesstype']"));
      int countBt= eBusType.size();
      System.out.println("list of Business type"+countBt);
      System.out.println("list of Bt");
      for(int i=0;i<countBt;i++){
    	  String testBt=eBusType.get(i).getText();
    	  System.out.println(testBt);
      }
        Select bt= new Select(driver.findElement(By.id("ddlbusinesstype")));
        bt.selectByVisibleText("Chemist [Pharmacy]");
	}
	@Test(priority=6)
	public void fyn(){
		WebElement dateFy= driver.findElement(By.xpath("//input[@id='txtfromfinancialyr']"));
        dateFy.sendKeys(FynYear);
        dateFy.sendKeys(Keys.ENTER);
	}
	@Test(priority=7)
	public void contactinfo() throws InterruptedException{
		
       WebElement phn =  driver.findElement(By.xpath("//input[@id='txtphone']"));
       phn.sendKeys(phone);
       
       // Get the typed value
       String typedValue = phn.getAttribute("value");
       int size = typedValue.length();
       
		// Assert with expected
		if (size == 12) {
			driver.findElement(By.xpath("//input[@id='txtUrl']")).sendKeys("w.com");
		}

		else {
			System.out.println("No limit is set.");
			phn.clear();
			Thread.sleep(3000);
			phn.sendKeys(phone);
		}
       
        driver.findElement(By.xpath("//input[@id='txtUrl']")).sendKeys("w.com");
        driver.findElement(By.xpath("//input[@id='txtuserEmailid']")).sendKeys("32q33342dsdadgdgssssgssgsssdfsdgsds@gamil.com");
        driver.findElement(By.xpath("//button[@id='addButtonEmail']")).click();
        driver.findElement(By.xpath("//input[@id='extraEmail']")).sendKeys("32q33342dsdadgdgssssgssgsssdfsdgsds@gamil.com");
        driver.findElement(By.xpath("//button[@id='addButtonEmail']")).click();
	}
	@Test(priority=8)
	public void uploadImage() throws AWTException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='btnEdit']")).click();
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection("C:\\Users\\Admin.DESKTOP-P28CFV6\\Desktop\\dek\\123.jpg"); 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		   robot.keyPress(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_V);
		   robot.keyRelease(KeyEvent.VK_V);
		   robot.keyRelease(KeyEvent.VK_CONTROL);
		   Thread.sleep(5000);
		   robot.keyPress(KeyEvent.VK_ENTER);
		   robot.keyRelease(KeyEvent.VK_ENTER);
		   //Delete image
		   // Thread.sleep(2000);
		  // driver.findElement(By.id("btnDelete")).click();
	}
	@Test(priority=9)
	public void Regtype() throws InterruptedException{
		List<WebElement> listregt= driver.findElements(By.xpath("//select[@id='comptype']"));
	     int countregt = listregt.size();
	     System.out.println("List of reg type");
	    for(int i=0;i<countregt;i++)
	    {
	 	   String textregt= listregt.get(i).getText();
	 	   System.out.println(textregt);
	    }
	    Thread.sleep(2000);
	    Select regt= new Select(driver.findElement(By.id("comptype")));
	    regt.selectByVisibleText("Composition");
	}
	@Test(priority=10)
	public void Gst(){
		if(driver.findElement(By.xpath("//*[@id='comptype']/option[1]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='gstnumber']")).sendKeys(gst1);
			 WebElement datgst= driver.findElement(By.xpath("//input[@id='txtregdate']"));
		        datgst.sendKeys(gst2);
		}
		else if(driver.findElement(By.xpath("//*[@id='comptype']/option[2]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='gstnumber']")).sendKeys(gst1);
	        WebElement datgst= driver.findElement(By.xpath("//input[@id='txtregdate']"));
	        datgst.sendKeys(gst2);
		}
		else if (driver.findElement(By.xpath("//*[@id='comptype']/option[3]")).isSelected()){
			driver.findElement(By.xpath("//select[@id='ddltaxstruc']"));
		}
	}
	@Test(priority=11)
	public void TaxStructure(){
		Select TXTST = new Select(driver.findElement(By.id("ddltaxstruc")));
		TXTST.selectByVisibleText("Product wise");
		driver.findElement(By.id("btn-Switch Tab")).click();
	}
	@Test(priority=12)
	public void TradeLIC(){
		if (driver.findElement(By.xpath("//*[@id='ddlbusinesstype']/option[2]")).isSelected()){
		WebElement trade =  driver.findElement(By.xpath("//input[@id='txtdlno']"));
		trade.sendKeys(trade01);
	        WebElement datst= driver.findElement(By.xpath("//input[@id='dlexpdate']"));
	        datst.sendKeys(trade02);
	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        driver.findElement(By.id("btn-Switch Tab")).click();
		}
		else if(driver.findElement(By.xpath("//*[@id='ddlbusinesstype']/option[3]")).isSelected()){
			WebElement trade1 =  driver.findElement(By.xpath("//*[@id='txtdlno']"));
			trade1.sendKeys(trade01);
			WebElement datst= driver.findElement(By.xpath("//input[@id='dlexpdate']"));
	        datst.sendKeys(trade02);
	        driver.findElement(By.id("btn-Switch Tab")).click();
		}
		else if(driver.findElement(By.xpath("//*[@id='ddlbusinesstype']/option[4]")).isSelected()){
			WebElement trade2 =  driver.findElement(By.xpath("//*[@id='txtdlno']"));
			trade2.sendKeys(trade01);
			WebElement datst= driver.findElement(By.xpath("//input[@id='dlexpdate']"));
	        datst.sendKeys(trade02);
	        driver.findElement(By.id("btn-Switch Tab")).click();
	}
		
		}
	@Test(priority=13)
	public void other() throws InterruptedException{
//Date Type
	       Thread.sleep(2000);
	       Select dt= new Select(driver.findElement(By.xpath("//*[@id='ddldatatype']")));
	       dt.selectByVisibleText("English");
	       
	}
	@Test(priority=14)
	public void valution() throws InterruptedException{
		List<WebElement> listvl= driver.findElements(By.xpath("//*[@id='txtvaluation']"));
	       int countvl = listvl.size();
	       System.out.println("List of valuetion Type");
	      for(int i=0;i<countvl;i++)
	      {
	   	   String textvl= listvl.get(i).getText();
	   	   System.out.println(textvl);
	      }
	      Thread.sleep(2000);
	      Select vl= new Select(driver.findElement(By.id("txtvaluation")));
	      vl.selectByIndex(2);
	    
	}
	@Test(priority=15)
	public void workingstl() throws InterruptedException{
		 List<WebElement> listws= driver.findElements(By.xpath("//select[@id='ddlworkinstyle']"));
	      int countws = listws.size();
	      System.out.println("List of work style");
	     for(int i=0;i<countws;i++)
	     {
	  	   String textws= listws.get(i).getText();
	  	   System.out.println(textws);
	     }
	     Thread.sleep(2000);
	     Select ws= new Select(driver.findElement(By.id("ddlworkinstyle")));
	     ws.selectByVisibleText("Secondary (Batch/Mrp/Size)");
	      //juridction  
	     driver.findElement(By.xpath("//input[@id='txtJurisdiction']")).sendKeys(workingstyle);
	}
	
	/*@Test(priority=16)
	public void selection() throws InterruptedException{
		List<WebElement> listSel= driver.findElements(By.xpath("//select[@id='ddlselecttion']"));
	    int countSel = listSel.size();
	    System.out.println("List of selection type");
	   for(int i=0;i<countSel;i++)
	   {
		   String textsel= listSel.get(i).getText();
		   System.out.println(textsel);
	   }
	   Thread.sleep(2000);
	   Select sel= new Select(driver.findElement(By.id("ddlselecttion")));
	  sel.selectByVisibleText("Manual");
	}*/
	@Test(priority=16)
	public void Save() throws InterruptedException{
		/*List<WebElement> listTs= driver.findElements(By.xpath("//select[@id='ddltaxstruc']"));
		  int countTs = listTs.size();
		  System.out.println("List of selection type");
		 for(int i=0;i<countTs;i++)
		 {
			   String textTs= listTs.get(i).getText();
			   System.out.println(textTs);
		 }
		 Thread.sleep(2000);
		 Select Ts= new Select(driver.findElement(By.id("ddltaxstruc")));
		  Ts.selectByVisibleText("Bill wise");*/
		       
		   driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	}

	public static void main(String[] args) throws Exception {
		DataDrivenCopy nm = new DataDrivenCopy();
		nm.webLaunch();
		nm.login();
		nm.create();
		nm.country();
		nm.state();
		nm.Pincode();
		nm.branchcode();
		nm.fyn();
		nm.contactinfo();
		nm.uploadImage();
		nm.Gst();
		nm.TradeLIC();
		nm.other();
		nm.valution();
		nm.workingstl();
		nm.Regtype();
		//nm.selection();
		nm.Save();
		
	}

}
