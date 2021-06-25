Feature:

  @regression
  Scenario Outline: TC-9 Verify zero tax for only SFO order in the checkout (Login with user with school in taxed state)
    #Clear cart after execution
  When I click on Sign in link located on the upper right of the page
    And I enter existing email address '<email>'
    And I click continue button under email field
    And I enter existing password '<password>'
    And I click sign in under password field
    And I go to Enter Orders
    And I select Student Flyer Orders
    And I add '<quantity1>' orders  with  student name '<student1>' and  item# '<itemNumber1>'
    And I add '<quantity2>' orders  with  student name '<student1>' and  item# '<itemNumber2>'
    And I add '<quantity3>' orders  with  student name '<student2>' and  item# '<itemNumber3>'
    And I add '<quantity5>' orders  with  student name '<student3>' and  item# '<itemNumber5>'
    And I add '<quantity6>' orders  with  student name '<student3>' and  item# '<itemNumber6>'
    And I click on Review Cart button
    And I click 'proceed to checkout' 1st button
    And I click 'proceed to checkout' 2nd button
  Then I verify tax amount is 0.00

  Examples:
      |email|password|student1|student2|student3|itemNumber1|quantity1|itemNumber2|quantity2|itemNumber3|quantity3|itemNumber5|quantity5|itemNumber6|quantity6|
      |brightonBeach3@Gmail.com|passwOOOOj9HrD|Harry|Jonh|Michael|1G8|5|4G8|1|3S8|2|11S8|4|2S8|10|

  @regression
  Scenario Outline: TC-13 Verify non-zero tax is present for SFO-YTO orders in the checkout for teacher with tax state school (Login with user with school in Non-taxed state (eg: AK)
  #Clear cart after execution
  When I click on Sign in link located on the upper right of the page
    And I enter existing email address '<email>'
    And I click continue button under email field
    And I enter existing password '<password>'
    And I click sign in under password field
    And I go to Enter Orders
    And I select Student Flyer Orders
    And I add '<quantity>' orders  with  student name '<student>' and  item# '<itemNumber1>'
    And I add '<quantity>' orders  with  student name '<student>' and  item# '<itemNumber2>'
    And I add '<quantity>' orders  with  student name '<student>' and  item# '<itemNumber3>'
    And I add '<quantity>' orders  with  student name '<student>' and  item# '<itemNumber4>'
    And I go to Enter Orders
    And I select Your Teacher Order
    And I enter in the clicked Price-QTY related to'<itemNumber11>'box '<quantity>'
    And I enter in the clicked Price-QTY related to'<itemNumber12>'box '<quantity>'
    And I click on Review Cart button
    And I click 'proceed to checkout' 1st button
    And I click 'proceed to checkout' 2nd button
  Then I verify tax amount is 0.00

  Examples:
      |email|password|student|quantity|itemNumber1|itemNumber2|itemNumber3|itemNumber4|itemNumber11|itemNumber12|
      |dumbo26@Gmail.com|passwOOOOj9HrD|Harry|1|1G8|11G8      |3S8        |4S8        |1S8         |2S8         |