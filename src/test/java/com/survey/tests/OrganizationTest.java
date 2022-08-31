package com.survey.tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.datahandler.ExcelDataHandler;
import com.obs.datahandler.PropertyDataHandler;
import com.survey.actions.UtilityActionHelper;
import com.survey.pages.DashboardPage;
import com.survey.pages.LoginPage;
import com.survey.pages.OrganizationPage;

public class OrganizationTest extends BaseTest {

	LoginPage lpage;
	DashboardPage dashboardPage;
	OrganizationPage organizationPage;
	SoftAssert soft;
	ExcelDataHandler excelObj;

	@BeforeMethod
	public void setup() throws Exception {
		lpage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		PropertyDataHandler prop = new PropertyDataHandler();
		Properties allProp = prop.readPropertiesFile("config.properties");
		dashboardPage = lpage.login(allProp.getProperty("username"), allProp.getProperty("password"));
		organizationPage = dashboardPage.gotoOrganizationPage();
		UtilityActionHelper uahObj = new UtilityActionHelper();
		uahObj.pageLoadWaitSeconds(driver, 50);
	}

	@Test(priority = 1, enabled = true)
	public void createOrganization() throws Exception {
		soft = new SoftAssert();
		organizationPage.clickOnCreateOrganizationBtn();
		excelObj = new ExcelDataHandler("ProjectExcel.xlsx", "Organization");
		String name = excelObj.getCellDataString(0, 1);
		int phoneNo = excelObj.getCellDataInteger(1, 1);
		String city = excelObj.getCellDataString(2, 1);
		String state = excelObj.getCellDataString(3, 1);
		String country = excelObj.getCellDataString(4, 1);
		String address = excelObj.getCellDataString(5, 1);
		String zipCode = excelObj.getCellDataString(6, 1);
		String email = excelObj.getCellDataString(7, 1);
		String password = excelObj.getCellDataString(8, 1);
		String logo = excelObj.getCellDataString(9, 1);
		organizationPage.saveOrganization(name, phoneNo, city, state, country, address, zipCode, email, password, logo);
		soft.assertTrue(organizationPage.waitUntilSuccessVisibility(), "Organization did not added");
		soft.assertAll();
	}
	@Test(priority = 2, enabled = true)
	public void verifySearchOrganization() throws Exception {
		soft = new SoftAssert();
		organizationPage.clickOnSearchField();
		excelObj = new ExcelDataHandler("ProjectExcel.xlsx", "Organization");
		String validSearchData = excelObj.getCellDataString(12, 1);
		String invalidSearchData = excelObj.getCellDataString(13, 1);
		soft.assertTrue(organizationPage.searchOrganization(validSearchData,"valid"), "Valid Search is not accurate");
		soft.assertTrue(organizationPage.searchOrganization(invalidSearchData,"invalid"), "Invalid Search shows result");
		soft.assertAll();
	}

	@AfterMethod
	public void logout() throws Exception {
		lpage.logout();
	}

}
