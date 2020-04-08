package Inventory_Transaction;

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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.margerp.qa.xls_Reader.Xls_Reader;

public class Sale_Bill_Settings {
	WebDriver driver;
	WebDriverWait Wait;
	boolean found = false;
	
	
	@BeforeSuite
	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/QA");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
	    	driver.findElement(By.xpath("//a[@class='nav-link login']")).click();
		}
	 @BeforeTest
	 public void login() {
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();
	}
    @Test(priority=1)
	 public void action() throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
		 
		// WebElement textbox = driver.findElement(By.xpath("//*[@id='SearchBox']"));
			//textbox.clear();
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
			Thread.sleep(2000);
			/*WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			pass.sendKeys("1234");
			pass.sendKeys(Keys.ENTER);*/
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Inventory Trans."));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Sale"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("New Bill")).click();
	 }
    @Test(priority=2)
	 // Date
	 public void ControlOpen() throws InterruptedException{
    	Thread.sleep(5000);
    	WebElement ele = driver.findElement(By.xpath("//a[@id='aControlRoomSetting']//img"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
    }
    @Test(priority=3)
    public void askBilling(){
    	Select ABill = new Select(driver.findElement(By.xpath("//select[@id='txtisPartyStatusOnTransaction']")));
    	ABill.selectByVisibleText("No");
    }
    @Test(priority=4)
    public void asksaletype(){
    	Select saletyp = new Select(driver.findElement(By.xpath("//select[@id='txtisSaleTypeForBilling']")));
    	saletyp.selectByVisibleText("No");
    }
  
   @Test(priority=4)
   public void ASkNetRate(){
	   Select AnetRa = new Select(driver.findElement(By.xpath("//select[@id='askNetRate']")));
	   AnetRa.selectByVisibleText("No");
   }
   
   @Test(priority=5)
   public void MFG() throws InterruptedException{
	   WebElement Mfg = driver.findElement(By.xpath("//button[@id='ExpiryMFG']"));
	   Mfg.click();
	   Thread.sleep(2000);
	   Select ExpREq = new Select(driver.findElement(By.xpath("//select[@id='isExpiaryDate']")));
	   ExpREq.selectByVisibleText("No");
	   
	   if(driver.findElement(By.xpath("//*[@id='isExpiaryDate']/option[1]")).isSelected()){
		   WebElement Mfgsett = driver.findElement(By.xpath("//button[@id='btn-Save']"));
		   Mfgsett.click();   
	   }
	   else {
		   Select Dft = new Select(driver.findElement(By.xpath("//select[@id='expiryDateFormat']")));
		   Dft.selectByIndex(0); 
		   
		   Select NEXPB = new Select(driver.findElement(By.xpath("//select[@id='nearExpiredItemsonBilling']")));
		   NEXPB.selectByVisibleText("Indicate");
		   
		   WebElement calcExp = driver.findElement(By.xpath("//input[@id='txtcalculateNearExpiryDays']"));
		   calcExp.clear();
		   calcExp.sendKeys("90");
		   calcExp.sendKeys(Keys.ENTER);
		   
		   Select ZRO = new Select(driver.findElement(By.xpath("//select[@id='allowRateZERORateorBanIndicateforExpiredItems']")));
		   ZRO.selectByVisibleText("Indicate");
		   Thread.sleep(2000);
		   
		   WebElement Mfgsett = driver.findElement(By.xpath("//button[@id='btn-Save']"));
		   Mfgsett.click();   
		   
	   }
   }//Rate * Quantity 
   @Test(priority=6)
   public void AmountCalc(){
	   Select Amtc = new Select(driver.findElement(By.xpath("//select[@id='amountCalculationOnBilling']")));
	   Amtc.selectByIndex(0);
 
   }
   @Test(priority=7)
   public void  MrFrom(){
	   Select Mr = new Select(driver.findElement(By.xpath("//select[@id='mrFrom']")));
	   Mr.selectByIndex(2);
   }
	@Test(priority=8)
    public void AskBillAndItem() throws InterruptedException{
		WebElement btun = driver.findElement(By.xpath("//button[@id='sale-bill-discount']"));
		btun.click();
		Thread.sleep(2000);
		
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@id='billDiscount']"));

			for (WebElement ele : allCheckbox) {
			    if (!ele.isSelected()) {
			        ele.click();
			    }
			}
		WebElement save = driver.findElement(By.xpath("//button[@id='btn-Save']"));
		save.click();
	}
	@Test(priority=8)
	public void Lastdeal(){
		Select Last = new Select (driver.findElement(By.xpath("//select[@id='replaceMasterRateDealOnLast']")));
		Last.selectByIndex(0);
		
	}
	@Test(priority=9)
	public void repeat(){
		Select Rept = new Select (driver.findElement(By.xpath("//select[@id='IndicateIfItemRepeatedInBill']")));
		Rept.selectByIndex(2);
	}
	@Test(priority=10)
	public void Zreo(){
		Select Zro = new Select(driver.findElement(By.xpath("//select[@id='IndicateIfBillingRateIsZero']")));
		Zro.selectByIndex(2);
	}
	@Test(priority=11)
	public void windowindex(){
		Select winindex = new Select (driver.findElement(By.xpath("//select[@id='openBatchWindowIndexOn']")));
		winindex.selectByIndex(3);
	}
	@Test(priority=12)
	public void cursor(){
		Select curs = new Select(driver.findElement(By.xpath("//select[@id='txtCursorshouldwait']")));
		curs.selectByIndex(1);
	}
	@Test(priority=13)
	public void batch(){
		Select bat = new Select(driver.findElement(By.xpath("//select[@id='rateFromMasterBatchDate']")));
		bat.selectByIndex(1);
	}
	@Test(priority=14)
	public void free(){
	WebElement FreeQty = driver.findElement(By.xpath("//button[@id='btnFreeQtyCondition']"));
	FreeQty.click();
	
	List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@id='freeQtyConditionOnSale']"));

	for (WebElement ele : allCheckbox) {
	    if (!ele.isSelected()) {
	        ele.click();
	    }
	}
	WebElement save = driver.findElement(By.xpath("//button[@id='btnRateInfoSave']"));
	save.click();
}
	@Test(priority=15)
	public void freeDec(){
		Select freedec = new Select(driver.findElement(By.xpath("//select[@id='freeQuantityRequiredinDecimal']")));
		freedec.selectByIndex(2);
	}
	@Test(priority=16)
	public void calc(){
		Select cal = new Select(driver.findElement(By.xpath("//select[@id='calculationTypeForSale']")));
		cal.selectByIndex(0);
	}
	@Test(priority=17)
	public void lossindic(){
		WebElement lossin = driver.findElement(By.xpath("//*[@id='loss']"));
		lossin.click();
		
		Select margin = new Select(driver.findElement(By.xpath("//select[@id='NetLossAndMarginLossIndication']")));
		margin.selectByIndex(0);
		
		Select losscalc = new Select(driver.findElement(By.xpath("//select[@id='LossCalculateOn']")));
		losscalc.selectByIndex(0);
		
		WebElement minmarg = driver.findElement(By.xpath("//input[@id='txtminMarginForLossIndication']"));
		minmarg.sendKeys("0");
		
		WebElement save = driver.findElement(By.xpath("//button[@id='btn-Save']"));
		save.click();
		
	}
	@Test(priority=18)
	public void negtivstk(){
		Select Neg = new Select(driver.findElement(By.xpath("//select[@id='negativeAllowed']")));
		Neg.selectByIndex(2);
		
	}
	@Test(priority=19)
	public void bill(){
		
     Select	bill = new Select(driver.findElement(By.xpath("//select[@id='askBillNo']")));
     bill.selectByIndex(1);
}
	@Test(priority=20)
	public void LoadChallan(){
		Select challan = new Select(driver.findElement(By.xpath("//select[@id='loadPendingChallans']")));
		challan.selectByIndex(1);
	}
	@Test(priority=21)
	public void ChangeRate(){
		Select ChangeRate = new Select(driver.findElement(By.xpath("//select[@id='updateChangedRate']")));
		ChangeRate.selectByIndex(0);
	}
	@Test(priority=22)
	public void CahngeDiscount(){
		Select ChDisc = new Select( driver.findElement(By.xpath("//select[@id='updateChangedDiscount']")));
		ChDisc.selectByIndex(0);
	}
	@Test(priority=23)
	public void mrR(){
		Select Mr = new Select (driver.findElement(By.xpath("//select[@id='txtisMR']")));
		Mr.selectByVisibleText("Yes");
	}
	@Test(priority=24)
	public void Modeofpay(){
		Select Mop = new Select(driver.findElement(By.xpath("//select[@id='txtisModeofPayment']")));
		Mop.selectByIndex(0);
	}
	@Test(priority=25)
	public void WaitforLed(){
		Select Wfl = new Select( driver.findElement(By.xpath("//select[@id='txtcursorwaitonadditionaledger']")));
		Wfl.selectByIndex(0);
	}
	@Test(priority=26)
	public void Askparty(){
		Select Apty = new Select( driver.findElement(By.xpath("//select[@id='txtaskpartyinretailbilling']")));
		Apty.selectByVisibleText("Ask");
	}
	@Test(priority=27)
	public void NegticIndi(){
		Select Neg = new Select(driver.findElement(By.xpath("//select[@id='isGoingtoNegativeStock']")));
		Neg.selectByVisibleText("Yes");
		
	}
	@Test(priority=28)
	public void closeControl(){
		WebElement Close = driver.findElement(By.xpath("//span[contains(text(),'×')]"));
		Close.click();
	}
	}














