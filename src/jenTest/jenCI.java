package jenTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class jenCI {

	public static WebDriver dr; 
	@Test
  public void function() {
	  
	  String URL= dr.getCurrentUrl();
	  System.out.println(URL);
  }
  @BeforeTest
  public void beforeTest() {
	  dr= new FirefoxDriver();
	  dr.navigate().to("http://beta.angelplastics.co.uk/");
  }

  @AfterTest
  public void afterTest() {
	  dr.quit();
  }

}
