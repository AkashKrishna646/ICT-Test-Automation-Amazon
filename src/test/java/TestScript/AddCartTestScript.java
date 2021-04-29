package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.AddCart;
import PageObjectModel.Common_for_Cart;
import PageObjectModel.Search;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCartTestScript extends Driver {
    @Test(dataProvider = "aDdToCaRt", dataProviderClass = DP_Login.class)
    public void AddToCart(String product) throws InterruptedException {
        AddCart addCart = new AddCart(driver);
        int cartNumber = addCart.cartNum();
        Assert.assertEquals(cartNumber, 0);
        Search search = new Search(driver);
        //searchItemFunction
        search.searchItem(product);
        //resultPageFunction
        java.lang.String searchResult = search.CheckResultPage();
        //verifyUserShouldBeInCorrectPage
        Assert.assertEquals(searchResult, product);
        Common_for_Cart Common_for_Cart = new Common_for_Cart(driver);
        //item list gettext
        java.lang.String itemList = Common_for_Cart.itemList();
        //clicking in item list
        Common_for_Cart.Common_for_Cart();
        //change_Tab
        Common_for_Cart.change_Tab();
        //getCorrectProductText
        java.lang.String correctItem = Common_for_Cart.checkProductItem();
        //checkingProductDetailsMatchWithItemDetails
        Assert.assertEquals(correctItem, itemList);
        //clickItemQuantityTo3
        addCart.changeQuantityToThree();
        //clickingAddToCart
        addCart.clickAddToCart();
        
    }
}
