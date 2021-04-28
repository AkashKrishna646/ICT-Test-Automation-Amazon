package TestScript;

import PageObjectModel.NaviToProductDetailPage;
import commons.Driver;
import org.testng.annotations.Test;

public class NaviToProductDetailPageTest extends Driver {
    @Test
    public void navigate() throws InterruptedException {
        NaviToProductDetailPage naviToPageDetailPage = new NaviToProductDetailPage(driver);
        naviToPageDetailPage.selectProduct();
    }
}
