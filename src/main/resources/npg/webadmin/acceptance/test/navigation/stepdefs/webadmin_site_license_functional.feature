${at.sign}InitializeWebAdminSLFunc
${at.sign}CloseWebAdminSLFunc

Feature: Webadmin Site License Functional verifications  
  
  ${at.sign}sprint-1   
  Scenario: 1. WebAdmin user cannot delete active site with licenses      
    Given webadmin user logs in with username "${login.username}" password "${login.password}"   
    When user searches site "${slams.site.id}" with existing licenses and tries to deactivate it 
    Then alert message "You cannot delete this account. There are still licenses in this account. Please disassociate the licenses." should display on site "${slams.site.id}" 
    And site "${slams.site.id}" is still active               