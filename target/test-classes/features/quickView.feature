Feature:
  @regression
  Scenario Outline: TC-3 Teacher can add books in Recommendations List from Quick View
    #Change book name or delete from List after each execution
  When I click on Sign in link located on the upper right of the page
    And I enter existing email address '<email>'
    And I click continue button under email field
    And I enter existing password '<password>'
    And I click sign in under password field
    And I click on quick search box and search for '<itemToSearch>'
    And I click on ‘Quick Look’ on a book '<bookName>' from results
    And I click on Recommend
    And I select '<recommendedOption>' from recommended options
    And I go to My Lists select option '<option>'
  Then I verify the item is added in Recommendations to Students Lists under My Lists
    Examples:
      |email|password|itemToSearch|bookName|recommendedOption|option|
      |brooklynHall3@Gmail.com|passwOOOOj9HrD|Harry|Harry Potter and the Chamb|Recommendations|Recommendations|
