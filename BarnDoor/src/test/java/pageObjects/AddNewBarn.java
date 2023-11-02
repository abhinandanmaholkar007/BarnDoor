package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

import java.util.List;

public class AddNewBarn {
    WebDriver driver;
    GenericUtils genericUtils;

    @FindBy(tagName = "nav")
          WebElement menu;

    @FindBy(xpath = "//span[text()='Barns & Horses']")
           WebElement barnForm;

    @FindBy(xpath = "//div[@class='top-container']/button")
           WebElement addNewBarnButton;

    @FindBy(xpath = "//input[@placeholder='Enter Barn Name']")
          WebElement enterBarnName;

    @FindBy(xpath = "//input[@placeholder='Enter No. of Stalls']")
          WebElement noOfStall;

    @FindBy(xpath = "//span[text()='Save']")
         WebElement saveBtn;

    @FindBy(className = "notification-component")
         WebElement confirmationMsg;

    public AddNewBarn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.genericUtils = new GenericUtils(driver);
    }

    /*
* addBarnDetails method go to the hamberg icon and click on the Barn and Horses
* click on the add barn and add new barn by entering all the mandatory details.
 */

    public void addBarnDetails(String barnName, String stallsNumber)  {
        {
            genericUtils.openSideMenu(menu, barnForm);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (driver.getCurrentUrl().contains("barns")) {
                addNewBarnButton.click();

            } else {
                System.out.println("Add Barn button not visible");
            }
            enterBarnName.sendKeys(barnName);
            noOfStall.clear();
            noOfStall.sendKeys(stallsNumber);
        }
    }
    /*
    In addBarn method
    * Condition 1: Grabbing success message after adding new barn.
    * Condition 2: If barns already exist print warning message.
     */
    public String addBarn() {

        genericUtils.clickOnSaveBtn(saveBtn);
        String message = genericUtils.successAndErrorMsg(confirmationMsg);
        return message;
    }
}





