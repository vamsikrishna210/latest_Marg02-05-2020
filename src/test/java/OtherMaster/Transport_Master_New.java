package OtherMaster;

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

public class Transport_Master_New {
	WebDriver driver;
	WebDriverWait Wait;
	
	public static Xls_Reader reader = new Xls_Reader("C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    String user        = 	reader.getCellData("Trnspt", "user", 2);
	String pass 	   = 	reader.getCellData("Trnspt", "password", 2);
	String Companyname = 	reader.getCellData("Trnspt", "Company_name", 2);
	String TrnsName    = 	reader.getCellData("Trnspt", "Trn_Name", 2);
	
	
	String mor         = 	reader.getCellData("Trnspt", "more", 2);
	String A1 	       = 	reader.getCellData("Trnspt", "Add_1", 2);
	String A2          = 	reader.getCellData("Trnspt", "Add_2", 2);
	String A3          = 	reader.getCellData("Trnspt", "Add_3", 2);
	
	
	String stat        = 	reader.getCellData("Trnspt", "State_Tran", 2);
	String pin 	       = 	reader.getCellData("Trnspt", "Pin_Code", 2);
	String phn         = 	reader.getCellData("Trnspt", "Phno", 2);
	String Mob         = 	reader.getCellData("Trnspt", "Mobile", 2);
	
	
	String M1          = 	reader.getCellData("Trnspt", "Mob1", 2);
	String M2 	       = 	reader.getCellData("Trnspt", "Mob2", 2);
	String M3          = 	reader.getCellData("Trnspt", "Mob3", 2);
	String Mod         = 	reader.getCellData("Trnspt", "Mode", 2);
	
	String stus          = 	reader.getCellData("Trnspt", "Status", 2);
	String Gstin         = 	reader.getCellData("Trnspt", "Gstin", 2);
	
	
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
		WebDriverWait wait = new WebDriverWait(driver, 40);
		 WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
		 
		// WebElement textbox = driver.findElement(By.xpath("//*[@id='SearchBox']"));
			//textbox.clear();
		 Thread.sleep(3000);
			textbox.sendKeys(Companyname);
			
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
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Other Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Transport Master")).click();
	 }
	@Test(priority=2)
	public void newb() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='btn-New']/span[1]")).click();
		Thread.sleep(2000);
}
	@Test(priority=3)
	public void nwname(){
	
		WebElement Tname =driver.findElement(By.id("txtTransportName"));
		Tname.sendKeys(TrnsName);
	}
	@Test(priority=4)
	public void more(){
		Select options = new Select(driver.findElement(By.id("ddlMore")));
		options.selectByVisibleText("Yes");
	}
	@Test(priority=5)
	public void addrss(){
		driver.findElement(By.xpath("//*[@id='txtAddress1']")).sendKeys(A1);
		driver.findElement(By.xpath("//*[@id='txtAddress2']")).sendKeys(A2);
		driver.findElement(By.xpath("//*[@id='txtAddress3']")).sendKeys(A3);
	
	}
	@Test(priority=6)
	public void Trstate(){
		WebElement state = driver.findElement(By.xpath("//input[@id='ddlstate']"));
		state.sendKeys(stat);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ENTER);
	
	}
	@Test(priority=7)
	public void pincd(){
		WebElement pincd = driver.findElement(By.xpath("//input[@id='Pin']"));
		pincd.sendKeys(pin);
		pincd.sendKeys(Keys.ENTER);
	}
	@Test(priority=8)
	public void contact(){
		WebElement phn1 = driver.findElement(By.xpath("//input[@id='PhoneNo']"));
		phn1.sendKeys(phn);
		phn1.sendKeys(Keys.ENTER);
		
		WebElement mbl = driver.findElement(By.xpath("//input[@id='MobileNo']"));
		mbl.sendKeys(Mob);
		mbl.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//button[@id='addButtonMobile']")).click();
		WebElement m1= driver.findElement(By.xpath("//input[@id='txtMobile1']"));
		m1.sendKeys(M1);
		m1.sendKeys(Keys.ENTER);
		WebElement m2 = driver.findElement(By.xpath("//input[@id='txtMobile2']"));
		m2.sendKeys(M2);
		m2.sendKeys(Keys.ENTER);
		WebElement m3 = driver.findElement(By.xpath("//input[@id='txtMobile3']"));
		m3.sendKeys(M3);
		m3.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
	}
	@Test(priority=9)
	public void status(){
		Select options2 = new Select(driver.findElement(By.id("ddlStatus")));
		options2.selectByVisibleText(stus);
		WebElement stat = driver.findElement(By.xpath("//select[@id='ddlTranspostMode']"));
		stat.sendKeys(Keys.ENTER);
	}
	@Test(priority=10)
	public void mode(){
		Select options3 = new Select(driver.findElement(By.id("ddlTranspostMode")));
		options3.selectByVisibleText(Mod);
		WebElement mod = driver.findElement(By.xpath("//select[@id='ddlStatus']"));
		mod.sendKeys(Keys.ENTER);
	}
	@Test(priority=11)
	public void trGst(){
		WebElement gst = driver.findElement(By.xpath("//input[@id='Gstin']"));
		gst.sendKeys(Gstin);
		driver.findElement(By.id("btn-Save")).click();
	}
	/*@Test(priority=12)
	public void navig(){
		driver.navigate().refresh();
	}*/
	/*public static void main(String[] args) throws Exception {
		Transport_Master_New tmn = new Transport_Master_New();
		tmn.webLaunch();
		tmn.login();
		tmn.action();
		tmn.newb();
		tmn.controlroom();
		tmn.closectrl();
		tmn.nwname();
		tmn.more();
		tmn.addrss();
		tmn.Trstate();
		tmn.pincd();
		tmn.contact();
		tmn.status();
		tmn.mode();
		tmn.trGst();
		tmn.navig();
	}*/
}
