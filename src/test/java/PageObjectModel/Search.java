package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
    //searchbox
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement search;
    //search_button
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement search_button;
    //result_page
    @FindBy(xpath = "//span[text()='\"iphone 12\"']")//search eqal sided print
    private WebElement result_page;

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //searchItemFunction
    public void searchItem(String search_item) throws InterruptedException {
        search.sendKeys(search_item);
        Thread.sleep(2000);
        search_button.click();
        Thread.sleep(4000);
    }

    //result_pageFunction
    public String CheckResultPage() {
        String result = result_page.getText();
        result = result.replaceAll("^[\"']+|[\"']+$", "");
        return result;
    }
}
