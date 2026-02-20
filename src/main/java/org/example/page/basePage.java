package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public basePage(WebDriver driver){
        this.driver = driver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    //methods
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public String getPageTitle()
    {
        return driver.getTitle();
    }
}
