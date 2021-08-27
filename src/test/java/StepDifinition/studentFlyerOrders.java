package StepDifinition;

import Pages.StudentFlyerOrders;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class studentFlyerOrders {
    StudentFlyerOrders fyo = new StudentFlyerOrders();
    String expectedErrorMessage = "Please enter a valid item number.";

    @Then("I verify I see error message 'Please enter a valid item number'")
    public void isErrorMessageForWrongItemNumberDisplayed() {
        boolean isErrorMessageDisplayed = fyo.isErrorMessageAppearsForWrongItemNumber();
        String actualErrorMessage = fyo.getTextFromErrorMessage();
        Assert.assertTrue(isErrorMessageDisplayed,"Error message is NOT displayed");
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage,"Error message text is NOT as expected");
    }

}
