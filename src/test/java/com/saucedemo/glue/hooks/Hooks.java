package com.saucedemo.glue.hooks;

import com.google.common.base.Splitter;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class Hooks {

    @Before
    public void firstSetTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @ParameterType(".*")
    public Actor actor(String actor) {
        return OnStage.theActorCalled(actor);
    }

    @ParameterType(".*")
    public List<String> items(String listOfItems) {
        return Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .splitToList(listOfItems);
    }
}