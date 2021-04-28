package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.Search;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTestScript extends Driver {
    @Test(dataProvider = "ValidSearch", dataProviderClass = DP_Login.class)
    public void validateSearch(String pdt) throws InterruptedException {
        Search search = new Search(driver);
        search.searchItem(pdt);
        String SearchResult = search.CheckResultPage();//check user should be in result page
        Assert.assertEquals(SearchResult, pdt);
    }
}