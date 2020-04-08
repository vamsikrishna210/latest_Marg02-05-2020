package Account_Group;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account_Group_New {
	WebDriver driver;
	WebDriverWait Wait;
	 public void webLaunch() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsikrishna\\Desktop\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.get("http://172.16.8.17/margwebsite/qa");
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    	Wait= new WebDriverWait(driver,20);
		}
	 public void login() {
		    driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("admin");
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	 public void action() throws InterruptedException{
		 WebElement textbox = driver.findElement(By.xpath("//*[@id='searchItems']"));
			textbox.clear();
			textbox.sendKeys("");
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
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			WebElement menu = driver.findElement(By.linkText("Master"));
			action.moveToElement(menu).perform();
			menu.sendKeys(Keys.ENTER);
			
			WebElement submenu1 = driver.findElement(By.linkText("Account Group"));
			action.moveToElement(submenu1).perform();
			submenu1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Group Master")).click();
	 }
	 public void search() {
		 WebElement searchBox = driver.findElement(By.name("SearchBox"));
		 searchBox.sendKeys("Sundry Debtors");
		 List<WebElement> allOpt1= driver.findElements(By.xpath("//div[@class='ag-body ag-layout-normal ag-row-no-animation']"));
		 int cnt= allOpt1.size();
		 System.out.println("List Of Account Group"+ cnt);
		 System.out.println("List Of Account Group");
		 for(int i=0; i< cnt;i++){
			 String grp=allOpt1.get(i).getText();
			 System.out.println(grp);
		 }
		 searchBox.sendKeys(Keys.ARROW_DOWN);
	}
	 public void createGroup() {
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@id='btn-New']")).click();
	WebElement textGrName=driver.findElement(By.xpath("//input[@id='txtGroupName']"));
	textGrName.sendKeys("group B~!@@*^");
	textGrName.sendKeys(Keys.ENTER);
	textGrName.sendKeys(Keys.ENTER);
	textGrName.sendKeys(Keys.ENTER);
	//WebElement drPbt=driver.findElement(By.xpath("//select[@id='drpProhibited']"));
	//drPbt.sendKeys(Keys.SPACE);
	//drPbt.sendKeys(Keys.ARROW_DOWN);
	}

	 public void clearGrData() {
		 driver.findElement(By.id("btn-Clear")).click();
		 driver.findElement(By.id("alertForm")).click();;
	}
	 public void saveGr() {
		driver.findElement(By.id("btn-Save")).click();
	}
	 public static void main(String[] args) throws Exception {
		 Account_Group_New agn = new Account_Group_New();
		 agn.webLaunch();
		 agn.login();
		 agn.action();
		 agn.search();
		 agn.createGroup();
	//	 agn.clearGrData();
		 agn.saveGr();
	}
}
