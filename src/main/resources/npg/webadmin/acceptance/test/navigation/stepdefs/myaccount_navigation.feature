${at.sign}InitializeMyAccount
${at.sign}CloseMyAccount

Feature: MyAccount Navigation Verification  
       As a personal account subscriber or WebAdmin user,
       I want to navigate into MyAccount pages
       so I can view and verify the page contents and links   

   
  Scenario: Webadmin MyAccount navigations sanity checks

    #----- Log-in WebAdmin and go to My Account page  ------#
 
    Given webadmin user is logged-in using username "${login.username}" password "${login.password}"  
    And is on personal account search page and searches orcid "${personal.search.orcid}"    
    Then ensure that orcid account "${personal.search.orcid.search.result}" is present in personal account search result page    
    
    #----- profile page  ------#    
 
    When searched personal account "${personal.search.orcid.search.result}" is selected
    Then ensure these elements are present or not present in the current my account page
 
    ${myaccount.profile.page.elements.webadmin} 
  
    When user is on WebAdmin account profile address book modification page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.profile.addressbook.page.elements.webadmin}     
    
    When user is on WebAdmin my account profile change password page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.profile.change.password.page.elements}    
    
    When user is on WebAdmin my account profile change email page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.profile.change.email.page.elements}    
     
    When user is on WebAdmin my account profile work details page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.profile.work.details.page.elements}  
    
    When user is on WebAdmin my account maximum login page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.profile.maximum.login.page.elements}  

    #----- alerts page  ------#

    When user is on WebAdmin my account user navigate to alerts page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.alerts.page.elements}  
    
    When user is on WebAdmin my account user navigate to alerts modification page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.alerts.modification.elements}  
    
    #-----  subscriptions and purchases page   ------#

    When user is on WebAdmin my account user navigate to subscriptions and purchases page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.subscriptions.purchases.elements}    
   
  
   
  Scenario: user navigates MyAccount pages     
    Given user is logged-in as "${myaccount.user.username}" password "${myaccount.user.password}" for user personal account search  

    #----- profile page  ------#

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
        
    #----- alerts page  ------#

    When my account user navigate to alerts page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.alerts.page.elements}  
    
    When my account user navigate to alerts modification page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.alerts.modification.elements}  
    
    #-----  subscriptions and purchases page  ------#

    When my account user navigate to subscriptions and purchases page
    Then ensure these elements are present or not present in the current my account page
    
    ${myaccount.subscriptions.purchases.elements}
          