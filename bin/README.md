# cucumber-restassured
cucumber rest assured sample

[![Build Status](https://travis-ci.org/cucumber/cucumber-java-skeleton.svg?branch=main)](https://travis-ci.org/cucumber/cucumber-java-skeleton)

This is the simplest possible build script setup for Cucumber Rest Assured api sample testing using Java.
There is a 5 feature filee with 5 scenarios. The scenario has three steps, run with tags to make them all pass!

## Get the code

Git:

    git clone https://github.com/pmsk92/cucumber-restassured.git
    cd cucumber-java-restassured-upd
    
    
Or simply [download a zip](https://github.com/pmsk92/cucumber-restassured/archive/main.zip) file.

## Use Maven

Open a command window and run:

    ./mvnw test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the 
`RunCucumberTest` class tells JUnit to kick off Cucumber.

For Example:-
@apiTest1 will run the api first test case and the @apiTest* will run the corresponding cases.
@apiTests tag is given to all feature files and running the test runner with this tag will make all the 5 tests to run
Reporting:- Cucmber report can be used and also allure report is integrated. 


## Use Gradle

Open a command window and run:

     ./gradlew test --rerun-tasks --info

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the
`RunCucumberTest` class tells JUnit to kick off Cucumber.

## Overriding options

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:

    mvn -Dcucumber.features="..." -Dcucumber.glue="..." test

Using Gradle:

    gradlew -Dcucumber.features="..." -Dcucumber.glue="..." test

