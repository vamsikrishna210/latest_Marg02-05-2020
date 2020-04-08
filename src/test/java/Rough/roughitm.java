
package Rough;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class roughitm {
	WebDriver driver;
	WebDriverWait Wait;

	@BeforeSuite
	public void webLaunch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.8.17/margwebsite/qa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Wait = new WebDriverWait(driver, 20);
	}

	@BeforeTest
	public void login() {
		driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();

	}

	@Test(priority=1)
	public void action() throws InterruptedException {
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
		Thread.sleep(000);
	//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='btn-New']")).click();
	}
// Control room settings:
	@Test(priority=3)
	public void countrlrmm() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.className("addEffset")).click();
	}

	@Test(priority=4)
	public void codereq() {
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

		Select barcodedup = new Select(driver.findElement(By.xpath("//select[@id='barcodeallowed']")));
		barcodedup.selectByVisibleText("No");
		
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
	public void pck() {
		Select pack = new Select(driver.findElement(By.id("packing")));
		pack.selectByVisibleText("Yes");

		Select packname = new Select(driver.findElement(By.id("isPrintNameRequired")));
		packname.selectByVisibleText("Yes");
	}

	@Test(priority=8)
	public void Agencynm() {
		Select agency1 = new Select(driver.findElement(By.id("isAgencyRequired")));
		agency1.selectByVisibleText("No");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//*[@id='isAgencyRequired']/option[1]")).isSelected()){
			driver.findElement(By.xpath("//select[@id='salt']"));
		}
		else if(driver.findElement(By.xpath("//*[@id='isAgencyRequired']/option[2]")).isSelected()){
		WebElement textboxAgency = driver.findElement(By.xpath("//input[@id='agencyRename']"));
		textboxAgency.clear();
		textboxAgency.sendKeys("KGFAgency1121212312654");	
	    Select visible = new Select(driver.findElement(By.xpath("//select[@id='isAgencyVisibleInList']")));
	    visible.selectByVisibleText("Yes");
     }

	}

	@Test(priority=9)
	public void Saltreq() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Select saltr = new Select(driver.findElement(By.xpath("//select[@id='salt']")));
		saltr.selectByVisibleText("No");
		if (driver.findElement(By.xpath("//*[@id='salt']/option[1]")).isSelected()){
			driver.findElement(By.id("Category"));
		}
		else if(driver.findElement(By.xpath("//*[@id='salt']/option[2]")).isSelected()){
		WebElement TBSalt = driver.findElement(By.xpath("//*[@id='saltrename']"));
		TBSalt.clear();
		TBSalt.sendKeys("Salt123");
	}
		}

	@Test(priority=10)
	public void catgryitm() {
		Select catgry = new Select(driver.findElement(By.id("Category")));
		catgry.selectByVisibleText("No");
        if (driver.findElement(By.xpath("//*[@id='Category']/option[1]")).isSelected()){
	      driver.findElement(By.id("Hsn"));
}
   else if (driver.findElement(By.xpath("//*[@id='Category']/option[2]")).isSelected()){
   		WebElement textboxCat = driver.findElement(By.xpath("//input[@id='CategoryRename']"));
		textboxCat.clear();
		textboxCat.sendKeys("KGFcat1321222323121322123123");
	}}

	@Test(priority=11)
	public void HSNReq() throws InterruptedException {
		Select HSNr = new Select(driver.findElement(By.id("Hsn")));
		HSNr.selectByVisibleText("Yes");
	
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//*[@id='Hsn']/option[1]")).isSelected()){
		      driver.findElement(By.id("Hsn"));
	}
	   else if (driver.findElement(By.xpath("//*[@id='Hsn']/option[2]")).isSelected()){
	   		WebElement textboxHSN = driver.findElement(By.xpath("//input[@id='hsnRename']"));
	   		textboxHSN.clear();
	   		textboxHSN.sendKeys("KGFHsn1321222323121322123123");
		}}

		/*WebElement textboxHSN = driver.findElement(By.xpath("//input[@id='hsnRename']"));
		textboxHSN.clear();
		textboxHSN.sendKeys("KGF HSN/San~~~!!@@##$$%%");*/
	

	@Test(priority=12)
	public void gstHeadingReq() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnGStHeading']")).click();
		WebElement igst = driver.findElement(By.id("igstHeading"));
		igst.clear();
		Thread.sleep(2000);
		igst.sendKeys("kgfigst");
		igst.sendKeys(Keys.ENTER);

		WebElement sgst = driver.findElement(By.id("sgstHeading"));
		sgst.clear();
		sgst.sendKeys("my sgst!`*^#");
		sgst.sendKeys(Keys.ENTER);

		WebElement cgst = driver.findElement(By.xpath(" //input[@id='cgstHeading']"));
		cgst.clear();
		cgst.sendKeys("my cgst ~`!*6##");

		WebElement cess = driver.findElement(By.xpath(" //input[@id='cessHeading']"));
		cess.clear();
		cess.sendKeys("my cess~`!*6##");

		WebElement addcess = driver.findElement(By.xpath("//input[@id='additionalCessHeading']"));
		addcess.clear();
		addcess.sendKeys("my addcess~`!*6##");
		
		driver.findElement(By.xpath("//button[@id='btnRateInfoSave']")).click();
		
		
	}
	@Test(priority=13)
	public void surcharge(){
		driver.findElement(By.xpath("//button[@id='btnSurcharge1']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		Select Cess = new Select(driver.findElement(By.xpath("//*[@id='isCessVisible']")));
	    Cess.selectByVisibleText("Yes");
	    
	    Select AddCess = new Select(driver.findElement(By.xpath("//*[@id='isAdditionalCessVisible']")));
	    AddCess.selectByVisibleText("Yes");	
	    
	    driver.findElement(By.xpath("//button[@id='btnRateInfoSave']")).click();
	}
	@Test(priority=14)
	public void Rateinf() throws InterruptedException{
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
	    RB.selectByVisibleText("Yes");
	    
	    WebElement RB1 = driver.findElement(By.xpath("//input[@id='ratebRename']"));
		RB1.clear();
		RB1.sendKeys("kfg RB");
		RB1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='pageButton']")).click();
	}
	@Test(priority=15)
	public void RMBD(){
		Select Rate = new Select (driver.findElement(By.xpath("//select[@id='Rates'")));
		Rate.selectByVisibleText("Date");	
	}
	@Test(priority=16)
	public void discapp(){
		Select discap = new Select(driver.findElement(By.xpath("//select[@id='discountApplicable']")));
		discap.selectByValue("Y");
		
		Select lessby = new Select(driver.findElement(By.xpath("//select[@id='rate_lessBy']")));
		lessby.selectByIndex(1);	
	}
	@Test(priority=17)
	public void itemdisc(){
		Select dsc = new Select(driver.findElement(By.xpath(" //select[@id='ItemDiscountType']")));
		dsc.selectByIndex(0);
		
		Select ITWD = new Select(driver.findElement(By.xpath("//select[@id='itemwiseDiscount']")));
		ITWD.selectByValue("N");	
	}
	@Test(priority=18)
	public void volDisc(){
		Select voldsc = new Select(driver.findElement(By.xpath(" //select[@id='vdisc1']")));
		voldsc.selectByIndex(0);	
		
	}
	
	
	@Test(priority=19)
	public void itemtype() {
		driver.findElement(By.xpath("//button[@id='btnItem']")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		WebElement costly = driver.findElement(By.xpath("//input[@id='itemTypeCostly']"));
		costly.clear();
		costly.sendKeys("too costly!!!~~~~~##$%^^");

		WebElement storage1 = driver.findElement(By.xpath("//input[@id='itemType8']"));
		storage1.clear();
		storage1.sendKeys("below 5'");

		WebElement storage2 = driver.findElement(By.xpath("//input[@id='itemType24']"));
		storage2.clear();
		storage2.sendKeys("below 15'");
		storage2.sendKeys(Keys.ENTER);
		storage2.sendKeys(Keys.ENTER);
		
// for escape (write the function)
		
		//driver.findElement(By.xpath("//button[@id='btnItenType']//span[contains(text(),'×')] ")).click();
	}

	@Test(priority=20)
	public void RackReq() throws InterruptedException {
		Select Rackr = new Select(driver.findElement(By.id("rackno")));
		Rackr.selectByVisibleText("Yes");
		
		if (driver.findElement(By.xpath("//*[@id='rackno']/option[1]")).isSelected()){
		      driver.findElement(By.id("Hsn"));
	}
	   else if (driver.findElement(By.xpath("//*[@id='rackno']/option[2]")).isSelected()){
	   		WebElement textboxRACK = driver.findElement(By.xpath("//input[@id='racknoRename']"));
	   		textboxRACK.clear();
	   		textboxRACK.sendKeys("my Rack123465~~~~!!!@@##");
		}

		/*WebElement textboxRACK = driver.findElement(By.xpath("//input[@id='racknoRename']"));
		textboxRACK.clear();
		textboxRACK.sendKeys("my Rack123465~~~~!!!@@##");
		Thread.sleep(2000);*/
		
	}

//close control room
	
	@Test(priority=21)
	public void closectrlm() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='close itemcontrolClose']")).click();
	}
