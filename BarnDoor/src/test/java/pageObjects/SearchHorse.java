package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.GenericUtils;

import java.util.List;

public class SearchHorse {
    WebDriver driver;
    GenericUtils genericUtils;
    By menu = By.tagName("nav");
    By barnForm = By.xpath("//span[text()='Barns & Horses']");
    By seachHorse=By.cssSelector("input[placeholder='Search Horse']");
    By searchHorseList=By.cssSelector(".list-container");

    public SearchHorse(WebDriver driver) {
        this.driver = driver;
        this.genericUtils = new GenericUtils(driver);
    }

    public void searchHorseWithName(String searchedHorse) throws InterruptedException {
        genericUtils.openSideMenu(menu,barnForm);
        Thread.sleep(4000);
        driver.findElement(seachHorse).sendKeys(searchedHorse);
        List<WebElement> horseName=driver.findElements(searchHorseList);
        for (WebElement listOfHorse:horseName) {
            String nameHorse=listOfHorse.getText();
            if (nameHorse.equalsIgnoreCase(searchedHorse)){
                Assert.assertEquals(horseName,searchedHorse);
            }
        }
    }
    }








