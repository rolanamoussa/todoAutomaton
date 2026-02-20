package org.example.FullCycle;

import driverFactory.DriverFactory;
import org.example.page.homePage;
import org.example.page.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.jsonDataReader;

import java.util.List;
import java.util.Map;

public class TestFullCycle {

    String email;
    String password;
    WebDriver driver ;
    loginPage loginPage;
    homePage homePage;


    String todoTitle ="Automation Task Todo";

@BeforeClass
    public void initDriver() {
    DriverFactory.initDriver("Edge");
    driver = DriverFactory.getDriver();

    driver.get("https://qacart-todo.herokuapp.com/login");
}

@DataProvider(name = "validLoginData")
public Object[][] getValidLogin(){
    String path ="src/test/resourcess/loginData.json";
    List<Map<String, Object>> dataList= jsonDataReader.readJsonnListOfMaps(path);

    Object[][]data =new Object[dataList.size()][4];
    for(int i=0;i<dataList.size();i++){
        data[i][0]=dataList.get(i).get("email").toString();
        data[i][1]=dataList.get(i).get("password").toString();
    }
    return data;
    }

    @Test(dataProvider = "validLoginData")
    public void loginWithValidCredentials(){
loginPage=new loginPage(driver);
loginPage.Login(email,password);

homePage =new homePage(driver);

Assert.assertTrue(homePage.checkLogoutButtonDisplay());
}

@Test(dependsOnMethods = {"loginWithValidCredentials"})
    public void addNewTodo(){
    homePage.clickAddNewTodoButton();
    homePage.enterTodoTitle(todoTitle);
    homePage.clickCreateNewTodoButton();

}

@Test(dependsOnMethods = {"addNewTodo"})
  public void unMarkTodo(){
    homePage.clickDoneCheckbox();
}

@Test(dependsOnMethods = {"unMarkTodo"})
    public void deleTodo(){
    homePage.clickDeleteButton();
    Assert.assertTrue(homePage.checkTodoIsDeleted(todoTitle));
}
}

