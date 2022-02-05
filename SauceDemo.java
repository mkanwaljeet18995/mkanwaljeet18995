package com.Kanwaljeet.Admin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class SauceDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Assert.assertEquals("Swag Labs", driver.getTitle());
		driver.findElement(By.id("user-name")).sendKeys("standard_user", Keys.RETURN);
		driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.RETURN);
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("PRODUCTS", driver.findElement(By.className("title")).getText());
		List<WebElement> element = driver.findElements(By.xpath("//*[contains(text(),'$')]"));
		Float[] arrPrice = new Float[element.size()];
		String str = null;
		for(int i=0; i<element.size();i++) {
			str = element.get(i).getText();
			arrPrice[i] = Float.parseFloat(str.substring(1, str.length()));		
			System.out.println(arrPrice[i]);
		}
		Arrays.sort(arrPrice);
		System.out.println("The highest Price is:- "+arrPrice[arrPrice.length-1]);
		String finalXpath= "//*[contains(text()[2],'"+arrPrice[arrPrice.length-1]+"')]/following::button[text()='Add to cart'][1]";
		driver.findElement(By.xpath(finalXpath)).click();
		List<WebElement> element2 = driver.findElements(By.xpath("//*[contains(text(),'Remove')]"));
		Assert.assertEquals(element2.size(), 1);
		String Expected = driver.findElement(By.xpath("//*[contains(text(),'Remove')]/preceding::div[@class='inventory_item_name'][1]")).getText();
		driver.findElement(By.className("shopping_cart_link")).click();
		String Actual = driver.findElement(By.className("inventory_item_name")).getText();
		Assert.assertEquals(Actual, Expected);
		driver.close();
	}


}
