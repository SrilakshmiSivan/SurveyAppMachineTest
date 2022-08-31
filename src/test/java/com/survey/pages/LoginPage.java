package com.survey.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.survey.actions.SendKeysActionHelper;
import com.survey.actions.UtilityActionHelper;
import com.survey.actions.ValidationActionHelper;
import com.survey.actions.WebActionHelper;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	WebActionHelper wahObj = new WebActionHelper();
	ValidationActionHelper vahObj = new ValidationActionHelper();
	SendKeysActionHelper skahObj = new SendKeysActionHelper();
	UtilityActionHelper uahObj = new UtilityActionHelper();
	
	@FindBy(id = "email")
	private WebElement uname;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(xpath = "//button")
	private WebElement loginBtn;
	@FindBy(xpath = "//a[contains(.,'Forgot Your Password?')]")
	private WebElement forgetPwdLink;
	@FindBy(xpath = "//div//main//div//div//div//div//div[contains(.,'Password')]")
	private WebElement forgetPwdHeading;
	@FindBy(xpath = "//a[contains(.,'Dashboard ')]")
	private WebElement dashboardLink;
	@FindBy(xpath = "(//div//ul)[2]/li/a")
	private WebElement userDetails;
	@FindBy(xpath = "((//div//ul)[2]/li/div/a)[2]")
	private WebElement logOutLabel;
	
	private String logoutLabelXpath = "((//div//ul)[2]/li/div/a)[2]";
	
	
	public String getURL() {
		return wahObj.getSiteURL(driver);
	}
	public String getTitle() {
		return wahObj.getSiteTitle(driver);
	}
	public boolean isUserNameFieldDisplayed() throws Exception {
		return vahObj.isElementVisible(driver, uname);
	}
	public boolean isPasswordFieldDisplayed() throws Exception {
		return vahObj.isElementVisible(driver, password);
	}
	public boolean isLoginBtnDisplayed() throws Exception {
		return vahObj.isElementVisible(driver, loginBtn);
	}
	public boolean isForgetPwdLinkDisplayed() throws Exception {
		return vahObj.isElementVisible(driver, forgetPwdLink);
	}
	public void clickOnForgetPasswordLink() {
		forgetPwdLink.click();
		
	}
	public boolean checkForgetPasswordPage() throws Exception {
		return vahObj.isElementVisible(driver, forgetPwdHeading);
	}
	public void clickLogin(String username, String pwd) throws Exception {
		skahObj.clearTextAndSendKeys(driver, uname, username);
		skahObj.clearTextAndSendKeys(driver, password, pwd);
		loginBtn.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}
	public boolean isDashboardDisplayed() throws Exception {
		return vahObj.isElementVisible(driver, dashboardLink);
	}
	public void logout() throws Exception {
		userDetails.click();
		uahObj.waitUntilElementVisible(driver, logoutLabelXpath);
		logOutLabel.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}
	
	public DashboardPage login(String username, String pwd) throws Exception {
		skahObj.clearTextAndSendKeys(driver, uname, username);
		skahObj.clearTextAndSendKeys(driver, password, pwd);
		loginBtn.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return new DashboardPage(driver);
	}

}
