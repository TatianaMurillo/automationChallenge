package tasks;

import Interactions.EnterValueToConvert;
import exceptions.MessageExceptions;
import exceptions.ThrowAppExceptions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.ConvertionPage;
import utils.Areas;


import java.util.Map;


public class ConvertAreas implements Task {

    Map<String,String> data;

    public ConvertAreas(Map<String,String> data) {
        this.data=data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ConvertionPage.DELETE),
                Click.on(ConvertionPage.UNITS.resolveAllFor(actor).get(0)));
        /*actor.attemptsTo(
                Scroll.to(ConvertionPage.UNIT_OPTION.of(getUnitValue(data.get("originUnitName")))));*/
        actor.attemptsTo(

                Click.on(ConvertionPage.UNIT_OPTION.of(getUnitValue(data.get("originUnitName")))));

        actor.attemptsTo(
                Click.on(ConvertionPage.UNITS.resolveAllFor(actor).get(1)));

        /* actor.attemptsTo(
                  Scroll.to(ConvertionPage.UNIT_OPTION.of(getUnitValue(data.get("targetUnitName")))));*/

        actor.attemptsTo(
                Click.on(ConvertionPage.UNIT_OPTION.of(getUnitValue(data.get("targetUnitName")))));

        actor.attemptsTo(
                EnterValueToConvert.enterValueToConvert(data.get("valueToConvert")));

        actor.attemptsTo(
                CalculateArea.calculateArea(data.get("originUnitName"),data.get("targetUnitName"),data.get("valueToConvert"))
        );

    }


    public static ConvertAreas convertAreas(Map<String,String> data){
        return Tasks.instrumented(ConvertAreas.class,data);
    }

    private String getUnitValue(String option) {

        try{
            switch (option){
                case "ACRE":
                    return Areas.ACRE.getFunctionalName();
                case "HECTARE":
                    return Areas.HECTARE.getFunctionalName();
                case "SQUARE_METER":
                    return Areas.SQUARE_METER.getFunctionalName();
                default:
                    throw new ThrowAppExceptions(MessageExceptions.SELECT_CONVERSION_OPTIOM);
            }
        }catch (Exception ex){
            throw new ThrowAppExceptions(MessageExceptions.SELECT_CONVERSION,ex);
        }
    }

}
