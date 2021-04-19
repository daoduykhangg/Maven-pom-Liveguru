package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AccountInformationPageUI;

public class AccountInformationPageObject extends AbstractPage{
	WebDriver driver;

	public AccountInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getAttributeValueOfFirstNameTextbox() {
		waitForElementVisible(driver, AccountInformationPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttributeValue(driver, AccountInformationPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getAttributeValueOfLastNameTextbox() {
		waitForElementVisible(driver, AccountInformationPageUI.LASTNAME_TEXTBOX);
		return getElementAttributeValue(driver, AccountInformationPageUI.LASTNAME_TEXTBOX, "value");
		
	}

	public String getAttributeValueOfEmailTextbox() {
		waitForElementVisible(driver, AccountInformationPageUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, AccountInformationPageUI.EMAIL_TEXTBOX, "value");
	}
}
