import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;

public class NewTest {
	WebDriver driver;
	WebDriverWait wait;
	public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
	public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
  @Test
  public void flipkart() throws InterruptedException {
	  WebElement ele = driver.findElement(By.xpath("//span[text()='Login'][1]"));
	  wait.until(ExpectedConditions.visibilityOf(ele));
	  if(ele.isDisplayed()) {
		  driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	  }
	  
	  driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("Samsung Galaxy S10");
	  driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  waitForElementvisible(driver.findElement(By.xpath("//a[@title='Mobiles']")));
	  driver.findElement(By.xpath("//a[@title='Mobiles']")).click();
	 // driver.findElement(By.xpath("//div[text()='SAMSUNG']/preceding::div[1]")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebElement ele2 =  driver.findElement(By.xpath("//input[@class='_30VH1S']"));
	  //waitForElementclickable(ele2);
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele2);
	  //WebElement ele3 =  driver.findElement(By.xpath("//div[text()='SAMSUNG']/preceding::div[1]"));
	  //((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele3);
	 WebElement ele3 = driver.findElement(By.xpath("//div[text()='SAMSUNG']"));
	 //WebElement ele4= driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele3);
	 //driver.findElement(By.xpath("//div[@class='_24_Dny _3tCU7L']")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
	  Thread.sleep(5000);
	  List<WebElement> element = driver.findElements(By.xpath("//div[contains(text(), 'SAMSUNG ')]"));
	  List<WebElement> pelement = driver.findElements(By.xpath("//div[contains(text(), 'SAMSUNG ')]/parent::div/following-sibling::div[1]/div[1]/div[1]/div[1]"));
	  List<WebElement> linkelement = driver.findElements(By.xpath("//div[contains(text(), 'SAMSUNG ')]/parent::div[1]/parent::div[1]/parent::a"));
	  int count=0;
	  for(WebElement CurrentElement : element) {
		  count = count+1;
		  System.out.println("Element "+count+" : ");
		  System.out.println("Name:- "+CurrentElement.getText());
		  System.out.println("Price:- "+pelement.get(count-1).getText());
		  System.out.println("link:- "+linkelement.get(count-1).getAttribute("href"));
		  System.out.println("**********************************");
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  //System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }

  @BeforeTest
  //@Parameters("browser")
  public void setup() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("os", "Windows");
	  caps.setCapability("os_version", "10");
	  caps.setCapability("browser", "Chrome");
	  caps.setCapability("browser_version", "latest");
	  caps.setCapability("browserstack.local", "false");
	  caps.setCapability("browserstack.debug", "true");
	  caps.setCapability("browserstack.networkLogs", "true");
	  caps.setCapability("browserstack.selenium_version", "3.141.59");
	  driver = new RemoteWebDriver(new URL(URL), caps);
	  /*if(browser.equalsIgnoreCase("chrome")){
		  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("chrome")){
		  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
		  driver = new ChromeDriver();
	  }*/
  }

  @AfterSuite
  public void afterSuite() {
  }
  public void waitForElementvisible(WebElement ele) {
	  try {
		wait.until(ExpectedConditions.visibilityOf(ele));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public void waitForElementclickable(WebElement ele) {
	  try {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
  }
}
