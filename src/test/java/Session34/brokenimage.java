package Session34;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.*;
import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class brokenimage {
	
	WebDriver driver ;
	
	@Before
	public void setup()
	{
		System.setProperty("WebDriver.Chrome.Driver","C:\\Users\\User\\eclipse-workspace\\classpractic\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		driver = new ChromeDriver();
		opt.setBinary("C:\\Users\\User\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	
	}
	@After
	public void end() throws InterruptedException
	{
		
		driver.quit();
	}
	
	@Test
	 public void imagebroke()
	 {
		List<WebElement> listofimgtag =  driver.findElements(By.tagName("a"));
		
		System.out.println("Total no of tag with img on webpage -> " + listofimgtag.size());
		
		for (int i = 0; i < listofimgtag.size(); i++)
		{
			String sourselink = listofimgtag.get(i).getAttribute("href");
			try {
				
				URL url= new URL(sourselink);
				
				URLConnection urlconnection= url.openConnection();
				
				HttpURLConnection httpconnection = (HttpURLConnection)urlconnection;
				
				httpconnection.setConnectTimeout(4000);
				
				httpconnection.connect();
				
				
				if (httpconnection.getResponseCode() == 200) {
					System.out.println("The Source Link " + sourselink + " -> is " + httpconnection.getResponseCode());
				}
				else {
					System.err.println("The Source Link " + sourselink + " -> is " + httpconnection.getResponseCode());
				}
				// disconnecting the connection with URL
				httpconnection.disconnect();
			} 
			catch (Exception e) 
			{
				System.out.println("Some issue with image source link ->" + sourselink );
				e.printStackTrace();
			}				
		}

	}
}
	