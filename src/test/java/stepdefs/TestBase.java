package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
       // return driver;
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
