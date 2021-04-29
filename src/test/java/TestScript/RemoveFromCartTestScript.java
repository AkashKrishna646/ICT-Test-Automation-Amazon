package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.AddCart;
import PageObjectModel.Common_for_Cart;
import PageObjectModel.RemoveFromCart;
import PageObjectModel.Search;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromCartTestScript extends Driver {
    @Test(dataProvider = "aDdToCaRt", dataProviderClass = DP_Login.class)
    public void removeFromCart(String product) throws InterruptedException {
        AddCart addCart = new AddCart(driver);
        int cartNum = addCart.cartNum();
        Assert.assertEquals(cartNum, 0);
        Search search = new Search(driver);
        //searchItemFunction
        search.searchItem(product);
        //resultPageFunction
        String searchResult = search.CheckResultPage();
        //verifyUserShouldBeInCorrectPage
        Assert.assertEquals(searchResult, product);
        Common_for_Cart Common_for_Cart = new Common_for_Cart(driver);
        //item list gettext
        String itemList = Common_for_Cart.itemList();
        //clicking in item list
        Common_for_Cart.Common_for_Cart();
        //change_Tab
        Common_for_Cart.change_Tab();
        //getCorrectProductText
        String correctItem = Common_for_Cart.checkProductItem();
        //checkingProductDetailsMatchWithItemDetails
        Assert.assertEquals(correctItem, itemList);
        //clickingAddToCart
        addCart.clickAddToCart();
        RemoveFromCart removeFromCart = new RemoveFromCart();
        //clickCart
        removeFromCart.cartclick();
        //getCartPageItem
        String cartItem = removeFromCart.CartPageItem();
        //checkProductAndCartPageProduct
        Assert.assertEquals(cartItem, correctItem);
        //click delete
        removeFromCart.delete();
        //getEmptyMsgIsPresent
        boolean emptyMsg = removeFromCart.isemptymsgpresent();
        //checkEmptyMsgIsPresent
        Assert.assertEquals(emptyMsg, true);
        //getCartCount
        String cartNumber = removeFromCart.cartcount();
////        //checkCartCountIsZero
        Assert.assertEquals(cartNumber, "0");

    }
}