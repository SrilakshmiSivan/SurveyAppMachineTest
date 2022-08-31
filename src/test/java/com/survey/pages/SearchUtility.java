package com.survey.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.survey.actions.SendKeysActionHelper;
import com.survey.actions.UtilityActionHelper;

public class SearchUtility {

	public SearchUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	SendKeysActionHelper skahObj = new SendKeysActionHelper();
	UtilityActionHelper uahObj = new UtilityActionHelper();
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchField;
	
	@FindBy(xpath = "//table//tbody/tr")
	private List <WebElement> rows;
	
	@FindBy(xpath = "(//table//tbody/tr)[1]/td")
	private List <WebElement> columns;
	
	private String loadingMsgXpath = "//div[@id='organizationDataTable_processing']";
	
	
public boolean search(String searchData, String searchType) throws Exception {
		
		boolean status = false;
		skahObj.clearTextAndSendKeys(driver, searchField, searchData);
		uahObj.waitUntilElementInvisible(driver, loadingMsgXpath);
		
		ArrayList result = uahObj.getAllTableContent(driver, 1, columns.size(), "//table/tbody/tr");
		
		if(searchType.equals("valid")) {
			if(result.contains(searchData) ) {
				status = true;
			}else {
				status = false;
			}
		}
		if(searchType.equals("invalid")) {
			if(columns.size() > 1) {
				status = false;
			}else {
				status = true;
			}
		}
		
		return status;
		
	}
}
