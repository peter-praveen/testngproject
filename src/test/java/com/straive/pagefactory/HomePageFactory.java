package com.straive.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.straive.basepackage.BaseClass;

public class HomePageFactory extends BaseClass{
	public HomePageFactory() {
	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotels;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="room_nos")
	private WebElement noOfRooms;
	
	@FindBy(id="datepick_in")
	private WebElement dateIn;
	
	@FindBy(id="datepick_out")
	private WebElement dateOut;
	
	@FindBy(id="adult_room")
	private WebElement adultRoom;
	
	@FindBy(id="child_room")
	private WebElement childRoom;
	
	@FindBy(id="Submit")
	private WebElement searchBtn;
	
	@FindBy(id="Reset")
	private WebElement resetBtn;
	
	@FindBy(id="radiobutton_0")
	private WebElement selectBtn;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
		
	@FindBy(id="cancel")
	private WebElement cancelBtn;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address")
	private WebElement billingAddres;
	
	@FindBy(id="cc_num")
	private WebElement creditCardNum;
	
	@FindBy(id="cc_type")
	private WebElement credCarType;
	
	@FindBy(id="cc_exp_month")
	private WebElement cardExpireMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement cardExpireYear;
	
	@FindBy(id="cc_cvv")
	private WebElement cvvNum;
	
	@FindBy(id="book_now")
	private WebElement bookNowBtn;
	
	@FindBy(id="cancel")
	private WebElement bookCancel;
	
	@FindBy(id="my_itinerary")
	private WebElement myItinery;
	
	@FindBy(id="search_hotel")
	private WebElement searchHotel;
	
	@FindBy(id="logout")
	private WebElement logOut;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getDateIn() {
		return dateIn;
	}

	public WebElement getDateOut() {
		return dateOut;
	}

	public WebElement getAdultRoom() {
		return adultRoom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getBillingAddres() {
		return billingAddres;
	}

	public WebElement getCreditCardNum() {
		return creditCardNum;
	}

	public WebElement getCredCarType() {
		return credCarType;
	}

	public WebElement getCardExpireMonth() {
		return cardExpireMonth;
	}

	public WebElement getCardExpireYear() {
		return cardExpireYear;
	}

	public WebElement getCvvNum() {
		return cvvNum;
	}

	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}

	public WebElement getBookCancel() {
		return bookCancel;
	}

	public WebElement getMyItinery() {
		return myItinery;
	}

	public WebElement getSearchHotel() {
		return searchHotel;
	}

	public WebElement getLogOut() {
		return logOut;
	}
	
	
	
	
	
	

}
