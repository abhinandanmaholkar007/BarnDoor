package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GenericUtils {
      static WebDriver driver;
      static WebDriverWait wait;
      WebElement element;
    Actions actions;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static WebElement waitVisibilityElement(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void openSideMenu(By menu,By barnForm )
    {
        element= waitVisibilityElement(menu, 10);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions=new Actions(driver);
        actions.moveToElement(element).perform();
        element.findElement(barnForm).click();
    }
    public void clickOnSaveBtn(By saveBtn) {
        driver.findElement(saveBtn).click();
    }

    public String successAndErrorMsg(By confirmationMsg)  {
        GenericUtils.waitVisibilityElement(confirmationMsg,10);
        if (driver.findElement(confirmationMsg).getText().contains("error")) {
            return driver.findElement(confirmationMsg).getText();
        }
        return driver.findElement(confirmationMsg).getText();
}

}









