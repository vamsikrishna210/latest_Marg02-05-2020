package Home;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
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

public class Password_powers {
	WebDriver driver;
	WebDriverWait Wait;
	
    public void webLaunch() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	driver.get("http://10.10.10.31/margwebsitetest");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	Wait= new WebDriverWait(driver,20);
	}
	public void login() {
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();

	}
	public void serchCompany() throws InterruptedException {
		WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
		textbox.clear();
		textbox.sendKeys("JAGGI PHARMA");
		Thread.sleep(2000);
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
	}
	public void Home1() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.linkText("Home"));
		action.moveToElement(menu).perform();
		menu.sendKeys(Keys.ENTER);
		
		WebElement submenu1 = driver.findElement(By.linkText("Passwords & Powers"));
		action.moveToElement(submenu1).perform();
		submenu1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("User Powers")).click();
		Thread.sleep(3000);	
	}
	public void newuser(){
		driver.findElement(By.xpath("//button[@title='New']")).click();
	}
	public void ceradentials(){
		WebElement name = driver.findElement(By.xpath("//input[@id='txtUserName']"));
		name.sendKeys("vk123456");
		name.sendKeys(Keys.ENTER);
		
		WebElement pass = driver.findElement(By.xpath("//input[@id='txtLoginPwd']"));
		pass.sendKeys("123456");
		pass.sendKeys(Keys.ENTER);
		
		WebElement repass = driver.findElement(By.xpath("//input[@id='txtConfirmPwd']"));
		repass.sendKeys("123456");
		repass.sendKeys(Keys.ENTER);
		
		Select status = new Select (driver.findElement(By.xpath("//select[@id='ddlStatus']")));
		status.selectByVisibleText("Active");
		
		
			
		}
		public void operatorType(){
			List<WebElement> operator= driver.findElements(By.id("ddlPower"));
			int countO=operator.size();
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countO;i++)
			{
				String textO = operator.get(i).getText();
				System.out.println(textO);	
			}
			Select opt = new Select (driver.findElement(By.id("ddlPower")));
			opt.selectByVisibleText("vamsikrishna");		
	}
		
		public void usertype(){
			List<WebElement> operator= driver.findElements(By.id("ddlType"));
			int countO=operator.size();
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countO;i++)
			{
				String textO = operator.get(i).getText();
				System.out.println(textO);	
			}
			Select opt = new Select (driver.findElement(By.id("ddlType")));
			opt.selectByVisibleText("Manager");	
	}
		public void companyunder() throws InterruptedException{
			driver.findElement(By.id("multipleSelect")).click();
			Thread.sleep(2000);
			List<WebElement> allCheckbox = driver.findElements(By.xpath("//*[@class='multiselect-item-checkbox']"));
			int countCH = allCheckbox.size();
			System.out.println("Total no of checkboxes: " +countCH);
			System.out.println("Names  no of checkboxes: " );
			 for(int i=1; i<5; i++)
			 {
				 WebElement chkbox = allCheckbox.get(i);
				 chkbox.click();
			 }
		}
		public void Reporting(){
			List<WebElement> Report= driver.findElements(By.id("ddlReporting"));
			int countR=Report.size();
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countR;i++)
			{
				String textR = Report.get(i).getText();
				System.out.println(textR);	
			}
			Select opt = new Select (driver.findElement(By.id("ddlReporting")));
			opt.selectByVisibleText("vamsikrishna");	
	}
			public void userinfoo() throws AWTException, InterruptedException{
				Select opt = new Select (driver.findElement(By.id("ddlUserInfo")));
				opt.selectByVisibleText("Yes");
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
				driver.findElement(By.id("txtName")).sendKeys("vamsikrishna");
				driver.findElement(By.id("txtMo")).sendKeys("9876543210");
				driver.findElement(By.id("txtAlternate")).sendKeys("9638527410");
				driver.findElement(By.id("txtEmailid")).sendKeys("223@gamil.com");
				WebElement dateBox = driver.findElement(By.id("txtDOB"));
			    dateBox.sendKeys("02042019");
			    
			    // upload pic
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
				   
				   driver.findElement(By.id("txtAadhar")).sendKeys("766388856617");
				   driver.findElement(By.xpath("//textarea[@id='txtAddress']")).sendKeys("faifhfksdhfuf dsfh foahfuisdafhuidfhuidsfhufhfhfh///././././../././.~@~@~!@~!~@!~@@!~@#!~#~!##!~#!~##~##~#");
				  driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
			}
			
		
		
	public static void main(String[] args) throws InterruptedException, AWTException {
		Password_powers pp = new Password_powers();
		pp.webLaunch();
		pp.login();
		pp.serchCompany();
		pp.Home1();
		pp.newuser();
		pp.ceradentials();
		pp.operatorType();
		pp.usertype();
		pp.companyunder();
		pp.Reporting();
		pp.userinfoo();
	}

}
