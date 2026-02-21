package org.example.page;

import org.example.page.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class homePage extends basePage {

    //Constructor
    public homePage(WebDriver driver) {
        super(driver);
    }

    //Locators

    By logoutButtonLocator = By.xpath("//span[text()='Logout']");
    By addNewTodoButtonLocator = By.xpath("(//button[@aria-label='delete'])[1]");
    By firstDoneCheckboxButtonLocator = By.xpath("(//input[@data-testid='complete-task'])[1]");
    By firstTodoLocator = By.xpath("(//h2[@data-testid='todo-text'])[1]");
    By firstDeleteButtonLocator = By.xpath("(//button[@data-testid='delete'])[1]");

    By firstTodoDivLocator = By.xpath("(//div[@data-testid='todo-item'])[1]");

    //Add New TODO Locators
    By todoNameFieldLocator = By.cssSelector("input[data-testid='new-todo']");
    By createTodoButtonLocator = By.cssSelector("button[data-testid='submit-newTask']");

    //Dynamic Locator for Todo

    //h2[text()='Task Title']"
    String staticPart1 = "//h2[text()='";
    String staticPart2 = "']";


    //Methods
    public boolean checkLogoutButtonDisplay(){
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator));
        if(logoutButton == null){
            return false;
        }else {
            return logoutButton.isDisplayed();
        }
    }
    // Method to perform Logout
    public void clickLogout() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutButtonLocator));
        logoutButton.click();
    }

    //Methods to Add New Todo
    public void clickAddNewTodoButton(){
        driver.findElement(addNewTodoButtonLocator).click();
    }

    public void enterTodoTitle(String todoTitle){
        WebElement todoTitleField = wait.until(ExpectedConditions.visibilityOfElementLocated(todoNameFieldLocator));
        if(todoTitleField == null){
            System.out.println("Todo Title Field is not displayed");
        }else {
            todoTitleField.sendKeys(todoTitle);
        }
    }

    public void clickCreateNewTodoButton(){
        driver.findElement(createTodoButtonLocator).click();
    }

    //Method to check the added todo
    public boolean checkAddedTodoTitle(String title){
        WebElement newAddedTodo = wait.until(ExpectedConditions.visibilityOfElementLocated(firstTodoLocator));
        if (newAddedTodo == null){
            return false;
        }else {
            return title.equals(newAddedTodo.getText());
        }
    }

    //Method to click the Done checkbox
    public void clickDoneCheckbox(){
        driver.findElement(firstDoneCheckboxButtonLocator).click();
    }

    //Method to delete Todo
    public void clickDeleteButton(){
        driver.findElement(firstDeleteButtonLocator).click();
    }


    //Method to check that the todo is deleted
    public boolean checkTodoIsDeleted(String todoTitle){
        String xpathLocator = staticPart1 + todoTitle + staticPart2;
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathLocator)));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }


    //Method to check if the todo is marked as done by checking background color
    public boolean checkTodoBackGroundColor(String backgroundColor){
        WebElement todo = driver.findElement(firstTodoDivLocator);
        System.out.println(todo.getAttribute("background-color"));

        return backgroundColor.equals(todo.getAttribute("background-color"));
    }


}