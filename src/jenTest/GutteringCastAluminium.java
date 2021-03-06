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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GutteringCastAluminium{
	public static WebDriver dr= new FirefoxDriver();
	@BeforeTest
	  public void LoginTest() {
		  	dr.get("http://angelplastics.co.uk/");
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
	  public void CastAluminiumGuttersProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("GutteringMainpage"));
		  TimeUnit.SECONDS.sleep(1);
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  dr.findElement(By.xpath(prop.getProperty("CastAluminiumGuttersProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("HalfRoundCastAluminiumProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  TimeUnit.SECONDS.sleep(1);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  TimeUnit.SECONDS.sleep(1);
			  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String finalcatproname=productname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
			  System.out.println("***********************************************************************************************");
			  TimeUnit.SECONDS.sleep(1);
			  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str8=prop.getProperty("Finalproductname_part1a");
				  String str13=prop.getProperty("popupClose");
				  int r=Subtotal+1;
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Recently viewed product name is:"+Proname);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  dr.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				  //ScreenCapture();
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+r+str13)).click();
			  }
			  dr.navigate().to(prop.getProperty("HalfRoundCastAluminiumProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=2)
	  public void VictorianOgeeCastAluminiumProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("CastAluminiumGuttersProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("VictorianOgeeCastAluminiumProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  TimeUnit.SECONDS.sleep(1);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  TimeUnit.SECONDS.sleep(1);
			  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String finalcatproname=productname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
			  System.out.println("***********************************************************************************************");
			  TimeUnit.SECONDS.sleep(1);
			  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str8=prop.getProperty("Finalproductname_part1a");
				  String str13=prop.getProperty("popupClose");
				  int r=Subtotal+1;
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Recently viewed product name is:"+Proname);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  dr.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				  //ScreenCapture();
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+r+str13)).click();
			  }
			  dr.navigate().to(prop.getProperty("VictorianOgeeCastAluminiumProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=3)
	  public void MouldedNo46OgeeCastAluminiumProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("CastAluminiumGuttersProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("MouldedNo46OgeeCastAluminiumProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  TimeUnit.SECONDS.sleep(1);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  TimeUnit.SECONDS.sleep(1);
			  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String finalcatproname=productname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
			  System.out.println("***********************************************************************************************");
			  TimeUnit.SECONDS.sleep(1);
			  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str8=prop.getProperty("Finalproductname_part1a");
				  String str13=prop.getProperty("popupClose");
				  int r=Subtotal+1;
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Recently viewed product name is:"+Proname);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  dr.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				  //ScreenCapture();
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+r+str13)).click();
			  }
			  dr.navigate().to(prop.getProperty("MouldedNo46OgeeCastAluminiumProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=4)
	  public void BeadedHalfRoundCastAluminiumProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("CastAluminiumGuttersProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("BeadedHalfRoundCastAluminiumProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  TimeUnit.SECONDS.sleep(1);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  TimeUnit.SECONDS.sleep(1);
			  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String finalcatproname=productname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
			  System.out.println("***********************************************************************************************");
			  TimeUnit.SECONDS.sleep(1);
			  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str8=prop.getProperty("Finalproductname_part1a");
				  String str13=prop.getProperty("popupClose");
				  int r=Subtotal+1;
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Recently viewed product name is:"+Proname);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  dr.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				  //ScreenCapture();
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+r+str13)).click();
			  }
			  dr.navigate().to(prop.getProperty("BeadedHalfRoundCastAluminiumProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=5)
	  public void BeadedDeepFlowCastAluminiumProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("CastAluminiumGuttersProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("BeadedDeepFlowCastAluminiumProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  TimeUnit.SECONDS.sleep(1);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  TimeUnit.SECONDS.sleep(1);
			  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String finalcatproname=productname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
			  System.out.println("***********************************************************************************************");
			  TimeUnit.SECONDS.sleep(1);
			  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str8=prop.getProperty("Finalproductname_part1a");
				  String str13=prop.getProperty("popupClose");
				  int r=Subtotal+1;
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Recently viewed product name is:"+Proname);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  dr.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				  //ScreenCapture();
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+r+str13)).click();
			  }
			  dr.navigate().to(prop.getProperty("CastAluminiumGuttersProductPage"));
	  }
	  }
	
	@AfterTest
	  public static void CloseBrowser(){
		  dr.close();
		  dr.quit();
	}
}