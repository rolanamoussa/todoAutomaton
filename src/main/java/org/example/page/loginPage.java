package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class loginPage extends basePage {


    //constructor
    public loginPage(WebDriver driver){
        super(driver);
    }



    //locators
    By emailFieldLocator= By.id("email");
    By PasswordFieldLocator=By.id("password");
    By loginButtonLocator=By.id("submit");

    //Error message Locators
    By emailErrorMessageLocator=By.id("email-helper-text");
    By passwordErrorMessageLocator=By.id("password-helper-text");
    By systemErrorMessageLocator= By.className("MuiAlert-message");


    //methods

    public loginPage enterEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
        return this;

    }

    public loginPage enterPassword(String password){
        driver.findElement(PasswordFieldLocator).sendKeys(password);
        return this ;
    }

    public void clickLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    //login method

    public void Login(String email, String password){
        this.enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();
    }
    //method for getting text from error messages
    public String getEmailErrorMessage(){
        WebElement emailError= driver.findElement(emailErrorMessageLocator);
        return emailError.getText();
    }

    public String getPasswordErrorMessage(){
        WebElement passwordError= driver.findElement(passwordErrorMessageLocator);
        return passwordError.getText();


    }

    public String getSystemErrorMeassage(){
        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(systemErrorMessageLocator));
        return emailError.getText();
    }
}
