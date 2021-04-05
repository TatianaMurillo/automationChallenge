package tasks;

import exceptions.MessageExceptions;
import exceptions.ThrowAppExceptions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utils.Constants;
import utils.VelocitiesConversion;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class CalculateVelocity implements Task {

    String originUnitName;
    String targetUnitName;
    String valueToConvert;

    public CalculateVelocity(String originUnitName, String targetUnitName, String valueToConvert) {
        this.originUnitName = originUnitName;
        this.targetUnitName = targetUnitName;
        this.valueToConvert=valueToConvert;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String ConvertedValue = convertValue(Double.parseDouble(valueToConvert));
        actor.remember(Constants.CALCULATED_VELOCITY,ConvertedValue);
    }

    public static CalculateVelocity calculateVelocity(String originUnitName, String targetUnitName, String valueToConvert){
        return new CalculateVelocity(originUnitName,targetUnitName,valueToConvert);
    }

    private double getUnitValue(String unitOrigin,String unitTarget) {

        try{
            switch (unitOrigin){
                case "MILIMETROXHORA":
                   return VelocitiesConversion.MILIMETROXHORA.valueOf(unitTarget).getValue();

                case "MILLAXMINUTO":
                    return  VelocitiesConversion.MILLAXMINUTO.valueOf(unitTarget).getValue();

                case "METROXMINUTO":
                    return  VelocitiesConversion.METROXMINUTO.valueOf(unitTarget).getValue();
                default:
                    throw new ThrowAppExceptions(MessageExceptions.SELECT_CONVERSION_OPTIOM);
            }
        }catch (Exception ex){
             throw new ThrowAppExceptions(MessageExceptions.SELECT_CONVERSION,ex);
        }
    }



    private  String convertValue( double valueToConvert){

        DecimalFormat df = new DecimalFormat("#.##########", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        df.setRoundingMode(RoundingMode.CEILING);

        double convertedValue;
        double targetValue = getUnitValue(originUnitName,targetUnitName);
        double originValue = 1;


        convertedValue= valueToConvert * targetValue / originValue;

        return df.format(convertedValue);
    }

}
