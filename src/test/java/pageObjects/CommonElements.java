package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nilki_Old.CommonPage.BasePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class CommonElements extends BasePage {
	
	public CommonElements() {
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log = Logger.getLogger(CommonElements.class);
	
	
	@FindBy(id = "com.techbins.niki:id/btnSubmit")
	public WebElement SubmitBtn;
	
	public void clickSubmit() {
		SubmitBtn.click();
		System.out.println("Clicked Submit Button");
		log.info("Clicked Submit Button");
	}
	
	public void threadSleep(Integer time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public void clickDeviceBackButton() {

		// ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		System.out.println("Back Button Clicked");

	}
	
	@FindBy(id = "com.android.packageinstaller:id/permission_message")
	public WebElement PermissionAllowMsg;

	// It will read and store allow prompt text

	public String getAllowPopupmsg() {
		String allowpopuptext = PermissionAllowMsg.getText();
		return allowpopuptext;
	}
	
	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement PermissionAllowButton;

	// It will click on Permission allow popup

	public void clickAllowBtn() {
		PermissionAllowButton.click();
	}
	
	
	public void relaunchAppForPopup() {
		driver.closeApp();
		threadSleep(2000);
		driver.launchApp();
		threadSleep(2000);
		System.out.println("App relaunched successfully for Popup");
		
		log.info("App relaunched successfully for Popup");
	}

}
