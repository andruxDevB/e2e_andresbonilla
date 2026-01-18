package com.saucedemo.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {
    public static final Target BUTTON_ADD_PRODUCTS = Target.the("Botón agregar producto")
            .locatedBy("//button[contains(@class,'btn_inventory')]");
    public static final Target BUTTON_VIEWCART = Target.the("Botón ver carro compras")
            .locatedBy("#shopping_cart_container");
    public static final Target BUTTON_CHECKOUT = Target.the("Botón finalizar compra")
            .locatedBy("#checkout");
}
