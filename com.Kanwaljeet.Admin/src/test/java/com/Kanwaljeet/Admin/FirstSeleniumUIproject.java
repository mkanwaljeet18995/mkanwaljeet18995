package com.Kanwaljeet.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class FirstSeleniumUIproject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
		
		/*InternetExplorerOptions ieOptions = new InternetExplorerOptions();
		ieOptions.attachToEdgeChrome();
        ieOptions.withEdgeExecutablePath("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
        WebDriver driver = new InternetExplorerDriver(ieOptions);*/
       // WebDriver driver = new InternetExplorerDriver();
        WebDriver driver = new EdgeDriver();
        driver.get("http://www.bing.com");
        WebElement elem = driver.findElement(By.id("sb_form_q"));
        elem.sendKeys("abc");
        elem.sendKeys("WebDriver", Keys.RETURN);
        driver.close();
	}

}