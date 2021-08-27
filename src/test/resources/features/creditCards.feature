Feature:
  @regression
  Scenario Outline: TC-5 Verify teacher can add only 3 credit cards under My Credit Cards in My Accounts
    #Loggin in account with 3 Credit Card added
  When I click on Sign in link located on the upper right of the page
    And I enter existing email address '<email>'
    And I click continue button under email field
    And I enter existing password '<password>'
    And I click sign in under password field
    And I click on My Profile dropdown and select Profile
    And I click add a card
  Then I verify I get error message 'You can only store three credit cards'
    Examples:
      |email|password|
      |la760@Gmail.com|passwOOOOj9HrD|