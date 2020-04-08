package Rough;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class createItem extends itemTestng {
	@Test(priority =21)
	public void itemcode(){
		driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']")).click();
		if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[1]")).isSelected()){
			driver.findElement(By.xpath("//select[@id='typeofSupply']")).click();
		}
		else if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[2]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='txtItemCode']")).sendKeys("23456");
		}
		else if (driver.findElement(By.xpath("//*[@id='txtItemCodeRequired']/option[3]")).isSelected()){
			driver.findElement(By.xpath("//input[@id='txtItemCode']")).sendKeys("23456");
		}
		
	}

}
