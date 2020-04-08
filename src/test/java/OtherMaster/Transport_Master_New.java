package OtherMaster;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Transport_Master_New {
	WebDriver driver;
	WebDriverWait Wait;
	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
		}
	 public void login() {
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("vamsikrishna");
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	 public void action() throws InterruptedException{
		 WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
			textbox.clear();
			textbox.sendKeys("JAGGI PHARMA DISTUBUTORS");
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
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Other Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Transport Master")).click();
	 }
	public void newb() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='btn-New']/span[1]")).click();
		Thread.sleep(2000);
}
	public void controlroom(){
		driver.findElement(By.id("btnControlRoom")).click();
	}
	public void closectrl(){
		driver.findElement(By.xpath("//h2[@class='headingItem']//span[contains(text(),'×')]")).click();
	}
	public void nwname(){
		driver.findElement(By.id("txtTransportName")).sendKeys("VK~@###!^\\//Transports12");
	}
	public void more(){
		Select options = new Select(driver.findElement(By.id("ddlMore")));
		options.selectByVisibleText("Yes");
	}
	public void addrss(){
		driver.findElement(By.xpath("//*[@id='txtAddress1']")).sendKeys("vkthvbdvxncvbxhvn,d~!@#$%^&*~!@#$%^&*vhvcb,dvd");
		driver.findElement(By.xpath("//*[@id='txtAddress2']")).sendKeys("vkthvbdvxncvbxhvn,d~!@#$%^&*~!@#$%^&*vhvcb,dvd");
		driver.findElement(By.xpath("//*[@id='txtAddress3']")).sendKeys("vkthvbdvxncvbxhvn,d~!@#$%^&*~!@#$%^&*vhvcb,dvd");
	
	}
	public void Trstate(){
		Select options1 = new Select(driver.findElement(By.id("ddlstate")));
		options1.selectByVisibleText("Delhi");
	}
	public void pincd(){
		driver.findElement(By.id("pin")).sendKeys("533101");
	}
	public void contact(){
		driver.findElement(By.id("txtPhone")).sendKeys("~!@2132vbxvb");
		driver.findElement(By.id("txtMobileNo")).sendKeys("~!@2132vbxvb");
		driver.findElement(By.id("addButtonMobile")).click();
		driver.findElement(By.id("txtMobileNo3")).sendKeys("~!@2132vbxvb");
		driver.findElement(By.id("addButtonMobile")).click();
	}
	public void status(){
		Select options2 = new Select(driver.findElement(By.id("ddlStatus")));
		options2.selectByVisibleText("Active");
	}
	public void mode(){
		Select options3 = new Select(driver.findElement(By.id("ddlTranspostMode")));
		options3.selectByVisibleText("Air");
	}
	public void trGst(){
		driver.findElement(By.id("txtTransportCode")).sendKeys("AA0CS37888983zi");
		driver.findElement(By.id("btn-Save")).click();
	}
	public void navig(){
		driver.navigate().refresh();
	}
	public static void main(String[] args) throws Exception {
		Transport_Master_New tmn = new Transport_Master_New();
		tmn.webLaunch();
		tmn.login();
		tmn.action();
		tmn.newb();
		tmn.controlroom();
		tmn.closectrl();
		tmn.nwname();
		tmn.more();
		tmn.addrss();
		tmn.Trstate();
		tmn.pincd();
		tmn.contact();
		tmn.status();
		tmn.mode();
		tmn.trGst();
		tmn.navig();
	}
}
