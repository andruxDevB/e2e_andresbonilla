package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenSauceDemo implements Task {

    private static final String URL = "https://www.saucedemo.com";

    public static OpenSauceDemo page() {
        return Tasks.instrumented(OpenSauceDemo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL)
        );
    }
}
