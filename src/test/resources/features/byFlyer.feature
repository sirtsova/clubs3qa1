Feature:

  @regression
  Scenario Outline: TC-11 Verify YTO-By Flyer jumper
  When I click on Sign in link located on the upper right of the page
    And I enter existing email address '<email>'
    And I click continue button under email field
    And I enter existing password '<password>'
    And I click sign in under password field
    And I go to Enter Orders
    And I select Your Teacher Order
    And I click on Price-QTY box
  Then Teacher sees a jumper right above the box with message
  When I click on X on the jumper
    And I enter in the clicked Price-QTY related to'<itemNumber>'box '<quantity>'
    And I click on other Price-QTY box
  Then I do NOT see any jumper

    Examples:
      |email|password|quantity|itemNumber|
      |wallStreet29@Gmail.com|passwOOOOj9HrD|3       |9S8       |