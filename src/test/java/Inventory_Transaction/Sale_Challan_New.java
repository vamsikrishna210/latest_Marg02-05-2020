package Inventory_Transaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;


//import org.apache.poi.ss.formula.functions.LookupUtils.CompareResult;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Sale_Challan_New {

// Prescription is opening chemist
	WebDriver driver;
	WebDriverWait Wait;
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
	String batch1        =	reader.getCellData("Sale", "Batch_Item", 2);
	
	
	@BeforeSuite
	 public void webLaunch() {
		
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/qa");
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
			System.out.println("company Selected");
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Inventory Trans."));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Sale"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			 WebElement challan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New Challan")));
			//driver.findElement(By.linkText("New Challan")).click();
			 challan.click();
			
	 }
	@Test(priority=2)
	 // Date
	 public void createSC() throws InterruptedException{
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
			if(!driver.findElements(By.xpath("//*[contains(@id,'txtentryNo')]")).isEmpty()){
			WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
			orderno.click();
			//orderno.clear();
			//orderno.sendKeys(OrderNo);
			//orderno.sendKeys(Keys.ENTER);
			}
		}
		else if(driver.findElement(By.xpath("//*[@id='txtaskpartyinretailbilling']/option[2]")).isSelected()){
			WebElement led =driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]"));
		    led.sendKeys(Keys.BACK_SPACE);
		    //led.sendKeys(Keys.SPACE);
		   
		    WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
			textbox.clear();
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
			
		}
		else if(driver.findElement(By.xpath("//*[@id='txtaskpartyinretailbilling']/option[3]")).isSelected()){
			if(!driver.findElements(By.xpath("//*[contains(@id,'txtentryNo')]")).isEmpty()){
			WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
			//orderno.clear();
			//orderno.sendKeys(OrderNo);
			//orderno.sendKeys(Keys.ENTER);
			orderno.click();
		}
		}
		
		 /*if(driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]")).isDisplayed());{
			 WebElement led =driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]"));
			    led.sendKeys(Keys.BACK_SPACE);
			    led.sendKeys(Keys.SPACE);
		 }*/

	 }
	@Test(priority=3)
	public void orderNo(){
		if(!driver.findElements(By.xpath("//*[contains(@id,'txtentryNo')]")).isEmpty()){
		WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
		if(orderno.isDisplayed()){
			//orderno.sendKeys(Keys.ENTER);
			orderno.sendKeys(Keys.ENTER);
		
		     }
			else {
				orderno.sendKeys(Keys.BACK_SPACE);
				orderno.sendKeys(OrderNo);
				orderno.sendKeys(Keys.ENTER);	
				
			}}
		if(driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]")).isDisplayed());{
			WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
			PId.clear();
			PId.sendKeys(Keys.ENTER);
			}
}
	@Test(priority=4)
	public void Patientid() throws InterruptedException{
		WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
		PId.clear();
		PId.sendKeys(PatientId);
		//PId.sendKeys(Keys.ENTER);
		Thread.sleep(5000);	
	}
	@Test(priority=5)
	public void prescription() throws InterruptedException{
		WebElement Ptextbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
		Ptextbox.clear();
	    Thread.sleep(5000);
		Ptextbox.sendKeys(Prescription);
		Thread.sleep(2000);
		Ptextbox.sendKeys(Keys.ENTER);
		
		
	}
	
	@Test(priority=6)
	public void DocId() throws InterruptedException{
		WebElement DId = driver.findElement(By
				.xpath("//*[contains(@id,'txtdrmobile')]"));
		if (DId.isDisplayed()) {
			DId.clear();
			DId.sendKeys(DoctorId);
			DId.sendKeys(Keys.ENTER);
			WebElement Drd = driver.findElement(By
					.xpath("//*[contains(@id,'txtdrname')]"));
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
                /*WebElement billdisc = driver.findElement(By.xpath("//input[@id='tempBillDiscountPercentage']"));
                if(billdisc.isEnabled()){
			//if (driver.findElements(By.xpath("//input[@id='tempBillDiscountPercentage']")) {
				//WebElement disc = driver.findElement(By.xpath("//input[@id='tempBillDiscountPercentage']"));
				billdisc.sendKeys(Keys.ENTER);
			}*/

		}
		if(!driver.findElements(By.xpath("//*[contains(@id,'txtStore')]")).isEmpty()){
			WebElement str = driver.findElement(By.xpath("//*[contains(@id,'txtStore')]"));
			str.sendKeys(Keys.ENTER);
		}

	}
	@Test(priority=7)
	public void PendingOrder() throws InterruptedException{
	/*List<WebElement> allchkbox = driver.findElements(By.xpath("//ag-grid-angular[@id='pendingChallanGrid']//div[@class='ag-root ag-font-style ag-layout-normal']"));
		
		int count = allchkbox.size();
	System.out.println("Total no. of checkboxes: "+count);
	
	//select all check boxes from top to bottom
	
	for(int i=1;i<count;i++)
	{
	WebElement chkbox = allchkbox.get(i);
	chkbox.click();
	
	}
			
	//WebElement eSearchBoxBill=driver.findElement(By.xpath("//*[@id='SearchBox']"));
	
	//eSearchBoxBill.sendKeys(Keys.ENTER);
	//eSearchBoxBill.sendKeys(Keys.ENTER);
*/		//String checkboxes = "ag-grid-angular[@id='pendingChallanGrid']//div[@class='ag-body-viewport ag-layout-normal']";
		// For orders
		// Automatic sttings
		if(driver.findElement(By.xpath("//option[contains(text(),'Automatic')]")).isSelected()){
			/*if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-0']")).isEmpty()){
				WebElement ItemCode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-0']"));
			}
				if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-1']")).isEmpty()){
					WebElement ItemCode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-1']"));
				}*/
					if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-2']")).isEmpty()){
						WebElement ItemCode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-2']"));
				}
					}
				// Selection
		else if(driver.findElement(By.xpath("//option[contains(text(),'Selection')]")).isSelected()){
			
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String checkboxes = "//div[@class='ag-row ag-row-even ag-row-level-0 normal ag-row-position-absolute ag-row-focus']//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
		List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		for (WebElement AllCheck : elementToClick) {
		    AllCheck.click();
		}
		WebElement esc = driver.findElement(By.xpath("//button[@id='btn-Close']"));
		esc.click();
		Thread.sleep(5000);
			
			/*String checkitems = "//*[contains(@class,'clsPendingChallanOrder')]";
			List<WebElement> Items = driver.findElements(By.xpath(checkitems));
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			int count = Items.size();
			for(int i =0 ; i<count ; i++){
				WebElement Sel = Items.get(i);
				
				Sel.click();
			}*/
       // Items selection in order
		String checkitems = "//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
		List<WebElement> Items = driver.findElements(By.xpath(checkitems));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		int count = Items.size();
		for(int i =0 ; i<count ; i++){
			WebElement Sel = Items.get(i);
			Sel.click();
		}
		WebElement esc1 = driver.findElement(By.xpath("//button[@id='btn-Close']"));
		esc1.click();
	}   
		// Not required
		else if(driver.findElement(By.xpath("//option[contains(text(),'Not Required')]")).isSelected()){
			System.out.println("pending orders not Selected npo selections selected");
		}
		}
	
	@Test(priority=8)
	 public void ItemSele() throws InterruptedException{
		
		if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-2']")).isEmpty()){
			
			WebElement ItemCode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-2']"));
			ItemCode.sendKeys(Keys.BACK_SPACE);
			ItemCode.sendKeys(ItemCode1);
			ItemCode.sendKeys(Keys.ENTER);
		}
		if(!driver.findElements(By.xpath("//input[@id='txt-tmp_barcode-2']")).isEmpty()){
			WebElement Barc = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-2']"));
			Barc.sendKeys(Keys.BACK_SPACE);
			Barc.sendKeys(BarCode);
			Barc.sendKeys(Keys.ENTER);
			
		}
		
			WebElement prov = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-2']"));
			prov.sendKeys(Keys.BACK_SPACE);
			
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchItems")));
			Seritem.sendKeys(Item1);
			Thread.sleep(3000);
			Seritem.sendKeys(Keys.ENTER);
			
		}
	//With and  without multi unit
	@Test(priority=9)
	public void Qty (){
		if(!driver.findElements(By.xpath("//input[@id='searchItems']")).isEmpty()){
			WebElement batch = driver.findElement(By.xpath("//input[@id='searchItems']"));
			batch.sendKeys(batch1);
			batch.sendKeys(Keys.ENTER);
			
		}
		if(!driver.findElements(By.xpath("//input[@id='txt-quantity-2']")).isEmpty()){
			WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-2']"));
			Qty.sendKeys(Keys.BACK_SPACE);
			Qty.sendKeys(Qty1);
			Qty.sendKeys(Keys.ENTER);
		}
		else{
			WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-2']"));
			Qty1.sendKeys(Keys.BACK_SPACE);
			Qty1.sendKeys(Unit2);
			Qty1.sendKeys(Keys.ENTER);
			
			WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-2')]"));
			pcs.sendKeys(Keys.BACK_SPACE);
			pcs.sendKeys(Unit1);
			pcs.sendKeys(Keys.ENTER);
		}
		if(!driver.findElements(By.xpath("//input[@id='txt-free-2']")).isEmpty()){
			WebElement free = driver.findElement(By.xpath("//input[@id='txt-free-2']"));
			free.sendKeys(Keys.BACK_SPACE);
			free.sendKeys(Free);
			free.sendKeys(Keys.ENTER);
			
		}
			
	}
	@Test(priority=10)
	public void rate() throws InterruptedException{
		 List<WebElement> Rate = driver.findElements(By.id("txt-salePurchaseRate-2"));
		if(!Rate.isEmpty()){
			WebElement entrrate = driver.findElement(By.id("txt-salePurchaseRate-2"));
			entrrate.sendKeys(Keys.BACK_SPACE);
			entrrate.sendKeys(Rate1);
		}
		else{
			WebElement entrrate = driver.findElement(By.id("txt-salePurchaseRate-2"));
			entrrate.sendKeys(Keys.ENTER);
		}
			
		
		Thread.sleep(5000);
	
		List<WebElement> disc1 = driver.findElements(By.xpath("//input[@id='txt-discount1-2']"));
		
		if(!disc1.isEmpty()){
	        WebElement disc = driver.findElement(By.xpath("//input[@id='txt-discount1-2']"));
			disc.sendKeys(Keys.ENTER);
			 //disc Modif
		     /*WebElement Dismo = driver.findElement(By.xpath("//button[@id='dontStore']"));
		     Dismo.click();*/
		      
		     }
			else {
				WebElement disc = driver.findElement(By.xpath("//input[@id='txt-discount1-2']"));
				disc.sendKeys(Keys.BACK_SPACE);
				disc.sendKeys(Discount);
				disc.sendKeys(Keys.ENTER);
				 /*WebElement Dismo = driver.findElement(By.xpath("//button[@id='dontStore']"));
				 Dismo.click();*/
			}
		}
	@Test(priority=11)
	public void Save() {
		WebElement sav = driver.findElement(By.xpath("//*[contains(@id,'btnSave')]"));
		sav.click();
	}
	}
	
	
	
 

















