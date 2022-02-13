package com.test.hybrid.SaucePageObjects;



import org.apache.log4j.xml.Log4jEntityResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.hybrid.Base.BaseTestClass;
import com.test.hybrid.Common.ConfigClass;
import com.test.hybrid.Utils.LoggerUtil;

public class LoginPage extends BaseTestClass{
	//PageFactory 
	ConfigClass c = new ConfigClass();
	LoggerUtil l = new LoggerUtil();
	@FindBy(id="user-name")
	WebElement UserName_EditBox;
	
	@FindBy(id="password")
	WebElement Password_EditBox;
	
	@FindBy(id="login-button")
	WebElement Login_button;
	
	//Initialise Pagefactory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String GetTitle() {
		LoggerUtil.logger.info(driver.getTitle());
		return driver.getTitle();
		
	}
	
	public void Login(String uName, String pass) {
		UserName_EditBox.sendKeys(uName);
		Password_EditBox.sendKeys(pass);
		Login_button.click();
	}
}
