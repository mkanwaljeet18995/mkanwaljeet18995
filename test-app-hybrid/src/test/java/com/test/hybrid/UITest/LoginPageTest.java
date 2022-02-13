package com.test.hybrid.UITest;

import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;
import org.testng.internal.ConstructorOrMethod;
import org.testng.internal.annotations.IAnnotationFinder;

import com.test.hybrid.Base.BaseTestClass;
import com.test.hybrid.Common.ConfigClass;
import com.test.hybrid.SaucePageObjects.LoginPage;
import com.test.hybrid.Utils.LoggerUtil;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.ITestObjectFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginPageTest extends BaseTestClass{
	LoginPage login;
	ConfigClass config;
	LoggerUtil l;
	public LoginPageTest() {
		super();
	}
@Test(priority=1)
  public void f1() {
	LoggerUtil.logger.info("Opening Application");
	String aTitle = login.GetTitle();
	Assert.assertEquals("Swag Labs", aTitle);
  }

@Test(priority=2)
public void f2() {
	LoggerUtil.logger.info("Logging into application");
	login.Login(config.USERNAME, config.PASSWORD);
}

  @BeforeMethod
  public void beforeMethod() {
	  Initialize(); 
	  login=new LoginPage();
	  config= new ConfigClass();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
@Override
public ITestNGMethod clone() {
	// TODO Auto-generated method stub
	return null;
}

}
