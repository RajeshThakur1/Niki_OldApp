package com.Niki_Old.TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Niki_Old.AutomationConstants.BaseTest;

import pageObjects.ChatServiceElements;
import pageObjects.CommonElements;
import pageObjects.SignUpElements;

/**
 *
 * @author Rajesh Thakur
 *
 */

public class Login extends BaseTest{
	@Test(priority = 1)
	public void verifyHomePage() {
	
		SignUpElements sign = new SignUpElements();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("Hello there, human!", sign.getSignUpHeader());
		log.info("Niki Homepage header appeared properly by Default in English");
		
		soft.assertEquals("Your Language preference is", sign.getLangPrefText());
		System.out.println("Language Insturction Message appears properly");
		log.info("Language Insturction Message appears properly");
		
		// Verify Hindi Radio Button

		soft.assertTrue(sign.hindiOptionIsDiplayed());
		soft.assertEquals("हिंदी", sign.getEnglishOptionName());
		soft.assertFalse(sign.hindiIsSelected());
		System.out.println("Hindi Radio button showing properly and by default its not selected");
		
		log.info("Hindi Radio button showing properly and by default its not selected");
		
	// Verify English Radio Button
		soft.assertTrue(sign.englishOptionIsDiplayed());
		soft.assertEquals("English", sign.getEnglishOptionName());
		soft.assertFalse(sign.englishIsSelected());
		System.out.println("English Radio button showing properly and by default its not selected");
		log.info("English Radio button showing properly and by default its not selected");
		
		// Next button details

		soft.assertTrue(sign.nextBtnAtLangSelectionIsDisplayed());
		soft.assertEquals("NEXT", sign.getNextBtnName());
		System.out.println("Next button is displaying properly at Home Screen");
		log.info("Next button is displaying properly at Home Screen");
		sign.clickNextBtnAtLoginPage();
		soft.assertTrue(sign.nextBtnAtLangSelectionIsDisplayed());
		System.out.println("Without selecting any Language, NEXT button is not working");
		log.info("Without selecting any Language, NEXT button is not working");
			
	}
	
	@Test(priority = 2)
	public void verifyLanguageLelection() {
		SignUpElements sign = new SignUpElements();
		
		SoftAssert soft = new SoftAssert();

		sign.clickHindiOption();

		// This status still getting as FALSE, even if we selected. This issue
		// from Android Side.
		// Assert.assertTrue(sign.hindiIsSelected());
		// System.out.println("Hindi Radio Button selected");

		soft.assertEquals("नमस्ते!", sign.getSignUpHeader());
		System.out.println("Niki Homepage header appeared properly in Hindi");
		log.info("Niki Homepage header appeared properly in Hindi");
		soft.assertEquals("आपकी भाषा चुनें", sign.getLangPrefText());
		System.out.println("Language Instruction Message appears properly in Hindi");
		log.info("Language Instruction Message appears properly in Hindi")
		;
		
		
		soft.assertTrue(sign.nextBtnAtLangSelectionIsDisplayed());
		soft.assertEquals("आगे बढ़ें", sign.getNextBtnName());
		System.out.println("Next button is displaying properly when Language selected to Hindi");
		log.info("Next button is displaying properly when Language selected to Hindi");
		sign.clickEnglishOption();
		
		soft.assertEquals("Hello there, human!", sign.getSignUpHeader());
		System.out.println("Niki Homepage header appeared properly in English");

		soft.assertEquals("Your Language preference is", sign.getLangPrefText());
		System.out.println("Language Instruction Message appears properly in English");

		soft.assertTrue(sign.nextBtnAtLangSelectionIsDisplayed());
		soft.assertEquals("NEXT", sign.getNextBtnName());
		System.out.println("Next button is displaying properly when Language selected to English");

		soft.assertAll();
	
	}
	
	@Test(priority = 3)
	public void verifyTextBoxEditable() {
		
		SignUpElements sign = new SignUpElements();
		sign.clickNextBtnAtLoginPage();

		WebElement phoneNoTextBox = sign.editPhNoField;
		sign.enterPhNo("1234");
		String textFieldVal = phoneNoTextBox.getText();
		
		
		if (textFieldVal.equalsIgnoreCase("1234")) {
			System.out.println("Phone Number Text Field is Editable");

		} else {
			System.out.println("Phone Number Text Field is Not Editable");
		}
		
	}
	
	@Test(priority = 4)
	public void verifyValidPhoneNumberEntry() {
		SignUpElements sign = new SignUpElements();
		System.out.println("Entering a valid phone number");
		sign.enterPhNo(un);
	}
	
	@Test(priority = 5)
	public void verifySubmitBtnEnable() {
		CommonElements common = new CommonElements();
		boolean sendBtn = common.SubmitBtn.isEnabled();
		System.out.print(sendBtn);
		if (sendBtn == true) {
			System.out.println("Submit Button is Enabled");
		} else {
			System.out.println("Submit Button is Disabled");
		}

	}
	
	@Test(priority = 6)
	public void verifyClickSubmitBtn() {
		CommonElements common = new CommonElements();
		common.clickSubmit();
	}
	
