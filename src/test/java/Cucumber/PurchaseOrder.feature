
@tag
Feature: Purchase the order from Ecormerce website
  I want to use this template for my feature file

	Background:
	Given I land on Ecomerce page
 

  @Regression
  Scenario Outline: Positive test for submiting the order
    Given Login with the username <name> and password <password>
    When I add the product <productName> to cart
    And checkout <productName> and submit the order
    Then "Thankyou for the order." message displayed on conformation page
    
    Examples: 
      | name  											| password  | productName|
    	|soumyaadhikary2018@gmail.com |Soumya123@ | ZARA COAT 3|
    	|soumyaadhikary23@gmail.com		|Soumya123@ | ZARA COAT 3|
