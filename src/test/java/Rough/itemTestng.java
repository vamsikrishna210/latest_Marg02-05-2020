package Rough;

//import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
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

public class itemTestng {
	//private static final int Webelement = 0;
	WebDriver driver;
	WebDriverWait Wait;

	@BeforeSuite
	public void webLaunch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin.DESKTOP-P28CFV6\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.8.17/margwebsite/qa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Wait = new WebDriverWait(driver, 20);
	}

	@BeforeTest
	public void login() {
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();

	}

	@Test(priority=1)
	public void action() throws InterruptedException {
		WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
		textbox.clear();
		
		textbox.sendKeys("vijay");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='searchItems']")));
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='textContent']"));
		int count = allOptions.size();
		System.out.println("No.of Autosuggesion " + count);
		System.out.println("List of Autosuggesion");
		for (int i = 0; i < count; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
		}
		// textbox.sendKeys(Keys.ARROW_DOWN);
		textbox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		pass.sendKeys("1234");
		pass.sendKeys(Keys.ENTER);
		
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

	@Test(priority=2)
	public void newb() throws InterruptedException{
		Thread.sleep(3000);
	//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='btn-New']")).click();
	}
	
	// control room Settings
	@Test(priority=3)
	public void controlroom(){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.className("addEffset")).click();
	}
	// code required
	
	@Test(priority=4)
	public void codereq(){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Select itemCodereq = new Select(driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']")));
		itemCodereq.selectByIndex(1);
	}
//  item code
	@Test(priority=5)
	public void itmcod() {
		Select itemCode = new Select(driver.findElement(By.id("IcItemCode")));
		itemCode.selectByVisibleText("Self");
		
		Select itmdup = new Select(driver.findElement(By.id("itemDuplicateAllowed")));
		itmdup.selectByVisibleText("Yes");
		
		Select barcode = new Select(driver.findElement(By.xpath("//select[@id='barcode']")));
		barcode.selectByVisibleText("No");

		/*Select barcodedup = new Select(driver.findElement(By.xpath("//select[@id='barcodeallowed']")));
		barcodedup.selectByVisibleText("No");*/
		
	}
	@Test(priority=6)
	public void workstyl() {

		List<WebElement> wStyle = driver.findElements(By.xpath("//select[@id='ItemWorkingStyleType']"));
		int countSt = wStyle.size();
		System.out.println("Working Styles types" + countSt);
		for (int i = 0; i < countSt; i++) {
			String textWs = wStyle.get(i).getText();
			System.out.println(textWs);
		}
		Select ws = new Select(driver.findElement(By.xpath("//select[@id='ItemWorkingStyleType']")));
		ws.selectByIndex(4);
	}
	@Test(priority=7)
	public void packingreq() {
		Select pack = new Select(driver.findElement(By.id("packing")));
		pack.selectByVisibleText("No");

		Select packname = new Select(driver.findElement(By.id("isPrintNameRequired")));
		packname.selectByVisibleText("Yes");
	}
	@Test(priority=8)
	public void Agencyname() {
		Select agency1 = new Select(driver.findElement(By.id("isAgencyRequired")));
		agency1.selectByVisibleText("Yes");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//*[@id='isAgencyRequired']/option[1]")).isSelected())
		{
			driver.findElement(By.xpath("//select[@id='salt']"));
		}
		else if(driver.findElement(By.xpath("//*[@id='isAgencyRequired']/option[2]")).isSelected())
		{
		WebElement textboxAgency = driver.findElement(By.xpath("//input[@id='agencyRename']"));
		textboxAgency.clear();
		textboxAgency.sendKeys("KGFAgency1121212312654");
		
	    Select visible = new Select(driver.findElement(By.xpath("//select[@id='isAgencyVisibleInList']")));
	    visible.selectByVisibleText("Yes");
     }
	}
	@Test(priority=9)
	public void Saltreqed() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Select saltr = new Select(driver.findElement(By.xpath("//select[@id='salt']")));
		saltr.selectByVisibleText("Yes");
		
		if (driver.findElement(By.xpath("//*[@id='salt']/option[1]")).isSelected())
		{
			driver.findElement(By.id("Category"));
		}
		else if(driver.findElement(By.xpath("//*[@id='salt']/option[2]")).isSelected())
		{
		WebElement TBSalt = driver.findElement(By.xpath("//*[@id='saltrename']"));
		TBSalt.clear();
		TBSalt.sendKeys("Salt123");
	}
		}
	// Category required
	
	@Test(priority=10)
	public void catgryitm() {
		Select catgry = new Select(driver.findElement(By.id("Category")));
		catgry.selectByVisibleText("Yes");
		
        if (driver.findElement(By.xpath("//*[@id='Category']/option[1]")).isSelected()){
	      driver.findElement(By.id("Hsn"));
}
   else if (driver.findElement(By.xpath("//*[@id='Category']/option[2]")).isSelected()){
   		WebElement textboxCat = driver.findElement(By.xpath("//input[@id='CategoryRename']"));
		textboxCat.clear();
		textboxCat.sendKeys("KGFcat1321222323121322123123");
	}}
