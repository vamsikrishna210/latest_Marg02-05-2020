package AccountsMaster;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
//import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Ledger_Master_Debtor {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
    
    String user        = 	reader.getCellData("Ledger", "User", 2);
	String pass 	   = 	reader.getCellData("Ledger", "password", 2);
	String Companyname = 	reader.getCellData("Ledger", "CompanyName", 2);
	String LedCode	   = 	reader.getCellData("Ledger", "LedgerCodeReq", 2);
	String Staion 	   = 	reader.getCellData("Ledger", "Station Required", 2);
	String DupLed      =  	reader.getCellData("Ledger", "Duplicate allowed", 2);
	String Altercode   =	reader.getCellData("Ledger", "Alternate Code", 2);
	String LedName     =	reader.getCellData("Ledger", "Ledger Name", 2);
	String AccGroup    =  	reader.getCellData("Ledger", "Account Group", 2);
	String Staion1     =	reader.getCellData("Ledger", "Station", 2);
	String Milto       =	reader.getCellData("Ledger", "Mail to", 2);
	String Ad1         =	reader.getCellData("Ledger", "Address1", 2);
	String Ad2  	   =	reader.getCellData("Ledger", "Address2", 2);
	String Ad3         =  	reader.getCellData("Ledger", "Address3", 2);
	String Country	   =	reader.getCellData("Ledger", "Country", 2);
	String State       =	reader.getCellData("Ledger", "State", 2);
	String City        =  	reader.getCellData("Ledger", "City", 2);
	String Pin	       =	reader.getCellData("Ledger", "Pincode", 2);
	String Phn         =	reader.getCellData("Ledger", "Phone No", 2);
	String Mobile1     =	reader.getCellData("Ledger", "Mobile 1", 2);
	String Mobl2 	   =	reader.getCellData("Ledger", "Mobile 2", 2);
	String Alt1        =  	reader.getCellData("Ledger", "Alternate Mobile1", 2);
	String Alt2  	   =	reader.getCellData("Ledger", "Alternate Mobile2", 2);
	String Alt3        =	reader.getCellData("Ledger", "Alternate Mobile3", 2);
	String BalMethod   =  	reader.getCellData("Ledger", "Balancing Method", 2);
	String OpenBal	   =	reader.getCellData("Ledger", "Opening Balance", 2);
	String DrCr        =	reader.getCellData("Ledger", "Debit/Credit", 2);
	String Crdays      =	reader.getCellData("Ledger", "Credit Days", 2);
	String LedType	   =	reader.getCellData("Ledger", "Ledger Type", 2);
	String Gst1        =	reader.getCellData("Ledger", "GST No.", 2);
	String GSt         =	reader.getCellData("Ledger", "GST Regis. Date", 2);
	String Vat         =	reader.getCellData("Ledger", "VAT No.", 2);
	String VatReg      =	reader.getCellData("Ledger", "VAT Regis. Date", 2);
	String Pan         =	reader.getCellData("Ledger", "PAN No.", 2);
	String Drug        =	reader.getCellData("Ledger", "D.L. No.", 2);
	String DLExp       =	reader.getCellData("Ledger", "D.L. Expiry Date", 2);
	String MFRNo       =	reader.getCellData("Ledger", "MFR No.", 2);
	String MFRExp 	   =	reader.getCellData("Ledger", "MFR Expiry Date", 2);
	String PreDrp      =	reader.getCellData("Ledger", "Prefix", 2);
	String First       =	reader.getCellData("Ledger", "First Name", 2);
	String Last        =	reader.getCellData("Ledger", "Last Name", 2);
	String Design      =	reader.getCellData("Ledger", "Designation", 2);
	String Website     =	reader.getCellData("Ledger", "Website", 2);
	String email       =	reader.getCellData("Ledger", "Email", 2);
	String AddE1       =	reader.getCellData("Ledger", "Add More Email IDs1", 2);
	String AddE2       =	reader.getCellData("Ledger", "Add More Email IDs2", 2);
	String AddE3       =	reader.getCellData("Ledger", "Add More Email IDs3", 2);
	String SplRtae     =	reader.getCellData("Ledger", "Special_Rates", 2);
	String Spldsc      =	reader.getCellData("Ledger", "Special_Disc", 2);
	String VolDsc      =	reader.getCellData("Ledger", "Volume_Disc", 2);
	String BanItem     =	reader.getCellData("Ledger", "Ban_Item", 2);
	String BanDsc      =	reader.getCellData("Ledger", "Ban_Disc", 2);
	String minrate     =	reader.getCellData("Ledger", "Min_Margin", 2);
	String ItemDisc    =	reader.getCellData("Ledger", "Item Discount %", 2);
	String BrkExpon    =	reader.getCellData("Ledger", "BRK/EXP Discount on", 2);
	String Brkexpper   =	reader.getCellData("Ledger", "BRK/EXP Discount %", 2);
	String AgenDisc    =	reader.getCellData("Ledger", "Agency_Discount", 2);
	String BrkDisc     =	reader.getCellData("Ledger", "Brk_Disc", 2);
	String BanAgen     =	reader.getCellData("Ledger", "Ban_Agen", 2);
	String Salerate    =	reader.getCellData("Ledger", "Sales Rate", 2);
	String BrkExprate  =	reader.getCellData("Ledger", "Brk/Exp Rate", 2);
	String Plimit      =	reader.getCellData("Ledger", "Primary Limit", 2);
	String PlBills     =	reader.getCellData("Ledger", "Primary Limit / Bills", 2);
	String Pldays      =	reader.getCellData("Ledger", "Primary Limit / Days", 2);
	String Climit      =	reader.getCellData("Ledger", "Credit Limit", 2);
	String ClimitBils  =	reader.getCellData("Ledger", "Credit Limit / Bills", 2);
	String ClimitDys   =	reader.getCellData("Ledger", "Credit Limit / Days", 2);
	String Climitset   =	reader.getCellData("Ledger", "Credit Limit Set", 2);
	String ClimitActn  =	reader.getCellData("Ledger", "Credit Limit Action", 2);
	String CDealing    =	reader.getCellData("Ledger", "Copy Dealing", 2);
	String CSure       =	reader.getCellData("Ledger", "Sure?", 2);
	String LedTrans    =	reader.getCellData("Ledger", "Transport", 2);
	String Delever     =	reader.getCellData("Ledger", "Delivered By", 2);
	String LedMr       =	reader.getCellData("Ledger", "M.R.", 2);
	String Route       =	reader.getCellData("Ledger", "Route", 2);
	String Area        =	reader.getCellData("Ledger", "Area", 2);
	String bday        =	reader.getCellData("Ledger", "Birthday", 2);
	String Annuversy   =	reader.getCellData("Ledger", "Anniversary", 2);
	String Latitude    =	reader.getCellData("Ledger", "Latitude", 2);
	String longi       =	reader.getCellData("Ledger", "Longitude", 2);
	String TFData      =	reader.getCellData("Ledger", "Transfer Data on", 2);
	String Ecode        =	reader.getCellData("Ledger", "E-Business Code", 2);
	String Freez        =	reader.getCellData("Ledger", "Freeze upto", 2);
	String LedCat       = 	reader.getCellData("Ledger","Ledger Category", 2);
	
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
	public void serchCompany() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement textbox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//input[@id='SearchBox']")));
		textbox.sendKeys(Companyname);
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='textContent']"));
		int count=allOptions.size();
		System.out.println("No.of Autosuggesion "+count);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count;i++){
			String text = allOptions.get(i).getText();
			System.out.println(text);	
		}
		//textbox.sendKeys(Keys.ARFROW_DOWN);
		textbox.sendKeys(Keys.ENTER);
	}
	public void Master() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.linkText("Master"));
		action.moveToElement(menu).perform();
		menu.sendKeys(Keys.ENTER);
		
		WebElement submenu1 = driver.findElement(By.linkText("Accounts Master"));
		action.moveToElement(submenu1).perform();
		submenu1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Ledger Master")).click();
		Thread.sleep(3000);
		
	}
	public void newleder (){
		driver.findElement(By.xpath("//button[@title='New']")).click();
	}
	public void ctrlrm () throws InterruptedException {
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//img[@src='./assets/images/setting.png'")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement textbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//a[@id='aControlRoomSetting']//img")));
		
		textbox1.click();
		
		Thread.sleep(2000);
		Select Codereq = new Select(driver.findElement(By.id("code")));
	    Codereq.selectByVisibleText(LedCode);
	    Thread.sleep(2000);
	    
	    Select Dupname = new Select(driver.findElement(By.xpath("//select[@id='name']")));
	    Dupname.selectByVisibleText(DupLed);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='close itemcontrolClose']")).click();
		

	}
	//New Name
	public void newname() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//*[@id='code']/option[1]")).isSelected()){
			driver.findElement(By.id("txtlegername")).sendKeys(LedName);
		}
		else if (driver.findElement(By.xpath("//*[@id='code']/option[2]")).isSelected()){
			driver.findElement(By.id("txtalternatecode")).sendKeys(Altercode);
			driver.findElement(By.id("txtlegername")).sendKeys(LedName);
		}
		else if(driver.findElement(By.xpath("//*[@id='code']/option[3]")).isSelected()){
			driver.findElement(By.id("txtalternatecode")).sendKeys(Altercode);
			driver.findElement(By.id("txtlegername")).sendKeys(LedName);
		}
		
			
		
	}
	public void Account() throws InterruptedException{	
		Thread.sleep(3000);
		WebElement textbox1 = driver.findElement(By.xpath("//input[@id='drpAccountGroup']"));
		textbox1.clear();
		//textbox1.sendKeys(Keys.SPACE);
		textbox1.sendKeys(AccGroup);
		Thread.sleep(5000);
		List<WebElement> allOptions1= driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		int count1=allOptions1.size();
		System.out.println("No.of Autosuggesion "+count1);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count1;i++)
		{
			String text1 = allOptions1.get(i).getText();
			System.out.println(text1);
			//System.out.println(allOptions1.get(i).getText());
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    textbox1.sendKeys(Keys.ARROW_DOWN);
		textbox1.sendKeys(Keys.ENTER);
		/*Select Sud = new Select(driver.findElement(By.xpath("//*[@class='dropdown-menu show']")));
		Sud.selectByVisibleText("SUNDRY DEBTORS");*/

	}
	//Control Room
	public void morectrlrm() throws InterruptedException{
		driver.findElement(
				By.xpath("//a[@id='aControlRoomSetting']//img"))
				.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		Select Stan = new Select(driver.findElement(By.xpath("//select[@id='sta']")));
		Stan.selectByVisibleText("No");
		Thread.sleep(2000);
		
		Select dup = new Select(driver.findElement(By.id("name")));
		dup.selectByVisibleText(DupLed);
		
		driver.findElement(By.xpath("//button[@id='mr']")).click();
		//Mr
		Select MRR = new Select(driver.findElement(By.xpath("//*[@id='isMR']")));
		MRR.selectByIndex(1);
		
		Thread.sleep(2000);
		
		if (driver.findElement(By.xpath("//*[@id='isMR']/option[1]")).isSelected())
		{  //driver.findElement(By.xpath("//*[@id='btn-Close']")).click();
			driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
		}
		else if (driver.findElement(By.xpath("//*[@id='isMR']/option[2]")).isSelected()){
			WebElement MR = driver.findElement(By.xpath("//input[@id='mr']"));
			MR.clear();
			MR.sendKeys("Mr1");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
		}
		Thread.sleep(3000);
		
		
		// Route
		driver.findElement(By.xpath("//button[@id='route-area']")).click();
		
		Select RoutA = new Select(driver.findElement(By.id("isrt")));
		RoutA.selectByIndex(0);
		
		if (driver.findElement(By.xpath("//*[@id='isrt']/option[1]")).isSelected())
		{  //driver.findElement(By.xpath("//*[@id='btn-Close']")).click();
			driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
		}
		else if (driver.findElement(By.xpath("//*[@id='isrt']/option[2]")).isSelected()){
			WebElement Rot = driver.findElement(By.id("rt"));
			Rot.clear();
			Rot.sendKeys("My Route");
			
			
			WebElement Are = driver.findElement(By.id("ar"));
			Are.clear();
			Are.sendKeys("MY Area");
			driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
		}
		
        Thread.sleep(5000);
        // Close Control room
		driver.findElement(By.xpath("//button[@class='close itemcontrolClose']")).click();
	}
	public void mailto() throws InterruptedException{
		WebElement mail = driver.findElement(By.id("txtMailTo"));
		mail.clear();
		Thread.sleep(2000);
		mail.sendKeys(Milto);
		
		driver.findElement(By.id("txtaddress1")).sendKeys(Ad1);
		driver.findElement(By.id("txtaddress2")).sendKeys(Ad2);
		driver.findElement(By.id("txtaddress3")).sendKeys(Ad3);
		
	}
	//country
	public void country() throws InterruptedException{
		WebElement textbox2 = driver.findElement(By.xpath("//input[@id='ddlCountryLinkID']"));
		textbox2.clear();
		textbox2.sendKeys(Country);
		Thread.sleep(2000);
		List<WebElement> allOptions2= driver.findElements(By.xpath("//*[@id='ddlCountryLinkID']"));
		int count2=allOptions2.size();
		System.out.println("No.of Autosuggesion "+count2);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count2;i++)
		{
			String text2 = allOptions2.get(i).getText();
			System.out.println(text2);	
		}
		    textbox2.sendKeys(Keys.ARROW_DOWN);
			//textbox2.sendKeys(Keys.ARROW_DOWN);
			textbox2.sendKeys(Keys.ENTER);	
		
		//create country
		/*WebElement textbox2 = driver.findElement(By.xpath("//*[@id='ddlCountryLinkID']"));
		
		textbox2.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		textbox2.sendKeys(Keys.ENTER);
		
		WebElement contry = driver.findElement(By.xpath("//input[@id='txtCountryName']"));
		contry.clear();
		contry.sendKeys("vamsikrishna");
		
		WebElement code= driver.findElement(By.xpath("//input[@id='txtCountryCode']"));
		code.sendKeys("kgf");
		code.sendKeys(Keys.ENTER);
		WebElement symb = driver.findElement(By.xpath("//input[@id='txtCurrencySymbol']"));
		symb.sendKeys("kgf");
		symb.sendKeys(Keys.ENTER);
		WebElement strng = driver.findElement(By.xpath("//input[@id='txtCurrencyString']"));
		strng.sendKeys(Keys.ENTER);
		
		
		//driver.findElement(By.xpath("//input[@id='txtCurrencySymbol']")).sendKeys("$KGF");

		Thread.sleep(2000);
		WebElement sav = driver.findElement(By.xpath("//button[@id='btn-Save']"));
		sav.sendKeys(Keys.ENTER);
		
		
		*/
		
		
	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	// State
	  public void state() throws InterruptedException{
		WebElement textbox3 = driver.findElement(By.id("ddlStateLinkID"));
		textbox3.clear();
		textbox3.sendKeys(State);
		Thread.sleep(2000);
		List<WebElement> allOptions3= driver.findElements(By.id("ddlStateLinkID"));
		int count3=allOptions3.size();
		System.out.println("No.of Autosuggesion "+count3);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<count3;i++)
		{
			String text3 = allOptions3.get(i).getText();
			System.out.println(text3);	
		}
		
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			textbox3.sendKeys(Keys.ARROW_DOWN);
			textbox3.sendKeys(Keys.ENTER);
			
	}
	  // city
	public void city(){
		 driver.findElement(By.xpath("//*[@id='ddlCity']")).sendKeys(City);
	}
	// Pincode
	public void pin(){
		driver.findElement(By.id("txtPostalCode")).sendKeys(Pin);
	}
	//opening balance
	public void balance() throws InterruptedException{
		List<WebElement> allOptions4= driver.findElements(By.id("ddlBalancingMethod"));
		int count4=allOptions4.size();
		System.out.println("No.of Autosuggesion "+count4);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<count4;i++)
		{
			String text4 = allOptions4.get(i).getText();
			System.out.println(text4);	
		}
			//textbox3.sendKeys(Keys.ARROW_DOWN);
			//textbox4.sendKeys(Keys.ENTER);	
	
		Select Balance = new Select(driver.findElement(By.id("ddlBalancingMethod")));
		Balance.selectByVisibleText(BalMethod);

		
		
		WebElement OPB = driver.findElement(By.id("txtOpeningBalance"));
		OPB.sendKeys(Keys.BACK_SPACE);
		//Thread.sleep(2000);
		OPB.sendKeys(OpenBal);
		OPB.sendKeys(Keys.ENTER);
	
		//Bill by bill
		if(driver.findElement(By.xpath("//*[@id='ddlBalancingMethod']/option[1]")).isSelected()){
			
			/*WebElement OPB = driver.findElement(By.id("txtOpeningBalance"));
			OPB.clear();
			OPB.sendKeys("200000");
			OPB.sendKeys(Keys.ENTER);*/
			
			Thread.sleep(5000);
			WebElement Date = driver.findElement(By.xpath("//*[@id='parent']/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]"));
			Date.sendKeys("20022020");
			Date.sendKeys(Keys.ENTER);
			
			WebElement Billno = driver.findElement(By.xpath("//*[@id='parent']/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/edittext/input"));
	//Billno.clear();
			Thread.sleep(2000);
			Billno.sendKeys("002");
			Billno.sendKeys(Keys.ENTER);
		   
			WebElement Days = driver.findElement(By.xpath("//*[@id='parent']/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[3]"));
            Days.clear();
            Days.sendKeys("100");
            Days.sendKeys(Keys.ENTER);
            
            WebElement BillValue = driver.findElement(By.xpath("//*[@id='parent']/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[4]/editnum/input"));
            BillValue.clear();
            BillValue.sendKeys("5000");
            BillValue.sendKeys(Keys.ENTER);
            
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='btn-Update']")).click();
            
            Thread.sleep(2000);
          
            Select mon = new Select(driver.findElement(By.id("ddlIsDebitCredit")));
			mon.selectByVisibleText("Cr");
			
		}
		//FiFo
		else if(driver.findElement(By.xpath("//*[@id='ddlBalancingMethod']/option[2]")).isSelected()){
			WebElement OB = driver.findElement(By.id("txtOpeningBalance"));
			//OB.clear();
			OPB.sendKeys(Keys.BACK_SPACE);
			OB.sendKeys(OpenBal);
			OPB.sendKeys(Keys.ENTER);
			//Thread.sleep(5000);
			
			Select mon = new Select(driver.findElement(By.id("ddlIsDebitCredit")));
			mon.selectByVisibleText(DrCr);
		}
		//OnAccount
		else if(driver.findElement(By.xpath("//*[@id='ddlBalancingMethod']/option[3]")).isSelected()){
			WebElement OPB1 = driver.findElement(By.id("txtOpeningBalance"));
			//OPB1.clear();
			OPB.sendKeys(Keys.BACK_SPACE);
			OPB1.sendKeys(OpenBal);
			OPB1.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			
		Select mon = new Select(driver.findElement(By.id("ddlIsDebitCredit")));
		mon.selectByVisibleText(DrCr);
	}
		
}
	//Contact
	public void contact() throws InterruptedException{
		driver.findElement(By.xpath("//input[@id='txtPhoneNo']")).sendKeys(Phn);
		driver.findElement(By.xpath("//input[@id='txtMobile']")).sendKeys(Mobile1);
		driver.findElement(By.xpath("//input[@id='txtMobile2']")).sendKeys(Mobl2);
		driver.findElement(By.xpath("//*[@id='btnMoreMobile']")).click();

		driver.findElement(By.id("txtMobile1")).sendKeys(Alt1);
		driver.findElement(By.id("txtMobile2")).sendKeys(Alt2);
		driver.findElement(By.id("txtMobile3")).sendKeys(Alt3);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
	}
	//GST&TAX
	public void Gst(){
		/*driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement GSTIN = driver.findElement(By.id("txtGSTHeading"));
		GSTIN.clear();
		GSTIN.sendKeys("GST");*/
		
		//driver.findElement(By.id("txtGSTHeading")).sendKeys("GST");
		WebElement GST = driver.findElement(By.id("txtGSTNo"));
		GST.sendKeys(Gst1);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement dateBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='txtGSTDate']")));
		//WebElement dateBox = driver.findElement(By.id("txtGSTDate"));
	    dateBox.sendKeys(GSt);
	    
		//driver.findElement(By.id("txtVATHeading")).sendKeys("46165498111651sdsadsadfsaffsa");
		
		driver.findElement(By.id("txtVATNo")).sendKeys(Vat);
		WebElement dateBox2 = driver.findElement(By.id("txtVATExpDate"));
	    dateBox2.sendKeys(VatReg);
	    
	  /*  WebElement PAN = driver.findElement(By.id("txtPANHeading"));
	    PAN.clear();
	    PAN.sendKeys("PANCARD");*/
		//driver.findElement(By.id("txtPANNo")).sendKeys("AAOCS1149R");
	}
	
	public void ledgertype() throws InterruptedException{
		
		List<WebElement> allOptions5= driver.findElements(By.id("ddlLedgerType"));
		int count5=allOptions5.size();
		System.out.println("No.of Autosuggesion "+count5);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<count5;i++)
		{
			String text5 = allOptions5.get(i).getText();
			System.out.println(text5);	
		}
		Thread.sleep(2000);	
		Select ledtype = new Select(driver.findElement(By.id("ddlLedgerType")));
		ledtype.selectByVisibleText(LedType);
		
	   /* WebElement OPT1 = driver.findElement(By.id("txtTaOptionalHeading1"));
	    OPT1.clear();
	    OPT1.sendKeys("Adhar");
		driver.findElement(By.id("txtTaOptionalNo1")).sendKeys("7663888466179999999999999");*/
		
		driver.findElement(By.xpath("//*[@id='btn-Switch Tab']")).click();
	}
	//Licence INfo
	public void licenceinf(){
		//driver.findElement(By.xpath("//*[@id='btn-Switch Tab']")).click();
		/*WebElement DLH = driver.findElement(By.id("txtDLNoHeading"));
		DLH.clear();
		DLH.sendKeys("druglo.NO");*/
	    driver.findElement(By.id("txtDLNo")).sendKeys(Drug);
	    WebElement dateBox1 = driver.findElement(By.id("txtDLExpiryDate"));
	    dateBox1.sendKeys(DLExp);
	    
	   /* WebElement MFGR = driver.findElement(By.id("txtMFRNoHeading"));
	    MFGR.clear();
	    MFGR.sendKeys("MyMFGR.no");*/
	    
	    
	    driver.findElement(By.id("txtMFRNo")).sendKeys("7569383454");
	    WebElement dateBox3 = driver.findElement(By.id("txtMFRExpiryDate"));
	    dateBox3.sendKeys(MFRExp);
	    
	    driver.findElement(By.xpath("//*[@id='btn-Switch Tab']")).click();
	    
	    /*WebElement OPT2 = driver.findElement(By.id("txtLiOptionalHeading1"));
	    OPT2.clear();
	    OPT2.sendKeys("MYNOOOO");
	    driver.findElement(By.id("txtLiOptionalNo1")).sendKeys("~!@#$%^&*(7569383454)gnfjknbjklnxv");
	    driver.findElement(By.xpath("//*[@id='btn-Switch Tab']/span[1]")).click();*/
	    
	}
	//Contact INfo
	public void continfo(){
		 Select MFRTYP = new Select(driver.findElement(By.id("ddlPersonPrefix")));
		    MFRTYP.selectByVisibleText(PreDrp);
		   
		    driver.findElement(By.id("txtFirstName")).sendKeys(First);
		    driver.findElement(By.id("txtLastName")).sendKeys(Last);
		    driver.findElement(By.id("txtDesignation")).sendKeys(Design);
		    driver.findElement(By.id("txtWebsite")).sendKeys(Website);
		    driver.findElement(By.id("txtEmail1")).sendKeys(email);
		    driver.findElement(By.xpath("//*[@id='btn-Switch Tab']")).click();
	}
	//others
	
	//Discount
	public void Discounts() throws InterruptedException{
		driver.findElement(By.xpath("//button[@id='btnDiscounts']")).click();
		Thread.sleep(2000);
		 WebElement itemdsc = driver.findElement(By.xpath("//input[@id='txtItemDiscount']"));
		 itemdsc.clear();
		 itemdsc.sendKeys(ItemDisc);
		
		 Select Brk = new Select(driver.findElement(By.id("//select[@id='BrkExpDiscountType']")));
		 Brk.selectByVisibleText(BrkExpon);
		 
		 WebElement EXP = driver.findElement(By.xpath("//input[@id='txtBrkExpDiscount']"));
		 EXP.clear();
		 EXP.sendKeys(Brkexpper);
		//Remaing have to add after fixing the bugs
		 driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	}
	
	// Billing Rate
	public void others() throws InterruptedException{
		  
	    driver.findElement(By.id("btnRates")).click();  
	    List<WebElement> allOptions6= driver.findElements(By.id("txtSalesRate"));
		int count6=allOptions6.size();
		System.out.println("No.of Autosuggesion "+count6);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<count6;i++)
		{
			String text6 = allOptions6.get(i).getText();
			System.out.println(text6);	
		}
		Thread.sleep(2000);	
		Select SaleRate = new Select(driver.findElement(By.id("txtSalesRate")));
		SaleRate.selectByVisibleText(Salerate);
		
		
		List<WebElement> allOptions7= driver.findElements(By.id("ddlBrkExpRate"));
		int count7=allOptions7.size();
		System.out.println("No.of Autosuggesion "+count7);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<count7;i++)
		{
			String text7 = allOptions7.get(i).getText();
			System.out.println(text7);	
		}
		Thread.sleep(2000);	
		Select EXPRA = new Select(driver.findElement(By.id("ddlBrkExpRate")));
		EXPRA.selectByVisibleText(BrkExprate);
	
		driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click(); 
	}
	//Limit
	public void limit() throws InterruptedException{
		driver.findElement(By.id("btnLimit")).click();
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//*[@id='ddlBalancingMethod']/option[1]")).isSelected()){
		WebElement prm = driver.findElement(By.id("txtPrimaryLimit"));
		prm.sendKeys(Plimit);
		prm.sendKeys(Keys.ENTER);
		
		
		WebElement prml = driver.findElement(By.id("txtPrimaryLimitBills"));
		prml.sendKeys(PlBills);
		prml.sendKeys(Keys.ENTER);
		
		WebElement prmlb = driver.findElement(By.id("txtPrimaryLimitDays"));
		prmlb.sendKeys(Pldays);
		prmlb.sendKeys(Keys.ENTER);
		
		WebElement crm = driver.findElement(By.id("txtCreditLimit"));
		crm.sendKeys(Climit);
		crm.sendKeys(Keys.ENTER);
		
		WebElement crml = driver.findElement(By.id("txtCreditLimitBills"));
		crml.sendKeys(ClimitBils);
		crml.sendKeys(Keys.ENTER);
		
		WebElement crmlb = driver.findElement(By.id("txtCreditLimitDays"));
		crmlb.sendKeys(ClimitDys);
		crmlb.sendKeys(Keys.ENTER);
		}
		else if(driver.findElement(By.xpath("//*[@id='ddlBalancingMethod']/option[2]")).isSelected()){
			WebElement prm = driver.findElement(By.id("txtPrimaryLimit"));
			prm.sendKeys(Plimit);
			prm.sendKeys(Keys.ENTER);
			
			
			WebElement prml = driver.findElement(By.id("txtPrimaryLimitBills"));
			prml.sendKeys(PlBills);
			prml.sendKeys(Keys.ENTER);
			
			WebElement prmlb = driver.findElement(By.id("txtPrimaryLimitDays"));
			prmlb.sendKeys(Pldays);
			prmlb.sendKeys(Keys.ENTER);
			
			WebElement crm = driver.findElement(By.id("txtCreditLimit"));
			crm.sendKeys(Climit);
			crm.sendKeys(Keys.ENTER);
			
			WebElement crml = driver.findElement(By.id("txtCreditLimitBills"));
			crml.sendKeys(ClimitBils);
			crml.sendKeys(Keys.ENTER);
			
			WebElement crmlb = driver.findElement(By.id("txtCreditLimitDays"));
			crmlb.sendKeys(ClimitDys);
			crmlb.sendKeys(Keys.ENTER);
			
		}
		else if(driver.findElement(By.xpath("//*[@id='ddlBalancingMethod']/option[3]")).isSelected()){
			WebElement prm = driver.findElement(By.id("txtPrimaryLimit"));
			prm.sendKeys(Plimit);
			prm.sendKeys(Keys.ENTER);
			
			WebElement crm = driver.findElement(By.id("txtCreditLimit"));
			crm.sendKeys(Climit);
		}
		List<WebElement> Limitset= driver.findElements(By.id("ddlCreditLimitSet"));
		int countL=Limitset.size();
		System.out.println("No.of Autosuggesion "+countL);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<countL;i++)
		{
			String textL = Limitset.get(i).getText();
			System.out.println(textL);	
		}
		Thread.sleep(2000);	
		Select LMT = new Select(driver.findElement(By.id("ddlCreditLimitSet")));
		LMT.selectByVisibleText(Climitset);
	    
		
		List<WebElement> CLimitset= driver.findElements(By.id("ddlCreditLimitAction"));
		int countLc=CLimitset.size();
		System.out.println("No.of Autosuggesion "+countLc);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<countL;i++)
		{
			String textCL = CLimitset.get(i).getText();
			System.out.println(textCL);	
		}
		Thread.sleep(2000);	
		Select CLMT = new Select(driver.findElement(By.id("ddlCreditLimitAction")));
		CLMT.selectByVisibleText(ClimitActn);
	    
		//driver.findElement(By.id("txtCreditDays")).sendKeys("12344666");
		driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
	
		
	}
	//copy dealings
	public void copydealings() throws InterruptedException{
		driver.findElement(By.id("btnDealings")).click();
		WebElement Copydealing = driver.findElement(By.xpath("//input[@id='drpCopyAutocomplete']"));
		Copydealing.sendKeys(CDealing);
		Copydealing.sendKeys(Keys.ARROW_DOWN);
		Copydealing.sendKeys(Keys.ENTER);
		/*List<WebElement> Copyd= driver.findElements(By.xpath("/input[@id='drpCopyAutocomplete']"));
		int countCD=Copyd.size();
		System.out.println("No.of Autosuggesion "+countCD);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<countCD;i++)
		{
			String textCD = Copyd.get(i).getText();
			System.out.println(textCD);	
		}
		Thread.sleep(2000);	
		Select CPYD = new Select(driver.findElement(By.id("ddlCopyLedgerLinkID")));
		CPYD.selectByVisibleText("IGST Input");
		*/
	   
		
	    Select sure = new Select(driver.findElement(By.id("ddlcopytype")));
	    sure.selectByVisibleText(CSure);
	 
	    driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
	    
	}
	//transporter
	public void transporter() throws InterruptedException{
		 driver.findElement(By.id("btnTransport")).click();
		 WebElement Transport = driver.findElement(By.xpath("//input[@id='drpTranAutocomplete']"));
		 Transport.sendKeys(LedTrans);
		 
		 String typedValue = Transport.getAttribute("value");
			int size = typedValue.length();
		// Thread.sleep(countdrp);
			
			List<WebElement> dropdown = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
			Iterator itr =  dropdown.iterator();
			while (itr.hasNext()) {
				System.out.println("++"+itr.next());
			}
			
			int countdrp = dropdown.size();
			 System.out.println("No.of Autosuggesion "+countdrp);
			 System.out.println("List of Autosuggesion");
			 for(int i=0;i<countdrp;i++)
				{
					String texttr = dropdown.get(i).getText();
					System.out.println(texttr);	
				}
		 
		 if(dropdown.contains(typedValue)){
			 Transport.sendKeys(Keys.ARROW_DOWN);
			 Transport.sendKeys(Keys.ENTER);
 }
		 else{
			 Transport.sendKeys(Keys.ENTER);
			 WebElement tname= driver.findElement(By.xpath("//input[@id='txtTransportName']"));
			 tname.sendKeys(Keys.ENTER);
			 
			 Select More1 = new Select(driver.findElement(By.xpath("//select[@id='ddlMore']")));
			 More1.selectByVisibleText("No");
			 
			 driver.findElement(By.xpath("//div[@class='modal-dialog']//button[@id='btn-Save']")).click();
		 } 
		    WebElement Deleveryby = driver.findElement(By.xpath("//input[@id='txtDeliveredBy']"));
		    Deleveryby.sendKeys(Delever);
			driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
	}
	public void mr() throws InterruptedException{
		driver.findElement(By.id("btnMr")).click();
		List<WebElement> listMr= driver.findElements(By.id("ddlmrlinkid"));
		int countMr=listMr.size();
		System.out.println("No.of Autosuggesion "+countMr);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<countMr;i++)
		{
			String textMr = listMr.get(i).getText();
			System.out.println(textMr);	
		}
		Thread.sleep(2000);	
		Select Mrl = new Select(driver.findElement(By.id("ddlmrlinkid")));
		Mrl.selectByVisibleText(LedMr);
		driver.findElement(By.id("btnSave")).click();
		
	}
	public void event() throws InterruptedException{
		driver.findElement(By.id("btnEvents")).click();
		WebElement dateBoxB = driver.findElement(By.id("txtBirthday"));
	    dateBoxB.sendKeys(bday);
	    Thread.sleep(2000);
	    WebElement dateBoxA = driver.findElement(By.id("txtAnniversary"));
	    dateBoxA.sendKeys(Annuversy);
	     driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
	}
	public void Geolocation(){
	     
	     driver.findElement(By.id("btnGeoLocation")).click();
	     driver.findElement(By.id("txtLatitude")).sendKeys(Latitude);
	     driver.findElement(By.id("txtLongitude")).sendKeys(longi);
	     driver.findElement(By.xpath("//div[@class='pageButton']//button[@id='btn-Save']")).click();
	    //driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-geolocation/div/button/span")).click();;
	}
	public void others2() throws InterruptedException{
		driver.findElement(By.id("btnOthers")).click();
	     
	     WebElement dateBoxfreez = driver.findElement(By.id("txtFreezeupto"));
	     dateBoxfreez.sendKeys(Freez);
	     
	}
	public void ledgercatgry() throws InterruptedException{
		List<WebElement> listLc= driver.findElements(By.id("ddlLedgerCategory"));
		int countlc=listLc.size();
		System.out.println("No.of Autosuggesion "+countlc);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<countlc;i++)
		{
			String textlc = listLc.get(i).getText();
			System.out.println(textlc);	
		}
		Thread.sleep(2000);	
		Select lc = new Select(driver.findElement(By.id("ddlLedgerCategory")));
		lc.selectByVisibleText("Stockist");
		Thread.sleep(2000);
		
	}
	
	public void party() throws InterruptedException{
		
		Select actv = new Select(driver.findElement(By.id("ddlStatus")));
		actv.selectByVisibleText("Active");
	}
	public void narcho() throws InterruptedException{
		List<WebElement> listNrc= driver.findElements(By.id("ddlNarcoSchHItemBilling"));
		int countNrc=listNrc.size();
		System.out.println("No.of Autosuggesion "+countNrc);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<countNrc;i++)
		{
			String textNrc = listNrc.get(i).getText();
			System.out.println(textNrc);	
		}
		Thread.sleep(2000);	
		Select nrc = new Select(driver.findElement(By.id("ddlNarcoSchHItemBilling")));
		nrc.selectByVisibleText("Allow All");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='btnControlRoom']//*[@height='20']")).click();
		
		 Select newitm = new Select(driver.findElement(By.id("isNewItem")));
         newitm.selectByVisibleText("Yes");
         
		Select Ebb = new Select(driver.findElement(By.id("isTranDataBusiCode")));
		Ebb.selectByVisibleText("Yes");
		
		driver.findElement(By.xpath("//h2[@class='headingItem']//span[contains(text(),'�')]")).click();
		Thread.sleep(2000);
       
		driver.findElement(By.id("txtEBusinessCode")).sendKeys("vam@~!%123456");
		
       // driver.findElement(By.id("txtMinimumMargin")).sendKeys("987");
        //driver.findElement(By.id("txtUploadPassword")).sendKeys("123456789");
        driver.findElement(By.id("txtNote")).sendKeys("~!@#$%^&*())(**&^%$%^&@#$%^&#$%^ESXRDCVFGZXCTVYICTVFUYHNJFGVGVUGBBGBBGBGBBBGBGBBB35165456196545946///''\\\\5498698494");
        
          driver.findElement(By.xpath("//button[@id='btnControlRoom']//*[@height='20']")).click();
		
         
		
		driver.findElement(By.xpath("//h2[@class='headingItem']//span[contains(text(),'�')]")).click();
        
       /* Select hid = new Select(driver.findElement(By.id("dllHide")));
        hid.selectByVisibleText("No");*/
		    Select newitms = new Select(driver.findElement(By.id("ddlNewItem")));
	        newitms.selectByVisibleText("No");
        
        //driver.findElement(By.id("txtCreditDays")).sendKeys("300");
        driver.findElement(By.id("txtInterest")).sendKeys("31.22");
        driver.findElement(By.id("txtItems")).sendKeys("123456");
	}
	public void uploadpic() throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='btnEdit']")).click();
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection("C:\\Users\\admin\\Desktop\\123.jpg"); 
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
	public void invcmtd() throws InterruptedException{
		 List<WebElement> listinvcf= driver.findElements(By.id("ddlInvoiceFormat1"));
			int countInvc=listinvcf.size();
			System.out.println("No.of Autosuggesion "+countInvc);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countInvc;i++)
			{
				String textInvc = listinvcf.get(i).getText();
				System.out.println(textInvc);	
			}
			Thread.sleep(2000);	
			Select invc = new Select(driver.findElement(By.id("ddlInvoiceFormat1")));
			invc .selectByVisibleText("Select");
			Thread.sleep(2000);
	        
			Select invcd = new Select(driver.findElement(By.id("ddlInvoiceFormat2")));
			invcd.selectByVisibleText("GUI");
			
			Select pic = new Select(driver.findElement(By.id("ddlInvoiceFormat3")));
			pic.selectByVisibleText("NT Landscape Local with Net Amount");
			
			
			
			List<WebElement> listinvcd= driver.findElements(By.id("ddlExport"));
			int countInvcd=listinvcd.size();
			//System.out.println("No.of Autosuggesion "+countInvc);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countInvcd;i++)
			{
				String textInvcd = listinvcd.get(i).getText();
				System.out.println(textInvcd);	
			}
			Select invca = new Select(driver.findElement(By.id("ddlExport")));
			invca.selectByVisibleText("Marg");
	        
	       //Select selectByVisibleText = new Select(driver.findElement(By.id("txtColor")));
	       //selectByVisibleText.selectByVisibleText("Red");
