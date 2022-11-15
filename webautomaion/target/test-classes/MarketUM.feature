Feature: Market UM Alerts

  I am a user of MarketAlertUM
  I want that only I can get access to my account.
  There should not be more than 5 alerts at a time.

  Scenario: Valid Login
    Given I am a user of marketalertum
    When I login using valid credentials
    Then I should see my alerts

  Scenario: Invalid Login
    Given I am a user of marketalertum
    When I login using invalid credentials
    Then I should see the login screen again

  Scenario: Alert Layout
    Given I am an administrator of the website and I upload 3 alerts
    Given I am a user of marketalertum
    When I view a list of alerts
    Then each alert should contain an icon
    And each alert should contain a heading
    And each alert should contain a description
    And each alert should contain an image
    And each alert should contain a price
    And each alert should contain a link to the original product website

  Scenario: Alert limit
    Given I am an administrator of the website and I upload more than 5 alerts
    Given I am a user of marketalertum
    When I view a list of alerts
    Then I should see 5 alerts

  Scenario: Icon Check
    Given I am an administrator of the website and I upload an alert of type 2
    Given I am a user of marketalertum
    When I view a list of alerts
    Then I should see 1 alerts
    And the icon displayed should be <icon file name>
