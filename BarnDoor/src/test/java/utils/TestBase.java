package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public WebDriver WebDriverManager()  {
        FileInputStream fis;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//Global.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties pro=new Properties();
        try {
            pro.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String barnUrl= pro.getProperty("url");
        String browser=pro.getProperty("browser");
        if(driver==null)
        {
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                //firefox code
                driver=new FirefoxDriver();
            }
            assert driver != null;
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get(barnUrl);

    }
        return driver;
}
}
