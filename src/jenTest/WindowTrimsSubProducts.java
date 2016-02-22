package jenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowTrimsSubProducts{
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
	  public void StandardShiplapProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.findElement(By.xpath(prop.getProperty("WindowTrimsMainProduct"))).click();
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  dr.findElement(By.xpath(prop.getProperty("StandaraWhiteWindowTrims"))).click();
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
			  dr.navigate().to(prop.getProperty("StandaraWhiteWindowTrimsProductpage"));
	  }
	  }
	@Test(enabled=true,priority=2)
	  public void BlackAshWindowTrimsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("BlackAshWindowTrims"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
			  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
	  }

	@Test(enabled=true,priority=3)
	  public void RoseWoodWindowTrimsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("RoseWoodWindowTrims"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
			  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
	  }

	@Test(enabled=true,priority=4)
	  public void AnthraciteGreyProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("AnthraciteGrey"))).click();
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
			  dr.navigate().to(prop.getProperty("AnthraciteGreyProductpage"));
	  }
	  }
	
	@Test(enabled=true,priority=5)
	  public void GoldenOakWindowTrimsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("GoldenOakWindowTrims"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=6)
	  public void ChartWellGreenWindowTrimsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("ChartWellGreenWindowTrims"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=7)
	  public void MahoghanyWoodgrainWindowTrimsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("MahoghanyWoodgrain"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=8)
	  public void WhiteWoodgrainWindowTrimsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("WhiteWoodgrain"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=9)
	  public void IrishOakWoodgrainWindowTrimsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("IrishOakWoodgrain"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=10)
	  public void CreamWoodgrainWindowTrimsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("CreamWoodgrain"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=11)
	  public void ExternalWindowChillsProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("ExternalWindowChills"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=12)
	  public void HockeyNoseWindowBoardProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("HockeyNoseWindowBoard"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  dr.findElement(By.xpath(prop.getProperty("WhiteHockeyBoard"))).click();
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=13)
	  public void WhiteBullnoseWindowBoardProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("WhiteBullnoseWindowBoard"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
  }
	
	@Test(enabled=true,priority=14)
	  public void WindowFittingAccesoriesProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
		  dr.findElement(By.xpath(prop.getProperty("WindowFittingAccesories"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  System.out.println("***********************************************************************************************");
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
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
			  dr.navigate().to(prop.getProperty("WindowTrimsMainpage"));
	  }
	
	
	
	
}

