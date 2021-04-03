Feature: Rick and morty api server

  Background:
    * url 'https://rickandmortyapi.com/api/'
    * header Accept = 'application/json'


  Scenario Outline: Check info and pagination veracity
    Given path '<path>'
    When method get
    Then status 200
    And assert response.info.count > 0
    And assert response.info.pages > 0

    Examples:
      |path|
      |character|
      |location|
      |episode|


  Scenario Outline: Check character response
    Given  path '<path>'
    And def expectedOutput = read('data/characters.json')
    When method get
    Then status 200
    And match $ == expectedOutput
    Examples:
      |path|
      |character|

  Scenario Outline: Check location response
    Given  path '<path>'
    And def expectedOutput = read('data/locations.json')
    When method get
    Then status 200
    And match $ == expectedOutput
    Examples:
      |path|
      |location|

  Scenario Outline: Check episodes response
    Given  path '<path>'
    And def expectedOutput = read('data/episodes.json')
    When method get
    Then status 200
    And match $ == expectedOutput
    Examples:
      |path|
      |episode|



