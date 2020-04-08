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

public class Salt_Master_New {
	WebDriver driver;
	WebDriverWait Wait;
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
		 Thread.sleep(2000);
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
			textbox.sendKeys("vamsikrishna");
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
			
			WebElement submenu1 = driver.findElement(By.linkText("Inventory Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Salt Master")).click();
	 }
	public void newb(){
		driver.findElement(By.id("btn-New")).click();
}
	public void saltname(){
		driver.findElement(By.id("txtSaltName")).sendKeys("Salt1");
	}
	public void morinfo(){
		Select MOREinfo = new Select(driver.findElement(By.id("purpose")));
		MOREinfo.selectByVisibleText("Yes");
	}
	public void details(){
		driver.findElement(By.id("txtIndication")).sendKeys("for all kind of things");
		driver.findElement(By.id("txtDosage")).sendKeys("180 MG");
		driver.findElement(By.id("txtSideEffect")).sendKeys("no side effects ");
		driver.findElement(By.id("txtSideEffect2")).sendKeys("always have very good effects ");
		driver.findElement(By.id("txtSpecialPrecautions")).sendKeys("any time can consume ");
		driver.findElement(By.id("txtDrugInteractions")).sendKeys("morning 90mg , evening 90mg ");
		driver.findElement(By.xpath("//*[@id='txtRemark']")).sendKeys("use every time good for health");
	}
	public void narchdetails(){
		Select Narcotic = new Select(driver.findElement(By.id("drpNarcotic")));
		Narcotic.selectByVisibleText("Yes");
		Select ScheduleH = new Select(driver.findElement(By.id("drpSchedule")));
		ScheduleH.selectByVisibleText("Yes");
		Select ScheduleH1= new Select(driver.findElement(By.id("drpScheduleH1")));
		ScheduleH1.selectByVisibleText("Yes");
	}
	public void maxrate(){
		driver.findElement(By.xpath("//*[@id='txtMaximumRate']")).sendKeys("2311121223");
	}
	public void conted(){
		Select Continued = new Select(driver.findElement(By.id("drpContinued")));
		Continued.selectByVisibleText("No");
	}
	public void prohbd(){
		Select Prohibited = new Select(driver.findElement(By.id("drpProhibited")));
		Prohibited.selectByVisibleText("Yes");
	}
	public void save(){
		driver.findElement(By.xpath("//*[@id='btn-Save']/span[1]")).click();
	}
	public void refrsh(){
		driver.navigate().refresh();
	}
	public static void main(String[] args) throws Exception {
		Salt_Master_New smn = new Salt_Master_New();
		smn.webLaunch();
		smn.login();
		smn.action();
		smn.newb();
		smn.saltname();
		smn.morinfo();
		smn.details();
		smn.maxrate();
		smn.narchdetails();
		smn.conted();
		smn.prohbd();
		smn.save();
	}
}
