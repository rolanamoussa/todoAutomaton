package org.example.loginTest;

import dataProvider.loginDataProviders;
import driverFactory.DriverFactory;
import org.example.page.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginInvalidScenario {
    WebDriver driver;

    @BeforeClass
    public void initDriver(){
        DriverFactory.initDriver("firefox");
        driver=DriverFactory.getDriver();
        driver.get("https://qacart-todo.herokuapp.com/login");
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = loginDataProviders.class)
    public void userCannotLoginWithInvalidData(
            String email,
            String password,
            String expectedErrorMessage,
            int scenarioNumber) {


        loginPage LoginPage = new loginPage(driver);
        LoginPage.Login(email, password);

        String actualErrorMessage = LoginPage.getSystemErrorMeassage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Negative Scenario Failed: Error message mismatch in scenario #" + scenarioNumber);


        String errorMessage="";
    switch(scenarioNumber){
        case 1:
            errorMessage= LoginPage.getEmailErrorMessage();
            break;
        case 2:
            errorMessage=LoginPage.getPasswordErrorMessage();
            break;
        case 3:
            errorMessage=LoginPage.getSystemErrorMeassage();
            break;
    }
        Assert.assertEquals(errorMessage,expectedErrorMessage,
                "Error message mismatch in scenario #" + scenarioNumber);
    }
@AfterMethod
public void refreshPage(){
    driver.navigate().refresh();

    }
}