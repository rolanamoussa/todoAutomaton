package org.example.loginTest;

import dataProvider.loginDataProviders;
import driverFactory.DriverFactory;
import org.example.page.homePage;
import org.example.page.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginHappyScenario {
    WebDriver driver;

    @BeforeClass
    public void initDriver(){
        DriverFactory.initDriver("chrome");
        driver = DriverFactory.getDriver();
    }

    @Test(dataProvider = "validLoginData", dataProviderClass = loginDataProviders.class)
    public void userCanLoginWithValidCredentials(String email, String password){
        driver.get("https://qacart-todo.herokuapp.com/login");

        loginPage LoginPage = new loginPage(driver);
        LoginPage.Login(email, password);

        homePage homePage = new homePage(driver);

        Assert.assertTrue(homePage.checkLogoutButtonDisplay(), "Happy Path Failed: Logout Button is not displayed");
    }
}