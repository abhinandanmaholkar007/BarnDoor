package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public  WebDriver driver;
    LoginPage loginPage;
    AddNewBarn addNewBarn;
    AddNewPasture addNewPasture;
    AddNewHorse addNewHorse;
    SearchHorse searchHorse;
    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public LoginPage getLoginPage()
    {
       this.loginPage=new LoginPage(driver);
       return loginPage;
    }

    public AddNewBarn getAddNewBarn()
    {
        this.addNewBarn=new AddNewBarn(driver);
        return addNewBarn;
    }

    public AddNewPasture getAddNewPasture()
    {
        this.addNewPasture=new AddNewPasture(driver);
        return addNewPasture;
    }

    public AddNewHorse getAddNewHorse()
    {
        this.addNewHorse=new AddNewHorse(driver);
        return addNewHorse;
    }

    public  SearchHorse getSearchHorse()
    {
        this.searchHorse=new SearchHorse(driver);
        return searchHorse;
    }



}
