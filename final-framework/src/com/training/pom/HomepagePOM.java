package com.training.pom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomepagePOM {
	
		private WebDriver driver; 

		String msg=null;
		
		public HomepagePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		//
		@FindBy(xpath="//a[contains(text(),'Sign up!')]")
		private WebElement signUp;
		
		@FindBy(name="firstname")
		private WebElement fstName;
		
		@FindBy(name="lastname")
		private WebElement lstName;

		@FindBy(name="email")
		private WebElement eMail;

		@FindBy(name="username")
		private WebElement usrName;

		@FindBy(name="pass1")
		private WebElement pas1;

		@FindBy(name="pass2")
		private WebElement pas2;

		@FindBy(name="phone")
		private WebElement phone;
		
		@FindBy(xpath="//p[contains(text(),'An e-mail')]")
		private WebElement signUpMsg;
		
		@FindBy(name="submit")
		private WebElement submitL;
		
		
		public void clickSignUpM() {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			this.signUp.click(); 
		}
		
		public void sendFirstNameM(String fstName)
		{
			this.fstName.clear();
			this.fstName.sendKeys(fstName);
		}
		
		public void sendLastNameM(String lstName)
		{
			this.lstName.clear();
			this.lstName.sendKeys(lstName);
		}

		public void eMailM(String eMail)
		{
			this.eMail.clear();
			this.eMail.sendKeys(eMail);
		}
		
		public void userNameM(String usrName)
		{
			this.usrName.clear();
			this.usrName.sendKeys(usrName);
		}
		
		public void pass1M(String pas1)
		{
			this.pas1.clear();
			this.pas1.sendKeys(pas1);
		}
		
		public void pass2M(String pas2)
		{
			this.pas2.clear();
			this.pas2.sendKeys(pas2);
		}
		
		public void phoneM(String phone)
		{
			this.phone.clear();
			this.phone.sendKeys(phone);
		}
		
		public void registerM() {
			this.submitL.click(); 
		}
		
		public void SignUpSuccessValM()
		{
			msg=this.signUpMsg.getText();
			System.out.println(msg);
			Assert.assertEquals(msg, "An e-mail has been sent to remind you of your login and password.");
			
		}
		
}