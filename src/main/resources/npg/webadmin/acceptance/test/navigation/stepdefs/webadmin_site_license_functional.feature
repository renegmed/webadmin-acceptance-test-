${at.sign}InitializeWebAdminSLFunc
${at.sign}CloseWebAdminSLFunc

Feature: Webadmin Site License Functional verifications  
  
  ${at.sign}sprint-1   
  Scenario: 1. WebAdmin user able to inactivate site with licenses      
    Given webadmin user logs in with username "${login.username}" password "${login.password}"   
    When user searches site "${slams.site.id}" with existing licenses and tries to deactivate it 
    Then alert message "Marking this account inactive no longer requires you to disassociate the licenses." should display at site "${slams.site.id}" 
    And confirm window message "Are you sure you want to change site account status to 'inactive'?" 
    And display confirmation page message "Site Account ${slams.site.id} has been successfully inactivated."
    
  #Scenario: 2. Verify inactivated site in Scenario 1                         