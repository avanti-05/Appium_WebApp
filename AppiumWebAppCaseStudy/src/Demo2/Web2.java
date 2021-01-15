package Demo2;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Web2 extends capability {
	AndroidDriver<AndroidElement> driver;
	
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver=capabilities();
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void testcase1() throws MalformedURLException, InterruptedException {
		
		driver.get("http://m.cricbuzz.com");
		
		System.out.println("launched cricbuzz");
		
		//this line will click on Menu
		driver.findElement(By.linkText("Menu")).click();
    	
		System.out.println("clicked on menu");
		
	    //this line will click on Menu
		driver.findElement(By.linkText("Home")).click();
		
		System.out.println("clicked on home");
		
		Thread.sleep(3000);
		
        //Scroll down till TOP-STORIES
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Top Stories')]"));
		js.executeScript("arguments[0].scrollIntoView();",element);
		
		System.out.println("Scrolled till top stories");
		
		//applying assert on TOP STORIES
		String Actual = element.getText();
        String Expected = "Top Stories";
        Assert.assertEquals(Actual, Expected);
        
	}
}
	