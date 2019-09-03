package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.Nilki_Old.CommonPage.BasePage;

public class ChatServiceElements extends BasePage{
	
	public ChatServiceElements() {
		PageFactory.initElements(driver, this);
	}
	public static Logger log= Logger.getLogger(ChatServiceElements.class);
	

}
