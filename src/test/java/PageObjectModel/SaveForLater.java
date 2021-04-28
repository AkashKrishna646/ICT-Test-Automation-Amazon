package PageObjectModel;

import commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SaveForLater extends Driver {
    //clickSaveForLater
    public void saveLater() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='Save for later']")).click();
        Thread.sleep(4000);
    }

    //saveForLaterPageAndMsgIsPresent
    public boolean isItemInSaveForLater() {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement messagePresent = driver.findElement(By.xpath("//div[@id='sc-saved-cart-list-caption-text']"));
        return messagePresent.isDisplayed();
    }


}