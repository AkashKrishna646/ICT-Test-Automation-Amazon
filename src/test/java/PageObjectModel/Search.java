package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
    //searchbox
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement search;
    //search_button
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement search_button;
    //result_page
    @FindBy(xpath = "//span[text()='\"iphone 12\"']")//search eqal sided print
    private WebElement result_page;

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //searchItemfunc
    public void searchItem(String search_item) throws InterruptedException {
        search.sendKeys(search_item);
        Thread.sleep(2000);
        search_button.click();
        Thread.sleep(4000);
    }

    //result_pagefunc
    public String CheckResultPage() {
        String rlt = result_page.getText();
        rlt = rlt.replaceAll("^[\"']+|[\"']+$", "");
        return rlt;
    }
}
