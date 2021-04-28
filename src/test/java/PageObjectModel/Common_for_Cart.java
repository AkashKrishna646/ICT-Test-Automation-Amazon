package PageObjectModel;

import commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Common_for_Cart extends Driver {

    @FindBy(xpath = "//span[contains(text(),'New Apple iPhone 12 (128GB) - Blue')]")
    private WebElement Common_for_Cart;

    public Common_for_Cart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //item list
    public void Common_for_Cart() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Common_for_Cart.click();
    }

    //crct prdt
    public String checkProductItem() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement prdtname = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String result = prdtname.getText();
        return result;
    }

    //item list gettext
    public String itemList() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String rst = Common_for_Cart.getText();
        return rst;
    }

    public void change_Tab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
}
