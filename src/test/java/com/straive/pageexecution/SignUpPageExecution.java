package com.straive.pageexecution;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.straive.basepackage.BaseClass;
import com.straive.pagefactory.SignUpPageFactory;


public class SignUpPageExecution {
	private static Logger logs=LogManager.getLogger(SignUpPageExecution.class);

	
	@BeforeClass
	public static void browserLaunch() {
		BaseClass.chromeLaunch();
		logs.info("Signup Test Execution has Started");
	}
	
	@AfterClass
	public static void closeBrowser() {
		BaseClass.close();
		logs.info("Signup Test Execution has Ended");
		
		
	}
	
	
	
	@Test (enabled=false)
	public void testSample() {
		System.out.println("Sample");
		try {
			BaseClass.launchURL(BaseClass.readExcel("Sheet1", 0, 0));

		} catch (Exception e) {
			System.out.println(e);
		}
		}
	
	
	

	
	
	@DataProvider (name="Login Test creds")
	public Object[][] creds(){
		return new Object[][]{
			{"Peter", "peter0123"},
			{"Praveen", "praveen1234"}
			};
	}
	
	
	@Test
	public void loginTest(String userName, String passWord)  {
		try {
			
		BaseClass.launchURL(BaseClass.readExcel("Sheet1", 0, 0));
		String signUrl=BaseClass.readExcel("Sheet1", 0, 0);
		SignUpPageFactory spf=new SignUpPageFactory();
		BaseClass.sendKeys(spf.getUsernameBox(), userName);
		BaseClass.sendKeys(spf.getPassWordBox(), passWord);
		BaseClass.click(spf.getLoginBtn());
		Assert.assertEquals(signUrl, BaseClass.getCurrentUrl());
		}catch(Exception  e) {
			System.out.println("The exception is "+e);
			logs.error("Exception occured as "+e);
			
		}
	}
	
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void signUpTest() {
		try {
		SignUpPageFactory spf=new SignUpPageFactory();
		BaseClass.launchURL(BaseClass.readExcel("Sheet1", 0, 0));
		BaseClass.click(spf.getNewUserLink());
		String actual=BaseClass.getCurrentUrl();
		Assert.assertFalse(BaseClass.readExcel("Sheet1", 0, 0).equals(BaseClass.getCurrentUrl()));
		BaseClass.sendKeys(spf.getUserName(), BaseClass.readProp("userName"));
		BaseClass.sendKeys(spf.getPassword(), BaseClass.readProp("password"));
		BaseClass.sendKeys(spf.getRepassword(), BaseClass.readProp("password"));
		BaseClass.sendKeys(spf.getFullName(), BaseClass.readProp("fullName"));
		BaseClass.sendKeys(spf.getEmail(), BaseClass.readProp("email"));
		Thread.sleep(8000); //captcha time
		BaseClass.click(spf.getCheckBox());
		BaseClass.click(spf.getSubmitBtn());
		String expected=BaseClass.getCurrentUrl();
		Assert.assertFalse(true);
		logs.info("SignUp Test is Completed succesfully");
		}catch(Exception  e) {
			System.out.println("The exception is "+e);
			logs.error("Exception occured as "+e);
			
		}
		
	}
	
	
}
