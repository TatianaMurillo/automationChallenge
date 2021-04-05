Feature: unit conversor application

    Scenario Outline: Convert units
      Given I want to convert units
      When  I introduce the values in the application
        |OriginValue  |<OriginValue> |
        |OriginUnit   |<OriginUnit>   |
        |DestinyUnit  |<DestinyUnit> |
      Then  I get the equivalent value for the target unit

      Examples:
      |OriginValue|OriginUnit|DestinyUnit|
      |345        |Pie |Link |