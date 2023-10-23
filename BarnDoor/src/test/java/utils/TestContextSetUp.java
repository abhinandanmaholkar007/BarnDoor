package utils;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetUp {

    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetUp() throws IOException {
        testBase=new TestBase();
        pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
        genericUtils=new GenericUtils(testBase.WebDriverManager());
    }

}
