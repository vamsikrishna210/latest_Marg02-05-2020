package Inventory_Transaction;

//import static org.testng.Assert.assertEquals;

//import java.sql.Driver;
//import java.sql.Driver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;






//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;



//Chemist

public class So_New {
	WebDriver driver;
	WebDriverWait Wait;
	
	//String[] invalidChars= {"#", "!", "$", "@", "%", "^","~"};
	
	  String specialCharacters="~!^";
	
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
	String Rate        =    reader.getCellData("Sale", "Rate_1", 2);
	String Message     =	reader.getCellData("Sale", "conformation_msg", 2);
	String Discount    =	reader.getCellData("Sale", "Disc_1", 2);
	String Free        =	reader.getCellData("Sale", "Free_Qty", 2);
	

	
	@BeforeSuite
	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/QA");
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
		 
		//WebElement textbox = driver.findElement(By.xpath("//*[@id='SearchBox']"));
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
			
			WebElement submenu1 = driver.findElement(By.linkText("Sales Order"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("New")).click();
	 }
	@Test(priority=2)
	 // Date
	 public void createSo() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.now();
		// WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control mydate ng-valid ng-touched ng-dirty'and@id='txtbillDate']")));
		 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'txtbillDate')]")));
		 //WebElement dateFy= driver.findElement(By.xpath("//input[@id='txtbillDate']"));  
		 Date.sendKeys(dtf.format(date));
		 System.out.println(dtf.format(date));
		 Thread.sleep(3000);
		 Date.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		if(driver.findElement(By.xpath("//*[@id='txtaskpartyinretailbilling']/option[1]")).isSelected()){
			WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
			orderno.click();
			//orderno.clear();
			//orderno.sendKeys("001");
			//orderno.sendKeys(Keys.ENTER);
		}
		else if(driver.findElement(By.xpath("//*[@id='txtaskpartyinretailbilling']/option[2]")).isSelected()){
			WebElement led =driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]"));
		    led.sendKeys(Keys.BACK_SPACE);
		    //led.sendKeys(Keys.SPACE);
		   
		    WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
			textbox.click();
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
		else if(driver.findElement(By.xpath("//*[@id='txtaskpartyinretailbilling']/option[3]")).isSelected()){
			WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
			orderno.click();
			//orderno.clear();
			//orderno.sendKeys("001");
			//orderno.sendKeys(Keys.ENTER);
		}
		
		
		 /*if(driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]")).isDisplayed());{
			 WebElement led =driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]"));
			    led.sendKeys(Keys.BACK_SPACE);
			    led.sendKeys(Keys.SPACE);
		 }*/

	 }
	@Test(priority=3)
	 // Ledger selection 
	 public void SlLedger () throws InterruptedException{
		    
			if(driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]")).isDisplayed());{
				WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
				//orderno.clear();
				orderno.sendKeys(Keys.ENTER);
				
			}
			
	 }
	@Test(priority=4)
	// order no
	public void orderNo(){
		WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
		//orderno.clear();
		//orderno.sendKeys(OrderNo);
		orderno.sendKeys(Keys.ENTER);
		
		if(driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]")).isDisplayed());{
			WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
			PId.clear();
			PId.sendKeys(Keys.ENTER);
			
		}
	}
	//patient selection
	@Test(priority=5)
	public void PatentId() throws InterruptedException{
		WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
		PId.clear();
		PId.sendKeys(PatientId);
		//PId.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		//prescription
		if(!driver.findElements(By.xpath("//input[@id='SearchBox']")).isEmpty()){
	    WebElement Ptextbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
		Ptextbox.clear();
	    Thread.sleep(2000);
		Ptextbox.sendKeys(Prescription);
		Thread.sleep(2000);
		Ptextbox.sendKeys(Keys.ENTER);
		
		}
		else {
			PId.sendKeys(Keys.ENTER);
		}
		   
		/*WebElement  DId = driver.findElement(By.xpath("//*[contains(@id,'txtdrmobile')]"));
		//if(driver.findElement(By.xpath("//*[contains(@id,'txtdrmobile')]")).isDisplayed());{
			
			//DId .clear();
			//DId .sendKeys(Keys.ENTER);	
		//}
		
		if(driver.findElement(By.xpath("//*[contains(@id,'txtdrmobile')]")).isDisplayed()){
			DId .sendKeys(Keys.ENTER);
			
		}
		//only 2
		else{
			DId.clear();
			DId.sendKeys(DoctorId);
			DId.sendKeys(Keys.ENTER);
			WebElement Drd= driver.findElement(By.xpath("//*[contains(@id,'txtdrname')]"));
			Drd.sendKeys(Keys.ENTER);
		}
	
		*/
	}
	@Test(priority=6)
	public void DocId() throws InterruptedException{
		
		WebElement DId = driver.findElement(By.xpath("//*[contains(@id,'txtdrmobile')]"));
		if (DId.isDisplayed()) {
			DId.clear();
			DId.sendKeys(DoctorId);
			DId.sendKeys(Keys.ENTER);
			WebElement Drd = driver.findElement(By.xpath("//*[contains(@id,'txtdrname')]"));
			Drd.sendKeys(Keys.ENTER);

		} else {
			// WebElement DId=
			// driver.findElement(By.xpath("//*[contains(@id,'txtdrmobile')]"));
			DId.clear();
			DId.sendKeys(DoctorId);
			DId.sendKeys(Keys.ENTER);
			WebElement Drd = driver.findElement(By.xpath("//*[contains(@id,'txtdrname')]"));
			Drd.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		/*WebElement DId= driver.findElement(By.xpath("//*[contains(@id,'txtdrmobile')]"));
		DId.clear();
		DId.sendKeys(DoctorId);
		DId.sendKeys(Keys.ENTER);
		WebElement Drd= driver.findElement(By.xpath("//*[contains(@id,'txtdrname')]"));
		Drd.sendKeys(Keys.ENTER);
	*/
		if(!driver.findElements(By.xpath("//input[@id='tempBillDiscountPercentage']")).isEmpty()){
			WebElement disc = driver.findElement(By.xpath("//input[@id='tempBillDiscountPercentage']"));
			disc.sendKeys(Keys.ENTER);
		}
		}
		
	}
	 
	
	@Test(priority=7)
	public void saletype() throws InterruptedException{
		//WebElement sale = driver.findElement(By.xpath("//*[contains(@id,'txtSaleType')]"));
		if(driver.findElement(By.xpath("//*[@id='txtisSaleTypeForBilling']/option[1]")).isSelected()){
			/*WebElement DId= driver.findElement(By.xpath("//*[contains(@id,'txtdrmobile')]"));
			DId.sendKeys(Keys.ENTER);	*/
			WebElement product = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-0']"));
			product.sendKeys(Keys.SPACE);
		}
		else if(driver.findElement(By.xpath("//*[@id='txtisSaleTypeForBilling']/option[2]")).isSelected()){
			WebElement sale = driver.findElement(By.xpath("//*[contains(@id,'txtSaleType')]"));
			Thread.sleep(3000);
			//sale.sendKeys("Itemwise");
			sale.sendKeys(Keys.ENTER);
			sale.sendKeys(Keys.ENTER);
		}
		if(!driver.findElements(By.xpath("//input[@id='tempBillDiscountPercentage']")).isEmpty()){
			WebElement billper = driver.findElement(By.xpath("//input[@id='tempBillDiscountPercentage']"));
			billper.sendKeys(Keys.ENTER);
		}
	}
	
	// Item Selection 
	@Test(priority=8)
	public void product(){
		if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-0']")).isEmpty()){
			WebElement ItemCode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-0']"));
			ItemCode.sendKeys(Keys.BACK_SPACE);
			ItemCode.sendKeys(ItemCode1);
			ItemCode.sendKeys(Keys.ENTER);
			
			WebElement prov = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-0']"));
			prov.clear();
			
		}
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
		Seritem.sendKeys(Item1);
		Seritem.sendKeys(Keys.ENTER);
		
	}
	// Qty selection
	@Test(priority=9)
	public void Qty (){
		if(!driver.findElements(By.xpath("//input[@id='txt-quantity-0']")).isEmpty()){
			WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-0']"));
			Qty.sendKeys(Keys.BACK_SPACE);
			Qty.sendKeys(Qty1);
			Qty.sendKeys(Keys.ENTER);
			
		}
		//only 2
		else{
			WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-0']"));
			Qty1.sendKeys(Keys.BACK_SPACE);
			Qty1.sendKeys(Unit2);
			Qty1.sendKeys(Keys.ENTER);
			
			WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-0')]"));
			//pcs.sendKeys(Keys.BACK_SPACE);
			pcs.sendKeys(Unit1);
			pcs.sendKeys(Keys.ENTER);
		}
		if(!driver.findElements(By.xpath("//input[@id='txt-free-0']")).isEmpty()){
			WebElement free = driver.findElement(By.xpath("//input[@id='txt-free-0']"));
			free.sendKeys(Keys.BACK_SPACE);
			free.sendKeys(Free);
			free.sendKeys(Keys.ENTER);
			
		}
	}
	//Rate selection
	@Test (priority=10)
    public void Rate() throws InterruptedException{
		
		WebElement rate = driver.findElement(By.xpath("//input[@id='txt-salePurchaseRate-0']"));
		String Ra = rate.getText();
		//if(!driver.findElements(By.xpath("//input[@id='txt-salePurchaseRate-0']")).isEmpty()){
		
	//WebElement rate = driver.findElement(By.xpath("//input[@id='txt-salePurchaseRate-0']"));
		if(rate.equals(Ra)){
		//if(rate.isEnabled()){
	     rate.sendKeys(Keys.ENTER);
	     
	     //Rate Modif
	     
	     WebElement Ratmod = driver.findElement(By.xpath("//button[@id='dontStore']"));
	     Ratmod.click();
	           /*if(rate.getSize().equals(null)){
	    	      driver.findElement(By.xpath("//button[@id='btnNo']")).click();
	    	       rate.sendKeys(Rate);
				   rate.sendKeys(Keys.ENTER);*/
				
				WebElement cnfrm = driver.findElement(By.xpath("//input[@id='txtConfirmation']"));
				cnfrm.sendKeys(Message);
				WebElement btn = driver.findElement(By.xpath("//button[@class='blueBtn m-0']"));
				btn.sendKeys(Keys.ENTER);
	      //}
	      
	     }
		else {
			//rate.sendKeys(Keys.BACK_SPACE);
			rate.sendKeys(Rate);
			rate.sendKeys(Keys.ENTER);
			
			
			/*WebElement cnfrm = driver.findElement(By.xpath("//input[@id='txtConfirmation']"));
			cnfrm.sendKeys(Message);
			WebElement btn = driver.findElement(By.xpath("//button[@class='blueBtn m-0']"));
			btn.sendKeys(Keys.ENTER);
			 WebElement Ratmod = driver.findElement(By.xpath("//button[@id='dontStore']"));
		     Ratmod.click();*/
			//btn.click();
			
			/*String foo =driver.findElement(By.xpath("//input[@id='txt-salePurchaseRate-0']")).getText();
			System.out.println("Rate :: "+foo);
			if (foo.equals(rate)) {
				rate.sendKeys(Keys.ENTER);
			} else {
			WebElement cnfrm = driver.findElement(By.xpath("//input[@id='txtConfirmation']"));
			cnfrm.sendKeys("Sure");
			WebElement btn = driver.findElement(By.xpath("//button[@class='blueBtn m-0']"));
			btn.click();
			}*/
		}
		
		/*String strng = rate.getText();
		System.out.println(strng);
		Assert.assertEquals(rate, strng);*/
		Thread.sleep(5000);
		WebElement disc1 = driver.findElement(By.xpath("//input[@id='txt-discount1-0']"));
		
		if(disc1.isDisplayed()){
			disc1.sendKeys(Keys.ENTER);
			 //disc Modif
			if(!driver.findElements(By.xpath("//button[@id='dontStore']")).isEmpty()){
		     WebElement Dismo = driver.findElement(By.xpath("//button[@id='dontStore']"));
		     Dismo.click();
			}
		     }
			else {
				disc1.sendKeys(Keys.BACK_SPACE);
				disc1.sendKeys(Discount);
				disc1.sendKeys(Keys.ENTER);
				WebElement Dismo = driver.findElement(By.xpath("//button[@id='dontStore']"));
				Dismo.click();
			}
		
	}
	// pro2
	@Test(priority=11)
	public void pro2(){
		WebElement Pro2 = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-1']"));
		Pro2.sendKeys(Keys.SPACE);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
		Seritem.sendKeys("Pro1");
		Seritem.sendKeys(Keys.ENTER);
	}
	@Test(priority=12)
	public void Qty2(){
		WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-1']"));
		Qty.sendKeys(Keys.BACK_SPACE);
		Qty.sendKeys("5");
		Qty.sendKeys(Keys.ENTER);
		
	}
	@Test(priority=13)
    public void Save (){
		WebElement sva = driver.findElement(By.xpath("//*[contains(@id,'btnSave')]"));
		sva.click();
	}
	
	


}
