package org.testing.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FormEntryPage extends BasePage {

    @FindBy(id = "et_pb_contact_name_1")
    private WebElement nameElement;

    @FindBy(id = "et_pb_contact_message_1")
    private WebElement messageElement;

    @FindBy(xpath = ".//*[@id='et_pb_contact_form_0']/div[2]/form/div/button")
    private WebElement submitButtonElement;

    private static final String URL = "https://www.ultimateqa.com/filling-out-forms/";

    public FormEntryPage( WebDriver webDriver ) {
        super(webDriver);
        webDriver.get(URL);
        PageFactory.initElements(webDriver, this);
    }

    public SuccessPage fillInForm(String name, String message){
        Objects.nonNull(name);
        Objects.nonNull(message);

        nameElement.sendKeys(name);
        messageElement.sendKeys(message);
        submit();

        return new SuccessPage(webDriver);
    }

    public ErrorPage fillInFormWithEmptyMessage(String name){
        Objects.nonNull(name);

        nameElement.sendKeys(name);
        messageElement.sendKeys("");
        submit();

        return new ErrorPage(webDriver);
    }

    public ErrorPage fillInFormWithEmptyName(String message){
        Objects.nonNull(message);

        nameElement.sendKeys("");
        messageElement.sendKeys(message);
        submit();

        return new ErrorPage(webDriver);
    }

    public ErrorPage fillInFormWithEmptyNameAndMessage(){
        nameElement.sendKeys("");
        messageElement.sendKeys("");
        submit();

        return new ErrorPage(webDriver);
    }

    private void submit(){
        submitButtonElement.submit();
        delay(TimeUnit.SECONDS, 1);
    }
}