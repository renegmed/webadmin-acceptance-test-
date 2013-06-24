cucumber-jvm-guice-examples
===========================

Looking at how to configure Guice to allow Stepdefs etc to use an interface while the Guice binding maps to a concrete implementation

@Inject annotations are required for all classes that don't have a no-arg constructor.


Acceptance Testing Using Cucumber jvm


To create and run test application

> mvn clean resources:resources -Dbrowser=safari test

> mvn clean resources:resources -Denvironment=test -Dbrowser=safari test


