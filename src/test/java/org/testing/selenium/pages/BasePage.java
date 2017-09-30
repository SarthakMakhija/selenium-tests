package org.testing.selenium.pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void delay(TimeUnit timeUnit, int value) {
        try {
            timeUnit.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}