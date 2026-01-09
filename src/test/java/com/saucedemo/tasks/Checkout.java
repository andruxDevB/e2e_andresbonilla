package com.saucedemo.tasks;

import com.saucedemo.models.Data;
import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Checkout implements Task {

    private final Data data;

    public Checkout(Data data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(CheckoutPage.FINISH_BUTTON),
                Enter.theValue(data.getFirstName()).into(CheckoutPage.FIRSTNAME),
                Enter.theValue(data.getLastName()).into(CheckoutPage.LASTNAME),
                Enter.theValue(data.getPostalCode()).into(CheckoutPage.POSTALCODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }

    public static Checkout with(Data data) {
        return instrumented(Checkout.class, data);
    }
}
