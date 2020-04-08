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


public class Agency_Master_Modify_new {
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
			driver.findElement(By.linkText("Agency Master")).click();
	 }
	 public void Serchbox() throws InterruptedException{
		 WebElement serchbox = driver.findElement(By.name("SearchBox"));
		    serchbox.clear();
		    serchbox.sendKeys("VAMMSSIKgf567");
			Thread.sleep(2000);
			List<WebElement> allOptions1= driver.findElements(By.xpath("//*[@class='ag-body-viewport ag-layout-normal']"));
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
      public void controlroom1(){
    	  driver.findElement(By.className("addEffset")).click();
    	  WebElement agencyname = driver.findElement(By.xpath("//div[@class='form-inline float-right']//input[@type='text']"));
    	  agencyname.clear();
    	  agencyname.sendKeys("kgfagency8921869512498198");
    	  driver.findElement(By.xpath(" //span[contains(text(),'×')]")).click();
      }
      public void agName(){
    	  WebElement rename = driver.findElement(By.id("txtCName"));
    	  rename.clear();
    	  rename.sendKeys("vamsi34545");
      }
      public void maingrop() throws InterruptedException{
    	  Select Stan = new Select(driver.findElement(By.id("drpMainGroup")));
  		Stan.selectByVisibleText("No");
  		
      }
      public void undercompany(){
    	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	  List<WebElement> allOptionscmpy= driver.findElements(By.xpath("//select[@id='drpUnderCompany']"));
			int countcmp=allOptionscmpy.size();
			System.out.println("No.of Autosuggesion "+countcmp);
			System.out.println("List of Autosuggesion");
			for(int i=0;i<countcmp;i++){
				String textcmp = allOptionscmpy.get(i).getText();
				System.out.println(textcmp);
			}
			Select UCMP = new Select(driver.findElement(By.xpath("//select[@id='drpUnderCompany']")));
			UCMP.selectByVisibleText("NEW COMPANY");
      }
      
      public void remark(){
    	  driver.findElement(By.id("txtRemark")).sendKeys("~!@#$%^&*()_~!@#$%^&*()_|}{:>< <>L<WZAEXSRCDVFTMNJI987812146132165111231~!@#$%^&*()|{}|:<><>~!@#$%^&*()~!@#$%^&*()__)(*&^%#EWXSRGT");
      }
      public void conted(){
    	  Select countinue = new Select(driver.findElement(By.id("drpContinued")));
			countinue.selectByVisibleText("Yes");
      }
      public void reodstr(){
    	  driver.findElement(By.id("txtReorderPref")).sendKeys("96863");	
			driver.findElement(By.xpath("//*[@id='txtStoreNo']")).sendKeys("96863");
      }
      public void prohii(){
    	  Select prohibited = new Select(driver.findElement(By.id("drpProhibit")));
			prohibited.selectByVisibleText("No");
      }
      public void ROF(){
    	  WebElement EP = driver.findElement(By.id("txtExpireReceiveUpto"));
    	  EP.clear();
    	  EP.sendKeys("1234666");
    	  
			WebElement rof = driver.findElement(By.id("txtReorderFormula"));
			rof.clear();
			rof.sendKeys("1236213213");
			
		WebElement mmr= driver.findElement(By.xpath("//*[@id='txtMinmargin']"));
		mmr.clear();
		mmr.sendKeys("!~!@#$%%^^96sdfsf32132133123");
			
      }
      public void addmore() throws InterruptedException{
    	  driver.findElement(By.xpath("//*[@id='btnAddMore']")).click();
			/*driver.findElement(By.id("txtEmain")).sendKeys("123456789@123.com");
			driver.findElement(By.id("txtEcc")).sendKeys("123456789001~~!@111.com");
			driver.findElement(By.id("txtEbcc")).sendKeys("123456789001~~!@123.com");
			driver.findElement(By.xpath("//*[@id='txtWebsite']")).sendKeys("123.com");*/
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();
			 Thread.sleep(2000);
      }
      public void save(){
    	  
			driver.findElement(By.xpath("//*[@id='btn-Update']/span[1]")).click();
      }
      public static void main(String[] args) throws Exception {
    	  Agency_Master_Modify_new  ammn = new Agency_Master_Modify_new ();
    	  ammn.webLaunch();
    	  ammn.login();
    	  ammn.action();
    	  ammn.Serchbox();
    	  ammn.edit();
    	  ammn.controlroom1();
    	  ammn.agName();
    	  ammn.maingrop();
    	  ammn.undercompany();
    	  ammn.remark();
    	  ammn.conted();
    	  ammn.reodstr();
    	  ammn.prohii();
    	 // ammn.ROF();
    	  ammn.addmore();
    	  ammn.save();
	}
}











