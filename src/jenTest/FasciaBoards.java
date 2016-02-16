package jenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FasciaBoards {
	public static WebDriver dr= new FirefoxDriver();
	@BeforeTest
	  public void LoginTest() {
		  	dr.get("http://dev.angelplastics.co.uk/");
			dr.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			dr.manage().window().maximize();
			String winhandle =dr.getWindowHandle();
			dr.findElement(By.xpath("html/body/div[1]/header/section[1]/div/div/div[1]/ul/li[1]/a")).click();
			for(String win: dr.getWindowHandles()){
				dr.switchTo().window(win);
				dr.findElement(By.id("login_username")).sendKeys("kelvin");
				dr.findElement(By.id("login_password")).sendKeys("123asd!@#");
				dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/ul/li[4]/input")).click();
			}
			dr.switchTo().window(winhandle);
		  
	  }
  @Test
  public void FasciaBoardsProduct() throws IOException {

	  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
	  FileInputStream input = new FileInputStream(file);
	  Properties prop = new Properties();
	  prop.load(input);
	  dr.findElement(By.xpath(prop.getProperty("MainProduct"))).click();
	  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
	  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
	  int n=list.size();
	  for(int i=1;i<=n;i++){
		  String str1=prop.getProperty("subproduct_part1");
		  String str2=prop.getProperty("subproduct_part2");
		  dr.findElement(By.xpath(str1+i+str2)).click();
		  WebElement SubSubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> lists=SubSubProduct.findElements(By.tagName("div"));
		  int n1=lists.size();
		  for(int j=1;i<=n1;i++){
			  String str3=prop.getProperty("subproduct_part1");
			  String str4=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str3+j+str4)).click();
			  WebElement FinalProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> products=FinalProduct.findElements(By.tagName("div"));
			  int total=products.size();
			  for(int k=1; k<=total; k++){
				  String str5=prop.getProperty("Finalproduct_Quantity_part1");
				  String str6=prop.getProperty("Finalproduct_Quantity_part2");
				  String str7=prop.getProperty("Finalproduct_Addtocart");
				  dr.findElement(By.xpath(str5+k+str6)).click();
				  dr.findElement(By.xpath(str5+k+str7)).click();
				  dr.findElement(By.xpath(prop.getProperty("Continue_shopping"))).click();
				  
		  }
		  }
	  }
	  
  }
  
}