// creation Page
	@Test(priority=22)
	public void itmecod() {
		if (driver.findElement(	By.xpath("//*[@id='txtItemCodeRequired']/option[1]")).isSelected()) {
			driver.findElements(By.id("typeofSupply"));
		}
		else if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[2]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='txtItemCode']")).sendKeys("kgf01~!@#$");
		}
		else if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[3]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='txtItemCode']")).sendKeys("kgf01~!@#$");
		}
	}

	@Test(priority=23)
	public void typesupp() {
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

	@Test(priority=24)
	public void barcode() {
		if (driver.findElement(By.xpath("//*[@id='barcode']/option[2]")).isSelected()) {
			driver.findElement(By.id("txtBarcode")).sendKeys("mykgf1234~!@#$%^&*(////");
		}
		else{
		driver.findElement(By.id("txtProduct")).sendKeys("mykgf1234!@#$%^&*(");
		}
	}

	@Test(priority=25)
	public void pkng() {

		driver.findElement(By.id("txtPacking")).sendKeys("Vamsi34567~!@#$%^&*(~!@#$%^&*");
		driver.findElement(By.id("txtPrintName")).sendKeys("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
	}

	@Test(priority=26)
	public void unit() throws InterruptedException {
		
		WebElement textbox = driver.findElement(By.xpath("//input[@id='unit']"));
		textbox.clear();
		textbox.sendKeys("PCS");
		Thread.sleep(2000);
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		int count = allOptions.size();
		System.out.println("No.of Autosuggesion " + count);
		System.out.println("List of Autosuggesion");
		for (int i = 0; i < count; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
		}
		textbox.sendKeys(Keys.ARROW_DOWN);
		textbox.sendKeys(Keys.ENTER);
	}

	/*
	 * WebElement textboxUNT = driver.findElement(By.id("unit"));
	 * textboxUNT.sendKeys(Keys.SPACE); Thread.sleep(2000);
	 * textboxUNT.sendKeys(Keys.ENTER);
	 * driver.findElement(By.id("txtUnitName")).sendKeys("kgfUn");
	 * 
	 * List<WebElement> allOptions1=
	 * driver.findElements(By.xpath("//*[@id='drpUqc']")); int
	 * count1=allOptions1.size();
	 * System.out.println("No.of Autosuggesion "+count1);
	 * System.out.println("List of Autosuggesion"); 
	 * for(int i=0;i<count1;i++){
	 * String text1 = allOptions1.get(i).getText();
	 *  System.out.println(text1); 
	 *  }
	 * Select UQC = new Select(driver.findElement(By.id("drpUqc")));
	 * UQC.selectByVisibleText("BTL-BOTTLES");
	 * driver.findElement(By.xpath("//*[@id='btn-Save']")).click();
	 */

	/*
	 * List<WebElement> allOptionsU =
	 * driver.findElements(By.xpath("//*[@class='dropdown-menu show']")); 
	 * int countU=allOptionsU.size();
	 * System.out.println("No.of Autosuggesion "+countU);
	 * System.out.println("List of Autosuggesion");
	 * for(int i=0;i<countU;i++){
	 * String textU = allOptionsU.get(i).getText();
	 * System.out.println(textU); }
	 * Select UQC = new
	 * Select(driver.findElement(By.xpath("//input[@id='unit']")));
	 * UQC.selectByVisibleText("KGS-KILOGRAMS");
	 */
	@Test(priority=27)
	public void decml() {
		Select decml = new Select(driver.findElement(By.xpath("//*[@id='deciaml']")));
		decml.selectByVisibleText("Yes");
	}

	@Test(priority=28)
	public void agennreq() throws InterruptedException {
		WebElement textbox = driver.findElement(By.xpath("//input[@id='txtcompName']"));
		textbox.clear();
		textbox.sendKeys(Keys.SPACE);
		// textbox.sendKeys("");
		Thread.sleep(2000);
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		int count = allOptions.size();
		System.out.println("No.of Autosuggesion " + count);
		System.out.println("List of Autosuggesion");
		for (int i = 0; i < count; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
		}
		textbox.sendKeys(Keys.ARROW_DOWN);
		textbox.sendKeys(Keys.ENTER);
		/*
		 * WebElement AGEN =
		 * driver.findElement(By.xpath("//*[@id='txtcompName']")); AGEN.clear();
		 * AGEN.sendKeys(Keys.SPACE); Thread.sleep(2000);
		 * AGEN.sendKeys(Keys.ENTER);
		 * driver.findElement(By.id("txtCName")).sendKeys("VAMMSSIKgf567");
		 * driver.findElement(By.id("txtbillprint")).sendKeys("1234657890");
		 * driver.findElement(By.id("txtDumpdays")).sendKeys("987654");
		 * 
		 * Select MORE = new Select(driver.findElement(By.id("drpMoreOption")));
		 * MORE.selectByVisibleText("Yes");
		 * 
		 * driver.findElement(By.id("txtRemark")).sendKeys(
		 * "~!@#$%^&*()_~!@#$%^&*()_|}{:>< <>L<WZAEXSRCDVFTMNJI987812146132165111231~!@#$%^&*()|{}|:<><>~!@#$%^&*()~!@#$%^&*()__)(*&^%#EWXSRGT"
		 * );
		 * 
		 * Select countinue = new
		 * Select(driver.findElement(By.id("drpContinued")));
		 * countinue.selectByVisibleText("Yes");
		 * 
		 * driver.findElement(By.id("txtReorderPref")).sendKeys("96863");
		 * driver.
		 * findElement(By.xpath("//*[@id='txtStoreNo']")).sendKeys("96863");
		 * 
		 * Select prohibited = new
		 * Select(driver.findElement(By.id("drpProhibit")));
		 * prohibited.selectByVisibleText("No");
		 * 
		 * driver.findElement(By.id("txtExpireReceiveUpto")).sendKeys(
		 * "!~!@#$%%^^968");
		 * driver.findElement(By.id("txtReorderFormula")).sendKeys
		 * ("!~!@#$%%^^963");
		 * driver.findElement(By.xpath("//*[@id='txtMinmargin']"
		 * )).sendKeys("!~!@#$%%^^96sdfsf");
		 * 
		 * driver.findElement(By.xpath("//*[@id='btnAddMore']")).click();
		 * driver.findElement(By.id("txtEmain")).sendKeys("123456789@123.com");
		 * driver.findElement(By.id("txtEcc")).sendKeys("123456789001@111.com");
		 * driver
		 * .findElement(By.id("txtEbcc")).sendKeys("123456789001@123.com");
		 * driver
		 * .findElement(By.xpath("//*[@id='txtWebsite']")).sendKeys("123.com");
		 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 * driver.findElement(By.id("btnSave")).click();
		 * 
		 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 * WebElement el = driver.findElement(By.id("btn-Save"));
		 * ((JavascriptExecutor)driver).executeScript("arguments[0].click()",
		 * el);
		 */}

	@Test(priority=29)
	public void ItemSalt() throws InterruptedException {
		if (driver.findElement(By.xpath("//*[@id='salt']/option[2]")).isSelected()) {
			WebElement Salti = driver.findElement(By.id("salt"));
			Salti.clear();
			Salti.sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			Salti.sendKeys(Keys.ENTER);
			driver.findElement(By.id("txtSaleName")).sendKeys("vamsikrishna12345~~~@#$");

			Select MOREinfo = new Select(driver.findElement(By.id("purpose")));
			MOREinfo.selectByVisibleText("Yes");

			driver.findElement(By.id("txtIndication")).sendKeys("for all kind of things");
			driver.findElement(By.id("txtDosage")).sendKeys("180 MG");
			driver.findElement(By.id("txtSideEffect")).sendKeys("no side effects ");
			driver.findElement(By.id("txtSideEffect2")).sendKeys("always have very good effects ");
			driver.findElement(By.id("txtSpecialPrecautions")).sendKeys("any time can consume ");
			driver.findElement(By.id("txtDrugInteractions")).sendKeys("morning 90mg , evening 90mg ");
			driver.findElement(By.xpath("//*[@id='txtRemark']")).sendKeys("use every time good for health");

			Select Narcotic = new Select(driver.findElement(By.id("drpNarcotic")));
			Narcotic.selectByVisibleText("Yes");
			Select ScheduleH = new Select(driver.findElement(By.id("drpSchedule")));
			ScheduleH.selectByVisibleText("Yes");
			Select ScheduleH1 = new Select(driver.findElement(By.id("drpScheduleH1")));
			ScheduleH1.selectByVisibleText("Yes");

			driver.findElement(By.xpath("//*[@id='txtMaximumRate']")).sendKeys("2311121223");
			Select Continued = new Select(driver.findElement(By.id("drpContinued")));
			Continued.selectByVisibleText("No");
			Select Prohibited = new Select(driver.findElement(By.id("drpProhibited")));
			Prohibited.selectByVisibleText("Yes");
			driver.findElement(By.xpath("//*[@id='btn-Save']/span[1]")).click();
		}
	}

	@Test(priority=30)
	public void Icat() throws InterruptedException {
		if (driver.findElement(By.xpath("//*[@id='Category']/option[2]")).isSelected()) {
			WebElement textbox = driver.findElement(By.xpath("//input[@id='category']"));
			textbox.clear();
			textbox.sendKeys(Keys.SPACE);
			textbox.sendKeys("vams");
			Thread.sleep(2000);
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
			int count = allOptions.size();
			System.out.println("No.of Autosuggesion " + count);
			System.out.println("List of Autosuggesion");
			for (int i = 0; i < count; i++) {
				String text = allOptions.get(i).getText();
				System.out.println(text);
			}
			textbox.sendKeys(Keys.ARROW_DOWN);
			textbox.sendKeys(Keys.ENTER);
		}
	}

	@Test(priority=31)
	public void IHsn() throws InterruptedException {
		WebElement textbox = driver.findElement(By.xpath("//input[@id='hsn']"));
		textbox.clear();
		textbox.sendKeys(Keys.SPACE);
		textbox.sendKeys("2");
		Thread.sleep(2000);
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		int count = allOptions.size();
		System.out.println("No of Autosuggestion" + count);
		System.out.println("List of Autosuggestions");
		for (int i = 0; i < count; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
		}
		textbox.sendKeys(Keys.ARROW_DOWN);
		textbox.sendKeys(Keys.ENTER);
	}

	
	 // @Test
	 /* public void ITax() throws InterruptedException{
	 WebElement textbox=driver.findElement(By.xpath("//input[@id='taxxCategory']"));
	  textbox.clear();
	  textbox.sendKeys(Keys.SPACE); 
	  textbox.sendKeys(Keys.ENTER); 
	  //textbox.sendKeys("KGF");
	  Thread.sleep(2000);
	  
	  List<WebElement>allOptions=driver.findElements(By.xpath("//*[@class='dropdown-menu show']")); 
	  int count=allOptions.size();
	  System.out.println("No of Autosuggestion"+count);
	  System.out.println("List of Autosuggestions");
	  for(int i=0;i<count;i++) {
	  String text=allOptions.get(i).getText(); 
	  System.out.println(text); }
	  textbox.sendKeys(Keys.ARROW_DOWN);
	  textbox.sendKeys(Keys.ENTER);
	 
	  driver.findElement(By.xpath("//input[@id='txtcessper']")).sendKeys("2231332" );
	  
	  driver.findElement(By.xpath( "//div[@class='text-right pageButton']//button[1]")).click(); }
	 */
	@Test(priority=32)
	public void purchaseinfo() {
		WebElement MRP = driver.findElement(By.xpath("//input[@id='txtmrp']"));
		MRP.sendKeys("100000");
		MRP.sendKeys(Keys.ENTER);

		WebElement PRate = driver.findElement(By.xpath("//input[@id='txtprate']"));
		PRate.sendKeys("5000");
		PRate.sendKeys(Keys.ENTER);

		WebElement Cost = driver.findElement(By.xpath("//input[@id='txtcost']"));
		Cost.sendKeys("6000");
		Cost.sendKeys(Keys.ENTER);

	}

	@Test(priority=33)
	public void Saleinfo() {
		WebElement RateA = driver.findElement(By.xpath("//input[@id='txtratea']"));
		RateA.sendKeys("9850");
		RateA.sendKeys(Keys.ENTER);

		WebElement RateB = driver.findElement(By.xpath("//input[@id='txtrateb']"));
		RateB.sendKeys("9850");
		RateB.sendKeys(Keys.ENTER);

		WebElement RateC = driver.findElement(By.xpath("//input[@id='txtratec']"));
		RateC.sendKeys("9850");
		RateC.sendKeys(Keys.ENTER);

		WebElement RateD = driver.findElement(By.xpath("//input[@id='txtrated']"));
		RateD.sendKeys("9850");
		RateD.sendKeys(Keys.ENTER);

		WebElement RateE = driver.findElement(By.xpath("//input[@id='txtratee']"));
		RateE.sendKeys("9850");
		RateE.sendKeys(Keys.ENTER);

		WebElement RateF = driver.findElement(By.xpath("//input[@id='txtratef']"));
		RateF.sendKeys("9850");
		RateF.sendKeys(Keys.ENTER);

		WebElement RateG = driver.findElement(By.xpath("//input[@id='txtrateg']"));
		RateG.sendKeys("9850");
		RateG.sendKeys(Keys.ENTER);

		WebElement RateH = driver.findElement(By.xpath("//input[@id='txtrateh']"));
		RateH.sendKeys("9850");
		RateH.sendKeys(Keys.ENTER);
	}

	@Test(priority=34)
	public void Discinfo() throws InterruptedException {
		// driver.findElement(By.id("ddldiscount")).click();
		List<WebElement> allOptions = driver.findElements(By.id("ddldiscount"));
		int count = allOptions.size();
		System.out.println("No.of Autosuggesion " + count);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for (int i = 0; i < count; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
		}
		Thread.sleep(2000);
		Select SaleRate = new Select(driver.findElement(By.id("ddldiscount")));
		SaleRate.selectByVisibleText("No Discount");

		driver.findElement(By.xpath("//input[@id='txtitemdiscount1']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='txtlessby']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='txtSpecialDisc']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='txtonqtyspecdisc']")).sendKeys("12345");

		driver.findElement(By.xpath("//input[@id='txtMaximumDiscount']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='txtPurchaseDiscount']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='txtPurchaseDiscount2']")).sendKeys("12345");
		driver.findElement(By.id("txtDiscountLess")).sendKeys("12345");
		driver.findElement(By.xpath(" //input[@id='txtFree']")).sendKeys("321321");
		driver.findElement(By.xpath("//input[@id='txtScheme']")).sendKeys("12345");

		List<WebElement> allOptions1 = driver.findElements(By.xpath("//select[@id='Validfrom']"));
		int count1 = allOptions1.size();
		System.out.println("No.of Autosuggesion " + count1);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for (int i = 0; i < count1; i++) {
			String text1 = allOptions1.get(i).getText();
			System.out.println(text1);
		}
		Thread.sleep(2000);
		Select Scheam = new Select(driver.findElement(By.xpath("//select[@id='Validfrom']")));
		Scheam.selectByVisibleText("No Scheme");

		WebElement dateBox = driver.findElement(By.xpath("//input[@id='txtSchemefromDate']"));
		dateBox.sendKeys("01042018");

		WebElement dateBox2 = driver.findElement(By.xpath("//input[@id='txtSchemetoDate']"));
		dateBox2.sendKeys("01032019");
		dateBox2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Test(priority=35)
	public void Quantity() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement Dsq = driver.findElement(By.id("txtBoxQuantity"));
		Dsq.sendKeys("54651561464");
		Dsq.sendKeys(Keys.ENTER);

		WebElement TMQ = driver.findElement(By.xpath("//input[@id='txtMinimumQuantity']"));
		TMQ.sendKeys("98506546545654654");
		TMQ.sendKeys(Keys.ENTER);

		WebElement ROD = driver.findElement(By.xpath("//input[@id='txtReorderDays']"));
		ROD.sendKeys("98506546545654654");
		ROD.sendKeys(Keys.ENTER);

		WebElement ROQ = driver.findElement(By.xpath("//input[@id='txtReorderQuantity']"));
		ROQ.sendKeys("98506546545654654");
		ROQ.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		WebElement MMQ = driver.findElement(By.id("txtMaximumQuantity"));
		MMQ.sendKeys("98506546545654654");
		MMQ.sendKeys(Keys.ENTER);

		WebElement TC = driver.findElement(By.xpath("//input[@id='txtconversion']"));
		TC.sendKeys("98506546545654654");
		TC.sendKeys(Keys.ENTER);
	}

	@Test(priority=36)
	public void OtherInfo() throws InterruptedException {
		WebElement minmmrgn = driver.findElement(By.xpath("//input[@id='txtMinimumMargin']"));
		minmmrgn.sendKeys("ghdiufgdjkgh9878987898978978");
		minmmrgn.sendKeys(Keys.ENTER);

		List<WebElement> Status = driver.findElements(By.xpath("//select[@id='status1']"));
		int counts = Status.size();
		System.out.println("No.of Autosuggesion " + counts);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for (int i = 0; i < counts; i++) {
			String texts = Status.get(i).getText();
			System.out.println(texts);
		}
		Thread.sleep(2000);
		Select Stus = new Select(driver.findElement(By.xpath("//select[@id='status1']")));
		Stus.selectByVisibleText("Continue");

		Select itype = new Select(driver.findElement(By.xpath("//select[@id='type']")));
		itype.selectByVisibleText("Normal");

		WebElement IRack = driver.findElement(By.xpath("//input[@id='txtRackNo']"));
		IRack.sendKeys("fsdfgd123456");
		IRack.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// control room
		driver.findElement(By.className("addEffset")).click();

		Select deftyp = new Select(driver.findElement(By.xpath("//select[@name='sale']")));
		deftyp.selectByVisibleText("Yes");

		List<WebElement> Negtive = driver.findElements(By.xpath("//select[@id='negative']"));
		int countNE = Negtive.size();
		System.out.println("No.of Autosuggesion " + countNE);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for (int i = 0; i < countNE; i++) {
			String textNeg = Negtive.get(i).getText();
			System.out.println(textNeg);
		}
		Thread.sleep(2000);
		Select negt = new Select(driver.findElement(By.xpath("//select[@id='negative']")));
		negt.selectByVisibleText("Both");

		Select F6 = new Select(driver.findElement(By.xpath("//select[@id='F6WorkorNotType']")));
		F6.selectByVisibleText("Yes");
		Thread.sleep(2000);

		List<WebElement> Dealf = driver.findElements(By.xpath("//select[@id='dealFrom']"));
		int countDF = Dealf.size();
		System.out.println("No.of Autosuggesion " + countDF);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for (int i = 0; i < countDF; i++) {
			String textDF = Dealf.get(i).getText();
			System.out.println(textDF);
		}
		Thread.sleep(2000);
		Select dealf = new Select(driver.findElement(By.xpath("//select[@id='dealFrom']")));
		dealf.selectByVisibleText("Manual");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// close control room
		driver.findElement(By.xpath("//h2[@class='headingItem']//span[contains(text(),'×')]")).click();

		Select Hidei = new Select(driver.findElement(By.xpath("//select[@id='Hide']")));
		Hidei.selectByVisibleText("No");

		Select Neg = new Select(driver.findElement(By.xpath("//select[@id='Negative']")));
		Neg.selectByVisibleText("Yes");

		Select RATEEFF = new Select(driver.findElement(By.xpath("//select[@id='RatesEffect']")));
		RATEEFF.selectByVisibleText("Yes");

		WebElement textboxMFR = driver.findElement(By.xpath("//input[@id='mfrname']"));
		textboxMFR.clear();
		textboxMFR.sendKeys("Vam");
		Thread.sleep(2000);
		List<WebElement> allOptions2 = driver.findElements(By.xpath("//input[@id='mfrname']"));
		int count2 = allOptions2.size();
		System.out.println("No.of Autosuggesion " + count2);
		System.out.println("List of Autosuggesion");
		for (int i = 0; i < count2; i++) {
			String text2 = allOptions2.get(i).getText();
			System.out.println(text2);
		}
		textboxMFR.sendKeys(Keys.ARROW_DOWN);
		// textboxMFR.sendKeys(Keys.ARROW_DOWN);
		textboxMFR.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test(priority=37)
	public void upload1() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='btnEdit']")).click();
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection("C:\\Users\\admin\\Desktop\\568.jpg");
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
	}

	@Test(priority=38)
	public void SaveI() {
		driver.findElement(By.xpath("//button[@name='btnSave']")).click();
	}
}
