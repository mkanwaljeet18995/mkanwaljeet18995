package com.test.hybrid.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.test.hybrid.Common.ConfigClass;

public class BaseTestClass {

	public static WebDriver driver;
	
	public static ConfigClass c = new ConfigClass();
	public BaseTestClass(){
		
	}
	public static void Initialize() {
		switch(c.BROWSER.toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", c.CHROME_DRIVER_LOCATION);
			driver = new ChromeDriver();
			break;
		case "EDGE":
			System.setProperty("webdriver.edge.driver", c.EDGE_DRIVER_LOCATION);
			driver = new EdgeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", c.IE_DRIVER_LOCATION);
			driver = new InternetExplorerDriver();
			break;
	}
		driver.get(c.URL);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
}
