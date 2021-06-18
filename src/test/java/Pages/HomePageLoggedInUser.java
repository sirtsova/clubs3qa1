package Pages;

import DriverWrapper.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageLoggedInUser {
    Commands cm = new Commands();
    By searchBoxQuickViewField = By.id("q");
    By searchBoxQuickViewButton = By.xpath("//i[contains(@class,'fa-search')]");
    By recommendedStarBtn = By.xpath("//div[contains(@class,'recommended-button')]");
            //By.xpath("//span[@class='icon-button-text' and text()='Recommended']/preceding-sibling::span");
    By toolTipster_X = By.xpath("//span[@class='tooltipster-close ']");
    By closeQuickLookBtn = By.xpath("//button[@title='Close']");
    By myListBnt = By.xpath("//span[text()='My Lists']/following-sibling::span");
    By itemTitleFromQuickLook = By.xpath("//h1[@itemprop='name']//a");
    By itemsAddedToRecommendationForStudent = By.xpath("//div[@class='recommendationtostudentspage']//div[@class='product-list-item']//a");

    public void typeBookOrAuthorData(String data) {cm.type(searchBoxQuickViewField,data);}
    public void clickOnSearchButton() {cm.clickActionClass(searchBoxQuickViewButton);}
    public void closeToolTipsters() {
        try {
            List<WebElement> tipsters = cm.getElements(toolTipster_X);
            for (WebElement tipster : tipsters) {
                cm.clickThis(tipster);
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    public void clickOnQuickLookOfBook(String partialBookTitle) {
            By imgOfBook = By.xpath("//a[@class='thumb-link' and contains(@title,'" + partialBookTitle + "')]");
            By quickLook = By.xpath("//div[@class='product-tile-image-vertMid']//a[contains(@title,'" + partialBookTitle + "')]//following-sibling::a[@class='quickview']");
            if (!(cm.isElementDisplayed(imgOfBook))) {
                cm.clickActionClass(searchBoxQuickViewButton);
                cm.scrollToElement(cm.getElement(imgOfBook));
            }
            cm.moveMouseOverElement(imgOfBook);
            cm.clickThis(quickLook);

    }
    public void closeAllHandles() {cm.closeAllHandlesButCurrent();}
    public void clickOnRecommended() {
        try {
            cm.clickActionClass(recommendedStarBtn);
        } catch (NoSuchElementException e) {
            cm.clickThis(recommendedStarBtn);
        }
          }
    public void selectOptionFromRecommend(String partialTextOfTheOptionToChoose) {
        By checkBox = By.xpath("//div[contains(text(),'"+partialTextOfTheOptionToChoose+"')]/preceding-sibling::div//input");
        cm.clickThis(checkBox);
    }
    public String getQuickLookBookTitle() {return cm.getTextWeb(itemTitleFromQuickLook);}

    public void closeQuickLookWindow() {cm.clickThis(closeQuickLookBtn);}
    public void scrollUpToMyLists() {cm.scrollToElement(cm.getElement(myListBnt));}
    public void clickMyListsBtn() {cm.clickThis(myListBnt);}
    public void selectOptionFromMyLists(String partialTextOfOption) {
        By option = By.xpath("//li[contains(@class,'mylists')]//div[@class='toggle-content']//a[contains(text(),'"+partialTextOfOption+"')]");
        cm.clickThis(option);
    }
    public List<WebElement> getItemsElementsAddedToRecommendationsForStudent() {
        return cm.getElements(itemsAddedToRecommendationForStudent);
    }

    By enterOrdersDropDown = By.xpath("(//a[@id='enter-orders' and contains(text(),'Enter Orders')])[2]");
    public void clickOnEnterOrdersDropDown() {cm.moveMouseOverElement(enterOrdersDropDown);}
    By studentFlyerOrders = By.xpath("(//li[@id='student-flyer-orders']//a)[2]");
    public void selectStudentFlyerOrders() {cm.clickActionClass(studentFlyerOrders);}
    By yourTeacherOrder = By.xpath("(//li[@id='your-teacher-order']//a)[2]");
    public void selectYourTeacherOrder() {cm.clickActionClass(yourTeacherOrder);}


}
