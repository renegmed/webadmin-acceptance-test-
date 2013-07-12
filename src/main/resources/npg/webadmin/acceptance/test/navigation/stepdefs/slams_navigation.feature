${at.sign}InitializeSlams
${at.sign}CloseSlams

Feature: Slams Navigation Verification  
       As site account librarian or WebAdmin user,
       I want to navigate into SLAMS pages
       so I can view and verify the page contents and links      
  
  
  Scenario: Webadmin Site Account SLAMS navigations sanity check
      
      Given user is logged-in as "${login.username}" password "${login.password}" for site account search
      And is on SLAMS page for site id "${slams.site.id}"    
      
      When on site account summary page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.summary.page.elements.webadmin}     
       
      When on site account summary modify user name page      
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.summary.modify.username.page.elements.common}     
      
      When on site account summary modify password page      
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.summary.modify.password.page.elements.common}    
            
      When on site account summary modify account details page      
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.summary.modify.account.details.page.elements.common}
 
      When on site account summary modify open url page      
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.summary.modify.open.url.page.elements.webadmin}    
      
      When on site account summary modify email page      
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.summary.modify.email.page.elements.common}
           
      When on site account summary modify address page      
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.summary.modify.address.page.elements.common} 

            
      When on site account address page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.address.page.elements.common}      

	  When on site account modify account address page 
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.address.modify.address.page.elements.webadmin}


      When on site account licenses page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.licenses.page.elements.webadmin}      
     
      When on site account license journal "${slams.account.licenses.journal.1}" page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.licenses.journal.page.elements.1.webadmin}      
      
      When on site account license journal "${slams.account.licenses.journal.2}" page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.licenses.journal.page.elements.2.webadmin}  
      
      
      When on site account article on demand page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.aod.page.elements.webadmin}
      
      When on site account article on demand license "${slams.account.aod.license.1}" page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.aod.license.page.elements.webadmin}
      
            
      When on site account ip ranges page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.ip.ranges.page.elements.webadmin}

      When on site account ip ranges modification page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.ip.ranges.modify.page.elements.webadmin}
      

      When on site account tokens page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.tokens.page.elements.webadmin}
      
      When on site account modify NPG token details page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.tokens.modify.npg.page.elements.webadmin}
      
      When on site account modify Palgrave Connect token details page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.tokens.modify.palgraveconnect.page.elements.webadmin}
      
      When on site account modify Palgrave Journals token details page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.tokens.modify.palgravejournals.page.elements.webadmin}
       
      
      When on site account statistics page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.statistics.page.elements.common}
      

      When on site account e-alerts page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.ealerts.page.elements.webadmin}

      When on site account e-alerts signup page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.ealerts.signup.page.elements.common}
      
      
      When on site account cap page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.cap.page.elements.webadmin}
      
      When on site account modify cap page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.cap.modify.page.elements.webadmin}
      
      When on site account modify cap password page
      Then tabs are present or not at site account SLAMS page
      ${slams.account.tab.page.elements.webadmin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.cap.password.modify.page.elements.common}
  
        
   Scenario: Nature Site administration SLAMS navigations sanity check
      
  	  Given Nature site administrator is in site account login page
  	  When site administrator logs in with name "${site.admin.login.username}" and password "${site.admin.login.password}"
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page  
      ${slams.account.summary.page.elements.site_admin}
 
 
      
      When on site administrator account summary modify user name page      
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.summary.modify.username.page.elements.common}          
            
      When on site administrator account summary modify password page      
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.summary.modify.password.page.elements.common}    
            
            
      When on site administrator account summary modify account details page      
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the SLAMS current page
      ${slams.account.summary.modify.account.details.page.elements.common}
 
      When on site administrator account summary modify open url page      
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.summary.modify.open.url.page.elements.site_admin}    
      
      When on site administrator account summary modify email page      
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.summary.modify.email.page.elements.common}
           
      When on site administrator account summary modify address page      
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.summary.modify.address.page.elements.common} 

            
      When on site administrator account address page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.address.page.elements.common}      

	  When on site administrator account modify account address page 
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.address.modify.address.page.elements.site_admin}


      When on site administrator account licenses page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.licenses.page.elements.site_admin}      
     
      When on site administrator account license journal "${slams.account.licenses.journal.1}" page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.licenses.journal.page.elements.1.site_admin}      
      
      When on site administrator account license journal "${slams.account.licenses.journal.2}" page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.licenses.journal.page.elements.2.site_admin}  
      
      
      When on site administrator account article on demand page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.aod.page.elements.site_admin}
      
      When on site administrator account article on demand license "${slams.account.aod.license.1}" page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.aod.license.page.elements.site_admin}
                  
      When on site administrator account ip ranges page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.ip.ranges.page.elements.site_admin}

      When on site administrator account ip ranges modification page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.ip.ranges.modify.page.elements.site_admin}
      

           
      When on site administrator account tokens page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.tokens.page.elements.site_admin.nature}
      
      When on site administrator account modify NPG token details page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.tokens.modify.page.elements.site_admin.nature}
      
  
      
      When on site administrator account statistics page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.statistics.page.elements.common}      

      When on site administrator account e-alerts page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.ealerts.page.elements.site_admin}

      When on site administrator account e-alerts signup page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.ealerts.signup.page.elements.common}
      
      
      When on site administrator account cap page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.cap.page.elements.site_admin}
      
      When on site administrator account modify cap page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.cap.modify.page.elements.site_admin}
      
      When on site administrator account modify cap password page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.cap.password.modify.page.elements.common}
 
   ${at.sign}sprint-3 
   Scenario: Palgrave Journals Site administration SLAMS navigation sanity check
   
  	  Given Palgrave Journals site administrator is in site account login page
  	  When site administrator logs in with name "${site.admin.login.username}" and password "${site.admin.login.password}"
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin.palgrave}
      And ensures these elements are present or not present in the Site Admin SLAMS current page  
      ${slams.account.summary.page.elements.site_admin.palgravejournals}    
 
      
      When on site administrator account tokens page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin.palgrave}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.tokens.page.elements.site_admin.palgravejournals}
      
      When on site administrator account modify Palgrave Journals token details page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin.palgrave}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.tokens.modify.page.elements.site_admin.palgravejournals}
      
      
   ${at.sign}sprint-4  
   Scenario: Palgrave Connect Site administration SLAMS navigation sanity check
  
  	  Given Palgrave Connect site administrator is in site account login page
  	  When site administrator logs in with name "${site.admin.login.username}" and password "${site.admin.login.password}"
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin.palgrave}
      And ensures these elements are present or not present in the Site Admin SLAMS current page  
      ${slams.account.summary.page.elements.site_admin.palgravejournals}          
 
      When on site administrator account tokens page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin.palgrave}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.tokens.page.elements.site_admin.palgraveconnect}
      
      When on site administrator account modify Palgrave Connect token details page
      Then tabs are present at site administrator SLAMS page
      ${slams.account.tab.page.elements.site_admin.palgrave}
      And ensures these elements are present or not present in the Site Admin SLAMS current page
      ${slams.account.tokens.modify.page.elements.site_admin.palgraveconnect}      
     
          