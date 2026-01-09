package com.saucedemo.stepdefinitions;

import com.saucedemo.models.Data;
import com.saucedemo.questions.ConfirmationMessage;
import com.saucedemo.tasks.*;
import com.saucedemo.utils.CsvUtils;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class StepDefinitions {

    private Actor usuario;
    private Data data;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());

        usuario = Actor.named("Usuario");
        usuario.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));


        data = CsvUtils.readCheckoutData();
    }

    @Given("el usuario ingresa a SauceDemo")
    public void el_usuario_ingresa_a_saucedemo() {
        usuario.attemptsTo(OpenSauceDemo.page());
    }

    @When("inicia sesión con credenciales validas")
    public void inicia_sesion_con_credenciales_validas() {
        usuario.attemptsTo(Login.withCredentials(data));
    }

    @And("agrega dos productos al carrito")
    public void agrega_dos_productos_al_carrito() {
        usuario.attemptsTo(AddProducts.toCart());
    }

    @And("completa el proceso de compra")
    public void completa_el_proceso_de_compra() {
        usuario.attemptsTo(Checkout.with(data));
    }

    @Then("debe ver el mensaje {string}")
    public void debe_ver_el_mensaje(String mensaje) {
        usuario.should(
                seeThat(ConfirmationMessage.text(), containsString(mensaje))
        );
    }
}
