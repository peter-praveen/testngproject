package com.straive.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.straive.basepackage.BaseClass;

public class SignUpPageFactory extends BaseClass {
	public SignUpPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (partialLinkText="New User Register Here")
	private WebElement newUserLink;
	
	@FindBy (id="username")
	private WebElement usernameBox;
	
	@FindBy (id="password")
	private WebElement passWordBox;
	
	@FindBy (id="login")
	private WebElement loginBtn;
	
	@FindBy (xpath="//*[@id='username']")
	private WebElement userName;
	
	@FindBy (xpath="//*[@id='password']")
	private WebElement password;
	
	@FindBy (xpath="//*[@id='re_password']")
	private WebElement repassword;
	
	@FindBy (xpath="//*[@id='full_name']")
	private WebElement fullName;
	
	@FindBy (xpath="//*[@id='email_add']")
	private WebElement email;
	
	@FindBy (xpath="//*[@id='tnc_box']")
	private WebElement checkBox; 
	
	@FindBy (id="Submit")
	private WebElement submitBtn;
	
	
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getClickLogin() {
		return clickLogin;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getRepassword() {
		return repassword;
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	
	@FindBy (partialLinkText="Click here to login")
	private WebElement clickLogin;


	public WebElement getNewUserLink() {
		return newUserLink;
	}

	public WebElement getUsernameBox() {
		return usernameBox;
	}

	public WebElement getPassWordBox() {
		return passWordBox;
	}

	
	
	
	
	
	
	

}
