package AccTran;

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

public class Journal_New {
	WebDriver driver;
	WebDriverWait Wait;
	
	 public static Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
	    
	   
	    String user        =    reader.getCellData("ContraJounrl", "user", 2);
		String pass		   = 	reader.getCellData("ContraJounrl", "password", 2);
		String Companyname = 	reader.getCellData("ContraJounrl", "Company_name", 2);
		String ledgername  = 	reader.getCellData("ContraJounrl", "ledger_name", 2);
		String vono		   = 	reader.getCellData("ContraJounrl", "Vocher_No", 2);
		String ledser	   = 	reader.getCellData("ContraJounrl", "Led_Sel", 2);
		String DBA         = 	reader.getCellData("ContraJounrl", "Debit_Amt", 2);
		String Amount1     =    reader.getCellData("ContraJounrl", "Amount_1", 2);
		String invc        = 	reader.getCellData("ContraJounrl", "invoice_No", 2);
		String mode        =	reader.getCellData("ContraJounrl", "Rec_Mode", 2);
		String Crmt        = 	reader.getCellData("ContraJounrl", "Cr_Amount", 2);
		String shrtexes    =	reader.getCellData("ContraJounrl", "Sh_Exes", 2);
		String RefNo       =	reader.getCellData("ContraJounrl", "Ref_No", 2);
		String Drmt        = 	reader.getCellData("ContraJounrl", "Dr_Amount", 2);
		String ledser2     =	reader.getCellData("ContraJounrl", "Ledger_2", 2);
		String crd         =	reader.getCellData("ContraJounrl", "Cr_Dr", 2);
		String DR          =	reader.getCellData("ContraJounrl", "Dr_Cr", 2);
		String insty          =	reader.getCellData("ContraJounrl", "Inst_Type", 2);
		String insNo          =	reader.getCellData("ContraJounrl", "Inst_No", 2);
	    
	    @BeforeSuite
	    // web lauch    
		public void LaunchBrowser() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("http://172.16.8.17/margwebsite/QA");
			driver.manage().window().maximize();
			System.out.println("url opend Sucessfuly");
			
			//lmd = new Ledger_Master_Debtor();
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
			System.out.println("logined scuessfully");
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
				System.out.println("company Selected");
				Actions action = new Actions(driver);
				WebElement menu = driver.findElement(By.linkText("Accounting Trans."));
				action.moveToElement(menu).perform();
			    menu.sendKeys(Keys.ENTER);
				//menu.click();
				
				Thread.sleep(2000);
				WebElement submenu1 = driver.findElement(By.linkText("Journal"));
				action.moveToElement(submenu1).perform();
				submenu1.sendKeys(Keys.ENTER);
				//submenu1.click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("New")).click();
				System.out.println("Journal opened Sucessfully");
				
