package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.ConvertionPage;
import utils.Constants;


public class TheLongitudeConversionValidation implements Question<Boolean> {


    public TheLongitudeConversionValidation() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String calculatedLongitude= actor.recall(Constants.CALCULATED_LONGITUDE);
        String value=  Text.of(ConvertionPage.TARGET_VALUE).viewedBy(actor).asString().replace(" ","");

        return calculatedLongitude.contains(value);

    }


    public static TheLongitudeConversionValidation getResult(){
        return new TheLongitudeConversionValidation();
    }


}
