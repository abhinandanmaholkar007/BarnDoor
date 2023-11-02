package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;
import java.util.Iterator;
import java.util.List;

public class AddNewPasture {
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

    @FindBy(xpath = "//button[text()=' Pasture ']")
         WebElement pastureClick;

    @FindBy(xpath = "//input[@placeholder='Enter Pasture Name']")
           WebElement pastureAdd;

    @FindBy(xpath = "//div[@class='top-container']/button")
    WebElement addNewBarnButoon;
    public AddNewPasture(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.genericUtils = new GenericUtils(driver);
    }

/*
 * clickOnPasture method add the new pasture and grapp the success and warning message based on the below condition.
 * Condition 1: Grabbing success message after adding new pasture.
 * Condition 2: If pasture already exist print warning message.
 */

    public String clickOnPasture (String pastureName)  {
        genericUtils.openSideMenu(menu,barnForm);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver.getCurrentUrl().contains("barns"))
        {
            addNewBarnButoon.click();

        }else{
            System.out.println("Add Barn button not visible");
        }
        pastureClick.click();
        pastureAdd.sendKeys(pastureName);
        genericUtils.clickOnSaveBtn(saveBtn);
        GenericUtils.waitVisibilityElement(confirmationMsg, 20);
        String message=genericUtils.successAndErrorMsg(confirmationMsg);
        return message;
    }
    }








