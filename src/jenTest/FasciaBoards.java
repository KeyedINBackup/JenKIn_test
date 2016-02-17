package jenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FasciaBoards {
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
  @Test
  public void FasciaBoardsProduct() throws IOException, InterruptedException {

	  File file = new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Products_PageObjects");
	  FileInputStream input = new FileInputStream(file);
	  Properties prop = new Properties();
	  prop.load(input);
	  dr.findElement(By.xpath(prop.getProperty("MainProduct"))).click();
	  WebElement SubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
	  List<WebElement> list=SubProduct.findElements(By.tagName("div"));
	  int t=list.size();
	  WebElement mainname=dr.findElement(By.xpath(prop.getProperty("mainproductname")));
	  String Mainproductname=mainname.getText();
	  System.out.println("*************************************************");
	  System.out.println("The Main Product Name is:"+Mainproductname);
	  System.out.println("*************************************************");
	  for(int i=1;i<=t;i++){
		  String str1=prop.getProperty("subproduct_part1");
		  String str2=prop.getProperty("subproduct_part2");
		  dr.findElement(By.xpath(str1+i+str2)).click();
		  WebElement SubSubProduct=dr.findElement(By.xpath(prop.getProperty("subproduct")));
		  List<WebElement> lists=SubSubProduct.findElements(By.tagName("div"));
		  int sum=lists.size();
		  WebElement subname=dr.findElement(By.xpath(prop.getProperty("subproductname")));
		  String Subfinalproductname=subname.getText();
		  System.out.println("The Sub Product Name is:"+Subfinalproductname);
		  System.out.println("*************************************************");
		  String [] Mainsubproductname={"LIGHT GREY GLOSS (RAL 7040)", "HAZY GREY GLOSS (RAL 7046)", "ANTHRACITE GREY GLOSS (RAL 7016)", "ANTHRACITE GREY WOODGRAIN FOIL (RAL 7016)"};
		  if(Arrays.asList(Mainsubproductname).contains(Subfinalproductname)){
			  for(int s=1;s<=sum;s++){
				  String str9=prop.getProperty("subproduct_part1");
				  String str10=prop.getProperty("subproduct_part2");
				  dr.findElement(By.xpath(str9+s+str10)).click();
				  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
				  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
				  int Subtotal=FinalSubproducts.size();
				  for(int n=1; n<=Subtotal; n++){
					  	int[] a={0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
						int d=Arrays.binarySearch(a, n);
						if(d>=0)
						{
							int l=n;
						} 
						else
						{
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
			  }
		  } 
				  
		  else{
			  for(int j=1;j<=sum;j++){
			  String str3=prop.getProperty("subproduct_part1");
			  String str4=prop.getProperty("subproduct_part2");
			  dr.findElement(By.xpath(str3+j+str4)).click();
			  WebElement FinalProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
			  List<WebElement> products=FinalProduct.findElements(By.tagName("figure"));
			  int total=products.size();
			  WebElement subcatname=dr.findElement(By.xpath(prop.getProperty("subcatproductname")));
			  String Subcatproductname=subcatname.getText();
			  String [] subcatproductname={"LIGHT GREY GLOSS (RAL 7040)", "HAZY GREY GLOSS (RAL 7046)", "ANTHRACITE GREY GLOSS (RAL 7016)", "ANTHRACITE GREY WOODGRAIN FOIL (RAL 7016)"};
			  if(Arrays.asList(subcatproductname).contains(Subcatproductname)){
				      for(int m=1;m<=total;m++){
					  String str9=prop.getProperty("subproduct_part1");
					  String str10=prop.getProperty("subproduct_part2");
					  dr.findElement(By.xpath(str9+m+str10)).click();
					  WebElement FinalSubProduct=dr.findElement(By.xpath(prop.getProperty("FinalProduct")));
					  List<WebElement> FinalSubproducts=FinalSubProduct.findElements(By.tagName("figure"));
					  int Subtotal=FinalSubproducts.size();
					  for(int n=1; n<=Subtotal; n++){
						  	int[] a={0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
							int d=Arrays.binarySearch(a, n);
							if(d>=0)
							{
								int l=n;
							} 
							else
							{
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
					     System.out.println("*************************************************");
						 WebElement catproduct=dr.findElement(By.xpath(prop.getProperty("catproductname")));
						 String Name=catproduct.getText();
						 String [] lightgrey={"9MM LIGHT GREY CAPPING FASCIA BOARD", "16MM LIGHT GREY MAXI FASCIA BOARD"};
						 String [] Hazygrey={"9MM HAZY GREY CAPPING FASCIA BOARD", "16MM HAZY GREY MAXI FASCIA BOARD"};
						 String [] AnthraciteGrey={"9MM ANTHRACITE GREY GLOSS CAPPING FASCIA BOARD", "16MM ANTHRACITE GREY GLOSS MAXI FASCIA BOARD"};
						 if(Arrays.asList(lightgrey).contains(Name)){
							 dr.navigate().to(prop.getProperty("LightgreyURL"));
						 } else if(Arrays.asList(Hazygrey).contains(Name)){
							 dr.navigate().to(prop.getProperty("HazygreyURL"));
						 }else if(Arrays.asList(AnthraciteGrey).contains(Name)){
							 dr.navigate().to(prop.getProperty("AnthraciteGreyURL"));
					}else{
						dr.navigate().to(prop.getProperty("AnthraciteGreyWoodgrainURL"));
					}
				 }
			  }
			  else{
				  for(int k=1; k<=total; k++){
				  	int[] a={0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
					int d=Arrays.binarySearch(a, k);
					if(d>=0)
					{
						int l=k;
					} 
					else
					{
				  String str5=prop.getProperty("Finalproduct_Quantity_part1");
				  String str6=prop.getProperty("Finalproduct_Quantity_part2");
				  String str7=prop.getProperty("Finalproduct_Addtocart");
				  String str8=prop.getProperty("Finalproductname");
				  dr.findElement(By.xpath(str5+k+str6)).click();
				  TimeUnit.SECONDS.sleep(2);
				  WebElement ProductName=dr.findElement(By.xpath(str5+k+str8));
				  String Name=ProductName.getText();
				  System.out.println("The Added product name is:"+Name);
				  dr.findElement(By.xpath(str5+k+str7)).click();
				  dr.findElement(By.xpath(prop.getProperty("Continue_shopping"))).click();
					}
				  }
			    }
			 dr.navigate().to(prop.getProperty("Subproductpage"));
			 }
			  
		  }
		  dr.navigate().to(prop.getProperty("FasciaMainPage"));  
	  }
		  
  }
}