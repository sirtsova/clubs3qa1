package StepDifinition;

import Pages.HomePageLoggedInUser;
import Pages.YourTeacherFlyer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class byFlyer {
    HomePageLoggedInUser hp = new HomePageLoggedInUser();
    YourTeacherFlyer ytf = new YourTeacherFlyer();
    String expectedHeader = "IMPORTANT";
    String expectedMessage = "All student paper flyer orders MUST be entered in the Student Flyer Orders tab.";
    int checkBox_x;
    int getCheckBox_y;
    int jumper_x;
    int jumper_y;

    @And("I select Your Teacher Order")
    public void selectTeacherFlyer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.selectYourTeacherOrder();}

    @And("I click on Price-QTY box")
    public void clickPriceQTYBox() {
          ytf.clickInput_1();
     }

    @Then("Teacher sees a jumper right above the box with message")
    public void isMessageDisplayed() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkBox_x = ytf.getInput_X();
        getCheckBox_y = ytf.getInput_Y();
        jumper_x = ytf.getJumper_X();
        jumper_y = ytf.getJumper_Y();
        boolean isJumperRightAboveTheBox = (checkBox_x-jumper_x)<200 && (getCheckBox_y-jumper_y)<400;
        Assert.assertTrue(isJumperRightAboveTheBox,"Jumper is not right above the box");
        List<String> actualErrorMessage = ytf.getJumperData();
        List<String> expectedErrorMessage = new ArrayList<>();
        expectedErrorMessage.add(expectedHeader);
        expectedErrorMessage.add(expectedMessage);
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage,"Error message is NOT as expected");
     }

     @And("I enter data in the clicked Price-QTY box")
     public void enterDataInBox(){
         ytf.enterDataInLinkedQTYBox();
     }

     @And("I click on other Price-QTY box")
    public void clickOtherPriceQTYBox() {
        ytf.clickInput_2();
         }

     @When("I click on X on the jumper")
     public void closeJumperX(){
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         ytf.closeJumper();
     }

     @Then("I do NOT see any jumper")
    public void verifyIDoNotSeeAnyJumper() {
         boolean isErrorMsgDisplayed = false;
         try {
             ytf.findJumpers();
         } catch (NoSuchElementException e) {
             isErrorMsgDisplayed = true;
         } catch (TimeoutException e) {
             e.printStackTrace();
             isErrorMsgDisplayed = true;
         }
         Assert.assertFalse(isErrorMsgDisplayed,"Unexpected error appears");
     }


}
