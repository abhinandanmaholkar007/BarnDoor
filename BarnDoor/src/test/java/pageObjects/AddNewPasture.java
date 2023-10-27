package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GenericUtils;

import java.util.Iterator;
import java.util.List;

public class AddNewPasture {
    WebDriver driver;
    GenericUtils genericUtils;
    By menu = By.tagName("nav");
    By barnForm = By.xpath("//span[text()='Barns & Horses']");
    By saveBtn=By.xpath("//span[text()='Save']");
    By confirmationMsg=By.className("notification-component");
    By pastureClick=By.xpath("//button[text()=' Pasture ']");
    By pastureAdd=By.xpath("//input[@placeholder='Enter Pasture Name']");
    By pastureList=By.className("visible-border-container");
    By addNewBarnButton=By.xpath("//div[@class='top-container']/button");
    public AddNewPasture(WebDriver driver) {
        this.driver = driver;
        this.genericUtils = new GenericUtils(driver);
    }



    public String clickOnPasture (String pastureName)  {
        genericUtils.openSideMenu(menu,barnForm);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver.getCurrentUrl().contains("barns"))
        {
            driver.findElement(addNewBarnButton).click();

        }else{
            System.out.println("Add Barn button not visible");
        }
        driver.findElement(pastureClick).click();
        driver.findElement(pastureAdd).sendKeys(pastureName);
        genericUtils.clickOnSaveBtn(saveBtn);
        GenericUtils.waitVisibilityElement(confirmationMsg, 20);
        String message=genericUtils.successAndErrorMsg(confirmationMsg);
        return message;
    }
    }








