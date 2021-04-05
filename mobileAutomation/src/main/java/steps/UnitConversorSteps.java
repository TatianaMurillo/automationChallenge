package steps;


import io.appium.java_client.android.AndroidDriver;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

import java.util.Map;

public class UnitConversorSteps {

    MainPage mainPage;

    public  UnitConversorSteps(AndroidDriver driver) {
        mainPage = new MainPage(driver);
    }

    public static UnitConversorSteps init(AndroidDriver driver){
        return new UnitConversorSteps(driver);
    }



    public void convertUnit(Map<String,String> data){
        mainPage.selectOriginUnitList(data.get("OriginUnit"));
        mainPage.selectDestinyUnitList(data.get("DestinyUnit"));
        mainPage.enterValueToConvert(data.get("OriginValue"));
    }

    @Test
    public void getConvertedValue(){
        Assert.assertThat(mainPage.getConvertionValue(), CoreMatchers.is("522.7273"));
    }

}
