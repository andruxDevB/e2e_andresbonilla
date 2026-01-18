package com.saucedemo.tasks;

import com.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ViewCartSL implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(CartPage.BUTTON_VIEWCART)
        );

    }

    public static ViewCartSL view() {
        return instrumented(ViewCartSL.class);
    }
}
