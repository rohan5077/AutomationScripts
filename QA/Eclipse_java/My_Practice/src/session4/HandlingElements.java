package session4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingElements {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.phptravels.net/hotels");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]/input")).sendKeys("delhi");
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div[1]/input")).sendKeys("09/08/2018");
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div[1]/input")).sendKeys("10/08/2018");
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("//*[@id=\"travellersInput\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"travellersInput\"]")).sendKeys("1 Adult 0 Child");
//		driver.findElement(By.xpath("//*[@id=\"childPlusBtn\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[5]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[5]/button")).click();
	}
}