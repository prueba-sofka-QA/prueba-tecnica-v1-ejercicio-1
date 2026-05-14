package com.purchase.stepdefinitions.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hook {

    @Before
    public void startEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }
}