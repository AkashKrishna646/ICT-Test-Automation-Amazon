package DataProvider;

import org.testng.annotations.DataProvider;

public class DP_Login {

    @DataProvider(name = "InvalidLogin")
    public static Object[][] dataProvider_invalidlogin() {
        return new Object[][]{
                {"8606736644"}
        };
    }

    @DataProvider(name = "ValidSearch")
    public static Object[][] dataProvider_search() {
        return new Object[][]{
                {"iphone 12"}
        };
    }

    @DataProvider(name = "productSearch")
    public static Object[][] dataProvider_productSearch() {
        return new Object[][]{
                {"iphone 12"}
        };
    }

    @DataProvider(name = "aDdToCaRt")
    public static Object[][] dataProvider_AddToCart() {
        return new Object[][]{
                {"iphone 12"}
        };
    }

    @DataProvider(name = "PinCode")
    public static Object[][] dataProvider_PinCode() {
        return new Object[][]{
                {"695011"}
        };
    }

    @DataProvider(name = "InValidPinCode")
    public static Object[][] dataProvider_Invalid_PinCode() {
        return new Object[][]{
                {"1234"}
        };
    }


}
