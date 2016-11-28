Feature: Min-Max pairs

  Scenario Outline: Compute the pair of minimum and maximum products in a list of integer values.
    Given a list of <values>
    When I compute the list
    Then it should return <expected>

    Examples:
      | values  | expected  |
      |         | 0, 0      |
      | 2       | 2, 2      |
      | 1, 2, 3 | 2, 6      |