package AccountsMaster;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sale_Master_New {
	WebDriver driver;
	WebDriverWait Wait;

	@BeforeSuite
	public void webLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.8.17/margwebsite/qa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Wait = new WebDriverWait(driver, 20);
	}

	@BeforeTest
	public void login() {
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();

	}

	@Test(priority = 1)
	public void action() throws InterruptedException {
		WebElement textbox = driver.findElement(By
				.xpath("//*[@id='searchItems']"));
		textbox.clear();
		textbox.sendKeys("vkg");
		Thread.sleep(2000);
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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.linkText("Master"));
		action.moveToElement(menu).perform();
		menu.sendKeys(Keys.ENTER);

		WebElement submenu1 = driver
				.findElement(By.linkText("Accounts Master"));
		action.moveToElement(submenu1).perform();
		submenu1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sale Master")).click();
	}

	@Test(priority = 2)
	public void news() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //button[@title='New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtSaleType")).sendKeys("Gst Sale - 10%");

	}

	@Test(priority = 3)
	public void local() throws InterruptedException {
		WebElement textbox = driver.findElement(By.id("txtlocal"));
		textbox.clear();
		textbox.sendKeys("s");
		Thread.sleep(2000);
		List<WebElement> allOptions = driver.findElements(By
				.xpath("//*[@class='dropdown-menu show']"));
		int count = allOptions.size();
		System.out.println("No.of Autosuggesion " + count);
		System.out.println("List of Autosuggesion");
		for (int i = 0; i < count; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
		}
		textbox.sendKeys(Keys.ARROW_DOWN);
		textbox.sendKeys(Keys.ENTER);

		// Select local= new
		// Select(driver.findElement(By.xpath("//*[@class='dropdown-menu show']")));
		// local.selectByVisibleText("CGST Output");
	}

	@Test(priority = 4)
	public void central() throws InterruptedException {
		WebElement tbLocal = driver.findElement(By
				.xpath("//input[@id='txtcentral']"));
		tbLocal.clear();
		tbLocal.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		List<WebElement> allOption = driver.findElements(By
				.xpath("//*[@class='dropdown-menu show']"));
		int count = allOption.size();
		System.out.println("No of Autosuggesion" + count);
		System.out.println("List of Autosuggesion");
		for (int i = 0; i < count; i++) {
			String text = allOption.get(i).getText();
			System.out.println(text);
		}
		tbLocal.sendKeys(Keys.ARROW_DOWN);
		tbLocal.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		/*
		 * Select cntrl= new
		 * Select(driver.findElement(By.xpath("//*[@class='dropdown-menu show']"
		 * ))); cntrl.selectByVisibleText("Sales");
		 */

	}

	@Test(priority = 5)
	public void taxtype() throws InterruptedException {
		WebElement TT = driver.findElement(By.id("txtigst"));
		// TT.clear();
		TT.sendKeys("12");
		TT.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		WebElement Cess = driver.findElement(By.id("txtcess"));
		Cess.sendKeys("6");
		Cess.sendKeys(Keys.ENTER);
	}

	@Test(priority = 6)
	public void NaturTransation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		/*
		 * try{ WebElement radio1 =
		 * driver.findElement(By.id("NatureofTransaction2")); radio1.click(); }
		 * catch(Exception e){ e.printStackTrace(); }
		 */
		 driver.findElement(By.xpath("//input[@id='NatureofTransaction4']")).click();

		/*
		 * List<WebElement> list = driver.findElements(By.xpath(
		 * "//input[@name='natureOfTransaction' and @type='radio']"));
		 * 
		 * System.out.println(list.size());
		 * 
		 * for (WebElement e : list) {
		 * System.out.println(e.getAttribute("value"));
		 * System.out.println(e.isSelected());
		 * 
		 * Thread.sleep(5000); if (e.getAttribute("value").equals("Export1")) {
		 * e.click(); }
		 * 
		 * // }
		 */
	/*	List<WebElement> list = driver
				.findElements(By
						.xpath("//input[@name='natureOfTransaction' and @type='radio']"));
		for (int i = 0; i < list.size(); i++) {
			WebElement local_radio = list.get(i);
			String FOR = local_radio.getAttribute("id");
			System.out.println("values of radio buttom------>" + FOR);
			Thread.sleep(5000);
			if (FOR.equals("NatureofTransaction2")) {
				local_radio.click();
			}
*/}
	
		 @Test(priority = 7)
			public void taxblity(){
			
			
				 
		 }
		}
	

