package org.testing.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ErrorPage extends BasePage {

    @FindBys(@FindBy(xpath = ".//*[@id='et_pb_contact_form_0']/div[1]/ul[1]/li"))
    private List<WebElement> errorElements;

    public ErrorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getErrorMessages(){
        return errorElements.stream().map(webElement -> webElement.getText()).collect(toList());
    }

    public int totalErrors(){
        return errorElements.size();
    }
}