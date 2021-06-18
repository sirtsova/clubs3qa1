package StepDifinition;

import Pages.Commands;
import Pages.HomePageLoggedInUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class quickView {
    HomePageLoggedInUser hp = new HomePageLoggedInUser();
    Commands cm = new Commands();
   String bookAdded = null;

    @And("I click on quick search box and search for '(.*)'")
    public void searchByTitleAuthorNameOrItem(String data) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.closeAllHandles();
        hp.closeToolTipsters();
        hp.typeBookOrAuthorData(data);
        hp.clickOnSearchButton();
        hp.clickOnSearchButton();

      }

    @And("I click on ‘Quick Look’ on a book '(.+)' from results")
    public void clickOnQuickLookOfBook(String partialBookTitle) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickOnQuickLookOfBook(partialBookTitle);

    }
    @And("I click on Recommend")
    public void clickRecommended() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.clickOnRecommended();
    }

    @And("I select '(.+)' from recommended options")
    public void selectOptionFromRecommendedList(String option) {
        hp.selectOptionFromRecommend(option);
        bookAdded = hp.getQuickLookBookTitle();
        hp.closeQuickLookWindow();
    }

    @And("I go to My Lists select option '(.+)'")
    public void goToMyListsSelectOption(String option) {
        hp.scrollUpToMyLists();
        hp.clickMyListsBtn();
        hp.selectOptionFromMyLists(option);

    }

    @Then("I verify the item is added in Recommendations to Students Lists under My Lists")
    public void verifyingIsItemAdded() {
        boolean isAddedBookFoundInQuickView = false;
        List<WebElement> booksRecommendedToStudents =hp.getItemsElementsAddedToRecommendationsForStudent();
        for(WebElement book: booksRecommendedToStudents) {
            cm.scrollToElement(book);
           String bookTitle = cm.getTextWeb(book);
            if(bookTitle.equalsIgnoreCase(bookAdded)){
                isAddedBookFoundInQuickView = true;
            }
        }
      Assert.assertTrue(isAddedBookFoundInQuickView,"Book has NOT been added to Quick View");
    }

}
