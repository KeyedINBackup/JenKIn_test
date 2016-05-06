package jenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login {
	public static WebDriver dr;
  @Test
  public void LoginTest() {
	  	dr = new FirefoxDriver();
		dr.get("http://dev.angelplastics.co.uk/");
		dr.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		dr.manage().window().maximize();
		String winhandle =dr.getWindowHandle();
		dr.findElement(By.xpath("html/body/div[1]/header/section[1]/div/div/div[1]/ul/li[1]/a")).click();
		for(String win: dr.getWindowHandles()){
			dr.switchTo().window(win);
			dr.findElement(By.id("login_username")).sendKeys("kelvin");
			dr.findElement(By.id("login_password")).sendKeys("123test456");
			dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/ul/li[4]/input")).click();
		}
		dr.switchTo().window(winhandle);
	  
  }
  
}
