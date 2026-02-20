package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class signupPage extends basePage {

//constructor
    public signupPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By firstnameFieldLocator= By.cssSelector("input[data-testid='first-name']");
    By lastNameFieldLocators=By.cssSelector("input[data-testid='last-name']");
    By emailFieldLocators=By.cssSelector("input[data-testid='email']");
    By passwordFieldLocators=By.cssSelector("input[data-testid='password']");
    By confirmPasswordFieldLocator= By.cssSelector("input[data-testid='confirm-password']");

    By signupButtonLocator=By.cssSelector("button[data-testid='submit']");

    //Error Message

    By fieldErrorMessageLocator= By.xpath("//p[contains(@class,'Mui-required')]");
    By systemErrorMessageLocator=By.className("MuiAlert-message");


    //method
    public signupPage entrFirstName(String firstName) {
        driver.findElement(firstnameFieldLocator).sendKeys(firstName);
        return this;
    }
    public signupPage enterLastName(String lastName){
        driver.findElement(lastNameFieldLocators).sendKeys(lastName);
        return this;
    }
    public signupPage enterEmail(String email){
        driver.findElement(emailFieldLocators).sendKeys(email);
        return this;
    }

    public signupPage enterPassword(String password){
        driver.findElement(passwordFieldLocators).sendKeys(password);
        return this;
    }

    public signupPage enterConfirmPassword(String confirmPassword){
        driver.findElement(confirmPasswordFieldLocator).sendKeys(confirmPassword);
        return this;
    }
    public void clickSignupButton() {
        driver.findElement(signupButtonLocator).click();
    }
    //sign method
    public void signUp(String firstName, String lastName, String email, String password, String confirmPassword){
        this.entrFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickSignupButton();
    }
    //methods to get
    public String getFieldErrorMessage(){
        WebElement fieldErrorMessage=driver.findElement(fieldErrorMessageLocator);
        return fieldErrorMessage.getText();
    }
    public String getSystemErrorMessage() {
        WebElement systemErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(systemErrorMessageLocator));
        if (systemErrorMessage == null) {
            return "WebElement is not displayed";
        } else {
            return systemErrorMessage.getText();
        }
    }
}
