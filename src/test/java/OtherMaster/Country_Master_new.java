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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Country_Master_new {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
   
    String user        = 	reader.getCellData("Country", "user", 2);
	String pass 	   = 	reader.getCellData("Country", "password", 2);
	String CompName    = 	reader.getCellData("Country", "Company_name", 2);
	String CountryName = 	reader.getCellData("Country", "Country_Name", 2);
	String MobleCode   = 	reader.getCellData("Country", "Mob_code", 2);
	String Curr        = 	reader.getCellData("Country", "Curre", 2);
	String Str         =    reader.getCellData("Country", "String", 2);
	
    
	@BeforeSuite
    public void webLaunch() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	driver.get("http://172.16.8.17/margwebsite/qa");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	Wait= new WebDriverWait(driver,20);
    	driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
	}
	@BeforeTest
	public void login() {
		
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
		Thread.sleep(3000);
		textbox.sendKeys(CompName);
		Thread.sleep(3000);
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
	public void actions() throws InterruptedException{
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Other Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Country Master")).click();
	 }
	@Test(priority=3)
	public void newb() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='btn-New']/span[1]")).click();
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void ctryname() throws InterruptedException{
		driver.findElement(By.id("txtCountryName")).sendKeys(CountryName);
		Thread.sleep(2000);
	}
	@Test(priority=5)
	public void mobilecode() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='txtCountryCode']")).sendKeys(MobleCode);
		Thread.sleep(2000);
	}
	@Test(priority=6)
	public void currsymbol(){
		driver.findElement(By.id("txtCurrencySymbol")).sendKeys(Curr);
	}
	@Test(priority=7)
	public void currstrng(){
		driver.findElement(By.id("txtCurrencyString")).sendKeys(Str);
		
	}
	@Test(priority=8)
	public void savectry(){
		driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
		
	}
	public void navg(){
		driver.navigate().back();
		//driver.navigate().refresh();
	}
	/*public static void main(String[] args) throws Exception {
		Country_Master_new ncm = new Country_Master_new();
		ncm.webLaunch();
		ncm.login();
		ncm.actions();
		ncm.newb();
		ncm.ctryname();
		ncm.mobilecode();
		ncm.currsymbol();
		ncm.currstrng();
		ncm.savectry();
		//ncm.navg();
	}*/
}
