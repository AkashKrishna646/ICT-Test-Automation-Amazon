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
    public void Sort(String pdt) throws InterruptedException {
        Search search = new Search(driver);
        search.searchItem(pdt);
        SortPriceHighToLow sorting = new SortPriceHighToLow(driver);
        sorting.SetHightoLow();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text = sorting.extracthightolow();
        Assert.assertEquals(text, "Sort by:Price: High to Low");
    }
}
