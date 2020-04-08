package InventoryMaster;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
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

import com.margerp.qa.xls_Reader.Xls_Reader;
// Item Data need to send from EXEl Sheet
public class Item_Mater_New {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
    
    String user        = 	reader.getCellData("Item", "user", 2);
	String pass 	   = 	reader.getCellData("Item", "password", 2);
	String Companyname = 	reader.getCellData("Item", "Company_name", 2);
	String Itemcode	   = 	reader.getCellData("Item", "Item_Code", 2);
	String Barcode 	   = 	reader.getCellData("Item", "Bar_Code", 2);
	String ProName     =  	reader.getCellData("Item", "Pro_Name", 2);
	String Goods	   =	reader.getCellData("Item", "Good_Drp", 2);
	String PrnitName   =	reader.getCellData("Item", "Prnit_Name", 2);
	String Packing     =  	reader.getCellData("Item", "Pcking_Item", 2);
	String Unit	   	   =	reader.getCellData("Item", "Unit_Item", 2);
	String Decimal     =	reader.getCellData("Item", "Decimal_Drp", 2);
	String Hsn  	   =	reader.getCellData("Item", "Hsn_Item", 2);
	String TaxCat      =  	reader.getCellData("Item", "Tax_Item", 2);
	String Adcess	   =	reader.getCellData("Item", "Adcess_Item", 2);
	String Agency      =	reader.getCellData("Item", "Agency_Item", 2);
	String Salt        =  	reader.getCellData("Item", "Salt_Item", 2);
	String Cat	       =	reader.getCellData("Item", "Cat_Item", 2);
	String Rack        =	reader.getCellData("Item", "Rack_Item", 2);
	String Negtive     =	reader.getCellData("Item", "Negt_Drp", 2);
	String MRP1  	   =	reader.getCellData("Item", "Mrp_Item", 2);
	String Prate1      =  	reader.getCellData("Item", "Prate_Item", 2);
	String Cost1	   =	reader.getCellData("Item", "Cost_Item", 2);
	String RateA1      =	reader.getCellData("Item", "RateA_Item", 2);
	String RateB1      =  	reader.getCellData("Item", "RateB_Item", 2);
	String Free1	   =	reader.getCellData("Item", "Free_Item", 2);
	String Schem1      =	reader.getCellData("Item", "Sche_Item", 2);
	String SchmType    =	reader.getCellData("Item", "Schm_Drp", 2);
	String Narcho	   =	reader.getCellData("Item", "Narch_Drp", 2);
	String SH	       =	reader.getCellData("Item", "SH_Drp", 2);
	String Sh1         =	reader.getCellData("Item", "SH1_Drp", 2);
	String Storage     =	reader.getCellData("Item", "Strge_Drp", 2);
	String Satus       =	reader.getCellData("Item", "staus_Drp", 2);
	String Color       =	reader.getCellData("Item", "Clr_Drp", 2);
	String DiscType    =	reader.getCellData("Item", "Dis_Drp", 2);
	String ItemDisc    =	reader.getCellData("Item", "Disc_Item", 2);
	String VolDisc     =	reader.getCellData("Item", "VolDisc_Item", 2);
	String MaxDiscper  =	reader.getCellData("Item", "MaxDiscper_Item", 2);
	String MinQty      =	reader.getCellData("Item", "MinQty_Item", 2);
	String ReDays      =	reader.getCellData("Item", "ReDays_Item", 2);
	String ReQty       =	reader.getCellData("Item", "ReQty_Item", 2);
	String MaxQty      =	reader.getCellData("Item", "MaxQty_Item", 2);
	String MinPer      =	reader.getCellData("Item", "MinPer_Item", 2);
	String Prohb       =	reader.getCellData("Item", "Proh_Drp", 2);
	String IVisible    =	reader.getCellData("Item", "Visiblity_Drp", 2);
	String MfR         =	reader.getCellData("Item", "MFR_Item", 2);

	 	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/qa");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
		}
	 public void login() {
		 driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(user);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	 public void action() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("//input[@id='SearchBox']")));
			textbox.sendKeys(Companyname);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Inventory Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Item Master")).click();
	 }
	 public void newb() throws InterruptedException{
		 Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='New']")).click();
	 }
	 
	 public void itmecod(){
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[1]")).isSelected()) {
				driver.findElements(By.id("typeofSupply"));
			}
			else if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[2]")).isSelected()){
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement itmcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtItemCode']")));
				itmcode.sendKeys(Itemcode);
				//driver.findElement(By.xpath("//input[@id='txtItemCode']")).sendKeys("1234");
			}
			else if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[3]")).isSelected()){
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement itmcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtItemCode']")));
				itmcode.sendKeys(Itemcode);
			}
		} 
	 public void typesupp(){
		 List<WebElement> listTs =	driver.findElements(By.id("typeofSupply"));
         int countTs= listTs.size();
        System.out.println("No of type of supply ");
        for( int i=0; i<countTs;i++){
        	String textTs= listTs.get(i).getText();
        	System.out.println(textTs);
        }
        Select  supply = new Select(driver.findElement(By.id("typeofSupply")));
        supply.selectByVisibleText(Goods);
	 }
	 public void barcode(){
		 
		 if (driver.findElement(By.xpath("//*[@id='barcode']/option[2]")).isSelected()) {
				driver.findElement(By.id("txtBarcode")).sendKeys(Barcode);
				 WebElement Pronmae = driver.findElement(By.xpath("//input[@id='txtProduct']"));
				 Pronmae.clear();
				 Pronmae.sendKeys(ProName);
			}
			else if (driver.findElement(By.xpath("//*[@id='barcode']/option[1]")).isSelected()){
				driver.findElement(By.xpath("//input[@id='txtProduct']")).sendKeys(ProName);
			}
	 }
	 public void productname(){
		 WebElement Pronmae = driver.findElement(By.xpath("//input[@id='txtProduct']"));
		 Pronmae.clear();
		 Pronmae.sendKeys(ProName);
	 }
	 // paking
	 public void pkng(){
		  if(driver.findElement(By.xpath("//*[@id='packing']/option[1]")).isSelected()){
			  driver.findElement(By.xpath("//textarea[@id='txtPrintName']"));
		  }
		  else if (driver.findElement(By.xpath("//*[@id='packing']/option[2]")).isSelected()){
			  WebElement pakng = driver.findElement(By.xpath("//input[@id='txtPacking']"));
			  pakng.clear();
			  pakng.sendKeys(Packing);
		  }
	    
	 }
	 
	 public void printName(){
		 if(driver.findElement(By.xpath("//*[@id='isPrintNameRequired']/option[1]")).isSelected()){
			 driver.findElement(By.xpath("//input[@id='unit']"));
		  }
		  else if (driver.findElement(By.xpath("//*[@id='isPrintNameRequired']/option[2]")).isSelected()){
			  WebElement pakng = driver.findElement(By.xpath("//textarea[@id='txtPrintName']"));
			  pakng.clear();
			  pakng.sendKeys(Packing);
		  }
	 }
	 public void unit() throws InterruptedException{
		
		/* WebElement  Unit = driver.findElement(By.xpath("//input[@id='unit']"));
		 Unit.sendKeys("Vamsi");
	     WebDriverWait wait = new WebDriverWait(driver,30 );
	     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu show']")));
		 List <WebElement> unitdrp = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		 System.out.println("auto sugg" + unitdrp.size());
			for (int i= 1;i<unitdrp.size();i++){
				
				System.out.println(unitdrp.get(i).getText());
				if(unitdrp.get(i).getText().equals("Vamsi")){
					unitdrp.get(i).click();
				}
			
			else {
				Unit.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				
				//Alert alert = driver.switchTo().alert();
				Unit.sendKeys(Keys.ENTER);
				List<WebElement> allOptions1 = driver.findElements(By.xpath("//*[@id='drpUqc']"));
				int count1 = allOptions1.size();
				System.out.println("No.of Autosuggesion " + count1);
				System.out.println("List of Autosuggesion");
				for (int j = 0; j < count1; j++) {
					String text1 = allOptions1.get(j).getText();
					System.out.println(text1);
				}
				Select UQC = new Select(driver.findElement(By.id("drpUqc")));
				UQC.selectByVisibleText("BTL-BOTTLES");
				driver.findElement(By.xpath("//*[@id='btn-Save']")).click();
			}
			}*/
		 WebElement textbox = driver.findElement(By.xpath("//input[@id='unit']"));
			textbox.clear();
			textbox.sendKeys(Unit);
			Thread.sleep(2000);
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
			int count = allOptions.size();
			System.out.println("No.of Autosuggesion " + count);
			System.out.println("List of Autosuggesion");
			for (int i = 0; i < count; i++) {
				String text = allOptions.get(i).getText();
				System.out.println(text);
			}
			textbox.sendKeys(Keys.ARROW_DOWN);
			textbox.sendKeys(Keys.ENTER);
			
			
	 }
	
		/* WebElement textboxUNT = driver.findElement(By.id("unit"));
			textboxUNT.sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			textboxUNT.sendKeys(Keys.ENTER);
			 driver.findElement(By.id("txtUnitName")).sendKeys("kgfUn");
			 
			 List<WebElement> allOptions1= driver.findElements(By.xpath("//*[@id='drpUqc']"));
				int count1=allOptions1.size();
				System.out.println("No.of Autosuggesion "+count1);
				System.out.println("List of Autosuggesion");
				for(int i=0;i<count1;i++){
					String text1 = allOptions1.get(i).getText();
					System.out.println(text1);
				}
				Select UQC = new Select(driver.findElement(By.id("drpUqc")));
				UQC.selectByVisibleText("BTL-BOTTLES");
				driver.findElement(By.xpath("//*[@id='btn-Save']")).click();*/
			
			/*List<WebElement> allOptionsU = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
			int countU=allOptionsU.size();
			System.out.println("No.of Autosuggesion "+countU);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<countU;i++){
				String textU = allOptionsU.get(i).getText();
				System.out.println(textU);	
			}
			Select UQC = new Select(driver.findElement(By.xpath("//input[@id='unit']")));
			UQC.selectByVisibleText("KGS-KILOGRAMS");*/
	 
	 public void decml(){
		 Select decml= new Select(driver.findElement(By.xpath("//select[@id='deciaml']")));
		 decml.selectByVisibleText(Decimal);
	 }
	 
	 public void IHsn() throws InterruptedException{
		 WebElement textbox=driver.findElement(By.xpath("//input[@id='hsn']"));
		 textbox.clear();
		 //textbox.sendKeys(Keys.SPACE);
		 textbox.sendKeys(Hsn);
		 Thread.sleep(2000);
		 List<WebElement> allOptions=driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		 int count=allOptions.size();
		 System.out.println("No of Autosuggestion"+count);
		 System.out.println("List of Autosuggestions");
		 for(int i=0;i<count;i++)
		 {
			 String text=allOptions.get(i).getText();
			 System.out.println(text);
			 
		 }
		 textbox.sendKeys(Keys.ARROW_DOWN);
		 textbox.sendKeys(Keys.ENTER);
		 
		 /*String textToSelect = "VAMSI";
		 Thread.sleep(2000);
		 WebElement autoOptions= driver.findElement(By.id("hsn"));
		 autoOptions.sendKeys("vamsi");

		 List<WebElement> optionsToSelect = driver.findElements(By.xpath("//ngb-typeahead-window[@id='ngb-typeahead-3']"));

		 for(WebElement option : optionsToSelect){
		     System.out.println(option);
		     if(option.getText().equals(textToSelect)) {
		         System.out.println("Trying to select: "+textToSelect);
		         driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		         option.click();
		         break;
		     }*/
		     /*else{
		    	 autoOptions.sendKeys(Keys.ENTER);
		     }*/	 
		 
	 // create HSN
	 
	/* WebElement textbox1=driver.findElement(By.xpath("//input[@id='hsn']"));
	 textbox1.clear();
	 textbox1.sendKeys(Keys.SPACE);
	 textbox1.sendKeys(Keys.ENTER);
	 Thread.sleep(5000);
	 
	 WebElement createHsncod = driver.findElement(By.xpath("//input[@id='txtUnitName']"));
	 createHsncod.sendKeys("newhsn");
	 
	 WebElement HsnName = driver.findElement(By.xpath("//input[@id='txtUnitName']"));
	 
     HsnName.sendKeys("new");
	 
	 driver.findElement(By.xpath("//button[@id='btn-Save']")).click();*/
	 } 
	 
	 public void ITax() throws InterruptedException{
		 WebElement textbox=driver.findElement(By.xpath("//input[@id='taxxCategory']"));
		 textbox.clear();
		 textbox.sendKeys(Keys.SPACE);
		 textbox.sendKeys(TaxCat);
		 Thread.sleep(2000);
		 List<WebElement> allOptions=driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		 int count=allOptions.size();
		 System.out.println("No of Autosuggestion"+count);
		 System.out.println("List of Autosuggestions");
		 for(int i=0;i<count;i++)
		 {
			 String text=allOptions.get(i).getText();
			 System.out.println(text);
		 }
		 textbox.sendKeys(Keys.ARROW_DOWN);
		 textbox.sendKeys(Keys.ENTER);
		 if(!driver.findElements(By.xpath("//input[@id='txtcessper2']")).isEmpty()){
	     driver.findElement(By.xpath("//input[@id='txtcessper2']")).sendKeys(Adcess);
		 }
		 //driver.findElement(By.xpath("//div[@class='text-right pageButton']//button[1]")).click();*/
	 }
	 public void agennreq() throws InterruptedException{
		 if(driver.findElement(By.xpath("//*[@id='isAgencyRequired']/option[1]")).isSelected()){
			 driver.findElement(By.xpath("//input[@id='salt']"));
			 if(driver.findElement(By.xpath("//*[@id='salt']/option[1]")).isSelected()){
				 driver.findElement(By.xpath("//select[@id='Category']"));
				 if(driver.findElement(By.xpath("//*[@id='Category']/option[1]")).isSelected()){
					 driver.findElement(By.xpath("//select[@id='rackno']"));
					 if(driver.findElement(By.xpath("//*[@id='rackno']/option[1]")).isSelected()){
						 driver.findElement(By.xpath("//select[@id='Negative']"));
					 }
				 }
			 }
		 }
		 else if(driver.findElement(By.xpath("//*[@id='isAgencyRequired']/option[2]")).isSelected()){
		 WebElement textbox = driver.findElement(By.xpath("//input[@id='txtcompName']"));
			textbox.clear();
			//textbox.sendKeys(Keys.SPACE);
			textbox.sendKeys(Agency);
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
		/*WebElement AGEN =  driver.findElement(By.xpath("//*[@id='txtcompName']"));
		AGEN.clear();
		AGEN.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		AGEN.sendKeys(Keys.ENTER);
		driver.findElement(By.id("txtCName")).sendKeys("Agency2");
		driver.findElement(By.id("txtbillprint")).sendKeys("1234657890");
		driver.findElement(By.id("txtDumpdays")).sendKeys("987654");
		
		Select MORE = new Select(driver.findElement(By.id("drpMoreOption")));
		MORE.selectByVisibleText("Yes");
		
		driver.findElement(By.id("txtRemark")).sendKeys("~!@#$%^&*()_~!@#$%^&*()_|}{:>< <>L<WZAEXSRCDVFTMNJI987812146132165111231~!@#$%^&*()|{}|:<><>~!@#$%^&*()~!@#$%^&*()__)(*&^%#EWXSRGT");
		
		Select countinue = new Select(driver.findElement(By.id("drpContinued")));
		countinue.selectByVisibleText("Yes");
		
		driver.findElement(By.id("txtReorderPref")).sendKeys("96863");	
		driver.findElement(By.xpath("//*[@id='txtStoreNo']")).sendKeys("96863");
		
		Select prohibited = new Select(driver.findElement(By.id("drpProhibit")));
		prohibited.selectByVisibleText("No");
		
		driver.findElement(By.id("txtExpireReceiveUpto")).sendKeys("22");
		driver.findElement(By.id("txtReorderFormula")).sendKeys("22");
		driver.findElement(By.xpath("//*[@id='txtMinmargin']")).sendKeys("!~!@#$%%^^96sdfsf");
		
		driver.findElement(By.xpath("//*[@id='btnAddMore']")).click();
		driver.findElement(By.id("txtEmain")).sendKeys("123456789@123.com");
		driver.findElement(By.id("txtEcc")).sendKeys("123456789001@111.com");
		driver.findElement(By.id("txtEbcc")).sendKeys("123456789001@123.com");
		driver.findElement(By.xpath("//*[@id='txtWebsite']")).sendKeys("123.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='pageButton']")).click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement el = driver.findElement(By.id("btn-Save"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", el);
	}*/
	 }
	 public void ItemSalt() throws InterruptedException{
		 if(driver.findElement(By.xpath("//*[@id='salt']/option[1]")).isSelected()){
			 driver.findElement(By.xpath("//select[@id='Category']"));
			 if(driver.findElement(By.xpath("//*[@id='Category']/option[1]")).isSelected()){
				 driver.findElement(By.xpath("//select[@id='rackno']"));
				 if(driver.findElement(By.xpath("//*[@id='rackno']/option[1]")).isSelected()){
					 driver.findElement(By.xpath("//select[@id='Negative']"));
				 }
			 }
		 }
	 
	 else if(driver.findElement(By.xpath("//*[@id='salt']/option[2]")).isSelected()){
			
		 WebElement salt1 = driver.findElement(By.xpath("//input[@id='salt']"));
		 salt1.clear();
			//textbox.sendKeys(Keys.SPACE);
		 salt1.sendKeys(Salt);
			Thread.sleep(2000);
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			salt1.sendKeys(Keys.ARROW_DOWN);
			salt1.sendKeys(Keys.ENTER);
		 
		 
		   /* WebElement Salti = driver.findElement(By.id("salt"));
			Salti.clear();
			Salti.sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			Salti.sendKeys(Keys.ENTER);
			driver.findElement(By.id("txtSaleName")).sendKeys(
					"vamsikrishna12345~~~@#$");

			Select MOREinfo = new Select(driver.findElement(By.id("purpose")));
			MOREinfo.selectByVisibleText("Yes");
			
			driver.findElement(By.id("txtIndication")).sendKeys("for all kind of things");
			driver.findElement(By.id("txtDosage")).sendKeys("180 MG");
			driver.findElement(By.id("txtSideEffect")).sendKeys("no side effects ");
			driver.findElement(By.id("txtSideEffect2")).sendKeys("always have very good effects ");
			driver.findElement(By.id("txtSpecialPrecautions")).sendKeys("any time can consume ");
			driver.findElement(By.id("txtDrugInteractions")).sendKeys("morning 90mg , evening 90mg ");
			driver.findElement(By.xpath("//*[@id='txtRemark']")).sendKeys("use every time good for health");
			
			Select Narcotic = new Select(driver.findElement(By.id("drpNarcotic")));
			Narcotic.selectByVisibleText("Yes");
			Select ScheduleH = new Select(driver.findElement(By.id("drpSchedule")));
			ScheduleH.selectByVisibleText("Yes");
			Select ScheduleH1= new Select(driver.findElement(By.id("drpScheduleH1")));
			ScheduleH1.selectByVisibleText("Yes");
			
			driver.findElement(By.xpath("//*[@id='txtMaximumRate']")).sendKeys("2311121223");
			Select Continued = new Select(driver.findElement(By.id("drpContinued")));
			Continued.selectByVisibleText("No");
			Select Prohibited = new Select(driver.findElement(By.id("drpProhibited")));
			Prohibited.selectByVisibleText("Yes");
			driver.findElement(By.xpath("//*[@id='btn-Save']/span[1]")).click();*/
	 }
	 }
	 public void Icat() throws InterruptedException{
		 if(driver.findElement(By.xpath("//*[@id='Category']/option[1]")).isSelected()){
			 driver.findElement(By.xpath("//select[@id='rackno']"));
			 if(driver.findElement(By.xpath("//*[@id='rackno']/option[1]")).isSelected()){
				 driver.findElement(By.xpath("//select[@id='Negative']"));
			 }
		 }
		 else if(driver.findElement(By.xpath("//*[@id='Category']/option[2]")).isSelected()){
			 
			 WebElement catg = driver.findElement(By.xpath("//input[@id='category']"));
			 catg.clear();
			// catg.sendKeys(Keys.SPACE);
			 catg.sendKeys(Cat);
				Thread.sleep(2000);
				List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
				int count=allOptions.size();
				System.out.println("No.of Autosuggesion "+count);
				System.out.println("List of Autosuggesion");
				for(int i=0;i<count;i++){
					String text = allOptions.get(i).getText();
					System.out.println(text);	
				}
				catg.sendKeys(Keys.ARROW_DOWN);
				catg.sendKeys(Keys.ENTER); 
				
			
				/*WebElement catg1 = driver.findElement(By.xpath("//input[@id='category']"));
				 catg1.clear();
				 catg1.sendKeys(Keys.SPACE);
				 catg1.sendKeys(Keys.ENTER);
				 
				 WebElement catname = driver.findElement(By.xpath("//input[@id='txtCategoryName']"));
				 catname.sendKeys("vamsi");
				 driver.findElement(By.xpath("//button[@id='btn-Save']")).click();*/
		 }
		 
		 
	 }
	 public void rackno(){
		 if(driver.findElement(By.xpath("//*[@id='rackno']/option[1]")).isSelected()){
			 driver.findElement(By.xpath("//select[@id='Negative']"));
		 }
		 else if (driver.findElement(By.xpath("//*[@id='rackno']/option[2]")).isSelected()){
			 WebElement rack = driver.findElement(By.xpath("//input[@id='rackAutoComplete']"));
			 rack.sendKeys(Rack);
			 rack.sendKeys(Keys.ARROW_DOWN);
			 rack.sendKeys(Keys.ENTER);
		 }
		 //input[@id='modelRack']
		
		/* // Create
		 WebElement rack = driver.findElement(By.xpath("//input[@id='modelRack']"));
		 rack.clear();
		 rack.sendKeys(Keys.SPACE);
		 rack.sendKeys(Keys.ENTER);
		 // store selection
		 WebElement store = driver.findElement(By.xpath("//input[@id='storeNameDrp']"));
		 store.clear();
		 store.sendKeys("Main Store");
		 store.sendKeys(Keys.ARROW_DOWN);
		 store.sendKeys(Keys.ENTER);
		 
		 WebElement Rackname = driver.findElement(By.xpath("//input[@id='name']"));
		 Rackname.sendKeys("Rack2");
		 
		 driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
		 
		 */
		 
	 } 
	 public void negtive(){
		 Select neg = new Select (driver.findElement(By.xpath("//select[@id='Negative']")));
		 neg.selectByVisibleText(Negtive);
	 }
	 
	 public void purchaseinfo(){
		 WebElement MRP=driver.findElement(By.xpath("//input[@id='txtmrp']"));
		 MRP.sendKeys(MRP1);
		 MRP.sendKeys(Keys.ENTER);
		 
		 WebElement PRate=driver.findElement(By.xpath("//input[@id='txtprate']"));
		 PRate.sendKeys(Prate1);
		 PRate.sendKeys(Keys.ENTER);
		 
		 WebElement Cost=driver.findElement(By.xpath("//input[@id='txtcost']"));
		 Cost.sendKeys(Cost1);
		 Cost.sendKeys(Keys.ENTER);
		 
	 }
	 public void Saleinfo() {
		 WebElement RateA=driver.findElement(By.xpath("//input[@id='txtratea']"));
		 RateA.sendKeys(RateA1);
		 RateA.sendKeys(Keys.ENTER);
		 
		 WebElement RateB=driver.findElement(By.xpath("//input[@id='txtrateb']"));
		 RateB.sendKeys(RateB1);
		 RateB.sendKeys(Keys.ENTER);
		 
		
	 }
	 public void Scheam(){
		 WebElement schm = driver.findElement(By.xpath("//*[@id='txtScheme']"));
		 schm.clear();
		 schm.sendKeys(Schem1);
		 
		 WebElement free = driver.findElement(By.xpath("//input[@id='txtFree']"));
		 free.clear();
		 free.sendKeys(Free1);
		 
		 Select Scheam = new Select(driver.findElement(By.xpath("//select[@id='Validfrom']")));
	     Scheam.selectByVisibleText(SchmType);
		 
	 }
	 public void narho(){
		 Select Narch = new Select(driver.findElement(By.xpath("//select[@id='narcotic']")));
	     Narch.selectByVisibleText(Narcho);
	     
	     Select  schdul = new Select(driver.findElement(By.xpath("//select[@id='scheduleH']")));
	    schdul.selectByVisibleText(SH);
	    
	    Select  schdul1 = new Select(driver.findElement(By.xpath("//select[@id='scheduleH1']")));
	    schdul1.selectByVisibleText(Sh1);
	    
	    Select  storagetype = new Select(driver.findElement(By.xpath("//select[@id='ItemType']")));
	    storagetype.selectByVisibleText(Storage);
	    
	    Select  Status = new Select(driver.findElement(By.xpath("//select[@id='status1']")));
	    Status.selectByVisibleText(Satus);
	    
	   /* Select color = new Select(driver.findElement(By.xpath("//select[@id='txtcolortype']")));
	    color.selectByVisibleText(color);*/
		 
	  
	 }
	 
	 public void extraReates(){
	     WebElement RateC=driver.findElement(By.xpath("//input[@id='txtratec']"));
		 RateC.sendKeys("0");
		 RateC.sendKeys(Keys.ENTER);
		 
		 WebElement RateD=driver.findElement(By.xpath("//input[@id='txtrated']"));
		 RateD.sendKeys("00");
		 RateD.sendKeys(Keys.ENTER);
		 
		 WebElement RateE=driver.findElement(By.xpath("//input[@id='txtratee']"));
		 RateE.sendKeys("00");
		 RateE.sendKeys(Keys.ENTER);
		 
		 WebElement RateF=driver.findElement(By.xpath("//input[@id='txtratef']"));
		 RateF.sendKeys("0");
		 RateF.sendKeys(Keys.ENTER);
		 
		 WebElement RateG=driver.findElement(By.xpath("//input[@id='txtrateg']"));
		 RateG.sendKeys("0");
		 RateG.sendKeys(Keys.ENTER);
		 
		 WebElement RateH=driver.findElement(By.xpath("//input[@id='txtrateh']"));
		 RateH.sendKeys("0");
		 RateH.sendKeys(Keys.ENTER);
		 
		 
		 
	 }
	 public void Discinfo() throws InterruptedException{
		// driver.findElement(By.id("ddldiscount")).click();  
		    List<WebElement> allOptions= driver.findElements(By.id("ddldiscount"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<count;i++)
			{
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			Thread.sleep(2000);	
			Select SaleRate = new Select(driver.findElement(By.id("ddldiscount")));
			SaleRate.selectByVisibleText(DiscType);
			
			WebElement itmdisc = driver.findElement(By.xpath("//input[@id='txtitemdiscount1']"));
			itmdisc.sendKeys(ItemDisc);
			itmdisc.sendKeys(Keys.ENTER);
			/*driver.findElement(By.xpath("//input[@id='txtlessby']")).sendKeys("12345");
			driver.findElement(By.xpath("//input[@id='txtSpecialDisc']")).sendKeys("12345");
			driver.findElement(By.xpath("//input[@id='txtonqtyspecdisc']")).sendKeys("12345");*/
			
			WebElement Maxdsc = driver.findElement(By.xpath("//input[@id='txtMaximumDiscount']"));
			Maxdsc.sendKeys(MaxDiscper);
			/*driver.findElement(By.xpath("//input[@id='txtPurchaseDiscount']")).sendKeys("12345");
			driver.findElement(By.xpath("//input[@id='txtPurchaseDiscount2']")).sendKeys("12345");
			driver.findElement(By.id("txtDiscountLess")).sendKeys("12345");*/
			driver.findElement(By.xpath("//button[@id='btnswitchtab']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='btnswitchtab']")).click();
			
			/*List<WebElement> allOptions1= driver.findElements(By.xpath("//select[@id='Validfrom']"));
			int count1=allOptions1.size();
			System.out.println("No.of Autosuggesion "+count1);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<count1;i++)
			{
				String text1 = allOptions1.get(i).getText();
				System.out.println(text1);	
			}
			Thread.sleep(2000);	
			
			
			WebElement dateBox = driver.findElement(By.xpath("//input[@id='txtSchemefromDate']"));
		    dateBox.sendKeys("01042018");
		    

			WebElement dateBox2 = driver.findElement(By.xpath("//input[@id='txtSchemetoDate']"));
		    dateBox2.sendKeys("01032019");
		    dateBox2.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);*/
		 }
	 public void Quantity(){
		 driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		/* WebElement Dsq = driver.findElement(By.id("txtBoxQuantity"));
		 Dsq.sendKeys("54651561464");
		 Dsq.sendKeys(Keys.ENTER);*/
		 
		WebElement TMQ =  driver.findElement(By.xpath("//input[@id='txtMinimumQuantity']"));
		TMQ.sendKeys(MinQty);
		TMQ.sendKeys(Keys.ENTER);
		
		WebElement ROD  =  driver.findElement(By.xpath("//input[@id='txtReorderDays']"));
		ROD.sendKeys(ReDays);
		ROD.sendKeys(Keys.ENTER);
		
		WebElement ROQ  =  driver.findElement(By.xpath("//input[@id='txtReorderQuantity']"));
		ROQ.sendKeys(ReQty);
		ROQ.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement MMQ  =  driver.findElement(By.id("txtMaximumQuantity"));
		MMQ.sendKeys(MaxQty);
		MMQ.sendKeys(Keys.ENTER);
		
		//driver.findElement(By.xpath("//button[@id='btnswitchtab']")).click();
		
		/*WebElement TC  =  driver.findElement(By.xpath("//input[@id='txtconversion']"));
		TC.sendKeys("98506546545654654");
		TC.sendKeys(Keys.ENTER);*/
	 }
	 public void OtherInfo() throws InterruptedException{
		WebElement minmmrgn =  driver.findElement(By.xpath("//input[@id='txtMinimumMargin']"));
		minmmrgn.sendKeys(MinPer);
		minmmrgn.sendKeys(Keys.ENTER);
		
		
		Select Proh = new Select(driver.findElement(By.xpath("//select[@id='type']")));
		Proh.selectByVisibleText(Prohb);
		
		Select Visible = new Select(driver.findElement(By.xpath("//select[@id='Hide']")));
		Visible.selectByVisibleText(IVisible);
			
		
		WebElement textboxMFR = driver.findElement(By.xpath("//input[@id='mfrname']"));
		textboxMFR.clear();
		textboxMFR.sendKeys(MfR);
		Thread.sleep(2000);
		List<WebElement> allOptions2= driver.findElements(By.xpath("//input[@id='mfrname']"));
		int count2=allOptions2.size();
		System.out.println("No.of Autosuggesion "+count2);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count2;i++)
		{
			String text2 = allOptions2.get(i).getText();
			System.out.println(text2);	
		}
		    textboxMFR.sendKeys(Keys.ARROW_DOWN);
			//textboxMFR.sendKeys(Keys.ARROW_DOWN);
			textboxMFR.sendKeys(Keys.ENTER);	
			
			//Create MFR
			/*textboxMFR.sendKeys(Keys.SPACE);
			textboxMFR.sendKeys(Keys.ENTER);
			WebElement MfrName = driver.findElement(By.id("txtName"));
			MfrName.sendKeys("NewMFR");
			driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	
	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);*/
	}
		
	public void upload1() throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='btnEdit']")).click();
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection("C:\\Users\\admin\\Desktop\\568.jpg"); 
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
	}
	 public void SaveI(){
		 driver.findElement(By.xpath("//button[@id='btnSave']")).click();
	 }
	 public static void main(String[] args) throws InterruptedException, AWTException {
		Item_Mater_New imn = new Item_Mater_New();
		imn.webLaunch();
		imn.login();
		imn.action();
		imn.newb();
		imn.itmecod();
		imn.typesupp();
		imn.barcode();
		//imn.productname();
		imn.pkng();
		imn.printName();
		imn.unit();
		imn.decml();
		imn.IHsn();
		imn.ITax();
		imn.agennreq();
		imn.ItemSalt();
		imn.Icat();
		imn.rackno();
		imn.negtive();
		imn.purchaseinfo();
		imn.Saleinfo();
		imn.Scheam();
		imn.narho();
		imn.extraReates();
		imn.Discinfo();
		imn.Quantity();
		imn.OtherInfo();
		//imn.upload1();
		imn.SaveI();
	}
}
