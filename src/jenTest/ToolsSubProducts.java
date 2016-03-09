package jenTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToolsSubProducts{
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
	
	public static void ScreenCapture() throws IOException{
		File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		String filename="Screenshot"+System.currentTimeMillis();
		FileUtils.copyFile(scrFile, new File("c:\\sel_screen\\"+filename+".png"));
	}
	
	@Test(enabled=true,priority=1)
	  public void ToolsProductPage() throws IOException, InterruptedException, AWTException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("ToolsProductPage"));
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String finalcatproname=productname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
			  System.out.println("***********************************************************************************************");
			  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=2; n<=Subtotal; n++){
				  
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("Finalproduct_Quantity_part2");
				  String str7=prop.getProperty("Finalproductname");
				  String str8=prop.getProperty("Price");
				  String str10=prop.getProperty("Cart");
				  String str11=prop.getProperty("ok");
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  TimeUnit.SECONDS.sleep(2);
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-2500);");
				  WebElement ProductName=dr.findElement(By.xpath(str5+n+str7));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Added product name is:"+Proname);
				  WebElement ProductPrice=dr.findElement(By.xpath(str5+n+str8));
				  String Price=ProductPrice.getText();
				  System.out.println("The Added product price is:"+Price);
				  ScreenCapture();
				  Actions act = new Actions(dr);
				  act.moveToElement(dr.findElement(By.xpath(str5+n+str10))).doubleClick().perform();
//				  dr.switchTo().frame(0);
//				  Robot object = new Robot();
//					object.delay(2000);
//					object.keyPress(KeyEvent.VK_TAB);
//					object.keyRelease(KeyEvent.VK_TAB);
//					object.keyPress(KeyEvent.VK_TAB);
//					object.keyRelease(KeyEvent.VK_TAB);
//					object.keyPress(KeyEvent.VK_ENTER);
//					object.keyRelease(KeyEvent.VK_ENTER);
				  dr.findElement(By.id(str11)).click();
		 }
		  dr.navigate().to(prop.getProperty("ToolsProductPage"));
	}
} 
	
}