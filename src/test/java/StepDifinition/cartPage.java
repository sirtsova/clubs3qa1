package StepDifinition;

import Pages.Commands;
import Pages.HomePageLoggedInUser;
import Pages.ReviewCart;
import Pages.StudentFlyerOrders;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en_scouse.An;
import javafx.print.Collation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import sun.text.resources.CollationData;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class cartPage {
    ReviewCart cart = new ReviewCart();
    HomePageLoggedInUser hp = new HomePageLoggedInUser();
    StudentFlyerOrders fo = new StudentFlyerOrders();
    double harryTotalPriceBefore;
    int harryTotalQuantityBefore;
    int totalQuantityBefore;
    double totalPriceBefore;
    int deletedQuantity;
    double deletedPrice;

    @And("I go to Enter Orders")
    public void clickOnEnterOrders() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickOnEnterOrdersDropDown();
    }

    @And("I select Student Flyer Orders")
    public void selectStudentFlyer() {hp.selectStudentFlyerOrders();}

    @And("I add '(.+)' orders  with  student name '(.+)' and  item# '(.+)'")
    public void addOrders(String quantity, String studentName, String itemNumber) {
        fo.addItems(studentName,itemNumber,quantity);
    }

    @And("I click on Review Cart button")
    public void clickOnReviewCart () {
        fo.clickReviewCart();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        harryTotalQuantityBefore = cart.getHarryTotalQuantity();
        harryTotalPriceBefore = cart.getHarryTotalPrice();
        totalQuantityBefore = cart.getTotalQuantity();
        totalPriceBefore = cart.getTotalPrice();
    }

    @And("I click on 'X' button corresponding to '(.+)' item for '(.+)' and click 'Yes' to confirm")
    public void deleteItem (String itemNumber, String studentName) {
      HashMap<Double,Integer> deletedPriceAndQuantity = cart.clickOn_X(itemNumber,studentName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<Double> priceDeleted = deletedPriceAndQuantity.keySet();
      for(Double price: priceDeleted) {
          deletedPrice=price;
      }
      Collection<Integer> quantityDeleted = deletedPriceAndQuantity.values();
      for(Integer quantity: quantityDeleted) {
          deletedQuantity = quantity;
      }
    }

    @Then("I verify that for '(.+)', item '(.+)' gets deleted")
    public void isItemHasBeenDeleted(String studentName, String itemNumber) {
        boolean isDeleted = false;
        try {
            By button_X = By.xpath("//tr[@id='"+itemNumber+"' and @data-name='"+studentName+"']//i[contains(@class,'fa-times-circle remove')]");
            Commands cm = new Commands();
            cm.getElement(button_X);
        } catch(NoSuchElementException e) {
            isDeleted = true;
        } catch (TimeoutException ea) {
            ea.printStackTrace();
            isDeleted = true;
        }
        Assert.assertTrue(isDeleted,"Item HAS NOT been deleted");
    }

    @Then("I verify respective amounts and quantities get updated")
    public void isAmountGotDeleted() {
        double expectedHarryPrice = harryTotalPriceBefore-(deletedPrice*deletedQuantity);
        int expectedHarryQuantity = harryTotalQuantityBefore-deletedQuantity;
        double expectedTotalPrice = totalPriceBefore-(deletedPrice*deletedQuantity);
        int expectedTotalQuantity = totalQuantityBefore-deletedQuantity;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double actualHarryPrice = cart.getHarryTotalPrice();
        int actualHarryQuantity = cart.getHarryTotalQuantity();
        double actualTotalPrice = cart.getTotalPrice();
        int actualTotalQuantity = cart.getTotalQuantity();
        Assert.assertEquals(expectedHarryPrice,actualHarryPrice,"Harry's price is not as expected");
        Assert.assertEquals(expectedHarryQuantity,actualHarryQuantity,"Harry's quantity is not as expected");
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice,"Total price is not as expected");
        Assert.assertEquals(expectedTotalQuantity,actualTotalQuantity,"Total quantity is not as expected");
    }


}
