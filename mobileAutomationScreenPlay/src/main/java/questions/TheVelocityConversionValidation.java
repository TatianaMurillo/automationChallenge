package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.ConvertionPage;
import utils.Constants;


public class TheVelocityConversionValidation implements Question<Boolean> {


    public TheVelocityConversionValidation() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String calculatedLongitude= actor.recall(Constants.CALCULATED_VELOCITY);
        String value=  Text.of(ConvertionPage.TARGET_VALUE).viewedBy(actor).asString().replace(" ","");

        return calculatedLongitude.contains(value);

    }


    public static TheVelocityConversionValidation getResult(){
        return new TheVelocityConversionValidation();
    }


}
