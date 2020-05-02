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

public class Agency_Master_New {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");

	String user			 = reader.getCellData("Agency1","user", 2);
	String pass 		 = reader.getCellData("Agency1","password", 2);
	String Companyname	 = reader.getCellData("Agency1","Company_name", 2);
	String AgencyName 	 = reader.getCellData("Agency1","Agency_Name", 2);
	String InvDx 		 = reader.getCellData("Agency1","Invoic_InD", 2);
	String Dump 		 = reader.getCellData("Agency1","Dump_day", 2);
	String Mro 			 = reader.getCellData("Agency1","More", 2);
	String Rmks 		 = reader.getCellData("Agency1","Remarks", 2);
	String Sttus		 = reader.getCellData("Agency1","Status", 2);
	String reorderPre	 = reader.getCellData("Agency1","Re_Ord_Pref", 2);
	String Strprf 		 = reader.getCellData("Agency1","store_No", 2);
	String proh 		 = reader.getCellData("Agency1","Prohib", 2);
	String exrev 		 = reader.getCellData("Agency1","Exp_Reciv", 2);
	String formulre 	 = reader.getCellData("Agency1","Reo_Form", 2);
	String minMar 		 = reader.getCellData("Agency1","Min_Mar", 2);
	String main			 = reader.getCellData("Agency1","Main", 2);
	String CC 			 = reader.getCellData("Agency1","cc", 2);
	String Bcc 			 = reader.getCellData("Agency1","bcc", 2);
	String Ur			 = reader.getCellData("Agency1","url", 2);

	@BeforeSuite
	public void webLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.8.17/margwebsite/qa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
	}

	@BeforeTest
	public void login() {
		
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
		Thread.sleep(3000);
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
		driver.findElement(By.linkText("Agency Master")).click();
	}

	@Test(priority = 2)
	public void newb() {
		driver.findElement(By.id("btn-New")).click();
	}
	
	
	
	@Test(priority = 3)
	public void create() throws InterruptedException {
		WebElement agencynm = driver.findElement(By.id("txtCName"));
		agencynm.sendKeys(AgencyName);
		agencynm.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.xpath("//span[contains(text(),'Agency name already exists !')]"));
		System.out.println(e1.getText());
		
		if(e1.getText().equals("Agency name already exists !")){
			agencynm.clear();
			agencynm.sendKeys("12345Ag");
			agencynm.sendKeys(Keys.ENTER);
		}
			
		
		driver.findElement(By.id("txtbillprint")).sendKeys(InvDx);
		driver.findElement(By.id("txtDumpdays")).sendKeys(Dump);
	}

	@Test(priority = 4)
	public void more() {
		Select MORE = new Select(driver.findElement(By.id("drpMoreOption")));
		MORE.selectByVisibleText(Mro);
	}

	@Test(priority = 5)
	public void rremark() {
		driver.findElement(By.id("txtRemark")).sendKeys(Rmks);
	}

	@Test(priority = 6)
	public void contn() {
		Select countinue = new Select(driver.findElement(By.id("drpContinued")));
		countinue.selectByVisibleText(Sttus);
	}

	@Test(priority = 7)
	public void recordandstrno() {
		driver.findElement(By.id("txtReorderPref")).sendKeys(reorderPre);
		driver.findElement(By.xpath("//*[@id='txtStoreNo']")).sendKeys(Strprf);
	}

	@Test(priority = 8)
	public void prohib() {
		Select prohibited = new Select(driver.findElement(By.id("drpProhibit")));
		prohibited.selectByVisibleText(proh);
	}

	@Test(priority = 9)
	public void reordermini() throws InterruptedException {
		WebElement exp = driver.findElement(By.id("txtExpireReceiveUpto"));
		exp.clear();
		Thread.sleep(2000);
		exp.sendKeys(exrev);
		exp.sendKeys(Keys.ENTER);

		WebElement reo = driver.findElement(By
				.xpath("//*[@id='txtReorderFormula']"));
		reo.clear();
		Thread.sleep(2000);
		reo.sendKeys(formulre);
		reo.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='txtMinmargin']"))
				.sendKeys(minMar);
	}

	@Test(priority = 10)
	public void webemail() {
		driver.findElement(By.xpath("//*[@id='btnAddMore']")).click();
		driver.findElement(By.id("txtEmain")).sendKeys(main);
		driver.findElement(By.id("txtEcc")).sendKeys(CC);
		driver.findElement(By.id("txtEbcc")).sendKeys(Bcc);
		driver.findElement(By.xpath("//*[@id='txtWebsite']")).sendKeys(Ur);
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
	}

	@Test(priority = 11)
	public void save() {
		driver.findElement(By.xpath("//*[@id='btn-Save']/span[1]")).click();
	}

	public static void main(String[] args) throws Exception {
		Agency_Master_New an = new Agency_Master_New();
		an.webLaunch();
		an.login();
		an.action();
		an.newb();
		an.create();
		an.more();
		// an.rremark();
		// //an.contn();
		// an.recordandstrno();
		// an.prohib();
		an.reordermini();
		an.webemail();
		an.save();

	}

}
