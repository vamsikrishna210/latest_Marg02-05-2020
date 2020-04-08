package AccountsMaster;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ledger_Master_FieldStaff {
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
	    Codereq.selectByVisibleText("No");
	    Thread.sleep(2000);
	    
	    Select dupl = new Select(driver.findElement(By.xpath("//*[@id='name']")));
	    dupl.selectByVisibleText("Yes");
	    
	    Select stnr = new Select(driver.findElement(By.xpath("//select[@id='sta']")));
	    stnr.selectByVisibleText("No");
	    
	    driver.findElement(By.xpath("/html/body/margerpapp-root/master-layout/div/div[2]/control-room/div/div/h2/button")).click();
		

	}
	public void newname() throws InterruptedException{
		driver.findElement(By.id("txtlegername")).sendKeys("vamsikrishnaKGF123");
		
		WebElement textbox1 = driver.findElement(By.xpath("//*[@id='ddlAccountGroupLinkID']"));
		textbox1.clear();
		//textbox1.sendKeys(Keys.SPACE);
		textbox1.sendKeys("SUNDRY D");
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
	    textbox1.sendKeys(Keys.ARROW_DOWN);
	    textbox1.sendKeys(Keys.ARROW_DOWN);
	    textbox1.sendKeys(Keys.ARROW_DOWN);
	    textbox1.sendKeys(Keys.ARROW_DOWN);
		textbox1.sendKeys(Keys.ENTER);
}
	public void Mailto() throws InterruptedException{
		WebElement milto = driver.findElement(By.xpath("//input[@id='txtMailTo']"));
		milto.clear();
		Thread.sleep(2000);
		//textbox1.sendKeys(Keys.SPACE);
		milto.sendKeys("vamsikrish3454");
	}
	public void addressled() throws InterruptedException{
		WebElement Address1 = driver.findElement(By.xpath("//input[@id='txtaddress1']"));
		Address1.sendKeys("gkjghjgk~~!!@@@~!@#$%^&*QWERTYUqwertyu989844894748848144849845198498449865484498498fsdfsdfdfsdfsdffsdfsfsdfsdfsdffsdffsdffsdfdfsdfdfsdfsdfsdfsdfsfsdfffsdfsdfsfsdfsdfsdfsdfsdfsdfsdfsfd"); 
		Thread.sleep(3000);
		
	}
	public void country() throws InterruptedException{
		WebElement cntry = driver.findElement(By.xpath("//*[@id='ddlCountryLinkID']"));
		cntry.clear();
		cntry.sendKeys("Vamsi");
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
		cntry.sendKeys(Keys.ARROW_DOWN);
		cntry.sendKeys(Keys.ARROW_DOWN);
		cntry.sendKeys(Keys.ENTER);	

	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	public void state() throws InterruptedException{
		WebElement stat = driver.findElement(By.id("ddlStateLinkID"));
		stat.clear();
		stat.sendKeys("Andhra");
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
		stat.sendKeys(Keys.ARROW_DOWN);
		stat.sendKeys(Keys.ENTER);
	}
	public void city(){
		driver.findElement(By.xpath("//*[@id='ddlCity']")).sendKeys("Rajahmundry");
		driver.findElement(By.xpath("//input[@id='txtPostalCode']")).sendKeys("Rajahmundry533101");	
	}
	public void contact() throws InterruptedException{
		driver.findElement(By.xpath("//input[@id='txtPhoneNo']")).sendKeys("jfdbshabdff9876543210");
		driver.findElement(By.xpath("//input[@id='txtMobile']")).sendKeys("jfdbshabdff9876543210");
		driver.findElement(By.xpath("//input[@id='txtMobile2']")).sendKeys("jfdbshabdff9876543210");
		 driver.findElement(By.xpath("//button[@id='btnMoreMobile']")).click();
		  Thread.sleep(1000);
		  
		  driver.findElement(By.id("txtMobile1")).sendKeys("1234567890");
		  driver.findElement(By.id("txtMobile2")).sendKeys("1234567890");
		  driver.findElement(By.id("txtMobile3")).sendKeys("1234567890");
		  driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		
	}
	public void email(){
		driver.findElement(By.xpath("//input[@id='txtEmail1']")).sendKeys("vamsi1322@123.com");
	}
	public void save(){
		driver.findElement(By.xpath("//button[@id='btn-Save']")).click();
		//driver.findElement(By.xpath(" //button[@id='btn-Clear']")).click();
	}
	public static void main(String[] args) throws InterruptedException {
		Ledger_Master_FieldStaff lmf = new Ledger_Master_FieldStaff();
		lmf.webLaunch();
		lmf.login();
		lmf.serchCompany();
		lmf.Master();
		lmf.newleder();
		lmf.ctrlrm();
		lmf.newname();
		lmf.Mailto();
		lmf.addressled();
		lmf.country();
		lmf.state();
		lmf.city();
		lmf.contact();
		lmf.email();
		lmf.save();
		
	}}
