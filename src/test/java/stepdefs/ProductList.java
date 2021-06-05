package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AmazonHomepage;
import pages.AmazonProductPage;
import pages.AmazonSearchResultPage;

public class ProductList{

    AmazonHomepage amazonHomepage;
    AmazonSearchResultPage amazonSearchResultPage;
    WebDriver driver;
    String url;
    String keyword;

    public ProductList(TestBase testBase){
        driver = testBase.driver;
    }

    @Given("User has navigated to {string} homepage")
    public void userHasNavigatedToHomepage(String url) {
        driver.get("https://www."+url);
        this.url=url;
    }

    @When("User enters the keyword {string} in search-box")
    public void userEntersTheKeywordInSearchBox(String keyword) {
        this.keyword = keyword;
        amazonHomepage = new AmazonHomepage(driver);
        amazonHomepage.enterKeywordToSearch(keyword);
    }

    @And("Presses the Search button")
    public void pressesTheSearchButton() {
        amazonHomepage.clickOnSearchButton();
    }

    @Then("Search result should contain correct product list")
    public void searchResultShouldContainCorrectProductList() {
        amazonSearchResultPage = new AmazonSearchResultPage(driver);
        amazonSearchResultPage.fetchDetailsAndWriteToExcel(url,keyword);
    }
}
