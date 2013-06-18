${at.sign}InitializePersonal
${at.sign}ClosePersonal

Feature: Webadmin User searches and navigate Personal Account pages 
       As a Webadmin user,
       I want to search personal account
       so I can view and update information related to the account
  
    
  ${at.sign}wip  
  Scenario: user navigates MyAccount pages     
    Given user is logged-in as "${myaccount.user.username}" password "${myaccount.user.password}" for user personal account search  

#              : profile

    When is on user my account profile page
    Then ensure these elements are present or not present in the current my account page
 
    ${myaccount.profile.page.elements.user} 
    
    When is on user my account profile address book modification page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.profile.addressbook.page.elements.user}     
    
    When is on user my account profile change email page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.profile.change.email.page.elements}    
     
    When is on user my account profile work details page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.profile.work.details.page.elements}     
        
#              : alerts

    When my account user navigate to alerts page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.alerts.page.elements}  
    
    When my account user navigate to alerts modification page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.alerts.modification.elements}  
    
#              : subscriptions and purchases

    When my account user navigate to subscriptions and purchases page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.alerts.subscriptions.purchases.elements}      