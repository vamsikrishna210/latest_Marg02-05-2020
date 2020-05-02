package OtherMaster;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class Patient_Master {
	WebDriver driver;
	WebDriverWait Wait;
	private Pattern regexPattern;
    private Matcher regMatcher;
    public static Xls_Reader reader = new Xls_Reader(
		    	"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    String user        = 	reader.getCellData("Pant", "user", 2);
   	String pass 	   = 	reader.getCellData("Pant", "password", 2);
   	String Companyname = 	reader.getCellData("Pant", "Company_name", 2);
   	String PantPhn     = 	reader.getCellData("Pant", "Pant_Phn", 2);
   	String PantId      = 	reader.getCellData("Pant", "Pant_Id", 3);
   	String PantName	   = 	reader.getCellData("Pant", "Pant_Name", 2);
   	String Gen         = 	reader.getCellData("Pant", "Gender_Drp", 2);
   	String Agee  	   =	reader.getCellData("Pant", "Age", 2);
	String Ledg  	   =	reader.getCellData("Pant", "P_Ledger", 2);
   	String Add1		   =	reader.getCellData("Pant", "Address", 2);
   	String PinNo1	   =	reader.getCellData("Pant", "PinNo", 2);
   	String Cmsion	   =	reader.getCellData("Pant", "Commession", 2);
   	String PhnNo       =    reader.getCellData("Pant", "PhnNo", 2);
   	String Emailid     =    reader.getCellData("Pant", "EmailId", 3);
   	String Optin	   =	reader.getCellData("Pant", "More_Options", 2);
   	String Ptype       =    reader.getCellData("Pant", "Pant_Type_Drp", 2);
   	String Des         =	reader.getCellData("Pant", "Disease", 2);
 	String Pdisc       =	reader.getCellData("Pant", "Pant_Disc", 2);
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
	public void serchCompany() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 70);
		 WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
		 
		// WebElement textbox = driver.findElement(By.xpath("//*[@id='SearchBox']"));
			//textbox.clear();
		    Thread.sleep(3000);
			textbox.sendKeys(Companyname);
			Thread.sleep(5000);
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
			
			System.out.println("company Selected Sucessfully");
			/*WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			pass.sendKeys("1234");
			pass.sendKeys(Keys.ENTER);*/
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
		driver.findElement(By.linkText("Patient Master")).click();
		Thread.sleep(3000);
		
	}
	@Test(priority=3)
	public void NewPatent(){
		driver.findElement(By.xpath("//button[@id='btn-New']")).click();	
	}
	@Test(priority=4)
	public void mobilenumber() throws InterruptedException{
		WebElement phn =  driver.findElement(By.xpath("//input[@id='txtMobileNo']"));
	       phn.sendKeys(PantPhn);
	       
	       // Get the typed value
	       String typedValue = phn.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size == 12) {
				driver.findElement(By.xpath("//input[@id='txtCode']")).click();
			}

			else {
				System.out.println("No limit is set.");
				phn.clear();
				Thread.sleep(3000);
				phn.sendKeys("1234567866");
			}
		
	}
	@Test(priority=5)
	public void ID(){
		WebElement id = driver.findElement(By.xpath("//input[@id='txtCode']"));
		
		if(id.isDisplayed()){
			id.sendKeys(Keys.ENTER);
		}
		else{
			id.clear();
			id.sendKeys(PantId);
			
		}
		/**/
	}
	@Test(priority=6)
	public void patientName(){
		WebElement name = driver.findElement(By.xpath("//input[@id='txtName']"));
		name.clear();
		name.sendKeys(PantName);
	}
	@Test(priority=7)
	public void Gender(){
		Select gen = new Select(driver.findElement(By.xpath("//select[@id='txtGender']")));
		gen.selectByVisibleText(Gen);
	}
	@Test(priority=8)
	public void Age() throws InterruptedException, ParseException{
			WebElement age=  driver.findElement(By.xpath("//input[@id='txtAge']"));
		       age.sendKeys(Agee);
		       
		     /*  // Get the typed value
		       String typedValue = age.getAttribute("value");
		       int size = typedValue.length();
		       
				// Assert with expected
				if (size <= 3) {
					driver.findElement(By.xpath("//input[@id='autoCompleteLedger']"));///.sendKeys("")
				}

				else {
					System.out.println("Age is wrong");
					age.clear();
					Thread.sleep(3000);
					age.sendKeys("27");
				}*/	
		
	}
	@Test(priority=9)
	public void ledgerSelect(){
		WebElement ldgr = driver.findElement(By.xpath("//input[@id='autoCompleteLedger']"));
		ldgr.clear();
		ldgr.sendKeys(Ledg);
		List<WebElement> Ledgrop = driver.findElements(By.xpath("//*[contains(@role,'listbox')]"));
		int count=Ledgrop.size();
		System.out.println("No.of Autosuggesion "+ count);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count;i++){
			String text = Ledgrop.get(i).getText();
			System.out.println(text);	
		}
		ldgr.sendKeys(Keys.ARROW_DOWN);
		ldgr.sendKeys(Keys.ENTER);

	}
	@Test(priority=10)
	public void Adress(){
		WebElement ADD = driver.findElement(By.xpath("//textarea[@id='txtAddress']"));
		ADD.clear();
		ADD.sendKeys(Add1);
	}
	@Test(priority=11)
	public void pincode() {
		WebElement pin = driver.findElement(By.xpath("//input[@id='txtPinno']"));
		pin.clear();
		pin.sendKeys(PinNo1);		
	}
	@Test(priority=12)
	public void phonenu() throws InterruptedException {
		WebElement phn = driver.findElement(By.xpath("//input[@id='txtPhoneNo']"));
		phn.sendKeys(PhnNo);
		 String typedValue = phn.getAttribute("value");
	       int size = typedValue.length();
	       
			// Assert with expected
			if (size >= 12) {
				driver.findElement(By.xpath("//input[@id='txtEmailId']"));
			}

			else {
				System.out.println("phn no is wrong");
				phn.clear();
				Thread.sleep(3000);
				phn.sendKeys("9876543210");
			}
	}
	/*public static boolean Email(WebElement emailid){
	
		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" +  "(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$"; 
		 Pattern pat = Pattern.compile("vamsi@123.com"); 
                 if (emailid == null) 
                     return false; 
                 return pat.matcher((CharSequence) emailid).matches();    
             } 
	public void mail(){
		WebElement emailid = driver.findElement(By.xpath("//input[@id='txtEmailId']"));
	String email = "vamsi@123.com"; 
    if (Email(emailid)) 
        driver.findElement(By.xpath("//select[@id='drpIsmore']"));
    else
        System.out.print("email not valid"); 
} */
	@Test(priority=13)
		public void Email(){
			WebElement email = driver.findElement(By.xpath("//input[@id='txtEmailId']"));
			email.clear();
			email.sendKeys(Emailid);
			
			Select more = new Select(driver.findElement(By.xpath("//select[@id='drpIsmore']")));
			more.selectByVisibleText(Optin);
		}
	@Test(priority=14)
	public void MoreOptions(){
		
	if(driver.findElement(By.xpath("//*[@id='drpIsmore']/option[1]")).isSelected()){
		driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	}
	//Dob
	else if(driver.findElement(By.xpath("//*[@id='drpIsmore']/option[2]")).isSelected()){
		WebElement dateFy= driver.findElement(By.xpath("//input[@id='txtDateofBirth']"));
        dateFy.sendKeys("30042019");
        dateFy.sendKeys(Keys.ENTER);
	}
	
	}
	@Test(priority=15)
	public void typeOFPatient() throws InterruptedException{
		List<WebElement> allOptions6= driver.findElements(By.xpath("//select[@id='txtPatientType']"));
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
		Select SaleRate = new Select(driver.findElement(By.xpath("//select[@id='txtPatientType']")));
		SaleRate.selectByVisibleText(Ptype);
		
		WebElement ptyp = driver.findElement(By.xpath("//select[@id='txtPatientType']"));
		ptyp.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
	}
	@Test(priority=16)
	public void Desce() throws InterruptedException{
		WebElement des = driver.findElement(By.xpath("//input[@id='txtdisease']"));
		des.clear();
		des.sendKeys(Keys.SPACE);
		
		WebElement searchDes = driver.findElement(By.xpath("//input[@id='txtdisease']"));
		Thread.sleep(3000);
		searchDes.sendKeys(Des);
		Thread.sleep(5000);
		
		List<WebElement> DesGrop = driver.findElements(By.xpath("//ag-grid-angular[@id='diseasemester']//div[@class='ag-body-viewport ag-layout-normal']"));
		int count1=DesGrop.size();
		System.out.println("No.of Autosuggesion "+ count1);
		System.out.println("List of Autosuggesion");
		for(int j=0;j<count1;j++){
			String text = DesGrop.get(j).getText();
			System.out.println(text);	
		}
		//ldgr.sendKeys(Keys.ARROW_DOWN);
		des.sendKeys(Keys.ENTER);

	}
	@Test(priority=17)
	public void discount(){
		WebElement dics = driver.findElement(By.xpath("//input[@id='txtDiscount']"));
		dics.clear();
		dics.sendKeys(Pdisc);
	}
	@Test(priority=18)
	public void savep() throws InterruptedException{
		driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
		Thread.sleep(2000);
		
		List<WebElement> patientList = driver.findElements(By.xpath("//div[@class='ag-row ag-row-odd ag-row-level-0 noBold ag-row-position-absolute ag-row-focus ag-row-selected']"));
		int count1=patientList.size();
		System.out.println("No.of Autosuggesion "+ count1);
		System.out.println("List of Autosuggesion");
		for(int j=0;j<count1;j++){
			String text = patientList.get(j).getText();
			System.out.println(text);	
		}
		
		
	}
	/*public static void main(String[] args) throws InterruptedException, ParseException {
		Patient_Master PM = new Patient_Master();
		PM.webLaunch();
		PM.login();
		PM.serchCompany();
		PM.Master();
		PM.NewPatent();
		PM.mobilenumber();
		PM.ID();
		PM.patientName();
		PM.Gender();
		PM.Age();
		PM.ledgerSelect();
		PM.Adress();
		PM.pincode();
		PM.phonenu();
		//PM.mail();
		PM.Email();
		PM.MoreOptions();
		PM.typeOFPatient();
		PM.Desce();
		PM.discount();
		PM.savep();
	}*/

}
