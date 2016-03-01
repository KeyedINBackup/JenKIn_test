package jenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cladding{
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
	@Test(enabled=false,priority=1)
	  public void StandardShiplapProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("CladdigMainPage"));
		  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
		  String Mainproductname=mainname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Main Product Name is:"+Mainproductname);
		  dr.findElement(By.xpath(prop.getProperty("StandardShiplap"))).click();
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
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1");
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  WebElement ProductName=dr.findElement(By.xpath(str7+n+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Added product name is:"+Proname);
				  WebElement ProductPrice=dr.findElement(By.xpath(str7+n+str10));
				  String Price=ProductPrice.getText();
				  System.out.println("The Added product price is:"+Price);
				  dr.findElement(By.xpath(str7+n+str11)).click();
				  dr.findElement(By.xpath(str7+n+str12)).click();
		 }
			  dr.navigate().to(prop.getProperty("StandardShiplapProductpage"));
	  }
	  }
	 
	@Test(enabled=false,priority=2)
	  public void VgroovecladdingProducts() throws IOException, InterruptedException {
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("claddigMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("Vgroovecladding"))).click();
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
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1");
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  WebElement ProductName=dr.findElement(By.xpath(str7+n+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Added product name is:"+Proname);
				  WebElement ProductPrice=dr.findElement(By.xpath(str7+n+str10));
				  String Price=ProductPrice.getText();
				  System.out.println("The Added product price is:"+Price);
				  dr.findElement(By.xpath(str7+n+str11)).click();
				  dr.findElement(By.xpath(str7+n+str12)).click();
			 }
			  dr.navigate().to(prop.getProperty("VgrooveCladdingProductpage"));
	  }
	  }
	
	  
	@Test(enabled=false,priority=3)
	  public void FeatherEdgeSmoothProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("claddigMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("FeatherEdgeSmooth"))).click();
		  WebElement Subproductname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subproname=Subproductname.getText();
		  System.out.println("***********************************************************************************************");
		  System.out.println("\t\tThe Sub Product Name is:"+Subproname);
		  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
		  List<WebElement> FinalSubproducts=SubProduct.findElements(By.tagName("figure"));
			  int Subtotal=FinalSubproducts.size();
			  for(int n=2; n<=Subtotal; n++){
				  String str5=prop.getProperty("ProductImage_Part1");
				  String str6=prop.getProperty("ProductImage_Part2");
				  String str7=prop.getProperty("Finalproductname_part1");
				  String str8=prop.getProperty("Finalproductname_part2");
				  String str10=prop.getProperty("Finalproductprice");
				  String str11=prop.getProperty("FinalQuantity");
				  String str12=prop.getProperty("Finalproduct_Addtocart_1");
				  JavascriptExecutor jse=(JavascriptExecutor)dr;
				  jse.executeScript("scroll(0,-500);");
				  TimeUnit.SECONDS.sleep(2);
				  dr.findElement(By.xpath(str5+n+str6)).click();
				  WebElement ProductName=dr.findElement(By.xpath(str7+n+str8));
				  String Name=ProductName.getText();
				  String Proname=Name.replaceAll("[\r\n]+", " ");
				  System.out.println("The Added product name is:"+Proname);
				  WebElement ProductPrice=dr.findElement(By.xpath(str7+n+str10));
				  String Price=ProductPrice.getText();
				  System.out.println("The Added product price is:"+Price);
				  dr.findElement(By.xpath(str7+n+str11)).click();
				  dr.findElement(By.xpath(str7+n+str12)).click();
			 }
			  dr.navigate().to(prop.getProperty("claddigMainPage"));
	  }

	@Test(enabled=true,priority=3)
	  public void EMbossedcladdingProducts() throws IOException, InterruptedException {
		  
		  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
		  FileInputStream input = new FileInputStream(file);
		  Properties prop = new Properties();
		  prop.load(input);
		  dr.navigate().to(prop.getProperty("claddigMainPage"));
		  dr.findElement(By.xpath(prop.getProperty("EMbossedcladding"))).click();
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
			  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("div"));
			  int Subtotal=FinalSubproducts.size();
			  for(int j=1;j<=Subtotal;j++){
				  String str3=prop.getProperty("subproduct_part1");
				  String str4=prop.getProperty("subproduct_part2");
				  dr.findElement(By.xpath(str3+j+str4)).click();
				  WebElement Finalcatproductname=dr.findElement(By.xpath(prop.getProperty("finalcatproductname")));
				  String Finalcatproname=Finalcatproductname.getText();
				  System.out.println("\t\tThe Sub category Product Name is:"+Finalcatproname);
				  System.out.println("***********************************************************************************************");
				  WebElement FinalSubcatProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
				  List<WebElement> FinalSubcatproducts=FinalSubcatProduct.findElements(By.tagName("figure"));
				  int finaltotal=FinalSubcatproducts.size();
				  for(int n=1; n<=finaltotal-1; n++){
					  String str5=prop.getProperty("ProductImage_Part1");
					  String str6=prop.getProperty("ProductImage_Part2");
					  String str7=prop.getProperty("Finalproductname_part1");
					  String str8=prop.getProperty("Finalproductname_part2");
					  String str10=prop.getProperty("Finalproductprice");
					  String str11=prop.getProperty("FinalQuantity");
					  String str12=prop.getProperty("Finalproduct_Addtocart_1");
					  JavascriptExecutor jse=(JavascriptExecutor)dr;
					  jse.executeScript("scroll(0,-500);");
					  TimeUnit.SECONDS.sleep(2);
					  dr.findElement(By.xpath(str5+n+str6)).click();
					  WebElement ProductName=dr.findElement(By.xpath(str7+n+str8));
					  String Name=ProductName.getText();
					  String Proname=Name.replaceAll("[\r\n]+", " ");
					  System.out.println("The Added product name is:"+Proname);
					  WebElement ProductPrice=dr.findElement(By.xpath(str7+n+str10));
					  String Price=ProductPrice.getText();
					  System.out.println("The Added product price is:"+Price);
					  dr.findElement(By.xpath(str7+n+str11)).click();
					  dr.findElement(By.xpath(str7+n+str12)).click();
			 }
				  WebElement catproduct=dr.findElement(By.xpath(prop.getProperty("catproductname")));
					 String Name=catproduct.getText();
					 String [] DoubleShiplap={"WHITE EMBOSSED SHIPLAP", "CREAM EMBOSSED SHIPLAP", "GREY EMBOSSED SHIPLAP", "SAND EMBOSSED SHIPLAP", "CAMEL EMBOSSED SHIPLAP", "ANTHRACITE GREY EMBOSSED SHIPLAP"};
					 String [] FeatherEdge={"WHITE EMBOSSED FEATHEREDGE", "CREAM EMBOSSED FEATHEREDGE", "GREY EMBOSSED FEATHEREDGE", "SAND EMBOSSED FEATHEREDGE", "CAMEL EMBOSSED FEATHEREDGE", "ANTHRACITE GREY EMBOSSED FEATHEREDGE"};
					 if(Arrays.asList(DoubleShiplap).contains(Name)){
						 dr.navigate().to(prop.getProperty("DoubleShiplap"));
					 } else if(Arrays.asList(FeatherEdge).contains(Name)){
						 dr.navigate().to(prop.getProperty("FeatherEdge"));
					 }else{
						 dr.navigate().to(prop.getProperty("VgrooveEmbossed"));
					 }
			}
		 dr.navigate().to(prop.getProperty("EMbossedcladdingProductpage"));
	  }
  }


	
}


