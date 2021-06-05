package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomepage {

    @FindBy(xpath = "//input[contains(@id,'searchtextbox')]")
    WebElement searchBox;

    @FindBy(xpath = "//input[contains(@id,'submit-button')]")
    WebElement searchButton;

    WebDriver driver;

    public AmazonHomepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterKeywordToSearch(String keyword){
        searchBox.sendKeys(keyword);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }
}
