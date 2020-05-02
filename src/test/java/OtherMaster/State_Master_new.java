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

public class State_Master_new {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
	String user        = 	reader.getCellData("State", "user", 2);
	String pass 	   = 	reader.getCellData("State", "password", 2);
	String CompName    = 	reader.getCellData("State", "Company_name", 2);
	String StatName    = 	reader.getCellData("State", "State_Name", 2);
	String Cdrp        = 	reader.getCellData("State", "Country_Drp", 2);
	String Scode        = 	reader.getCellData("State", "State_Code", 2);
	//String Str         =    reader.getCellData("State", "String", 2);
	
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
			public void action() throws InterruptedException{
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Other Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("State Master")).click();
	 }
	@Test(priority=3)
	public void newb() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='btn-New']/span[1]")).click();
		Thread.sleep(2000);
}
	@Test(priority=4)
	public void selcntry(){
		/*Select options2 = new Select(driver.findElement(By.id("drpCountry")));
		options2.selectByVisibleText(Cdrp);*/
		
		WebElement Cdrop = driver.findElement(By.xpath("//input[@id='autoCompleteCountry']"));
		Cdrop.sendKeys(Cdrp);
		
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		int count=allOptions.size();
		System.out.println("No.of Autosuggesion "+count);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count;i++){
			String text = allOptions.get(i).getText();
			System.out.println(text);	
		}
		Cdrop.sendKeys(Keys.ARROW_DOWN);
		Cdrop.sendKeys(Keys.ENTER);
		
		
	}
	@Test(priority=5)
	public void stname(){
		driver.findElement(By.id("txtStateName")).sendKeys(StatName);
		
	}
	@Test(priority=6)
	public void stcode(){
		driver.findElement(By.id("txtStateCode")).sendKeys(Scode);
	}
	@Test(priority=7)
	public void stsave(){
		driver.findElement(By.id("btn-Save")).click();
	}
	/*public static void main(String[] args) throws Exception {
		State_Master_new smn = new State_Master_new();
		smn.webLaunch();
		smn.login();
		smn.action();
		smn.newb();
		smn.selcntry();
		smn.stname();
		smn.stcode();
		smn.stsave();
		}*/
}

