package jenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GutteringImitaionCastIron{
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
	@Test(enabled=true,priority=1)
	  public void StandardHalfRoundProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("GutteringMainpage"));
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  dr.findElement(By.xpath(prop.getProperty("ImitationCastIronProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("Standard112mmHalfRoundbyBrettMartinProducts"))).click();
		  WebElement Finalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Finalproname=Finalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Product Name is:"+Finalproname);
		  System.out.println("***********************************************************************************************");
		  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
		  int Subtotal=FinalSubproducts.size();
		  for(int n=1; n<=Subtotal; n++){
			  String str5=prop.getProperty("Finalproduct_Quantity_part1");
			  String str6=prop.getProperty("Finalproduct_Quantity_part2");
			  String str7=prop.getProperty("Finalproduct_Addtocart");
			  String str8=prop.getProperty("Finalproductname");
			  dr.findElement(By.xpath(str5+n+str6)).click();
			  TimeUnit.SECONDS.sleep(2);
			  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
			  String Name=ProductName.getText();
			  System.out.println("The Added product name is:"+Name);
			  dr.findElement(By.xpath(str5+n+str7)).click();
			  dr.findElement(By.xpath(prop.getProperty("Continue_shopping"))).click();
          }
	  }
	@Test(enabled=true,priority=2)
	  public void DeepCapacityRoundbyBrettMartinProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.findElement(By.xpath(prop.getProperty("ImitationCastIronProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("115mmDeepCapacityRoundbyBrettMartinProducts"))).click();
		  WebElement Finalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Finalproname=Finalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Product Name is:"+Finalproname);
		  System.out.println("***********************************************************************************************");
		  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
		  int Subtotal=FinalSubproducts.size();
		  for(int n=1; n<=Subtotal; n++){
			  String str5=prop.getProperty("Finalproduct_Quantity_part1");
			  String str6=prop.getProperty("Finalproduct_Quantity_part2");
			  String str7=prop.getProperty("Finalproduct_Addtocart");
			  String str8=prop.getProperty("Finalproductname");
			  dr.findElement(By.xpath(str5+n+str6)).click();
			  TimeUnit.SECONDS.sleep(2);
			  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
			  String Name=ProductName.getText();
			  System.out.println("The Added product name is:"+Name);
			  dr.findElement(By.xpath(str5+n+str7)).click();
			  dr.findElement(By.xpath(prop.getProperty("Continue_shopping"))).click();
        }
	 }
	
	@Test(enabled=true,priority=3)
	  public void MouldedOgeeGutterbyBrettMartinProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.findElement(By.xpath(prop.getProperty("ImitationCastIronProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("106mmMouldedOgeeGutterbyBrettMartinProducts"))).click();
		  WebElement Finalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Finalproname=Finalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Product Name is:"+Finalproname);
		  System.out.println("***********************************************************************************************");
		  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
		  int Subtotal=FinalSubproducts.size();
		  for(int n=1; n<=Subtotal; n++){
			  String str5=prop.getProperty("Finalproduct_Quantity_part1");
			  String str6=prop.getProperty("Finalproduct_Quantity_part2");
			  String str7=prop.getProperty("Finalproduct_Addtocart");
			  String str8=prop.getProperty("Finalproductname");
			  dr.findElement(By.xpath(str5+n+str6)).click();
			  TimeUnit.SECONDS.sleep(2);
			  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
			  String Name=ProductName.getText();
			  System.out.println("The Added product name is:"+Name);
			  dr.findElement(By.xpath(str5+n+str7)).click();
			  dr.findElement(By.xpath(prop.getProperty("Continue_shopping"))).click();
      }
	 }
	
	@Test(enabled=true,priority=4)
	  public void IndustrialHalfRoundbyBrettMartinProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.findElement(By.xpath(prop.getProperty("ImitationCastIronProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("160mmIndustrialHalfRoundbyBrettMartinProducts"))).click();
		  WebElement Finalproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Finalproname=Finalproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Product Name is:"+Finalproname);
		  System.out.println("***********************************************************************************************");
		  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
		  int Subtotal=FinalSubproducts.size();
		  for(int n=1; n<=Subtotal; n++){
			  String str5=prop.getProperty("Finalproduct_Quantity_part1");
			  String str6=prop.getProperty("Finalproduct_Quantity_part2");
			  String str7=prop.getProperty("Finalproduct_Addtocart");
			  String str8=prop.getProperty("Finalproductname");
			  dr.findElement(By.xpath(str5+n+str6)).click();
			  TimeUnit.SECONDS.sleep(2);
			  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
			  String Name=ProductName.getText();
			  System.out.println("The Added product name is:"+Name);
			  dr.findElement(By.xpath(str5+n+str7)).click();
			  dr.findElement(By.xpath(prop.getProperty("Continue_shopping"))).click();
    }
	 }
	
	
	@Test(enabled=false,priority=1)
	  public void Products() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("GutteringMainpage"));
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  dr.findElement(By.xpath(prop.getProperty("ImitationCastIronProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Sub-category Product Name is:"+Subcatproname);
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
				  String str5=prop.getProperty("Finalproduct_Quantity_part1");
				  String str6=prop.getProperty("Finalproduct_Quantity_part2");
				  String str7=prop.getProperty("Finalproduct_Addtocart");
				  String str8=prop.getProperty("Finalproductname");
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  TimeUnit.SECONDS.sleep(2);
				  WebElement ProductName=dr.findElement(By.xpath(str5+n+str8));
				  String Name=ProductName.getText();
				  System.out.println("The Added product name is:"+Name);
				  dr.findElement(By.xpath(str5+n+str7)).click();
				  dr.findElement(By.xpath(prop.getProperty("Continue_shopping"))).click();
	          }
			  dr.navigate().to(prop.getProperty("ImitationCastIronProductPage"));
	  }
	  }
	
	
	
}