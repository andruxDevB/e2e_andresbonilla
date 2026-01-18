package com.saucedemo.tasks;

import com.saucedemo.models.ModelCustomer;
import com.saucedemo.ui.CartPage;
import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CheckoutSL implements Task {

    private String f_name;
    private String l_name;
    private String p_code;

    public CheckoutSL (ModelCustomer customer) {
        this.f_name = customer.getF_name();
        this.l_name = customer.getL_name();
        this.p_code = customer.getP_code();
    }

    public static CheckoutSL whitCredentials( ModelCustomer customer) {
        return Tasks.instrumented(CheckoutSL.class, customer);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.BUTTON_CHECKOUT),
                WaitUntil.the(CheckoutPage.INPUT_FIRST_NAME, isEnabled()).forNoMoreThan(10L).seconds(),
                Enter.keyValues(f_name).into(CheckoutPage.INPUT_FIRST_NAME),
                Enter.keyValues(l_name).into(CheckoutPage.INPUT_LAST_NAME),
                Enter.keyValues(p_code).into(CheckoutPage.INPUT_POSTAL_CODE),
                Click.on(CheckoutPage.BUTTON_CONTINUE),
                WaitUntil.the(CheckoutPage.BUTTON_FINISH, isEnabled()).forNoMoreThan(10L).seconds(),
                Click.on(CheckoutPage.BUTTON_FINISH)

        );
    }
}
