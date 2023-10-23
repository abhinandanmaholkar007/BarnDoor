package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GenericUtils;

import java.util.List;

public class AddNewBarn {
    WebDriver driver;
    GenericUtils genericUtils;
    By menu = By.tagName("nav");
    By barnForm = By.xpath("//span[text()='Barns & Horses']");
    By addNewBarnButton = By.xpath("//div[@class='top-container']/button");
    By enterBarnName = By.xpath("//input[@placeholder='Enter Barn Name']");
    By noOfStall = By.xpath("//input[@placeholder='Enter No. of Stalls']");
    By saveBtn = By.xpath("//span[text()='Save']");
    By confirmationMsg = By.className("notification-component");
    //  By barnList=By.cssSelector(".barn-detail span");
    By barnList = By.cssSelector(".anchor-wrapper li");

    public AddNewBarn(WebDriver driver) {
        this.driver = driver;
        this.genericUtils = new GenericUtils(driver);
    }

    public void addBarnDetails(String barnName, String stallsNumber) throws InterruptedException {
        {
            genericUtils.openSideMenu(menu, barnForm);
            Thread.sleep(5000);
            if (driver.getCurrentUrl().contains("barns")) {
                driver.findElement(addNewBarnButton).click();

            } else {
                System.out.println("Add Barn button not visible");
            }
            driver.findElement(enterBarnName).sendKeys(barnName);
            driver.findElement(noOfStall).clear();
            driver.findElement(noOfStall).sendKeys(stallsNumber);
        }
    }

    public String addBarn() {

        genericUtils.clickOnSaveBtn(saveBtn);
        String message = genericUtils.successAndErrorMsg(confirmationMsg);
        return message;
    }
}





