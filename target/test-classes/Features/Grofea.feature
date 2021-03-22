Feature: Grolls
  Order some T-shirts

  @mytag

  Scenario:Select 2 small T-Shirts on Grolls
    Given I have selected size small
    And  I have also selected 2 T-shirt
    When I press cart
    Then the result should be 2 small T-shirts in the basket