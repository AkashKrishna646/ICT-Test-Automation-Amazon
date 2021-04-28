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
    public void removeFROMcart(String prdt) throws InterruptedException {
        AddCart addCart = new AddCart(driver);
        int crtnum = addCart.cartnum();
        Assert.assertEquals(crtnum, 0);
        Search search = new Search(driver);
        //searchitemfun
        search.searchItem(prdt);
        //resultpagefunc
        String Srchrslt = search.CheckResultPage();
        //verifyUsershouldbeincorrectpage
        Assert.assertEquals(Srchrslt, prdt);
        Common_for_Cart Common_for_Cart = new Common_for_Cart(driver);
        //item list gettext
        String itemlist = Common_for_Cart.itemList();
        //clicking in item list
        Common_for_Cart.Common_for_Cart();
        //change_Tab
        Common_for_Cart.change_Tab();
        //getcorrectproducttext
        String crctitm = Common_for_Cart.checkProductItem();
        //checkingPrdtDetailsMatchWithItemdetails
        Assert.assertEquals(crctitm, itemlist);
        //clickingAddtoCart
        addCart.clickAddToCart();
        RemoveFromCart rmvfrmcrt = new RemoveFromCart();
        //clickCart
        rmvfrmcrt.cartclick();
        //getCartPageItem
        String cartitem = rmvfrmcrt.CartPageItem();
        //checkPrdtandCartpageproduct
        Assert.assertEquals(cartitem, crctitm);
        //click delete
        rmvfrmcrt.delete();
        //getemptmsgisPresent
        boolean emptymsg = rmvfrmcrt.isemptymsgpresent();
        //checkemptymsgispresent
        Assert.assertEquals(emptymsg, true);
        //getcartcount
        String cartnumber = rmvfrmcrt.cartcount();
////        //checkcartcountiszero
        Assert.assertEquals(cartnumber, "0");

    }
}