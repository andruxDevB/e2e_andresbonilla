package com.saucedemo.tasks;

import com.saucedemo.models.Data;
import com.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

public class Login implements Task {

    private final Data data;

    public Login(Data data) {
        this.data = data;
    }

    public static Login withCredentials(Data data) {
        return Tasks.instrumented(Login.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.getUsername()).into(LoginPage.USERNAME),
                Enter.theValue(data.getPassword()).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
