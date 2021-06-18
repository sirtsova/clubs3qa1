package Pages;

import org.openqa.selenium.By;

public class StudentFlyerOrders {
    Commands cm = new Commands();
    By inputStudentName = By.id("student-name");
    By inputItemNumber = By.id("item-number");
    By buttonAdd = By.id("btn-add");
    By reviewCartButton = By.className("secondary");

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
       cm.clickThis(reviewCartButton);}

   /* public void enterItemNumber(String number) {cm.type(inputItemNumber,number);}
   public void clickButtonAdd() {cm.clickThis(buttonAdd);}
   public void changeQuantityForStudentWithItemNumber(String student, String itemNumber, String quantity) {
        By quantityNumber = By.xpath("//td[contains(text(),'"+student+"')]/..//a[contains(text(),'"+itemNumber+"')]/../following-sibling::td[@class=' item-qty']//input[@type='text']");
        cm.scrollToElement(cm.getElement(quantityNumber));
        cm.type(quantityNumber,quantity);
    }

    */


}
