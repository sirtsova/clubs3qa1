Feature:

  @regression
  Scenario Outline: TC-6 Verify teacher gets error for invalid item number in SFO (Student Flyer Order)
  When I click on Sign in link located on the upper right of the page
    And I enter existing email address '<email>'
    And I click continue button under email field
    And I enter existing password '<password>'
    And I click sign in under password field
    And I go to Enter Orders
    And I select Student Flyer Orders
    And I add '<quantity>' orders  with  student name '<student>' and  item# '<itemNumber>'
  Then I verify I see error message 'Please enter a valid item number'

    Examples:
    |email|password|quantity|student|itemNumber|
    |brooklynHall3@Gmail.com|passwOOOOj9HrD|1|Harry|111|
