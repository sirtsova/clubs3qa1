package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class MyAccount {
    Commands cm = new Commands();
    By addACard = By.xpath("//div[contains(@class,'link-credit-card')]/a[contains(text(),'Add a Card')]");
    By errorMsgOnly3CCAllowed = By.xpath("//div[@class='tooltipster-box']//div[@class='tooltipster-body']");
    By closePopUp = By.xpath("//span[@class='notification-close']");

    public void clickAddACard() {cm.clickThis(addACard);}
    public boolean errorMSgIsDisplayed() {return cm.isElementDisplayed(errorMsgOnly3CCAllowed);}
    public void closePopUp() {
        try {
            cm.clickThis(closePopUp);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    public String get3CCErrorMsg() { return cm.getTextWeb(errorMsgOnly3CCAllowed);}

}
