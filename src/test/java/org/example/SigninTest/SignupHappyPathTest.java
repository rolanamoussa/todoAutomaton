package org.example.SigninTest;

import dataProvider.signUpDataProvider;
import driverFactory.DriverFactory;
import org.example.page.signupPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupHappyPathTest {
    WebDriver driver;

    @BeforeClass
    public void initDriver(){
        DriverFactory.initDriver("chrome");
        driver = DriverFactory.getDriver();
    }

    @Test(dataProvider = "ValidSignupData", dataProviderClass = signUpDataProvider.class)
    public void userSignupSuccessfully(String firstName, String lastName,
                                       String email, String password,
                                       String confirmPassword) {

        driver.get("https://qacart-todo.herokuapp.com/signup");
        signupPage signupPageObj = new signupPage(driver);

        signupPageObj.signUp(firstName, lastName, email, password, confirmPassword);

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://qacart-todo.herokuapp.com/todo",
                "Happy Path Failed: User was not redirected to the todo page!");
    }
}