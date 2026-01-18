package com.saucedemo.ui;

import net.serenitybdd.annotations.DefaultUrl;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


@DefaultUrl("page:webdriver.base.url.saucedemo")
public class LoginPage extends PageObject {
    public static final Target INPUT_USERNAME = Target.the("Campo usuario")
            .locatedBy("#user-name");
    public static final Target INPUT_PASSWORD = Target.the("Campo contraseña")
            .locatedBy("#password");
    public static final Target BUTTON_LOGIN = Target.the("Botón iniciar sesión")
            .locatedBy("#login-button");
}
