Feature: First one

  Scenario:

    Given a game looks like this:
    |XXXX|
    |X @X|
    |XXXX|

    When player moves left

    Then a game should look like this:
    |XXXX|
    |X@ X|
    |XXXX|
