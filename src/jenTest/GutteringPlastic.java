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

public class GutteringPlastic{
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
	  public void StandardHalfRoundProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("112mmStandardHalfRoundProductspage"));
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final sub-category Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("112mmStandardHalfRoundProducts"))).click();
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
			  dr.navigate().to(prop.getProperty("112mmStandardHalfRoundProductspage"));
	  }
	}
	@Test(enabled=true,priority=2)
	  public void SquareLineGutterinProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeRange"));
		  dr.findElement(By.xpath(prop.getProperty("112mmSquarelineGutteringProducts"))).click();
		  WebElement Subfinalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subfinalproname=Subfinalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subfinalproname);
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
			  dr.navigate().to(prop.getProperty("112mmSquarelineGutteringProductPage"));
	  }
	  }  
	
	@Test(enabled=true,priority=3)
	  public void PolyFlowGutterinProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeRange"));
		  dr.findElement(By.xpath(prop.getProperty("117mmPolyflowGutteringProducts"))).click();
		  WebElement Subfinalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subfinalproname=Subfinalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subfinalproname);
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
			  dr.navigate().to(prop.getProperty("117mmPolyflowGutteringProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=4)
	  public void VictorianOgeeGutterinProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeRange"));
		  dr.findElement(By.xpath(prop.getProperty("130mmVictorianOgeeGutteringProducts"))).click();
		  WebElement Subfinalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subfinalproname=Subfinalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subfinalproname);
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
			  dr.navigate().to(prop.getProperty("130mmVictorianOgeeGutteringProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=5)
	  public void SovereignMouldedOgeePrducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeRange"));
		  dr.findElement(By.xpath(prop.getProperty("117mmSovereignMouldedOgeePrducts"))).click();
		  WebElement Subfinalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subfinalproname=Subfinalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subfinalproname);
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
			  dr.navigate().to(prop.getProperty("117mmSovereignMouldedOgeePrductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=6)
	  public void MinlineGutteringProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeRange"));
		  dr.findElement(By.xpath(prop.getProperty("75mmMinlineGutteringProducts"))).click();
		  WebElement Subfinalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subfinalproname=Subfinalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subfinalproname);
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
			  dr.navigate().to(prop.getProperty("75mmMinlineGutteringProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=7)
	  public void IndustrialGutteringProductPage() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeRange"));
		  dr.findElement(By.xpath(prop.getProperty("150mmIndustrialGutteringProducts"))).click();
		  WebElement Subfinalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subfinalproname=Subfinalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subfinalproname);
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
			  dr.navigate().to(prop.getProperty("150mmIndustrialGutteringProductPage"));
	  }
	  }
	
	
	@Test(enabled=true,priority=8)
	  public void TerrainPremiumRangeProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("110mmCrescentHalfRoundGutteringProdutPage"));
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
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
			  dr.navigate().to(prop.getProperty("110mmCrescentHalfRoundGutteringProdutPage"));
	  }
	  }
	
	@Test(enabled=true,priority=9)
	  public void CornicheSquarelineGutteringProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumRangeMainPage"));
		  TimeUnit.SECONDS.sleep(1);
		  dr.findElement(By.xpath(prop.getProperty("120mmCornicheSquarelineGutteringProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
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
			  dr.navigate().to(prop.getProperty("120mmCornicheSquarelineGutteringProductPage"));
	  }
	  }
	
			  
	  
	  
	@Test(enabled=true,priority=10)
	  public void RapidflowDeepflowGutteringProducts() throws IOException, InterruptedException {
		File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("131mmRapidflowDeepflowGutteringProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
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
			  dr.navigate().to(prop.getProperty("131mmRapidflowDeepflowGutteringProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=11)
	  public void StreamlineSquareGutteringProductPage() throws IOException, InterruptedException {
		File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("137mmStreamlineSquareGutteringProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
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
			  dr.navigate().to(prop.getProperty("137mmStreamlineSquareGutteringProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=12)
	  public void OmegaOgeeGutteringProductPage() throws IOException, InterruptedException {
		File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("122mmOmegaOgeeGutteringProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
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
			  dr.navigate().to(prop.getProperty("122mmOmegaOgeeGutteringProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=13)
	  public void AccessoriesProductPage() throws IOException, InterruptedException {
		File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("AccessoriesProducts"))).click();
		  TimeUnit.SECONDS.sleep(1);
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
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
		  dr.navigate().to(prop.getProperty("TerrainPremiumRangeMainPage"));
		  }
	
	@Test(enabled=true,priority=14)
	  public void FloplastTradeRangeProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PlasticGutteringMainpage"));
		  TimeUnit.SECONDS.sleep(1);
		  dr.findElement(By.xpath(prop.getProperty("FloplastTradeRangeProducts"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub sub-category Product Name is:"+Subproname);
		  TimeUnit.SECONDS.sleep(1);
		  dr.findElement(By.xpath(prop.getProperty("112mmStandardHalfRoundFloplastProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
		  TimeUnit.SECONDS.sleep(1);
		  dr.findElement(By.xpath(prop.getProperty("BlackHalfRoundFloplastProducts"))).click();
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
		  dr.navigate().to(prop.getProperty("112mmStandardHalfRoundFloplastProductPage"));
  }
  
	@Test(enabled=true,priority=15)
	  public void XtrafloGutterSystemProductPage() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FloplastTradeRangeProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("170mmXtrafloGutterSystemProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
		  TimeUnit.SECONDS.sleep(1);
		  dr.findElement(By.xpath(prop.getProperty("BlackHalfRoundFloplastProducts"))).click();
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
		  dr.navigate().to(prop.getProperty("170mmXtrafloGutterSystemProductPage"));
		 
  }
	
	

	@Test(enabled=true,priority=16)
	  public void CapDeepCapacityGutterSystemProductPage() throws IOException, InterruptedException {
		File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FloplastTradeRangeProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("112mmHi-CapDeepCapacityGutterSystemProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
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
			  dr.navigate().to(prop.getProperty("112mmHi-CapDeepCapacityGutterSystemProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=17)
	  public void SwishAnthraciteGreyRAL7016GutteringProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PlasticGutteringMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("SwishAnthraciteGreyRAL7016GutteringProducts"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
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
			  dr.navigate().to(prop.getProperty("PlasticGutteringMainpage"));
	  }
	@AfterTest
	  public static void CloseBrowser(){
		  dr.close();
		  dr.quit();
	}
}