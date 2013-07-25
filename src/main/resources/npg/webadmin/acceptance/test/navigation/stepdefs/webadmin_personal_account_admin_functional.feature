${at.sign}InitializeWebAdminPAFunc
${at.sign}CloseWebAdminPAFunc

Feature: Personal Account Admin
 
  
  ${at.sign}sprint-1
  Scenario: 1.0 Search personal accounts using different criteria 
    Given user is logged-in as "${login.username}" password "${login.password}" for webadmin personal account admin        
    When user is on personal account search page
    Then ensure result item is in the search result page   
	
	  ${personal.search.scenario.user}

  ${at.sign}sprint-1 
  Scenario: 2.0 Search user orcid id
    Given user is logged-in as "${login.username}" password "${login.password}" for webadmin personal account admin    
    When user is on personal account search page      
    Then ensure orcid account "${personal.search.scenario.orcid.search.result}" is in the search result page 
    
      ${personal.search.scenario.orcid} 
       
     
                                