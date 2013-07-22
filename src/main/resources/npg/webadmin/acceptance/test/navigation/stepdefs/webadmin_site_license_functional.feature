${at.sign}InitializeWebAdminSLFunc
${at.sign}CloseWebAdminSLFunc

Feature: Main Site License Search verifaction

  ${at.sign}sprint-1 
  Scenario: 1.1 Search site account based on site ID, user Id, organization, IP address   
     Given webadmin user logs in with username "${login.username}" password "${login.password}"   
     When user is on site account search page to fill search fields    
     Then ensure the organization "Orszagos Onkologiai Intezet  " is in search result page given the following conditions
        
        ${site.account.search.scenario.site}
  
  ${at.sign}sprint-1
  Scenario: 1.2 Search site account given site administrator attributes 
     Given webadmin user logs in with username "${login.username}" password "${login.password}"   
     When user is on site account search page to fill search fields    
     Then ensure the organization "Orszagos Onkologiai Intezet  " is in site administrator result page given the following conditions

        ${site.account.search.scenario.admin}
        
        
  ${at.sign}sprint-1   
  Scenario: 2.1. WebAdmin user able to inactivate site with licenses      
     Given webadmin user logs in with username "${login.username}" password "${login.password}"   
     When user searches site "${slams.site.id}" with existing active license 
     Then confirm window message "Marking this account inactive no longer requires you to disassociate the licenses. Are you sure you want to change site account status to 'inactive'?" should display at site "${slams.site.id}" 
     And display confirmation page message "Site Account ${slams.site.id} has been successfully inactivated."    
  
  ${at.sign}sprint-1     
  Scenario: 2.2. Verify site administrator not able to login when Scenario 1 deactivated the site   
     Given Nature site administrator is in login page
     When site administrator logs in with username "${site.admin.login.username}" and password "${site.admin.login.password}"
     Then site administrator should not be able to login with page message "Username does not exist, please enter the correct username."
  
  ${at.sign}sprint-1  
  Scenario: 2.3. WebAdmin user activated site 
     Given webadmin user logs in with username "${login.username}" password "${login.password}" 
     When user searches site "${slams.site.id}" with existing inactive license 
     Then confirm window message "Are you sure you want to change site account status to 'active'?" should display at site "${slams.site.id}" 
     And display confirmation page message "Site Account ${slams.site.id} has been successfully activated."
  
  ${at.sign}sprint-1                    
  Scenario: 2.4. Verify site administrator is able to login when Scenario 3 deactivated the site   
     Given Nature site administrator is in login page
     When site administrator logs in with username "${site.admin.login.username}" and password "${site.admin.login.password}"
     Then site administrator should be able to login displaying "Nature Publishing - 14312". 
                         