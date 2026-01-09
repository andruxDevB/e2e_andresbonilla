package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target FIRSTNAME = Target.the("campo nombre").located(By.id("first-name"));
    public static final Target LASTNAME = Target.the("campo apellido").located(By.id("last-name"));
    public static final Target POSTALCODE = Target.the("campo postal").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("botón continuar").located(By.id("continue"));
    public static final Target FINISH_BUTTON = Target.the("botón finalizar").located(By.id("finish"));
    public static final Target CONFIRM_MESSAGE = Target.the("mensaje confirmación")
            .located(By.className("complete-header"));
}
