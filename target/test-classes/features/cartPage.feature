Feature:
  Scenario Outline: Verify user can delete item on Cart page
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
    And I add '<quantity4>' orders  with  student name '<student2>' and  item# '<itemNumber4>'
    And I add '<quantity5>' orders  with  student name '<student3>' and  item# '<itemNumber5>'
    And I add '<quantity6>' orders  with  student name '<student3>' and  item# '<itemNumber6>'
    And I click on Review Cart button
    And I click on 'X' button corresponding to '<itemNumber1>' item for '<student1>' and click 'Yes' to confirm
    Then I verify respective amounts and quantities get updated
    Then I verify that for '<student1>', item '<itemNumber1>' gets deleted

    Examples:
    |email|password|student1|student2|student3|itemNumber1|quantity1|itemNumber2|quantity2|itemNumber3|quantity3|itemNumber4|quantity4|itemNumber5|quantity5|itemNumber6|quantity6|
    |dumbo21@Gmail.com|passwOOOOj9HrD|Harry|Jonh|Michael|2S8|5|11S8       |1        |2G8        |2        |14G8       |2        |4G8        |4        |1G8        |10       |

 Scenario Outline: Verify user can delete item on Cart page (Account with pre-added items)
   When I click on Sign in link located on the upper right of the page
   And I enter existing email address '<email>'
   And I click continue button under email field
   And I enter existing password '<password>'
   And I click sign in under password field
   And I go to Enter Orders
   And I select Student Flyer Orders
   And I click on Review Cart button
   And I click on 'X' button corresponding to '<itemNumber1>' item for '<student1>' and click 'Yes' to confirm
   Then I verify that for '<student1>', item '<itemNumber1>' gets deleted
   Then I verify respective amounts and quantities get updated

   Examples:
     |email|password|student1|itemNumber1|
     |jamaicaCenter1@Gmail.com|passwOOOOj9HrD|Harry|2S8|










