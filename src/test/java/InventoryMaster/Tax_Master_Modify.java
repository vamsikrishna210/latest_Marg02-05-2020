package InventoryMaster;

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

public class Tax_Master_Modify {
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
	 public void action() throws InterruptedException{
		 WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
			textbox.clear();
			textbox.sendKeys("JAGGI PHARMA DISTUBUTORS");
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
			
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Inventory Master"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Tax Category")).click();
	 }
	 public void search() throws InterruptedException {
		 WebElement serchbox = driver.findElement(By.xpath("//input[@placeholder='Search here..']"));
		 serchbox.clear();
		 serchbox.sendKeys("KGF@~!#%$^&***123456");
	     Thread.sleep(2000);
		
	}
	 public void suggestion1() {
		 List<WebElement> allOptions1= driver.findElements(By.xpath("//*[@class='ag-body ag-layout-normal ag-row-no-animation']"));
			int count1=allOptions1.size();
			
			System.out.println("No.of Autosuggesion "+count1);
			System.out.println("List of Autosuggesion");
			
			for(int i=0;i<count1;i++){
				String text1 = allOptions1.get(i).getText();
				System.out.println(text1);	
			}
	}
	 public void edit(){
		 driver.findElement(By.className("mksBtn")).click();
	 }
	 public void contrltax() throws InterruptedException{
		 driver.findElement(By.xpath("//button[@id='btnControlRoom']//*[@height='20']")).click();
		 WebElement box = driver.findElement(By.xpath("//input[@id='igstHeading']"));
		 box.clear();
		 box.sendKeys("KGF@~!#%$^&***123456gst");
	     Thread.sleep(2000);
	     
	     WebElement box1 = driver.findElement(By.xpath("//input[@id='cgstHeading']"));
		 box1.clear();
		 box1.sendKeys("KGF@~!#%$^&***123456cgst");
	     Thread.sleep(2000);
	     
	     WebElement box2 = driver.findElement(By.xpath("//input[@id='sgstHeading']"));
		 box2.clear();
		 box2.sendKeys("KGF@~!#%$^&***123456sgst");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//h2[@class='headingItem']//span[contains(text(),'×')]")).click();
	     
	 }
	 public void nameg(){
		 driver.findElement(By.id("name")).sendKeys("KGF@~!#%$^&***123456789");
	 }
	 public void gstn(){
		 driver.findElement(By.id("igst")).sendKeys("KGF@~!#%$^&***12345611111111");
	 }
	 public void type(){
		 List<WebElement> Taxtype= driver.findElements(By.id("zerotaxtype"));
			int count1=Taxtype.size();
			//System.out.println("No.of Autosuggesion "+count1);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<count1;i++){
				String text1 = Taxtype.get(i).getText();
				System.out.println(text1);	
			}
			Select zeroTax = new Select(driver.findElement(By.id("zerotaxtype")));
			zeroTax.selectByVisibleText("Nil Rated");
	 }
	 public void update(){
		 driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();
	 }
	 public static void main(String[] args) throws InterruptedException {
		 Tax_Master_Modify tmm  = new Tax_Master_Modify();
		 tmm.webLaunch();
		 tmm.login();
		 tmm.action();
		 tmm.search();
		 tmm.suggestion1();
		 tmm.edit();
		 tmm.contrltax();
		 tmm.nameg();
		 tmm.gstn();
		 tmm.type();
		 tmm.update();
	}
	 
	 
}
