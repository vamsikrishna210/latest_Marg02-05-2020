package OtherMaster;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MRmaster {
	WebDriver driver;
	WebDriver Wait;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://172.16.8.17/margwebsite");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("vamsikrishna");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
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
		
		WebElement submenu1 = driver.findElement(By.linkText("Other Master"));
		action.moveToElement(submenu1).perform();
		submenu1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("MR/Salesman")).click();
		driver.findElement(By.id("btn-New")).click();
		driver.findElement(By.id("txtName")).sendKeys("ch.satish1");
		driver.findElement(By.xpath("//*[@id='txtEmail']")).sendKeys("satish.ch123@gmail.com");
		driver.findElement(By.id("txtaddress1")).sendKeys("gdsfjklgnjvnb,sdgfkjn~~~jkgnkvnbjb,kfjnxznv");
		driver.findElement(By.xpath("//*[@id='txtMobile']")).sendKeys("9876543210");
		//driver.findElement(By.id("txtPhone")).sendKeys("32131~!@#$#%$#@3212");
		Select options1 = new Select(driver.findElement(By.id("drpRoute")));
		options1.selectByVisibleText("Rajahmundry");
		
		Select options2 = new Select(driver.findElement(By.id("drpArea")));
		options2.selectByVisibleText("123Road");
		
		driver.findElement(By.id("btn-Save")).click();
		

}}
