package com.survey.tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.datahandler.PropertyDataHandler;
import com.survey.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage lpage;
	SoftAssert soft;
	PropertyDataHandler prop = new PropertyDataHandler();
	
	@BeforeMethod
	public void invokeLoginPage() {
		lpage = new LoginPage(driver);
	}

	/*
	 * Verify that the user is able to launch the URL
	 */
	@Test(priority = 0, enabled = true)
	public void verifyExpectedURLisLaunched() throws IOException{
		soft = new SoftAssert();
		PropertyDataHandler prop = new PropertyDataHandler();
		Properties allProp = prop.readPropertiesFile("config.properties");
		soft.assertEquals(lpage.getURL(), allProp.getProperty("url"), "Wrong URL Launched");
		soft.assertAll();
	}
	/*
	 * Verify all fields are displayed on the login page (User Name, Password, Login Button, Remember Me checkbox, Forget Password Link, Back to home Page Link)
	 */
	@Test(priority = 1, enabled = true)
	public void validateLoginPageFieldsAreDisplayed() throws Exception {
		soft = new SoftAssert();
		soft.assertTrue(lpage.isUserNameFieldDisplayed(), "User Name field is not displayed");
		soft.assertTrue(lpage.isPasswordFieldDisplayed(), "Password field is not displayed");
		soft.assertTrue(lpage.isLoginBtnDisplayed(), "Login Button is not displayed");
		soft.assertTrue(lpage.isForgetPwdLinkDisplayed(), "Forget password link is not displayed");
		soft.assertAll();
	}
	@Test(priority = 2, enabled = true)
	public void verifyForgetPasswordLinkRedirection() throws Exception {
		soft = new SoftAssert();
		lpage.clickOnForgetPasswordLink();
		soft.assertTrue(lpage.checkForgetPasswordPage(), "Forget Password page is not displayed");
		soft.assertAll();
	}
	/*
	 * Verify invalid login
	 */
	@Test(priority = 3, dataProvider = "Credentials", enabled = true)
	public void validateAllInvalidLogin(String uname, String pwd) throws Exception {
		
		soft = new SoftAssert();
		lpage.clickLogin(uname, pwd);
		if(uname.equals("")) 
			soft.assertTrue(lpage.isUserNameFieldDisplayed(), "Empty login redirects to somewhere");
		if(uname.equals("superadm@surveyapp.com"))
			soft.assertTrue(lpage.isUserNameFieldDisplayed(), "Invalid uname and pwd check redirects to somewhere");
		if(uname.equals("superadm@surveyapp.com"))
			soft.assertTrue(lpage.isUserNameFieldDisplayed(), "Invalid uname and valid pwd check redirects to somewhere");
		if(uname.equals("superadmin@surveyapp.com"))
			soft.assertTrue(lpage.isUserNameFieldDisplayed(), "Valid uname and Invalid pwd check redirects to somewhere");
		
		soft.assertAll();
	}
	/*
	 * Verify valid login
	 */
	@Test(priority = 4,  enabled = true)
	public void verifyValidLogin() throws Exception {
		
		soft = new SoftAssert();
		Properties allProp = prop.readPropertiesFile("config.properties");
		lpage.clickLogin(allProp.getProperty("username"), allProp.getProperty("password"));
		soft.assertTrue(lpage.isDashboardDisplayed(), "Login is not successful");
		lpage.logout();
		soft.assertTrue(lpage.isUserNameFieldDisplayed(), "Logout is not successfull");
		soft.assertAll();
	}
	
	@DataProvider(name = "Credentials")
	public Object[][] getData(){
		Object[][] data = new Object[4][2];
		data[0][0] = "";
		data[0][1] = "";
		data[1][0] = "superadm@surveyapp.com";
		data[1][1] = "admin123";
		data[2][0] = "superadmin@surveyapp.com";
		data[2][1] = "admin1";
		data[3][0] = "superadm@surveyapp.com";
		data[3][1] = "admin1";
		return data;
	}
}
