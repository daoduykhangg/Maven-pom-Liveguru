package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class User_01_Register extends AbstractTest {
	private WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
	}

	@Test
	public void TC_01() {
		log.info("Step 01");
		verifyTrue(false);
		System.out.println("step 02");
		verifyTrue(true);
		System.out.println("step 03");
		verifyTrue(false);
		System.out.println("step 04");
		verifyTrue(true);
		System.out.println("step 05");
		verifyFalse(false);
		System.out.println("step 06");
		verifyFalse(true);
		System.out.println("step 07");
		verifyFalse(false);
		System.out.println("step 08");
		verifyFalse(true);
		System.out.println("step 09");
		verifyEquals(true, false);
		System.out.println("step 10");
		verifyEquals(true, false);
		System.out.println("step 11");
		verifyEquals(true, true);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.close();
	}

}
