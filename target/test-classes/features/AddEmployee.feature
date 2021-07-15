Feature: Adding employees

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on add employee button

  @smoke
  Scenario: Adding employee from add employee page
    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee is added successfully

    @smoke
   Scenario: Adding employee from add employee page via feature file
    And user enters first name "Sammyyy" middlename "middleee" and lastname"lastnameeee"
    And user clicks on save button
    And employee is added successfully

      @example
      Scenario Outline: Adding employee from add employee page via feature file
        And user enters "<FirstName>" "<MiddleName>" and "<LastName>" in the application
        And user clicks on save button
        Then employee is added successfully

        Examples:
          |FirstName|MiddleName|LastName|
          |Ashleyy  |Midleee   |Lastttt |
          |Bennyyy  |MN        |LN      |
          |Hailyy   |Middle    |Last    |


        @datatablewithheader
        Scenario: Adding multiple employees in a single execution
          When add multiple employees and verify they are added successfully
          |FirstName|MiddleName|LastName|
          |Hasell    |Middleee  |Lasttt  |
          |Hensell   |MiddleN   |LastN   |
          |Haylii   |Middle    |Last    |

          @excel
          Scenario: Adding the employee from excel file
            When  user adds multiple employees from excel file from "newData" sheet and verify they are added

            @db
            Scenario:Add the employee and testing it from the backend
              When user enters firstname middlename and lastname
              And capture the employeeId
              And user clicks on
              Then query the HRMS database
              And verify the data from frontend and backend


