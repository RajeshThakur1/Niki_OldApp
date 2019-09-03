package com.Niki_Old.AutomationConstants;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import generic.Property;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest implements AutomationConstants{
	
	public Logger log;
	//public static WebDriver driver;
	
	public static String un;
	public static String pw;
	public static String homePageURL;
	public static String loginPageURL;
	public static long timeout;
	public static URL url;
	
	public static String deviceName;
	public static String udid;
	public static String platformName;
	public static String platformVersion;
	public static String appPackage;
	public static String appActivity;
	
	public static String cardno;
	public static String nameOnCard;
	public static String expMonth;
	public static String expYear;
	public static String CVV;
	public static String version;
	
	public static AndroidDriver<WebElement> driver;
	
	public static boolean loginRequired=true;
	public static boolean logoutRequired=true;
	

	public BaseTest() {
		
		log=log.getLogger("LOg_ Logger");
		PropertyConfigurator.configure("Log4j.properties");
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}

	public void initFrameWork() throws MalformedURLException {
		log.info("initilizing framework");
		//url=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "URL");
		un=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "UN");
		//System.out.println(un);
		pw=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "PW");
		timeout=Long.parseLong(Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "IMPLICIT"));
		deviceName=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "deviceName");
		udid=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "udid");
		platformName=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "platformName");
		platformVersion=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "platFormVersion");
		appPackage=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "appPackage");
		appActivity=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "appActivity");
		
		cardno=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "cardNo");
		nameOnCard=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "NameOnCard");
		expMonth=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "expMonth");
		expYear=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "expYear");
		CVV=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "CVV");
		version=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "version");
		
	}
	
	
	@BeforeTest
	public void initApplication() throws Exception {
		initFrameWork();
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("udid", udid);
		caps.setCapability("platformName", platformName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("appPackage", appPackage);
		caps.setCapability("appActivity", appActivity);
		caps.setCapability("noReset", true);

		
		
		
		
		url= new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver<WebElement>(url,caps);
		//driver.manage().window().maximize();
		
		
		log.info("TimeOut:"+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public void relaunchApp() throws InterruptedException {
		driver.closeApp();
		Thread.sleep(2000);
		driver.launchApp();
	}

	
	
		
	
	

}
