package com.straive.pageexecution;

import java.io.IOException;

import org.apache.commons.codec.net.BCodec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.straive.basepackage.BaseClass;
import com.straive.pagefactory.HomePageFactory;
import com.straive.pagefactory.LoginPageFactory;

@Listeners({ListenersImp.class})
public class HomePageExecution {
	private static Logger logs=LogManager.getLogger(HomePageExecution.class);
	private static ExtentHtmlReporter rep=new ExtentHtmlReporter("ExtentReport.html");
	private static ExtentReports ext=new ExtentReports();
	
	
	@BeforeClass
	public static void browserLaunch() {
		ext.attachReporter(rep);
		BaseClass.chromeLaunch();
		logs.info("Homepage Test Execution has Started");
	}
	
	@Test (groups= {"Smoke", "Regression"})
	public void bookingLoginTest() {
		ExtentTest LoginForBooking = ext.createTest("Login for Booking");
		try {
		BaseClass.launchURL(BaseClass.readExcel("Sheet1", 0, 0));
		LoginPageFactory lpf=new LoginPageFactory();
		BaseClass.sendKeys(lpf.getUsernameBox(), BaseClass.readProp("userName"));
		BaseClass.sendKeys(lpf.getPassWordBox(), BaseClass.readProp("password"));
		BaseClass.click(lpf.getLoginBtn());
		LoginForBooking.pass("Login is Done successfully");
		}catch(Exception e) {
			
			LoginForBooking.error("The exception is "+e);	
		}
	}
	
	@Test (dependsOnMethods="bookingLoginTest", groups= {"Smoke", "Regression"})
	public void bookingTest() {
		ExtentTest BookingDetails = ext.createTest("Booking details");
		try {
			
		HomePageFactory hp=new HomePageFactory();
		BaseClass.selectByValue(hp.getLocation(), BaseClass.readExcel("Sheet1", 1, 0));
		BaseClass.selectByValue(hp.getHotels(), BaseClass.readExcel("Sheet1", 2, 0));
		BaseClass.selectByValue(hp.getRoomType(), BaseClass.readExcel("Sheet1", 3, 0));
		BaseClass.selectByIndex(hp.getNoOfRooms(), 2);
		BaseClass.clearElement(hp.getDateIn());
		BaseClass.sendKeys(hp.getDateIn(), BaseClass.readExcel("Sheet1", 4, 0));
		BaseClass.clearElement(hp.getDateOut());
		BaseClass.sendKeys(hp.getDateOut(), BaseClass.readExcel("Sheet1", 5, 0));
		BaseClass.selectByIndex(hp.getAdultRoom(), 2);
		BaseClass.selectByIndex(hp.getChildRoom(), 1);
		BaseClass.click(hp.getSearchBtn());
		BaseClass.click(hp.getSelectBtn());
		BaseClass.click(hp.getContinueBtn());
		BookingDetails.pass("Booking is done");
		
		
		}catch(Exception  e) {
			System.out.println("The exception is "+e);
			logs.error("Exception occured as "+e);
			BookingDetails.equals("Exception is "+e);
			
		}
	}
	
	
	@Test (dependsOnMethods="bookingTest", groups= {"Smoke", "Regression"})
	public void billingTest() {
		ExtentTest BillingDetails = ext.createTest("Billing details");
		try {
		HomePageFactory hp=new HomePageFactory();
		BaseClass.sendKeys(hp.getFirstName(), BaseClass.readExcel("Sheet1", 6, 0));
		BaseClass.sendKeys(hp.getLastName(), BaseClass.readExcel("Sheet1", 7, 0));
		BaseClass.sendKeys(hp.getBillingAddres(), BaseClass.readExcel("Sheet1", 8, 0));
		BaseClass.scrollByFind(hp.getBookNowBtn());
		BaseClass.sendKeys(hp.getCreditCardNum(), BaseClass.readExcel("Sheet1", 9, 0));
		BaseClass.selectByValue(hp.getCredCarType(), BaseClass.readExcel("Sheet1", 10, 0));
		BaseClass.selectByValue(hp.getCardExpireMonth(), BaseClass.readExcel("Sheet1", 11, 0));
		BaseClass.selectByValue(hp.getCardExpireYear(), BaseClass.readExcel("Sheet1", 12, 0));
		BaseClass.sendKeys(hp.getCvvNum(), BaseClass.readExcel("Sheet1", 13, 0));
		BaseClass.click(hp.getBookNowBtn());		
		BaseClass.scrollByFind(hp.getLogOut());
		BaseClass.takeScreenshot();
		Assert.assertTrue(BaseClass.isVisbile(hp.getMyItinery()));
		BaseClass.click(hp.getLogOut());
		logs.info("Hotel Booking is completed !!!");
		BillingDetails.pass("Hotel Booking is completed !!! ");
		}catch(Exception  e) {
			System.out.println("The exception is "+e);
			logs.error("Exception occured as "+e);
			BillingDetails.error("Exception occured as "+e);
			
			
		}
		
	}
	
	@AfterClass
	public static void closeBrowser() {
		BaseClass.close();
		logs.info("Hompage Test Execution has Ended");
		ext.flush();
		
		
	}
	
	

}
