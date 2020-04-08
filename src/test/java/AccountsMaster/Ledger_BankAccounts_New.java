package AccountsMaster;

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

public class Ledger_BankAccounts_New {
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
	public void serchCompany() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchBox")));
			textbox.sendKeys("vamsikrishna");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> allOptions= driver.findElements(By.xpath("//*[@class='textContent']"));
			int count=allOptions.size();
			System.out.println("No.of Autosuggesion "+count);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count;i++){
				String text = allOptions.get(i).getText();
				System.out.println(text);	
			}
			textbox.sendKeys(Keys.ENTER);
	}
	public void Master() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.linkText("Master"));
		action.moveToElement(menu).perform();
		menu.sendKeys(Keys.ENTER);
		
		WebElement submenu1 = driver.findElement(By.linkText("Accounts Master"));
		action.moveToElement(submenu1).perform();
		submenu1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Ledger Master")).click();
		Thread.sleep(3000);
		
	}
	public void newleder (){
		driver.findElement(By.xpath("//button[@title='New']")).click();
	}
	public void ctrlrm () throws InterruptedException {
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//img[@src='./assets/images/setting.png'")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement textbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//a[@id='aControlRoomSetting']//img")));
		
		textbox1.click();
		
		Thread.sleep(2000);
		Select Codereq = new Select(driver.findElement(By.id("code")));
	    Codereq.selectByIndex(2);
	    Thread.sleep(2000);
	    
	    Select Dupname = new Select(driver.findElement(By.xpath("//select[@id='name']")));
	    Dupname.selectByVisibleText("Yes");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='close itemcontrolClose']")).click();
	}
	public void newname() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//*[@id='code']/option[1]")).isSelected()){
			driver.findElement(By.id("txtlegername")).sendKeys("HDFC");
		}
		else if (driver.findElement(By.xpath("//*[@id='code']/option[2]")).isSelected()){
			driver.findElement(By.id("txtalternatecode")).sendKeys("12345");
			driver.findElement(By.id("txtlegername")).sendKeys("HDFC");
		}
		else if(driver.findElement(By.xpath("//*[@id='code']/option[3]")).isSelected()){
			driver.findElement(By.id("txtalternatecode")).sendKeys("12345");
			driver.findElement(By.id("txtlegername")).sendKeys("HDFC");
		}		
		
	}
		
	public void Accountgroup() throws InterruptedException{
		WebElement Accgrp = driver.findElement(By.xpath("//input[@id='drpAccountGroup']"));
		Accgrp .clear();
		//textbox1.sendKeys(Keys.SPACE);
		Accgrp .sendKeys("B");
		Thread.sleep(5000);
		List<WebElement> allOptions1= driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
		int count1=allOptions1.size();
		System.out.println("No.of Autosuggesion "+count1);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count1;i++)
		{
			String text1 = allOptions1.get(i).getText();
			System.out.println(text1);
			//System.out.println(allOptions1.get(i).getText());
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Accgrp.sendKeys(Keys.ARROW_DOWN);
		Accgrp.sendKeys(Keys.ENTER);
	}
	public void station() throws InterruptedException{
		WebElement ston = driver.findElement(By.xpath("//input[@id='ddlstation']"));
		ston.clear();
		ston.sendKeys("r");
		Thread.sleep(2000);
		List<WebElement> allOptions2= driver.findElements(By.xpath("//*[@id='ddlCountryLinkID']"));
		int count2=allOptions2.size();
		System.out.println("No.of Autosuggesion "+count2);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count2;i++)
		{
			String text2 = allOptions2.get(i).getText();
			System.out.println(text2);	
		}
		    ston.sendKeys(Keys.ARROW_DOWN);			
			ston.sendKeys(Keys.ENTER);	
	}
	public void mailtoB() throws InterruptedException{
		WebElement mail = driver.findElement(By.xpath("//input[@id='txtMailTo']"));
		mail.clear();
		Thread.sleep(2000);
		mail.sendKeys("vamsikrishna7569");
	}
	public void addressled() throws InterruptedException{
		WebElement Address1 = driver.findElement(By.xpath("//input[@id='txtaddress1']"));
		Address1.sendKeys("gkjghjgk~~!!@@@~!@#$%^&*QWERTYUqwertyu989844894748848144849845198498449865484498498fsdfsdfdfsdfsdffsdfsfsdfsdfsdffsdffsdffsdfdfsdfdfsdfsdfsdfsdfsfsdfffsdfsdfsfsdfsdfsdfsdfsdfsdfsdfsfd"); 
		Thread.sleep(3000);
		
	}
	public void country1() throws InterruptedException{
		/*WebElement cntry = driver.findElement(By.xpath("//*[@id='ddlCountryLinkID']"));
		 //cntry.clear();
		cntry.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		cntry.sendKeys(Keys.ENTER);
		 //cntry.sendKeys("Vamsi");
		Thread.sleep(2000);
		
		driver.findElement(By.id("txtCountryName")).sendKeys("KGF12~!@#$%^34");
		driver.findElement(By.xpath("//input[@id='txtCountryCode']")).sendKeys("KGF7569");
		driver.findElement(By.xpath("//input[@id='txtCurrencySymbol']")).sendKeys("$@~~~~~!!!!!");
		driver.findElement(By.xpath("//input[@id='txtCurrencyString']")).sendKeys("GOLD7569");
		driver.findElement(By.xpath("//marg-button[@tabindex='5']//button[@id='btn-Save']")).click();*/
		WebElement textbox2 = driver.findElement(By.xpath("//*[@id='ddlCountryLinkID']"));
		textbox2.clear();
		textbox2.sendKeys("India");
		Thread.sleep(2000);
		List<WebElement> allOptions2= driver.findElements(By.xpath("//*[@id='ddlCountryLinkID']"));
		int count2=allOptions2.size();
		System.out.println("No.of Autosuggesion "+count2);
		System.out.println("List of Autosuggesion");
		for(int i=0;i<count2;i++)
		{
			String text2 = allOptions2.get(i).getText();
			System.out.println(text2);	
		}
		   // textbox2.sendKeys(Keys.ARROW_DOWN);
			textbox2.sendKeys(Keys.ARROW_DOWN);
			textbox2.sendKeys(Keys.ENTER);	
	}
	public void state1() throws InterruptedException{
		WebElement stat1 = driver.findElement(By.id("ddlStateLinkID"));
		stat1.clear();
		
		stat1.sendKeys("New Delhi");
		Thread.sleep(2000);
		List<WebElement> allOptions3= driver.findElements(By.id("ddlStateLinkID"));
		int count3=allOptions3.size();
		System.out.println("No.of Autosuggesion "+count3);
		System.out.println("List of Autosuggesion");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for(int i=0;i<count3;i++)
		{
			String text3 = allOptions3.get(i).getText();
			System.out.println(text3);	
		}
		
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		stat1.sendKeys(Keys.ARROW_DOWN);
		stat1.sendKeys(Keys.ENTER);
	}
	public void city1(){
		driver.findElement(By.xpath("//*[@id='ddlCity']")).sendKeys("Rajahmundry");
		driver.findElement(By.xpath("//input[@id='txtPostalCode']")).sendKeys("Rajahmundry533101");	
	}
	public void openbal(){
		driver.findElement(By.xpath("//input[@id='txtOpeningBalance']")).sendKeys("500000");
		
		Select OPBL = new Select(driver.findElement(By.id("ddlIsDebitCredit")));
		OPBL.selectByVisibleText("Cr");
	}
	public void bankdetails(){
		driver.findElement(By.xpath("//input[@id='txtAccountNo']")).sendKeys("766388846617");
		driver.findElement(By.xpath("//input[@id='txtRTGSNo']")).sendKeys("766388846617~!@#$%^bkhckbxckjkvb");
		driver.findElement(By.xpath("//input[@id='txtIFSCCode']")).sendKeys("766388846617~!@#$%^jhfdfhkjuglhqwertyu");
		driver.findElement(By.xpath("//input[@id='txtMicrNo']")).sendKeys("766388846617qwertyui~~~~~");
		driver.findElement(By.xpath("//input[@id='txtPhoneNo']")).sendKeys("766388846617qwertyui~~~~~");
	}
	public void F10(){
		driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	}
public static void main(String[] args) throws InterruptedException {
	Ledger_BankAccounts_New lbn = new Ledger_BankAccounts_New();
	lbn.webLaunch();
	lbn.login();
	lbn.serchCompany();
	lbn.Master();
	lbn.newleder();
	lbn.ctrlrm();
	lbn.newname();
	lbn.Accountgroup();
	//lbn.station();
	lbn.mailtoB();
	lbn.addressled();
	lbn.country1();
	lbn.state1();
	lbn.city1();
	lbn.openbal();
	lbn.bankdetails();
	lbn.F10();
}
}
