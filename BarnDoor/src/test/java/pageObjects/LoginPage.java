package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class LoginPage {
    WebDriver driver;
    GenericUtils genericUtils;

    By uid= By.xpath("//div[@class='email']/input");
    By pass=By.xpath("//div[@class='password']/input");
    By loginBtn=By.cssSelector(".login-btn");
    By menu = By.tagName("nav");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.genericUtils = new GenericUtils(driver);
    }

    public void login(String userName, String password) {
        GenericUtils.waitVisibilityElement(uid,10);
        driver.findElement(uid).sendKeys(userName);
        GenericUtils.waitVisibilityElement(pass,10);
        driver.findElement(pass).sendKeys(password);
        GenericUtils.waitVisibilityElement(loginBtn,10);
        driver.findElement(loginBtn).click();
        GenericUtils.waitVisibilityElement(menu,10);
    }
    public String verifyDashboard()
    {
        return driver.getCurrentUrl();
    }
}



