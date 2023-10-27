package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class AddNewHorse {
    WebDriver driver;
    GenericUtils genericUtils;
    By menu = By.tagName("nav");
    By barnForm = By.xpath("//span[text()='Barns & Horses']");
    By saveBtn=By.xpath("//span[text()='Save']");
    By confirmationMsg=By.className("notification-component");
    By addHorse=By.xpath("//span[text()='Add Horse']");
    By enterHorseName=By.xpath("//input[@placeholder='Enter horse name']");
    public AddNewHorse(WebDriver driver) {
        this.driver = driver;
        this.genericUtils = new GenericUtils(driver);
    }


    public void addHorse(String horseName) throws InterruptedException {
        genericUtils.openSideMenu(menu,barnForm);
        GenericUtils.waitVisibilityElement(addHorse,10);
        Thread.sleep(4000);
        driver.findElement(addHorse).click();
        Thread.sleep(4000);
        GenericUtils.waitVisibilityElement(enterHorseName,20);
        driver.findElement(enterHorseName).sendKeys(horseName);
        Thread.sleep(3000);
        genericUtils.clickOnSaveBtn(saveBtn);
        genericUtils.successAndErrorMsg(confirmationMsg);
    }}








