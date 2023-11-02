package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class AddHorseActivities {
    WebDriver driver;
    GenericUtils genericUtils;

@FindBy(tagName = "nav")
WebElement menu;
    @FindBy(xpath = "//span[text()='Barns & Horses']")
    WebElement barnForm;

    @FindBy(css = "div[class='column-container'] div[class='activity-status-icons']")
           WebElement activityIcon;

    @FindBy(xpath = "//span[text()='Shoeing']")
         WebElement clickOnShoeing;
    @FindBy(xpath = "//span[text()='Create Activity']")
          WebElement createActivity;

    @FindBy(xpath = "//div[@class='dropdown-container']")
            WebElement shoeingActivityTypeDropdown;

    @FindBy(xpath = "//span[text()='Trim All 4']")
            WebElement selectShoeingActivity;

    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
         WebElement EnterShoeingDate;

    @FindBy(xpath = "//input[@formcontrolname='shoeingRepeatValue']")
        WebElement enterRepeatShoeingActivity;

    @FindBy(css = ".repeat-schedule-dropdown")
         WebElement selectNoneDropdown;

    @FindBy(xpath = "//span[text()='Week(s)']")
         WebElement selectOption;

    @FindBy(xpath = "//span[text()='Create Activity']")
          WebElement clickOnCreateActivityBtn;

    public AddHorseActivities(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.genericUtils = new GenericUtils(driver);
    }
/*
* goToActivityScreen method go to the hamberg icon and click on the Barn and Horses.
* addShoeing method adding the shoeing activity for horse.
 */
    public void goToActivitiesScreen()  {
        genericUtils.openSideMenu(menu,barnForm);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        genericUtils.clickOnSaveBtn(activityIcon);
    }
    public void addShoeing( String shoeingDate, String repeatShoeingActivity)  {

        genericUtils.clickOnSaveBtn(clickOnShoeing);
        genericUtils.clickOnSaveBtn(createActivity);
        GenericUtils.waitVisibilityElement(shoeingActivityTypeDropdown,5);
        genericUtils.clickOnSaveBtn(shoeingActivityTypeDropdown);
        genericUtils.clickOnSaveBtn(selectShoeingActivity);
        EnterShoeingDate.sendKeys(shoeingDate);
        enterRepeatShoeingActivity.sendKeys(repeatShoeingActivity);
        genericUtils.clickOnSaveBtn(selectNoneDropdown);
        genericUtils.clickOnSaveBtn(selectOption);
        genericUtils.clickOnSaveBtn(clickOnCreateActivityBtn);
        genericUtils.switchToAlert();

    }

   }








