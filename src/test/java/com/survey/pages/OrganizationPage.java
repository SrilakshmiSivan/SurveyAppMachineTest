package com.survey.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.datahandler.ExcelDataHandler;
import com.survey.actions.SendKeysActionHelper;
import com.survey.actions.UtilityActionHelper;
import com.survey.actions.ValidationActionHelper;


public class OrganizationPage {

	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		suObj = new SearchUtility(driver);
	}
	
	WebDriver driver;
	UtilityActionHelper uahObj = new UtilityActionHelper();
	SendKeysActionHelper skahObj = new SendKeysActionHelper();
	ValidationActionHelper vahObj = new ValidationActionHelper();
	SearchUtility suObj;
	
	@FindBy(id = "createNewOrganization")
	private WebElement createOrganizationBtn;
	@FindBy(id = "company_name")
	private WebElement companyNameField;
	@FindBy(id = "phone_number")
	private WebElement phoneNumberField;
	@FindBy(id = "city")
	private WebElement cityField;
	@FindBy(id = "state")
	private WebElement stateField;
	@FindBy(id = "country")
	private WebElement countryField;
	@FindBy(id = "address")
	private WebElement addressField;
	@FindBy(id = "zip_code")
	private WebElement zipCodeField;
	@FindBy(id = "email")
	private WebElement emailField;
	@FindBy(id = "password")
	private WebElement passwordField;
	@FindBy(id = "logo")
	private WebElement logoUpload;
	@FindBy(id = "saveBtn")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[@id='alertmessage']")
	private WebElement addSuccessMsg;
	@FindBy(xpath = "((//table/tbody/tr)[4]/td)[11]/a[@data-original-title='Edit']")
	private WebElement editIcon;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchField;
	
	
	private String addSuccessMsgXpath = "//div[@id='alertmessage']";
	private String companyNameFieldXpath = "//input[@id='company_name']";
	
	public void clickOnCreateOrganizationBtn() throws Exception {
		createOrganizationBtn.click();
		uahObj.waitUntilElementVisible(driver, companyNameFieldXpath);
	}

	public void saveOrganization(String name, int phoneNo, String city, String state, String country, String address, String zipCode, String email, String password, String logo) throws Exception {
		skahObj.clearTextAndSendKeys(driver, companyNameField, name);
		skahObj.sendKeysJsById(driver, "phone_number", phoneNo);
		skahObj.clearTextAndSendKeys(driver, cityField, city);
		skahObj.clearTextAndSendKeys(driver, stateField, state);
		skahObj.clearTextAndSendKeys(driver, countryField, country);
		skahObj.clearTextAndSendKeys(driver, addressField, address);
		skahObj.clearTextAndSendKeys(driver, zipCodeField, zipCode);
		skahObj.clearTextAndSendKeys(driver, emailField, email);
		skahObj.clearTextAndSendKeys(driver, passwordField, password);
		skahObj.sendKeys(driver, logoUpload, logo);
		saveBtn.click();
	}

	public boolean waitUntilSuccessVisibility() throws Exception {
		uahObj.waitUntilElementVisible(driver, addSuccessMsgXpath);
		return vahObj.isElementVisible(driver, addSuccessMsg);
	}

	public void clickOnSearchField() {
		searchField.click();
		
	}

	public boolean searchOrganization(String searchKey, String searchType) throws Exception {
		return suObj.search(searchKey, searchType);
	}

	
}
