package Inventory_Transaction;

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

public class Purchase_challan_new {
	
	//public Sale_Challan_New scn;
	
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
	String Challanno   = 	reader.getCellData("purchase", "Order_No", 2);
	//String Challanno   = 	reader.getCellData("purchase", "Order_No", 2);
	String PenOrd	   =	reader.getCellData("purchase", "pending_Order", 2);
	String ItemCode1   =	reader.getCellData("purchase", "Item_Code", 2);
	String ItemCode2   =	reader.getCellData("purchase", "Item_Code", 3);
	String BarCode     =	reader.getCellData("purchase", "Bar_Code", 2);
	String BarCode2     =	reader.getCellData("purchase", "Bar_Code", 3);
	String Item1       =    reader.getCellData("purchase", "Item_1", 2);
	String Item2       =    reader.getCellData("purchase", "Item_1", 3);
	String PurchaseTy    =	reader.getCellData("purchase", "Pur_Type", 2);
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
	String BillAmount1 =	reader.getCellData("purchase", "Bill_Amount", 3);
	String Free        =	reader.getCellData("purchase", "Free_Qty", 2);
	String LSertype    =	reader.getCellData("purchase", "Serch_Led_By", 2);
	
	

	@BeforeSuite
	 public void webLaunch() {
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("http://172.16.8.17/margwebsite/QA");
			driver.manage().window().maximize();
			System.out.println("url opend Sucessfuly");
		}
	@BeforeTest
	 public void login() {
		driver.findElement(By.xpath("//a[@class='nav-link login']")).click();
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
			
			System.out.println("company Selected sucessfully");
			/*WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			pass.sendKeys("1234");
			pass.sendKeys(Keys.ENTER);*/
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Inventory Trans."));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Purchase"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("New Challan")).click();
			System.out.println("purchase challan opend Sucessfully");
	 }
	@Test(priority=2)
	 public void createPc() throws InterruptedException{
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
	public void challanNo(){
		WebElement chnNo = driver.findElement(By.xpath("//*[contains(@id,'txtentryNo')]"));
		//Dimension countC = chnNo.getSize();
		if(chnNo.getSize().equals(1)){
			chnNo.sendKeys(Keys.ENTER);
		}
		else{
			chnNo.sendKeys(Challanno);
			chnNo.sendKeys(Keys.ENTER);
			
		}
		
	}
	@Test(priority=5)
	public void store(){
		if(!driver.findElements(By.xpath("//*[contains(@id,'txtStore')]")).isEmpty()){
			WebElement str = driver.findElement(By.xpath("//*[contains(@id,'txtStore')]"));
			str.sendKeys(Keys.ENTER);
		}
	}
  @Test(priority=6)
  public void Purtype() throws InterruptedException{
	  if(driver.findElement(By.xpath("//*[@id='txtisPurchaseTypeForBilling']/option[1]")).isSelected()){
		  WebElement pendorder = driver.findElement(By.xpath("//input[@id='SearchBox']"));
		  //pendorder.sendKeys(PenOrd);
		  
	  }
	  else if(driver.findElement(By.xpath("//*[@id='txtisPurchaseTypeForBilling']/option[2]")).isSelected()){
		  WebElement purtp = driver.findElement(By.xpath("//*[contains(@id,'txtSaleType')]"));
		  purtp.sendKeys(Keys.ENTER);
		  
		  /*WebElement SerchType = driver.findElement(By.xpath("//input[@id='SearchBox']"));
		   //SerchType.sendKeys(PurchaseTy);
		  Thread.sleep(3000);
		  SerchType.sendKeys(Keys.ENTER);*/
	  }
	  
  }
  @Test(priority=7)
  public void pendingor() throws InterruptedException{
	  if(!driver.findElements(By.xpath("//input[@id='SearchBox']")).isEmpty()){
		  WebElement pendorder = driver.findElement(By.xpath("//input[@id='SearchBox']"));
		  pendorder.sendKeys(PenOrd);
		  // pending order Check
		  Thread.sleep(3000);
		  String checkboxes = "//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
			List<WebElement> elementToClick = driver.findElements(By.xpath(checkboxes));
			for (WebElement AllCheck : elementToClick) {
			    AllCheck.click();
			}
			
			
			WebElement esc = driver.findElement(By.xpath("//button[@id='btn-Close']"));
			esc.click();
			Thread.sleep(5000);
			
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
		}
	  }
  @Test(priority=8)
  public void itemCode(){
	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-cus_itemCode-0')]")).isEmpty()){
		  WebElement iCode = driver.findElement(By.xpath("//*[contains(@id,'txt-cus_itemCode-0')]"));
		  iCode.sendKeys(ItemCode1);  
		  iCode.sendKeys(Keys.ENTER);
		  System.out.println("searched with Code");
	  }
	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-cus_itemCode-1')]")).isEmpty()){
		  WebElement iCode = driver.findElement(By.xpath("//*[contains(@id,'txt-cus_itemCode-1')]"));
		  iCode.sendKeys(ItemCode1);  
		  iCode.sendKeys(Keys.ENTER);
		  System.out.println("searched with Code");
	  }
	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-cus_itemCode-2')]")).isEmpty()){
		  WebElement iCode = driver.findElement(By.xpath("//*[contains(@id,'txt-cus_itemCode-2')]"));
		  iCode.sendKeys(ItemCode1);  
		  iCode.sendKeys(Keys.ENTER);
		  System.out.println("searched with Code");
	  }
	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-cus_itemCode-3')]")).isEmpty()){
		  WebElement iCode = driver.findElement(By.xpath("//*[contains(@id,'txt-cus_itemCode-3')]"));
		  iCode.sendKeys(ItemCode1);  
		  iCode.sendKeys(Keys.ENTER);
		  System.out.println("searched with Code");
	  }
	  else{
	  System.out.println("code not avilble");
	  }
	  if(!driver.findElements(By.xpath("//input[@id='txt-tmp_barcode-0']")).isEmpty()){
		  WebElement BCode = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-0']"));
		  BCode.sendKeys(BarCode);
		  BCode.sendKeys(Keys.ENTER); 
		  System.out.println("searched with BarCode row 0");
	  }
	  if(!driver.findElements(By.xpath("//input[@id='txt-tmp_barcode-1']")).isEmpty()){
		  WebElement BCode = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-1']"));
		  BCode.sendKeys(BarCode);
		  BCode.sendKeys(Keys.ENTER); 
		  System.out.println("searched with BarCode row 1");
	  }
	  
	  if(!driver.findElements(By.xpath("//input[@id='txt-tmp_barcode-2']")).isEmpty()){
		  WebElement BCode = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-2']"));
		  BCode.sendKeys(BarCode);
		  BCode.sendKeys(Keys.ENTER); 
		  System.out.println("searched with BarCode Row 2");
	  }
	  if(!driver.findElements(By.xpath("//input[@id='txt-tmp_barcode-3']")).isEmpty()){
		  WebElement BCode = driver.findElement(By.xpath("//input[@id='txt-tmp_barcode-3']"));
		  BCode.sendKeys(BarCode);
		  BCode.sendKeys(Keys.ENTER); 
		  System.out.println("searched with BarCode Row 3");
	  }
	  else {
		  
	  } System.out.println("Barcode not avilble");
  
  }
  @Test(priority=9)
  public void itemSelect() throws InterruptedException{
	  // Row 0
	    if(!driver.findElements(By.xpath("//input[@id='txt-itemLinkID-0']")).isEmpty()){
	    WebElement prov = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-0']"));
		prov.sendKeys(Keys.SPACE);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
		Seritem.sendKeys(Item1);
		Thread.sleep(3000);
		Seritem.sendKeys(Keys.ENTER);
		System.out.println("item selected sucessfully roe 0");
	  }// Row 1
	  if(!driver.findElements(By.xpath("//input[@id='txt-itemLinkID-1']")).isEmpty()){
		    WebElement prov = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-1']"));
			prov.sendKeys(Keys.SPACE);
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
			Seritem.sendKeys(Item1);
			Thread.sleep(3000);
			Seritem.sendKeys(Keys.ENTER);
			
			System.out.println("item selected sucessfully row 1");
		  }
	  // Row 2
	  if(!driver.findElements(By.xpath("//input[@id='txt-itemLinkID-2']")).isEmpty()){
		    WebElement prov = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-2']"));
			prov.sendKeys(Keys.SPACE);
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
			Seritem.sendKeys(Item1);
			Thread.sleep(3000);
			Seritem.sendKeys(Keys.ENTER);
			
			System.out.println("item selected sucessfully row 2");
		  }
	  if(!driver.findElements(By.xpath("//input[@id='txt-itemLinkID-3']")).isEmpty()){
		    WebElement prov = driver.findElement(By.xpath("//input[@id='txt-itemLinkID-3']"));
			prov.sendKeys(Keys.SPACE);
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
			Seritem.sendKeys(Item1);
			Thread.sleep(3000);
			Seritem.sendKeys(Keys.ENTER);
			System.out.println("item selected sucessfully row 3");
	  }
  }
  @Test(priority=10)
  public void  quaty(){
	  if(!driver.findElements(By.xpath("//*[@id='txt-quantity-0']")).isEmpty()){
			WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-0']"));
			//Qty.sendKeys(Keys.BACK_SPACE);
			Qty.sendKeys(Qty1);
			Qty.sendKeys(Keys.ENTER);
		}
		else{
			WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-0']"));
			//Qty1.sendKeys(Keys.BACK_SPACE);
			Qty1.sendKeys(Unit2);
			Qty1.sendKeys(Keys.ENTER);
			
			WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-0')]"));
			//pcs.sendKeys(Keys.BACK_SPACE);
			pcs.sendKeys(Unit1);
			pcs.sendKeys(Keys.ENTER);
		}
	  
	  // Row 1
	  
	  if(!driver.findElements(By.xpath("//*[@id='txt-quantity-1']")).isEmpty()){
			WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-1']"));
			//Qty.sendKeys(Keys.BACK_SPACE);
			Qty.sendKeys(Qty1);
			Qty.sendKeys(Keys.ENTER);
		}
		else{
			WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-']"));
			//Qty1.sendKeys(Keys.BACK_SPACE);
			Qty1.sendKeys(Unit2);
			Qty1.sendKeys(Keys.ENTER);
			
			WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-1')]"));
			//pcs.sendKeys(Keys.BACK_SPACE);
			pcs.sendKeys(Unit1);
			pcs.sendKeys(Keys.ENTER);
		}
	  //row 2
	  if(!driver.findElements(By.xpath("//*[@id='txt-quantity-2']")).isEmpty()){
			WebElement Qty = driver.findElement(By.xpath("//input[@id='txt-quantity-2']"));
			//Qty.sendKeys(Keys.BACK_SPACE);
			Qty.sendKeys(Qty1);
			Qty.sendKeys(Keys.ENTER);
		}
		else{
			WebElement Qty1 = driver.findElement(By.xpath("//input[@id='txt-unitFromEnteredValue-2']"));
			//Qty1.sendKeys(Keys.BACK_SPACE);
			Qty1.sendKeys(Unit2);
			Qty1.sendKeys(Keys.ENTER);
			
			WebElement pcs = driver.findElement(By.xpath("//*[contains(@id,'txt-unitToEnteredValue-2')]"));
			//pcs.sendKeys(Keys.BACK_SPACE);
			pcs.sendKeys(Unit1);
			pcs.sendKeys(Keys.ENTER);
		}
	  // row 3
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
	  

	  
  }
  @Test(priority=11)
  public void free(){
	  //row 0
	  
	  
	  
	  
	  
	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-free-0')]")).isEmpty()){
		  WebElement free0 = driver.findElement(By.xpath("//*[contains(@id,'txt-free-0')]"));
		  free0.sendKeys(Keys.BACK_SPACE);
		  free0.sendKeys(Free);
		  free0.sendKeys(Keys.ENTER);
		  System.out.println("row 0");
	  }
	  //  row 1
	  
	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-free-1')]")).isEmpty()){
		  WebElement free0 = driver.findElement(By.xpath("//*[contains(@id,'txt-free-1')]"));
		  free0.sendKeys(Keys.BACK_SPACE);
		  free0.sendKeys(Free);
		  free0.sendKeys(Keys.ENTER);
		  System.out.println("row 1");
	  }
	  // row2
	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-free-2')]")).isEmpty()){
		  WebElement free0 = driver.findElement(By.xpath("//*[contains(@id,'txt-free-2')]"));
		  free0.sendKeys(Keys.BACK_SPACE);
		  free0.sendKeys(Free);
		  free0.sendKeys(Keys.ENTER);
		  System.out.println("row 2");
	  }
	  // row 3
	  if(!driver.findElements(By.xpath("//*[contains(@id,'txt-free-3')]")).isEmpty()){
		  WebElement free0 = driver.findElement(By.xpath("//*[contains(@id,'txt-free-3')]"));
		  free0.sendKeys(Keys.BACK_SPACE);
		  free0.sendKeys(Free);
		  free0.sendKeys(Keys.ENTER);
		  System.out.println("row 3");
	  }
	  
	  
	  
	  
		}
  }
  
  
















