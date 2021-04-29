package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class invalidPinCode {
    @FindBy(xpath = "//span[@id='glow-ingress-line2']")
    private WebElement select_address;
    @FindBy(xpath = "//input[@id='GLUXZipUpdateInput']")
    private WebElement enter_a_pinCode;
    @FindBy(xpath = "//input[@aria-labelledby='GLUXZipUpdate-announce']")
    private WebElement apply_click;
    @FindBy(xpath = "//span[@id='glow-ingress-line2']")
    private WebElement header_pinCode;
    @FindBy(xpath = "//div[@class='a-box-inner a-alert-container']")
    private WebElement error_msg;

    public invalidPinCode(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectYourAddressClick() {
        select_address.click();
    }

    public void EnterPinCode(String pinCode) throws InterruptedException {
        Thread.sleep(4000);
        enter_a_pinCode.sendKeys(pinCode);
        apply_click.click();
        Thread.sleep(4000);
    }

    public boolean isErrorMsgPresent() {
        return error_msg.isDisplayed();
    }
}
