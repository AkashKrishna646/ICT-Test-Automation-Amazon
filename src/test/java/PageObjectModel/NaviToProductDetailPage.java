package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaviToProductDetailPage {
    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement hamburger;
    @FindBy(xpath = "//a[@class='hmenu-item' and @data-menu-id=8]")
    private WebElement category;
    @FindBy(xpath = "//ul[@data-menu-id=8]//a[@class='hmenu-item']")
    private WebElement subcategory;

    public NaviToProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() throws InterruptedException {
        hamburger.click();
        Thread.sleep(2000);
        category.click();
//        Thread.sleep(2000);
        subcategory.click();
        Thread.sleep(5000);
    }

}
