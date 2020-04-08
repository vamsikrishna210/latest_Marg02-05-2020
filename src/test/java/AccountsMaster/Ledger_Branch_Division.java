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

public class Ledger_Branch_Division {
	WebDriver driver;
	WebDriverWait Wait;
	
    public void webLaunch() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	driver.get("http://172.16.8.17/margwebsite");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	Wait= new WebDriverWait(driver,20);
	}
	public void login() {
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("vamsikrishna");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();

	}
	public void serchCompany() throws InterruptedException {
		WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
		textbox.clear();
		textbox.sendKeys("JAGGI PHARMA DISTUBUTORS");
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
	    
	    driver.findElement(By.xpath("//h2[@class='headingItem']//button[@type='button']")).click();
		
	}
	public void altercode(){
		driver.findElement(By.id("txtalternatecode")).sendKeys("~!#%^vamsi123");
		
	}
	public void ledgername(){
		driver.findElement(By.id("txtlegername")).sendKeys("vamsikrishna7569");
	}
	
	public void accountGroup() throws InterruptedException
	{
	     WebElement accgp = driver.findElement(By.xpath("//input[@id='ddlAccountGroupLinkID']"));
	     accgp.clear();
	     accgp.sendKeys("Branch");
	     Thread.sleep(2000);
	     List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
	     int count = allOptions.size();
	     for(int i=0;i<count;i++)
	     {
	    	 String text = allOptions.get(i).getText();
	    	System.out.println(text);
	    	
	     }
	     accgp.sendKeys(Keys.ARROW_DOWN);
	     accgp.sendKeys(Keys.ENTER);
	      }
	
	public void balance_mtd()
	{
		/*WebElement opening=driver.findElement(By.xpath("//select[@id='ddlBalancingMethod']"));
		opening.sendKeys(Keys.SPACE);
		List<WebElement> allOptions = driver.findElements(By.xpath(""))
		int count=allOptions.size();
		for(int i=0;i<count;i++)
	     {
	    	 String text = allOptions.get(i).getText();
	    	System.out.println(text*/
	    	Select opbl = new Select(driver.findElement(By.xpath("//select[@id='ddlBalancingMethod']")));
	    	opbl.selectByIndex(2);
	  WebElement open = driver.findElement(By.xpath("//input[@id='txtOpeningBalance']"));
	  open.sendKeys("57540000");
	  open.sendKeys(Keys.ENTER);
	  open.sendKeys(Keys.ENTER);
	  
	  WebElement credit = driver.findElement(By.xpath("//input[@id='txtCreditDays']"));
	  credit.clear();
	  credit.sendKeys("3456");
	  credit.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
	}
	public static void main(String[] args) throws InterruptedException {
		Ledger_Branch_Division lbd = new Ledger_Branch_Division();
		lbd.webLaunch();
		lbd.login();
		lbd.serchCompany();
		lbd.Master();
		lbd.newleder();
		lbd.ctrlrm();
		lbd.altercode();
		lbd.ledgername();
		lbd.accountGroup();
		lbd.balance_mtd();
		
	}
}
