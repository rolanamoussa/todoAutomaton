package org.example.FullCycle;

import dataProvider.loginDataProviders;
import dataProvider.signUpDataProvider;
import driverFactory.DriverFactory;
import org.example.page.homePage;
import org.example.page.loginPage;
import org.example.page.signupPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestFullCycle {


    WebDriver driver ;
    signupPage signupPage;
    loginPage loginPage;
    homePage homePage;


    String todoTitle ="Automation Task Todo";

    @BeforeClass
        public void initDriver() {
        DriverFactory.initDriver("Chrome");
        driver = DriverFactory.getDriver();

        driver.get("https://qacart-todo.herokuapp.com/signup");
    }

    @Test (priority=1,dataProvider = "ValidSignupData",dataProviderClass = signUpDataProvider.class)
    public void signUpNewUser(String firstName,String lastName,String email,String password,String confirmPassword){
    signupPage=new signupPage(driver);
        signupPage.signUp(firstName,lastName,email,password,confirmPassword);
    homePage=new homePage(driver);

        Assert.assertTrue(homePage.checkLogoutButtonDisplay(), "Signup failed, logout button not found!");
        homePage.clickLogout();
    }

    @Test(priority = 2, dependsOnMethods = {"signUpNewUser"}, dataProvider = "validLoginData", dataProviderClass = loginDataProviders.class)
    public void loginWithValidCredentials( String email, String password) {
        driver.get("https://qacart-todo.herokuapp.com/login");
        loginPage = new loginPage(driver);
        loginPage.Login(email,password);

        homePage = new homePage(driver);
        Assert.assertTrue(homePage.checkLogoutButtonDisplay(), "Login Failed!");
    }

@Test(priority = 3, dependsOnMethods = {"loginWithValidCredentials"})
    public void addNewTodo(){
    homePage.clickAddNewTodoButton();
    homePage.enterTodoTitle(todoTitle);
    homePage.clickCreateNewTodoButton();

    Assert.assertTrue(homePage.checkAddedTodoTitle(todoTitle));

}


@Test(priority = 4,  dependsOnMethods = {"addNewTodo"})
public void markTodoAsDone(){
        homePage.clickDoneCheckbox();
}
@Test(priority = 5, dependsOnMethods = {"markTodoAsDone"})
  public void unMarkTodo(){
    homePage.clickDoneCheckbox();
}

@Test(priority = 6, dependsOnMethods = {"unMarkTodo"})
    public void deleTodo(){
    homePage.clickDeleteButton();
    Assert.assertTrue(homePage.checkTodoIsDeleted(todoTitle));
}
}

