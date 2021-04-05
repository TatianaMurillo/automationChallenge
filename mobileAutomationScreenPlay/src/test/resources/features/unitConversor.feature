Feature: unit conversor application

  @Test1
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

    @Test2
  Scenario Outline: Convert Velocities
    Given I want to convert Velocidad
    When  I introduce the values for Velocities
      |valueToConvert  |<valueToConvert>      |
      |originUnitName  |<originUnitName>      |
      |targetUnitName  |<targetUnitName>      |
    Then  I get the equivalent value for velocity

    Examples:
      |valueToConvert|originUnitName   |targetUnitName |
      |1             | MILLAXMINUTO    |MILIMETROXHORA |
      |3             | METROXMINUTO    |MILLAXMINUTO   |

  @Test3
  Scenario Outline: Convert Areas
    Given I want to convert Area
    When I introduce the values for Areas
      |valueToConvert  |<valueToConvert>      |
      |originUnitName  |<originUnitName>      |
      |targetUnitName  |<targetUnitName>      |
    Then  I get the equivalent value for area

    Examples:
      |valueToConvert|originUnitName   |targetUnitName|
      |3             |  ACRE           |HECTARE       |
      |345           |  SQUARE_METER   |HECTARE       |