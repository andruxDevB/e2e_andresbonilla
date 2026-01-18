package com.saucedemo.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage extends PageObject {

    public static final Target INPUT_FIRST_NAME = Target.the("Campo nombre cliente")
            .locatedBy("#first-name");
    public static final Target INPUT_LAST_NAME = Target.the("Campo apellido cliente")
            .locatedBy("#last-name");
    public static final Target INPUT_POSTAL_CODE = Target.the("Campo codigo postal")
            .locatedBy("#postal-code");
    public static final Target BUTTON_CONTINUE = Target.the("Botón continuar")
            .locatedBy("#continue");
    public static final Target BUTTON_FINISH = Target.the("Botón finalizar")
            .locatedBy("#finish");
    public static final Target LABEL_MSG_SUCCESS = Target.the("Mensaje compra exitosa")
            .locatedBy(".complete-header");

}
