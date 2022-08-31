package com.survey.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.datahandler.ExcelDataHandler;
import com.survey.actions.SendKeysActionHelper;
import com.survey.actions.UtilityActionHelper;
import com.survey.actions.ValidationActionHelper;

public class DashboardPage {

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	ValidationActionHelper vahObj = new ValidationActionHelper();
	UtilityActionHelper uahObj = new UtilityActionHelper();
	SendKeysActionHelper skahObj = new SendKeysActionHelper();
	ExcelDataHandler excelObj;
	
	@FindBy(xpath = "//a[contains(.,'Dashboard ')]")
	private WebElement dashboardLabel;
	@FindBy(xpath = "//a[contains(.,'Onboarding')]")
	private WebElement onboardingLabel;
	@FindBy(xpath = "//a[contains(.,'Survey')]")
	private WebElement surveyLabel;
	@FindBy(xpath = "//a[contains(.,'Reports')]")
	private WebElement reportsLabel;
	@FindBy(xpath = "(//div//ul)[2]/li/a")
	private WebElement userDetails;
	@FindBy(xpath = "((//div//ul)[2]/li/div/a)[1]")
	private WebElement profileLabel;
	@FindBy(xpath = "//a[@title='Edit']")
	private WebElement editIcon;
	@FindBy(xpath = "//input[@id='country']")
	private WebElement countryField;
	@FindBy(xpath = "//input[@id='zip_code']")
	private WebElement zipcodeField;
	@FindBy(xpath = "//button[contains(.,'Save Profile')]")
	private WebElement saveProfileBtn;
	@FindBy(xpath = "//input[@id='city']")
	private WebElement cityField;
	@FindBy(xpath = "//div[@id='alertmessage']/div[contains(.,' Profile updated successfully')]")
	private WebElement profileUpdateSuccess;
	@FindBy(xpath = "(//ul//li)[2]/div/a[contains(.,'Organization')]")
	private WebElement organizationLabel;
	
	
	
	
	private String dashboardLabelXpath = "//a[contains(.,'Dashboard ')]";
	private String onboardingLabelXpath = "//a[contains(.,'Onboarding')]";
	private String surveyLabelXpath = "//a[contains(.,'Survey')]";
	private String campaginLabelXpath = "//a[contains(.,'Campaign ')]";
	private String reportLabelXpath = "//a[contains(.,'Reports')]";
	private String customReportLabelXpath = "//a[contains(.,'Custom Reports')]";
	private String settingsLabelXpath = "//a[contains(.,'Settings')]";
	private String onboardingDropDownXpath = "(//ul//li)[2]/div";
	private String organizationLabelXpath = "(//ul//li)[2]/div/a[contains(.,'Organization')]";
	private String userLabelXpath = "(//ul//li)[2]/div/a[contains(.,'Users')]";
	private String surveyDropDownXpath = "(//ul//li)[3]/div";
	private String surveyListLabelXpath = "(//ul//li)[3]/div/a[contains(.,'Survey List')]";
	private String newSurveyLabelXpath = "(//ul//li)[3]/div/a[contains(.,'New Survey')]";
	private String reportDropDownXpath = "(//ul//li)[5]/div";
	private String negativeReportLabelXpath = "(//ul//li)[5]/div/a[contains(.,'Negative Report')]";
	private String summaryReportLabelXpath = "(//ul//li)[5]/div/a[contains(.,'Summary Report')]";
	private String detailedSurveyReportLabelXpath = "(//ul//li)[5]/div/a[contains(.,'Detailed Survey Report')]";
	private String dialledReportLabelXpath = "(//ul//li)[5]/div/a[contains(.,'Dialled Reports')]";
	private String profileLabelXpath = "((//div//ul)[2]/li/div/a)[1]";
	private String editIconXpath = "//a[@title='Edit']";
	private String profileUpdateSuccessXpath = "//div[@id='alertmessage']/div[contains(.,' Profile updated successfully')]";
	
			
	public boolean isDashboardLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, dashboardLabelXpath);
	}

	public boolean isOnboardingLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, onboardingLabelXpath);
	}

	public boolean isSurveyLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, surveyLabelXpath);
	}

	public boolean isCampaignLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, campaginLabelXpath);
	}

	public boolean isReportsLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, reportLabelXpath);
	}

	public boolean iscustomReportsLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, customReportLabelXpath);
	}

	public boolean isSettingsLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, settingsLabelXpath);
	}

	public void clickOnOnboardingLabel() throws Exception {
		onboardingLabel.click();
		uahObj.waitUntilElementVisible(driver, onboardingDropDownXpath);
	}

	public boolean isOrganizationLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, organizationLabelXpath);
	}

	public boolean isUsersLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, userLabelXpath);
	}

	public void clickOnSurveyLabel() throws Exception {
		surveyLabel.click();
		uahObj.waitUntilElementVisible(driver, surveyDropDownXpath);
	}

	public boolean isSurveyListLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, surveyListLabelXpath);
	}

	public boolean isNewSurveyLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, newSurveyLabelXpath);
	}

	public void clickOnReportsLabel() throws Exception {
		reportsLabel.click();
		uahObj.waitUntilElementVisible(driver, reportDropDownXpath);
	}

	public boolean isNegativeReportLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, negativeReportLabelXpath);
	}

	public boolean isSummaryReportLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, summaryReportLabelXpath);
	}

	public boolean isDetailedSurveyReportLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, detailedSurveyReportLabelXpath);
	}

	public boolean isDialledReportLabelDisplayed() throws Exception {
		return vahObj.isElementPresentByXpath(driver, dialledReportLabelXpath);
	}

	public void clickOnProfileLabel() throws Exception {
		userDetails.click();
		uahObj.waitUntilElementVisible(driver, profileLabelXpath);
		profileLabel.click();
		uahObj.waitUntilElementVisible(driver, editIconXpath);
	}

	public boolean isUserProfileEdited() throws Exception {
		editIcon.click();
		excelObj = new ExcelDataHandler("ProjectExcel.xlsx", "UserProfile");
		String country = excelObj.getCellDataString(0, 1);
		String city = excelObj.getCellDataString(1, 1);
		skahObj.clearTextAndSendKeys(driver, countryField, country);
		skahObj.clearTextAndSendKeys(driver, cityField, city);
		saveProfileBtn.click();
		uahObj.waitUntilElementVisible(driver, profileUpdateSuccessXpath);
		return vahObj.isElementVisible(driver, profileUpdateSuccess);
	}
	
	public OrganizationPage gotoOrganizationPage() throws Exception {
		onboardingLabel.click();
		uahObj.waitUntilElementVisible(driver, onboardingDropDownXpath);
		organizationLabel.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return new OrganizationPage(driver);
	}

}
