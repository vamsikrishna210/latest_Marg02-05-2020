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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Hsn_San_new {
	
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");

	String user         =       reader.getCellData("HSN", "user", 2);
	String pass         =		reader.getCellData("HSN", "password", 2);
	String Companyname  = 		reader.getCellData("HSN", "Company_name", 2);
	String Code         = 		reader.getCellData("HSN", "Hsn_Code", 2);
	String HName        = 		reader.getCellData("HSN", "Hsn_Name", 2);

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
		WebElement textbox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
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
			driver.findElement(By.linkText("HSN/SAC Master")).click();
	 }
	@Test(priority = 2)
	public void newb(){
		driver.findElement(By.id("btn-New")).click();
	}
	@Test(priority = 3)
	public void code(){
		WebElement  cod = driver.findElement(By.id("inphsncode"));
		cod.sendKeys(Code);
		
	}
	@Test(priority = 4)
	public void name(){
		driver.findElement(By.id("inphsnname")).sendKeys(HName);
		
	}
	@Test(priority = 5)
	public void save(){
		driver.findElement(By.xpath("//*[@id='btn-Save']")).click();
	}
	/*public static void main(String[] args) throws Exception {
		Hsn_San_new hsn = new Hsn_San_new();
		hsn.webLaunch();
		hsn.login();
		hsn.action();
		hsn.newb();
		hsn.code();
		hsn.name();
		hsn.save();
	}*/
}
