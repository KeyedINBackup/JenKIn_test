package com.payment.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PayPalTestLowValue {

	public static WebDriver dr;
	
	@BeforeTest
	public void Login() {
		dr= new FirefoxDriver();
		dr.navigate().to("http://dev.angelplastics.co.uk/");

		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.findElement(By.xpath("html/body/div[1]/header/section[1]/div/div/div[1]/ul/li[1]/a")).click();
		dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/ul/li[1]/input")).sendKeys("cus3@im360.co.uk");
		dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/ul/li[2]/input")).sendKeys("cus3@im360.co.uk");
		dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/ul/li[3]/label")).click();
		dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/ul/li[4]/input")).submit();
	}
	
	@Test(enabled=true,priority=1)
	public void lowvalueorder() throws InterruptedException{
		dr.navigate().to("http://dev.angelplastics.co.uk/Category/811/Ground-Guard-Lawn-Paving-Tile");
		System.out.println("***********************************************************************************************");
		WebElement product =dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/h2"));
		String ProductName=product.getText();
		System.out.println("The Product name is:"+ProductName);
		System.out.println("***********************************************************************************************");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement prodctpage=dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/section"));
		List<WebElement> totalproducts=prodctpage.findElements(By.tagName("div"));
		int n=totalproducts.size();
		for(int i=1; i<=n; i++){
			String str1="html/body/div[1]/div[2]/div/div/section/section/div[";
			String str2="]/figure/form/a/span";
			String str3="]/section/div/div/div[2]/div/form/div[2]/h4/b";
			String str4="]/section/div/div/div[2]/div/form/div[2]/table[2]/tbody/tr/td[2]/div/button[2]";
			String str5="]/section/div/div/div[2]/div/form/div[2]/div[3]/a";
			String str6="]/section/button";
			 if( i % 2 != 0){
				 int r=i+1;
				 dr.findElement(By.xpath(str1+i+str2)).click();
				 WebElement SubProductName=dr.findElement(By.xpath(str1+r+str3));
				 String Name=SubProductName.getText();
				 String Proname=Name.replaceAll("[\r\n]+", " ");
			     System.out.println("The Sub product name is:"+Proname);
				 dr.findElement(By.xpath(str1+r+str4)).click();
				 dr.findElement(By.xpath(str1+r+str5)).click();
				 dr.findElement(By.xpath(str1+r+str6)).click();
				 TimeUnit.SECONDS.sleep(3);
     			 String ProEnd="200 Litre Garden Lake Water Butt Kit";
				 if(ProEnd.equalsIgnoreCase(Proname)){
					  break;
				  }	 
			 }
		}
		dr.findElement(By.xpath("html/body/div[1]/header/section[2]/div/div/div/div[2]/div/nav/ul/li[7]/a/b")).click();
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/a[1]")).click();
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div[1]/div/div[2]/ul/li[1]/label")).click();
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div[1]/div/div[2]/ul/li[7]/input")).sendKeys("UK");
		Select sel=new Select(dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div[1]/div/div[2]/ul/li[9]/select")));
		sel.selectByIndex(2);
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div[1]/div/div[2]/ul/li[10]/input")).sendKeys("02086449922");
		JavascriptExecutor jse=(JavascriptExecutor)dr;
		jse.executeScript("scroll(0,500);");
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div[2]/figure[2]")).click();
		WebElement TPrice =dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div[3]/table/tbody/tr[5]/td[2]"));
		String Total=TPrice.getText();
		System.out.println("***********************************************************************************************");
		System.out.println("The Total price including all Vat is :"+Total);
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div[3]/table/tbody/tr[6]/td/label")).click();
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div[3]/table/tbody/tr[7]/td/input")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/form/div/input")).click();
		dr.findElement(By.xpath("html/body/div[2]/div[2]/div[3]/div/form[2]/div[2]/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/span/input")).click();
		dr.findElement(By.id("login_email")).sendKeys("angeltests@im360.co.uk");
		dr.findElement(By.id("login_password")).sendKeys("123asd!@#");
		dr.findElement(By.xpath("html/body/div[2]/div[2]/div[3]/div/form[2]/div[2]/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/div[3]/p[4]/input")).click();
		WebElement PPrice =dr.findElement(By.xpath("html/body/div[2]/div[2]/div[3]/div/form[2]/div[2]/div[1]/div/div[2]/div/div[2]/div/div[3]"));
		String PayPalTotal=PPrice.getText();
		System.out.println("The PayPal Total price including all Vat is :"+PayPalTotal);
		dr.findElement(By.xpath("html/body/div[2]/div[2]/div[3]/div/form[2]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[5]/div/input")).click();
		dr.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/form[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div[2]/ul/li[1]/span/span/input")).click();
		TimeUnit.SECONDS.sleep(5);
		Alert alt =dr.switchTo().alert();
		alt.accept();
		WebElement os =dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/h2"));
		String Status=os.getText();
		System.out.println("***********************************************************************************************");
		System.out.println("Order Status:"+Status);
		System.out.println("***********************************************************************************************");
		TimeUnit.SECONDS.sleep(3);
	}
	
	@AfterMethod
	public void closeBrowser(){
		dr.close();
		dr.quit();
	}
	
		
}