// hsn Required
	
	@Test(priority=11)
	public void HSNReq() throws InterruptedException {
		Select HSNr = new Select(driver.findElement(By.id("Hsn")));
		HSNr.selectByVisibleText("Yes");
	
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//*[@id='Hsn']/option[1]")).isSelected())
		{
		      driver.findElement(By.xpath("//button[@id='btnGStHeading']")).click();
	}
	   else if (driver.findElement(By.xpath("//*[@id='Hsn']/option[2]")).isSelected())
	   {
	   		WebElement textboxHSN = driver.findElement(By.xpath("//input[@id='hsnRename']"));
	   		textboxHSN.clear();
	   		textboxHSN.sendKeys("KGFHsn1321222323121322123123");
		}}
// Gstin Configration:
	
	@Test(priority=12)
	public void gstHeadingReq() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnGStHeading']")).click();
		
		WebElement igst = driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='igstHeading']"));
		igst.clear();
		Thread.sleep(2000);
		igst.sendKeys("kgfigst");
		igst.sendKeys(Keys.ENTER);

		WebElement sgst = driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='sgstHeading']"));
		sgst.clear();
		Thread.sleep(2000);
		sgst.sendKeys("my sgst!");
		sgst.sendKeys(Keys.ENTER);

		WebElement cgst = driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='cgstHeading']"));
		cgst.clear();
		Thread.sleep(2000);
		cgst.sendKeys("my cgst ");

		WebElement cess = driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='cessHeading']"));
		cess.clear();
		Thread.sleep(2000);
		cess.sendKeys("my cess");

		WebElement addcess = driver.findElement(By.xpath("//div[@class='modal-body']//div[@id='gstHeading']//input[@id='additionalCessHeading']"));
		addcess.clear();
		Thread.sleep(2000);
		addcess.sendKeys("my addcess");
		
		driver.findElement(By.xpath("//button[@id='btnRateInfoSave']")).click();	
	}
	/*//Surcharge
	@Test(priority=13)
	public void Surcharge() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSurcharge1']")).click();
		
		Select Cess = new Select(driver.findElement(By.xpath("//*[@id='isCessVisible']")));
		Cess.selectByIndex(0);
		
		Select AdddCess = new Select(driver.findElement(By.xpath("//*[@id='isAdditionalCessVisible']")));
		AdddCess.selectByIndex(0);
		
		driver.findElement(By.xpath("//button[@id='btnRateInfoSave']")).click();
	}*/
	@Test(priority=13)
	public void Rateinfo() throws InterruptedException{
		driver.findElement(By.xpath("//button[@id='btnSurcharge2']")).click();
		
		WebElement mrp = driver.findElement(By.xpath("//input[@id='mrpRename']"));
		mrp.clear();
		mrp.sendKeys("kfg MRP");
		mrp.sendKeys(Keys.ENTER);
		
		WebElement RA1 = driver.findElement(By.xpath("//input[@id='rateaRename']"));
		RA1.clear();
		RA1.sendKeys("kfg RA");
		RA1.sendKeys(Keys.ENTER);
		
	    Select RB = new Select(driver.findElement(By.xpath("//select[@id='isRatebRequired']")));
	    RB.selectByVisibleText("No");
	    
	    Thread.sleep(3000);
	    
	    if (driver.findElement(By.xpath("//*[@id='isRatebRequired']/option[1]")).isSelected()){
	    	
	      driver.findElement(By.xpath("//button[@id='btnRateInfoSave']")).click();
	      
	      }
	    else if (driver.findElement(By.xpath("//*[@id='isRatebRequired']/option[2]")).isSelected()){
	    	
	    WebElement RB1 = driver.findElement(By.xpath("//input[@id='ratebRename']"));
		RB1.clear();
		RB1.sendKeys("kfg RB");
		RB1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='btnRateInfoSave']")).click();
	}
   }
	@Test(priority=14)
	public void RMBD(){
		Select Rate = new Select (driver.findElement(By.xpath("//select[@id='Rates']")));
		Rate.selectByIndex(1);
	}
	@Test(priority=15)
	public void DiscountApplicable(){
		Select DiscApp = new Select (driver.findElement(By.xpath("//select[@id='discountApplicable']")));
		DiscApp.selectByIndex(0);	
	}
	@Test(priority=16)
	public void VDSC1(){
		Select volume1 = new Select (driver.findElement(By.xpath("//select[@id='discountApplicable']")));
		volume1.selectByIndex(2);
	}
	@Test(priority=17)
	public void ItemType() throws InterruptedException{
		driver.findElement(By.xpath("//button[@id='btnItemtype']")).click();
		Thread.sleep(2000);
		WebElement costly = driver.findElement(By.xpath("//div[@id='gstHeading']//input[@id='itemTypeCostly']"));
		costly.clear();
		Thread.sleep(2000);
		costly.sendKeys("Hot");
		
		WebElement temp8 = driver.findElement(By.xpath("//div[@id='gstHeading']//input[@id='itemType8']"));
		temp8.clear();
		Thread.sleep(2000);
		temp8.sendKeys("chilled");
		
		WebElement temp24 = driver.findElement(By.xpath("//div[@id='gstHeading']//input[@id='itemType24']"));
		temp24.clear();
		Thread.sleep(2000);
		temp24.sendKeys("Room temp");
		
		driver.findElement(By.xpath("//div[@class='pageButton']")).click();
	}
	@Test(priority=18)
	public void RackNo() throws InterruptedException {
		Select RackR = new Select(driver.findElement(By.id("rackno")));
		RackR.selectByVisibleText("No");
	
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//*[@id='rackno']/option[1]")).isSelected())
		{
		      driver.findElement(By.xpath("//select[@id='sale']"));
	}
	   else if (driver.findElement(By.xpath("//*[@id='rackno']/option[2]")).isSelected())
	   {
	   		WebElement textboxRAck = driver.findElement(By.xpath("//input[@id='racknoRename']"));
	   		textboxRAck.clear();
	   		textboxRAck.sendKeys("KGFRack1321222323121322123123");
		}
		}
	@Test(priority=19)
	public void DefaultSalequantity(){
		Select DSQTY = new Select(driver.findElement(By.xpath("//select[@id='sale']")));
		DSQTY.selectByIndex(0);
	}
	@Test(priority=20)
	public void CloseControlRoom(){
		driver.findElement(By.xpath("//button[@class='close itemcontrolClose']//span[contains(text(),'×')]")).click();
	}
	//item code values
	
	@Test(priority =21)
	public void itemcode(){
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']")).click();
		if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[1]")).isSelected()){
			driver.findElement(By.xpath("//select[@id='typeofSupply']")).click();
		}
		else if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[2]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='txtItemCode']")).sendKeys("23456");
		}
		else if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[3]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='txtItemCode']")).sendKeys("23456");
		}
		
	}
	@Test(priority=22)
	public void typeofSupply(){
		List<WebElement> listTs = driver.findElements(By.id("typeofSupply"));
		int countTs = listTs.size();
		System.out.println("No of type of supply ");
		for (int i = 0; i < countTs; i++) {
			String textTs = listTs.get(i).getText();
			System.out.println(textTs);
		}
		Select supply = new Select(driver.findElement(By.id("typeofSupply")));
		supply.selectByVisibleText("Service");
	}
	@Test(priority=23)
	public void barcode(){
		if (driver.findElement(By.xpath("//*[@id='barcode']/option[2]")).isSelected()) {
			driver.findElement(By.id("txtBarcode")).sendKeys("mykgf1234");
		}
		else if (driver.findElement(By.xpath("//*[@id='barcode']/option[1]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='txtProduct']")).sendKeys("my product");
		}
		
	}
	@Test(priority=24)
	public void pkng() {
		if (driver.findElement(By.xpath("//*[@id='packing']/option[2]")).isSelected()) {
		driver.findElement(By.id("txtPacking")).sendKeys("Vamsi34567");
	}
		else if (driver.findElement(By.xpath("//*[@id='packing']/option[1]")).isSelected()) {
		driver.findElement(By.xpath("//textarea[@id='txtPrintName']")).click();
		
		if (driver.findElement(By.xpath("//*[@id='isPrintNameRequired']/option[2]")).isSelected()){
			driver.findElement(By.xpath("//textarea[@id='txtPrintName']")).sendKeys("21351");
		}}}
		
	@Test(priority=25)
	public void unit() throws InterruptedException{
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
	}

