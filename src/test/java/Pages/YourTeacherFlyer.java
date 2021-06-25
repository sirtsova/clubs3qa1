package Pages;

import DriverWrapper.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public class YourTeacherFlyer {
    Commands cm = new Commands();
    By inputItem_9S8 = By.xpath("//input[@data-itemid='9S8']");
    By jumper = By.xpath("//div[@id='info-student-flyer-order-fee']");
    By jumper_Unidentified = By.id("error-message-tooltip");
    By jumperHeader = By.xpath("//div[@class='info-modal-hd']");
    By jumperMessage = By.xpath("//div[@class='info-modal-content']");
    By exclamationPoint = By.xpath("//i[@class='icon-exclamation']");
    By closeJumper_X = By.xpath("//i[contains(@class,'info-modal-close')]");
    By inputItem_3S8 = By.xpath("//input[@data-itemid='3S8']");


    public int getInput_X() {
       int inputX =  cm.getXCoordinate(inputItem_9S8);
        return inputX;
    }

    public int getInput_Y() {
        int inputY =  cm.getXCoordinate(inputItem_9S8);
        return inputY;
    }

    public int getJumper_X() {
       int jumperX = cm.getXCoordinate(jumperMessage);
       return jumperX;
    }

    public int getJumper_Y() {
        int jumperY = cm.getYCoordinate(jumperMessage);
        return jumperY;
    }

    public void clickInput_1() {
        cm.scrollDownByPixels(500);
        cm.clickThis(inputItem_9S8);}

    public List<String> getJumperData() {
        String exclamation = cm.getTextWeb(exclamationPoint);
        String header = cm.getTextWeb(jumperHeader).replace(exclamation,"");


        String message = cm.getTextWeb(jumperMessage);
        List<String> errorMessage = new ArrayList<>();
        errorMessage.add(header);
        errorMessage.add(message);

        return errorMessage;
    }

    public void enterDataInLinkedQTYBox(String item, String quantity) {
        By inputItem = By.xpath("//input[@data-itemid='"+item+"']");
        cm.clickActionClass(inputItem);
        cm.type(inputItem,quantity);
    }

    public void closeJumper() {cm.clickThis(closeJumper_X);}

    public void clickInput_2() {
         cm.clickActionClass(inputItem_3S8);
    }

    public void findJumpers() {

            cm.getElement(jumper).getText();
            cm.getElement(jumper_Unidentified).getText();
    }




}
