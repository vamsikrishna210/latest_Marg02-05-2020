package Inventory_Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
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

public class Po_New {
	WebDriver driver;
	WebDriverWait Wait;
	//String[] invalidChars= {"#", "!", "$", "@", "%", "^","~"};
	
	  String specialCharacters="~!^";
	
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
  
 
    String user        = 	reader.getCellData("purchase", "user", 2);
	String pass 	   = 	reader.getCellData("purchase", "password", 2);
	String Companyname = 	reader.getCellData("purchase", "Company_name", 2);
	String ledgername  = 	reader.getCellData("purchase", "ledger_name", 2);
	String OrderNo 	   = 	reader.getCellData("purchase", "Order_No", 2);
	String PatientId   = 	reader.getCellData("purchase", "Patient_Id", 2);
	String Prescription=	reader.getCellData("purchase", "Prescription_Id", 2);
	String DoctorId    =	reader.getCellData("purchase", "Doctor_Id", 2);
	String ItemCode1   =	reader.getCellData("purchase", "Item_Code", 2);
	String ItemCode2   =	reader.getCellData("purchase", "Item_Code", 3);
	String BarCode     =	reader.getCellData("purchase", "Bar_Code", 2);
	String BarCode2     =	reader.getCellData("purchase", "Bar_Code", 3);
	String Item1       =    reader.getCellData("purchase", "Item_1", 2);
	String Item2       =    reader.getCellData("purchase", "Item_1", 3);
	String SaleType    =	reader.getCellData("purchase", "Sale_Type", 2);
	String Qty1        =    reader.getCellData("purchase", "Quantity_main", 2);
	String Qty2        =    reader.getCellData("purchase", "Quantity_main", 3);
	String Unit2       =	reader.getCellData("purchase", "Multi_unit_2", 2);
	String Unit1       =	reader.getCellData("purchase", "Multi_unit_1", 2);
	String Rate        =    reader.getCellData("purchase", "Rate_1", 2);
	String Rate2       =    reader.getCellData("purchase", "Rate_1", 3);
	String Message     =	reader.getCellData("purchase", "conformation_msg", 2);
	String Discount    =	reader.getCellData("purchase", "Disc_1", 2);
	String Discount2   =	reader.getCellData("purchase", "Disc_1", 3);
	String BillDisc    =	reader.getCellData("purchase", "Bill_Disc", 3);
	String BillAmount1  =	reader.getCellData("purchase", "Bill_Amount", 3);
	String Free        =	reader.getCellData("purchase", "Free_Qty", 2);
	String LSertype    =	reader.getCellData("purchase", "Serch_Led_By", 2);
	

