package com.pageobjects; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Homepage {

    WebDriver driver;
    WebDriverWait wait;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By closepopup = By.xpath("//span[@class='commonModal__close']");
    By roundtripButton = By.xpath("//label[@for='roundTrip']");
    By sourceCity = By.id("fromCity");
    By sourceSearchBox = By.xpath("//input[@aria-controls='react-autowhatever-1']");
    By destinationCity = By.id("toCity");
    By destinationSearchBox = By.xpath("//input[@aria-controls='react-autowhatever-1']");
    By searchButton = By.xpath("//*[@class='primaryBtn font24 latobold widgetSearchBtn']");

    public void closepopup() {
        wait.until(ExpectedConditions.elementToBeClickable(closepopup)).click();
    }

    public void clickroundtrip() {
        wait.until(ExpectedConditions.elementToBeClickable(roundtripButton)).click();
    }
    public void entersourcecity(String fromcity) {
        wait.until(ExpectedConditions.elementToBeClickable(sourceCity)).click();  
        wait.until(ExpectedConditions.presenceOfElementLocated(sourceSearchBox)).sendKeys(fromcity);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + fromcity + "']"))).click();
    }

    public void destinationcity(String tocity) {
        wait.until(ExpectedConditions.elementToBeClickable(destinationCity)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(destinationSearchBox)).sendKeys(tocity);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + tocity + "']"))).click();
    }

    public void selectdeparturedate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Departure')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Fri Mar 14 2025']//div[@class='dateInnerCell']"))).click();
    }

    public void selectreturndate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Return')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'Tue Apr 08 2025')]//div[contains(@class,'dateInnerCell')]"))).click();
    }

    public void clickserachbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public WebElement getSourceCityElement() {
        return driver.findElement(sourceCity);
    }

    public WebElement getDestinationCityElement() {
        return driver.findElement(destinationCity);
    }

    public WebElement getDepartureDateElement() {
        return driver.findElement(By.xpath("//span[contains(text(),'Departure')]"));
    }

    public WebElement getReturnDateElement() {
        return driver.findElement(By.xpath("//span[contains(text(),'Return')]"));
    }

    public WebElement getSearchButtonElement() {
        return driver.findElement(searchButton);
    }
}
