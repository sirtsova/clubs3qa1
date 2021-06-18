Feature:
  Scenario Outline: Verify YTO-By Flyer jumper
    When I click on create account link on upper right conner
    And I select 'Teacher/Administrator' radio button
    And I click on 1st next button
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
    And I go to Enter Orders
    And I select Your Teacher Order
    And I click on Price-QTY box
    Then Teacher sees a jumper right above the box with message
    When I click on X on the jumper
    And I enter data in the clicked Price-QTY box
    And I click on other Price-QTY box
    Then I do NOT see any jumper

    Examples:
      |title|FirstName|LastName|email|password|mobileNumber|zipcode|schoolName|numberOfStudents|
      |Mr.|Vallisa |LAStttn|wallStreet21@Gmail.com|passwOOOOj9HrD|3487549087|99518|Adak Schoo|1|