package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidPinCode {
    @FindBy(xpath = "//span[@id='glow-ingress-line2']")
    private WebElement selectYourAddress;
    @FindBy(xpath = "//input[@id='GLUXZipUpdateInput']")
    private WebElement enter_A_PinCode;
    @FindBy(xpath = "//input[@aria-labelledby='GLUXZipUpdate-announce']")
    private WebElement applyClick;
    @FindBy(xpath = "//span[@id='glow-ingress-line2']")
    private WebElement headerPinCode;

    public ValidPinCode(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectYourAddressClick() {
        selectYourAddress.click();
    }

    public void EnterPinCode(String pinCode) throws InterruptedException {
        Thread.sleep(4000);
        enter_A_PinCode.sendKeys(pinCode);
        applyClick.click();
    }

    public String ValidateHeaderPinCode() throws InterruptedException {
        Thread.sleep(4000);
        String HeaderPinCode = headerPinCode.getText();
        String headerPinCode = HeaderPinCode.replaceAll("[^0-9]", "");
        return headerPinCode;
    }
}
