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

import com.margerp.qa.xls_Reader.Xls_Reader;

public class station_Master_new {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    String user        = 	reader.getCellData("Station", "user", 2);
	String pass 	   = 	reader.getCellData("Station", "password", 2);
	String Companyname = 	reader.getCellData("Station", "Company_name", 2);
	String StnName     = 	reader.getCellData("Station", "Station_Name", 2);
	
	
	 public void webLaunch() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	driver.get("http://172.16.8.17/margwebsite/qa");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	Wait= new WebDriverWait(driver,20);
		}
	 public void login() {
		 driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	 public void action() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
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
		
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Other Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Station Master")).click();
	 }
	public void newb() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='btn-New']/span[1]")).click();
		Thread.sleep(2000);
}
	public void stnName(){
		driver.findElement(By.id("txtStaionName")).sendKeys(StnName);
		driver.findElement(By.id("btn-Save")).click();
	}
	public static void main(String[] args) throws Exception {
		station_Master_new stnm = new station_Master_new();
		stnm.webLaunch();
		stnm.login();
		stnm.action();
		stnm.newb();
		stnm.stnName();
		
		
		
	}
}
