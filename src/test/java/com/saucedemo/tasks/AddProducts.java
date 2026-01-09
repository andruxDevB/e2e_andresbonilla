package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.saucedemo.ui.ProductsPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProducts {

    public static Task toCart() {
        return instrumented(AddProductsTask.class);
    }

    public static class AddProductsTask implements Task {

        @Override
        public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Click.on(PRODUCT_ONE),
                    Click.on(PRODUCT_TWO),
                    Click.on(CART)
            );
        }
    }
}