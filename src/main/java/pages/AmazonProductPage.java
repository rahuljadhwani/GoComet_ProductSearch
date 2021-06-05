package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

import java.util.ArrayList;

public class AmazonProductPage {

    @FindBy(xpath="//span[@id='productTitle']")
    WebElement productTitle;

    @FindBy(xpath="//span[contains(@class,'color-price')]/span[@class='currencyINR']/parent::span")
    WebElement productPrice;

    By priceLocator = By.xpath("//span[contains(@class,'color-price')]/span[@class='currencyINR']/parent::span");

    @FindBy(xpath ="//tr/th[contains(text(),'OS')]/following-sibling::td")
    WebElement category;

    @FindBy(xpath = "//tr/th[contains(text(), 'ASIN')]/following-sibling::td")
    WebElement serialNumber;

    WebDriver driver;
    WaitUtil waitUtil;

    public AmazonProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ArrayList<String> returnProductDetails(){

        ArrayList<String> currentProductList = new ArrayList();
        currentProductList.add(productTitle.getText().trim());
        waitUtil = new WaitUtil(driver);
        waitUtil.waitForElementsVisibility(priceLocator);
        currentProductList.add(productPrice.getText().trim());
        currentProductList.add(category.getText().trim());
        currentProductList.add(serialNumber.getText().trim());
        return currentProductList;
    }

}
