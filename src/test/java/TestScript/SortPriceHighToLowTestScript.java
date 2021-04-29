package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.Search;
import PageObjectModel.SortPriceHighToLow;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SortPriceHighToLowTestScript extends Driver {
    @Test(dataProvider = "ValidSearch", dataProviderClass = DP_Login.class)
    public void Sort(String product) throws InterruptedException {
        Search search = new Search(driver);
        search.searchItem(product);
        SortPriceHighToLow sorting = new SortPriceHighToLow(driver);
        sorting.SetHighToLow();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text = sorting.extractHighToLow();
        Assert.assertEquals(text, "Sort by:Price: High to Low");
    }
}
