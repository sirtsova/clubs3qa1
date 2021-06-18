package StepDifinition;

import Pages.CreateAccount;
import Pages.MyAccount;
import Pages.SignIn;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en_scouse.An;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class creditCards {
    SignIn signIn = new SignIn();
    MyAccount myAccount = new MyAccount();
    CreateAccount acc = new CreateAccount();
    String expectedErrorMsg = "You can only store three credit cards";

    @And("I click on Sign in link located on the upper right of the page")
    public void clickHomePageSighIn() {signIn.clickOnSighInHomePage();}

    @And("I enter existing email address '(.+)'")
    public void enterEmail(String email) {
       signIn.typeEmail(email);}

    @And("I click continue button under email field")
    public void clickContinue() {signIn.clickContinueBtnUnderEmailField();}

    @And("I enter existing password '(.*)'")
    public void enterPassword(String password) {signIn.typePassword(password);}

    @And("I click sign in under password field")
    public void clickSignIn() {
        signIn.clickSignInAfterPassword();

        myAccount.closePopUp();

    }

    @And("I click on My Profile dropdown and select Profile")
    public void goToMyProfile() {
        acc.clickOnMyProfileBtn();
        acc.selectProfileOption();
    }

    @And("I click add a card")
    public void clickToAddCard() {myAccount.clickAddACard();}

    @Then("I verify I get error message 'You can only store three credit cards'")
    public void errorMessageShouldAppearWhileAdding4thCC() throws InterruptedException {
        Thread.sleep(3000);
       Assert.assertTrue(myAccount.errorMSgIsDisplayed());
       Assert.assertEquals(myAccount.get3CCErrorMsg(),expectedErrorMsg,"Error message is not as expected");
    }

}
