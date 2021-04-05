package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class MainPage {

    AndroidDriver driver;

    String idSelectUnit="com.ba.universalconverter:id/select_unit_spinner_arrow";
    String idTargetValue="com.ba.universalconverter:id/target_value";
    String xpathTargetValue="//android.widget.TextView[@resource-id='com.ba.universalconverter:id/target_value']";
    String xpathSelectUnitOption="//android.widget.TextView[@text='{0}']";
    String xpathForKeys = "//android.widget.Button[@text='{0}']";

    public MainPage(AndroidDriver driver) {
        this.driver=driver;
    }


    public void selectOriginUnitList(String originUnit) {
        List<WebElement> list = driver.findElements(By.id(idSelectUnit));
        list.get(0).click();

        driver.findElement(By.xpath(xpathSelectUnitOption.replace("{0}", originUnit))).click();

    }

    public void enterValueToConvert(String value){
        for (int i = 0; i<value.length();i++) {
            driver.findElement(By.xpath(xpathForKeys.replace("{0}",String.valueOf(value.charAt(i))))).click();
        }
    }
    public void selectDestinyUnitList(String destinyUnit){
        List<WebElement> list = driver.findElements(By.id(idSelectUnit));
        list.get(1).click();

        driver.findElement(By.xpath(xpathSelectUnitOption.replace("{0}",destinyUnit))).click();
    }

    public String getConvertionValue(){

        WebElement targetElementXPath =  driver.findElement(By.xpath(xpathTargetValue));
        WebElement targetElement =  driver.findElement(By.id(idTargetValue));
        return  targetElementXPath.getText();
    }

}
