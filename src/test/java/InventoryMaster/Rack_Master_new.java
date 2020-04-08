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
///import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Rack_Master_new {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
   
    String user        = 	reader.getCellData("Area", "user", 2);
	String pass 	   = 	reader.getCellData("Area", "password", 2);
	String Companyname = 	reader.getCellData("Area", "Company_name", 2);
	String Rak   	   = 	reader.getCellData("Area", "Rack_Name", 2);
	/*String Area1       = 	reader.getCellData("Area", "Area_Name", 2);
	String AreaRenanme =    reader.getCellData("Area", "Area_Rename", 2);*/
	
	  @BeforeSuite
	    // web lauch    
		public void LaunchBrowser() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("http://172.16.8.17/margwebsite/vamsi");
			driver.manage().window().maximize();
	    
	    	/*TestBase.initialization();
	    	Tb = new TestBase(); */
			
			
		}
	    @BeforeTest
		//login to app
		public void Login() throws InterruptedException {
			
			driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
			driver.findElement(By.id("userid")).sendKeys(user);
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("btnSave")).click();
			
	    	//login_Credentials();
		}
	    @Test(priority=1)
		// search and select company
		public void searchCompany() throws InterruptedException {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
			 WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='SearchBox']")));
			 
			// WebElement textbox = driver.findElement(By.xpath("//*[@id='SearchBox']"));
				//textbox.clear();
			 Thread.sleep(3000);
				textbox.sendKeys(Companyname);
				Thread.sleep(2000);
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
				/*WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
				pass.sendKeys("1234");
				pass.sendKeys(Keys.ENTER);*/
				
				Actions action = new Actions(driver);
				WebElement menu = driver.findElement(By.linkText("Master"));
				action.moveToElement(menu).perform();
				menu.sendKeys(Keys.ENTER);
				
				WebElement submenu1 = driver.findElement(By.linkText("Inventory Master"));
				action.moveToElement(submenu1).perform();
				submenu1.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
			driver.findElement(By.linkText("Rack Master")).click();
	 }
	@Test(priority=2)
	public void newb(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='btn-New']")).click();
	}
	@Test(priority=3)
	public void storename() throws InterruptedException{
		
		WebElement store = driver.findElement(By.xpath("//*[@id='storeNameDrp']"));
		//store.clear();
		Thread.sleep(3000);
		//store.sendKeys("Main Store");
		//List<WebElement> dropdownElements = driver.findElements(By.cssSelector("#ngb-typeahead-0"));
		List<WebElement> allOptions1= driver.findElements(By.xpath("//select[@id='storelinkid']"));
		int count1=allOptions1.size();
		
		
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count1;i++){
			String text1 = allOptions1.get(i).getText();
			System.out.println(text1);
		}
		if(store.equals(allOptions1.indexOf(1))){
			store.sendKeys(Keys.ARROW_DOWN);
			store.sendKeys(Keys.ENTER);
			
		}
		else{
			store.sendKeys(Keys.ENTER);
			
		}
		
		
		/*
		for(WebElement element : dropdownElements){

		                if("text the need to compage".equalsIgnoreCase(element.getText())){

		                    //do anything you want
		                }
		            }*/
		
	}
	@Test(priority=4)
	public void rackno(){
		driver.findElement(By.id("name")).sendKeys(Rak);
	}
	@Test(priority=5)
	public void save() throws InterruptedException{
		driver.findElement(By.id("btn-Save")).click();
		Thread.sleep(2000);
	}
	public void refrsh(){
		driver.navigate().refresh();
	}
	/*public static void main(String[] args) throws Exception {
		Rack_Master_new rmn = new Rack_Master_new();
		rmn.webLaunch();
		rmn.login();
		rmn.action();
		rmn.newb();
		rmn.storename();
		rmn.rackno();
		rmn.save();
		//rmn.refrsh();
		*/
	}
//}
