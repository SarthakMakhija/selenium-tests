# selenium-tests
Sample project to learn project object model with Selenium against [Sample Website](https://www.ultimateqa.com/filling-out-forms/)

## Page Object Model
Page Object model is an object design pattern in Selenium, where web pages are represented as classes, and the various 
elements on the page are defined as variables on the class. All possible user interactions can then be implemented as methods on the class.

## Structure of a test
```java
  @Test
  public void shouldReturnErrorPageGivenEmptyName(){
      FormEntryPage formEntryPage         = new FormEntryPage(webDriver);
      ErrorPage errorPage                 = formEntryPage.fillInFormWithEmptyName("functional-test-description");
      List<String> expectedErrorMessages  = Arrays.asList(new String[]{"Name"});

      assertEquals(1, errorPage.totalErrors());
      assertEquals(expectedErrorMessages, errorPage.getErrorMessages());
  }
```    

## Structure of a Page Object
```java
  public class ErrorPage extends BasePage {

    @FindBys(@FindBy(xpath = ".//*[@id='et_pb_contact_form_0']/div[1]/ul[1]/li"))
    private List<WebElement> errorElements;

    //constructor...
    
    public int totalErrors(){
        return errorElements.size();
    }
    //...other bahaviors
}
```
