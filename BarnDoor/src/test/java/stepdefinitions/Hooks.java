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
    public void afterScenario() throws IOException {
         testContextSetUp.testBase.WebDriverManager().quit();
    }
    @AfterStep
    public void addScreenShots(Scenario scenario) throws IOException {
        WebDriver driver=testContextSetUp.testBase.WebDriverManager();
        if (scenario.isFailed())
        {
            File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent=FileUtils.readFileToByteArray(source);
            scenario.attach(fileContent,"image/png","image");

        }
    }
}
