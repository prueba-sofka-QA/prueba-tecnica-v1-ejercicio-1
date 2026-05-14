package com.purchase.hooks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class AbrirNavegador  implements Task {
    private String url;


    public AbrirNavegador(String url) {
        this.url = url;
    }

x
    @Override
    public <T extends Actor> void performAs(T actor) {        
        actor.attemptsTo(
            Open.url(url)
        );
    }


    public static AbrirNavegador AbrirUrl(String url) {
        return Tasks.instrumented(AbrirNavegador.class, url);
    }
}
