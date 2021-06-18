package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SignIn {
    Commands cm = new Commands();
    By updateNowBtn = By.xpath("//a[contains(text(),'UPDATE NOW')]");
    By signInLink = By.linkText("Sign In");
    By signInIframe = By.id("iframeMyScholastic");
    By emailFieldIframe = By.id("user-text-field");
    By continueButtonUnderEmail = By.id("signin-email-submit-button");
    By passwordFieldIframe = By.id("password-text-field");
    By signInButtonUnderPassword = By.id("password");


    public void clickOnSighInHomePage() {
        cm.clickThis(signInLink);
        // cm.clickThis(updateNowBtn);
    }
    public void typeEmail(String email) {
        cm.switchToFrame("iframeMyScholastic");
        cm.type(emailFieldIframe,email);
    }
    public void clickContinueBtnUnderEmailField() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       cm.clickThis(continueButtonUnderEmail);

    }
    public void typePassword(String password) {cm.type(passwordFieldIframe,password);}
    public void clickSignInAfterPassword() {cm.clickThis(signInButtonUnderPassword);

    }


}
