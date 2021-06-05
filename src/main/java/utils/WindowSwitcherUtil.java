package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowSwitcherUtil {

    WebDriver driver;

    public WindowSwitcherUtil(WebDriver driver){
        this.driver = driver;
    }
    public void switchWindow(String pageTitle){

        Set<String> allWindows  = driver.getWindowHandles();

        for(String current:allWindows){
            driver.switchTo().window(current);
            if(driver.getTitle().contains(pageTitle)){
                break;
            }
        }
    }

    public void switchToParentWindow(String currentHandle){
        driver.close();
        driver.switchTo().window(currentHandle);
    }
}
