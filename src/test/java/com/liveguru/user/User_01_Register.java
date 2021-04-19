package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AccountDashboardPageObject;
import pageObjects.AccountInformationPageObject;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import utilities.FakerConfig;

public class User_01_Register extends AbstractTest {
	private WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		fakeData = FakerConfig.getFakeData();

		firstName = fakeData.getFirstname();
		middleName = "Duy";
		lastName = fakeData.getLastname();
		email = fakeData.getEmailAddress();
		password = fakeData.getPassword();

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Register_New_Account() {
		log.info("Register - Step 01: Click to 'Account' Menu");
		homePage.clickToAccountMenu();

		log.info("Register - Step 02: Click to 'Register' Link");
		homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		log.info("Register - Step 03: Enter to 'First Name' Textbox with value '" + firstName + "'");
		registerPage.enterToFirstnameTextbox(firstName);

		log.info("Register - Step 04: Enter to 'Middle Name/Initial' Textbox with value '" + middleName + "'");
		registerPage.enterToMiddlenameTextbox(middleName);

		log.info("Register - Step 05: Enter to 'Last Name' Textbox with value '" + lastName + "'");
		registerPage.enterToLastnameTextbox(lastName);

		log.info("Register - Step 06: Enter to 'Email Address' Textbox with value '" + email + "'");
		registerPage.enterToEmailAddressTextbox(email);

		log.info("Register - Step 07: Enter to 'Password' Textbox with value '" + password + "'");
		registerPage.enterToPasswordTextbox(password);

		log.info("Register - Step 08: Enter to 'Confirm Password' Textbox with value '" + password + "'");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register - Step 09: Click to 'Register' Button");
		registerPage.clickToRegisterButton();
		accountDashboardPage = PageGeneratorManager.getAccountDashboardPage(driver);

		log.info("Register - Step 10: Verify the success message is displayed with value 'Thank you for registering with Main Website Store.' ");
		verifyEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
	}

	@Test
	public void TC_02_Verify_User_Information_After_Register() {
		log.info("Register[Verify]  - Step 01: Click to 'My Account' Link");
		accountDashboardPage.clickToLinkInFooterByPageName(driver, "My Account");
		
		log.info("Register[Verify]  - Step 02: Click to 'Account Information' Link");
		accountDashboardPage.clickToLinkByPageName(driver, "Account Information");
		accountInformationPage = PageGeneratorManager.getAccountInformationPage(driver);
		
		log.info("Register[Verify]  - Step 03: Verify the value of 'Firstname' Textbox is displayed with value '" + firstName + "'");
		verifyEquals(accountInformationPage.getAttributeValueOfFirstNameTextbox(), firstName);
		
		log.info("Register[Verify]  - Step 04: Verify the value of 'Lastname' Textbox is displayed with value '" + lastName + "'");
		verifyEquals(accountInformationPage.getAttributeValueOfLastNameTextbox(), lastName);
		
		log.info("Register[Verify]  - Step 05: Verify the value of 'Email' Textbox is displayed with value '" + email + "'");
		verifyEquals(accountInformationPage.getAttributeValueOfEmailTextbox(), email);
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.close();
	}

	FakerConfig fakeData;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	AccountDashboardPageObject accountDashboardPage;
	AccountInformationPageObject accountInformationPage;
	String firstName, middleName, lastName, email, password;
}
