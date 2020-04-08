package OtherMaster;

import java.util.List;
import java.util.concurrent.TimeUnit;









//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import org.openqa.selenium.By;
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

public class Doctor_Master {
	WebDriver driver;
	WebDriverWait Wait;
	/*private Pattern regexPattern;
    private Matcher regMatcher;*/
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    String user        = 	reader.getCellData("Doc", "user", 2);
	String pass 	   = 	reader.getCellData("Doc", "password", 2);
	String Companyname = 	reader.getCellData("Doc", "Company_name", 2);
	String DocPhn      = 	reader.getCellData("Doc", "Doc_Phn", 2);
	String DocPhn1     = 	reader.getCellData("Doc", "Doc_Phn", 3);
	String DocId1	   = 	reader.getCellData("Doc", "Doc_Id", 2);
	String DocReg      = 	reader.getCellData("Doc", "Doc_Reg", 2);
	String DocName	   =	reader.getCellData("Doc", "Doc_Name", 2);
	String HsptlName   =	reader.getCellData("Doc", "Hsptl_Name", 2);
	String Splx		   =	reader.getCellData("Doc", "Specilization", 2);
	String Cmsion	   =	reader.getCellData("Doc", "Commession", 2);
	String Address     =    reader.getCellData("Doc", "Address", 2);
	String Address2    =    reader.getCellData("Doc", "Address", 3);
	String Pin		   =	reader.getCellData("Doc", "PinNo", 2);
	String PhoneNo     =    reader.getCellData("Doc", "PhnNo", 2);
	String DEmailId    =	reader.getCellData("Doc", "EmailId", 2);
	
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
		driver.findElement(By.linkText("Doctor Master")).click();
		Thread.sleep(3000);
		
	}
	@Test(priority=3)
	public void NewDoc(){
		driver.findElement(By.xpath("//button[@id='btn-New']")).click();	
	}
	@Test(priority=4)
	public void MobileNO() throws InterruptedException{
		WebElement phn =  driver.findElement(By.xpath("//input[@id='txtMobileNumber']"));
	       phn.sendKeys(DocPhn);
	       
	       // Get the typed value
	       String typedValue = phn.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size == 12) {
				driver.findElement(By.xpath("//input[@id='txtCode']")).sendKeys(DocId1);
			}

			else {
				System.out.println("No limit is set.");
				phn.clear();
				Thread.sleep(3000);
				phn.sendKeys(DocPhn1);
				phn.sendKeys(Keys.ENTER);
				//Thread.sleep(2000);
				/*WebElement e1 = driver.findElement(By.xpath("//div[@class='popover-body']"));
				       System.out.println(e1.getText());
				       if(e1.getText().equals("MobileNo already exists !")){
					    phn.clear();
					   phn.sendKeys(DocPhn1);*/
				}
			}
			
			
	//}
	@Test(priority=5)
	public void ID(){
		WebElement DocId = driver.findElement(By.xpath("//input[@id='txtCode']"));
		if(DocId.isDisplayed()){
			DocId.sendKeys(Keys.ENTER);
		}
		else{
		DocId.clear();
		DocId.sendKeys(DocId1);
	}
		}
	@Test(priority=6)
	public void RegNo(){
		WebElement Regno = driver.findElement(By.xpath("//input[@id='txtRegno']"));
		Regno.clear();
		Regno.sendKeys(DocReg);
	}
	@Test(priority=7)
	public void name(){
		WebElement DcName = driver.findElement(By.xpath("//input[@id='txtName']"));
		DcName.clear();
		DcName.sendKeys(DocName);
	
	}
	@Test(priority=8)
	public void Hosp(){
		WebElement Hosp = driver.findElement(By.xpath("//input[@id='txtHosiptalName']"));
		Hosp.clear();
		Hosp.sendKeys(HsptlName);
	}
	@Test(priority=9)
	public void Special() throws InterruptedException{
		WebElement splization = driver.findElement(By.xpath("//input[@id='txtSpecialisationId']"));
		splization.clear();
		splization.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		WebElement SearchBoxSp = driver.findElement(By.xpath("//*[@id='SearchBox']"));
		SearchBoxSp.clear();
		SearchBoxSp.sendKeys(Splx);
		
		List<WebElement> SPLI= driver.findElements(By.xpath("//*[contains(@id,'specializationGrid')]"));
		int count2=SPLI.size();
		System.out.println("No.of Autosuggesion "+count2);
		System.out.println("List of Autosuggesion");
		for(int j=0;j<count2;j++){
			String text1 = SPLI.get(j).getText();
			System.out.println(text1);	
		}
		splization.sendKeys(Keys.ENTER);	
	}
	@Test(priority=10)
	public void commission(){
		WebElement com = driver.findElement(By.xpath("//input[@id='txtCommision']"));
		com.clear();
		com.sendKeys(Cmsion);
	}
	@Test(priority=11)
	public void adddoc() throws InterruptedException{
		WebElement ADD = driver.findElement(By.xpath("//textarea[@id='txtAddress']"));
	    ADD.clear();
	    ADD.sendKeys(Address);
	       // Get the typed value
	       String typedValue = ADD.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size <=135 ) {
				driver.findElement(By.xpath("//input[@id='txtPinno']"));//.sendKeys("110035")
			}

			else {
				System.out.println("No limit is set.");
				ADD.clear();
				Thread.sleep(3000);
				ADD.sendKeys(Address2);
			} 
	}
	@Test(priority=12)
	public void pincode(){
		WebElement pincode = driver.findElement(By.xpath("//input[@id='txtPinno']"));
		pincode.sendKeys(Pin);
	}
	@Test(priority=13)
	public void phnNi() throws InterruptedException{
		WebElement phone = driver.findElement(By.xpath("//input[@id='txtPhoneno']"));
		phone.sendKeys(PhoneNo);
		 // Get the typed value
	       String typedValue = phone.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size <=12 ) {
				driver.findElement(By.xpath("//input[@id='txtEmailId']"));//.sendKeys("110035")
			}

			else {
				System.out.println("No limit is set.");
				phone.clear();
				Thread.sleep(3000);
				phone.sendKeys("98979998789");
			} 
	}
	@Test(priority=14)
	public void email(){
		WebElement email = driver.findElement(By.xpath("//input[@id='txtEmailId']"));
		email.sendKeys(DEmailId);
	}
	@Test(priority=15)
	public void save(){
		driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	}
	/*public static void main(String[] args) throws InterruptedException {
		Doctor_Master DM = new Doctor_Master();
		DM.webLaunch();
		DM.login();
		DM.serchCompany();
		DM.Master();
		DM.NewDoc();
		DM.MobileNO();
		DM.ID();
		DM.RegNo();
		DM.name();
		DM.Hosp();
		DM.Special();
		DM.commission();
		DM.adddoc();
		DM.pincode();
		DM.phnNi();
		DM.email();
		DM.save();
	}*/
}
