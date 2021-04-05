package tasks;

import exceptions.MessageExceptions;
import exceptions.ThrowAppExceptions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utils.Constants;
import utils.LongitudesConversion;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class CalculateLongitude implements Task {

    String originUnitName;
    String targetUnitName;
    String valueToConvert;

    public CalculateLongitude(String originUnitName, String targetUnitName, String valueToConvert) {
        this.originUnitName = originUnitName;
        this.targetUnitName = targetUnitName;
        this.valueToConvert=valueToConvert;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String ConvertedValue = convertValue(Double.parseDouble(valueToConvert));
        actor.remember(Constants.CALCULATED_LONGITUDE,ConvertedValue);
    }

    public static CalculateLongitude calculateLongitude(String originUnitName, String targetUnitName, String valueToConvert){
        return new CalculateLongitude(originUnitName,targetUnitName,valueToConvert);
    }

    private double getUnitValue(String unitOrigin,String unitTarget) {

        try{
            switch (unitOrigin){
                case "PIES":
                   return LongitudesConversion.PIE.valueOf(unitTarget).getValue();

                case "METERS":
                    return  LongitudesConversion.METER.valueOf(unitTarget).getValue();

                case "KILOMETERS":
                    return  LongitudesConversion.KILOMETER.valueOf(unitTarget).getValue();
                default:
                    throw new ThrowAppExceptions(MessageExceptions.SELECT_CONVERSION_OPTIOM);
            }
        }catch (Exception ex){
             throw new ThrowAppExceptions(MessageExceptions.SELECT_CONVERSION,ex);
        }
    }



    private  String convertValue( double valueToConvert){

        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);

        double convertedValue;
        double targetValue = getUnitValue(originUnitName,targetUnitName);
        double originValue = 1;

        if(operation()){
            convertedValue= valueToConvert * targetValue / originValue;
        }else{
            convertedValue=  originValue * valueToConvert / targetValue;
        }
        return df.format(convertedValue);
    }

    private boolean operation(){
        double targetValue = getUnitValue(originUnitName,targetUnitName);
        double originValue = getUnitValue(targetUnitName,originUnitName);

        if(originValue < targetValue){
            return true;
        }else{
            return false;
        }


    }


}
