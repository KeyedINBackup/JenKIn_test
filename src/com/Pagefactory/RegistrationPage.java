package com.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    WebDriver dr;
	public RegistrationPage(WebDriver dr){
		this.dr=dr;
	}
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[1]/ul[1]/li[1]/input")
	WebElement UNameField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[1]/ul[1]/li[2]/input")
	WebElement PassField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[1]/ul[1]/li[3]/input")
	WebElement ConfirmPassField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[1]/input")
	WebElement FirstNameField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[2]/input")
	WebElement SurNameField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[3]/input")
	WebElement CompanyNamField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[4]/input")
	WebElement Address1Field;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[5]/input")
	WebElement Address2Field;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[6]/input")
	WebElement townField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[7]/input")
	WebElement CountryField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[8]/input")
	WebElement PostCodeField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[9]/input")
	WebElement EmailField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[10]/input")
	WebElement ConfirmEmailField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[11]/input")
	WebElement PhoneNoField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[2]/ul/li[12]/input")
	WebElement MobileNoField;
	
	@FindBy(how=How.XPATH, using="html/body/div[1]/div[2]/div/div/section/form/div[3]/ul/li[13]/label")
	WebElement CheckBoxField;
	
	public void setUsername(String uname){
		UNameField.sendKeys(uname);
		
	}
	
	public void setPass(String pass){
		PassField.sendKeys(pass);
		
	}
	
	
	public void setConfirmPass(String conpass){
		ConfirmPassField.sendKeys(conpass);
		
	}
	
	public void setFname(String Fname){
		FirstNameField.sendKeys(Fname);
		
	}

	public void setLname(String Lname){
		SurNameField.sendKeys(Lname);
		
	}
	
	public void setCompanyname(String Comname){
		CompanyNamField.sendKeys(Comname);
		
	}
	
	public void setAddOnename(String Addonename){
		Address1Field.sendKeys(Addonename);
		
	}
	
	public void setAddTwoname(String AddTwoname){
		Address1Field.sendKeys(AddTwoname);
		
	}
	
	public void setTownname(String tname){
		townField.sendKeys(tname);
		
	}
	
	public void setCountryname(String Counname){
		CountryField.sendKeys(Counname);
		
	}
	
	public void setpcname(String pc){
		PassField.sendKeys(pc);
		
	}
	
	public void setEname(String ename){
		EmailField.sendKeys(ename);
		
	}
	
	public void setCEname(String cename){
		ConfirmEmailField.sendKeys(cename);
		
	}
	
	public void setpno(String pno){
		PhoneNoField.sendKeys(pno);
		
	}
	
	public void setmno(String mno){
		MobileNoField.sendKeys(mno);
		
	}
	
	public void setSubmit(){
		CheckBoxField.click();
	
	}	
}
