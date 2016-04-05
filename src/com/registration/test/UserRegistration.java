package com.registration.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserRegistration {

	static WebDriver dr;
	
	public static void Screenshot() throws IOException{
		File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		String filename="Screensnap"+System.currentTimeMillis();
		FileUtils.copyFile(src, new File("c:\\sel_screen\\"+filename+".png"));
	}
	
	public static void main(String [] args) throws Exception{
		DataDrivenTest.setExcelPath("C://Selenium//jenkindemo//src//TestData//TestData.xlsx", "RegPage");
		File file=new File("C:\\Selenium\\jenkindemo\\src\\objectRepositry\\Reg_Page_Objects");
		FileInputStream input=new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(input);
		dr=new FirefoxDriver();
		for(int i=1; i<=22; i++){
		dr.navigate().to("http://dev.angelplastics.co.uk/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		dr.findElement(By.xpath("html/body/div[1]/header/section[1]/div/div/div[1]/ul/li[1]/a")).click();
		dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/footer/a")).click();
		String name=DataDrivenTest.getExcelData(i, 0);
		String password=DataDrivenTest.getExcelData(i, 1);
		String confirmpassword=DataDrivenTest.getExcelData(i, 2);
		String firstname=DataDrivenTest.getExcelData(i, 3);
		String surname=DataDrivenTest.getExcelData(i, 4);
		String companyname=DataDrivenTest.getExcelData(i, 5);
		String address1=DataDrivenTest.getExcelData(i, 6);
		String address2=DataDrivenTest.getExcelData(i, 7);
		String town=DataDrivenTest.getExcelData(i, 8);
		String country=DataDrivenTest.getExcelData(i, 9);
		String postcodenumber=DataDrivenTest.getExcelData(i, 10);
		String emailid=DataDrivenTest.getExcelData(i, 11);
		String confirmemailid=DataDrivenTest.getExcelData(i, 12);
		String phonenumber=DataDrivenTest.getExcelData(i, 13);
		String mobilenumber=DataDrivenTest.getExcelData(i, 14);
		dr.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(name);
		dr.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(password);
		dr.findElement(By.xpath(prop.getProperty("conpass"))).sendKeys(confirmpassword);
		dr.findElement(By.xpath(prop.getProperty("fname"))).sendKeys(firstname);		
		dr.findElement(By.xpath(prop.getProperty("sname"))).sendKeys(surname);
		dr.findElement(By.xpath(prop.getProperty("comname"))).sendKeys(companyname);
		dr.findElement(By.xpath(prop.getProperty("add1"))).sendKeys(address1);
		dr.findElement(By.xpath(prop.getProperty("add2"))).sendKeys(address2);
		dr.findElement(By.xpath(prop.getProperty("town"))).sendKeys(town);
		dr.findElement(By.xpath(prop.getProperty("country"))).sendKeys(country);
		dr.findElement(By.xpath(prop.getProperty("pcode"))).sendKeys(postcodenumber);
		dr.findElement(By.xpath(prop.getProperty("email"))).sendKeys(emailid);
		dr.findElement(By.xpath(prop.getProperty("conEmail"))).sendKeys(confirmemailid);
		dr.findElement(By.xpath(prop.getProperty("phoneno"))).sendKeys(phonenumber);
		dr.findElement(By.xpath(prop.getProperty("mobileno"))).sendKeys(mobilenumber);
		JavascriptExecutor jse=(JavascriptExecutor)dr;
		jse.executeScript("scroll(0,1000);");
		Robot object= new Robot();
		object.delay(1000);
		object.keyPress(KeyEvent.VK_TAB);
		object.keyRelease(KeyEvent.VK_TAB);
		object.keyPress(KeyEvent.VK_ENTER);	
			
		object.keyRelease(KeyEvent.VK_ENTER);
		jse.executeScript("scroll(0,1000);");
		TimeUnit.SECONDS.sleep(2);
		Screenshot();	
		String ps=dr.getPageSource();
		if(ps.contains("Registration Confirmation")){
			System.out.println("Successfully registered...!");
			break;
		} else {
			System.out.println("Please update the errors and Try again..!");
		}
	  }
		dr.quit();
	}	
  }
