package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.GenericUtils;

public class AddHorseActivities {
    WebDriver driver;
    GenericUtils genericUtils;
    By menu = By.tagName("nav");
    By barnForm = By.xpath("//span[text()='Barns & Horses']");
    By activityIcon=By.cssSelector("div[class='column-container'] div[class='activity-status-icons']");
    By clickOnShoeing=By.xpath("//span[text()='Shoeing']");
    By createActivity=By.xpath("//span[text()='Create Activity']");
    By shoeingActivityTypeDropdown=By.tagName("bd-dropdown");
    By selectShoeingActivity=By.xpath("//span[text()='Trim All 4']");
    By shoeingCalendarClick=By.xpath("//img[@class='calendar-icon']");
    By selectShoeingDate=By.xpath("//mat-calendar[contains(@id,'mat-datepicker')]");
    By saveBtn=By.xpath("//span[text()='Save']");
    By confirmationMsg=By.className("notification-component");
    By addHorse=By.xpath("//span[text()='Add Horse']");
    By enterHorseName=By.xpath("//input[@placeholder='Enter horse name']");
    public AddHorseActivities(WebDriver driver) {
        this.driver = driver;
        this.genericUtils = new GenericUtils(driver);
    }

    public void goToActivitiesScreen()  {
        genericUtils.openSideMenu(menu,barnForm);
        GenericUtils.waitVisibilityElement(activityIcon,10);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(activityIcon).click();
    }
    public void addShoeing()  {
        driver.findElement(clickOnShoeing).click();
        driver.findElement(createActivity).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(shoeingActivityTypeDropdown).click();
        driver.findElement(selectShoeingActivity).click();
        driver.findElement(shoeingCalendarClick).click();
        driver.findElement(selectShoeingDate);
    }

   }