				Thread.sleep(5000);
		 }
	    @Test(priority=2)
	    public void date() throws InterruptedException{
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			 LocalDate date = LocalDate.now();
			 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'txtEntryDate')]")));
			 
			 Date.sendKeys(dtf.format(date));
			 System.out.println(dtf.format(date));
			 Thread.sleep(3000);
			 Date.sendKeys(Keys.ENTER);
			 System.out.println("system date entred");
			 
			///Thread.sleep(5000);
	    }
	    @Test(priority=3)
	    public void vochr(){
	    	WebElement voch = driver.findElement(By.xpath("//*[contains(@id,'txtVoucherNo')]"));
	    	
	    	if(voch.isDisplayed()){
	    		System.out.println(voch.getText());
	    		voch.sendKeys(Keys.ENTER);
	    		System.out.println("vocher No Exists");
	    	}
	    	else{
	    		voch.sendKeys(vono);
	    		voch.sendKeys(Keys.ENTER);
	    		System.out.println("vocher No not Exists");
	    	}
	    }
	    @Test(priority=4)
	    public void seledger() throws InterruptedException{
	    	/*Select Cr = new Select(driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-0']")));
	    	Cr.selectByVisibleText(DR);*/
	    	/*WebElement drselc = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-0']"));
	    	drselc.sendKeys(Keys.ENTER);*/
	        Select led = new Select(driver.findElement(By.xpath("//*[@id='mrgSearchBox']")));
	    	led.selectByVisibleText(ledser);
	    	if(driver.findElement(By.xpath("//option[contains(text(),'Dr')]")).isSelected()){
	    	 // Name
	    		WebElement drselc = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-0']"));
		    	drselc.sendKeys(Keys.ENTER);
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
	        // CR selection
	        else if(driver.findElement(By.xpath("//option[contains(text(),'Cr')]")).isSelected()){
	        	WebElement drselc = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-0']"));
		    	drselc.sendKeys(Keys.ENTER);
	        	if(driver.findElement(By.xpath("//*[@id='mrgSearchBox']/option[2]")).isDisplayed()){
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
		 			System.out.println("ledger Serched by Name");
		 			
		        }
		        // Code
		        else  if(driver.findElement(By.xpath("//option[contains(text(),'Code')]")).isSelected()){
		          	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
		   			//textbox.clear();
		   		    Thread.sleep(2000);
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
	    }
	    
	    @Test(priority=5)
	    public void instTy(){
	    	if(!driver.findElements(By.xpath("//select[@id='drp-instype-0']")).isEmpty()){
	    		Select iins = new Select(driver.findElement(By.xpath("//select[@id='drp-instype-0']")));
	    		iins.selectByVisibleText(insty);
	    		WebElement ins = driver.findElement(By.xpath("//select[@id='drp-instype-0']"));
	    		ins.sendKeys(Keys.ENTER);
	    	}
	    	if(!driver.findElements(By.xpath("//input[@id='txt-insno-0']")).isEmpty()){
	    	WebElement instNo = driver.findElement(By.xpath("//input[@id='txt-insno-0']"));
	    	if(instNo.isDisplayed()){
	    		instNo.sendKeys(Keys.ENTER);
	    		System.out.println("inst no exist");
	    	}
	    	else{
	    		instNo.sendKeys(insNo);
	    		instNo.sendKeys(Keys.ENTER);
	    	}
	    }}
	    @Test(priority=6)
	    public void DebitAmount(){
	    	if(!driver.findElements(By.xpath("//input[@id='txt-drAmount-0']")).isEmpty()){
	    		WebElement DBamount = driver.findElement(By.xpath("//input[@id='txt-drAmount-0']"));
	        	//String dt = DBamount.getText();
	        	//if(DBamount.getSize().equals(0)){.
	        	if(DBamount.isDisplayed()){
	        		DBamount.sendKeys(DBA);
	        		DBamount.sendKeys(Keys.ENTER);
	        	}
	        	else{
	        		
	        		DBamount.sendKeys(Keys.ENTER);
	        	}
	        	
	    	}
	    	else{
	    	WebElement DBamount = driver.findElement(By.xpath("//input[@id='txt-crAmount-0']"));
	    	//String dt = DBamount.getText();
	    	//if(DBamount.getSize().equals(0)){.
	    	if(DBamount.isDisplayed()){
	    		DBamount.sendKeys(DBA);
	    		DBamount.sendKeys(Keys.ENTER);
	    	}
	    	else{
	    		
	    		DBamount.sendKeys(Keys.ENTER);
	    	}
	    	
	    }
	    }
	    @Test(priority=7)
	    public void adjustment() throws InterruptedException{
	    if(!driver.findElements(By.xpath("//select[@id='drpRefType']")).isEmpty()){
	        if(driver.findElement(By.xpath("//option[contains(text(),'Advance')]")).isSelected()){
   		      Thread.sleep(2000);
	    		WebElement Ref = driver.findElement(By.xpath("//input[@id='txt-cus_invoiceNo-0']"));
	    		Ref.sendKeys(RefNo);
	    		Ref.sendKeys(Keys.ENTER);
	    		
	    		WebElement Adja = driver.findElement(By.xpath("//input[@id='txt-adjustmentAmount-0']"));
	    		Adja.sendKeys(Keys.ENTER);
	    		
	    	}
   	      else if(driver.findElement(By.xpath("//option[contains(text(),'Agst Ref')]")).isSelected()){
   	      String checkboxes = "//*[@id='billAdjustmentGrid']/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]";
			List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
			for (WebElement AllCheck : elementToClick) {
			    AllCheck.click();
			    
    	}
			
			WebElement Adjamnt = driver.findElement(By.xpath("//input[@id='txt-adjustmentAmount-0']"));
			if(Adjamnt.isDisplayed()){
				Adjamnt.sendKeys(DBA);
	 			Adjamnt.sendKeys(Keys.ENTER);
			}
			else{
				Adjamnt.sendKeys(Keys.ENTER);
			}		
    }
   	
   	}}
	    @Test(priority=8)
	    public void SecondRow() throws InterruptedException{
	    	/*WebElement dcr = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-1']"));
	    	dcr.sendKeys(Keys.ENTER);*/
	    	if(driver.findElement(By.xpath("//option[contains(text(),'Dr')]")).isSelected()){
	    		WebElement cr = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-1']"));
	        	cr.sendKeys(Keys.ENTER);
	    		Select led = new Select(driver.findElement(By.xpath("//*[@id='mrgSearchBox']")));
	        	led.selectByVisibleText(ledser);
	        	Thread.sleep(2000);
	        	 // Name
	            if(driver.findElement(By.xpath("//option[contains(text(),'Name')]")).isSelected()){
	            	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
	     			//textbox.clear();
	     		    Thread.sleep(2000);
	     			textbox.sendKeys(ledser2);
	     			Thread.sleep(2000);
	     			//driver.findElement(By.xpath("//*[text()='Vamsi Debit']")).click();
	     			//WebElement ledserh = driver.findElement(By.xpath("//*[contains(@id,'ledgerGrid')]"));
	     			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'ledgerGrid')]"));
	     			
	     			int count=allOptions.size();
	     			System.out.println("No.of Autosuggesion "+count);
	     			System.out.println("List of Autosuggesion");
	     			for(int i=0;i<count;i++){
	     				String text = allOptions.get(i).getText();
	     				System.out.println(text);	
	     			}
	     			//textbox.sendKeys(Keys.ARROW_DOWN);
	     			textbox.sendKeys(Keys.ENTER);
	     			/*if(ledserh.equals(allOptions.indexOf(1))){
	     				//ledserh.sendKeys(Keys.ARROW_DOWN);
	     				ledserh.sendKeys(Keys.ENTER);
	     				
	     			}
	     			else{
	     				ledserh.sendKeys(Keys.F2);
	     				
	     			}
	     			*/
	     			System.out.println("ledger Serched by Name");
	     			
	            }
	            //code
	            else  if(driver.findElement(By.xpath("//option[contains(text(),'Code')]")).isSelected()){
	           	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
	    			//textbox.clear();
	    		    Thread.sleep(2000);
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
	    			System.out.println("ledger Serched by Mobile");
	    			
	        }
	          //mobile
	            else if(driver.findElement(By.xpath("//option[contains(text(),'Mobile')]")).isSelected()){
	           	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
	    			//textbox.clear();
	    		    Thread.sleep(2000);
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
	    			System.out.println("ledger Serched by DL No.");
	    			

	    }
	         // DL.No
	            else if(driver.findElement(By.xpath("//option[contains(text(),'D.L. No.')]")).isSelected()){
	           	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
	    			//textbox.clear();
	    		    Thread.sleep(2000);
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
	    			System.out.println("ledger Serched by Address");
	    			
	            }
	            // Address
	            else if(driver.findElement(By.xpath("//option[contains(text(),'Address')]")).isSelected()){
	           	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
	    			//textbox.clear();
	    		    Thread.sleep(2000);
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
	    			System.out.println("ledger Serched by GSTIN");
	        }
	      
	    	
	    	//GStin
	    	else if(driver.findElement(By.xpath("//option[contains(text(),'GSTIN')]")).isSelected()){
	          	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
	   			//textbox.clear();
	   		    Thread.sleep(2000);
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
	   			System.out.println("ledger Serched by GSTIN");
	       }
	     
	    	
	    }// For CR
	    	 else if(driver.findElement(By.xpath("//option[contains(text(),'Cr')]")).isSelected()){
	    		WebElement cr = driver.findElement(By.xpath("//select[@id='drp-creditOrDebit-1']"));
	    	    cr.sendKeys(Keys.ENTER);
	    	   Select led = new Select(driver.findElement(By.xpath("//*[@id='mrgSearchBox']")));
	    	   led.selectByVisibleText(ledser);
	    	    	
	    		 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
	  			//textbox.clear();
	  		    Thread.sleep(2000);
	  			textbox.sendKeys(ledser2);
	  			Thread.sleep(2000);
	  			//driver.findElement(By.xpath("//*[text()='Vamsi Debit']")).click();
	  			
	  			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id='ledgerGrid']/div/div[1]/div/div[3]"));
	  			
	  			int count=allOptions.size();
	  			System.out.println("No.of Autosuggesion "+count);
	  			System.out.println("List of Autosuggesion");
	  			for(int i=0;i<count;i++){
	  				String text = allOptions.get(i).getText();
	  				System.out.println(text);	
	  			}
	  			//textbox.sendKeys(Keys.ARROW_DOWN);
	  			textbox.sendKeys(Keys.ENTER);
	  			
	  			
	  			// Future implementation 
	  		/* String typedValue = textbox.getAttribute("value");
	  			System.out.println(allOptions);
	  			System.out.println(typedValue);
	  			System.out.println(allOptions.contains(typedValue));
	  			for(int i=0 ;i<allOptions.size();i++){
	  				
	  				System.out.println(allOptions.get(i).getText().equals(typedValue));
	  			 // if(allOptions.get(i).getText().equals(typedValue)){
	  			if(typedValue.equals(allOptions.indexOf(0))){
	  				//ledserh.sendKeys(Keys.ARROW_DOWN);
	  				
	  				textbox.sendKeys(Keys.ENTER);
	  				System.out.println("ledger is avliable");
	  				
	  			}
	  			
	  			
	  			else{
	  				textbox.sendKeys(Keys.F2);
	  				System.out.println("have to create new ledger");
	  				
	  				break;
	  			}}*/
	  			
	  			System.out.println("ledger Serched by Name");
	  			
	         }
	         //code
	         else  if(driver.findElement(By.xpath("//option[contains(text(),'Code')]")).isSelected()){
	        	 WebElement textbox = driver.findElement(By.xpath("//input[@id='SearchBox']"));
	 			//textbox.clear();
	 		    Thread.sleep(2000);
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
	 			System.out.println("ledger Serched by Mobile");
	 			
	     }
	       //mobile
	         else if(driver.findElement(By.xpath("//option[contains(text(),'Mobile')]")).isSelected()){
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
	 			System.out.println("ledger Serched by DL No.");
	 			

	 }
	      // DL.No
	         else if(driver.findElement(By.xpath("//option[contains(text(),'D.L. No.')]")).isSelected()){
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
	 			System.out.println("ledger Serched by Address");
	 			
	         }
	         // Address
	         else if(driver.findElement(By.xpath("//option[contains(text(),'Address')]")).isSelected()){
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
	 			System.out.println("ledger Serched by GSTIN");
	     }
	   
	 	
	 	//GStin
	 	else if(driver.findElement(By.xpath("//option[contains(text(),'GSTIN')]")).isSelected()){
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
				System.out.println("ledger Serched by GSTIN");
	    }
		}
	    @Test(priority=9)
	    public void inst2(){
	    	if(!driver.findElements(By.xpath("//select[@id='drp-instype-1']")).isEmpty()){
	    		Select iins = new Select(driver.findElement(By.xpath("//select[@id='drp-instype-1']")));
	    		iins.selectByVisibleText(insty);
	    		WebElement ins = driver.findElement(By.xpath("//select[@id='drp-instype-1']"));
	    		ins.sendKeys(Keys.ENTER);
	    	}
	    	if(!driver.findElements(By.xpath("//input[@id='txt-insno-0']")).isEmpty()){
	    	WebElement instNo = driver.findElement(By.xpath("//input[@id='txt-insno-1']"));
	    	if(instNo.isDisplayed()){
	    		instNo.sendKeys(Keys.ENTER);
	    		System.out.println("inst no exist");
	    	}
	    	else{
	    		instNo.sendKeys(insNo);
	    		instNo.sendKeys(Keys.ENTER);
	    	}
	    }	
	    }
	   
	    @Test(priority=10)
	    public void Amnt(){
	    	if(!driver.findElements(By.xpath("//input[@id='txt-drAmount-1']")).isEmpty()){
	    		WebElement DBamount = driver.findElement(By.xpath("//input[@id='txt-drAmount-1']"));
	        	//String dt = DBamount.getText();
	        	//if(DBamount.getSize().equals(0)){.
	        	if(DBamount.isDisplayed()){
	        		DBamount.sendKeys(DBA);
	        		DBamount.sendKeys(Keys.ENTER);
	        	}
	        	else{
	        		
	        		DBamount.sendKeys(Keys.ENTER);
	        	}
	        	
	    	}
	    	else{
	    	WebElement DBamount = driver.findElement(By.xpath("//input[@id='txt-crAmount-1']"));
	    	//String dt = DBamount.getText();
	    	//if(DBamount.getSize().equals(0)){.
	    	if(DBamount.isDisplayed()){
	    		DBamount.sendKeys(DBA);
	    		DBamount.sendKeys(Keys.ENTER);
	    	}
	    	else{
	    		
	    		DBamount.sendKeys(Keys.ENTER);
	    	}
	    	
	    }
	    }
	    @Test(priority=11)
	    public void cradjust() throws InterruptedException{
	    	if(!driver.findElements(By.xpath("//select[@id='drpRefType']")).isEmpty()){
		        if(driver.findElement(By.xpath("//option[contains(text(),'Advance')]")).isSelected()){
	   		      Thread.sleep(2000);
		    		WebElement Ref = driver.findElement(By.xpath("//input[@id='txt-cus_invoiceNo-0']"));
		    		Ref.sendKeys(RefNo);
		    		Ref.sendKeys(Keys.ENTER);
		    		
		    		WebElement Adja = driver.findElement(By.xpath("//input[@id='txt-adjustmentAmount-0']"));
		    		Adja.sendKeys(Keys.ENTER);
		    		
		    	}
	   	 else if(driver.findElement(By.xpath("//option[contains(text(),'Agst Ref')]")).isSelected()){
	   	    String checkboxes = "//*[@id='billAdjustmentGrid']/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]";
				List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
				for (WebElement AllCheck : elementToClick) {
				    AllCheck.click();
				    
	    	}
				
				WebElement Adjamnt = driver.findElement(By.xpath("//input[@id='txt-adjustmentAmount-0']"));
				if(Adjamnt.isDisplayed()){
					Adjamnt.sendKeys(DBA);
		 			Adjamnt.sendKeys(Keys.ENTER);
				}
				else{
					Adjamnt.sendKeys(Keys.ENTER);
				}		
	    }
	   	
	   	}
	    	
	    }
	    @Test(priority=12)
    	
	    	public void nartion(){
		    	WebElement nrt = driver.findElement(By.xpath("//*[contains(@id,'txtRemark')]"));
		    	//nrt.getText();
		    	String rem = nrt.getText();
		    	System.out.println(rem);
		    	nrt.sendKeys(Keys.ENTER);
		    }
	    @Test(priority=13)
	    public void savr(){
	    	WebElement sav = driver.findElement(By.xpath("//*[contains(@id,'save')]"));
	     	   sav.click();
	     	  // sav.sendKeys(Keys.F10);
    	}
	    
	    }









