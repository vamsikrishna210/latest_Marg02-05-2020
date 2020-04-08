package AccountsMaster;

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

public class Ledger_BANK_OCC {
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
		WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
		textbox.clear();
		textbox.sendKeys("vamsikrishna");
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
		driver.findElement(By.xpath("//span[@class='box'][contains(text(),'New')]")).click();
	}
	public void ctrlrm () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.className("addEffset")).click();
		Thread.sleep(2000);
		Select Codereq = new Select(driver.findElement(By.id("code")));
	    Codereq.selectByVisibleText("Yes");
	    Thread.sleep(2000);
	    
	    Select dupl = new Select(driver.findElement(By.xpath("//*[@id='name']")));
	    dupl.selectByVisibleText("Yes");
	    
	    Select stnr = new Select(driver.findElement(By.xpath("//select[@id='sta']")));
	    stnr.selectByVisibleText("Yes");
	    
	    driver.findElement(By.xpath("/html/body/margerpapp-root/master-layout/div/div[2]/control-room/div/div/h2/button")).click();
		
	}
	public void altercode(){
		driver.findElement(By.id("txtalternatecode")).sendKeys("~!#%^vamsi34547");
		
	}
	public void ledgername(){
		driver.findElement(By.id("txtlegername")).sendKeys("vamsikrishna7569");
	}
	public void Accountgroup() throws InterruptedException{
		WebElement Accgrp = driver.findElement(By.xpath("//*[@id='ddlAccountGroupLinkID']"));
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
		Accgrp.sendKeys(Keys.ARROW_DOWN);
		Accgrp.sendKeys(Keys.ENTER);
	}
	public void oppenbal(){
		WebElement opbl = driver.findElement(By.xpath("//input[@placeholder='0.00']"));
		opbl.sendKeys("300~~~!!!!000000");
		opbl.sendKeys(Keys.ENTER);
		
		Select mode = new Select(driver.findElement(By.xpath("//select[@id='ddlIsDebitCredit']")));
		mode.selectByVisibleText("Cr");
		
		driver.findElement(By.xpath("//input[@id='txtCreditDays']")).sendKeys("5!~!~!~!609");
	}
	public void saveL(){
		WebElement savL = driver.findElement(By.xpath("//button[@id='btn-Save']"));
		savL.sendKeys(Keys.ENTER);
	}
	public static void main(String[] args) throws Exception {
		Ledger_BANK_OCC LBO = new Ledger_BANK_OCC();
		LBO.webLaunch();
		LBO.login();
		LBO.serchCompany();
		LBO.Master();
		LBO.newleder();
		LBO.ctrlrm();
		LBO.altercode();
		LBO.ledgername();
		LBO.Accountgroup();
		LBO.oppenbal();
		LBO.saveL();
	}
}
