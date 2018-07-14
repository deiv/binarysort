Feature: Tests para el endpoint binarysort

  Background:
    * url 'http://localhost:8080'
    * configure headers = { 'Content-Type': 'application/json;charset=UTF-8', 'Accept':'application/json' }
    * path 'binarysort'

  Scenario Outline: se ordenan los enteros correctamente
    Given request { "integer_list": [<entrada>] }
    When method POST
    Then status 200
    Then match header Content-Type == 'application/json;charset=UTF-8'
    Then match response == { "result": [<salida>] }

    Examples:
      | entrada | salida |
      | 1, 15, 5, 7, 3 | 15, 7, 3, 5, 1 |

  Scenario: devuelve una lista vacia si la entrada está vacia
    Given request { "integer_list": [ ] }
    When method POST
    Then status 200
    Then match header Content-Type == 'application/json;charset=UTF-8'
    Then match $ == { "result": [] }

  Scenario Outline: respondemos con error para entradas distintas de numeros enteros
    Given request { "integer_list": [<entrada>] }
    When method POST
    Then status 400
    Then match $ == ''

    Examples:
      | entrada |
      | 1, 15, "5", 7, 3 |
      | 1, 15, 5.5, 7, 3 |
      | 1, 15, , ,, 1 7, 3 |
      | 1, 15, 1 7, 3 |
      | a, b, c, 3 |

  Scenario: respondemos con error para entradas con esquema no esperado
    Given request { "propiedad_noesperada": "valor_noesperado", "foo": "bar" }
    When method POST
    Then status 400
    Then match $ == ''

