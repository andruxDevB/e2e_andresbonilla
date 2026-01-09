Feature: Flujo de compra en SauceDemo

  Scenario: Compra E2E exitosa
    Given el usuario ingresa a SauceDemo
    When inicia sesión con credenciales validas
    And agrega dos productos al carrito
    And completa el proceso de compra
    Then debe ver el mensaje "THANK YOU FOR YOUR ORDER"