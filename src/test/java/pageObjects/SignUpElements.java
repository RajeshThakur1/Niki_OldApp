package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nilki_Old.CommonPage.BasePage;

public class SignUpElements extends BasePage{
	public SignUpElements() {
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log= Logger.getLogger(SignUpElements.class);
	
	
	@FindBy(id = "com.techbins.niki:id/hellohuman")
	public WebElement helloHumanText;

	//com.techbins.niki:id/hellohuman
	// It will get text and print

	public String getSignUpHeader() {
		waitTillElementIsVisible(helloHumanText);
		String helloHumanHeader = helloHumanText.getText();
		return helloHumanHeader;

	}
	
	
	@FindBy(id = "com.techbins.niki:id/labelLangauagePreference")
	public WebElement langPrefText;

	public String getLangPrefText() {
		waitTillElementIsVisible(langPrefText);
		String langText = langPrefText.getText();
		return langText;
	}

	//Hindi radio Button
	
	@FindBy(id = "com.techbins.niki:id/hindiRadioButton")
	public WebElement hindiRadio;

	public boolean hindiOptionIsDiplayed() {
		waitTillElementIsVisible(hindiRadio);
		boolean englishOptionStatus = hindiRadio.isDisplayed();
		return englishOptionStatus;
	}
	
	@FindBy(id = "com.techbins.niki:id/englishRadioButton")
	public WebElement englishRadio;

	public String getEnglishOptionName() {
		waitTillElementIsVisible(englishRadio);
		String hindiLabelText = englishRadio.getText();
		return hindiLabelText;
	}
	
	public boolean hindiIsSelected() {
		waitTillElementIsVisible(hindiRadio);
		boolean englishRadioStatus = hindiRadio.isSelected();
		return englishRadioStatus;
	}

	public boolean englishOptionIsDiplayed() {
		waitTillElementIsClickable(englishRadio);
		boolean englishOptionStatus = englishRadio.isDisplayed();
		return englishOptionStatus;
	}

	public boolean englishIsSelected() {
		boolean englishRadioStatus = englishRadio.isSelected();
		return englishRadioStatus;
	}
	
	@FindBy(id = "com.techbins.niki:id/languageSelectorNextBtn")
	public WebElement nxtBtnLangPage;

	public boolean nextBtnAtLangSelectionIsDisplayed() {
		waitTillElementIsVisible(nxtBtnLangPage);
		boolean nextBtnStatus = nxtBtnLangPage.isDisplayed() && nxtBtnLangPage.isEnabled();
		return nextBtnStatus;
	}

	public String getNextBtnName() {
		
		String nxtBtnTxt = nxtBtnLangPage.getText();
		return nxtBtnTxt;
	}

	public void clickNextBtnAtLoginPage() {
		nxtBtnLangPage.click();

	}

	public void clickHindiOption() {
		hindiRadio.click();
	}
	
	public void clickEnglishOption() {
		englishRadio.click();
	}

	
	@FindBy(id = "com.techbins.niki:id/edtTxtPhone")
	public WebElement editPhNoField;
	
	public void enterPhNo(String phNo) {
		editPhNoField.clear();
		editPhNoField.sendKeys(phNo);
		log.info("Phone Number Entered -"+phNo);
		System.out.println("Entered Phone Number");
	}
	
	@FindBy(id = "com.techbins.niki:id/txtViewSMSLabel")
	public WebElement sentOTPHeader;
	
	public String getOtpPageHeader() {
		String sentOtpTxt = sentOTPHeader.getText();
		System.out.println("Header On Sent OTP Page " + sentOtpTxt);
		log.info("Header On Sent OTP Page "+ sentOtpTxt);
		
		return sentOtpTxt;
	}
	
	@FindBy(id = "com.techbins.niki:id/getOtpOnCall")
	public WebElement otpOnCallBtn;
	
	public boolean otpOnCallBtnIsDisplayed() {
		boolean otpOnCallBtnStatus = otpOnCallBtn.isDisplayed();
		return otpOnCallBtnStatus;
	}
	
	public void clickOtpOnCallBtn() {
		otpOnCallBtn.click();
	}

	
	@FindBy(id = "com.techbins.niki:id/txtCallTime")
	public WebElement callingYouTxt;

	public String getCallingText() {
		String callingTxtDsply = callingYouTxt.getText();
		return callingTxtDsply;
	}
	
	@FindBy(id = "com.techbins.niki:id/txtOTPError")
	public WebElement troubleSignLink;
	
	public boolean troubleSignLinkIsDisplayed() {
		boolean troubleSignLinkStatus = troubleSignLink.isDisplayed();
		return troubleSignLinkStatus;
	}
	
	public void clickTroubleSignInLink() {
		troubleSignLink.click();
		System.out.println("Clicked on Trouble in SignIn Link");
	}

	
	@FindBy(xpath = "//android.widget.TextView[@text='Compose']")
	public WebElement composeMailHdr;

	
	public boolean gmailComposeHdrIsDisplayed() {
		boolean composeMailTxtStatus = composeMailHdr.isDisplayed();
		return composeMailTxtStatus;
	}
	
	public String getTroubleSignInLinkText() {
		String troubleSignLinkName = troubleSignLink.getText();
		return troubleSignLinkName;
	}

	@FindBy(id = "com.google.android.gm:id/to")
	public WebElement mailToAddress;
	
	public String getToMailToAddress() {
		String mailToAdrsTxt = mailToAddress.getText();
		return mailToAdrsTxt;
	}
	
	@FindBy(id = "com.google.android.gm:id/subject")
	public WebElement mailSubject;

	public String getMailSubject() {
		String mailSubText = mailSubject.getText();
		return mailSubText;
	}
	
	@FindBy(id = "com.techbins.niki:id/editTxtOtpCode")
	public WebElement otpTxtBox;
	
	public void enterWrongOTP() {
		otpTxtBox.clear();
		otpTxtBox.sendKeys("482");
		System.out.println("Entered OTP");
		log.info("Wrong OTP entered");
	}
	

	public void enterAlphaNumericOTP() {
		otpTxtBox.clear();
		otpTxtBox.sendKeys("SIV5");
		String alphaOtp = otpTxtBox.getText();
		if (alphaOtp.equalsIgnoreCase("SIV5")) {
			System.out.println("This text box allows Alpha Numeric Keyboard which is not expected");
			log.info("This text box allows Alpha Numeric Keyboard which is not expected");
		} else {
			System.out.println("Alpha Numeric Key not allowed");
			log.info("Alpha Numeric Key not allowed");
		}

	}
	
	@FindBy(id = "com.techbins.niki:id/txtWrongNumber")
	public WebElement editOptionPhNo;
	
	public void clickEditSymbol() {
		System.out.println("User wants to change the phone number");
		log.info("User wants to change the phone number");
		editOptionPhNo.click();
	}
	
	public void reEnterPhNo(String phNo) throws Exception {
		editPhNoField.clear();
		editPhNoField.sendKeys(phNo);
		System.out.println("Re Entered Phone Number");
		log.info("Re Entered Phone Number");
		// CommonElements common = new CommonElements(driver);
		// common.threadSleep(5000);

		Thread.sleep(5000);
		/*
		 * CommonElements common=new CommonElements(driver);
		 * common.clickSubmit(); Thread.sleep(4000);
		 */

	}
	
	public void enterOTP() {
		otpTxtBox.clear();
		otpTxtBox.sendKeys("4862");
		System.out.println("Entered OTP");
		log.info("Entered OTP");
	}
	
	@FindBy(id = "com.techbins.niki:id/introBackgroundImage")
	public WebElement startChattingButton;

	public boolean getStartedScreenIsDisplayed() {
		boolean startedBtnStatus = startChattingButton.isDisplayed();
		return startedBtnStatus;
	}
	
	public void clickStartChatBtn() {
		startChattingButton.click();
	}
	
	@FindBy(id = "com.techbins.niki:id/btnAllow")
	public WebElement appAllowBtn;

	public boolean appAllowBtnIsDisplayed() {
		boolean allowBtnStatus = appAllowBtn.isDisplayed();
		return allowBtnStatus;
	}
	
	public void clickAppAllowBtn() {
		appAllowBtn.click();
		System.out.println("App Allow Button Clicked");
		
		log.info("App Allow Button Clicked");
	}

	
}
