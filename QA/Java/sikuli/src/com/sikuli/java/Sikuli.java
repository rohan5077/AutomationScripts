package com.sikuli.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli {

	public static void main(String[] args) throws FindFailed, InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

//		Screen screen = new Screen();
//		Pattern windows = new Pattern("E:\\Rohan\\QA\\sikuli_images\\windows.png");
//		Pattern arduino = new Pattern("E:\\Rohan\\QA\\sikuli_images\\arduino.png");
//		Pattern compile = new Pattern("E:\\Rohan\\QA\\sikuli_images\\compile.png");
//		
//		screen.click(windows);
//		Thread.sleep(1000);
//		screen.click(arduino);
//		Thread.sleep(4000);
//		screen.click(compile);
		
		DesktopOptions desktop = new DesktopOptions();
		
		desktop.setApplicationPath("C:\\Program Files (x86)\\Arduino\\arduino.exe");
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), desktop);
		
		Screen screen = new Screen();
		
//		Pattern windows = new Pattern("E:\\Rohan\\QA\\sikuli_images\\windows.png");
//		Pattern arduino = new Pattern("E:\\Rohan\\QA\\sikuli_images\\arduino.png");
		Pattern compile = new Pattern("E:\\Rohan\\QA\\sikuli_images\\arduinoTool.png");
		
//		screen.click(windows);
//		Thread.sleep(1000);
//		screen.click(arduino);
		Thread.sleep(4000);
		screen.click(compile);
		
	}

}
