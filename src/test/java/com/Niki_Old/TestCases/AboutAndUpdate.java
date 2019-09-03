package com.Niki_Old.TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Niki_Old.AutomationConstants.BaseTest;

import pageObjects.ChatPageHeader;
import pageObjects.CommonElements;
import pageObjects.ProfileElements;
import pageObjects.SignUpElements;

public class AboutAndUpdate extends BaseTest{
	
	@Test
	public void verifyAboutLink() throws Exception {
		SoftAssert soft = new SoftAssert();
		ChatPageHeader header = new ChatPageHeader();
		header.clickProfileButton();
		ProfileElements profile = new ProfileElements();

		soft.assertTrue(profile.aboutLinkIsDisplayed());
		System.out.println("'About' Link Displays");
		log.info("'About' Link Displays");
		

		soft.assertEquals("ABOUT", profile.getAboutLinkText());
		//System.out.println("'About' Link Name is displays correct name");
		
		log.info("'About' Link Name is displays correct name");
		
		profile.clickAbout();
		Thread.sleep(3000);
		CommonElements common = new CommonElements();
		soft.assertEquals("About", common.getProfileElementHeader());
		System.out.println("About Link is working fine");

		common.threadSleep(4000);

		soft.assertAll();

	}
	
	@Test
	public void verifyAboutPageElements() {
		ProfileElements profile = new ProfileElements();
		CommonElements common = new CommonElements();
		SoftAssert soft = new SoftAssert();

		soft.assertEquals(version, profile.getAppVersion());
		System.out.println("App Version showing Correctly");
		log.info("App Version showing Correctly");

		soft.assertEquals("© 2018 niki.ai, All rights reserved.", profile.getCopyRightTxt());
		System.out.println("Copy Right message showing properly");

		soft.assertEquals("Crafted with ❤ in India.", profile.getCraftIndMsg());
		System.out.println("Crafted Message Appears Properly");

		soft.assertAll();

	}
	
	
	@Test
	public void verifyHowNikiWorksLink() {
		SoftAssert soft = new SoftAssert();
		ProfileElements profile = new ProfileElements();
		CommonElements common = new CommonElements();

		soft.assertTrue(profile.howNikiWorkLinkIsDisplayed());
		System.out.println("'How Niki Works' Tab appeared properly");

		profile.clickAboutHowNikiWorksLink();
		//common.threadSleep(7000);
		soft.assertEquals("Reach Support", profile.getSupportHeading());
		System.out.println("Its moved to Support page");
		log.info("Its moved to Support page");

		soft.assertTrue(common.backBtnIsDisplayed());
		System.out.println("Back Button appeared properly");
		log.info("Back Button appeared properly");
		
		common.clickDeviceBackButton();
		common.threadSleep(3000);
		soft.assertEquals("About", common.getProfileElementHeader());
		System.out.println("Its moved back to About Page from 'How Niki Works' page");
		
		
		log.info("Its moved back to About Page from 'How Niki Works' page");
		
		soft.assertAll();

	}
	
	@Test
	public void verifyTermsAndConditionLink() {
		SoftAssert soft = new SoftAssert();
		ProfileElements profile = new ProfileElements();
		CommonElements common = new CommonElements();
		ChatPageHeader hdr = new ChatPageHeader();

		soft.assertTrue(profile.termsConditionLinkIsDisplayed());
		System.out.println("'Terms & Condition' Tab appeared properly");

		profile.clickTermsCondtionLink();
		//common.threadSleep(7000);

		soft.assertEquals("Niki", common.getProfileElementHeader());

		soft.assertTrue(profile.termsAndCondHdrIsDisplayed());

		System.out.println("Its moved to Terms and Conditition page");
		log.info("Its moved to Terms and Conditition page");
		

		soft.assertTrue(common.profileButton.isDisplayed());
		System.out.println("Back button appeared properly");
		
		log.info("Back button appeared properly");
		
		hdr.clickProfileButton();
		common.threadSleep(3000);
		soft.assertEquals("About", common.getProfileElementHeader());
		System.out.println("Its moved back to About Page from 'Terms & Conditions' page");

		soft.assertAll();

	}
	
	
	@Test
	public void verifyPartnerLink() {
		SoftAssert soft = new SoftAssert();
		ProfileElements profile = new ProfileElements();
		CommonElements common = new CommonElements();
		SignUpElements sign = new SignUpElements();

		soft.assertTrue(profile.partnerLinkIsDisplayed());
		System.out.println("'Partner with us' Tab appeared properly");

		profile.clickPartnerLink();
		common.threadSleep(7000);
		soft.assertTrue(sign.gmailComposeHdrIsDisplayed());
		soft.assertEquals("<partners@niki.ai>, ", sign.getToMailToAddress());
		soft.assertEquals("I'm looking for a business partnership with niki.ai", sign.getMailSubject());
		System.out.println("Mail details are correct");
		log.info("Mail details are correct");
		
		common.clickDeviceBackButton();
		common.clickDeviceBackButton();
		common.threadSleep(3000);
		soft.assertEquals("About", common.getProfileElementHeader());
		System.out.println("Its moved back to About Page from 'Partner with us' page");

		common.relaunchApp();

		soft.assertAll();
	}
	
	@Test
	public void verifyUpdate() throws Exception {
		ChatPageHeader header = new ChatPageHeader();
		header.clickProfileButton();
		ProfileElements profile = new ProfileElements();
		SoftAssert soft = new SoftAssert();

		soft.assertTrue(profile.updateAppLinkIsDisplayed());
		System.out.println("Update Link is Displaying in the screen");

		soft.assertEquals("CHECK FOR UPDATE", profile.getUpdateLinkText());
		System.out.println("Update Link Text is correct");

		soft.assertAll();
	}
	
	@Test
	public void verifyAboutLinkFunctionality() throws Exception {
		ProfileElements profile = new ProfileElements();
		CommonElements common = new CommonElements();
		SoftAssert soft = new SoftAssert();

		profile.clickForUpdate();
		Thread.sleep(10000);

		// soft.assertTrue(profile.googlePlayHdrIsDisplayed());
		soft.assertEquals("Niki: Online Recharges, Bill Payments & more", profile.getNikiPlayStoreName());
		System.out.println("Its moved to Playstore");

		common.threadSleep(2000);
		common.clickDeviceBackButton();
		common.threadSleep(2000);

		common.relaunchApp();

		soft.assertAll();
	}
	

}
