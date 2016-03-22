package jenTest;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UnderGroundDrainageProducts{
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
	  public void UnderGroundDrainageSubProduct() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("UnderGroundDrainageProductPage"));
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  dr.findElement(By.xpath(prop.getProperty("110mmUnderGroundProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subcatproname);
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
			  for(int n=1; n<=Subtotal; n++){
				  int r=n+1;
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str7=prop.getProperty("Finalproductname_part1a");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
				  String str13=prop.getProperty("popupClose_1");
				  String str14=prop.getProperty("popupClose_2");
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  WebElement ProductName=dr.findElement(By.xpath(str7+r+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Added product name is:"+Proname);
				  WebElement ProductPrice=dr.findElement(By.xpath(str7+r+str10));
				  String Price=ProductPrice.getText();
				  System.out.println("The Added product price is:"+Price);
				  ScreenCapture();
				  dr.findElement(By.xpath(str7+r+str11)).click();
				  dr.findElement(By.xpath(str7+r+str12)).click();
				  dr.findElement(By.xpath(str13+r+str14)).click();
	          }
			  dr.navigate().to(prop.getProperty("110mmUnderGroundProductPage"));
	  }
	}
	
	@Test(enabled=false,priority=2)
	  public void PolystormModularWaterStorageProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("UnderGroundDrainageProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("PolystormModularWaterStorageProducts"))).click();
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  System.out.println("***********************************************************************************************");
		  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
		  int Subtotal=FinalSubproducts.size();
		  for(int n=1; n<=Subtotal; n++){
			  int r=n+1;
			  String str5=prop.getProperty("ProductImage_Part1");
			  String str6=prop.getProperty("ProductImage_Part2");
			  String str7=prop.getProperty("Finalproductname_part1a");
			  String str8=prop.getProperty("Finalproductname_part2");
			  String str10=prop.getProperty("Finalproductprice");
			  String str11=prop.getProperty("FinalQuantity");
			  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
			  String str13=prop.getProperty("popupClose_1");
			  String str14=prop.getProperty("popupClose_2");
			  JavascriptExecutor jse=(JavascriptExecutor)dr;
			  jse.executeScript("scroll(0,-500);");
			  TimeUnit.SECONDS.sleep(2);
			  dr.findElement(By.xpath(str5+n+str6)).click();
			  WebElement ProductName=dr.findElement(By.xpath(str7+r+str8));
			  String Name=ProductName.getText();
			  String Proname=Name.replaceAll("[\r\n]+", " ");
			  System.out.println("The Added product name is:"+Proname);
			  WebElement ProductPrice=dr.findElement(By.xpath(str7+r+str10));
			  String Price=ProductPrice.getText();
			  System.out.println("The Added product price is:"+Price);
			  ScreenCapture();
			  dr.findElement(By.xpath(str7+r+str11)).click();
			  dr.findElement(By.xpath(str7+r+str12)).click();
			  dr.findElement(By.xpath(str13+r+str14)).click();
  }		  
}
	
	@Test(enabled=false,priority=3)
	  public void DrainageSundriesProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("UnderGroundDrainageProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("DrainageSundriesProducts"))).click();
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  System.out.println("***********************************************************************************************");
		  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
		  int Subtotal=FinalSubproducts.size();
		  for(int n=1; n<=Subtotal; n++){
			  int r=n+1;
			  String str5=prop.getProperty("ProductImage_Part1");
			  String str6=prop.getProperty("ProductImage_Part2");
			  String str7=prop.getProperty("Finalproductname_part1a");
			  String str8=prop.getProperty("Finalproductname_part2");
			  String str10=prop.getProperty("Finalproductprice");
			  String str11=prop.getProperty("FinalQuantity");
			  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
			  String str13=prop.getProperty("popupClose_1");
			  String str14=prop.getProperty("popupClose_2");
			  JavascriptExecutor jse=(JavascriptExecutor)dr;
			  jse.executeScript("scroll(0,-500);");
			  TimeUnit.SECONDS.sleep(2);
			  dr.findElement(By.xpath(str5+n+str6)).click();
			  WebElement ProductName=dr.findElement(By.xpath(str7+r+str8));
			  String Name=ProductName.getText();
			  String Proname=Name.replaceAll("[\r\n]+", " ");
			  System.out.println("The Added product name is:"+Proname);
			  WebElement ProductPrice=dr.findElement(By.xpath(str7+r+str10));
			  String Price=ProductPrice.getText();
			  System.out.println("The Added product price is:"+Price);
			  ScreenCapture();
			  dr.findElement(By.xpath(str7+r+str11)).click();
			  dr.findElement(By.xpath(str7+r+str12)).click();
			  dr.findElement(By.xpath(str13+r+str14)).click();
}		  
}
	
	@Test(enabled=false,priority=4)
	  public void MMUnderGroundProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("UnderGroundDrainageProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("150mmUnderGroundProducts"))).click();
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  System.out.println("***********************************************************************************************");
		  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
		  int Subtotal=FinalSubproducts.size();
		  for(int n=1; n<=Subtotal; n++){
			  int r=n+1;
			  String str5=prop.getProperty("ProductImage_Part1");
			  String str6=prop.getProperty("ProductImage_Part2");
			  String str7=prop.getProperty("Finalproductname_part1a");
			  String str8=prop.getProperty("Finalproductname_part2");
			  String str10=prop.getProperty("Finalproductprice");
			  String str11=prop.getProperty("FinalQuantity");
			  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
			  String str13=prop.getProperty("popupClose_1");
			  String str14=prop.getProperty("popupClose_2");
			  JavascriptExecutor jse=(JavascriptExecutor)dr;
			  jse.executeScript("scroll(0,-500);");
			  TimeUnit.SECONDS.sleep(2);
			  dr.findElement(By.xpath(str5+n+str6)).click();
			  WebElement ProductName=dr.findElement(By.xpath(str7+r+str8));
			  String Name=ProductName.getText();
			  String Proname=Name.replaceAll("[\r\n]+", " ");
			  System.out.println("The Added product name is:"+Proname);
			  WebElement ProductPrice=dr.findElement(By.xpath(str7+r+str10));
			  String Price=ProductPrice.getText();
			  System.out.println("The Added product price is:"+Price);
			  ScreenCapture();
			  dr.findElement(By.xpath(str7+r+str11)).click();
			  dr.findElement(By.xpath(str7+r+str12)).click();
			  dr.findElement(By.xpath(str13+r+str14)).click();
			  
}	
		  dr.navigate().to(prop.getProperty("UnderGroundDrainageProductPage"));
}	
}
	