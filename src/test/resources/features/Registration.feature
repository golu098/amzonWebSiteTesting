Feature: Testing Registration page of Amazon

  Background:
    Given the user is on the registration page

  Scenario: Checking required fields on the form
    When the page loads
    Then a registration form should be prominently displayed with the required fields:
      | Field         | Type     | Validation |
      | Your name     | text     | Required   |
      | Mobile number | number   | Required   |
      | Password      | password | Required   |


  Scenario: Successful Registration with valid details
    Given a user enters valid details in the registration form:

      | Your name | Mobile number | password |
      | shiv kant | 6202055728    | Abcs12@  |

    When the "Submit" button is clicked
  Scenario Outline: Field validation messages appear correctly
    Given a user has visited and then moved away from the "<Field>" field
    When the input in the "<Field>" field is invalid or missing after the visit
    Then an error message should dynamically appear next to the "<Field>" field, specifying the error "<Error Message>"

    Examples:
      | Field         | Error Message   |
      | Your name     | Enter your name |
      | Mobile number | Enter your mobile number                |
      |   Password            |       Enter your password          |

  Scenario Outline: Registration Error - Password too short
    Given a user enters a password '<password>' shorter than 6 characters
    When the user submits the form
    Then the form should show an error message "Passwords must be at least 6 characters."

    Examples:
      | password |
      | short    |
      | abc      |
      | a        |

