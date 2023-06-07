@NewTask
Feature: Validate the JQUERY Portal functions

  Scenario: Validate Drag and Drop action
    Given user navigates to the JQUERY landing page
    When user selects the Droppable interaction action
    Then user can drag and drop element


  Scenario: Validate MultiSelect action
    Given user navigates to the JQUERY landing page
    When user selects the Selectable interaction action
    Then user can multiselect "Item 1" "Item 3" "Item 7"


  Scenario: Validate ControlGroup Widget action
    Given user navigates to the JQUERY landing page
    When user selects the ControlGroup Widget action
    And user select Vehicle Transmission type
    And user select Vehicle Insurance period
    And user select Rental Vehicle Transmission type
    And user select Rental Vehicle Insurance period
    Then user can book now Vehicle