Feature: Fizzbuzz

  Scenario Outline: Computing the Fizzbuzz value
    Given a value of <value>
    When I compute the value
    Then it should return <expected>

    Examples:
      | value | expected  |
      | 1     | "1"       |
      | 2     | "2"       |
      | 3     | "fizz"    |
      | 4     | "4"       |
      | 5     | "buzz"    |
      | 6     | "fizz"    |
      | 7     | "7"       |
      | 8     | "8"       |
      | 9     | "fizz"    |
      | 10    | "buzz"    |
      | 11    | "11"      |
      | 12    | "fizz"    |
      | 13    | "13"      |
      | 14    | "14"      |
      | 15    | "fizzbuzz"|