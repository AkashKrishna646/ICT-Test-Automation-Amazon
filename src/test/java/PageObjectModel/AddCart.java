package PageObjectModel;

import commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AddCart extends Driver {
    //cartcountlocator
    @FindBy(id = "nav-cart-count")
    private WebElement cartnumber;

    public AddCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //getCartCount
    public int cartnum() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int cartnumbr = Integer.parseInt(cartnumber.getText());
        return cartnumbr;
    }

    //tabchange
    public void tabchange() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    //changeCartQuantityTo3
    public void changeQuantityToThree() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select drpCountry = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));//quantity locator
        drpCountry.selectByVisibleText("3");
    }

    //clickAddToCart
    public void clickAddToCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement add_cartlocation = driver.findElement(By.id("add-to-cart-button"));//add item to cart
        add_cartlocation.click();
        Thread.sleep(5000);
    }


}

