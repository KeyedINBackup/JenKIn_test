package jenTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownpipesHoppersAluminiumSubProducts{
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
				dr.findElement(By.id("login_password")).sendKeys("123test456");
				dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/ul/li[4]/input")).click();
			}
			dr.switchTo().window(winhandle);
	}
	public static void ScreenCapture() throws IOException{
		File file=new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		FileInputStream input = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(input);
		WebElement element=dr.findElement(By.xpath(prop.getProperty("ScreenElement")));
		File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(scrFile);
		Point point = element.getLocation();
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", scrFile);
		String filename="Screenshot"+System.currentTimeMillis();
		FileUtils.copyFile(scrFile, new File("c:\\sel_screen\\"+filename+".png"));
	}
	
	@Test(enabled=true,priority=1)
	  public void AluminiumPipesProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("Downpipes&HoppersProductPage"));
		  TimeUnit.SECONDS.sleep(1);
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  dr.findElement(By.xpath(prop.getProperty("AluminiumPipesProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("RoundAluminiumPipesProducts"))).click();
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
			  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String finalcatproname=productname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
			  System.out.println("***********************************************************************************************");
			  TimeUnit.SECONDS.sleep(1);
			  WebElement FinalSubProducts=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> FinalSubproductss=FinalSubProducts.findElements(By.tagName("figure"));
			  int Subtotals=FinalSubproductss.size();
			  for(int n=1; n<=Subtotals; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str8=prop.getProperty("Finalproductname_part1a");
				  String str13=prop.getProperty("popupClose");
				  int r=Subtotals+1;
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
			  dr.navigate().to(prop.getProperty("RoundAluminiumPipesProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=2)
	  public void SquareAndRectangularAluminiumPipesProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("AluminiumPipesProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("SquareAndRectangularAluminiumPipesProducts"))).click();
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
			  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String finalcatproname=productname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
			  System.out.println("***********************************************************************************************");
			  TimeUnit.SECONDS.sleep(1);
			  WebElement FinalSubProducts=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> FinalSubproductss=FinalSubProducts.findElements(By.tagName("figure"));
			  int Subtotals=FinalSubproductss.size();
			  for(int n=1; n<=Subtotals; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str8=prop.getProperty("Finalproductname_part1a");
				  String str13=prop.getProperty("popupClose");
				  int r=Subtotals+1;
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-1000);");
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
			  dr.navigate().to(prop.getProperty("SquareAndRectangularAluminiumPipesProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=3)
	  public void CastAluminiumHoppersProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("AluminiumPipesProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("CastAluminiumHoppersProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  System.out.println("***********************************************************************************************");
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubProducts=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproductss=FinalSubProducts.findElements(By.tagName("figure"));
		  int Subtotals=FinalSubproductss.size();
		  for(int n=1; n<=Subtotals; n++){
			  String str5=prop.getProperty("ProductImage_Part1");
			  String str6=prop.getProperty("ProductImage_Part2");
			  String str8=prop.getProperty("Finalproductname_part1a");
			  String str13=prop.getProperty("popupClose");
			  int r=Subtotals+1;
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
		  dr.navigate().to(prop.getProperty("CastAluminiumHoppersProductPage"));
  }
	  
	
	@Test(enabled=true,priority=4)
	  public void OrnamentalFixingLugsProduct() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("AluminiumPipesProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("OrnamentalFixingLugsProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  System.out.println("***********************************************************************************************");
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubProducts=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproductss=FinalSubProducts.findElements(By.tagName("figure"));
		  int Subtotals=FinalSubproductss.size();
		  for(int n=1; n<=Subtotals; n++){
			  String str5=prop.getProperty("ProductImage_Part1");
			  String str6=prop.getProperty("ProductImage_Part2");
			  String str8=prop.getProperty("Finalproductname_part1a");
			  String str13=prop.getProperty("popupClose");
			  int r=Subtotals+1;
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
		  dr.navigate().to(prop.getProperty("OrnamentalFixingLugsProductPage"));
}
	
	@Test(enabled=true,priority=5)
	  public void EmbelishmentsProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("AluminiumPipesProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("EmbelishmentsProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  System.out.println("***********************************************************************************************");
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubProducts=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproductss=FinalSubProducts.findElements(By.tagName("figure"));
		  int Subtotals=FinalSubproductss.size();
		  for(int n=1; n<=Subtotals; n++){
			  String str5=prop.getProperty("ProductImage_Part1");
			  String str6=prop.getProperty("ProductImage_Part2");
			  String str8=prop.getProperty("Finalproductname_part1a");
			  String str13=prop.getProperty("popupClose");
			  int r=Subtotals+1;
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
		  dr.navigate().to(prop.getProperty("AluminiumPipesProductPage"));
}
	@Test(enabled=true,priority=6)
	  public void TemporaryRainWaterPipeProduct() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("Downpipes&HoppersProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("TemporaryRainWaterPipeProduct"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String FinalSubproname=FinalSubproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+FinalSubproname);
		  System.out.println("***********************************************************************************************");
		  TimeUnit.SECONDS.sleep(1);
		  WebElement FinalSubProducts=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproductss=FinalSubProducts.findElements(By.tagName("figure"));
		  int Subtotals=FinalSubproductss.size();
		  for(int n=1; n<=Subtotals; n++){
			  String str5=prop.getProperty("ProductImage_Part1");
			  String str6=prop.getProperty("ProductImage_Part2");
			  String str8=prop.getProperty("Finalproductname_part1a");
			  String str13=prop.getProperty("popupClose");
			  int r=Subtotals+1;
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
		  dr.navigate().to(prop.getProperty("Downpipes&HoppersProductPage"));
}
	
	@AfterTest
	  public static void CloseBrowser(){
		  dr.close();
		  dr.quit();
	}
}