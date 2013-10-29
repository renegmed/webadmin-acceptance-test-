cucumber-jvm-guice-examples
===========================

Looking at how to configure Guice to allow Stepdefs etc to use an interface while the Guice binding maps to a concrete implementation

@Inject annotations are required for all classes that don't have a no-arg constructor.


Acceptance Testing Using Cucumber jvm


To create and run test application

> mvn clean resources:resources -Dbrowser=safari test

> mvn clean resources:resources -Denvironment=test -Dbrowser=safari test

browser values:

chrome - to use provided chrome driver 
chromehtml - to use HtmlUnitDriver generic chrome version
chrome16 - to use HtmlUnitDriver chrome version 16
foxtrot17 - to use HtmlUnitDriver foxtrot version 17
foxtrot10 - to use HtmlUnitDriver foxtrot version 10
foxtrot3 - to use HtmlUnitDriver foxtrot version 3
safari - to use selenium provided safari driver
explorer or iexplorer - to use selenium provided iexplorer driver


Running Specific Scenarios using Tag

If you tag a selected scenarios with @sprint-7 and call this:

  mvn clean resources:resources -Denvironment=test -Dbrowser=htmlunit -Dcucumber.options="--tags @sprint-2" test

only the scenarios with @sprint-7 will be ran. However if you call this:
 
  mvn clean resources:resources -Denvironment=test -Dbrowser=safari test

even though the tag @sprint-7 is still present in the selected scenarios, all the scenarios will be ran.  

