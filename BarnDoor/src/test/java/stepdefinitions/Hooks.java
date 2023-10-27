package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetUp;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetUp testContextSetUp;
    public Hooks(TestContextSetUp testContextSetUp)  {
        this.testContextSetUp=testContextSetUp;
    }

    @After
    public void afterScenario()  {
        try {
            testContextSetUp.testBase.WebDriverManager().quit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterStep
    public void addScreenShots(Scenario scenario)  {
        WebDriver driver= null;
        try {
            driver = testContextSetUp.testBase.WebDriverManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (scenario.isFailed())
        {
            File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent= new byte[0];
            try {
                fileContent = FileUtils.readFileToByteArray(source);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            scenario.attach(fileContent,"image/png","image");

        }
    }
}
