package Pages;

import DriverWrapper.Web;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Commands {
    Alert myAlert;
   // public WebElement getElement(By locator) { return Web.getDriver().findElement(locator); }
   public WebElement getElement(By locator) {
        //return Web.getDriver().findElement(locator);

       Wait fWait = new FluentWait(Web.getDriver())
               .withTimeout(Duration.ofSeconds(30))
               .pollingEvery(Duration.ofSeconds(1))
               .ignoring(NoSuchElementException.class)
               .ignoring(NoAlertPresentException.class)
               .ignoring(StaleElementReferenceException.class)
               .withMessage("Element is not found within 30 seconds");

       WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
           public WebElement apply(WebDriver driver) {
               return driver.findElement(locator);
           }
       });

       return element;
    }
   // public List<WebElement> getElements(By locator) { return Web.getDriver().findElements(locator); }
   public List<WebElement> getElements(By locator) {
       // wait for 30sec before declaring element is not found
       //return Web.getDriver().findElements(locator);

       Wait fWait = new FluentWait(Web.getDriver())
               .withTimeout(Duration.ofSeconds(30))
               .pollingEvery(Duration.ofSeconds(1))
               .ignoring(NoSuchElementException.class)
               .ignoring(NoAlertPresentException.class)
               .ignoring(StaleElementReferenceException.class)
               .withMessage("Elements are not found within 30 seconds");

       List<WebElement> elements = (List<WebElement>) fWait.until(new Function<WebDriver, List<WebElement>>() {
           public List<WebElement> apply(WebDriver driver) {
               return driver.findElements(locator);
           }
       });
       return elements;

   }

    public void clickThis(By locator) { getElement(locator).click(); }
    public void clickThis(WebElement element) { element.click();}

    public void type (By locator, String data) { getElement(locator).sendKeys(data);}
    public void type (WebElement element, String data) { element.sendKeys(data); }

    public boolean isElementEnabled(WebElement element) { return element.isEnabled();}
    public boolean isElementEnabled(By locator) { return getElement(locator).isEnabled();}

    public boolean isElementDisplayed(WebElement element) { return element.isDisplayed();}
    public boolean isElementDisplayed(By locator) { return getElement(locator).isDisplayed();}

    public boolean isElementSelected(WebElement element) { return element.isSelected();}
    public boolean isElementSelected(By locator) { return getElement(locator).isSelected();}

    public String getTextWeb(By locator) { return getElement(locator).getText();}
    public String getTextWeb(WebElement element) { return  element.getText();}

    public int getXCoordinate(By locator) { return getElement(locator).getLocation().getX();}
    public int getYCoordinate(By locator) { return getElement(locator).getLocation().getY();}

    public int getXCoordinate(WebElement element) { return element.getLocation().getX();}
    public int getYCoordinate(WebElement element) { return element.getLocation().getY();}

    public String getAttributeWeb(By locator, String attribute) { return getElement(locator).getAttribute(attribute);}
    public String getAttributeWeb(WebElement element, String attribute) {return element.getAttribute(attribute);}

    public void moveMouseOverElement(By locator) {
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(getElement(locator)).build().perform();
    }
    public void moveMouseOverElement(WebElement element) {
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(element).build().perform();
    }
    public void clickActionClass(By locator) {
        Actions act = new Actions(Web.getDriver());
        act.click(getElement(locator)).build().perform();
        }
    public void clickActionClass() {
        Actions act = new Actions(Web.getDriver());
        act.contextClick().build().perform();
    }

    public void actionPageDown() {
        Actions act = new Actions(Web.getDriver());
        act.keyDown(Keys.RIGHT).build().perform();
    }

    public void actionEnterKey() {
        Actions act = new Actions(Web.getDriver());
        act.keyDown(Keys.ENTER).build().perform();
    }

    public void actionScroll(By locator) {
        Actions act = new Actions(Web.getDriver());
        WebElement element = getElement(locator);
        act.moveToElement(element);
        act.dragAndDropBy(element,0,30).build().perform();
    }

    public void scrollToButton() {
        JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public void scrollDownByPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
        js.executeScript("scrollBy(0,"+pixels+");");
    }

    public void scrollUpByPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
        js.executeScript("scrollBy(0,-"+pixels+");");
    }

    public void scrollToElement(WebElement element) {
      JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
      js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public void selectFromDropDown(WebElement element, String data) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(data);
    }
    public void selectFromDropDown(By locator, String data) {
        Select dropdown = new Select(getElement(locator));
        dropdown.selectByVisibleText(data);
    }
    public void selectFromDropDownValue(WebElement element, String data) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(data);
    }

    public void selectFromAutoSuggestion(By locator, String dataToSelect){
        List<WebElement> allSuggestions = getElements(locator);
        for(WebElement suggestionElement: allSuggestions) {
            String suggestion = getTextWeb(suggestionElement);
            if(suggestion.equalsIgnoreCase(dataToSelect)){
                clickThis(suggestionElement);
                break;
            }
        }
    }

    public String getCurrentHandle(){ return Web.getDriver().getWindowHandle(); }
    public Set<String> getAllHandles() { Set<String> handles = Web.getDriver().getWindowHandles(); return handles;}
    public WebDriver switchToWindow(String handle) {return Web.getDriver().switchTo().window(handle);}
    public void closeAllHandlesButCurrent() {
       String currentHandle = Web.getDriver().getWindowHandle();
       Set<String> handles = Web.getDriver().getWindowHandles();
       for(String handle: handles) {
           if(!(handle.equalsIgnoreCase(currentHandle)))
           {
               Web.getDriver().switchTo().window(handle).close();
           }
       }
       Web.getDriver().switchTo().window(currentHandle);
   }

    public void switchToAlert() { myAlert = Web.getDriver().switchTo().alert(); }
    public String getAlertText() { return myAlert.getText();}
    public void clickAlertNegativeButton() { myAlert.dismiss(); }
    public void clickAlertPositiveButton() { myAlert.accept(); }
    public void typeOnAlert(String data) { myAlert.sendKeys(data); }
    public void switchToFrame(String id) { Web.getDriver().switchTo().frame(id); }
    public void switchToFrame(By locator) {
        WebElement frame = getElement(locator);
        Web.getDriver().switchTo().frame(frame);
    }
    public void switchToFrame(int index) { Web.getDriver().switchTo().frame(index); }

}
