package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class AddNewHorse {
    WebDriver driver;
    GenericUtils genericUtils;
  @FindBy(tagName = "nav")
  WebElement menu;
  @FindBy(xpath = "//span[text()='Barns & Horses']")
  WebElement barnForm;

  @FindBy(xpath = "//span[text()='Save']")
  WebElement saveBtn;

  @FindBy(className = "notification-component")
  WebElement confirmationMsg;

    @FindBy(xpath = "//span[text()='Add Horse']")
          WebElement addHorse;

    @FindBy(xpath = "//input[@placeholder='Enter horse name']")
    WebElement enterHorseName;
    public AddNewHorse(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.genericUtils = new GenericUtils(driver);
    }

    /*
     * addHorse method add horse and grab success message
     */
    public void addHorse(String horseName)  {
        genericUtils.openSideMenu(menu,barnForm);
        GenericUtils.waitVisibilityElement(addHorse,10);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addHorse.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GenericUtils.waitVisibilityElement(enterHorseName,20);
        enterHorseName.sendKeys(horseName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        genericUtils.clickOnSaveBtn(saveBtn);
        genericUtils.successAndErrorMsg(confirmationMsg);
    }}








