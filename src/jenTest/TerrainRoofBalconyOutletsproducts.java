package jenTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
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

public class TerrainRoofBalconyOutletsproducts{
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
	  public void TerrainRoofBalconyOutletsProduct() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainRoofBalconyOutletsProductPage"));
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  System.out.println("***********************************************************************************************");
		  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("div"));
		  int Subtotal=FinalSubproducts.size();
		  for(int n=1; n<=Subtotal; n++){
			  String str5=prop.getProperty("ProductImage_Part1");
			  String str6=prop.getProperty("ProductImage_Part2");
			  String str7=prop.getProperty("Finalproductname_part1");
			  String str8=prop.getProperty("Finalproductname_part2");
			  String str10=prop.getProperty("Finalproductprice_1");
			  String str11=prop.getProperty("FinalQuantity");
			  String str12=prop.getProperty("Finalproduct_Addtocart_2");
			  if( n % 2 != 0){
			  int r=n+1;
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
			  //ScreenCapture();
			  dr.findElement(By.xpath(str7+r+str11)).click();
			  dr.findElement(By.xpath(str7+r+str12)).click();
			  String ProEnd[]={"Socket Adaptor (82mm x 68mm)"};
			  if(Arrays.asList(ProEnd).contains(Proname)){
				  break;
			  }
			}
		  }
	}
	
	@AfterTest
	  public static void CloseBrowser(){
		  dr.close();
		  dr.quit();

	 }
	
}