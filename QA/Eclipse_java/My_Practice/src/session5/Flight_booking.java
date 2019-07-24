package session5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flight_booking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.phptravels.net/hotels");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[1]/li[3]/a")).click();
		
		driver.findElement(By.id("s2id_autogen1")).sendKeys("New York");
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.id("s2id_autogen2")).sendKeys("Delhi");
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[3]/div/input")).sendKeys("2018-08-10");
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
//		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[4]/div/input")).sendKeys("12/08/2018");
//		Thread.sleep(1000);
//		act.sendKeys(Keys.TAB).perform();
		
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[5]/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[5]/div/input")).sendKeys("2");
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[6]/button")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"bookbtn\"]")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Rohan");
		driver.findElement(By.name("lastname")).sendKeys("Sharma");
		driver.findElement(By.name("email")).sendKeys("rohans@dosepack.com");
		driver.findElement(By.name("confirmemail")).sendKeys("rohans@dosepack.com");
		driver.findElement(By.name("phone")).sendKeys("8699958019");
		driver.findElement(By.name("address")).sendKeys("Gujarat");
		driver.findElement(By.name("country")).sendKeys("India");
		
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div/div/div[1]/div/div[1]/div[2]/div[3]/button")).click();
		
//		driver.findElement(By.xpath("//*[@id=\"travellersInput\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"travellersInput\"]")).sendKeys("1 Adult 0 Child");
////		driver.findElement(By.xpath("//*[@id=\"childPlusBtn\"]")).click();
////		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[5]/button")).click();
//		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[5]/button")).click();
	}

}
