package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static Target CHECKOUT = Target.the("checkout").located(By.id("checkout"));
}
