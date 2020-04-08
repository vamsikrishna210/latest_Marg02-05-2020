package AccountsMaster;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Ledger_Master_Credtors {
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
		    
		    Select dup1 = new Select(driver.findElement(By.id("name")));
		    dup1.selectByVisibleText("Yes");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/margerpapp-root/master-layout/div/div[2]/control-room/div/div/h2/button")).click();
			

		}
		public void newname() throws InterruptedException{
			driver.findElement(By.id("txtlegername")).sendKeys("vamsikrishnaKGF12");
			
			WebElement textbox1 = driver.findElement(By.xpath("//*[@id='ddlAccountGroupLinkID']"));
			textbox1.clear();
			//textbox1.sendKeys(Keys.SPACE);
			textbox1.sendKeys("SUNDRY C");
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
			textbox1.sendKeys(Keys.ENTER);
			/*Select Sud = new Select(driver.findElement(By.xpath("//*[@class='dropdown-menu show']")));
			Sud.selectByVisibleText("SUNDRY DEBTORS");*/

		}
		public void morectrlrm() throws InterruptedException{
			driver.findElement(By.className("addEffset")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			Select Stan = new Select(driver.findElement(By.id("sta")));
			Stan.selectByVisibleText("No");
			Thread.sleep(2000);
			
			Select dup = new Select(driver.findElement(By.id("name")));
			dup.selectByVisibleText("No");
			
			Select MRR = new Select(driver.findElement(By.id("isMR")));
			MRR.selectByVisibleText("Yes");
			
			
			Select RoutA = new Select(driver.findElement(By.id("isrt")));
			RoutA.selectByVisibleText("No");

			driver.findElement(By.xpath("/html/body/margerpapp-root/master-layout/div/div[2]/control-room/div/div/h2/button")).click();
		}
		public void mailto(){
			WebElement mail = driver.findElement(By.id("txtMailTo"));
			mail.clear();
			mail.sendKeys("vamsikgf3454");
			
			driver.findElement(By.id("txtaddress1")).sendKeys("hsgdfbxzbc,sdghf,533101");
			driver.findElement(By.id("txtaddress2")).sendKeys("hsgdfbxzbc,sdghf,533101");
			driver.findElement(By.id("txtaddress3")).sendKeys("hsgdfbxzbc,sdghf,533101");
			
		}
		public void country() throws InterruptedException{
			WebElement textbox2 = driver.findElement(By.xpath("//*[@id='ddlCountryLinkID']"));
			textbox2.clear();
			textbox2.sendKeys("Vamsi");
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
			    textbox2.sendKeys(Keys.ARROW_DOWN);
				textbox2.sendKeys(Keys.ARROW_DOWN);
				textbox2.sendKeys(Keys.ENTER);	

		        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		public void state() throws InterruptedException{
			WebElement textbox3 = driver.findElement(By.id("ddlStateLinkID"));
			textbox3.clear();
			textbox3.sendKeys("Andhrapradesh");
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
				textbox3.sendKeys(Keys.ARROW_DOWN);
				textbox3.sendKeys(Keys.ENTER);
				
		}
		public void city(){
			 driver.findElement(By.xpath("//*[@id='ddlCity']")).sendKeys("Rajahmundry");
		}
		public void pin(){
			driver.findElement(By.id("txtPostalCode")).sendKeys("533101");
		}
		public void balance(){
			List<WebElement> allOptions4= driver.findElements(By.id("ddlBalancingMethod"));
			int count4=allOptions4.size();
			System.out.println("No.of Autosuggesion "+count4);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<count4;i++)
			{
				String text4 = allOptions4.get(i).getText();
				System.out.println(text4);	
			}
				//textbox3.sendKeys(Keys.ARROW_DOWN);
				//textbox4.sendKeys(Keys.ENTER);	
		}
		public void openbal(){
			Select Balance = new Select(driver.findElement(By.id("ddlBalancingMethod")));
			Balance.selectByVisibleText(" On Account ");
			
			WebElement OPB = driver.findElement(By.id("txtOpeningBalance"));
			OPB.clear();
			OPB.sendKeys("200000");
			OPB.sendKeys(Keys.ENTER);
			
			Select mon = new Select(driver.findElement(By.id("ddlIsDebitCredit")));
			mon.selectByVisibleText("Dr");
		}
		public void contact() throws InterruptedException{
			driver.findElement(By.id("txtPhoneNo")).sendKeys("~!@#$%^&*(~!@#$%^bnvnvbn2132212222222");
			driver.findElement(By.id("txtMobile")).sendKeys("~!@#$%^&*(~!@#$%^bnvnvbn7569383454");
			driver.findElement(By.id("txtMobile2")).sendKeys("~!@#$%^&*(~!@#$%^9874563210");
			driver.findElement(By.xpath("//*[@id='btnMoreMobile']")).click();

			driver.findElement(By.id("txtMobile1")).sendKeys("~!@#$%^&*(~!@#$%^bnvnvbn7569383454");
			driver.findElement(By.id("txtMobile2")).sendKeys("~!@#$%^&*(~!@#$%^bnvnvbn7569383454");
			driver.findElement(By.id("txtMobile3")).sendKeys("~!@#$%^&*(~!@#$%^bnvnvbn7569383454");
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);
		}
		public void Gst(){
			/*driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement GSTIN = driver.findElement(By.id("txtGSTHeading"));
			GSTIN.clear();
			GSTIN.sendKeys("GST");*/
			
			//driver.findElement(By.id("txtGSTHeading")).sendKeys("GST");
			driver.findElement(By.id("txtGSTNo")).sendKeys("37AAOCS1149R1ZI");
			WebElement dateBox = driver.findElement(By.id("txtGSTDate"));
		    dateBox.sendKeys("01042018");
		    
			//driver.findElement(By.id("txtVATHeading")).sendKeys("46165498111651sdsadsadfsaffsa");
			
			driver.findElement(By.id("txtVATNo")).sendKeys("46165498111651sdsadsadfsaffsa");
			WebElement dateBox2 = driver.findElement(By.id("txtVATExpDate"));
		    dateBox2.sendKeys("02042025");
		    
		  /*  WebElement PAN = driver.findElement(By.id("txtPANHeading"));
		    PAN.clear();
		    PAN.sendKeys("PANCARD");*/
			//driver.findElement(By.id("txtPANNo")).sendKeys("AAOCS1149R");
		}
		public void ledgertype() throws InterruptedException{
			List<WebElement> allOptions5= driver.findElements(By.id("ddlLedgerType"));
			int count5=allOptions5.size();
			System.out.println("No.of Autosuggesion "+count5);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<count5;i++)
			{
				String text5 = allOptions5.get(i).getText();
				System.out.println(text5);	
			}
			Thread.sleep(2000);	
			Select ledtype = new Select(driver.findElement(By.id("ddlLedgerType")));
			ledtype.selectByVisibleText("Composition");
			
		   /* WebElement OPT1 = driver.findElement(By.id("txtTaOptionalHeading1"));
		    OPT1.clear();
		    OPT1.sendKeys("Adhar");
			driver.findElement(By.id("txtTaOptionalNo1")).sendKeys("7663888466179999999999999");*/
			
			driver.findElement(By.xpath("//*[@id='btn-Switch Tab']/span[1]")).click();
		}
		public void licenceinf(){
			/*WebElement DLH = driver.findElement(By.id("txtDLNoHeading"));
			DLH.clear();
			DLH.sendKeys("druglo.NO");*/
		    driver.findElement(By.id("txtDLNo")).sendKeys("~!@#$%^&*(897456643113165)gnfjknbjklnxv");
		    WebElement dateBox1 = driver.findElement(By.id("txtDLExpiryDate"));
		    dateBox1.sendKeys("31012026");
		    
		   /* WebElement MFGR = driver.findElement(By.id("txtMFRNoHeading"));
		    MFGR.clear();
		    MFGR.sendKeys("MyMFGR.no");*/
		    
		    
		    driver.findElement(By.id("txtMFRNo")).sendKeys("~!@#$%^&*(7569383454)gnfjknbjklnxv");
		    WebElement dateBox3 = driver.findElement(By.id("txtMFRExpiryDate"));
		    dateBox3.sendKeys("31052026");
		    
		    driver.findElement(By.xpath("//*[@id='btn-Switch Tab']/span[1]")).click();
		    
		    /*WebElement OPT2 = driver.findElement(By.id("txtLiOptionalHeading1"));
		    OPT2.clear();
		    OPT2.sendKeys("MYNOOOO");
		    driver.findElement(By.id("txtLiOptionalNo1")).sendKeys("~!@#$%^&*(7569383454)gnfjknbjklnxv");
		    driver.findElement(By.xpath("//*[@id='btn-Switch Tab']/span[1]")).click();*/
		    
		}
		public void continfo(){
			 Select MFRTYP = new Select(driver.findElement(By.id("ddlPersonPrefix")));
			    MFRTYP.selectByVisibleText("Mr.");
			   
			    driver.findElement(By.id("txtFirstName")).sendKeys("vamsikrishna");
			    driver.findElement(By.id("txtLastName")).sendKeys("ganivada");
			    driver.findElement(By.id("txtDesignation")).sendKeys("~!@#$%^&*QA Lead ");
			    driver.findElement(By.id("txtWebsite")).sendKeys("www.vamsikgf123456.com");
			    driver.findElement(By.id("txtEmail1")).sendKeys("www.kgf@gmail.com");
			    driver.findElement(By.xpath("//*[@id='btn-Switch Tab']/span[1]")).click();
		}
		public void others() throws InterruptedException{
			  
		    driver.findElement(By.id("btnRates")).click();  
		    List<WebElement> allOptions6= driver.findElements(By.id("txtSalesRate"));
			int count6=allOptions6.size();
			System.out.println("No.of Autosuggesion "+count6);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<count6;i++)
			{
				String text6 = allOptions6.get(i).getText();
				System.out.println(text6);	
			}
			Thread.sleep(2000);	
			Select SaleRate = new Select(driver.findElement(By.id("txtSalesRate")));
			SaleRate.selectByVisibleText("M.R.P");
			
			
			List<WebElement> allOptions7= driver.findElements(By.id("ddlBrkExpRate"));
			int count7=allOptions7.size();
			System.out.println("No.of Autosuggesion "+count7);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<count7;i++)
			{
				String text7 = allOptions7.get(i).getText();
				System.out.println(text7);	
			}
			Thread.sleep(2000);	
			Select EXPRA = new Select(driver.findElement(By.id("ddlBrkExpRate")));
			EXPRA.selectByVisibleText("M.R.P");
			
			//driver.findElement(By.id("txtScrapRate")).sendKeys("23132");
			

			/*List<WebElement> allOptions8= driver.findElements(By.id("ddlRatesType"));
			int count8=allOptions8.size();
			System.out.println("No.of Autosuggesion "+count8);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<count8;i++)
			{
				String text8 = allOptions8.get(i).getText();
				System.out.println(text8);	
			}
			Thread.sleep(2000);	
			Select SCRP = new Select(driver.findElement(By.id("ddlRatesType")));
			SCRP.selectByVisibleText("F");*/
			driver.findElement(By.id("btnSave")).click(); 
		}
		public void limit() throws InterruptedException{
			driver.findElement(By.id("btnLimit")).click();
			driver.findElement(By.id("txtPrimaryLimit")).sendKeys("1234567890");
			driver.findElement(By.id("txtPrimaryLimitBills")).sendKeys("123");
			driver.findElement(By.id("txtPrimaryLimitDays")).sendKeys("1234");
			
			driver.findElement(By.id("txtCreditLimit")).sendKeys("1234567890");
			driver.findElement(By.id("txtCreditLimitBills")).sendKeys("123");
			driver.findElement(By.id("txtCreditLimitDays")).sendKeys("1234");
		    
			List<WebElement> Limitset= driver.findElements(By.id("ddlCreditLimitSet"));
			int countL=Limitset.size();
			System.out.println("No.of Autosuggesion "+countL);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countL;i++)
			{
				String textL = Limitset.get(i).getText();
				System.out.println(textL);	
			}
			Thread.sleep(2000);	
			Select LMT = new Select(driver.findElement(By.id("ddlCreditLimitSet")));
			LMT.selectByVisibleText("Auto Set");
		    
			
			List<WebElement> CLimitset= driver.findElements(By.id("ddlCreditLimitAction"));
			int countLc=CLimitset.size();
			System.out.println("No.of Autosuggesion "+countLc);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countL;i++)
			{
				String textCL = CLimitset.get(i).getText();
				System.out.println(textCL);	
			}
			Thread.sleep(2000);	
			Select CLMT = new Select(driver.findElement(By.id("ddlCreditLimitAction")));
			CLMT.selectByVisibleText("Follow Strictly");
		    
			driver.findElement(By.id("txtCreditDays")).sendKeys("12344666");
			driver.findElement(By.id("btnSave")).click();
		}
		/*public void collections() throws InterruptedException{
			driver.findElement(By.id("btnCollections")).click();
			Thread.sleep(2000);
			List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
			int countCH = allCheckbox.size();
			System.out.println("Total no of checkboxes: " +countCH);
			System.out.println("Names  no of checkboxes: " );
			 for(int i=0; i<countCH; i++)
			 {
				 WebElement chkbox = allCheckbox.get(i);
				 chkbox.click();
			 }
			
			driver.findElement(By.id("txtCollectionday1")).sendKeys("10");
			driver.findElement(By.id("txtCollectionday2")).sendKeys("15");
			driver.findElement(By.id("txtCollectionday3")).sendKeys("99");
			driver.findElement(By.id("txtCollectionday4")).sendKeys("10");
			driver.findElement(By.id("btnSave")).click();
		}*/
		public void copydealings() throws InterruptedException{
			driver.findElement(By.id("btnDealings")).click();
			List<WebElement> Copyd= driver.findElements(By.id("ddlCopyLedgerLinkID"));
			int countCD=Copyd.size();
			System.out.println("No.of Autosuggesion "+countCD);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countCD;i++)
			{
				String textCD = Copyd.get(i).getText();
				System.out.println(textCD);	
			}
			Thread.sleep(2000);	
			Select CPYD = new Select(driver.findElement(By.id("ddlCopyLedgerLinkID")));
			CPYD.selectByVisibleText("Raj Medical");
			
		    Select sure = new Select(driver.findElement(By.id("ddlcopytype")));
		    sure.selectByVisibleText("Yes");
		 
		    driver.findElement(By.id("btnSave")).click();
		    
		}
		public void transporter() throws InterruptedException{
			 driver.findElement(By.id("btnTransport")).click();
				List<WebElement> trans= driver.findElements(By.id("ddlTransportLinkID"));
				int countTr=trans.size();
				System.out.println("No.of Autosuggesion "+countTr);
				System.out.println("List of Autosuggesion");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				for(int i=0;i<countTr;i++)
				{
					String texttr = trans.get(i).getText();
					System.out.println(texttr);	
				}
				Thread.sleep(2000);	
				Select TRNS = new Select(driver.findElement(By.id("ddlTransportLinkID")));
				TRNS.selectByVisibleText("VK~Transports12");
				driver.findElement(By.id("txtDeliveredBy")).sendKeys("~!#@$@$%$krishna123456789");
				driver.findElement(By.id("btnSave")).click();
				
		}
		public void mr() throws InterruptedException{
			driver.findElement(By.id("btnMr")).click();
			List<WebElement> listMr= driver.findElements(By.id("ddlmrlinkid"));
			int countMr=listMr.size();
			System.out.println("No.of Autosuggesion "+countMr);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countMr;i++)
			{
				String textMr = listMr.get(i).getText();
				System.out.println(textMr);	
			}
			Thread.sleep(2000);	
			Select Mrl = new Select(driver.findElement(By.id("ddlmrlinkid")));
			Mrl.selectByVisibleText("Sarbjeet MR2");
			driver.findElement(By.id("btnSave")).click();
			
		}
		public void event() throws InterruptedException{
			driver.findElement(By.id("btnEvents")).click();
			WebElement dateBoxB = driver.findElement(By.id("txtBirthday"));
		    dateBoxB.sendKeys("31051987");
		    Thread.sleep(2000);
		    WebElement dateBoxA = driver.findElement(By.id("txtAnniversary"));
		    dateBoxA.sendKeys("01012019");
		     driver.findElement(By.id("btnSave")).click();
		}
		public void Geolocation(){
		     
		     driver.findElement(By.id("btnGeoLocation")).click();
		     driver.findElement(By.id("txtLatitude")).sendKeys("~!@bdsjaajfhjk28.644800");
		     driver.findElement(By.id("txtLongitude")).sendKeys("~!@bdsjaajfhjk 77.216721");
		     driver.findElement(By.id("btnSave")).click();
		    //driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-geolocation/div/button/span")).click();;
		}
		public void others2() throws InterruptedException{
			driver.findElement(By.id("btnOthers")).click();
		     
		     WebElement dateBoxfreez = driver.findElement(By.id("txtFreezeupto"));
		     dateBoxfreez.sendKeys("01022019");
		     
				/*List<WebElement> listtf= driver.findElements(By.id("ddlTransferDataon"));
				int counttf=listtf.size();
				System.out.println("No.of Autosuggesion "+counttf);
				System.out.println("List of Autosuggesion");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				for(int i=0;i<counttf;i++)
				{
					String texttf = listtf.get(i).getText();
					System.out.println(texttf);	
				}
				Thread.sleep(2000);	
				Select Tf1 = new Select(driver.findElement(By.id("ddlTransferDataon")));
				Tf1.selectByVisibleText("GST No.");*/
		}
		public void ledgercatgry() throws InterruptedException{
			List<WebElement> listLc= driver.findElements(By.id("ddlLedgerCategory"));
			int countlc=listLc.size();
			System.out.println("No.of Autosuggesion "+countlc);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countlc;i++)
			{
				String textlc = listLc.get(i).getText();
				System.out.println(textlc);	
			}
			Thread.sleep(2000);	
			Select lc = new Select(driver.findElement(By.id("ddlLedgerCategory")));
			lc.selectByVisibleText("Stockist");
			Thread.sleep(2000);
			
		}
		/*public void catgry () throws InterruptedException{
			List<WebElement> listcat= driver.findElements(By.id("ddlCategory"));
			int countcat=listcat.size();
			System.out.println("No.of Autosuggesion "+countcat);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countcat;i++)
			{
				String textcat = listcat.get(i).getText();
				System.out.println(textcat);	
			}
			Thread.sleep(2000);	
			Select lCat = new Select(driver.findElement(By.id("ddlCategory")));
			lCat.selectByVisibleText("3rd Category");
			Thread.sleep(2000);
			
		}*/
		public void party() throws InterruptedException{
			/*List<WebElement> listParty= driver.findElements(By.id("ddlPartyType"));
			int countParty=listParty.size();
			System.out.println("No.of Autosuggesion "+countParty);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countParty;i++)
			{
				String textParty = listParty.get(i).getText();
				System.out.println(textParty);	
			}
			Thread.sleep(2000);	
			Select pty = new Select(driver.findElement(By.id("ddlPartyType")));
			pty.selectByVisibleText("Local");
			Thread.sleep(2000);*/
			
			Select actv = new Select(driver.findElement(By.id("ddlStatus")));
			actv.selectByVisibleText("Active");
		}
		public void narcho() throws InterruptedException{
			List<WebElement> listNrc= driver.findElements(By.id("ddlNarcoSchHItemBilling"));
			int countNrc=listNrc.size();
			System.out.println("No.of Autosuggesion "+countNrc);
			System.out.println("List of Autosuggesion");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			for(int i=0;i<countNrc;i++)
			{
				String textNrc = listNrc.get(i).getText();
				System.out.println(textNrc);	
			}
			Thread.sleep(2000);	
			Select nrc = new Select(driver.findElement(By.id("ddlNarcoSchHItemBilling")));
			nrc.selectByVisibleText("Allow All");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@id='btnControlRoom']//*[@height='20']")).click();
			
			Select Ebb = new Select(driver.findElement(By.id("isTranDataBusiCode")));
			Ebb.selectByVisibleText("Yes");
			
			driver.findElement(By.xpath("//h2[@class='headingItem']//span[contains(text(),'×')]")).click();
			Thread.sleep(2000);
	       
			driver.findElement(By.id("txtEBusinessCode")).sendKeys("vam@~!%123456");
			
	       // driver.findElement(By.id("txtMinimumMargin")).sendKeys("987");
	        //driver.findElement(By.id("txtUploadPassword")).sendKeys("123456789");
	        driver.findElement(By.id("txtNote")).sendKeys("~!@#$%^&*())(**&^%$%^&@#$%^&#$%^ESXRDCVFGZXCTVYICTVFUYHNJFGVGVUGBBGBBGBGBBBGBGBBB35165456196545946///''\\\\5498698494");
	        
	          driver.findElement(By.xpath("//button[@id='btnControlRoom']//*[@height='20']")).click();
			
	          Select newitm = new Select(driver.findElement(By.id("ddlNewItem")));
	          newitm.selectByVisibleText("Yes");
			
			driver.findElement(By.xpath("//h2[@class='headingItem']//span[contains(text(),'×')]")).click();
	        
	       /* Select hid = new Select(driver.findElement(By.id("dllHide")));
	        hid.selectByVisibleText("No");*/
			    Select newitms = new Select(driver.findElement(By.id("ddlNewItem")));
		        newitms.selectByVisibleText("No");
	        
	        //driver.findElement(By.id("txtCreditDays")).sendKeys("300");
	        driver.findElement(By.id("txtInterest")).sendKeys("31.22");
	        driver.findElement(By.id("txtItems")).sendKeys("123456");
		}
		public void uploadpic() throws InterruptedException, AWTException{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[@id='btnEdit']")).click();
			Thread.sleep(2000);
			StringSelection stringSelection = new StringSelection("C:\\Users\\admin\\Desktop\\123.jpg"); 
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
		public void invcmtd() throws InterruptedException{
			 List<WebElement> listinvcf= driver.findElements(By.id("ddlInvoiceFormat1"));
				int countInvc=listinvcf.size();
				System.out.println("No.of Autosuggesion "+countInvc);
				System.out.println("List of Autosuggesion");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				for(int i=0;i<countInvc;i++)
				{
					String textInvc = listinvcf.get(i).getText();
					System.out.println(textInvc);	
				}
				Thread.sleep(2000);	
				Select invc = new Select(driver.findElement(By.id("ddlInvoiceFormat1")));
				invc .selectByVisibleText("Select");
				Thread.sleep(2000);
		        
				Select invcd = new Select(driver.findElement(By.id("ddlInvoiceFormat2")));
				invcd.selectByVisibleText("GUI");
				
				Select pic = new Select(driver.findElement(By.id("ddlInvoiceFormat3")));
				pic.selectByVisibleText("NT Landscape Local with Net Amount");
				
				
				
				List<WebElement> listinvcd= driver.findElements(By.id("ddlExport"));
				int countInvcd=listinvcd.size();
				//System.out.println("No.of Autosuggesion "+countInvc);
				System.out.println("List of Autosuggesion");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				for(int i=0;i<countInvcd;i++)
				{
					String textInvcd = listinvcd.get(i).getText();
					System.out.println(textInvcd);	
				}
				Select invca = new Select(driver.findElement(By.id("ddlExport")));
				invca.selectByVisibleText("Marg");
		        
		       //Select selectByVisibleText = new Select(driver.findElement(By.id("txtColor")));
		       //selectByVisibleText.selectByVisibleText("Red");
//				Select pbh = new Select(driver.findElement(By.id("ddlPBatch")));
//				pbh.selectByVisibleText("No");
	         driver.findElement(By.id("btnSave")).click();
	         driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
	       public void saveled(){
	         driver.findElement(By.id("btn-Save")).click();
	        // 
	         //driver.findElement(By.id("btn-Close")).click();
	        // driver.findElement(By.id("blueBtn")).click();
		}
		public static void main(String[] args) throws InterruptedException, AWTException {
			Ledger_Master_Credtors lm= new Ledger_Master_Credtors();
			lm.webLaunch();
			lm.login();
			lm.serchCompany();
			lm.Master();
			lm.newleder();
			lm.ctrlrm();
			lm.newname();
			lm.morectrlrm();
			lm.mailto();
			lm.country();
			lm.state();
			lm.city();
			lm.pin();
			lm.balance();
			lm.openbal();
			lm.contact();
			lm.Gst();
			lm.ledgertype();
			lm.licenceinf();
			lm.continfo();
			lm.others();
			lm.limit();
			//lm.collections();
			lm.copydealings();
			lm.transporter();
			lm.mr();
			lm.event();
			lm.Geolocation();
			lm.others2();
			lm.ledgercatgry();
			//lm.catgry();
			lm.party();
			lm.narcho();
			lm.uploadpic();
			lm.invcmtd();
			lm.saveled();
		}
		
	}


