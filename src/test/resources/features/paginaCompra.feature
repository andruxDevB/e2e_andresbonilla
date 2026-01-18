@serenityE2E
Feature: Automatizacion prueba funcional flujo de compra en pagina web

    @id:1
    Scenario Outline: Compra en pagina web iniciando sesion con credenciales validas
      Given el usuario cliente ingresa a la pagina web SauceDemo
      When el ingresa sus credenciales
        | user   | password   |
        | <user> | <password> |
      And agrega 2 productos al carrito
      And completa el formulario de compra
        | f_name   | l_name   | p_code   |
        | <f_name> | <l_name> | <p_code> |
      Then finaliza la compra visualizando el mensaje "<message>"
      Examples:
        | user | password | f_name | l_name | p_code | message |
        | standard_user | secret_sauce | Andres | Bonilla | 170150 | Thank you for your order! |
