package com.saucedemo.glue;


import com.saucedemo.models.ModelCredentials;
import com.saucedemo.models.ModelCustomer;
import com.saucedemo.tasks.*;
import com.saucedemo.ui.CheckoutPage;
import com.saucedemo.ui.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.Text.of;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.equalTo;

public class CompraGlue {

    @Given("el usuario {actor} ingresa a la pagina web SauceDemo")
    public void elUsuarioIngresaALaPaginaWebSauceDemo(Actor actor) {
        givenThat(actor).attemptsTo(
                NavigateTo.page(LoginPage.class)
        );
    }
    @When("el ingresa sus credenciales")
    public void elIngresaSusCredenciales(io.cucumber.datatable.DataTable credentials) {
        when(theActorInTheSpotlight()).wasAbleTo(
                MakeLoginSL.whitCredentials(new ModelCredentials(credentials))
        );
    }
    @When("agrega {int} productos al carrito")
    public void agregaProductosAlCarrito(int productos) {
        when(theActorInTheSpotlight()).wasAbleTo(
                AddProductSL.quantity(productos)
        );
        andThat(theActorInTheSpotlight()).wasAbleTo(
                ViewCartSL.view()
        );
    }
    @When("completa el formulario de compra")
    public void completaElFormularioDeCompra(io.cucumber.datatable.DataTable customer) {
        when(theActorInTheSpotlight()).wasAbleTo(
                CheckoutSL.whitCredentials(new ModelCustomer(customer))
        );
    }
    @Then("finaliza la compra visualizando el mensaje {string}")
    public void finalizaLaCompraVisualizandoElMensaje(String string) {
        then(theActorInTheSpotlight()).should(
                seeThat("Mensaje exitoso", the(CheckoutPage.LABEL_MSG_SUCCESS),isVisible()),
                seeThat("Mensaje exitoso", of(CheckoutPage.LABEL_MSG_SUCCESS), equalTo(string))
        );
    }
}
