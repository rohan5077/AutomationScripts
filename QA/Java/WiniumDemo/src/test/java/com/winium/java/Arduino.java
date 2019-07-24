package com.winium.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
public class Arduino {

	public static void main(String[] args) throws FindFailed, InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

			
		DesktopOptions desktop = new DesktopOptions();
		
		
		desktop.setApplicationPath("C:\\\\Program Files (x86)\\\\Arduino\\\\arduino.exe");
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), desktop);

		Actions action = new Actions(driver);
		
		Screen screen = new Screen();
		
		Pattern compile = new Pattern("E:\\Rohan\\QA\\sikuli_images\\compile.png");
		
		Thread.sleep(5000);
		screen.click(compile);
		
	}

}
