package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.util.HashMap;

public class ReviewCart {
    Commands cm = new Commands();
    By harryItemsTotalPrice = By.xpath("//ul[@class='std-total']//li[contains(text(),'Harry')]/following-sibling::li[contains(@class,'stdPriceTotal')]");
    By harryItemsQuantity = By.xpath("//ul[@class='std-total']//li[contains(text(),'Harry')]/following-sibling::li[contains(@class,'std-total-qty')]//span");
    By totalPrice = By.xpath("//li[contains(@class,'sfoSubTotalPrice')]");
    By totalQuantity = By.xpath("//span[contains(@class,'sfoSubTotalQty')]");
    By removeConfirmationButton_Yes = By.xpath("//button[contains(@class,'removeYes')]");
    By proceedToCheckOut = By.xpath("//button[contains(text(),'Proceed to Checkout')]");
    By proceedToCheckOut_2 = By.xpath("(//button[@class='button-text'])[2]");



    public double getHarryTotalPrice() {
        cm.scrollToElement(cm.getElement(harryItemsTotalPrice));
        String harryTotalPrice = cm.getTextWeb(harryItemsTotalPrice).replace("$","");
        double harryTotalPriceInt = Double.parseDouble(harryTotalPrice);
        return harryTotalPriceInt;
    }

    public int getHarryTotalQuantity() {
        cm.scrollToElement(cm.getElement(harryItemsQuantity));
        int harryTotalItemsCount =Integer.parseInt(cm.getTextWeb(harryItemsQuantity));
        return harryTotalItemsCount;
    }

    public double getTotalPrice() {
        cm.scrollToElement(cm.getElement(totalPrice));
        double totalPriceInt = Double.parseDouble(cm.getTextWeb(totalPrice).replace("$",""));
        return totalPriceInt;
    }

    public int getTotalQuantity() {
        cm.scrollToElement(cm.getElement(totalQuantity));
        int totalQuantityInt = Integer.parseInt(cm.getTextWeb(totalQuantity));
        return totalQuantityInt;
    }

    public HashMap<Double,Integer> clickOn_X(String itemNumber, String studentName) {
        By button_X = By.xpath("//tr[@id='"+itemNumber+"' and @data-name='"+studentName+"']//i[contains(@class,'fa-times-circle remove')]");
        cm.scrollToElement(cm.getElement(button_X));
        By quantityOfDeletedItem = By.xpath("//tr[@id='"+itemNumber+"' and @data-name='"+studentName+"']//i[contains(@class,'fa-times-circle remove')]/../..//input");
        By priceOfDeletedItem = By.xpath("//tr[@id='"+itemNumber+"' and @data-name='"+studentName+"']//i[contains(@class,'fa-times-circle remove')]/../../preceding-sibling::td[@class='price']//span");
        Integer quantityDeleted = Integer.parseInt(cm.getAttributeWeb(quantityOfDeletedItem,"value"));
        Double priceDeleted = Double.parseDouble(cm.getTextWeb(priceOfDeletedItem).replace("$",""));
        HashMap<Double,Integer> priceAndQuantity = new HashMap<>();
        priceAndQuantity.put(priceDeleted,quantityDeleted);
        cm.clickThis(button_X);
        cm.clickThis(removeConfirmationButton_Yes);
        return priceAndQuantity;
    }

    public void clickProceedToCheckOut_1() {
        cm.scrollToElement(cm.getElement(proceedToCheckOut));
        cm.clickThis(proceedToCheckOut);
        }

    public void clickProceedToCheckOut_2() {
        cm.scrollToElement(cm.getElement(proceedToCheckOut_2));
        cm.clickThis(proceedToCheckOut_2);
    }


}
