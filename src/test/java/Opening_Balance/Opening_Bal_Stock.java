package Opening_Balance;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Opening_Bal_Stock {
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
			WebElement textbox = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//input[@id='SearchBox']")));
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
			
			WebElement submenu1 = driver.findElement(By.linkText("Opening Balance"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Stock")).click();
	 }
	 public void SerchStore() throws InterruptedException{
		 /*WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement SerStor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
			SerStor.sendKeys("main");
			SerStor.sendKeys(Keys.ENTER);*/
		 WebElement SerStor = driver.findElement(By.xpath("//input[@id='SearchBox']"));
		 SerStor.sendKeys("main");
		 Thread.sleep(3000);
		 SerStor.sendKeys(Keys.ENTER);
	 }
	 public void seleitem(){
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement Seritem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchItems']")));
			Seritem.sendKeys("New Pro1");
			Seritem.sendKeys(Keys.ENTER);
	 }
	 
	 public void Serchbatch() throws InterruptedException{
		 if(!driver.findElements(By.xpath("//input[@id='txt-OpeningQty-0']")).isEmpty()){
		 WebElement opb = driver.findElement(By.xpath("//input[@id='txt-OpeningQty-0']"));
		 opb.clear();
		 opb.sendKeys("123");
		 Thread.sleep(3000);
		 opb.sendKeys(Keys.ENTER);
		 
	 }
		 else{
			 //batch 
			 Thread.sleep(3000);
			 WebElement bath = driver.findElement(By.xpath("//input[@id='txt-batchName-0']"));
			 System.out.println(bath.isDisplayed());
			 //if(bath.isDisplayed()){
			 
			 if (bath.getSize().equals(null)){
				 Thread.sleep(3000);
				 bath.sendKeys(Keys.ENTER);
			 }
			 else {
				 bath.clear();
				 bath.sendKeys("321");
				 bath.sendKeys(Keys.ENTER);
			 }
			 //unit1
			 WebElement unit = driver.findElement(By.xpath("//input[@id='txt-OpeningQuantity-0']"));
			 unit.sendKeys(Keys.BACK_SPACE);
			 unit.sendKeys("50");
			 unit.sendKeys(Keys.ENTER);
			 //MRP
			 WebElement mrp = driver.findElement(By.xpath("//*[contains(@id,'txt-mrp')]"));
			 mrp.sendKeys(Keys.BACK_SPACE);
			 mrp.sendKeys("200");
			 mrp.sendKeys(Keys.ENTER);
			 //Prate
			 WebElement prate = driver.findElement(By.xpath("//*[contains(@id,'txt-pRate')]"));
			 prate.sendKeys(Keys.BACK_SPACE);
			 prate.sendKeys("100");
			 prate.sendKeys(Keys.ENTER);
			 //Cost
			 WebElement Perco = driver.findElement(By.xpath("//*[contains(@id,'txt-costPerPcs')]"));
			 Perco.sendKeys(Keys.BACK_SPACE);
			 Perco.sendKeys("10");
			 Perco.sendKeys(Keys.ENTER);
			 //RateA
			 WebElement RateA = driver.findElement(By.xpath("//*[contains(@id,'txt-rateA')]"));
			 RateA.sendKeys(Keys.BACK_SPACE);
			 RateA.sendKeys("150");
			 RateA.sendKeys(Keys.ENTER);
			 // Remaing Rates
			 WebElement rateB = driver.findElement(By.xpath("//*[contains(@id,'txt-rateB')]"));
			 rateB.sendKeys(Keys.BACK_SPACE);
			 rateB.sendKeys("149");
			 rateB.sendKeys(Keys.ENTER);
			 
			 WebElement rateC = driver.findElement(By.xpath("//*[contains(@id,'txt-rateC')]"));
			 rateC.sendKeys(Keys.BACK_SPACE);
			 rateC.sendKeys("149");
			 rateC.sendKeys(Keys.ENTER);
			 
			 WebElement rateD = driver.findElement(By.xpath("//*[contains(@id,'txt-rateD')]"));
			 rateD.sendKeys(Keys.BACK_SPACE);
			 rateD.sendKeys("149");
			 rateD.sendKeys(Keys.ENTER);
			 
			 WebElement rateE = driver.findElement(By.xpath("//*[contains(@id,'txt-rateE')]"));
			 rateE.sendKeys(Keys.BACK_SPACE);
			 rateE.sendKeys("149");
			 rateE.sendKeys(Keys.ENTER);
			 
			 WebElement rateF = driver.findElement(By.xpath("//*[contains(@id,'txt-rateF')]"));
			 rateF.sendKeys(Keys.BACK_SPACE);
			 rateF.sendKeys("149");
			 rateF.sendKeys(Keys.ENTER);
			 
			 WebElement rateG = driver.findElement(By.xpath("//*[contains(@id,'txt-rateG')]"));
			 rateG.sendKeys(Keys.BACK_SPACE);
			 rateG.sendKeys("149");
			 rateG.sendKeys(Keys.ENTER);
			 
			 WebElement rateH = driver.findElement(By.xpath("//*[contains(@id,'txt-rateH')]"));
			 rateH.sendKeys(Keys.BACK_SPACE);
			 rateH.sendKeys("149");
			 rateH.sendKeys(Keys.ENTER); 

			 //Dates
			 WebElement MfGd= driver.findElement(By.xpath("//*[contains(@id,'txt-mfgDate')]"));
			 MfGd.sendKeys("09-2019");
			 MfGd.sendKeys(Keys.ENTER);
			
			 WebElement Exp = driver.findElement(By.xpath("//input[@id='txt-expiryDate-0']"));
		     Exp.sendKeys(Keys.ENTER); 
			 
		 }
		 
	 }
	/* public void batch () throws InterruptedException{
		 Thread.sleep(3000);
		 WebElement bath = driver.findElement(By.xpath("//input[@id='txt-batchName-0']"));
		 System.out.println(bath.isDisplayed());
		 //if(bath.isDisplayed()){
		 
		 if (bath.getSize().equals(null)){
			 Thread.sleep(3000);
			 bath.sendKeys(Keys.ENTER);
		 }
		 else {
			 bath.clear();
			 bath.sendKeys("321");
			 bath.sendKeys(Keys.ENTER);
		 }
	 }
	 public void unit1(){             //*[contains(@id,'txt-unitToEnteredValue')]
		 WebElement unit = driver.findElement(By.xpath("//input[@id='txt-OpeningQuantity-0']"));
		 unit.sendKeys(Keys.BACK_SPACE);
		 unit.sendKeys("50");
		 unit.sendKeys(Keys.ENTER);
	 }
	 public void Mrp(){
		 WebElement mrp = driver.findElement(By.xpath("//*[contains(@id,'txt-mrp')]"));
		 mrp.sendKeys(Keys.BACK_SPACE);
		 mrp.sendKeys("200");
		 mrp.sendKeys(Keys.ENTER);
		 
	 }
	 public void Prate(){
		 WebElement prate = driver.findElement(By.xpath("//*[contains(@id,'txt-pRate')]"));
		 prate.sendKeys(Keys.BACK_SPACE);
		 prate.sendKeys("100");
		 prate.sendKeys(Keys.ENTER);
	 }
	 public void perunitCo(){
		 WebElement Perco = driver.findElement(By.xpath("//*[contains(@id,'txt-costPerPcs')]"));
		 Perco.sendKeys(Keys.BACK_SPACE);
		 Perco.sendKeys("10");
		 Perco.sendKeys(Keys.ENTER);
	 }
	 public void rateAinfo(){
		 WebElement RateA = driver.findElement(By.xpath("//*[contains(@id,'txt-rateA')]"));
		 RateA.sendKeys(Keys.BACK_SPACE);
		 RateA.sendKeys("150");
		 RateA.sendKeys(Keys.ENTER);
		 
	 }
	 public void RemainingRates(){
			 WebElement rateB = driver.findElement(By.xpath("//*[contains(@id,'txt-rateB')]"));
			 rateB.sendKeys(Keys.BACK_SPACE);
			 rateB.sendKeys("149");
			 rateB.sendKeys(Keys.ENTER);
			 
			 WebElement rateC = driver.findElement(By.xpath("//*[contains(@id,'txt-rateC')]"));
			 rateC.sendKeys(Keys.BACK_SPACE);
			 rateC.sendKeys("149");
			 rateC.sendKeys(Keys.ENTER);
			 
			 WebElement rateD = driver.findElement(By.xpath("//*[contains(@id,'txt-rateD')]"));
			 rateD.sendKeys(Keys.BACK_SPACE);
			 rateD.sendKeys("149");
			 rateD.sendKeys(Keys.ENTER);
			 
			 WebElement rateE = driver.findElement(By.xpath("//*[contains(@id,'txt-rateE')]"));
			 rateE.sendKeys(Keys.BACK_SPACE);
			 rateE.sendKeys("149");
			 rateE.sendKeys(Keys.ENTER);
			 
			 WebElement rateF = driver.findElement(By.xpath("//*[contains(@id,'txt-rateF')]"));
			 rateF.sendKeys(Keys.BACK_SPACE);
			 rateF.sendKeys("149");
			 rateF.sendKeys(Keys.ENTER);
			 
			 WebElement rateG = driver.findElement(By.xpath("//*[contains(@id,'txt-rateG')]"));
			 rateG.sendKeys(Keys.BACK_SPACE);
			 rateG.sendKeys("149");
			 rateG.sendKeys(Keys.ENTER);
			 
			 WebElement rateH = driver.findElement(By.xpath("//*[contains(@id,'txt-rateH')]"));
			 rateH.sendKeys(Keys.BACK_SPACE);
			 rateH.sendKeys("149");
			 rateH.sendKeys(Keys.ENTER); 
			 
		 }	
	 public void M_EDate(){
	
		 WebElement MfGd= driver.findElement(By.xpath("//*[contains(@id,'txt-mfgDate')]"));
		 MfGd.sendKeys("09-2019");
		 MfGd.sendKeys(Keys.ENTER);
		
		 WebElement Exp = driver.findElement(By.xpath("//input[@id='txt-expiryDate-0']"));
	     Exp.sendKeys(Keys.ENTER); 
		 }
	 
	 
	 public static void main(String[] args) throws InterruptedException {
		 Opening_Bal_Stock ops = new Opening_Bal_Stock();
		 ops.webLaunch();
		 ops.login();
		 ops.action();
		 ops.SerchStore();
		 ops.seleitem();
		 ops.Serchbatch();
		 ops.batch();
		 ops.unit1();
		 ops.Mrp();
		 ops.Prate();
		 ops.perunitCo();
		 ops.rateAinfo();
		 ops.RemainingRates();
		 ops.M_EDate();
		 
	}*/
}
