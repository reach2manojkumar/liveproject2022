Feature: Validation the login functionlity

  
  Scenario: Validating with invalid username and valid password 
    Given Open the chrome as login page
    And verify whether loaded page is correct or not
    When As user give invalid user and valid password
    And Click the login botton
    Then Check the whether it redirected to loginpage or not
    And Verify Warning text is present or not
    And close the webpage 

 Scenario: Validating with blank username and blank password 
    Given Open the chrome as login page
    And verify whether loaded page is correct or not
    When As user give blank user and blank password
    And Click the login botton
    Then Check the whether it redirected to loginpage or not
    And Verify Warning text is present or not
    And close the webpage 

 
  Scenario: Validating with valid username and valid password 
    Given Open the chrome as login page
    And verify whether loaded page is correct or not
    When As user give valid user and valid password
    And Click the login botton
    Then Check the whether it redirected to loginpage or not
    And Verify Warning text is present or not
    And close the webpage 
 