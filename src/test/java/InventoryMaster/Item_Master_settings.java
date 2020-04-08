package InventoryMaster;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Item_Master_settings {
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
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
			textbox.sendKeys("vamsikrishna");
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
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Inventory Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Item Master")).click();
	 }
	 public void newb() throws InterruptedException{
		 Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='New']")).click();
	 }
	 
	public void countrlrmm(){
		 //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//*[contains(@id,'ControlRoomSetting')]")).click();
			/*WebDriverWait wait3 = new WebDriverWait(driver, 10);
			WebElement contrl = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='aControlRoomSetting']//img")));
			contrl.click();*/
		/*WebElement element = driver.findElement(By.xpath("//a[@id='aControlRoomSetting']//img"));

		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().perform();
		*/
		WebElement ele = driver.findElement(By.xpath("//a[@id='aControlRoomSetting']//img"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	 }
	 public void codereq(){
		 driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			Select itemCodereq = new Select(driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']")));
			itemCodereq.selectByIndex(1);
			
	 }
	 public void itmcodgen(){
		 Select itemCodegen = new Select(driver.findElement(By.id("IcItemCode")));
			itemCodegen.selectByVisibleText("Self");
			
	 }
	 
	 public void dup1(){
		 Select itmdup = new Select(driver.findElement(By.id("itemDuplicateAllowed")));
			itmdup.selectByVisibleText("Yes");
			
	 }
	 
	 public void Barcode(){
		 Select barc= new Select(driver.findElement(By.id("barcode")));
		 barc.selectByVisibleText("No");
		 
		 if (driver.findElement(By.xpath("//*[@id='barcode']/option[1]")).isSelected()){
			 driver.findElement(By.xpath("//select[@id='ItemWorkingStyleType']"));
		 }
		 else if (driver.findElement(By.xpath("//*[@id='barcode']/option[2]")).isSelected()){
			Select DupBar = new Select( driver.findElement(By.xpath("//select[@id='barcodeallowed']")));
			DupBar.selectByVisibleText("No");
		 }
		
			 
	 }
	 public void workstyl(){

			List<WebElement> wStyle= driver.findElements(By.xpath("//select[@id='ItemWorkingStyleType']"));
			int countSt= wStyle.size();
			System.out.println("Working Styles types"+countSt);
			for(int i=0;i<countSt;i++){
				String textWs= wStyle.get(i).getText();
				System.out.println(textWs);
			}
			Select ws = new Select(driver.findElement(By.xpath("//select[@id='ItemWorkingStyleType']")));
			ws.selectByIndex(1);	
			}
	  public void pck(){
		 Select pack = new Select(driver.findElement(By.id("packing")));
			pack.selectByVisibleText("Yes");
			
			Select packname = new Select(driver.findElement(By.id("isPrintNameRequired")));
			packname.selectByVisibleText("Yes");
	 }
	 public void Agencynm(){
		 Select agency1 = new Select(driver.findElement(By.id("isAgencyRequired")));
		 agency1.selectByVisibleText("Yes");
		 
		 WebElement textboxAgency = driver.findElement(By.xpath("//input[@id='agencyRename']"));
		 textboxAgency.clear();
		 textboxAgency.sendKeys("KGFAgency1121212312654");
		 
	 }
	 public void Saltreq(){
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 Select saltr = new Select(driver.findElement(By.xpath("//select[@id='salt']")));
		 saltr.selectByVisibleText("Yes");
	 }
	 public void catgryitm(){
		 Select saltr = new Select(driver.findElement(By.id("Category")));
		 saltr.selectByVisibleText("Yes");
		 
		 WebElement textboxCat = driver.findElement(By.xpath("//input[@id='CategoryRename']"));
		 textboxCat.clear();
		 textboxCat.sendKeys("KGFcat1321222323121322123123");
	 }
	 public void HSNReq(){
		 Select HSNr = new Select(driver.findElement(By.id("Hsn")));
		 HSNr.selectByVisibleText("Yes");
		 
		 WebElement textboxHSN = driver.findElement(By.xpath("//input[@id='hsnRename']"));
		 textboxHSN.clear();
		 textboxHSN.sendKeys("KGF HSN/San~~~!!@@##$$%%");
	 }
	 public void gstHeadingReq() throws InterruptedException {
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnGStHeading']")).click();
		WebElement igst= driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='igstHeading']"));
		igst.clear();
		igst.sendKeys("my igst~!*}^%$#");
		
		WebElement sgst= driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='sgstHeading']"));
		sgst.clear();
		sgst.sendKeys("my sgst!`*^#");
		
		WebElement cgst= driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='cgstHeading']"));
		cgst.clear();
		cgst.sendKeys("my cgst ~`!*6##");
	
		
		WebElement cess= driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='cessHeading']"));
		cess.clear();
		cess.sendKeys("my cess~`!*6##");
		
		WebElement addcess= driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='additionalCessHeading']"));
		addcess.clear();
		addcess.sendKeys("my addcess~`!*6##");
