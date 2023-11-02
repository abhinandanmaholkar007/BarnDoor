package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GenericUtils {
      static WebDriver driver;
      static WebDriverWait wait;
      WebElement element;
    Actions actions;
    JavascriptExecutor executor;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static void waitVisibilityElement(WebElement locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
         wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void openSideMenu(WebElement menu,WebElement barnForm )
    {
        waitVisibilityElement(menu, 10);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions=new Actions(driver);
        actions.moveToElement(menu).perform();
        actions.click(barnForm).perform();

    }
    public void clickOnSaveBtn(WebElement saveBtn) {
       //saveBtn.click();
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", saveBtn);
    }

    public String successAndErrorMsg(WebElement confirmationMsg)  {
        GenericUtils.waitVisibilityElement(confirmationMsg,10);
        if (confirmationMsg.getText().contains("error")) {
            return confirmationMsg.getText();
        }
        return confirmationMsg.getText();
}

    public void switchToAlert()
    {
      Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

    }

}









