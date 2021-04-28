package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.invalidPincode;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class invalidPinCodeTestScript extends Driver {
    @Test(dataProvider = "InValidPincode", dataProviderClass = DP_Login.class)
    public void invalidPinCode(String pincode) throws InterruptedException {
        invalidPincode invalidPincode = new invalidPincode(driver);
        invalidPincode.selectYourAddressClick();
        invalidPincode.Enterpincode(pincode);
        boolean value = invalidPincode.isErrorMsgPresent();
        Assert.assertEquals(value, true);
    }
}
