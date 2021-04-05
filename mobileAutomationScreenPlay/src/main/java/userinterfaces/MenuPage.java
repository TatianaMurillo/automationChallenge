package userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class MenuPage {
    public static final Target MENU_TOGGLE=Target.the("Button to display menu").located(By.xpath("//android.widget.ImageButton[@content-desc='Abrir el cajon de navegacion']"));
    public static final Target MENU_OPTION=Target.the("Option to convert longitudes").locatedBy("//android.widget.TextView[@text='{0}']");


}
