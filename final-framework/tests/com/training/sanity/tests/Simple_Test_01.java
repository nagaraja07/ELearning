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
import com.training.pom.MyCoursePOM;
import com.training.pom.HomepagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Simple_Test_01 {


	private static final boolean False = false;
	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOM loginPOM; 
	private HomepagePOM homepagePOM;
	private MyCoursePOM mycoursePOM;
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
		mycoursePOM=new MyCoursePOM(driver);
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
	
	@Test(enabled=False)
	public void userSignUPTest() {
		boolean chck1=homepagePOM.clickSignUpM();
		if(chck1)
		{
		homepagePOM.roleSeleM();	
		homepagePOM.sendFirstNameM("Sam");
		homepagePOM.sendLastNameM("SNK10");
		homepagePOM.eMailM("Sam_SNK08@gmail.com");
		homepagePOM.userNameM("Sam_SNK10");
		homepagePOM.pass1M("1Sample10");
		homepagePOM.pass2M("1Sample10");
		homepagePOM.phoneM("1231231231");
		homepagePOM.languageM("English");
		homepagePOM.registerM();
		homepagePOM.SignUpSuccessValM();
		}
	
	}
	
	@Test(enabled=False)
	public void userLoginTest() {
			homepagePOM.entUsernameM("Sam_SNK10");
			homepagePOM.entPasswordM("1Sample10");
			homepagePOM.usrLoginM();
			homepagePOM.loginMsgValidationM("Sam SNK10");
			//screenShot.captureScreenShot("First");
	}
	
	@Test(enabled=False)
	public void editProfile() {
			homepagePOM.entUsernameM("Sam_SNK10");
			homepagePOM.entPasswordM("1Sample10");
			homepagePOM.usrLoginM();
			homepagePOM.loginMsgValidationM("Sam SNK10");
			homepagePOM.editProfileM();
			homepagePOM.entCurrPassM("1Sample10");
			homepagePOM.entResetPass1M("1Sample91");
			homepagePOM.entResetPass2M("1Sample91");
			homepagePOM.saveProfileM();
			homepagePOM.saveProfMsgValidationM();
			//screenShot.captureScreenShot("First");
	}
	
	
	@Test
	public void m1(){
		
		//Login as teacher
		homepagePOM.entUsernameM("Suzi_SNK01");
		homepagePOM.entPasswordM("1Sample10");
		homepagePOM.usrLoginM();
		
		//m1 steps
		boolean b1=false;
		b1=mycoursePOM.addNewCourseClickM();
		b1=mycoursePOM.entAddNewCourseTitM("Python P4");
		b1=mycoursePOM.addNewCourseAdvSettM();
		b1=mycoursePOM.entAddNewCourseCatM("Projects (PROJ)");
		b1=mycoursePOM.entAddNewCourseCdM("Pythonp4");
		b1=mycoursePOM.entAddNewCourseLangM("English");
		b1=mycoursePOM.addNewCourseSubM();
		b1=mycoursePOM.addCourIntroClickM();
		b1=mycoursePOM.entNewCourIntroM("Intro");
		b1=mycoursePOM.addCourIntroSaveClickM();
		
	}
	
	
	
}
