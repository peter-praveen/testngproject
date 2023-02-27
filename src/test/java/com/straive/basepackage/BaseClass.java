package com.straive.basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static void chromeLaunch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	public static void launchURL(String url) {
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void click(WebElement element) {
		element.click();
	}
	
	public static void sendKeys(WebElement element, String keys) {
		element.sendKeys(keys);
	}
	public static void submit(WebElement element) {
		element.submit();
		}
	public static void dragAndDrop(WebElement src, WebElement trgt) {
	Actions act=new Actions(driver);
		act.dragAndDrop(src, trgt).build().perform();
			}
	public static void contextClick(WebElement elem) {
		Actions act=new Actions(driver);
		act.contextClick(elem);
	}
	public static void scrollByFind(WebElement elem) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(false)", elem);
	}
	public static boolean isVisbile(WebElement elem) {
		return elem.isDisplayed();
	}
	public static String getPageTitle() {
		return driver.getTitle();
	}
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public  static String getText(WebElement elem) {
		return elem.getText();
		
	}
	
	public static void takeScreenshot() throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File fl=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fl, new File("C:\\Users\\Peter Praveen\\Desktop\\ProjectOutput\\Adactin\\ScreenShot"+System.currentTimeMillis()+".png"));
	System.out.println("Screenshot is Taken");
	}
	
	public static String readExcel(String sheet,int x, int y) throws IOException {
		File fl=new File("C:\\Users\\Peter Praveen\\Desktop\\ProjectOutput\\Adactin\\Credentials.xlsx");
		FileInputStream fis=new FileInputStream(fl);
		Workbook wk=new XSSFWorkbook(fis);
		Sheet sht=wk.getSheet(sheet);
		Row rw=sht.getRow(x);
		Cell cell=rw.getCell(y);
		return cell.getStringCellValue();
	}
	
	public static String readProp(String key) throws IOException {
		File fl=new File("C:\\Users\\Peter Praveen\\eclipse-workspace\\TestNG-Project\\src\\test\\resources\\Credentials.properties");
		FileInputStream fis=new FileInputStream(fl);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public static void selectByValue(WebElement elem, String value) {
		Select slct=new Select(elem);
		slct.selectByValue(value);
		
	}
	
	public static void selectByIndex(WebElement elem, int index) {
		Select slct=new Select(elem);
		slct.selectByIndex(index);
		
	}
	
	public static void clearElement(WebElement elem) {
		elem.clear();
	}
	
	public static void close() {
		driver.close();
	}
	
	
	
	

}
