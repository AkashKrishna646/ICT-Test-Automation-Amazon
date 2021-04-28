package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortPriceHighToLow {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement search;
    @FindBy(className = "nav-input")
    private WebElement searchButton;
    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    private WebElement sortBy;
    @FindBy(xpath = "//a[@id='s-result-sort-select_2']")
    private WebElement hightolowclick;
    @FindBy(xpath = "//span[@id='a-autoid-2-announce']")
    private WebElement getTexthightolow;


    public SortPriceHighToLow(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void SetHightoLow() throws InterruptedException {
        sortBy.click();
        //Thread.sleep(2000);
        hightolowclick.click();
    }

    public String extracthightolow() {
        String HighToLow = getTexthightolow.getText();
        System.out.println(HighToLow);
        return HighToLow;
    }
}
