package StepDifinition;

import DriverWrapper.Web;
import Pages.Commands;
import Pages.CreateAccount;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import java.sql.SQLOutput;


public class createAccount {
    CreateAccount h = new CreateAccount();
    Commands cm = new Commands();
    String enteredFirstName = null;
    String enteredLastName = null;
    String schoolDetailsWhileCreatingAcc = "null";
    String classCodeHomePage = null;
    String schoolDetailsMyAcc = null;


    @Given("I am on Scholastic Reading Club")
    public void launchSchoolacticQA() {Web.openUrl();}

    @And ("I click on create account link on upper right conner")
    public void clickCreateAccount() {h.clickOnCreateAccountLink();}

    @And("I select 'Teacher/Administrator' radio button")
    public void selectTeacherRadioButton(){
        h.selectTeacherRadioBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click on 1st next button")
    public void clickNext_1() {h.clickNext1();}

    @And("I select title '(.+)' from dropdown")
    public void selectMrFromTitle(String title) {h.clickSelectTitle(); h.selectOption(title);}

    @And("I enter first name '(.+)'")
    public void enterFirstName(String name) {h.typeFirstName(name); enteredFirstName = name;}

    @And("I enter last name '(.+)'")
    public void enterLastName(String name) {h.typeLastName(name); enteredLastName = name;}

    @And("I enter email address '(.+)'")
    public void enterEmail(String email) {h.typeEmail(email);}

    @And("I enter password '(.+)'")
    public void enterPassword(String password) {h.typePassword(password);}

    @And("I enter mobile number '(.+)'")
    public void enterMobileNumber(String number) {
        cm.scrollDownByPixels(400);
        h.typePhoneNumber(number);
    }

    @And("I accept Terms of Use")
    public void acceptTermOfUse() {h.acceptTermsOfUse();}

    @And("I click on 2nd next button")
    public void clickNext_2() {h.clickNext2();}

    @And("I enter zipcode '(.+)'")
    public void enterZipCode(String zipcode) {h.enterZipCode(zipcode);}

    @And("I click on Search button")
    public void clickSearchButton() {h.clickSearch();}

    @And("I select '(.+)' from dropdown option")
    public void selectState(String state) {
        h.searchByState(state);
    }

    @And("I type and select city '(.+)'")
    public void enterCityName(String city) {
        h.searchByCity(city);
    }

    @And("I search and select school '(.*)'")
    public void enterSchoolName(String schoolName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            h.enterSchoolName(schoolName);
        } catch (StaleElementReferenceException e) {
            h.enterSchoolName(schoolName);
        }
        try {
            h.selectFirstOptionSchool();
        } catch (StaleElementReferenceException e) {
            h.selectFirstOptionSchool();
        }
       schoolDetailsWhileCreatingAcc = h.selectedSchoolDetails();
    }

    @And("I click on 3rd next button")
    public void clickNext_3() {h.clickNext3();}

    @And("I select role 'by Grade'")
    public void selectRole() {h.clickRoleDropDown(); h.selectByGrade();}

    @And("I select 1st grade from myGrade")
    public void select1stGrade() {h.clickGradeDropDown(); h.select1stGrade();}

    @And("I enter number of students '(.+)'")
    public void enterNumberOfStudents(String studentsCount) {h.enterNumOfStudents(studentsCount);}

    @And("I click on 4th next button")
    public void clickNext_4() {h.clickNext4();}

    @And("I select Preferred Reading Level System 'GLM'")
    public void selectPreferredReadingLevel() {h.clickRedyingSystemBtn(); h.selectGRLOption();}

    @And("I click on 'continue on website' button")
    public void clickContinueOnWebSite() {h.clickOnSiteBtn();}

    @Then("I verify a CLASS CODE is present on Home-Page")
    public void isClassCodePresentOnHomeAndMyAccount() {
        Assert.assertTrue(h.isClassCodePresentOnHomePg(), "Class code is NOT present on Home-Page");
        classCodeHomePage = h.grabClassCodeFromHomePg();
         }

    @Then("I verify same ClASS CODE present on My Account-Page")
    public void isClassCodeSameOnMyAccount()  {
        h.clickOnMyProfileBtn();
        h.selectProfileOption();
        Assert.assertEquals(classCodeHomePage, h.grabClassCodeFromMyAcc(),
                "Code present on Home-page is NOT same as code present on MyAccount-Page");
         }


    @Then("I verify teacher name entered while creating account is present on My Accounts")
    public void isTeacherNamePresentAsEntered() {
        cm.scrollDownByPixels(400);
        String nameEntered = enteredFirstName+" "+enteredLastName;
        String nameOnMyAccount = h.nameOnMyAccount().replace("Mr. ","");
        Assert.assertEquals(nameEntered,nameOnMyAccount, "Name present on My Account-Page is not same as entered.");
    }

    @Then("I verify same school address is present as selected while creating the account")
    public void isSchoolDetailsPresentAsSelectedWhileCreatingAcc() {
        schoolDetailsMyAcc =h.selectSchoolDetailsMyAcc();
        Assert.assertEquals(schoolDetailsWhileCreatingAcc,schoolDetailsMyAcc,
                "School details present on my Account-Page is NOT as selected");

    }


}
