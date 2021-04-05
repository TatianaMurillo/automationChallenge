package Interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.MenuPage;

import java.util.Map;


public class GoToMenuOption implements Interaction {

    String option;

    public GoToMenuOption(String option) {
        this.option=option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MenuPage.MENU_TOGGLE),
                Click.on(MenuPage.MENU_OPTION.of(option))
        );

    }

    public static GoToMenuOption goToMenuOption(String option){
        return Tasks.instrumented(GoToMenuOption.class,option);
    }
}
