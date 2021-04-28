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
    public void AddToCart(String prdt) throws InterruptedException {
        AddCart addCart = new AddCart(driver);
        int cartnumber = addCart.cartnum();
        Assert.assertEquals(cartnumber, 0);
        Search search = new Search(driver);
        //searchItemfun
        search.searchItem(prdt);
        //resultpagefunc
        java.lang.String Srchrslt = search.CheckResultPage();
        //verifyUsershouldbeincorrectpage
        Assert.assertEquals(Srchrslt, prdt);
        Common_for_Cart Common_for_Cart = new Common_for_Cart(driver);
        //item list gettext
        java.lang.String itemlist = Common_for_Cart.itemList();
        //clicking in item list
        Common_for_Cart.Common_for_Cart();
        //change_Tab
        Common_for_Cart.change_Tab();
        //getcorrectproducttext
        java.lang.String crctitm = Common_for_Cart.checkProductItem();
        //checkingPrdtDetailsMatchWithItemdetails
        Assert.assertEquals(crctitm, itemlist);
        //clickitemquantityto3
        addCart.changeQuantityToThree();
        //clickingAddtoCart
        addCart.clickAddToCart();
        
    }
}
