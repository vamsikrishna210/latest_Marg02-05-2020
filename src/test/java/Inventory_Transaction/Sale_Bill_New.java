package Inventory_Transaction;

import java.sql.Driver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;



























//import org.openqa.selenium.Alert;
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

import General_Fun.General_Functions;

import com.margerp.qa.xls_Reader.Xls_Reader;
public class Sale_Bill_New {
	
	
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
		String Rate1        =    reader.getCellData("Sale", "Rate_1", 2);
		String Message     =	reader.getCellData("Sale", "conformation_msg", 2);
		String Discount    =	reader.getCellData("Sale", "Disc_1", 2);
		String Free        =	reader.getCellData("Sale", "Free_Qty", 2);
		String CashACC        =	reader.getCellData("Sale", "Cash_Bal", 2);
		String Remark        =	reader.getCellData("Sale", "Remark_cash", 2);
	
	@BeforeSuite
	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/vamsi");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
	    	driver.findElement(By.xpath("//a[@class='nav-link login']")).click();
		}
	 @BeforeTest
	 public void login() {
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
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
			driver.findElement(By.linkText("New Bill")).click();
	 }
    @Test(priority=2)
	 // Date
	 public void createsale() throws InterruptedException{
    	
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
		
		//Ask party settings 
		// no
		if(driver.findElement(By.xpath("//*[@id='txtaskpartyinretailbilling']/option[1]")).isSelected()){
			if(driver.findElement(By.xpath("//*[@id='askBillNo']/option[1]")).isSelected()){
				WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
				PId.clear();
			}
			else if(driver.findElement(By.xpath("//*[@id='askBillNo']/option[2]")).isSelected()){
				WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
				orderno.click();
			}
			else if(driver.findElement(By.xpath("//*[@id='askBillNo']/option[3]")).isSelected()){
				WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
				PId.clear();
			//orderno.clear();
			//orderno.sendKeys(OrderNo);
			//orderno.sendKeys(Keys.ENTER);
			}
		}
		// Ask
		else if(driver.findElement(By.xpath("//*[@id='txtaskpartyinretailbilling']/option[2]")).isSelected()){
			WebElement led =driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]"));
		    led.sendKeys(Keys.BACK_SPACE);
		    //led.sendKeys(Keys.SPACE);
		   Thread.sleep(3000);
		   // WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
		    WebElement textbox = driver.findElement(By.xpath("//*[contains(@id,'SearchBox')]"));
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
		// Ask on space bar
		else if(driver.findElement(By.xpath("//*[@id='txtaskpartyinretailbilling']/option[3]")).isSelected()){
			if(driver.findElement(By.xpath("//*[@id='askBillNo']/option[1]")).isSelected()){
				 if(driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]")).isDisplayed());{
					 WebElement led =driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]"));
					    led.sendKeys(Keys.BACK_SPACE);
					    led.sendKeys(Keys.SPACE);
				 }
				WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
				PId.clear();
			}
			else if(driver.findElement(By.xpath("//*[@id='askBillNo']/option[2]")).isSelected()){
				WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
				orderno.click();
			}
			else if(driver.findElement(By.xpath("//*[@id='askBillNo']/option[3]")).isSelected()){
				WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
				PId.clear();
			//orderno.clear();
			//orderno.sendKeys(OrderNo);
			//orderno.sendKeys(Keys.ENTER);
			}
		}
		
		
		 if(driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]")).isDisplayed());{
			 WebElement led =driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]"));
			    led.sendKeys(Keys.BACK_SPACE);
			    led.sendKeys(Keys.SPACE);
		 }

	 }
    @Test(priority=3)
    public void orderNo(){
    	WebElement orderno1 = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
    	//List<WebElement> orderno = driver.findElements(By.xpath("//*[contains(@id,'txtentryNo')]"));
		if(orderno1.isEnabled()){
			//WebElement orderno1 = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
			orderno1.sendKeys(Keys.ENTER);
			//orderno.sendKeys(Keys.ENTER);
		
		     }
			else {
				//WebElement orderno1 = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
				orderno1.sendKeys(Keys.BACK_SPACE);
				orderno1.sendKeys(OrderNo);
				orderno1.sendKeys(Keys.ENTER);	
				
			}
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
		}
	
		@Test(priority=7)
		public void PendingChallan() throws InterruptedException{
			//Auto
			if(driver.findElement(By.xpath("//*[@id='loadPendingChallans']/option[1]")).isSelected()){
				WebElement sav = driver.findElement(By.xpath("//*[contains(@id,'btnSave')]"));
				sav.click();
			}
			//Ask Salection
			else if(driver.findElement(By.xpath("//*[@id='loadPendingChallans']/option[2]")).isSelected()){
				// Load Challan
				
				System.out.println("Ask Challan selected");
				String checkboxes = "//div[@class='ag-row ag-row-even ag-row-level-0 normal ag-row-position-absolute ag-row-focus']//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
				List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
				for (WebElement AllCheck : elementToClick) {
				    AllCheck.click();
				}
				WebElement esc = driver.findElement(By.xpath("//button[@id='btn-Close']"));
				esc.click();
				Thread.sleep(2000);
				
				// Select challan items
				String checkitems1 = "//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
				List<WebElement> Items1 = driver.findElements(By.xpath(checkitems1));
				int count1 = Items1.size();
				for(int i =0 ; i<count1 ; i++){
					WebElement Sel = Items1.get(i);
					Sel.click();
				}
				WebElement escc = driver.findElement(By.xpath("//button[@id='btn-Close']"));
				escc.click();
				System.out.println("items Selected");
				
				
				System.out.println("Ordr checked");
				
				// Load Order
				String checkboxes1 = "//div[@class='ag-row ag-row-even ag-row-level-0 normal ag-row-position-absolute ag-row-focus']//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
				List<WebElement> elementToClick1 = driver.findElements(By.xpath(checkboxes1));
				for (WebElement AllCheck1 : elementToClick1) {
				    AllCheck1.click();
				}
				WebElement esc1 = driver.findElement(By.xpath("//button[@id='btn-Close']"));
		      		esc1.click();
				Thread.sleep(5000);
				
				// Load Items from order
				String checkitems = "//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
				List<WebElement> Items = driver.findElements(By.xpath(checkitems));
				int count = Items.size();
				for(int i =0 ; i<count ; i++){
					WebElement Sel = Items.get(i);
					Sel.click();
				}
				WebElement esc2 = driver.findElement(By.xpath("//button[@id='btn-Close']"));
				esc2.click();
				System.out.println("items Selected");
				
			}
			// Not Required
			else if(driver.findElement(By.xpath("//*[@id='loadPendingChallans']/option[3]")).isSelected()){
			//if(driver.findElements(By.xpath("//div[@class='ag-body-container ag-layout-normal']//div[1]//div[1]//span[1]//span[1]//span[2]")).isEmpty()){
				if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-2']")).isEmpty()){
					WebElement Procode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-2']"));
					Procode.sendKeys(ItemCode1);
					Procode.sendKeys(Keys.ENTER);
					
				}
				else if(!driver.findElements(By.xpath("//*[contains(@id,'txt-tmp_barcode-2')]")).isEmpty()){
					WebElement Bar = driver.findElement(By.xpath("//*[contains(@id,'txt-tmp_barcode-2')]"));
					Bar.sendKeys(BarCode);
					Bar.sendKeys(Keys.ENTER);
			}
				}
			
		}
		/*@Test(priority=8)
		public void PendingOrder() throws InterruptedException{
			String checkboxes = "//div[@class='ag-body-container ag-layout-normal']//div[1]//div[1]//span[1]//span[1]//span[2]";
			List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
			for (WebElement AllCheck : elementToClick) {
			    AllCheck.click();
			}
			WebElement esc = driver.findElement(By.xpath("//button[@id='btn-Close']"));
	      		esc.click();
			Thread.sleep(5000);
		}
		@Test(priority=9)
		public void SelectPendingItems(){
			// Items selection in order
			String checkitems = "//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
			List<WebElement> Items = driver.findElements(By.xpath(checkitems));
			int count = Items.size();
			for(int i =0 ; i<count ; i++){
				WebElement Sel = Items.get(i);
				Sel.click();
			}
			WebElement esc1 = driver.findElement(By.xpath("//button[@id='btn-Close']"));
			esc1.click();
		}*/
		@Test(priority=8)
		public void Proselection(){
			if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-2']")).isEmpty()){
				WebElement Procode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-2']"));
				Procode.sendKeys(ItemCode1);
				Procode.sendKeys(Keys.ENTER);
			}
			else if(!driver.findElements(By.xpath("//*[contains(@id,'txt-tmp_barcode-2')]")).isEmpty()){
				WebElement Bar = driver.findElement(By.xpath("//*[contains(@id,'txt-tmp_barcode-2')]"));
				Bar.sendKeys(BarCode);
				Bar.sendKeys(Keys.ENTER);
			}
			
		}
		@Test(priority=9)
		public void selItem(){
			WebElement pro = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-3']"));
			pro.sendKeys(Keys.SPACE);
			if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[2]")).isSelected()){
				WebElement itemS = driver.findElement(By.xpath("//input[@id='searchItems']"));
				itemS.sendKeys(Item1);
				itemS.sendKeys(Keys.ENTER);
			}
			else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[1]")).isSelected()){
				WebElement itemS = driver.findElement(By.xpath("//input[@id='searchItems']"));
				itemS.sendKeys(BarCode);
				itemS.sendKeys(Keys.ENTER);
			}
		}
		@Test(priority=10)
		public void Qty(){
			if(!driver.findElements(By.xpath("//*[@id='txt-quantity-3']")).isEmpty()){
				WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-3']"));
				//Qty.sendKeys(Keys.BACK_SPACE);
				Qty.sendKeys(Qty1);
				Qty.sendKeys(Keys.ENTER);
			}
			else{
				WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-3']"));
				//Qty1.sendKeys(Keys.BACK_SPACE);
				Qty1.sendKeys(Unit2);
				Qty1.sendKeys(Keys.ENTER);
				
				WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-3')]"));
				//pcs.sendKeys(Keys.BACK_SPACE);
				pcs.sendKeys(Unit1);
				pcs.sendKeys(Keys.ENTER);
			}
			if(!driver.findElements(By.xpath("//input[@id='txt-free-3']")).isEmpty()){
				WebElement free = driver.findElement(By.xpath("//input[@id='txt-free-3']"));
				free.sendKeys(Keys.BACK_SPACE);
				free.sendKeys(Free);
				free.sendKeys(Keys.ENTER);
				
			}	
		}
		@Test(priority=11)
		public void Rate() throws InterruptedException{
			 //List<WebElement> Rate = driver.findElements(By.id("txt-salePurchaseRate-3"));
		     /*WebElement	Rate = driver.findElement(By.id("txt-salePurchaseRate-3"));
				if(Rate.equals(null)){*/
			WebElement rate = driver.findElement(By.xpath("//input[@id='txt-salePurchaseRate-3']"));
			//String Ra = rate.getText();
			
			if (rate.isDisplayed()){
				WebElement entrrate = driver.findElement(By.id("txt-salePurchaseRate-3"));
				//entrrate.sendKeys(Keys.BACK_SPACE);
				entrrate.sendKeys(Rate1);
				entrrate.sendKeys(Keys.ENTER);
					
					
				}
				else{
					WebElement entrrate = driver.findElement(By.id("txt-salePurchaseRate-3"));
					entrrate.sendKeys(Keys.ENTER);
				}
					
				
				Thread.sleep(5000);
			
				//List<WebElement> disc1 = driver.findElements(By.xpath("//input[@id='txt-discount1-3']"));
				WebElement disc = driver.findElement(By.xpath("//input[@id='txt-discount1-3']"));
				if(disc.isEnabled()){
					if (disc.isEnabled()){
			        //WebElement disc = driver.findElement(By.xpath("//input[@id='txt-discount1-3']"));
					disc.sendKeys(Keys.ENTER);
					 //disc Modif
				     /*WebElement Dismo = driver.findElement(By.xpath("//button[@id='dontStore']"));
				     Dismo.click();*/}
				      
				     }
					else {
						//WebElement disc = driver.findElement(By.xpath("//input[@id='txt-discount1-3']"));
						disc.sendKeys(Keys.BACK_SPACE);
						disc.sendKeys(Discount);
						disc.sendKeys(Keys.ENTER);
						 /*WebElement Dismo = driver.findElement(By.xpath("//button[@id='dontStore']"));
						 Dismo.click();*/
					}
			
		}
		@Test(priority=12)
		public void savesbill(){
			WebElement svbill = driver.findElement(By.xpath("//*[contains(@id,'btnSave')]"));
			svbill.click();
		}
		@Test(priority=13)
		public void modeofpay() throws InterruptedException{
			 // Cash
			WebElement cash = driver.findElement(By.xpath("//input[@id='txt-amount-0']"));
			/*cash.sendKeys(CashACC);
			cash.sendKeys(Keys.ENTER);*/
			
			Thread.sleep(2000);
			String cr = cash.getText();
			// Bill Amount 
			
			WebElement billamount = driver.findElement(By.xpath("//input[@id='BillAmount']"));
			String BA = billamount.getText();
			//double d2 =Double.parseDouble(BA); 
			
			
			if(cr.equals(BA)){
				
				cash.sendKeys(Keys.ENTER);
			}
			else{
				cash.sendKeys(Keys.BACK_SPACE);
				cash.sendKeys(Keys.ENTER);
				// Bank
				WebElement bank = driver.findElement(By.xpath("//input[@id='txt-amount-1']"));
				String BAn = bank.getText();
				
				//double d=Double.parseDouble(BAn);
				// Adjustmant
				WebElement Adju = driver.findElement(By.xpath("//input[@id='BalanceAdjusted']"));
				String adj = Adju.getText();
				//double d3 =Double.parseDouble(adj); 
				/*double d4 = 
				
				 if(d3==d4){
					 bank.sendKeys(Keys.ENTER);
				 }*/
			}	
			
			
		}
		@Test(priority= 14)
		public void remarks(){
			WebElement rem = driver.findElement(By.xpath("//input[@id='txt-Remarks-0']"));
			rem.sendKeys(Remark);
			
			WebElement save2 = driver.findElement(By.xpath("//span[@class='box'][contains(text(),'Save')]"));
			save2.click();
			System.out.println("Bill saved properly");
		}
		
		}

	
    	
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  