package com.saucedemo.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.saucedemo.ui.CartPage.BUTTON_ADD_PRODUCTS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductSL implements Task {

    private final int quantity;

    public AddProductSL(int quantity) {
        this.quantity = quantity;
    }

    public static AddProductSL quantity(int quantity) {
        return instrumented(AddProductSL.class, quantity);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> buttons =
                BUTTON_ADD_PRODUCTS.resolveAllFor(actor);

        for (int i = 0; i < quantity; i++) {
            actor.attemptsTo(
                    Click.on(buttons.get(i))
            );
        }

    }

}
