package org.testing.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testing.selenium.pages.ErrorPage;
import org.testing.selenium.pages.FormEntryPage;
import org.testing.selenium.pages.SuccessPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FormEntryTest {

    private static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.gecko.driver", "/Users/sarthakm/Downloads/geckodriver");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void shouldReturnSuccessPageGivenNonEmptyNameAndMessage(){
        FormEntryPage formEntryPage = new FormEntryPage(webDriver);
        SuccessPage successPage = formEntryPage.fillInForm("functional-test", "functional-test-description");

        assertEquals("Form filled out successfully", successPage.getSuccessMessage());
    }

    @Test
    public void shouldReturnSuccessPageGivenEmptyName(){
        FormEntryPage formEntryPage         = new FormEntryPage(webDriver);
        ErrorPage errorPage                 = formEntryPage.fillInFormWithEmptyName("functional-test-description");
        List<String> expectedErrorMessages  = Arrays.asList(new String[]{"Name"});

        assertEquals(1, errorPage.totalErrors());
        assertEquals(expectedErrorMessages, errorPage.getErrorMessages());
    }

    @Test
    public void shouldReturnSuccessPageGivenEmptyMessage(){
        FormEntryPage formEntryPage         = new FormEntryPage(webDriver);
        ErrorPage errorPage                 = formEntryPage.fillInFormWithEmptyMessage("functional-test");
        List<String> expectedErrorMessages  = Arrays.asList(new String[]{"Message"});

        assertEquals(1, errorPage.totalErrors());
        assertEquals(expectedErrorMessages, errorPage.getErrorMessages());
    }

    @Test
    public void shouldReturnSuccessPageGivenEmptyNameAndMessage(){
        FormEntryPage formEntryPage         = new FormEntryPage(webDriver);
        ErrorPage errorPage                 = formEntryPage.fillInFormWithEmptyNameAndMessage();
        List<String> expectedErrorMessages  = Arrays.asList(new String[]{"Name", "Message"});

        assertEquals(2, errorPage.totalErrors());
        assertEquals(expectedErrorMessages, errorPage.getErrorMessages());
    }

    @AfterClass
    public static void shutDown(){
        webDriver.quit();
    }
}