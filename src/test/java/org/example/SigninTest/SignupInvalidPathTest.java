package org.example.SigninTest;

import dataProvider.signUpDataProvider;
import driverFactory.DriverFactory;
import org.example.page.signupPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupInvalidPathTest {

        WebDriver driver;

        @BeforeClass
        public void initDriver(){
            DriverFactory.initDriver("chrome");
            driver = DriverFactory.getDriver();
        }

        @Test(dataProvider = "InvalidLoginData", dataProviderClass = signUpDataProvider.class)
        public void userCannotSignupWithInvalidData(
                String firstName, String lastName,
                String email, String password,
                String confirmPassword,
                String expectedErrorMessage,
                int scenarioNumber) {

            driver.get("https://qacart-todo.herokuapp.com/signup");
            signupPage signupPageObj = new signupPage(driver);

            signupPageObj.signUp(firstName, lastName, email, password, confirmPassword);

            String actualErrorMessage = signupPageObj.getSystemErrorMessage();

            Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                    "Negative Test Failed: Error message mismatch in scenario #" + scenarioNumber);
        }
    }

