package com.straive.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.straive.basepackage.BaseClass;

public class LoginPageFactory extends BaseClass{
	public LoginPageFactory() {
	PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getUsernameBox() {
		return usernameBox;
	}

	public WebElement getPassWordBox() {
		return passWordBox;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	@FindBy (id="username")
	private WebElement usernameBox;
	

	@FindBy (id="password")
	private WebElement passWordBox;
	
	@FindBy (id="login")
	private WebElement loginBtn;

}
