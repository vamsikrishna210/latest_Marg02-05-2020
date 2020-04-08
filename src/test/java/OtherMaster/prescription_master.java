package OtherMaster;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
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
//Need to complete After Id Given to unit
public class prescription_master {
	WebDriver driver;
	WebDriverWait Wait;
	/*private Pattern regexPattern;
    private Matcher regMatcher;*/
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    String user        = 	reader.getCellData("Prescrip", "user", 2);
	String pass 	   = 	reader.getCellData("Prescrip", "password", 2);
	String Companyname = 	reader.getCellData("Prescrip", "Company_name", 2);
	String Predays1     = 	reader.getCellData("Prescrip", "Pre_Days", 2);
	String Patients    = 	reader.getCellData("Prescrip", "P_Id", 3);
	String PSerchType  = 	reader.getCellData("Prescrip", "P_Type_Serch", 2);
	String PMob        = 	reader.getCellData("Prescrip", "P_Mobile", 2);
	String pName	   =	reader.getCellData("Prescrip", "P_Nmae", 2);
	String DSearchType =	reader.getCellData("Prescrip", "D_Type_Serch", 2);
	String DocRg	   =	reader.getCellData("Prescrip", "Doc_Reg", 2);
	String DocNam	   =	reader.getCellData("Prescrip", "Doc_Name", 2);
	String DocMob      =    reader.getCellData("Prescrip", "Doc_Mob", 2);
	String DocId       =    reader.getCellData("Prescrip", "Doc_Id", 3);
	String MrDrp	   =	reader.getCellData("Prescrip", "Mor", 2);
	String Admi        =    reader.getCellData("Prescrip", "AdmissionDate", 2);
	String Discg       =	reader.getCellData("Prescrip", "DischargeDate", 2);
	String Digo        = 	reader.getCellData("Prescrip", "Dig", 2);
	String Old	       =	reader.getCellData("Prescrip", "Old", 2);
	String Item        =	reader.getCellData("Prescrip", "Item_serch", 2);
	String PDays	   =	reader.getCellData("Prescrip", "PrescDays", 2);
	String Qty   	   =	reader.getCellData("Prescrip", "QTY1", 2);
	String Unitd       =    reader.getCellData("Prescrip", "Unitdrp1", 2);
	String Dy          =    reader.getCellData("Prescrip", "Days", 3);
	String Rate		   =	reader.getCellData("Prescrip", "Rate", 2);
	String Dose1	   =	reader.getCellData("Prescrip", "Dose", 2);
	
    
	@BeforeSuite
    public void webLaunch() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	driver.get("http://172.16.8.17/margwebsite/qa");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
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
		//textbox.sendKeys(Keys.ARROW_DOWN);
		textbox.sendKeys(Keys.ENTER);
	}
	@Test(priority=2)
	public void Master() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.linkText("Master"));
		action.moveToElement(menu).perform();
		menu.sendKeys(Keys.ENTER);
		
		WebElement submenu1 = driver.findElement(By.linkText("Other Master"));
		action.moveToElement(submenu1).perform();
		submenu1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Prescription Master")).click();
		Thread.sleep(3000);
		
	}
	@Test(priority=3)
	public void prenew(){
		driver.findElement(By.xpath("//button[@id='btn-New']")).click();
	}
	@Test(priority=4)
	public void date() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.now();
		// WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control mydate ng-valid ng-touched ng-dirty'and@id='txtbillDate']")));
		 WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtPresDate']")));
		 //WebElement dateFy= driver.findElement(By.xpath("//input[@id='txtbillDate']"));  
		 Date.sendKeys(dtf.format(date));
		 
		 Thread.sleep(3000);
		 Date.sendKeys(Keys.ENTER);
		 //Date.sendKeys(Keys.ENTER);
	}
	@Test(priority=5)
	public void perdays() throws InterruptedException{
		WebElement days =  driver.findElement(By.xpath("//input[@id='txtPresForDay']"));
		days.sendKeys(Predays1);
	       
	       // Get the typed value
	       String typedValue = days.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size <= 3) {
				driver.findElement(By.xpath("//*[contains(@id,'txtPatientCode')]"));
			}

			else {
				System.out.println("No limit is set.");
				days.clear();
				Thread.sleep(3000);
				days.sendKeys("365");
			}
	}
	@Test(priority=6)
	public void serpatient() throws InterruptedException{
		WebElement pat = driver.findElement(By.xpath("//*[contains(@id,'txtPatientCode')]"));
		pat.sendKeys(Keys.SPACE);
		
		Select type = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		type.selectByVisibleText(PSerchType);
		Thread.sleep(2000);
		
		if (driver.findElement(By.xpath("//option[contains(text(),'All')]")).isSelected()) {
			WebElement serpat = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serpat.click();
			Thread.sleep(3000);
			//serpat.clear();
			serpat.sendKeys(Patients);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'patientGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serpat.sendKeys(Keys.ENTER);
			
		}
		else if (driver.findElement(By.xpath("//option[contains(text(),'Mobile No')]")).isSelected()){
			WebElement serpat = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serpat.click();
			Thread.sleep(3000);
			serpat.sendKeys(PMob);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'patientGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serpat.sendKeys(Keys.ENTER);
			
		}
		else if (driver.findElement(By.xpath("//option[contains(text(),'Name')]")).isSelected()){
			WebElement serpat = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serpat.click();
			Thread.sleep(3000);
			serpat.sendKeys(pName);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'patientGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serpat.sendKeys(Keys.ENTER);
		}
		else if (driver.findElement(By.xpath("//option[contains(text(),'Patient ID')]")).isSelected()){
			WebElement serpat = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serpat.click();
			Thread.sleep(3000);
			serpat.sendKeys(Patients);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'patientGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serpat.sendKeys(Keys.ENTER);
		}
	
	}
	@Test(priority=7)
	public void  DocSer() throws InterruptedException{
		WebElement docser1 = driver.findElement(By.xpath("//input[@id='txtdoctorCode']"));
		docser1.sendKeys(Keys.SPACE);
		
		Select type = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		type.selectByVisibleText(DSearchType);
		Thread.sleep(2000);
		
		if (driver.findElement(By.xpath("//option[contains(text(),'All')]")).isSelected()) {
			WebElement serdoc = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serdoc.clear();
			serdoc.sendKeys(DocNam);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'doctorGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serdoc.sendKeys(Keys.ENTER);
			
		}
		else if (driver.findElement(By.xpath("//option[contains(text(),'Mobile No')]")).isSelected()){
			WebElement serdoc = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serdoc.clear();
			serdoc.sendKeys(DocMob);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'doctorGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serdoc.sendKeys(Keys.ENTER);
		}
		else if (driver.findElement(By.xpath("//option[contains(text(),'Name')]")).isSelected()){
			WebElement serdoc = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serdoc.clear();
			serdoc.sendKeys(DocNam);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'doctorGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serdoc.sendKeys(Keys.ENTER);
		}
		else if (driver.findElement(By.xpath("//option[contains(text(),'Doctor ID')]")).isSelected()){
			WebElement serdoc = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serdoc.clear();
			serdoc.sendKeys(DocId);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'doctorGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serdoc.sendKeys(Keys.ENTER);
		}
		else if (driver.findElement(By.xpath("//option[contains(text(),'Registration No')]")).isSelected()){
			WebElement serdoc = driver.findElement(By.xpath("//input[@id='SearchBox']"));
			serdoc.clear();
			serdoc.sendKeys(DocRg);
			
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'doctorGrid')]"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			//textbox.sendKeys(Keys.ARROW_DOWN);
			serdoc.sendKeys(Keys.ENTER);
		}
		
	}
	@Test(priority=8)
	public void moreOpt() throws InterruptedException{
		Select moropt = new Select(driver.findElement(By.xpath("//select[@id='txtisMore']")));
		moropt.selectByVisibleText(MrDrp);
		
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id='txtisMore']/option[1]")).isSelected()) {
			WebElement opt = driver.findElement(By.xpath("//select[@id='txtisMore']"));
			opt.sendKeys(Keys.ENTER);	
		}
		else if (driver.findElement(By.xpath("//*[@id='txtisMore']/option[2]")).isSelected()){
			WebElement admison = driver.findElement(By.xpath("//input[@id='txtDateofAddmission']"));
			admison.sendKeys(Admi);
			
			WebElement Discharge = driver.findElement(By.xpath("//input[@id='txtDateofDischarge']"));
			Discharge.sendKeys(Discg);
			
			WebElement dign = driver.findElement(By.xpath("//input[@id='txtDiagnosis']"));
			dign.sendKeys(Digo);
			
			String typedValue1 = dign.getAttribute("value");
		       int size = typedValue1.length();
		       
				// Assert with expected
				if (size <= 45) {
					driver.findElement(By.xpath("//input[@id='txtOldHistory']"));
				}

				else {
					System.out.println("No limit is set.");
					dign.clear();
					Thread.sleep(3000);
					dign.sendKeys("Mild Fever with 102 temp");  
				}
				Thread.sleep(2000);
				WebElement perdign = driver.findElement(By.xpath("//input[@id='txtOldHistory']"));
				perdign.sendKeys(Old);
				
				String typedValue2 = perdign.getAttribute("value");
			       int size1 = typedValue2.length();
			       
					// Assert with expected
					if (size1 <= 45) {
						WebElement perdign3 = driver.findElement(By.xpath("//input[@id='txtOldHistory']"));
						perdign3.sendKeys(Keys.ENTER);
					}

					else {
						System.out.println("No limit is set.");
						perdign.clear();
						Thread.sleep(3000);
						perdign.sendKeys("no desise");  
					}
				perdign.sendKeys(Keys.ENTER);
		}
		}
	@Test(priority=9)
	public void ItemSelect() throws InterruptedException{
		WebElement itemdrp = driver.findElement(By.xpath("//*[contains(@id,'txt-itemLinkID')]"));
		itemdrp.clear();
		itemdrp.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		WebElement itemserch = driver.findElement(By.xpath("//input[@id='searchItems']"));
		itemserch.clear();
		itemserch.sendKeys(Item);
		Thread.sleep(5000);
		List<WebElement> allOptions1 = driver.findElements(By.xpath("//*[contains(@id,'temGrid')]"));
		int count1=allOptions1.size();
		System.out.println("No.of Autosuggesion "+count1);
		System.out.println("List of Autosuggesion");
		for(int k=0;k<count1;k++){
			String text = allOptions1.get(k).getText();
			System.out.println(text);	
		}
		//textbox.sendKeys(Keys.ARROW_DOWN);
		itemserch.sendKeys(Keys.ENTER);	
	
	}
	@Test(priority=10)
	public void presdays() throws InterruptedException{
		Thread.sleep(5000);
		WebElement perday = driver.findElement(By.xpath("//*[contains(@id,'txt-Day')]"));
		perday.clear();
		perday.sendKeys(PDays);
		perday.sendKeys(Keys.ENTER);
	
	}
	@Test(priority=11)
	public void Dose() throws InterruptedException{
		WebElement Dose = driver.findElement(By.xpath("//*[contains(@id,'txt-Dose-0')]"));
		//Dose.clear();
		Dose.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Dose.sendKeys(Dose1);
		Dose.sendKeys(Keys.ENTER);
	}
	@Test(priority=12)
	public void QTY() throws InterruptedException{
		WebElement quantity = driver.findElement(By.xpath("//*[contains(@id,'txt-Quantity')]"));
		//quantity.clear();
		quantity.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		quantity.sendKeys(Qty);
		quantity.sendKeys(Keys.ENTER);
	}
	@Test(priority=13)
	public void unitdrp(){
		WebElement Unit = driver.findElement(By.xpath("//select[@id='drpunit-UnitLinkid-0']"));
		Select unit = new Select (driver.findElement(By.xpath("//select[@id='drpunit-UnitLinkid-0']")));
		unit.selectByVisibleText(Unitd);
		Unit.sendKeys(Keys.ENTER);
		
	}
	@Test(priority=14)
	public void Days (){
		WebElement days = driver.findElement(By.xpath("//select[@id='drp-Yesno-0']"));
		Select day = new Select (driver.findElement(By.xpath("//select[@id='drp-Yesno-0']")));
		//day.selectByVisibleText(Dy);
		day.selectByIndex(0);
		days.sendKeys(Keys.ENTER);
	}
	@Test(priority=15)
	
	public  void  rate(){
		WebElement rate = driver.findElement(By.xpath("//input[@id='txt-Rate-0']"));
			if(rate.isDisplayed())	{
				rate.sendKeys(Keys.ENTER);
			}
			else{
				rate.sendKeys(Keys.BACK_SPACE);
				rate.sendKeys(Rate);
				rate.sendKeys(Keys.ENTER);
			}
		
	}
	@Test(priority=16)
	public void pressave(){
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
	}
		
	
	/*public static void main(String[] args) throws InterruptedException {
		prescription_master pam = new prescription_master();
		pam.webLaunch();
		pam.login();
		pam.serchCompany();
		pam.Master();
		pam.prenew();
		pam.date();
		pam.perdays();
		pam.serpatient();
		pam.DocSer();
		pam.moreOpt();
		pam.ItemSelect();
		pam.presdays();
		pam.Dose();
		pam.QTY();
		pam.unitdrp();
		pam.Days();
		pam.rate();
	}*/
}
