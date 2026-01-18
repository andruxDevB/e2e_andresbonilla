package com.saucedemo.tasks;

import com.saucedemo.models.ModelCredentials;
import com.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class MakeLoginSL implements Task {

    private String user;
    private String password;

    public MakeLoginSL(ModelCredentials credentials){
        this.user = credentials.getUser();
        this.password = credentials.getPassword();
    }

    public static MakeLoginSL whitCredentials( ModelCredentials credentials) {
        return Tasks.instrumented(MakeLoginSL.class, credentials);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.keyValues(user).into(LoginPage.INPUT_USERNAME),
                Enter.keyValues(password).into(LoginPage.INPUT_PASSWORD),
                Click.on(LoginPage.BUTTON_LOGIN)
        );

    }
}
