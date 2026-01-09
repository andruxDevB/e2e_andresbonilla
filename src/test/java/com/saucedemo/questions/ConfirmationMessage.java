package com.saucedemo.questions;

import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConfirmationMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return CheckoutPage.CONFIRM_MESSAGE
                .resolveFor(actor)
                .getText();
    }

    public static ConfirmationMessage text() {
        return new ConfirmationMessage();
    }
}
