package Interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.ConvertionPage;


public class EnterValueToConvert implements Interaction {

    String value;

    public EnterValueToConvert(String value) {
        this.value=value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i=0; i<value.length();i++){
                actor.attemptsTo(
                        Click.on(ConvertionPage.KEYS.of(String.valueOf(value.charAt(i))))
                );
        }
    }

    public static EnterValueToConvert enterValueToConvert(String value){
        return Tasks.instrumented(EnterValueToConvert.class,value);
    }
}
