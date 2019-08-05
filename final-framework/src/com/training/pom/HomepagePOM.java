package com.training.pom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomepagePOM {
	
		private WebDriver driver; 

		String msg=null;
		
		public HomepagePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//p[text()='Follow courses']")
		private WebElement roleRadButL;
		
		@FindBy(id="login")
		private WebElement loginUserNameL;
		
		@FindBy(id="password")
		private WebElement loginPasswordL;
		
		@FindBy(id="form-login_submitAuth")
		private WebElement loginBtnL;
		
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
		
		@FindBy(name="language")
		private WebElement languageL;
		
		@FindBy(xpath="//p[contains(text(),'An e-mail')]")
		private WebElement signUpMsg;
		
		@FindBy(xpath="//div[@class='normal-message']/p[1]")
		private WebElement loginMsgL;
		
		@FindBy(name="submit")
		private WebElement submitL;
		
		@FindBy(xpath="//h4[contains(text(),'Most popular courses')]")
		private WebElement homePageIndL;
		
		@FindBy(xpath="//h2[@class='page-header']")
		private WebElement signUpPageIndL;
			
		
		//Edit Profile Locators
		
		@FindBy(name="password0")
		private WebElement currPassEditProfL;
		
		@FindBy(name="password1")
		private WebElement resPass1L;
		
		@FindBy(name="password2")
		private WebElement resPass2L;
		
		
		@FindBy(xpath="//a[contains(text(),'Edit profile')]")
		private WebElement editProfileBtnL;

		@FindBy(name="apply_change")
		private WebElement saveSettingL;
		
		@FindBy(xpath="//div[@class='alert alert-info']")
		private WebElement saveProfMsgL;
		
		
		public boolean clickSignUpM() {
			Boolean Flg1 = false;
			try{
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				if (this.homePageIndL.isDisplayed())
				{
					this.signUp.click();
					if(this.signUpPageIndL.isDisplayed())Flg1=true;
				}
			}catch(Exception e){
				System.out.println (e);
			}
			return Flg1;
		}
		
		//roleRadButL
		public void roleSeleM() {
			try{
		        if(roleRadButL.isDisplayed())
		        {
		        	if(roleRadButL.isEnabled())
		        	{
		        		if(roleRadButL.isSelected())
		        		{
		        			System.out.println("Student role is already Selected");
		        		}
		        		else{
		        			roleRadButL.click();
		        			System.out.println("Student role is Selected now");
		        		}
		        	}
		        	else{
		        		System.out.println("Role Button is not enabled");
		        	}
		        }
		        else{
		        	System.out.println("Role Button is unavailable");
		        }
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		
		public void sendFirstNameM(String fstName)
		{
			try{
				this.fstName.clear();
				this.fstName.sendKeys(fstName);
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		public void sendLastNameM(String lstName)
		{
			try{
				this.lstName.clear();
				this.lstName.sendKeys(lstName);
			}catch(Exception e){
				System.out.println (e);
			}
		}

		public void eMailM(String eMail)
		{
			try{
				this.eMail.clear();
				this.eMail.sendKeys(eMail);
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		public void userNameM(String usrName)
		{
			try{
				this.usrName.clear();
				this.usrName.sendKeys(usrName);
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		public void pass1M(String pas1)
		{
			try{
				this.pas1.clear();
				this.pas1.sendKeys(pas1);
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		public void pass2M(String pas2)
		{
			try{
				this.pas2.clear();
				this.pas2.sendKeys(pas2);
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		public void phoneM(String phone)
		{
			try{
				this.phone.clear();
				this.phone.sendKeys(phone);
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		public void languageM(String lang)
		{
			try{
				Select drpLang=new Select(this.languageL); 
				drpLang.selectByVisibleText(lang);
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		public void registerM() {
			try{
				this.submitL.click();
			}catch(Exception e){
				System.out.println (e);
			}
		}
		
		public void SignUpSuccessValM()
		{
			try{
				msg=this.signUpMsg.getText();
				System.out.println(msg);
				Assert.assertEquals(msg, "An e-mail has been sent to remind you of your login and password.");
			}catch(Exception e){
				System.out.println (e);
			}
			
		}	
		
		
		//Valid User login methods starts here
		
		public void entUsernameM(String usrNameVal)
		{
			try{
				this.loginUserNameL.clear();
				this.loginUserNameL.sendKeys(usrNameVal);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void entPasswordM(String usrPassVal)
		{
			try{
				this.loginPasswordL.clear();
				this.loginPasswordL.sendKeys(usrPassVal);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void usrLoginM()
		{
			try{
				this.loginBtnL.click();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void loginMsgValidationM(String usrNameVal)
		{
			try{
				String loginMsgVal=null;
				loginMsgVal=this.loginMsgL.getText();
				System.out.println(loginMsgVal);
			
				String expLoginMsg="Hello "+usrNameVal+" and welcome,";
				Assert.assertEquals(loginMsgVal, expLoginMsg);
			}catch(Exception e){
				System.out.println (e);
			}
			
		}	
		//Valid User login methods ends here
		
		//Edit Profile Methods starts here
		public void editProfileM()
		{
			try{
				this.editProfileBtnL.click();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void entCurrPassM(String usrCurrPass)
		{
			try{
				this.currPassEditProfL.clear();
				this.currPassEditProfL.sendKeys(usrCurrPass);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		
		public void entResetPass1M(String usrResPass1)
		{
			try{
				this.resPass1L.clear();
				this.resPass1L.sendKeys(usrResPass1);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void entResetPass2M(String usrResPass2)
		{
			try{
				this.resPass2L.clear();
				this.resPass2L.sendKeys(usrResPass2);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void saveProfileM()
		{
			try{
				this.saveSettingL.click();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void saveProfMsgValidationM()
		{
			try{
				String saveProfMsgVal=null;
				saveProfMsgVal=this.saveProfMsgL.getText();
				System.out.println(saveProfMsgVal);
				String saveProfSuccMsg="Your new profile has been saved";
				Assert.assertEquals(saveProfSuccMsg, saveProfMsgVal);
			}catch(Exception e){
				System.out.println (e);
			}
			
		}	
		
		
}