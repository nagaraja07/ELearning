package com.training.pom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyCoursePOM {
	
		private WebDriver driver; 

		String msg=null;
		
		public MyCoursePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="title")
		private WebElement sam;
		
		@FindBy(xpath="[@class='breadcrumb']")
		private WebElement myCourseBrdcrumsL;
		
		@FindBy(xpath="//a[contains(text(),'Create a course')]")
		private WebElement creCourseL;
		
		public boolean myCoursePageChck()
		{
			boolean myCoursePgChck=false;
			try{
				if(this.myCourseBrdcrumsL.isDisplayed())
				{
					myCoursePgChck=true;
				}
			}catch(Exception e){
			System.out.println (e);
				}
			return myCoursePgChck;
		}
		
		@FindBy(xpath="//form[@class='form-horizontal']/fieldset/legend)")
		private WebElement addNewCoursePgL;
		
		@FindBy(id="title")
		private WebElement newCourseTitL;
		
		@FindBy(id="advanced_params")
		private WebElement newCourseAdvanSettL;

		@FindBy(id="add_course_category_code")
		private WebElement addCourseCatCdL;
		
		@FindBy(id="add_course_wanted_code")
		private WebElement addCourseCdL;
		
		@FindBy(id="add_course_course_language")
		private WebElement addCourseLangL;
		
		@FindBy(id="add_course_submit")
		private WebElement addCourseSubmitL;
		
		@FindBy(xpath="//div[@class='help-course']/a/em")
		private WebElement addIntroL;
		
		@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
		private WebElement introFrameL;
		
		@FindBy(className="cke_editable cke_editable_themed cke_contents_ltr cke_show_borders")
		private WebElement introFrameEditL;

		@FindBy(name="intro_cmdUpdate")
		private WebElement introSaveL;
		
		
		@FindBy(className="alert alert-success")
		private WebElement addCoursePageSummAlertL;				
				
		
		//Click Create New Course link in Teacher Home page
		public boolean addNewCourseClickM()
		{
			boolean status_Flg=false;
			try{
				if(this.creCourseL.isDisplayed())
				{
					this.creCourseL.click();
					status_Flg=true;
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		

		@FindBy(name="title")
		private WebElement idl;
		
		//New Course Title Entered- parm Str title, return bool flag
		public boolean entAddNewCourseTitM(String newCourseTitVal)
		{
			boolean status_Flg=false;
			String newCourseTitRet = null;
			try{
				if(this.newCourseTitL.isDisplayed())
				{
					if(this.newCourseTitL.isDisplayed())
					{
						this.newCourseTitL.clear();
						this.newCourseTitL.sendKeys(newCourseTitVal);
						//this.newCourseTitL.click();
						//Thread.sleep(15000);
						//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
						//newCourseTitRet=this.newCourseTitL.getText();
						newCourseTitRet=this.newCourseTitL.getAttribute("value");
						System.out.println("retrieved value : "+newCourseTitRet);
						Assert.assertEquals(newCourseTitRet, newCourseTitVal);
						status_Flg=true;
					}
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		
		
		//Click Advanced Setting button in Add new course page
		public boolean addNewCourseAdvSettM()
		{
			boolean status_Flg=false;
			try{
				if(this.newCourseAdvanSettL.isDisplayed())
				{
					this.newCourseAdvanSettL.click();
					if(this.addCourseCatCdL.isDisplayed())
					{
						status_Flg=true;
					}
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		
		
		//New Course Category Entered- parm Str Category, return bool flag
		public boolean entAddNewCourseCatM(String newCourseCatVal)
		{
			boolean status_Flg=false;
			String newCourseCatRet = null;
			try{
				if(this.addCourseCatCdL.isDisplayed())
				{
					Select catCdSel=new Select(this.addCourseCatCdL);
					catCdSel.selectByVisibleText(newCourseCatVal);
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					//newCourseCatRet=this.newCourseTitL.getText();
					newCourseCatRet=this.newCourseTitL.getAttribute("value");
					Assert.assertEquals(newCourseCatRet, newCourseCatVal);
					status_Flg=true;
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		
		
		//New Course Code Entered- parm Str Code, return bool flag
		public boolean entAddNewCourseCdM(String newCourseCdVal)
		{
			boolean status_Flg=false;
			String newCourseCdRet = null;
			try{
				if(this.addCourseCdL.isDisplayed())
				{
					this.addCourseCdL.clear();
					this.addCourseCdL.sendKeys(newCourseCdVal);
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					//newCourseCdRet=this.addCourseCdL.getText();
					newCourseCdRet=this.addCourseCdL.getAttribute("value");
					Assert.assertEquals(newCourseCdRet, newCourseCdVal);
					status_Flg=true;
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		
		
		//New Course Language Selected - parm Str Category, return bool flag
		public boolean entAddNewCourseLangM(String newCourseLangVal)
		{
			boolean status_Flg=false;
			String newCourseLangRet = null;
			try{
				if(this.addCourseCatCdL.isDisplayed())
				{
					Select LangSel=new Select(this.addCourseCatCdL);
					LangSel.selectByVisibleText(newCourseLangVal);
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					newCourseLangRet=this.newCourseTitL.getAttribute("value");
					Assert.assertEquals(newCourseLangRet, newCourseLangVal);
					status_Flg=true;
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		
		
		//Click Create Course button in Add new course page
		public boolean addNewCourseSubM()
		{
			boolean status_Flg=false;
			try{
				if(this.addCourseSubmitL.isDisplayed())
				{
					this.addCourseSubmitL.click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Assert.assertTrue(addIntroL.isDisplayed(), "Course Creation successfull");
					System.out.println("Submit completed");
					status_Flg=true;
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}		
		
		//Course Summary page check - Add Intro
		public boolean addCourIntroClickM()
		{
			boolean status_Flg=false;
			try{
				if(this.addIntroL.isDisplayed())
				{
					this.addIntroL.click();
					//Assert.assertTrue(introFrameL.isDisplayed(), "Clicked Add Intro button");
					status_Flg=true;
					System.out.println("Add Intro frame displayed");
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		
		
		//Course Summary page - Enter Course Intro
		public boolean entNewCourIntroM(String newCourseIntroVal)
		{
			boolean status_Flg=false;
			String newCourseIntroRet = null;
			try{
				if(this.addIntroL.isDisplayed())
				{
				//Switch to Frame
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame(addIntroL);

				this.introFrameEditL.clear();
				this.introFrameEditL.sendKeys(newCourseIntroVal);
				newCourseIntroRet=this.introFrameEditL.getText();
				Assert.assertEquals(newCourseIntroRet, newCourseIntroVal);
				
				//Return to Parent Frame
				driver.switchTo().defaultContent();

				status_Flg=true;
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		
		//Course Summary page - Click Save Intro Button
		public boolean addCourIntroSaveClickM()
		{
			boolean status_Flg=false;
			try{
				if(this.introSaveL.isDisplayed())
				{
					this.introSaveL.click();
					Assert.assertTrue(addCoursePageSummAlertL.isDisplayed(), "Course Intro Text added successfull");
					status_Flg=true;
					System.out.println("Updated Introduction");
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return status_Flg;
		}
		
		
		
		
}