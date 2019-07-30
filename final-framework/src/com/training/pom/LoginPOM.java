package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 

	String msg=null;
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
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
	
	@FindBy(xpath="//div/p[contains(text(),'Dear')]")
	private WebElement signUpMsg;
	
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	} 
	
	
	
	
}
