package com.purchase.hooks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class OpenBrowser  implements Task {
    private String url;


    public OpenBrowser(String url) {
        this.url = url;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {        
        actor.attemptsTo(
            Open.url(url)
        );
    }


    public static OpenBrowser AbrirUrl(String url) {
        return Tasks.instrumented(OpenBrowser.class, url);
    }
}
