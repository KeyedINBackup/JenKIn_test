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

public class FasciaSubProducts {
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
  @Test(enabled=false,priority=1)
  public void WhiteFasciaProducts() throws IOException, InterruptedException {
	  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
	  FileInputStream input = new FileInputStream(file);
	  Properties prop = new Properties();
	  prop.load(input);
	  dr.navigate().to(prop.getProperty("FasciaMainPage"));
	  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
	  String Mainproductname=mainname.getText();
	  System.out.println("***********************************************************************************************");
	  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
	  TimeUnit.SECONDS.sleep(1);
	  dr.findElement(By.xpath(prop.getProperty("WhiteFascia"))).click();
	  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
	  String Subproname=Subproductname.getText();
	  System.out.println("***********************************************************************************************");
	  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
	  TimeUnit.SECONDS.sleep(1);
	  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
	  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
	  int t=list.size();
	  for(int i=1;i<=t;i++){
		  String str1=prop.getProperty("subproduct_part1");
		  String str2=prop.getProperty("subproduct_part2");
		  dr.findElement(By.xpath(str1+i+str2)).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
		  System.out.println("***********************************************************************************************");
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
		  dr.navigate().to(prop.getProperty("WhiteFasicaproductpage"));
      }
  }
  
  @Test(enabled=true,priority=2)
  public void BlackFasciaProducts() throws IOException, InterruptedException {
	  
	  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
	  FileInputStream input = new FileInputStream(file);
	  Properties prop = new Properties();
	  prop.load(input);
	  dr.navigate().to(prop.getProperty("FasciaMainPage"));
	  dr.findElement(By.xpath(prop.getProperty("BlackFascia"))).click();
	  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
	  String Subproname=Subproductname.getText();
	  System.out.println("***********************************************************************************************");
	  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
	  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
	  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
	  int t=list.size();
	  for(int i=1;i<=t;i++){
		  String str1=prop.getProperty("subproduct_part1");
		  String str2=prop.getProperty("subproduct_part2");
		  dr.findElement(By.xpath(str1+i+str2)).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
		  System.out.println("***********************************************************************************************");
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
		  dr.navigate().to(prop.getProperty("BlackFasicaproductpage"));
  }
  }
	  
	  @Test(enabled=false,priority=3)
	  public void LightGreyFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("GreyFasicaproductpage"));
		  dr.findElement(By.xpath(prop.getProperty("lightGrey"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
		 dr.navigate().to(prop.getProperty("LightgreyURL"));
	   }
	  }
  
	  @Test(enabled=false,priority=4)
	  public void HazyGreyFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("GreyFasicaproductpage"));
		  dr.findElement(By.xpath(prop.getProperty("HazyGrey"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
		 dr.navigate().to(prop.getProperty("HazygreyURL"));
	   }
	  }
	  
	  @Test(enabled=false,priority=5)
	  public void AnthraciteGreyFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("AnthraciteGreyURL"));
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
		 dr.navigate().to(prop.getProperty("AnthraciteGreyURL"));
	   }
	  }  
	  
	  @Test(enabled=false,priority=6)
	  public void AnthraciteWoodGreyFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("GreyFasicaproductpage"));
		  dr.findElement(By.xpath(prop.getProperty("AnthraciteWoodGrey"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
		 dr.navigate().to(prop.getProperty("AnthraciteWoodGreyURL"));
	   }
	  }  
	  	  
	  @Test(enabled=true,priority=7)
	  public void RosewoodFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("RosewoodFascia"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
			  dr.navigate().to(prop.getProperty("RosewoodFasciaMainPage"));
	  }
	  }
  
	  @Test(enabled=true,priority=8)
	  public void MahoganyFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("MahoganyFascia"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
			  dr.navigate().to(prop.getProperty("MahoganyFasciaMainPage"));
	  }
	  }
	  
	  @Test(enabled=true,priority=9)
	  public void GoldenOakFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("GoldenOakFascia"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
			  dr.navigate().to(prop.getProperty("GoldenOakFasciaMainPage"));
	  }
	  } 
	  
	  @Test(enabled=false,priority=10)
	  public void IrishOakFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("IrishOakFascia"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
			  dr.navigate().to(prop.getProperty("IrishOakFasciaMainPage"));
	  }
	  } 
	  
	  @Test(enabled=false,priority=11)
	  public void ChartwellGreenFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("ChartwellGreenFascia"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
			  dr.navigate().to(prop.getProperty("ChartwellGreenFasciamainPage"));
	  }
	  } 
	  
	  @Test(enabled=false,priority=12)
	  public void CreamFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("CreamFascia"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
			  dr.navigate().to(prop.getProperty("CreamFasciamainPage"));
	  }
	  } 
	  
	  @Test(enabled=false,priority=13)
	  public void MBossFasciaProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("M-BossFascia"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
		  int t=list.size();
		  for(int i=1;i<=t;i++){
			  String str1=prop.getProperty("subproduct_part1");
			  String str2=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str1+i+str2)).click();
			  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproname=Subcatproductname.getText();
			  System.out.println("***********************************************************************************************");
			  System.out.println("\t\tThe Sub category Product Name is:"+Subcatproname);
			  System.out.println("***********************************************************************************************");
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
			  dr.navigate().to(prop.getProperty("M-BossFasciamainPage"));
	  }
	  } 
	  
	  @Test(enabled=false,priority=14)
	  public void ThickFlatTudorBoardProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("20mmThickFlatTudorBoard"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
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
			  dr.navigate().to(prop.getProperty("FasciaMainPage"));
	  }
	  @AfterTest
	  public static void CloseBrowser(){
		  dr.close();
		  dr.quit();

	 }
	  
}