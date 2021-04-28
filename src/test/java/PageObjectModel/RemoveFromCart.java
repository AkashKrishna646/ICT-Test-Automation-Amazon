package PageObjectModel;

import commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RemoveFromCart extends Driver {
    //clickCart
    public void cartclick() {
        driver.findElement(By.xpath("//*[@id='attach-view-cart-button-form']")).click();
    }

//    //getCartPageItem
    public String CartPageItem() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ctm = driver.findElement(By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini sc-info-block']//span[1]"));
        String cartitem = ctm.getText();
        return cartitem;
    }

    //clickDelete
    public void delete() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        Thread.sleep(5000);
    }

    //checkemptmsgisPresent
    public boolean isemptymsgpresent() {
        WebElement emptymsg = driver.findElement(By.xpath("//div[@class='a-row sc-your-amazon-cart-is-empty']//h2"));
        return emptymsg.isDisplayed();
    }

    //getcartcount
    public String cartcount() {
        String cartnum = driver.findElement(By.id("nav-cart-count")).getText();
        return cartnum;
    }
}
