package com.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageobjects.Homepage;

public class FlightBookingTests extends com.base.baseclass {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void Navigatetowebsite() {
		driver = InitializeBrowser("chrome");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void Searchflights() throws InterruptedException {
		Homepage homepage = new Homepage(driver);
		Thread.sleep(2000);
		homepage.closepopup();
		wait.until(ExpectedConditions.visibilityOf(homepage.getSourceCityElement()));
		homepage.entersourcecity("Pune");

	}

	@AfterMethod
	public void close() {
		if (driver != null) {
			driver.quit();
		}
	}
}
