package session3;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetaupChrome {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 ChromeOptions options = new ChromeOptions();

	        Map<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("credentials_enable_service", false);
	        prefs.put("password_manager_enabled", false); 
	        options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://www.meditab.com");
		Thread.sleep(2000);
	}

}
