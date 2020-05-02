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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Password_powers {
	WebDriver driver;
	WebDriverWait Wait;
	
	  String specialCharacters="~!^";
		
		public static Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Vamsikrishna\\Desktop\\ddf.xlsx");
	  
	 
	    String user        = 	reader.getCellData("User", "user", 2);
		String pass 	   = 	reader.getCellData("User", "password", 2);
		String Companyname = 	reader.getCellData("User", "Company_name", 2);
		String UserId      = 	reader.getCellData("User", "User_Name", 2);
		String Password    = 	reader.getCellData("User", "Pass_new", 2);
		String fullName    = 	reader.getCellData("User", "Full_name", 2);
		String UserStstus  =	reader.getCellData("User", "Status_user", 2);
		String powers      =	reader.getCellData("User", "Copy_powers", 2);
		String  usertype   =	reader.getCellData("User", "Type_user", 3);
		String usercomp    =	reader.getCellData("User", "Company_User", 2);
		String reportuser  =	reader.getCellData("User", "Reporter_User", 3);
		String MobUser     =    reader.getCellData("User", "Mobile_User", 2);
		String Altermib    =    reader.getCellData("User", "Alter_User", 3);
		String userEmail   =	reader.getCellData("User", "Email_user", 2);
		String Dob         =    reader.getCellData("User", "DOB_User", 2);
		String Adhar       =    reader.getCellData("User", "Adhar_User", 3);
		String Remarks       =	reader.getCellData("User", "Remarks_user", 2);
	@BeforeSuite
    public void webLaunch() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://172.16.8.17/margwebsite/QA");
		driver.manage().window().maximize();
		System.out.println("url opend Sucessfuly");
	}
	@BeforeTest
	public void login() {
		driver.findElement(By.xpath("//a[@class='nav-link login']")).click();
		driver.findElement(By.id("userid")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("btnSave")).click();
		System.out.println("logined scuessfully");

	}
	@Test(priority=1)
	public void serchCompany() throws InterruptedException {
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
			
			System.out.println("company Selected sucessfully");
	}
	@Test(priority=2)
	public void Home1() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//a[@id='aControlRoomSetting']//img"));
		action.moveToElement(menu).perform();
		//menu.sendKeys(Keys.ENTER);
		menu.click();
		
		/*WebElement submenu1 = driver.findElement(By.linkText("User Powers"));
		action.moveToElement(submenu1).perform();
		submenu1.sendKeys(Keys.ENTER);*/
		Thread.sleep(2000);
		driver.findElement(By.linkText("User Powers")).click();
		Thread.sleep(3000);	
	
		
	
	}
	@Test(priority=3)
	public void newuser(){
		driver.findElement(By.xpath("//button[@title='New']")).click();
	}
	@Test(priority=4)
	public void ceradentials(){
		WebElement name = driver.findElement(By.xpath("//input[@id='txtUserName']"));
		name.sendKeys(UserId);
		name.sendKeys(Keys.ENTER);
		
		WebElement pass = driver.findElement(By.xpath("//input[@id='txtLoginPwd']"));
		pass.sendKeys(Password);
		pass.sendKeys(Keys.ENTER);
		
		WebElement repass = driver.findElement(By.xpath("//input[@id='txtConfirmPwd']"));
		repass.sendKeys(Password);
		repass.sendKeys(Keys.ENTER);
		
		WebElement funmae = driver.findElement(By.xpath("//input[@id='txtName']"));
		funmae.sendKeys(fullName);
		funmae.sendKeys(Keys.ENTER);
		
		Select status = new Select (driver.findElement(By.xpath("//select[@id='ddlStatus']")));
		status.selectByVisibleText(UserStstus);
		
		
			
		}
	@Test(priority=5)
		public void CopyPower(){
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
			opt.selectByVisibleText(powers);		
	}
	@Test(priority=6)
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
			opt.selectByVisibleText(usertype);	
	}
	@Test(priority=7)
		public void companyunder() throws InterruptedException{
			/*driver.findElement(By.xpath("//div[@class='buttonOnOff']")).click();
			Thread.sleep(2000);
			String checkitems = "//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']";
			List<WebElement> Items = driver.findElements(By.xpath(checkitems));
			int count = Items.size();
			
			for(int i=count-1;i>=0;i--) {
				Items.get(i).click();
				} 
			Thread.sleep(3000);
			for(int i =0 ; i<count ; i++){
				WebElement Sel = Items.get(i);
				Sel.click();
			}
			List<WebElement> allchkbox = driver.findElements(By.xpath("//span[@class='ag-selection-checkbox']//span[@class='ag-icon ag-icon-checkbox-unchecked']")); 
			int count = allchkbox.size();
			System.out.println("Total no. of checkboxes: "+count);
			
			
			//deselect all checkboxes from bottom to top 
			for(int i=count-1;i>=0;i--) {
			allchkbox.get(i).click();
			} 
			Thread.sleep(3000);
			//select all check boxes from top to bottom 
			for(int i=0;i<count;i++)
			{
			WebElement chkbox = allchkbox.get(i); 
			chkbox.click();
			}*/
		WebElement comp = driver.findElement(By.xpath("//button[@id='spanCont']"));
		comp.sendKeys(Keys.ENTER);
			}
		
	@Test(priority=8)
		public void Reporting() throws InterruptedException{
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
			opt.selectByVisibleText(reportuser);	
			Thread.sleep(2000);
			
	}
	@Test(priority=9)
			public void userinfoo() throws AWTException, InterruptedException{
		List<WebElement> allchkbox = driver.findElements(By.xpath("//input[@id='ddlUserInfo']")); 
		int count = allchkbox.size();
		System.out.println("Total no. of checkboxes: "+count);
		for(int i=0;i<count;i++)
		{
		WebElement chkbox = allchkbox.get(i); 
		chkbox.click();
		}
		
		
				/*WebElement usewrinf = driver.findElement(By.xpath("//input[@id='ddlUserInfo']"));
				usewrinf.click();
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);*/
				

				WebElement mob = driver.findElement(By.id("txtMo"));
				mob.sendKeys(MobUser);
				WebElement alternate =  driver.findElement(By.id("txtAlternate"));
				alternate.sendKeys(Altermib);
				
				
				WebElement email = driver.findElement(By.id("txtEmailid"));
				email.sendKeys(userEmail);
				WebElement dateBox = driver.findElement(By.id("txtDOB"));
			    dateBox.sendKeys(Dob);
			    
			    // upload pic
			    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				/*driver.findElement(By.xpath("//button[@id='btnEdit']")).click();
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
				   robot.keyRelease(KeyEvent.VK_ENTER);*/
				   
				   WebElement adhar = driver.findElement(By.id("txtAadhar"));
				   adhar.sendKeys(Adhar);
				   WebElement remarks = driver.findElement(By.xpath("//textarea[@id='txtAddress']"));
				   remarks.sendKeys(Remarks);
				  //driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
			}
			
		
		
	/*public static void main(String[] args) throws InterruptedException, AWTException {
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
	}*/

}
