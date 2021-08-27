Feature: Create an Account
Background:
 # Given I am on Scholastic Reading Club
  When I click on create account link on upper right conner
       And I select 'Teacher/Administrator' radio button
       And I click on 1st next button

  @regression
  Scenario Outline: TC-1 User can create a new teacher account in taxable state using Zip Code
    #Change email after each execution
       And I select title '<title>' from dropdown
       And I enter first name '<FirstName>'
       And I enter last name '<LastName>'
       And I enter email address '<email>'
       And I enter password '<password>'
       And I enter mobile number '<mobileNumber>'
       And I accept Terms of Use
       And I click on 2nd next button
       And I enter zipcode '<zipcode>'
       And I click on Search button
       And I search and select school '<schoolName>'
       And I click on 3rd next button
       And I select role 'by Grade'
       And I select 1st grade from myGrade
       And I enter number of students '<numberOfStudents>'
       And I click on 4th next button
       And I select Preferred Reading Level System 'GLM'
       And I click on 'continue on website' button
    Then I verify a CLASS CODE is present on Home-Page
    Then I verify same ClASS CODE present on My Account-Page
    Then I verify teacher name entered while creating account is present on My Accounts
    Then I verify same school address is present as selected while creating the account
    Examples:
    |title|FirstName|LastName|email              |password      |mobileNumber|zipcode|schoolName|numberOfStudents|
    |Mr.|Vallisa |LAStttn|brooklynHall7@Gmail.com|passwOOOOj9HrD|3487549087|10012    |Scholastic+Book+Club|1     |

  @regression
  Scenario Outline: TC-2 User can create a new teacher account in taxable state using School Search
    #Change email after each execution
    And I select title '<title>' from dropdown
    And I enter first name '<FirstName>'
    And I enter last name '<LastName>'
    And I enter email address '<email>'
    And I enter password '<password>'
    And I enter mobile number '<mobileNumber>'
    And I accept Terms of Use
    And I click on 2nd next button
    And I select '<state>' from dropdown option
    And I type and select city '<city>'
    And I search and select school '<schoolName>'
    And I click on 3rd next button
    And I select role 'by Grade'
    And I select 1st grade from myGrade
    And I enter number of students '<numberOfStudents>'
    And I click on 4th next button
    And I select Preferred Reading Level System 'GLM'
    And I click on 'continue on website' button
  Then I verify a CLASS CODE is present on Home-Page
  Then I verify same ClASS CODE present on My Account-Page
  Then I verify teacher name entered while creating account is present on My Accounts
  Then I verify same school address is present as selected while creating the account

   Examples:
    |title|FirstName|LastName|email              |password      |mobileNumber|state|city|schoolName|numberOfStudents|
    |Mr.|Vallisa |LAStttn  |brightonBeach7@Gmail.com|passwOOOOj9HrD|3487549087|New York |New York |Scholastic+Book+Club|1     |


  @regression
  Scenario Outline: TC-4 User can create a new teacher account in non-taxable state using Zip Code
    #Change email after each execution
      And I select title '<title>' from dropdown
      And I enter first name '<FirstName>'
      And I enter last name '<LastName>'
      And I enter email address '<email>'
      And I enter password '<password>'
      And I enter mobile number '<mobileNumber>'
      And I accept Terms of Use
      And I click on 2nd next button
      And I enter zipcode '<zipcode>'
      And I click on Search button
      And I search and select school '<schoolName>'
      And I click on 3rd next button
      And I select role 'by Grade'
      And I select 1st grade from myGrade
      And I enter number of students '<numberOfStudents>'
      And I click on 4th next button
      And I select Preferred Reading Level System 'GLM'
      And I click on 'continue on website' button
  Then I verify a CLASS CODE is present on Home-Page
  Then I verify same ClASS CODE present on My Account-Page
  Then I verify same school address is present as selected while creating the account
  Then I verify teacher name entered while creating account is present on My Accounts

    Examples:
        |title|FirstName|LastName|email|password|mobileNumber|zipcode|schoolName|numberOfStudents|
        |Mr.|Vallisa |LAStttn|dumbo29@Gmail.com|passwOOOOj9HrD|3487549087|99518|Adak Schoo|1|
