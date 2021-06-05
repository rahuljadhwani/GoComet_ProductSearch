package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomepage {

    @FindBy(xpath="//input[contains(@title, 'Search for products')]")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    WebDriver driver;

    public FlipkartHomepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterKeywordToSearch(String keyword){
        searchBox.sendKeys(keyword);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }
}
