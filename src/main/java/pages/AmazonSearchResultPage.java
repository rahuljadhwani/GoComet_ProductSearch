package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExcelUtil;
import utils.WindowSwitcherUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AmazonSearchResultPage {

    @FindBy(xpath = "//div[@class='sg-row']/descendant::h2/a/span")
    List<WebElement> searchResult;

    WebDriver driver;
    WindowSwitcherUtil windowSwitcherUtil;
    AmazonProductPage amazonProductPage;
    String currentSearchResultWindow;
    ArrayList<ArrayList<String>> productDetailsList;
    ExcelUtil excelUtil;

    public AmazonSearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public void fetchDetailsAndWriteToExcel(String source, String productType){
        productDetailsList = new ArrayList();
        currentSearchResultWindow = driver.getWindowHandle();
        for(int i=0; i<searchResult.size(); i++) {
            String pageTitle = searchResult.get(i).getText().trim();
            searchResult.get(i).click();
            windowSwitcherUtil = new WindowSwitcherUtil(driver);
            windowSwitcherUtil.switchWindow(pageTitle);
            amazonProductPage = new AmazonProductPage(driver);
            ArrayList<String> fetchedList = amazonProductPage.returnProductDetails();
            fetchedList.add(source);
            productDetailsList.add(fetchedList);
            windowSwitcherUtil.switchToParentWindow(currentSearchResultWindow);
            dataIntoExcel(productDetailsList,productType);
        }
        System.out.println(productDetailsList);
    }

    private void dataIntoExcel(ArrayList<ArrayList<String>> productDetailsList, String productType) {
        excelUtil = new ExcelUtil();
        for (int i=0; i<productDetailsList.size(); i++) {
            try {
                excelUtil.writeIntoExcel(productType, productDetailsList.get(i));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
