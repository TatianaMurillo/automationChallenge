package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.ConvertionPage;


public class LongitudeConversion implements Question<String> {


    public LongitudeConversion() {
    }

    @Override
    public String answeredBy(Actor actor) {

        String value=  Text.of(ConvertionPage.TARGET_VALUE).viewedBy(actor).asString();
        return value;

    }


    public static LongitudeConversion getValue(){
        return new LongitudeConversion();
    }


}
