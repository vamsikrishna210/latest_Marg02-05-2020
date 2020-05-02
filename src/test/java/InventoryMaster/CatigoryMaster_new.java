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

public class CatigoryMaster_new {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");

	String user = reader.getCellData("HSN", "user", 2);
	String pass = reader.getCellData("HSN", "password", 2);
	String Companyname = reader.getCellData("HSN", "Company_name", 2);
	String catname = reader.getCellData("HSN", "Cat_Name", 2);
	String catname2 = reader.getCellData("HSN", "Cat_Name_re", 2);
	

	@BeforeSuite
	public void webLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.8.17/margwebsite/qa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
			driver.findElement(By.linkText("Category Master")).click();
	 }
	@Test(priority = 4)
	public void newb(){
		driver.findElement(By.id("btn-New")).click();
	}
	@Test(priority = 5)
	public void newcat() throws InterruptedException{
		WebElement catnm = driver.findElement(By.id("txtCategoryName"));
		catnm.sendKeys(catname);
		catnm.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.xpath("//span[contains(text(),'Category name already exists !')]"));
		System.out.println(e1.getText());
		
		if(e1.getText().equals("Category name already exists !")){
			catnm.clear();
			catnm.sendKeys(catname2);
			catnm.sendKeys(Keys.ENTER);
		}
		
	}
	@Test(priority = 6)
	public void save(){
		driver.findElement(By.xpath("//*[@id='btn-Save']/span[1]")).click();
		
	}
	/*@Test(priority = 7)
	public void ref(){
		driver.navigate().refresh();
	}*/
	/*public static void main(String[] args) throws InterruptedException {
		CatigoryMaster_new nc = new CatigoryMaster_new();
		nc.webLaunch();
		nc.login();
		nc.action();
		nc.newb();
		nc.newcat();
		nc.save();
		
			
		
	}*/
}
