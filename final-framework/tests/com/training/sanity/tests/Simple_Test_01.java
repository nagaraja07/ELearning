package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.HomepagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Simple_Test_01 {


	private static final boolean False = false;
	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOM loginPOM; 
	private HomepagePOM homepagePOM;
	private static Properties properties; 
	private ScreenShot screenShot; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		homepagePOM = new HomepagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test(enabled=False)
	public void loginPassTest() {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
	}
	
	@Test
	public void loginTest() {
		homepagePOM.clickSignUpM();
		homepagePOM.sendFirstNameM("Sam12312");
		homepagePOM.sendLastNameM("SNK05");
		homepagePOM.eMailM("Sam_SNK05@gmail.com");
		homepagePOM.userNameM("Sam_SNK05");
		homepagePOM.pass1M("1Smaple91");
		homepagePOM.pass2M("1Sample91");
		homepagePOM.registerM();
		homepagePOM.SignUpSuccessValM();
		//
	
	}
	
	
}
