package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {

    public static final Target PRODUCT_ONE =
            Target.the("Producto 1")
                    .locatedBy("//button[@data-test='add-to-cart-sauce-labs-backpack']");

    public static final Target PRODUCT_TWO =
            Target.the("Producto 2")
                    .locatedBy("//button[@data-test='add-to-cart-sauce-labs-bike-light']");

    public static final Target CART =
            Target.the("Carrito")
                    .locatedBy(".shopping_cart_link");
}