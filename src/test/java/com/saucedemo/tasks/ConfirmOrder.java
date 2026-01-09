package com.saucedemo.tasks;

import com.saucedemo.models.Data;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.saucedemo.ui.CheckoutPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmOrder {

    public static Task with(Data data) {
        return instrumented(ConfirmOrderTask.class, data);
    }

    public static class ConfirmOrderTask implements Task {

        private final Data data;

        public ConfirmOrderTask(Data data) {
            this.data = data;
        }

        @Override
        public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Enter.theValue(data.getFirstName()).into(FIRSTNAME),
                    Enter.theValue(data.getLastName()).into(LASTNAME),
                    Enter.theValue(data.getPostalCode()).into(POSTALCODE),
                    Click.on(CONTINUE_BUTTON),
                    Click.on(FINISH_BUTTON)
            );
        }
    }
}
