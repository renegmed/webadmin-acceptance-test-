${at.sign}Initialize
${at.sign}Close
Feature: Webadmin Login Functionalities  
  
   
  Scenario: Verify user valid login credential   
    Given user is in webadmin main page
    When user goes to login page
    Then ensure the user is able to logged in with username "${login.username}" password "${login.password}" 
 
  
  Scenario: Verify user has valid username but wrong password   
    Given user is in webadmin main page
    When user goes to login page
    Then ensure the user is not able to logged in with username "${login.username}" password "wxyz123"
                