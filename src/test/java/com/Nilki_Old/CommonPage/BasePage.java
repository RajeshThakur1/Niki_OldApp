package com.Nilki_Old.CommonPage;


import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.Niki_Old.AutomationConstants.AutomationConstants;
import com.Niki_Old.AutomationConstants.BaseTest;

import generic.Property;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class BasePage {

	public Logger log=Logger.getLogger(this.getClass());
	public AndroidDriver<WebElement> driver;
	public String configFile;
	public long timeout;
	
	public BasePage() {
		this.driver=BaseTest.driver;
		configFile=AutomationConstants.CONFIG_PATH+AutomationConstants.CONFIG_FILE;
		timeout=Long.parseLong(Property.getPropertyValue(configFile, "EXPLICIT"));
		
	}
	
	public void waitTillElementIsVisible(WebElement Element)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(Element));
	}
	
	public void waitTillElementIsVisible(List<WebElement> Element)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(Element));
	}
	
	
	public void verifyURLis(String expectedUrl)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(expectedUrl));
		
	}
	
	 public boolean verifyURLhas(String expectedURL) {
		 return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(expectedURL));
		 
	 }
	 
	 public void moveToElement(WebElement element) {
		 Actions actions=new Actions(driver);
		 actions.moveToElement(element).perform();
	 }
	 
	 public boolean isElementdisPlayed(WebElement element) {
		 try {
			element.isDisplayed();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("element is not displayed Exception "+e.getMessage());
			return false;
		}
	 }
	
	 
	 
	 public void waitTillElementIsClickable(WebElement element)
		{
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		}
	 
	 public boolean isButtonEnable(WebElement element) {
		 return element.isEnabled();
	 }
	 
	 public boolean isTestElementDisplayed(WebElement element) {
		 try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	 }
	 
	 
	 
	 
	 /*
	 
	 public void assertion() {
		 
		 SoftAssert soft = new SoftAssert();
		 ChatPageHeader header = new ChatPageHeader(driver);
		 header.clickProfileButton();

		 ProfileElements profile = new ProfileElements(driver);

		 soft.assertTrue(profile.aboutLinkIsDisplayed());
		 System.out.println("'हमारी जानकारी' Link Displays");

		 soft.assertEquals("हमारी जानकारी", profile.getAboutLinkText());
		 System.out.println("'हमारी जानकारी' Link Name is displays correct name");

		 profile.clickAbout();
		 Thread.sleep(3000);
		 CommonElements common = new CommonElements(driver);
		 soft.assertEquals("हमारी जानकारी", common.getProfileElementHeader());
		 System.out.println("हमारी जानकारी  Link is working fine");

		 common.threadSleep(4000);

		 soft.assertAll();

		 
		 
		 
	 }
	 
	 
	 
	 /*
	 
	 public void convertToHindi() {
			String header=getSignUpHeader();
			char[] stringToCharArray=header.toCharArray();
			int length=stringToCharArray.length;
			//int i;
			
			System.out.println(header.charAt(0));
			
				System.out.println(stringToCharArray);
				
		
		}
	 */
	 
	 public String[] getAllOptionArray(List<WebElement> elements) {
		 waitTillElementIsVisible(elements);
		 String[] allOption = new String[elements.size()];
		 
		 for (int i = 0; i < elements.size(); i++) {
			WebElement element=elements.get(i);
			allOption[i]=element.getText();
		}
		 return allOption;
	 }
	
	 public void isPerticularTextPresent(String actualText,String expectedText) {
 		 if(actualText.contains(expectedText)) {
			 log.info(expectedText+" has varified");
		 }
		 else {
			 log.warn(expectedText+" Is not verified");
		 }
		 
	 }
	 
	 public void verifyAckMsg(WebElement element,String expectedText) {
		 waitTillElementIsVisible(element);
		 String actualText=element.getText();
		 SoftAssert soft = new SoftAssert();
		 soft.assertEquals(actualText, actualText);
		 log.info("Acknoledgement Message-"+actualText+" is Verified");
		 soft.assertAll();
		 
	 }
	 
	 public void VerifyGuidenceMsg(WebElement element, String expecedText) {
		 waitTillElementIsVisible(element);
		 String actualText=element.getText();
		 SoftAssert soft = new SoftAssert();
		 soft.assertEquals(actualText, actualText);
		 log.info("Guidence Message-"+actualText+" is Verified");
		 soft.assertAll();
	 }
	 
	 public void veriFyAnyText(WebElement element,String expectedText) {
		 
		 waitTillElementIsVisible(element);
		 String actualText=element.getText();
		 SoftAssert soft = new SoftAssert();
		 
		 soft.assertEquals(actualText, expectedText);
		 log.info(expectedText+" Is verified");
		 
		 
		 
	 }
	 
	 public void displayAlloptions(List<WebElement> elements,String[] allPlanText) {
		 waitTillElementIsVisible(elements);
			//String[] allPlansText=getAllOptionArray(elements);
			for (int i = 0; i < elements.size(); i++) {
				WebElement plan=elements.get(i);
				String planText=plan.getText();
				if(planText.contains(allPlanText[i])) {
					log.info(plan);
					
				}
				else {
					log.warn("Plans Is not displaying");
				}
				
			}
	 }
	 
	 

	
	
}
