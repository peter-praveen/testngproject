package com.straive.pageexecution;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.straive.basepackage.BaseClass;
import com.straive.pagefactory.LoginPageFactory;

public class LoginPageExceution {
	private static Logger logger=LogManager.getLogger(LoginPageExceution.class);
	
	@BeforeClass
	public static void browserLaunch() {
		BaseClass.chromeLaunch();
	}

	@BeforeMethod
	public static void beforeLogin() {

		System.out.println("Login Executed");
	}
	
	@Test (groups= {"Smoke"})
	public void loginTest() throws IOException {
		logger.info("Test Started");
		BaseClass.launchURL(BaseClass.readProp("url"));
		String expected=BaseClass.getCurrentUrl();
		LoginPageFactory lp=new LoginPageFactory();
		BaseClass.sendKeys(lp.getUsernameBox(), BaseClass.readProp("userName"));
		BaseClass.sendKeys(lp.getPassWordBox(), BaseClass.readProp("password"));
		BaseClass.click(lp.getLoginBtn());
		String actual=BaseClass.getCurrentUrl();
		Assert.assertFalse(actual.equals(expected));
		
	}
	
}
