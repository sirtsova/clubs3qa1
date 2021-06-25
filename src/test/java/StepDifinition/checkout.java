package StepDifinition;

import Pages.StartCheckOut;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class checkout {
    StartCheckOut start = new StartCheckOut();

    @Then("I verify tax amount is 0.00")
    public void isTaxAmountZero() {
        double actualTaxAmount = start.getTaxAmount();
        double expectedAmount = 0;
        Assert.assertEquals(actualTaxAmount,expectedAmount,"Tax amount does NOT equals to zero");
    }
}