//			Select pbh = new Select(driver.findElement(By.id("ddlPBatch")));
//			pbh.selectByVisibleText("No");
         driver.findElement(By.id("btnSave")).click();
         driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
       public void saveled(){
         driver.findElement(By.id("btn-Save")).click();
        // 
         //driver.findElement(By.id("btn-Close")).click();
        // driver.findElement(By.id("blueBtn")).click();
	}
	public static void main(String[] args) throws InterruptedException, AWTException {
		Ledger_Master_Debtor lm= new Ledger_Master_Debtor();
		lm.webLaunch();
		lm.login();
		lm.serchCompany();
		lm.Master();
		lm.newleder();
		lm.ctrlrm();
		lm.newname();
		lm.Account();
		lm.morectrlrm();
		lm.mailto();
		lm.country();
		lm.state();
		lm.city();
		lm.pin();
		lm.balance();
		//lm.openbal();
		lm.contact();
	    lm.Gst();
		lm.ledgertype();
		lm.licenceinf();
		lm.continfo();
		lm.others();
		lm.limit();
		//lm.collections();
		lm.copydealings();
		//lm.transporter();
		//lm.mr();
		/*lm.event();
		lm.Geolocation();
		lm.others2();
		lm.ledgercatgry();
		//lm.catgry();
		lm.party();
		lm.narcho();
		lm.uploadpic();
		//lm.invcmtd();
*/		lm.saveled();
	}
	
	
}
