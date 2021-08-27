package Pages;

import cucumber.api.java.eo.Do;
import org.openqa.selenium.By;

public class StartCheckOut {
    Commands cm = new Commands();
    By taxAmount = By.id("order_total_tax");

    public double getTaxAmount() {
       String taxString = cm.getTextWeb(taxAmount).replace("$","");
       return Double.parseDouble(taxString);
    }
}