	@BeforeSuite
	 public void webLaunch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://172.16.8.17/margwebsite/QA");
		driver.manage().window().maximize();
		System.out.println("url opend Sucessfuly");
		}
	@BeforeTest
	 public void login() {
		driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
		driver.findElement(By.id("userid")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("btnSave")).click();
		System.out.println("logined scuessfully");

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
			
			System.out.println("company Selected");
			/*WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			pass.sendKeys("1234");
			pass.sendKeys(Keys.ENTER);*/
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Inventory Trans."));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Purchase Order"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("New")).click();
			System.out.println("purchase order opend Sucessfully");
	 }
	@Test(priority=2)
	 public void createPo() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.now();
		 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'txtbillDate')]")));
		 Date.sendKeys(dtf.format(date));
		 System.out.println(dtf.format(date));
		 Thread.sleep(3000); 
		 Date.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		System.out.println("local date Enterd");
		 
	 }
	@Test(priority=3)
	 public void selectLedger() throws InterruptedException{
		//Serch Ledger By
				Select LSerch = new Select(driver.findElement(By.xpath("//select[@id='mrgSearchBox']")));
				LSerch.selectByVisibleText(LSertype);
				
				Thread.sleep(3000);
				if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[2]")).isSelected()){
				 WebDriverWait wait = new WebDriverWait(driver, 10);
				 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
				 Serach1.sendKeys(ledgername);
					//Thread.sleep(2000);
					List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
					int count=allOptions.size();
					System.out.println("No.of Autosuggesion "+count);
					System.out.println("List of Autosuggesion");
					for(int i=0;i<count;i++){
						String text = allOptions.get(i).getText();
						System.out.println(text);	
					}
					
					//textbox.sendKeys(Keys.ARROW_DOWN);
					
					Serach1.sendKeys(Keys.ENTER);
					System.out.println("ledger Selected Sucessfully");
					System.out.println("_-___----__----___");
					Thread.sleep(2000);
				 
			 }
				else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[3]")).isSelected()){
					 WebDriverWait wait = new WebDriverWait(driver, 10);
					 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
					 Serach1.sendKeys(ledgername);
						//Thread.sleep(2000);
						List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
						int count=allOptions.size();
						System.out.println("No.of Autosuggesion "+count);
						System.out.println("List of Autosuggesion");
						for(int i=0;i<count;i++){
							String text = allOptions.get(i).getText();
							System.out.println(text);	
						}
						
						//textbox.sendKeys(Keys.ARROW_DOWN);
						
						Serach1.sendKeys(Keys.ENTER);
						System.out.println("ledger Selected Sucessfully");
						System.out.println("_-___----__----___");
						Thread.sleep(2000);
				}
				else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[4]")).isSelected()){
					 WebDriverWait wait = new WebDriverWait(driver, 10);
					 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
					 Serach1.sendKeys(ledgername);
						//Thread.sleep(2000);
						List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
						int count=allOptions.size();
						System.out.println("No.of Autosuggesion "+count);
						System.out.println("List of Autosuggesion");
						for(int i=0;i<count;i++){
							String text = allOptions.get(i).getText();
							System.out.println(text);	
						}
						
						//textbox.sendKeys(Keys.ARROW_DOWN);
						
						Serach1.sendKeys(Keys.ENTER);
						System.out.println("ledger Selected Sucessfully");
						System.out.println("_-___----__----___");
						Thread.sleep(2000);
				}
				else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[5]")).isSelected()){
					 WebDriverWait wait = new WebDriverWait(driver, 10);
					 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
					 Serach1.sendKeys(ledgername);
						//Thread.sleep(2000);
						List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
						int count=allOptions.size();
						System.out.println("No.of Autosuggesion "+count);
						System.out.println("List of Autosuggesion");
						for(int i=0;i<count;i++){
							String text = allOptions.get(i).getText();
							System.out.println(text);	
						}
						
						//textbox.sendKeys(Keys.ARROW_DOWN);
						
						Serach1.sendKeys(Keys.ENTER);
						System.out.println("ledger Selected Sucessfully");
						System.out.println("_-___----__----___");
						Thread.sleep(2000);
				}
				else if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[6]")).isSelected()){
					 WebDriverWait wait = new WebDriverWait(driver, 10);
					 WebElement Serach1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
					 Serach1.sendKeys(ledgername);
						//Thread.sleep(2000);
						List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
						int count=allOptions.size();
						System.out.println("No.of Autosuggesion "+count);
						System.out.println("List of Autosuggesion");
						for(int i=0;i<count;i++){
							String text = allOptions.get(i).getText();
							System.out.println(text);	
						}
						
						//textbox.sendKeys(Keys.ARROW_DOWN);
						
						Serach1.sendKeys(Keys.ENTER);
						System.out.println("ledger Selected Sucessfully");
						System.out.println("_-___----__----___");
						Thread.sleep(2000);
				}
		 
	 }
	@Test(priority=4)
	public void orderNo(){
		
		if(driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]")).isDisplayed()){
			WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
			//orderno.clear();
			orderno.sendKeys(Keys.ENTER);	
			System.out.println("order number Exists");
			
		}
		else{
			WebElement orderno = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
			orderno.clear();
			orderno.sendKeys(OrderNo);
			orderno.sendKeys(Keys.ENTER);	
			System.out.println("orderNo entered ");
		}
		// purchase type
		//no
		if(driver.findElement(By.xpath("//*[@id='txtisPurchaseTypeForBilling']/option[1]")).isSelected()){
			// Discount percentage
			System.out.println("purchase type not selected");
			if(!driver.findElements(By.xpath("//input[@id='tempBillDiscountPercentage']")).isEmpty()){
				WebElement Discper = driver.findElement(By.xpath("//input[@id='tempBillDiscountPercentage']"));
				Discper.sendKeys(Keys.ENTER);
				System.out.println("Discount percentage is showing ");
			}
			else {
				if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-0']")).isEmpty()){
					WebElement ItemCode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-0']"));
					/*ItemCode.sendKeys(ItemCode1);
					ItemCode.sendKeys(Keys.ENTER);*/
				}
				else if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-0']")).isEmpty()){
					WebElement Barc = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-0']"));
					/*Barc.sendKeys(BarCode);
					Barc.sendKeys(Keys.ENTER);*/
				}
				else{
				WebElement pro1 = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-0']"));
				pro1.sendKeys(Keys.SPACE);
			    }	
				}	
			}
		// Yes selected
		else if(driver.findElement(By.xpath("//*[@id='txtisPurchaseTypeForBilling']/option[2]")).isSelected()) {
			WebElement purchasetype = driver.findElement(By.xpath("//*[contains(@id,'txtSaleType')]"));
			purchasetype.sendKeys(Keys.ENTER);
			
			if(!driver.findElements(By.xpath("//input[@id='tempBillDiscountPercentage']")).isEmpty()){
				WebElement Discper = driver.findElement(By.xpath("//input[@id='tempBillDiscountPercentage']"));
				Discper.sendKeys(Keys.ENTER);
				System.out.println("Discount percentage is showing ");	
		}
		}
	}	// Item1 Selection
		@Test(priority=5)
		public void itemSelection() throws InterruptedException{
			if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-0']")).isEmpty()){
				
				WebElement ItemCode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-0']"));
				ItemCode.sendKeys(Keys.BACK_SPACE);
				ItemCode.sendKeys(ItemCode1);
				ItemCode.sendKeys(Keys.ENTER);
			}
			if(!driver.findElements(By.xpath("//input[@id='txt-tmp_barcode-0']")).isEmpty()){
				WebElement Barc = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-0']"));
				Barc.sendKeys(Keys.BACK_SPACE);
				Barc.sendKeys(BarCode);
				Barc.sendKeys(Keys.ENTER);
				
			}
			
				WebElement prov = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-0']"));
				prov.sendKeys(Keys.SPACE);
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
				WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
				Seritem.sendKeys(Item1);
				Thread.sleep(3000);
				Seritem.sendKeys(Keys.ENTER);
				
				System.out.println("item selected sucessfully");
				
			}
		@Test(priority=6)
		public void ReqQty(){
			if(!driver.findElements(By.xpath("//input[@id='txt-quantity-0']")).isEmpty()){
				 System.out.println("Multi unit is off");
				WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-0']"));
				Qty.sendKeys(Keys.BACK_SPACE);
				Qty.sendKeys(Qty1);
				Qty.sendKeys(Keys.ENTER);
				
			}
			else{
				System.out.println("multi unit on ");
				// only for two multi unit values
				
				 if(!driver.findElements(By.xpath("//input[@id='txt-unitFromEnteredValue-0']")).isEmpty()){
				WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-0']"));
				Qty1.sendKeys(Keys.BACK_SPACE);
				Qty1.sendKeys(Unit2);
				Qty1.sendKeys(Keys.ENTER);
				 }
				WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-0')]"));
				pcs.sendKeys(Keys.BACK_SPACE);
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
		
		@Test(priority=7)
		public void purRate(){
			
			WebElement rate = driver.findElement(By.xpath("//input[@id='txt-salePurchaseRate-0']"));
			if(rate.isDisplayed()){
				rate.sendKeys(Keys.ENTER);
			}
			else{
				rate.sendKeys(Rate);
				rate.sendKeys(Keys.ENTER);
			}
		}
		@Test(priority=8)
        public void Discount()	{
			WebElement dis  = driver.findElement(By.xpath("//input[@id='txt-discount1-0']"));
			if(dis.isDisplayed()){
				dis.sendKeys(Keys.ENTER);	
			}
			else {
				dis.sendKeys(Keys.BACK_SPACE);
				dis.sendKeys(Discount);
				dis.sendKeys(Keys.ENTER);	
			}
			
		}
		// Secound Item
		@Test(priority=9)
		public void Code2() throws InterruptedException{
           if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-1']")).isEmpty()){
				
				WebElement ItemCode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-1']"));
				ItemCode.sendKeys(Keys.BACK_SPACE);
				ItemCode.sendKeys(ItemCode2);
				ItemCode.sendKeys(Keys.ENTER);
			}
			if(!driver.findElements(By.xpath("//input[@id='txt-tmp_barcode-1']")).isEmpty()){
				WebElement Barc = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-1']"));
				Barc.sendKeys(Keys.BACK_SPACE);
				Barc.sendKeys(BarCode2);
				Barc.sendKeys(Keys.ENTER);
				
			}
			
				WebElement prov = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-1']"));
				prov.sendKeys(Keys.SPACE);
				
				WebDriverWait wait = new WebDriverWait(driver, 5);
				WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
				Seritem.sendKeys(Item2);
				Thread.sleep(3000);
				Seritem.sendKeys(Keys.ENTER);
				
				System.out.println("item 2 selected sucessfully");
				
			}
		@Test(priority=10)
		public void Qty2(){
			if(!driver.findElements(By.xpath("//input[@id='txt-quantity-1']")).isEmpty()){
				WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-1']"));
				Qty.sendKeys(Keys.BACK_SPACE);
				Qty.sendKeys(Qty2);
				Qty.sendKeys(Keys.ENTER);
				 System.out.println("Multi unit is off");
			}
			else{
				System.out.println("multi unit on ");
				// only for two multi unit values
				
				 if(!driver.findElements(By.xpath("//input[@id='txt-unitFromEnteredValue-1']")).isEmpty()){
				WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-1']"));
				Qty1.sendKeys(Keys.BACK_SPACE);
				Qty1.sendKeys(Unit2);
				Qty1.sendKeys(Keys.ENTER);
				 }
				WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-1')]"));
				pcs.sendKeys(Keys.BACK_SPACE);
				pcs.sendKeys(Unit1);
				pcs.sendKeys(Keys.ENTER);
			}
			if(!driver.findElements(By.xpath("//input[@id='txt-free-1']")).isEmpty()){
				WebElement free = driver.findElement(By.xpath("//input[@id='txt-free-1']"));
				free.sendKeys(Keys.BACK_SPACE);
				free.sendKeys(Free);
				free.sendKeys(Keys.ENTER);
				
			}
		}
		@Test(priority=11)
		public void pur2Rate(){
			WebElement rate = driver.findElement(By.xpath("//input[@id='txt-salePurchaseRate-1']"));
			if(rate.isDisplayed()){
				rate.sendKeys(Keys.ENTER);
				System.out.println("Rate Not changed");
			}
			else{
				rate.sendKeys(Rate2);
				rate.sendKeys(Keys.ENTER);
				System.out.println("Rate Changed");
			}
		}
		@Test(priority=12)
		public void Dis2(){
			WebElement dis  = driver.findElement(By.xpath("//input[@id='txt-discount1-1']"));
			if(dis.isDisplayed()){
				dis.sendKeys(Keys.ENTER);
				System.out.println("Disc Not Changed");
			}
			else {
				dis.sendKeys(Keys.BACK_SPACE);
				dis.sendKeys(Discount2);
				dis.sendKeys(Keys.ENTER);	
				System.out.println("Disc Changed");
			}
			
		}
		@Test(priority=13)
		public void Save(){
			if(!driver.findElements(By.xpath("//*[contains(@id,'txtbillDiscountPercentage')]")).isEmpty()){
				WebElement BillDisPer = driver.findElement(By.xpath("//*[contains(@id,'txtbillDiscountPercentage')]"));
			      if(BillDisPer.isDisplayed()){
			    	  BillDisPer.sendKeys(Keys.ENTER);
			      }
			      else{
			    	  BillDisPer.sendKeys(Keys.BACK_SPACE);
			    	  BillDisPer.sendKeys(BillDisc);
			    	  BillDisPer.sendKeys(Keys.ENTER);
			      }
			      if(!driver.findElements(By.xpath("//*[contains(@id,'txtbillDiscountAmount')]")).isEmpty()){
			    	  WebElement BillAmount = driver.findElement(By.xpath("//*[contains(@id,'txtbillDiscountAmount')]"));
			    	  if(BillAmount.isDisplayed()){
			    		  BillAmount.sendKeys(Keys.ENTER);
			    	  }
			    	  else{
			    		  BillAmount.sendKeys(Keys.BACK_SPACE);
			    		  BillAmount.sendKeys(BillAmount1);
			    		  BillAmount.sendKeys(Keys.ENTER);
			    	  }
			      }
			      if(!driver.findElements(By.xpath("//*[contains(@id,'txt-ledgerLinkID')]")).isEmpty()){
			    	  WebElement Round = driver.findElement(By.xpath("//*[contains(@id,'txt-ledgerLinkID')]"));
			    	  Round.sendKeys(Keys.ENTER);
			    	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-percentage')]")).isEmpty()){
			    		  WebElement per = driver.findElement(By.xpath("//*[contains(@id,'txt-percentage')]"));
			    		  per.sendKeys(Keys.ENTER);
			    		  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-amount')]")).isEmpty()){
			    			  WebElement Amnt = driver.findElement(By.xpath("//*[contains(@id,'txt-amount')]"));
			    			  Amnt.sendKeys(Keys.ENTER);
			    			  
			    			  if(!driver.findElements(By.xpath("//*[contains(@id,'txtbillValue')]")).isEmpty()){
			    				  WebElement value = driver.findElement(By.xpath("//*[contains(@id,'txtbillValue')]"));
			    				  value.sendKeys(Keys.ENTER);
			    				
			    			  }
			    		  }
			    		  
			    	  }
			      }
			      
			     /* if(driver.findElement(By.xpath("//*[@id='txtcursorwaitonadditionaledger']/option[1]")).isSelected()){
			    	 
			      }*/
			      WebElement Sve = driver.findElement(By.xpath("//*[contains(@id,'btnSave')]"));
					Sve.click();
					Sve.sendKeys(Keys.F10);
					Sve.sendKeys(Keys.F10);
					
					
					WebElement msg=driver.findElement(By.xpath("//notifier-container[@class='notifier__container']"));
					String text=msg.getText();
					if (msg.isEnabled() && text.contains("Purchase order saved successfully"))
					{ 
					    System.out.println("Successfully completed");
					}else{
					    System.out.println(msg.getText());
					}
							    }
					//System.out.println("po saved Sucessfully");
			
				
			else{
			WebElement Sve = driver.findElement(By.xpath("//*[contains(@id,'btnSave')]"));
			Sve.click();
			Sve.sendKeys(Keys.F10);
			Sve.sendKeys(Keys.F10);
			
			WebElement msg=driver.findElement(By.xpath("//notifier-container[@class='notifier__container']"));
			String text=msg.getText();
			if (msg.isEnabled() && text.contains("Purchase order saved successfully"))
			{ 
			    System.out.println("Successfully completed");
			}else{
			    System.out.println(msg.getText());
			}
			///System.out.println("po saved Sucessfully");
			
		      }
		
		  }
		}
			 
 
	


