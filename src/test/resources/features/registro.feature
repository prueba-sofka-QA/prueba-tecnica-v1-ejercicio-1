Feature: Registro de usuario

  Scenario: Registro exitoso con datos validos
    Given que el usuario esta en la pagina de registro
    When completa el formulario con datos validos
    Then el sistema muestra un mensaje de confirmacion
