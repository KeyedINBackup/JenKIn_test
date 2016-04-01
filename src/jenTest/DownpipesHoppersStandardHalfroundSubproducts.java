package jenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
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

public class DownpipesHoppersStandardHalfroundSubproducts{
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
	  public void StandardHalfRoundProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("Downpipes&HoppersProductPage"));
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  dr.findElement(By.xpath(prop.getProperty("StandardPlasticPipesProducts"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  dr.findElement(By.xpath(prop.getProperty("StandardRoundPipe68mmProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub sub-category Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("Black68mmPipeProducts"))).click();
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
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Outlet Adaptor"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("StandardRoundPipe68mmProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=2)
	  public void StandardSquarePipe65mmProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeDownpipeRangeProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("StandardSquarePipe65mmProducts"))).click();
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
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Long Hose Rainwater Diverter Kit (black)", "Extended Backplate (brown)"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("StandardSquarePipe65mmProductPage"));
	  }
	  }  
	
	@Test(enabled=true,priority=3)
	  public void ThreeinchRoundPipeProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeDownpipeRangeProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("82mm(3inch)RoundPipeProducts"))).click();
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
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Rainwater adaptor"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("82mm(3inch)RoundPipeProductPage"));
	  }
	  }  
	
	@Test(enabled=true,priority=4)
	  public void FourinchRoundPipeProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("PolypipeTradeDownpipeRangeProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("110mm(4inch)RoundPipeProducts"))).click();
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
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Drain Connector (black)", "110mm Grey Drain Connector"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("110mm(4inch)RoundPipeProductPage"));
	  }
	  }  
	
	@Test(enabled=true,priority=5)
	  public void TerrainPremiumDownpipeRangeProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("StandardPlasticPipesProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("TerrainPremiumDownpipeRangeProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub sub-category Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("68mmRoundDownPipeProducts"))).click();
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
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Outlet Adaptor"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("68mmRoundDownPipeProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=6)
	  public void CornicheSquarelineGutteringProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumDownpipeRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("62mmSquareDownPipeProducts"))).click();
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
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("div"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice_1");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Long Hose Rainwater Diverter Kit (black)"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("62mmSquareDownPipeProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=7)
	  public void SquareDownpipesProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumDownpipeRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("75mmSquareDownpipesProducts"))).click();
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
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("div"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice_1");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Access Pipe 75mm (terr black)", "75mm Square Branch (terr white)"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("75mmSquareDownpipesProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=8)
	  public void RoundDownpipesProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumDownpipeRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("82mmRoundDownpipesProducts"))).click();
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
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("div"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice_1");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Rainwater adaptor"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("82mmRoundDownpipesProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=9)
	  public void MMRoundDownpipesProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumDownpipeRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("110mmRoundDownpipesProducts"))).click();
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
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("div"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice_1");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Drain Connector (black)"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("110mmRoundDownpipesProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=10)
	  public void RoofBalconyOutletsProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("TerrainPremiumDownpipeRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("RoofBalconyOutletsProducts"))).click();
		  WebElement productname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
		  String finalcatproname=productname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Final Product Name is:"+finalcatproname);
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
			  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
		  dr.navigate().to(prop.getProperty("TerrainPremiumDownpipeRangeMainPage"));
	  }
	
	@Test(enabled=true,priority=11)
	  public void FloplastTradeDownpipeRangeProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("StandardPlasticPipesProductPage"));
		  dr.findElement(By.xpath(prop.getProperty("FloplastTradeDownpipeRangeProducts"))).click();
		  WebElement Subcatproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subcatproname=Subcatproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub sub-category Product Name is:"+Subcatproname);
		  dr.findElement(By.xpath(prop.getProperty("68mmRoundDownPipeFloplastProducts"))).click();
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
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd[]={"Connector to Drain"};
				  if(Arrays.asList(ProEnd).contains(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("68mmRoundDownPipeFloplastProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=12)
	  public void FloplastRoundDownpipesProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FloplastTradeDownpipeRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("80mmRoundDownpipesProducts"))).click();
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
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("div"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice_1");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd="Rainwater adaptor (80mm -110mm)";
				  if(ProEnd.equalsIgnoreCase(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("80mmRoundDownpipesProductPage"));
	  }
	  }
	
	@Test(enabled=true,priority=13)
	  public void BlackpipesProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("FloplastTradeDownpipeRangeMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("Black110mmpipeProducts"))).click();
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
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("div"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=1; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice_1");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1a");
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
				  String ProEnd="110mm Single Socket Access Pipe (black floplast)";
				  if(ProEnd.equalsIgnoreCase(Proname)){
					  break;
				  }
				}
			  }
			  dr.navigate().to(prop.getProperty("Black110mmpipeProductPage"));
	  }
	  }
	
	
	
	@AfterTest
	  public static void CloseBrowser(){
		  dr.close();
		  dr.quit();
	}
	
		
}