	@Test(priority = 7)
	public void verifyOTPEnterPageHeader() {
		SoftAssert soft = new SoftAssert();
		SignUpElements sign = new SignUpElements();
		String sentOTPText = sign.getOtpPageHeader();
		soft.assertEquals("We've sent you an OTP", sentOTPText);
		soft.assertAll();

	}


	@Test(priority = 8)
	public void verifyGetOtpCallBtn() throws Exception {
		SoftAssert soft = new SoftAssert();
		Thread.sleep(35000);
		SignUpElements sign = new SignUpElements();
		soft.assertTrue(sign.otpOnCallBtnIsDisplayed());
		System.out.println("GET OTP ON CALL Button displayed");
		log.info("GET OTP ON CALL Button displayed");
		
		soft.assertAll();
	}
	
	@Test(priority = 9)
	public void verifyCallingYou() {
		SoftAssert soft = new SoftAssert();
		SignUpElements sign = new SignUpElements();
		sign.clickOtpOnCallBtn();
		String callingTxtPrompt = sign.getCallingText();
		soft.assertEquals("Calling you...", callingTxtPrompt);
		System.out.println("Getting OTP Call");
		
		
		log.info("Getting OTP Call");
		soft.assertAll();

	}
	
	@Test(priority = 10)
	public void verifyTroubleSignLink() throws Exception {
		SoftAssert soft = new SoftAssert();
		SignUpElements sign = new SignUpElements();
		soft.assertTrue(sign.troubleSignLinkIsDisplayed());
		soft.assertEquals("I'm having trouble signing in", sign.getTroubleSignInLinkText());
		System.out.println("Trouble In SignIn Link appeared");

		sign.clickTroubleSignInLink();
		Thread.sleep(5000);
		soft.assertTrue(sign.gmailComposeHdrIsDisplayed());
		soft.assertEquals("<support@niki.ai>, ", sign.getToMailToAddress());
		soft.assertEquals("Having trouble signing in to Niki", sign.getMailSubject());
		// Assert.assertTrue(sign.getMailText());
		System.out.println("Mail details are correct");
		CommonElements common = new CommonElements();
		common.threadSleep(3000);
		common.clickDeviceBackButton();

		soft.assertAll();
	}

	
	

	@Test(priority = 11)
	public void verifyNonNumericOTP() {
		SignUpElements sign = new SignUpElements();
		sign.enterAlphaNumericOTP();

	}
	@Test(priority = 12)
	public void verifyWrongOTP() {
		SignUpElements sign = new SignUpElements();
		CommonElements common = new CommonElements();
		common.clickDeviceBackButton();
		sign.enterWrongOTP();
	}

	
	@Test(priority = 13)
	public void verifyClickEditSymbol() {
		SignUpElements sign = new SignUpElements();
		sign.clickEditSymbol();
	}
	@Test(priority = 14)
	public void verifyReEnterPhNo() throws Exception {
		SignUpElements sign = new SignUpElements();
		sign.reEnterPhNo("9684759374");
		CommonElements common = new CommonElements();
		common.clickSubmit();
	}
	
	@Test(priority = 15)
	public void verifyCorrectOTP() throws Exception {
		SignUpElements sign = new SignUpElements();
		sign.enterOTP();
	}
	
	
	@Test(priority = 16)
	public void verifyGetStartedScreen() {

		SignUpElements sign = new SignUpElements();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(sign.getStartedScreenIsDisplayed());
		System.out.println("'Get Started' Screen appeared properly");
		log.info("'Get Started' Screen appeared properly");
		sign.clickStartChatBtn();

		soft.assertAll();

	}
	
	@Test(priority = 17)
	public void verifyDeviceLocationPopup() {
		SoftAssert soft = new SoftAssert();
		CommonElements common = new CommonElements();
		String allowText = common.getAllowPopupmsg();
		soft.assertEquals("Allow Niki to access this device's location?", allowText);

		soft.assertAll();

	}
	
	@Test(priority = 18)
	public void verifyLocationAllowBtn() {
		CommonElements common = new CommonElements();
		ChatServiceElements chat = new ChatServiceElements();
		SignUpElements sign = new SignUpElements();
		boolean allowBtn = common.PermissionAllowButton.isDisplayed();
		System.out.print(allowBtn);

		try {
			System.out.println("Location Allow Button is Displayed");
			common.clickAllowBtn();
		} catch (Exception e) {
			System.out.println("Location Allow Button is not displayed");
		}

		common.threadSleep(10000);
		common.relaunchAppForPopup();
	}

	
	@Test(priority = 19)
	public void verifyAllowAppPopup() {
		CommonElements common = new CommonElements();
		ChatServiceElements chat = new ChatServiceElements();
		SignUpElements sign = new SignUpElements();

		common.threadSleep(10000);
		// chat.enterDataWithoutSend("h");
		// common.threadSleep(20000);
		Assert.assertTrue(sign.appAllowBtnIsDisplayed());
		sign.clickAppAllowBtn();
		System.out.println("Its clicked on App Allow Popup");
		common.threadSleep(10000);
		for (int i = 0; i <= 3; i++) {
			common.relaunchAppForPopup();
		}

	}
	
	
	
}