//		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		/*WebElement sav = driver.findElement(By.xpath("//button[@id='btnRateInfoSave']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", sav);*/
		
		
		
		driver.findElement(By.xpath("//button[@id='btnRateInfoSave']")).click();
		 
	}
	 public void Surcharge() throws InterruptedException{
		 driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//button[@id='btnSurcharge1']")).click();
		 Thread.sleep(3000);
		 Select Cess = new Select(driver.findElement(By.xpath("//div[@id='surchargeSetting']//select[@id='isCessVisible']")));
		 Cess.selectByIndex(1);
		 
		 Select ACA = new Select(driver.findElement(By.id("isAdditionalCessVisible")));
		 ACA.selectByIndex(1);
		 
		 driver.findElement(By.xpath("//control-room-rate-info//span[contains(text(),'×')]")).click();
		 
	 }
	 
	 public void RackReq() throws InterruptedException{
		 Select Rackr = new Select(driver.findElement(By.id("rackno")));
		 Rackr.selectByVisibleText("Yes");
		 
		 WebElement textboxRACK = driver.findElement(By.xpath("//input[@id='racknoRename']"));
		 textboxRACK.clear();
		 textboxRACK.sendKeys("my Rack123465~~~~~~~!!!@@##");
		 Thread.sleep(2000);
	 }
	 public void itemtype(){
		 driver.findElement(By.xpath("//button[@id='btnItemtype']")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 WebElement costly =  driver.findElement(By.xpath("//div[@id='gstHeading']//input[@id='itemTypeCostly']"));
		 costly.clear();
		 costly.sendKeys("too costly!!!~~~~~##$%^^");
		 
		WebElement storage1 = driver.findElement(By.xpath("//div[@id='gstHeading']//input[@id='itemType8']"));
		storage1.clear();
		storage1.sendKeys("below 5'");
		
		WebElement storage2 = driver.findElement(By.xpath("//div[@id='gstHeading']//input[@id='itemType24']"));
		storage2.clear();
		storage2.sendKeys("below 15'");
		
		driver.findElement(By.xpath("//button[@id='btnRateInfoSave']")).click();
	 }
	
	 public void closectrlm() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@class,'close itemcontrolClose')]")).click();
	 }
	 public static void main(String[] args) throws InterruptedException {
		
	
	 Item_Master_settings IMS = new Item_Master_settings();
	    IMS.webLaunch();
		IMS.login();
		IMS.action();
		IMS.newb();
		IMS.countrlrmm();
		IMS.codereq();
		IMS.itmcodgen();
		IMS.dup1();
		IMS.Barcode();
		IMS.workstyl();
		IMS.pck();
		IMS.Agencynm();
		IMS.Saltreq();
		IMS.catgryitm();
		IMS.HSNReq();
		IMS.RackReq();
		IMS.itemtype();
		IMS.gstHeadingReq();
		IMS.Surcharge();
		IMS.closectrlm();
}
}