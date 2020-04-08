package Home;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Compeny_Modify_new {
	WebDriver driver;
	WebDriverWait Wait;
	
    public void webLaunch() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin.DESKTOP-P28CFV6\\Desktop\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	driver.get("http://172.16.8.17/margwebsite");
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
	public void serch() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
	//	WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
		textbox.clear();
		textbox.sendKeys("VKGGROUP1.LTD");
		Thread.sleep(2000);
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='textContent']"));
		int count=allOptions.size();
		System.out.println("No.of Autosuggesion "+count);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count;i++){
			String text = allOptions.get(i).getText();
			System.out.println(text);	
			
		}
		}
		public void edit(){
			driver.findElement(By.className("mksBtn")).click();
			
		}
		public void cmpname() throws InterruptedException{
			WebElement nametb = driver.findElement(By.id("txtcompname"));
			nametb.clear();
			Thread.sleep(2000);
			nametb.sendKeys("vam@83454");
			driver.findElement(By.id("txtaddress1")).sendKeys("nsp ,ksajhd &asdjhlf,Delhi ,sdgdggdggdggdgdgdgdgdggdggfdgfdg");
			driver.findElement(By.id("txtaddress2")).sendKeys("nsp ,ksajhd &asdjhlf,Delhi~@@@@@@@!!!!!!!");
			driver.findElement(By.id("txtaddress3")).sendKeys("nsp ,ksajhd &asdjhlf,Delhi~!~!3321`21`21`");
		}
		
		public void Cmpcountry() throws InterruptedException{
			WebElement cntry = driver.findElement(By.xpath("//*[@id='ddlcountry']"));
			cntry.clear();
			cntry.sendKeys(Keys.SPACE);
			Thread.sleep(3000);
			
			/*List<WebElement> allOptionctry= driver.findElements(By.xpath("//*[@id='ddlcountry']"));
			int countctry=allOptionctry.size();
			for(int i=0;i<countctry;i++)
			{
				String textctry = allOptionctry.get(i).getText();	
			}*/
				//textbox1.sendKeys(Keys.ARROW_DOWN);
			   cntry.sendKeys(Keys.ENTER);
		}
		public void createcntry() throws InterruptedException{
			driver.findElement(By.xpath("//input[@id='txtCountryName']")).sendKeys("kgf1~~~~~~~~~");	
			driver.findElement(By.xpath("//input[@id='txtCountryCode']")).sendKeys("~!~@#*|>?345");
			driver.findElement(By.xpath("//input[@id='txtCurrencySymbol']")).sendKeys("!`~*");
			driver.findElement(By.xpath("//input[@id='txtCurrencyString']")).sendKeys("!#^*1234");
			Thread.sleep(2000);
			driver.findElement(By.id("btn-Save")).click();
		}
		public void cmpState() throws InterruptedException{
			WebElement state = driver.findElement(By.xpath("//input[@id='ddlstate']"));
			state.clear();
			state.sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			
			/*List<WebElement> allOptionstate= driver.findElements(By.xpath("//input[@id='ddlstate']"));
			int countstate=allOptionstate.size();
			for(int i=0;i<countstate;i++)
			{
				String textstate = allOptionstate.get(i).getText();	
			}*/
				//textbox1.sendKeys(Keys.ARROW_DOWN);
			 state.sendKeys(Keys.ENTER);	
		}
		public void creatState() throws InterruptedException{
			driver.findElement(By.id("txtStateName")).sendKeys("vamsikgf1234");	
			driver.findElement(By.id("txtStateCode")).sendKeys("!`~*+210");
			Thread.sleep(2000);
			driver.findElement(By.id("btn-Save")).click();
		}
		public void uploadPic() throws InterruptedException, AWTException{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[@id='btnEdit']")).click();
			Thread.sleep(2000);
			StringSelection stringSelection = new StringSelection("C:\\Users\\admin\\Desktop\\123.jpg"); 
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot = new Robot();
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			   robot.keyPress(KeyEvent.VK_CONTROL);
			   robot.keyPress(KeyEvent.VK_V);
			   robot.keyRelease(KeyEvent.VK_V);
			   robot.keyRelease(KeyEvent.VK_CONTROL);
			   Thread.sleep(5000);
			   robot.keyPress(KeyEvent.VK_ENTER);
			   robot.keyRelease(KeyEvent.VK_ENTER);
			   //Delete image
			   // Thread.sleep(2000);
			  // driver.findElement(By.id("btnDelete")).click();
			  
		}
		public void update(){
			 driver.findElement(By.id("btn-Update")).click();
		}
		public static void main(String[] args) throws InterruptedException, AWTException {
			Compeny_Modify_new cmn = new Compeny_Modify_new();
			cmn.webLaunch();
			cmn.login();
			cmn.serch();
			cmn.edit();
			cmn.cmpname();
			cmn.Cmpcountry();
			cmn.createcntry();
			cmn.cmpState();
			cmn.creatState();
			cmn.uploadPic();
			cmn.update();
		}
	}
	

