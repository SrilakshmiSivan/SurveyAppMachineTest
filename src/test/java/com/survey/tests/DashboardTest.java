package com.survey.tests;

import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.datahandler.PropertyDataHandler;
import com.survey.pages.DashboardPage;
import com.survey.pages.LoginPage;

public class DashboardTest extends BaseTest{
	
	LoginPage lpage;
	DashboardPage dashboardPage;
	SoftAssert soft;
	
	@BeforeMethod
	public void setup() throws Exception {
		lpage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		PropertyDataHandler prop = new PropertyDataHandler();
		Properties allProp = prop.readPropertiesFile("config.properties");
		dashboardPage = lpage.login(allProp.getProperty("username"), allProp.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	/*
	 * Verify the fields are displayed on the Dashboard Page
	 */
	@Test(priority = 1, enabled = true)
	public void validateDashboardPageFieldsAreDisplayed() throws Exception {
		soft = new SoftAssert();
		soft.assertTrue(dashboardPage.isDashboardLabelDisplayed(), "Dashboard Label is not displayed");
		soft.assertTrue(dashboardPage.isOnboardingLabelDisplayed(), "Onboarding Label is not displayed");
		soft.assertTrue(dashboardPage.isSurveyLabelDisplayed(), "Survey Label is not displayed");
		soft.assertTrue(dashboardPage.isCampaignLabelDisplayed(), "Campaign Label is not displayed");
		soft.assertTrue(dashboardPage.isReportsLabelDisplayed(), "Reports Label is not displayed");
		soft.assertTrue(dashboardPage.iscustomReportsLabelDisplayed(), "Custom Reports Label is not displayed");
		soft.assertTrue(dashboardPage.isSettingsLabelDisplayed(), "Settings Label is not displayed");
		soft.assertAll();
	}
	/*
	 * Validate while clicking on the Onboarding a drop with Users and Organization is displayed 
	 */
	@Test(priority = 2, enabled = true)
	public void validateOnboardingDropDownIsShowing() throws Exception {
		soft = new SoftAssert();
		dashboardPage.clickOnOnboardingLabel();
		soft.assertTrue(dashboardPage.isOrganizationLabelDisplayed(), "Organization Label is not displayed");
		soft.assertTrue(dashboardPage.isUsersLabelDisplayed(), "Users Label is not displayed");
		soft.assertAll();
	}
	/*
	 *Validate while clicking on the Survey , Survey List and New Survey label is displayed
	 */
	@Test(priority = 3, enabled = true)
	public void validateSurveyDropDownIsShowing() throws Exception {
		soft = new SoftAssert();
		dashboardPage.clickOnSurveyLabel();
		soft.assertTrue(dashboardPage.isSurveyListLabelDisplayed(), "Survey List Label is not displayed");
		soft.assertTrue(dashboardPage.isNewSurveyLabelDisplayed(), "New Survey Label is not displayed");
		soft.assertAll();
	}
	/*
	 *Validate while clicking on the Survey , Survey List and New Survey label is displayed
	 */
	@Test(priority = 4, enabled = true)
	public void validateReportsDropDownisShowing() throws Exception {
		soft = new SoftAssert();
		dashboardPage.clickOnReportsLabel();
		soft.assertTrue(dashboardPage.isNegativeReportLabelDisplayed(), "Survey List Label is not displayed");
		soft.assertTrue(dashboardPage.isSummaryReportLabelDisplayed(), "New Survey Label is not displayed");
		soft.assertTrue(dashboardPage.isDetailedSurveyReportLabelDisplayed(), "New Survey Label is not displayed");
		soft.assertTrue(dashboardPage.isDialledReportLabelDisplayed(), "New Survey Label is not displayed");
		soft.assertAll();
	}
	/*
	 *Verify the user profile can be edited
	 */
	@Test(priority = 5, enabled = true)
	public void verifyUserProfileEdit() throws Exception {
		soft = new SoftAssert();
		dashboardPage.clickOnProfileLabel();
		soft.assertTrue(dashboardPage.isUserProfileEdited(), "User Profile is not edited");
		soft.assertAll();
	}
	
	@AfterMethod
	public void logout() throws Exception {
		lpage.logout();
	}


}
