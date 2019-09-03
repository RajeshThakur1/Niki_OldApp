package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nilki_Old.CommonPage.BasePage;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChatPageHeader extends BasePage{
	
	public ChatPageHeader() {
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log= Logger.getLogger(ChatPageHeader.class);
	
	@FindBy(className = "android.widget.ImageButton")
	public WebElement profileButton;
	
	public void clickProfileButton() {
		System.out.println("Clicking on Profile Button");
		log.info("Clicking on Profile Button");
		profileButton.click();
	}
	
	@FindBy(id = "com.techbins.niki:id/niki_title_chat")
	public WebElement chatHeaderTitle;
	
	public String getHeaderName() {
		String HeaderText = chatHeaderTitle.getText();
		return HeaderText;
	}

}
