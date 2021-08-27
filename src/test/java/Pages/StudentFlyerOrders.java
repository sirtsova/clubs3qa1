package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class StudentFlyerOrders {
    Commands cm = new Commands();
    By inputStudentName = By.id("student-name");
    By inputItemNumber = By.id("item-number");
    By buttonAdd = By.id("btn-add");
    By reviewCartButton = By.className("secondary");
    By errorMessage = By.id("error-message-tooltip");

   public void addItems(String name, String number, String quantity) {
       int num = Integer.parseInt(quantity);
       int count = 0;
       do {
           cm.type(inputStudentName, name);
           cm.type(inputItemNumber, number);
           cm.clickThis(buttonAdd);
           count++;
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       } while(count!=num);
    }

    public void clickReviewCart() {
       cm.scrollToElement(cm.getElement(reviewCartButton));
       cm.clickThis(reviewCartButton);
   }

   public boolean isErrorMessageAppearsForWrongItemNumber() {
       boolean isDisplayed = true;
       try {
           isDisplayed = cm.isElementDisplayed(errorMessage);
       } catch (NoSuchElementException e) {
           e.printStackTrace();
           isDisplayed = false;
       } catch (TimeoutException to) {
           isDisplayed = false;
       }

       return isDisplayed;
   }

   public String getTextFromErrorMessage() {
       String errorMessageText = null;
       try {
           errorMessageText = cm.getTextWeb(errorMessage);
       } catch (NoSuchElementException e) {
          } catch (TimeoutException e) { }
       return errorMessageText;
   }


}
