package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.*;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaveForLaterTest extends Driver {
    @Test(dataProvider = "aDdToCaRt", dataProviderClass = DP_Login.class)
    public void SaveForLater(String product) throws InterruptedException {
        AddCart addCart = new AddCart(driver);
        int cartNum = addCart.cartnum();
        Assert.assertEquals(cartNum, 0);
        Search search = new Search(driver);
        //searchItemFunc
        search.searchItem(product);
        //resultPageFunc
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
        //get correct product text
        String correctItem = Common_for_Cart.checkProductItem();
        //checkingProductDetailsMatchWithItemDetails
        Assert.assertEquals(correctItem, itemList);
        //clickingAddToCart
        addCart.clickAddToCart();
        RemoveFromCart removeFromCart = new RemoveFromCart();
        //clickCart
        removeFromCart.cartclick();
//        //getCartPageItem
        String cartItem = removeFromCart.CartPageItem();
        //checkProduct and CartPageProduct
        Assert.assertEquals(cartItem, correctItem);
        SaveForLater SaveForLater = new SaveForLater();
//        clickSaveLaterButton
        SaveForLater.saveLater();
        //SaveForLaterPageAndMsgIsPresent
        boolean messagePresent = SaveForLater.isItemInSaveForLater();
        //checkSaveForLaterMsgIsPresent
        Assert.assertTrue(messagePresent);
        //get Cart Count
        String cartNumber = removeFromCart.cartcount();
//        //checkCartCountIsZero
        Assert.assertEquals(cartNumber, "0");


    }
}
