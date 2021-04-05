Feature: unit conversor application

  Scenario Outline: Convert longitudes
    Given I want to convert Longitud
    When  I introduce the values for longitudes
      |valueToConvert  |<valueToConvert>      |
      |originUnitName  |<originUnitName>   |
      |targetUnitName  |<targetUnitName>       |
    Then  I get the equivalent value for the target unit

    Examples:
      |valueToConvert|originUnitName|targetUnitName|
      |345           |  METERS      |PIES          |
      |345           |  PIES        |METERS        |

  Scenario Outline: Convert Velocities
    Given I want to convert Velocidad
    When  I introduce the values for Velocities
      |valueToConvert  |<valueToConvert>      |
      |originUnitName  |<originUnitName>   |
      |targetUnitName  |<targetUnitName>       |
    Then  I get the equivalent value for the target unit

    Examples:
      |valueToConvert|originUnitName|targetUnitName|
      |345           |  METERS      |PIES          |
      |345           |  PIES        |METERS        |

  Scenario Outline: Convert Areas
    Given I want to convert Area
    When I introduce the values for Areas
      |valueToConvert  |<valueToConvert>      |
      |originUnitName  |<originUnitName>   |
      |targetUnitName  |<targetUnitName>       |
    Then  I get the equivalent value for the target unit

    Examples:
      |valueToConvert|originUnitName|targetUnitName|
      |345           |  METERS      |PIES          |
      |345           |  PIES        |METERS        |