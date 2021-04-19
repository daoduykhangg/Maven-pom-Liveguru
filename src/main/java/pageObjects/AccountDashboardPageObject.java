package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AccountDashboardPageUI;

public class AccountDashboardPageObject extends AbstractPage{
	WebDriver driver;

	public AccountDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, AccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, AccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}
}
