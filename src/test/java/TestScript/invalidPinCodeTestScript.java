package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.invalidPinCode;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class invalidPinCodeTestScript extends Driver {
    @Test(dataProvider = "InValidPinCode", dataProviderClass = DP_Login.class)
    public void invalidPinCode(String pinCode) throws InterruptedException {
        invalidPinCode invalidPincode = new invalidPinCode(driver);
        invalidPincode.selectYourAddressClick();
        invalidPincode.EnterPinCode(pinCode);
        boolean value = invalidPincode.isErrorMsgPresent();
        Assert.assertEquals(value, true);
    }
}
