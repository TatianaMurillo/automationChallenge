package userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ConvertionPage {
    public static final Target UNITS=Target.the("List ti select units").located(By.id("com.ba.universalconverter:id/select_unit_spinner_arrow"));

    public static final Target KEYS=Target.the("keys to enter values").locatedBy("//android.widget.Button[@text='{0}']");

    public static final Target UNIT_OPTION=Target.the("Options from the list").locatedBy("//android.widget.TextView[@text='{0}']");


    public static final Target TARGET_VALUE=Target.the("textview with the target conversion").located(By.id("com.ba.universalconverter:id/target_value"));


}
