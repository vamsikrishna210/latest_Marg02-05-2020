package InventoryMaster;

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

public class MFR_New {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");

	String user         =       reader.getCellData("MFR", "user", 2);
	String pass         =		reader.getCellData("MFR", "password", 2);
	String Companyname  = 		reader.getCellData("MFR", "Company_name", 2);
	String MFName       =       reader.getCellData("MFR", "MFR_Name", 2);
	String Mro          = 		reader.getCellData("MFR", "More", 2);
	String ctry         =       reader.getCellData("MFR", "Country", 2);
	String stst         =		reader.getCellData("MFR", "State", 2);
	String Ad1          = 		reader.getCellData("MFR", "Adree_1", 2);
	String ad2          = 		reader.getCellData("MFR", "Adree_2", 2);
	String ad3          = 		reader.getCellData("MFR", "Adree_3", 2);
	String emal         = 		reader.getCellData("MFR", "Email_Id", 2);
	String e1           =       reader.getCellData("MFR", "E_m1", 2);
	String e2           =		reader.getCellData("MFR", "E_m2", 2);
	String e3           =		reader.getCellData("MFR", "E_m3", 2);
	String Phno         =       reader.getCellData("MFR", "Phn_no", 2);
	String Mob1         = 		reader.getCellData("MFR", "Mobile", 2);
	String mob2         =       reader.getCellData("MFR", "Mob_2", 2);
	String mob3         =		reader.getCellData("MFR", "Mob_3", 2);
	String mob4         =		reader.getCellData("MFR", "Mob_4", 2);
	String stus         =		reader.getCellData("MFR", "Status", 2);
	String web         =		reader.getCellData("MFR", "Web_Site", 2);
	String prob         =		reader.getCellData("MFR", "Prohib", 2);

	@BeforeSuite
	public void webLaunch() {      
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.8.17/margwebsite/qa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Wait = new WebDriverWait(driver, 20);
	}

	@BeforeTest
	public void login() {
		driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(user);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();

	}

	@Test(priority = 1)
	public void action() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//input[@id='SearchBox']")));
		textbox.sendKeys(Companyname);
		List<WebElement> allOptions = driver.findElements(By
				.xpath("//*[@class='textContent']"));
		int count = allOptions.size();
		System.out.println("No.of Autosuggesion " + count);
		System.out.println("List of Autosuggesion");
		for (int i = 0; i < count; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
		}
		// textbox.sendKeys(Keys.ARROW_DOWN);
		textbox.sendKeys(Keys.ENTER);

		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.linkText("Master"));
		action.moveToElement(menu).perform();
		menu.sendKeys(Keys.ENTER);

		WebElement submenu1 = driver.findElement(By
				.linkText("Inventory Master"));
		action.moveToElement(submenu1).perform();
		submenu1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
			driver.findElement(By.linkText("Manufacturer")).click();
	 }
	@Test(priority = 2)
	public void newb(){
		driver.findElement(By.id("btn-New")).click();
	}
	@Test(priority = 3)
	public void name(){
		driver.findElement(By.id("txtName")).sendKeys(MFName);
	}
	@Test(priority = 4)
	public void more(){
		Select more = new Select(driver.findElement(By.id("drpMoreOption")));
		more.selectByVisibleText(Mro);
	}
	@Test(priority = 5)
	public void country() throws InterruptedException{
		/*Select country = new Select(driver.findElement(By.xpath("//input[@id='ddlcountry']")));
		country.selectByVisibleText("India");
		Thread.sleep(2000);*/
		
		WebElement textbox = driver.findElement(By.xpath("//*[@id='ddlcountry']"));
		textbox.clear();
		textbox.sendKeys(ctry);
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
	@Test(priority = 6)
	public void state() throws InterruptedException{
		WebElement textbox = driver.findElement(By.xpath("//input[@id='ddlstate']"));
		textbox.clear();
		textbox.sendKeys(stst);
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
	@Test(priority = 7)
	public void address(){
		driver.findElement(By.id("txtaddress1")).sendKeys(Ad1);
		driver.findElement(By.id("txtaddress2")).sendKeys(ad2);
		driver.findElement(By.id("txtaddress3")).sendKeys(ad3);
		driver.findElement(By.id("txtemail")).sendKeys(emal);
		driver.findElement(By.id("btnMoreEmail")).click();
	}
	@Test(priority = 8)
	public void addmore(){
		driver.findElement(By.id("txtEmail1")).sendKeys(e1);
		driver.findElement(By.id("txtEmail2")).sendKeys(e2);
		driver.findElement(By.id("txtEmail3")).sendKeys(e3);
		driver.findElement(By.id("btnSave")).click();
	}
	@Test(priority = 9)
	public void mobi(){

		driver.findElement(By.id("txtPhone")).sendKeys(Phno);
		driver.findElement(By.id("txtMobile")).sendKeys(Mob1);
		driver.findElement(By.id("btnMoreMobile")).click();
	}
	@Test(priority = 10)
	public void addmobi(){
		driver.findElement(By.id("txtMobile1")).sendKeys(mob2);
		driver.findElement(By.id("txtMobile2")).sendKeys(mob3);
		driver.findElement(By.id("txtMobile3")).sendKeys(mob4);
		driver.findElement(By.id("btnSave")).click();
		
	}
	@Test(priority = 11)
	public void website(){
		driver.findElement(By.id("txtWebsite")).sendKeys(web);
	}
	@Test(priority = 12)
	public void contd() throws InterruptedException{
		Select continued = new Select(driver.findElement(By.id("drpContinued")));
		continued.selectByVisibleText(stus);
		Thread.sleep(2000);
	}
	@Test(priority = 13)
	public void prohb(){
		Select Prohb = new Select(driver.findElement(By.id("drpProhibeted")));
		Prohb.selectByVisibleText(prob);
		
	}
	@Test(priority = 14)
	public void save(){
		WebElement Save = driver.findElement(By.xpath("//button[@id='btn-Save']"));
		Save.sendKeys(Keys.ENTER);
	}
/*public static void main(String[] args) throws Exception {
	MFR_New mfr = new MFR_New();
	mfr.webLaunch();
	mfr.login();
	mfr.action();
	mfr.newb();
	mfr.name();
	mfr.more();
	mfr.country();
	mfr.state();
	mfr.address();
	mfr.addmore();
	mfr.mobi();
	mfr.addmobi();
	mfr.website();
	mfr.contd();
	mfr.prohb();
	mfr.save();
	
}*/
}

