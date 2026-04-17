Feature: Login to the Application


Background:
  Given I want to launch the browserApp
  And enter the URL as "https://www.saucedemo.com/"

Scenario:
Login to the App with Valid Credentials


When Login page is displayed enter username as "standard_user"
And enter the password as "secret_sauce"
And click on login button field
Then validate the homepageApp

#Same script with multiple data - Scenario outline with Example

   Scenario Outline: Login to Application with multiple credentials
   
    When Login page is displayed provide username as "<Username>"
    And provide password as "<Password>"
    And click on the login button 
    Then I validate for the Home Page
    
    
    Examples:
    
    | Username | Password | 
    | standard_user | secret_sauce |
    | locked_out_user | secret_sauce |
    | problem_user | secret_sauce |