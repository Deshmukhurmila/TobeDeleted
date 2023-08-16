package prasctis;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findelement {

	WebDriver driver;
	
	
@Before
public void Startup()
{
	System.setProperty("WebDriver.Chrome.Driver", "C:\\Users\\User\\eclipse-workspace\\classpractic\\chromedriver.exe");
	ChromeOptions opt = new ChromeOptions();
	driver = new ChromeDriver();
	opt.setBinary("C:\\Users\\User\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
}

@Test
public void testingmenu()
{

	WebElement Textboxele= driver.findElement(By.xpath("//textarea[@name='q']"));
	Textboxele.sendKeys("urohi rohit deshmukh");
	
	WebElement buttonele = driver.findElement(By.name("btnK"));
	buttonele.click();
	
}


@After
public void EndProcess()
{
	driver.quit();
}







	
	
}
