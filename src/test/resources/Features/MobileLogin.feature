Feature: Supper App Test
  @all
  Scenario: Login
    Given validate login page and click login
    When write username "<user>"
    And write password "<password>"
    And clicks on login btn
    Then user is navigate to the home page
    Examples:
      | user                   | password |
      | typhoonakkus@gmail.com | 123456   |

