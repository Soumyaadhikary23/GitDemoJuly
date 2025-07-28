
@tag
Feature: Error Validation
  I want to use this template for my feature file

  

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I land on Ecomerce page
    When Login with the username <name> and password <password>
    Then "Incorrect email or password." message displayed 

       Examples: 
      | name  											| password  | 
    	|soumyaadhikary@gmail.com 		|Soumya123@ | 
    	
