package TestScript;

import DataProvider.DP_Login;
import PageObjectModel.ValidPinCode;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPinCodeTestScript extends Driver {
    @Test(dataProvider = "PinCode", dataProviderClass = DP_Login.class)
    public void pinCodeValidate(String pinCode) throws InterruptedException {
        ValidPinCode ValidPinCode = new ValidPinCode(driver);
        ValidPinCode.selectYourAddressClick();
        ValidPinCode.EnterPinCode(pinCode);
        String extractPinCode = ValidPinCode.ValidateHeaderPinCode();
        Assert.assertEquals(extractPinCode, pinCode);
    }
}
