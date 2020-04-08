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

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Area_Master_New {
	WebDriver driver;
	WebDriverWait Wait;
	public static Xls_Reader reader = new Xls_Reader(
			"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
    
   
    String user        = 	reader.getCellData("Area", "user", 2);
	String pass 	   = 	reader.getCellData("Area", "password", 2);
	String Companyname = 	reader.getCellData("Area", "Company_name", 2);
	String Route1	   = 	reader.getCellData("Area", "Rout_Drp", 2);
	String Area1       = 	reader.getCellData("Area", "Area_Name", 2);
	String AreaRenanme =    reader.getCellData("Area", "Area_Rename", 2);
	
	
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
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(user);
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
			textbox.sendKeys(Keys.ENTER);
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Other Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Area Master")).click();
	 }
	public void newb() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='btn-New']/span[1]")).click();
		
	}
	public void controlroomArea() throws InterruptedException{
		driver.findElement(By.xpath("//button[@id='btnControlRoom']//*[@height='20']")).click();
		Thread.sleep(2000);
		WebElement area = driver.findElement(By.xpath("//input[@id='txtArea']"));
		area.clear();
		area.sendKeys(AreaRenanme);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h2[@class='headingItem']//span[contains(text(),'�')]")).click();
	}
	public void selecctAr() throws InterruptedException{
		Thread.sleep(2000);
		WebElement routname = driver.findElement(By.xpath("//input[@id='autoCompleteRoute']"));
		routname.clear();
		routname.sendKeys(Route1);
		Thread.sleep(2000);
		List<WebElement> allOptions2= driver.findElements(By.xpath("//input[@id='autoCompleteRoute']"));
		int count2=allOptions2.size();
		System.out.println("No.of Autosuggesion "+count2);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count2;i++)
		{
			String text2 = allOptions2.get(i).getText();
			System.out.println(text2);	
		}
		routname.sendKeys(Keys.ARROW_DOWN);
			//textbox2.sendKeys(Keys.ARROW_DOWN);
		routname.sendKeys(Keys.ENTER);	
				}
	public void Route(){
		driver.findElement(By.id("txtAreaName")).sendKeys(Area1);
	}

	public void save(){
		driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	}
	public static void main(String[] args) throws Exception {
		Area_Master_New amn = new Area_Master_New();
		amn.webLaunch();
		amn.login();
		amn.action();
		amn.newb();
		amn.controlroomArea();
		amn.selecctAr();
        amn.Route();
       
        amn.save();
	}
	
}
