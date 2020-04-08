package Returns_Sale_Purchase;

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

public class Sale_Credit_Note_New {

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
		String batch1      =	reader.getCellData("Sale", "Batch_Item", 2);
		String ledser	   = 	reader.getCellData("Sale", "Led_Sel", 2);
		String RetBill	   = 	reader.getCellData("Sale", "Return_Bill", 2);
		
		
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
				
				WebElement submenu1 = driver.findElement(By.linkText("Sale Return"));
				action.moveToElement(submenu1).perform();
				submenu1.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
				 WebElement challan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Credit Note")));
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
			  // Thread.sleep(3000);
			  /* // WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
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
				textbox.sendKeys(Keys.ENTER);*/
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
			
			
			/* if(driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]")).isDisplayed());{
				 WebElement led =driver.findElement(By.xpath("//*[contains(@id,'txtLedgerName')]"));
				    led.sendKeys(Keys.BACK_SPACE);
				    led.sendKeys(Keys.SPACE);*/
			 }

		 //)
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
				//PId.sendKeys(Keys.ENTER);
				}
	}
		@Test(priority=4)
		public void Patientid() throws InterruptedException{
			WebElement PId = driver.findElement(By.xpath("//*[contains(@id,'txtptmobile')]"));
			
			if(PId.isDisplayed()){
				PId.sendKeys(PatientId);
				PId.sendKeys(Keys.ENTER);
				//PId.sendKeys(Keys.ENTER);
				System.out.println("patient enterd ");
				//Thread.sleep(5000);	
			}
			else{
			//PId.clear();
			
			
			PId.sendKeys(Keys.ENTER);
			System.out.println("patient exist");
		}
			}
		@Test(priority=5)
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
		@Test(priority=6)
		public void Billdetails() throws InterruptedException{
			if(!driver.findElements(By.xpath("//div[@class='modal-content']")).isEmpty()){
			//if(!driver.findElements(By.xpath("//select[@id='returnOfBill']")).isEmpty()){
				Select det = new Select(driver.findElement(By.xpath("//select[@id='returnOfBill']")));
				det.selectByVisibleText(RetBill);
				Thread.sleep(2000);
				
				WebElement details = driver.findElement(By.xpath("//select[@id='returnOfBill']"));
				details.sendKeys(Keys.ENTER);
				if(driver.findElement(By.xpath("//option[contains(text(),'Single')]")).isSelected()){
					WebElement billno = driver.findElement(By.xpath("//input[@id='txtbillNo']"));
					if(billno.isDisplayed()){
						billno.sendKeys(Keys.ENTER);
					}
					else {
						billno.clear();
						billno.sendKeys("0001");
					    billno.sendKeys(Keys.ENTER);
					}
					 WebElement ok = driver.findElement(By.xpath("//button[@id='ok']"));
					 ok.click();
				}
				else if(driver.findElement(By.xpath("//option[contains(text(),'Manual')]")).isSelected()){
					WebElement ok = driver.findElement(By.xpath("//button[@id='ok']"));
					 ok.click();
				}
			}
		}
		@Test(priority=7)
		public void bilload() throws InterruptedException{
			
			if(!driver.findElements(By.xpath("//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']")).isEmpty()){
				String checkboxes = "//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
				List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
				for (WebElement AllCheck : elementToClick) {
				    AllCheck.click();
			}
				WebElement sv = driver.findElement(By.xpath("//button[@id='btn-Close']"));
				sv.click();
				
				
				WebElement end = driver.findElement(By.xpath("//*[contains(@id,'btnSave')]"));
				end.click();
				//end.sendKeys(Keys.F10);
			
		}
			/// manul condition
			else {
				//barcode
			if(!driver.findElements(By.xpath("//input[@id='txt-tmp_barcode-0']")).isEmpty()){
				WebElement bar = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-0']"));
				bar.sendKeys(BarCode);
				bar.sendKeys(Keys.ENTER);
			}
//			item code
			if(!driver.findElements(By.xpath("//input[@id='txt-cus_itemCode-0']")).isEmpty()){
				WebElement Icode = driver.findElement(By.xpath("//input[@id='txt-cus_itemCode-0']"));
				Icode.sendKeys(ItemCode1);
				Icode.sendKeys(Keys.ENTER);
				
			}
			
			
			// pro selection in 0 row for mannul billing
			if(!driver.findElements(By.xpath("//input[@id='txt-itemLinkID-0']")).isEmpty()){
				WebElement ManItem = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-0']"));
				ManItem.sendKeys(Keys.ENTER);
				// Serch by discription
				if(driver.findElement(By.xpath("//option[contains(text(),'Description')]")).isSelected()){
					WebElement itemS = driver.findElement(By.xpath("//input[@id='searchItems']"));
					itemS.sendKeys(Item1);
					itemS.sendKeys(Keys.ENTER);
				}
				// Serch  by barcode
				else if(driver.findElement(By.xpath("//option[contains(text(),'Barcode')]")).isSelected()){
					WebElement itemS = driver.findElement(By.xpath("//input[@id='searchItems']"));
					itemS.sendKeys(BarCode);
					itemS.sendKeys(Keys.ENTER);
				}
				// serch by Itemcode
				else if(driver.findElement(By.xpath("//option[contains(text(),'Itemcode')]")).isSelected()){
					WebElement itemS = driver.findElement(By.xpath("//input[@id='searchItems']"));
					itemS.sendKeys(ItemCode1);
					itemS.sendKeys(Keys.ENTER);
				}
				Thread.sleep(2000);
				/// QTY selection
				if(!driver.findElements(By.xpath("//input[@id='txt-quantity-0']")).isEmpty()){
					WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-0']"));
					Qty.sendKeys(Keys.BACK_SPACE);
					Qty.sendKeys(Qty1);
					Qty.sendKeys(Keys.ENTER);
				}
				else{
					// unit 2
					if(!driver.findElements(By.xpath("//input[@id='txt-unitFromEnteredValue-0']")).isEmpty()){
					WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-0']"));
					Qty1.sendKeys(Keys.BACK_SPACE);
					Qty1.sendKeys(Unit2);
					Qty1.sendKeys(Keys.ENTER);
					}
					//unit1
					if(!driver.findElements(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-0')]")).isEmpty()){
					WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-0')]"));
					pcs.sendKeys(Keys.BACK_SPACE);
					pcs.sendKeys(Unit1);
					pcs.sendKeys(Keys.ENTER);
				}
					}
				// free
				if(!driver.findElements(By.xpath("//input[@id='txt-free-2']")).isEmpty()){
					WebElement free = driver.findElement(By.xpath("//input[@id='txt-free-0']"));
					free.sendKeys(Keys.BACK_SPACE);
					free.sendKeys(Free);
					free.sendKeys(Keys.ENTER);
					
				}
				
				
				//// rate
				WebElement rate = driver.findElement(By.xpath("//input[@id='txt-salePurchaseRate-0']"));
				//String Ra = rate.getText();
				
				if (rate.isDisplayed()){
					WebElement entrrate = driver.findElement(By.id("txt-salePurchaseRate-0"));
					//entrrate.sendKeys(Keys.BACK_SPACE);
					entrrate.sendKeys(Rate1);
					entrrate.sendKeys(Keys.ENTER);
						
						
					}
					else{
						WebElement entrrate = driver.findElement(By.id("txt-salePurchaseRate-0"));
						entrrate.sendKeys(Keys.ENTER);
					}
						
					
					Thread.sleep(5000);
				
					//List<WebElement> disc1 = driver.findElements(By.xpath("//input[@id='txt-discount1-3']"));
					WebElement disc = driver.findElement(By.xpath("//input[@id='txt-discount1-0']"));
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
			WebElement sav = driver.findElement(By.xpath("//*[contains(@id,'btnSave')]"));
			sav.click();
                }
			}
		}





















