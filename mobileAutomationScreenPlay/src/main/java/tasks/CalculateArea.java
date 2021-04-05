package tasks;

import exceptions.MessageExceptions;
import exceptions.ThrowAppExceptions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utils.Constants;
import utils.AreaConversion;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class CalculateArea implements Task {

    String originUnitName;
    String targetUnitName;
    String valueToConvert;

    public CalculateArea(String originUnitName, String targetUnitName, String valueToConvert) {
        this.originUnitName = originUnitName;
        this.targetUnitName = targetUnitName;
        this.valueToConvert=valueToConvert;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String ConvertedValue = convertValue(Double.parseDouble(valueToConvert));
        actor.remember(Constants.CALCULATED_AREA,ConvertedValue);
    }

    public static CalculateArea calculateArea(String originUnitName, String targetUnitName, String valueToConvert){
        return new CalculateArea(originUnitName,targetUnitName,valueToConvert);
    }

    private double getUnitValue(String unitOrigin,String unitTarget) {

        try{
            switch (unitOrigin){
                case "ACRE":
                   return AreaConversion.ACRE.valueOf(unitTarget).getValue();

                case "HECTARE":
                    return  AreaConversion.HECTARE.valueOf(unitTarget).getValue();

                case "SQUARE_METER":
                    return  AreaConversion.SQUARE_METER.valueOf(unitTarget).getValue();
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
        df.setRoundingMode(RoundingMode.UNNECESSARY);

        double convertedValue;
        double targetValue = getUnitValue(originUnitName,targetUnitName);
        double originValue = 1;


        convertedValue= valueToConvert * targetValue / originValue;

        return df.format(convertedValue);
    }

}
