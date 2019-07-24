package session3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.toolsqa.com/automation-practice-form/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Thread.sleep(2000);
		driver.findElement(By.linkText("Partial Link Test"));
		Thread.sleep(2000);
		driver.findElement(By.linkText("Link Test"));
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Rohan");
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("Sharma");
		Thread.sleep(2000);
		driver.findElement(By.id("sex-0")).click();;
		Thread.sleep(2000);
		driver.findElement(By.id("sex-1"));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#exp-0")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#exp-1")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#exp-2")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#exp-3")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#exp-4")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#exp-5")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#exp-6")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("08/08/18");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"profession-0\"]")).click();;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"profession-1\"]")).click();;
		Thread.sleep(2000);
		driver.findElement(By.className("input-xlarge"));
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
