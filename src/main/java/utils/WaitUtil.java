package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    WebDriverWait wait;
    WebDriver driver;

    public WaitUtil(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    public void waitForElementsVisibility(By elementLocator){
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

}
