Feature:PrinterLogic testing

Scenario Outline: Login in correctly
  Given I'm using <browser>
  And I'm in login page
  When I enter the username ElChuko and password PrinterLogic27
  Then I should be logged in
  Examples:
    | browser |
    | Chrome  |
    | Firefox |


  Scenario: Wrong user name should not login
    Given I'm using <browser>
    And I'm in login page
    When I enter the username NotElChuko and password PrinterLogic27
    Then I should not be logged in


  Scenario: Wrong password should not login
    Given I'm using Chrome
    And I'm in login page
    When I enter the username ElChuko and password BadPassword
    Then I should not be logged in


  Scenario: Wrong username and password should not login
    Given I'm using Chrome
    And I'm in login page
    When I enter the username NotElChuko and password BadPassword
    Then I should not be logged in