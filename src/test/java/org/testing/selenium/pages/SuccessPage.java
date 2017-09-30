package org.testing.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage extends BasePage {

    @FindBy(xpath = ".//*[@id='et_pb_contact_form_0']/div/p")
    private WebElement successMessageElement;

    public SuccessPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getSuccessMessage(){
        return successMessageElement.getText();
    }
}