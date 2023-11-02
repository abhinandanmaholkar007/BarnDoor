package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class LoginPage {
    WebDriver driver;
    GenericUtils genericUtils;

    @FindBy(xpath = "//div[@class='email']/input")
    WebElement uid;

    @FindBy(xpath ="//div[@class='password']/input")
          WebElement pass;

    @FindBy(css = ".login-btn")
           WebElement loginBtn;
    @FindBy(tagName = "nav")
    WebElement menu;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.genericUtils = new GenericUtils(driver);
    }
/*
* login method login into the barndoor application and verify the dashboard page
 */
    public void login(String userName, String password) {
        GenericUtils.waitVisibilityElement(uid,10);
        uid.sendKeys(userName);
        GenericUtils.waitVisibilityElement(pass,10);
        pass.sendKeys(password);
        GenericUtils.waitVisibilityElement(loginBtn,10);
        loginBtn.click();
        GenericUtils.waitVisibilityElement(menu,10);
    }
    public String verifyDashboard()
    {
        return driver.getCurrentUrl();
    }
}



