package tasks;

import Interactions.EnterValueToConvert;
import exceptions.MessageExceptions;
import exceptions.ThrowAppExceptions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import userinterfaces.ConvertionPage;
import utils.Longitudes;


import java.util.Map;


public class ConvertLongitudes implements Task {

    Map<String,String> data;

    public ConvertLongitudes(Map<String,String> data) {
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
                CalculateLongitude.calculateLongitude(data.get("originUnitName"),data.get("targetUnitName"),data.get("valueToConvert"))
        );
    }


    public static ConvertLongitudes convertLongitudes(Map<String,String> data){
        return Tasks.instrumented(ConvertLongitudes.class,data);
    }

    private String getUnitValue(String option) {

        try{
            switch (option){
                case "PIES":
                    return Longitudes.PIES.getFunctionalName();
                case "METERS":
                    return Longitudes.METERS.getFunctionalName();
                case "KILOMETERS":
                    return Longitudes.KILOMETERS.getFunctionalName();
                default:
                    throw new ThrowAppExceptions(MessageExceptions.SELECT_CONVERSION_OPTIOM);
            }
        }catch (Exception ex){
            throw new ThrowAppExceptions(MessageExceptions.SELECT_CONVERSION,ex);
        }
    }

}
