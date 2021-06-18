package Pages;

import DriverWrapper.Web;
import Pages.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CreateAccount {
   static String expected_string = null;
   Commands cm = new Commands();
   By createAccountLink = By.xpath("//div[@id='navLinksOnly']/preceding-sibling::a[text()='Create an Account']");
   By teacherSelectionRadioBtn = By.xpath("//label[@for='acccountTeacther']");
   By nextBtnOnCreateAccWindow = By.id("linkChooseAcount");
   By titleDropdownCreateAccWindow = By.id("dwfrm_profile_customer_title");
   By titleDropdownOption_Mr = By.xpath("//span[text()='Mr.']");
   //form[@id='RegistrationForm']//div[contains(@class,'profile-title')]
   //form[@id='RegistrationForm']//div[contains(text(),'Select Title')]
   By firstNameCreateAccWindowField = By.id("dwfrm_profile_customer_firstname");
   By lastNameCreateAccWindowField = By.id("dwfrm_profile_customer_lastname");
   By emailCreateAccWindowField = By.id("dwfrm_profile_customer_email");
   By passwordCreateAccWindowField = By.id("dwfrm_profile_login_password");
   By phoneNumCreateAccWindowField = By.id("dwfrm_profile_customer_phone");
   By termsOfUseCreateAccWindowCheckBox = By.id("dwfrm_registration_termsofuseteacher");
   By getNextBtnOnCreateAccWindow_2 = By.className("button-continue");
   By mySchoolZipField = By.id("dwfrm_myschool_schoolzip");
   By searchByStateToClick = By.xpath("//div[contains(@class,'school-state')]//div[@class='custom-select']");
   By searchBtnUnderZip = By.xpath("//div[@class='form-row ']/following-sibling::div[@class='align-center']//button");
   By cityField = By.xpath("//input[contains(@class,'ui-autocomplete')]");
   By searchButtonUnderCity = By.xpath("//div[contains(@class,'school-city')]/following::button[@id='button-search']");
   By searchSchoolAutoSuggestion = By.id("dwfrm_searchschool_schoolvalue");
   By FirstOption = By.xpath("//span[@class='ui-menu-item-wrapper']");
   By schoolNameYourSelection = By.className("school-name");
   By schoolAddressYourSelection = By.className("school-add");
   By schoolStateYourSelection = By.className("school-state");
   By nextBtnSchoolName_3 = By.xpath("//button[contains(text(),'NEXT')]");
   By roleDropDown = By.xpath("//div[contains(@class,'primaryrole')]");
   By byGradeOption = By.xpath("//span[contains(text(),'by Grade')]");
   By gradeDropDown = By.xpath("//div[contains(@class,'noscroll')]");
   By grade1stOption = By.xpath("//span[contains(text(),'1st')]");
   By myRoleNumOfStudentsField = By.id("dwfrm_myrole_students");
   By nextBtnMyRole_4 = By.xpath("//button[@name='dwfrm_myrole_findgrade']");
   By readyingLevelSystemDropDown = By.id("dwfrm_profileselection_readinglevel");
   By optionGRL = By.xpath("//span[contains(text(),'GRL')]");
   By continueOnSiteBtn_5 = By.xpath("//button[@name='dwfrm_profileselection_confirmed']");
   By classCodeHomePage = By.xpath("//div[text()='Class Code']/..//following-sibling::div[@class='details']//div[@class='value']");
   By nameOnHomePg = By.className("teacher-name-with-salutation");
   By myAccountDropDown = By.xpath("//span[contains(@class,'user-account-name')]");
   By profileOption = By.xpath("//a[@title='Profile']");
   By classCodeFromMyAcc = By.xpath("//h3[text()='Class Code']//following-sibling::span");
   By schoolDetailsMyAcc = By.xpath("//h3[text()='School']/..//div[@class='text-blk']//span");
   By myAccountName = By.xpath("//h3[text()='Name']/..//div[@class='text-blk']//span");

   public void clickOnCreateAccountLink(){ cm.clickThis(createAccountLink); }
   public void selectTeacherRadioBtn(){ cm.clickThis(teacherSelectionRadioBtn); }
   public void clickNext1() {cm.clickThis(nextBtnOnCreateAccWindow);}
   public void clickSelectTitle() {cm.moveMouseOverElement(titleDropdownCreateAccWindow);
      cm.clickActionClass(titleDropdownCreateAccWindow); }
   public void selectOption(String title) {
      By titleDropdownOption = By.xpath("//span[text()='"+title+"']");
      cm.moveMouseOverElement(titleDropdownOption); cm.clickActionClass(titleDropdownOption);}
   public void typeFirstName(String firstName) {cm.type(firstNameCreateAccWindowField,firstName);}
   public void typeLastName(String lastName) {cm.type(lastNameCreateAccWindowField,lastName);}
   public void typeEmail(String email) {cm.type(emailCreateAccWindowField,email);}
   public void typePassword(String password) {cm.type(passwordCreateAccWindowField,password);}
   public void typePhoneNumber(String phoneNumber) {cm.type(phoneNumCreateAccWindowField,phoneNumber);}
   public void acceptTermsOfUse(){cm.scrollToElement(cm.getElement(termsOfUseCreateAccWindowCheckBox)); cm.clickThis(termsOfUseCreateAccWindowCheckBox);}
   public void clickNext2() {cm.clickThis(getNextBtnOnCreateAccWindow_2);}
   public void enterZipCode(String zip) {cm.type(mySchoolZipField,zip);}
   public void searchByState(String state) {
      cm.clickActionClass(searchByStateToClick);
     try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      By stateName = By.xpath("//span[text()=' "+state+"']");
      if(!(cm.isElementDisplayed(stateName))) {
         cm.scrollToElement(cm.getElement(stateName));
      }
         cm.clickActionClass(stateName);
   }

   public void searchByCity(String city) {
      cm.type(cityField,city);
      try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      cm.clickActionClass(By.xpath("//span[text()='OR']"));
      cm.clickThis(searchButtonUnderCity);
    }
   public void clickSearch() {cm.clickThis(searchBtnUnderZip);}
   public void enterSchoolName(String name) {
      cm.type(searchSchoolAutoSuggestion,name);
      cm.clickActionClass(searchSchoolAutoSuggestion);
      cm.clickThis(searchSchoolAutoSuggestion);
   }
   public void selectFirstOptionSchool() {
      cm.clickThis(FirstOption);
   }

   public String selectedSchoolDetails() {
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      ArrayList<String> schoolDetails = new ArrayList<>();
      String schoolDetailsString = "null";
       for(int i=0;i<=3;i++) {
          try {
             if(schoolDetailsString.length()<20) {
                schoolDetails.add(cm.getTextWeb(schoolNameYourSelection));
                schoolDetails.add(cm.getTextWeb(schoolAddressYourSelection));
                schoolDetails.add(cm.getTextWeb(schoolStateYourSelection));
                schoolDetailsString = schoolDetails.toString();
             }
          } catch (StaleElementReferenceException e) {
             System.out.println("School details hasn't selected");
          }
       }

     return schoolDetailsString.replace(" ","").replace(",","");
   }

   public void clickNext3() {cm.clickThis(nextBtnSchoolName_3);}
   public void clickRoleDropDown() {cm.clickThis(roleDropDown);}
   public void selectByGrade() {cm.clickThis(byGradeOption);}
   public void clickGradeDropDown() {cm.clickThis(gradeDropDown);}
   public void select1stGrade() {cm.clickThis(grade1stOption);}
   public void enterNumOfStudents(String number) {
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      cm.type(myRoleNumOfStudentsField,number);}
   public void clickNext4() {cm.clickThis(nextBtnMyRole_4);}
   public void clickRedyingSystemBtn() {cm.clickActionClass(readyingLevelSystemDropDown);}
   public void selectGRLOption() {cm.clickThis(optionGRL);}
   public void clickOnSiteBtn() {cm.clickThis(continueOnSiteBtn_5);}
   public boolean isClassCodePresentOnHomePg() { return cm.isElementDisplayed(classCodeHomePage);}
   public String grabClassCodeFromHomePg() {return cm.getTextWeb(classCodeHomePage);}
   public String grabNameFromHomePg() {return cm.getTextWeb(nameOnHomePg).replace("Hi, ","");}
   public void clickOnMyProfileBtn(){cm.clickThis(myAccountDropDown);}
   public void selectProfileOption() {cm.clickThis(profileOption);}
   public String grabClassCodeFromMyAcc() {return cm.getTextWeb(classCodeFromMyAcc);}
   public String selectSchoolDetailsMyAcc() {
      List<WebElement> schoolDetails = cm.getElements(schoolDetailsMyAcc);
      ArrayList<String> detailsArr = new ArrayList<>();
        for (WebElement detail : schoolDetails) {
            detailsArr.add(cm.getTextWeb(detail));
            }

      String schoolDetMyAcc = detailsArr.toString().replace(" ","").replace(",","");
      return schoolDetMyAcc;
   }
   public String nameOnMyAccount() { return cm.getTextWeb(myAccountName);}

}
