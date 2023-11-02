package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.GenericUtils;

import java.util.List;

public class SearchHorse {
    WebDriver driver;
    GenericUtils genericUtils;
@FindBy(tagName = "nav")
WebElement menu;
    @FindBy(xpath = "//span[text()='Barns & Horses']")
    WebElement barnForm;
    @FindBy(css = "input[placeholder='Search Horse']")
          WebElement searchHorse;
    @FindBy(css = ".list-container")
    List<WebElement> searchHorseList;

    public SearchHorse(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.genericUtils = new GenericUtils(driver);
    }
/*
* searchHorseWithname method search the horse and verify the searched name is displayed or not.
 */
    public void searchHorseWithName(String searchedHorse)  {
        genericUtils.openSideMenu(menu,barnForm);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        searchHorse.sendKeys(searchedHorse);
        for (WebElement listOfHorse:searchHorseList) {
            String nameHorse=listOfHorse.getText();
            if (nameHorse.equalsIgnoreCase(searchedHorse)){
                Assert.assertEquals(nameHorse,searchedHorse);
            }
        }
    }
    }








