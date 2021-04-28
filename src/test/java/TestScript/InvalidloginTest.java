package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.InvalidLogin;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidloginTest extends Driver {
    @Test(dataProvider = "InvalidLogin", dataProviderClass = DP_Login.class)
    public void invalidlogin(String UserName) throws InterruptedException {
        InvalidLogin invalidlogin = new InvalidLogin(driver);
        invalidlogin.enterUsername(UserName);
        //Thread.sleep(4000);
        boolean error_msg_flag = invalidlogin.is_error_message_Present();
        Assert.assertEquals(true, error_msg_flag);
    }
}
