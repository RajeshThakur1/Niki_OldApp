package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nilki_Old.CommonPage.BasePage;

public class ProfileElements extends BasePage{
	
	
	public ProfileElements() {
		PageFactory.initElements(driver, this);
		
	}
	public static Logger log= Logger.getLogger(ProfileElements.class);
	
	@FindBy(id = "com.techbins.niki:id/needHelp")
	public WebElement aboutLink;

	public boolean aboutLinkIsDisplayed() {
		boolean aboutLinkStatus = aboutLink.isDisplayed();
		return aboutLinkStatus;
	}
	
	public String getAboutLinkText() {
		String aboutText = aboutLink.getText();
		return aboutText;
	}
	
	public void clickAbout() {
		System.out.println("Cliking on ABOUT Link");
		aboutLink.click();
	}
	
	@FindBy(id = "com.techbins.niki:id/versionCode")
	public WebElement appVersionNo;

	public String getAppVersion() {
		String appVersion = appVersionNo.getText();
		return appVersion;
	}
	
	@FindBy(id = "com.techbins.niki:id/rightsreserved")
	public WebElement copyRightTxt;

	public String getCopyRightTxt() {
		String copyRightMsg = copyRightTxt.getText();
		return copyRightMsg;
	}
	
	
	@FindBy(xpath = "//android.widget.TextView[@text='Crafted with ❤ in India.']")
	public WebElement craftIndMsg;

	public String getCraftIndMsg() {
		String craftIndTxt = craftIndMsg.getText();
		return craftIndTxt;
	}
	
	@FindBy(id = "com.techbins.niki:id/howNikiWorksContainer")
	public WebElement howNikiWorksLinkTab;

	public boolean howNikiWorkLinkIsDisplayed() {
		boolean howNikiLinkiStatus = howNikiWorksLinkTab.isDisplayed();
		return howNikiLinkiStatus;
	}
	
	public void clickAboutHowNikiWorksLink() {
		waitTillElementIsClickable(howNikiWorksLinkTab);
		howNikiWorksLinkTab.click();
	}
	
	@FindBy(xpath = "//android.view.View[@text='Reach Support']")
	public WebElement supportHeading;

	public String getSupportHeading() {
		waitTillElementIsVisible(supportHeading);
		String supportHeaderTxt = supportHeading.getText();
		return supportHeaderTxt;
	}
	
	@FindBy(id = "com.techbins.niki:id/termsAndConditionsContainer")
	public WebElement termsConditionLinkTab;

	public boolean termsConditionLinkIsDisplayed() {
		boolean tandcLinkiStatus = termsConditionLinkTab.isDisplayed();
		return tandcLinkiStatus;
	}
	
	public void clickTermsCondtionLink() {
		termsConditionLinkTab.click();
	}
	
	@FindBy(xpath = "//android.view.View[@text='TERMS & CONDITIONS']")
	public WebElement termscondhdr;

	public boolean termsAndCondHdrIsDisplayed() {
		waitTillElementIsVisible(termscondhdr);
		boolean termsHdrStatus = termscondhdr.isDisplayed();
		return termsHdrStatus;
	}

	@FindBy(id = "com.techbins.niki:id/partnerWithUsContainer")
	public WebElement partnerLinkTab;

	public boolean partnerLinkIsDisplayed() {
		boolean partnerLinkiStatus = partnerLinkTab.isDisplayed();
		return partnerLinkiStatus;
	}
	
	public void clickPartnerLink() {
		partnerLinkTab.click();
	}
	
	@FindBy(id = "com.techbins.niki:id/updateTheApp")
	public WebElement updateAppLink;

	public boolean updateAppLinkIsDisplayed() {
		boolean updateLinkStatus = updateAppLink.isDisplayed();
		return updateLinkStatus;
	}
	
	public String getUpdateLinkText() {
		String updateLinkTxt = updateAppLink.getText();
		return updateLinkTxt;
	}
	
	public void clickForUpdate() {
		System.out.println("Cliking on CHECK FOR UPDATE Link");
		updateAppLink.click();
	}
	
	@FindBy(id = "com.android.vending:id/title_title")
	public WebElement nikiNameInPlayStore;

	public String getNikiPlayStoreName() {
		String nikiPlayStore = nikiNameInPlayStore.getText();
		return nikiPlayStore;
	}

	
	
}
